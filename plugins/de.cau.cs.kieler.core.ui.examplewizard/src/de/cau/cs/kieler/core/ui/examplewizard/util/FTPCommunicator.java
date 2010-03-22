/**
 * 
 */
package de.cau.cs.kieler.core.ui.examplewizard.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import sun.net.TelnetOutputStream;
import sun.net.ftp.FtpClient;

/**
 * Class to provide FTP communication.
 * 
 * @author omi
 * 
 */
public class FTPCommunicator extends FtpClient {

	/** Singleton instance of this class */
	public static final FTPCommunicator INSTANCE = new FTPCommunicator();

	/**
	 * Constructor.
	 */
	FTPCommunicator() {
		super();
	}

	/**
	 * Sending a file via FTP to a host.
	 * 
	 * @param host
	 *            target host.
	 * @param user
	 *            user name
	 * @param pass
	 *            password
	 * @param path
	 *            target folder
	 * @param src
	 *            file to send
	 * @param dest
	 *            destination file
	 */
	public void sendFile(String host, String user, String pass, String path,
			File src, String dest) {
		try {
			byte[] cache = new byte[1024], temp;
			int b;
			int byteCount = 0;

			// connect to server and register
			openServer(host);
			login(user, pass);

			// read file and write to byte array
			FileInputStream fis = new FileInputStream(src);
			b = fis.read();
			while (b != -1) {
				if (byteCount >= cache.length) {
					temp = new byte[cache.length + 1024];
					for (int i = 0; i < cache.length; i++)
						temp[i] = cache[i];
					cache = temp;
				}
				cache[byteCount] = (byte) b;
				byteCount++;
				b = fis.read();
			}
			fis.close();
			
			// shorten cache by 0 values.
			int end = 0;
			for(int i = 0; i < cache.length; i++) {
				if(cache[i] == 0) {
					end = i;
				}
			}
			byte[] send = new byte[end];
			for (int i = 0; i < cache.length; i++)
				send[i] = cache[i];
			
			// send file
			binary();
			// choose path
			cd(path);
			TelnetOutputStream os = put(dest);
			os.write(send);

			os.close();
			closeServer();
		} catch (IOException e) {
			e.printStackTrace();
			// TODO
		}
	}

	/**
	 * Deleting a file on the host via FTP.
	 * 
	 * @param host
	 *            host containing the file
	 * @param login
	 *            user name
	 * @param pass
	 *            password
	 * @param path
	 *            the files path
	 * @param file
	 *            the file to remove
	 */
	public void removeFile(String host, String login, String pass, String path,
			String file) {
		try {
			openServer(host);
			login(login, pass);
			cd(path);
			this.issueCommand("DELE " + file);
			closeServer();
		} catch (IOException e) {
			e.printStackTrace();
			// TODO
		}
	}
}
