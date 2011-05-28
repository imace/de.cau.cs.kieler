/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse Rich Client
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2011 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klots.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;

import lejos.nxt.remote.NXTCommand;
import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTCommException;
import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTInfo;
import lejos.pc.comm.NXTSamba;
import lejos.pc.tools.NXJFlashUI;


/**
 * Class to allow the updating and verification of the leJOS firmware. The firmware image files
 * can be located inside of jar archives, such as Eclipse plugins, as well as on the file system.
 * This adapted implementation is based on Andy Shaw original code.
 * 
 * @author ybe
 */
public class NXTFlashUpdate {

    private static final int MAX_FIRMWARE_PAGES = 368;
    private static final int TOTAL_PAGES = 1024;
    private static final int SETTINGS_PAGES = 1;
    private static final int DIRECTORY_PAGES = 2;
    private static final int MENU_ADDRESS_LOC = 0x40;
    private static final int ADDRESS_LOC_ADDITION = 4;
    private static final int MENU_LENGTH_LOC = MENU_ADDRESS_LOC + ADDRESS_LOC_ADDITION;
    private static final int FLASH_START_PAGE_LOC = MENU_LENGTH_LOC + ADDRESS_LOC_ADDITION;
    
    private NXJFlashUI ui;

    
    
    /**
     * @param ui 
     */
    public NXTFlashUpdate(final NXJFlashUI ui) {
        this.ui = ui;
    }

    
    
    /**
     * Format and store a 32 bit value into a memory image.
     * 
     * @param mem
     *            The image in which to store the value
     * @param offset
     *            The location in bytes in the image
     * @param val
     *            The value to be stored.
     */
    void storeWord(byte[] mem, int offset, final int val) {
        mem[offset++] = (byte) (val & 0xff);
        mem[offset++] = (byte) ((val >> 8) & 0xff);
        mem[offset++] = (byte) ((val >> 16) & 0xff);
        mem[offset++] = (byte) ((val >> 24) & 0xff);
    }

    
    
    /**
     * Create the memory image ready to be flashed to the device. Load the
     * firmware and menu images into memory ready for flashing.
     * 
     * @param vmPath Relative path to the leJOS VM firmware image in the KLOTS plugin jar file.
     * @param menuPath
     *               Relative path to the leJOS menu system firmware image in the KLOTS plugin jar file.
     * @param klotsPath
     *               Full path to the KLOTS plugin jar file.
     * 
     * @return Memory image ready to be flashed to the device.
     * 
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    public byte[] createFirmwareImage(final String vmPath, final String menuPath, final String klotsPath)
    throws IOException, FileNotFoundException {
        ui.message("Building firmware image.");
        byte[] memoryImage = new byte[MAX_FIRMWARE_PAGES * NXTSamba.PAGE_SIZE];
        ui.message("VM file:   KLOTS plugin/" + vmPath);
        ui.message("Menu file: KLOTS plugin/" + menuPath);
        int vmLen;
        int menuLen;
        int menuStart;
        // if the firmware images are located in the KLOTS plugin jar file.
        if (klotsPath.endsWith(".jar")) {
            vmLen = readBytesIntoArray(klotsPath, vmPath, memoryImage, 0);
            // Round up to page and use as base for the menu location
            menuStart = ((vmLen + NXTSamba.PAGE_SIZE - 1) / NXTSamba.PAGE_SIZE) * NXTSamba.PAGE_SIZE;
            // Read the menu. Note we may read less than the full size of the menu.
            // If so this will be caught by the overall size check below.
            menuLen = readBytesIntoArray(klotsPath, menuPath, memoryImage, menuStart);
        // if this is a eclipse developer instance, so the firmware images are located in the file system
        } else {
            FileInputStream vm = new FileInputStream(
                    klotsPath + System.getProperty("file.separator") + vmPath);
            FileInputStream menu = new FileInputStream(
                    klotsPath + System.getProperty("file.separator") + menuPath);
            vmLen = vm.read(memoryImage, 0, memoryImage.length);
            // Round up to page and use as base for the menu location
            menuStart = ((vmLen + NXTSamba.PAGE_SIZE - 1) / NXTSamba.PAGE_SIZE) * NXTSamba.PAGE_SIZE;
            // Read the menu. Note we may read less than the full size of the menu.
            // If so this will be caught by the overall size check below.
            menuLen = menu.read(memoryImage, menuStart, memoryImage.length - menuStart);
            vm.close();
            menu.close();
        }
        
        // We store the length and location of the Menu in special locations
        // that are known to the firmware.
        storeWord(memoryImage, MENU_LENGTH_LOC, menuLen);
        storeWord(memoryImage, MENU_ADDRESS_LOC, menuStart + NXTSamba.FLASH_BASE);
        storeWord(memoryImage, FLASH_START_PAGE_LOC, MAX_FIRMWARE_PAGES);
        // Check overall size allow for size/length markers in last block.
        if (menuStart + menuLen >= memoryImage.length) {
            throw new IOException("Combined size of VM and Menu > " + memoryImage.length);
        }
        ui.message("VM size: " + vmLen + " bytes.");
        ui.message("Menu size: " + menuLen + " bytes.");
        ui.message("Total image size " + (menuStart + menuLen) + "/" + memoryImage.length + " bytes.");
        return memoryImage;
    }

    
    
    /**
     * Create a memory image for the leJOS file system. We create an in memory
     * image for the settings, and directory pages. We then fill the remainder
     * of the space with a test pattern to help detect any flash memory problems
     * 
     * @return byte array containing the file system data
     */
    public byte[] createFilesystemImage() {
        ui.message("Building filesystem image.");
        byte[] fs = new byte[NXTSamba.PAGE_SIZE * (TOTAL_PAGES - MAX_FIRMWARE_PAGES)];
        // First few pages are settings are directory, these must all be
        // cleared to zero. After that we fill with a test pattern, to help
        // spot any flash problems
        int addr = (SETTINGS_PAGES + DIRECTORY_PAGES) * NXTSamba.PAGE_SIZE;
        while (addr <= (fs.length - 32)) {
            storeWord(fs, addr, addr);
            addr += 4;
            storeWord(fs, addr, ~addr);
            addr += 4;
            storeWord(fs, addr, 0xf0f0f0f0);
            addr += 4;
            storeWord(fs, addr, 0x0f0f0f0f);
            addr += 4;
            storeWord(fs, addr, 0xaaaaaaaa);
            addr += 4;
            storeWord(fs, addr, 0x55555555);
            addr += 4;
            storeWord(fs, addr, 0x00000000);
            addr += 4;
            storeWord(fs, addr, 0xffffffff);
            addr += 4;
        }
        return fs;
    }

    
    
    /**
     * Locate and open an nxt device in SAM-BA mode. If none are present wait up
     * to timeout ms checking to see if one has become available.
     * 
     * @param timeout 
     * 
     * @return NXTSamba 
     * 
     * @throws NXTCommException 
     * @throws IOException 
     */
    public NXTSamba openSambaDevice(final int timeout) throws NXTCommException, IOException {
        NXTSamba samba = new NXTSamba();

        ui.message("Locating device in firmware update mode.");
        // Look for devices in SAM-BA mode
        NXTInfo[] nxts = samba.search();
        if (nxts.length == 0) {
            for (int i = 0; i < timeout / 1000; i++) {
                nxts = samba.search();
                if (nxts.length > 0) {
                    break;
                }
                try {
                    ui.progress("Searching", (i * 100) / (timeout / 1000));
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        }
        if (nxts.length > 1) {
            throw new NXTCommException("Too many devices in firmware update mode.");
        }
        if (nxts.length == 0) {
            return null;
        }
        // Must be just the one. Try and open it!
        if (!samba.open(nxts[0])) {
            throw new NXTCommException("Failed to open device in SAM-BA mode.");
        }
        ui.message("Opened device in firmware update mode.");
        return samba;
    }

    
    
    /**
     * Attempt to restart the nxt in SAM-BA mode.
     * 
     * @param nxt The device to reset
     * 
     * @throws NXTCommException
     * @throws IOException
     */
    public void resetDevice(final NXTInfo nxt) throws NXTCommException, IOException {
        ui.message("Attempting to reboot the device.");
        NXTComm nxtComm = NXTCommFactory.createNXTComm(nxt.protocol);
        NXTCommand cmd = NXTCommand.getSingleton();
        if (!nxtComm.open(nxt, NXTComm.LCP)) {
            throw new NXTCommException("Failed to open device in command mode.");
        }
        cmd.setNXTComm(nxtComm);
        // Force into firmware update mode.
        cmd.boot();
        cmd.close();
    }
    
    
    
    
    /**
     * @param page 
     * @return 
     */
    private static int getPageAddr(final int page) {
        return NXTSamba.FLASH_BASE + page * NXTSamba.PAGE_SIZE; 
    }

    
    
    /**
     * Verify that the contents of the nxt flash memory match the supplied
     * image.
     * 
     * @param nxt
     *            device to verify
     * @param first
     *            starting address
     * @param memoryImage
     *            memory address to compare with
     * 
     * @return number of mismatched bytes found
     * 
     * @throws IOException
     */
    public int verifyPages(final NXTSamba nxt, final int first, byte[] memoryImage) throws IOException {
        int failCnt = 0;
        int len = memoryImage.length;
        InputStream is = nxt.createInputStream(getPageAddr(first), len);
        try {
            int p = -1;
            for (int i = 0; i < len; i++) {
                int np = i * 100 / len;
                if (np > p) {
                    p = np;
                    ui.progress("Verifying", np);
                }
                
                int b = is.read();
                if (b < 0) {
                    throw new IOException("EOF came too soon");
                }
                
                if ((byte) b != memoryImage[i]) {
                    ui.message(String.format(
                        "Verify failed at address 0x%08X: expected 0x%02X, found 0x%02X\n",
                        i,  memoryImage[i] & 0xff,  b));
                    failCnt++;
                }
            }
        } finally {
            is.close();
        }
        ui.progress("", 0);
        if (failCnt == 0) {
            ui.message("Verified " + memoryImage.length + " bytes ok.");
        } else {
            ui.message("Failed to verify " + failCnt + " of " + memoryImage.length + " bytes.");
        }
        return failCnt;
    }

    
    
    
    /**
     * @param nxt 
     * @param first 
     * @param memoryImage 
     * 
     * @throws IOException 
     */
    public void writePages(final NXTSamba nxt, final int first, byte[] memoryImage) throws IOException {
        int pages = memoryImage.length / NXTSamba.PAGE_SIZE;
        int p = -1;
        for (int page = 0; page < pages; page++) {
            int np = page * 100 / pages;
            if (np > p) {
                p = np;
                ui.progress("Writing", np);
            }
            nxt.writePage(first + page, memoryImage, page   * NXTSamba.PAGE_SIZE);
        }
        
        //workaround the problem, that verification and rebooting fails directly after write
        nxt.readWord(getPageAddr(first));

        ui.progress("", 0);
    }

    
    
    /**
     * Update the NXT with the new memory image.
     * 
     * @param nxt
     *            Device to update, must be open in SAM-BA mode.
     * @param memoryImage
     *            New image for the device
     * 
     * @throws IOException 
     */
    public void writeFirmware(final NXTSamba nxt, byte[] memoryImage) throws IOException {
        ui.message("Unlocking pages.");
        nxt.unlockAllPages();
        ui.message("Writing firmware image.");
        writePages(nxt, 0, memoryImage);
    }

    
    
    /**
     * Format the nxt file system.
     * 
     * @param nxt
     *            Device to format
     * @param fs
     *            File system image to use
     * @throws IOException
     */
    public void writeFilesystem(final NXTSamba nxt, byte[] fs) throws IOException {
        ui.message("Unlocking pages.");
        nxt.unlockAllPages();
        ui.message("Writing filesystem image.");
        writePages(nxt, MAX_FIRMWARE_PAGES, fs);
    }

    
    
    /**
     * Verify the firmware downloaded to the device.
     * 
     * @param nxt
     *            device to verify
     * @param image
     *            firmware image to compare against
     * @return the number of mismatched bytes.
     * @throws IOException
     */
    public int verifyFirmware(final NXTSamba nxt, byte[] image) throws IOException {
        ui.message("Verifying firmware.");
        return verifyPages(nxt, 0, image);
    }

    
    
    /**
     * Verify the file system downloaded to the device.
     * 
     * @param nxt
     *            device to verify
     * @param image
     *            file system image to compare against
     * @return the number of mismatched bytes.
     * @throws IOException
     */
    public int verifyFilesystem(final NXTSamba nxt, byte[] fs) throws IOException {
        ui.message("Verifying filesystem.");
        return verifyPages(nxt, MAX_FIRMWARE_PAGES, fs);
    }

    
    
    /**
     * @param nxt 
     * @throws IOException 
     */
    public void rebootDevice(final NXTSamba nxt) throws IOException {
        ui.message("Restarting the device.");
        nxt.reboot();
        nxt.close();
    }

    
    
    /**
     * Update the NXT with the new memory image.
     * 
     * @param nxt
     *            Device to update, must be open in SAM-BA mode.
     * @param memoryImage
     *            New firmware image for the device
     * @param fs
     *            File system image.
     * @param verify
     *            Should we verify the updates?
     *            
     * @throws IOException 
     */
    public void updateDevice(final NXTSamba nxt, byte[] memoryImage, byte[] fs, final boolean verify)
    throws IOException {
        updateDevice(nxt, memoryImage, fs, verify, verify, true);
    }

    
    
    /**
     * Update the NXT with the new memory image.
     * 
     * @param nxt
     *            Device to update, must be open in SAM-BA mode.
     * @param memoryImage
     *            New firmware image for the device
     * @param fs
     *            File system image.
     * @param verifyFirm
     *            Should we verify the firmware updates?
     * @param verifyFS
     *            Should we verify the file system updates?
     * @param reboot
     *            Reboot after update.
     *            
     * @throws IOException 
     */
    public void updateDevice(final NXTSamba nxt, byte[] memoryImage, byte[] fs,
                             final boolean verifyFirm, final boolean verifyFS, final boolean reboot)
    throws IOException {
        if (memoryImage != null) {
            writeFirmware(nxt, memoryImage);
            if (verifyFirm) {
                verifyFirmware(nxt, memoryImage);
            }
        }
        if (fs != null) {
            writeFilesystem(nxt, fs);
            if (verifyFS) {
                verifyFilesystem(nxt, fs);
            }
        }
        if (reboot) {
            rebootDevice(nxt);
        }
    }
    
    
    
    /**
     * @param pathToJar 
     * @param relativeFilePathInJar 
     * @param memoryImage 
     * @return int 
     * @throws IOException 
     */
    private int readBytesIntoArray(final String pathToJar, final String relativeFilePathInJar,
                                   byte[] memoryImage, final int offset) throws IOException {
        // open jar stream
        FileInputStream fin = null;
        JarInputStream jin = null;
        fin = new FileInputStream(pathToJar);
        jin = new JarInputStream(fin);
        ZipEntry entry;
        // search for the given entry in jar and position the stream on start of that entry
        while ((entry = jin.getNextEntry()) != null) {
            if (entry.getName().equals(relativeFilePathInJar)) {
                break;
            }
        }
        // read the entry data into the byte array until the whole entry has been read
        int imageLen = 0;
        int len = 0;
        while (len != -1) {
            imageLen += len;
            len = jin.read(memoryImage, offset + imageLen, memoryImage.length - offset - imageLen);
        }
        // close entry and streams
        jin.closeEntry();
        jin.close();
        fin.close();
        // return the number of total bytes read
        return imageLen;
    }
    
}
