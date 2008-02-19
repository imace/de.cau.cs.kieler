/*
 * 
 * ============================================================================
 * The Apache Software License, Version 1.1
 * ============================================================================
 * 
 * Copyright (C) 1999-2003 The Apache Software Foundation. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modifica-
 * tion, are permitted provided that the following conditions are met:
 *  1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *  3. The end-user documentation included with the redistribution, if any,
 * must include the following acknowledgment: "This product includes software
 * developed by the Apache Software Foundation (http://www.apache.org/)."
 * Alternately, this acknowledgment may appear in the software itself, if and
 * wherever such third-party acknowledgments normally appear.
 *  4. The names "Batik" and "Apache Software Foundation" must not be used to
 * endorse or promote products derived from this software without prior written
 * permission. For written permission, please contact apache@apache.org.
 *  5. Products derived from this software may not be called "Apache", nor may
 * "Apache" appear in their name, without prior written permission of the
 * Apache Software Foundation.
 * 
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * APACHE SOFTWARE FOUNDATION OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLU-
 * DING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS
 * OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * This software consists of voluntary contributions made by many individuals
 * on behalf of the Apache Software Foundation. For more information on the
 * Apache Software Foundation, please see <http://www.apache.org/> .
 *  
 */

package com.dlsc.batik.viewer;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;
import javax.swing.JComponent;
import javax.swing.JWindow;
import org.apache.batik.bridge.BridgeContext;
import org.apache.batik.bridge.DocumentLoader;
import org.apache.batik.bridge.GVTBuilder;
import org.apache.batik.bridge.UserAgent;
import org.apache.batik.bridge.UserAgentAdapter;
import org.apache.batik.bridge.ViewBox;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.gvt.renderer.StaticRenderer;
import org.eclipse.core.runtime.Platform;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

public class SlideShow extends JComponent {

	StaticRenderer renderer;

	UserAgent userAgent;

	DocumentLoader loader;

	BridgeContext ctx;

	BufferedImage image;

	BufferedImage display;

	File[] files;

	static int duration = 3000;

	static int frameDelay = duration + 7000;

	boolean done = false;

	public SlideShow(File[] files, Dimension size) {
		setBackground(Color.black);
		this.files = files;
		renderer = new StaticRenderer();
		userAgent = new UserAgentAdapter();
		loader = new DocumentLoader(userAgent);
		ctx = new BridgeContext(userAgent, loader);

		if (size == null) {
			size = Toolkit.getDefaultToolkit().getScreenSize();
		}

		setPreferredSize(size);
		setDoubleBuffered(false);

		final RenderThread t = new RenderThread();
		final JWindow w = new JWindow();

		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 2) {
					t.stopThread();
					w.dispose();
				} else if (me.getClickCount() == 1) {
					if (done) {
						w.dispose();
					} else {
						togglePause();
					}
				}
			}
		});

		size.width += 2;
		size.height += 2;
		display = new BufferedImage(size.width, size.height,
				BufferedImage.TYPE_INT_BGR);

		t.start();

		w.setBackground(Color.black);
		w.getContentPane().setBackground(Color.black);
		w.getContentPane().add(this);
		w.pack();

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		w.setLocation((dim.width - w.getWidth()) / 2, (dim.height - w
				.getHeight()) / 2);

		w.setVisible(true);
	}

	class RenderThread extends Thread {
		private boolean stopThread = false;

		public void stopThread() {
			stopThread = true;
		}

		public void run() {
			renderer.setDoubleBuffered(true);
			for (int i = 0; i < files.length; i++) {
				if (stopThread) {
					done = true;
					break;
				}

				GraphicsNode gvtRoot = null;
				GVTBuilder builder = new GVTBuilder();

				try {
					Document svgDoc = loader.loadDocument(files[i].toURL()
							.toString());
					gvtRoot = builder.build(ctx, svgDoc);
					renderer.setTree(gvtRoot);

					Element elt = ((SVGDocument) svgDoc).getRootElement();
					renderer.setTransform(ViewBox.getViewTransform(null, elt,
							display.getWidth(), display.getHeight()));

					renderer.updateOffScreen(display.getWidth(), display
							.getHeight());

					Rectangle r = new Rectangle(0, 0, display.getWidth(),
							display.getHeight());
					renderer.repaint(r);
					image = renderer.getOffScreen();
					setTransition(image);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (!stopThread && transitionThread != null) {
				try {
					transitionThread.join();
				} catch (InterruptedException ie) {
				}
				done = true;
				setCursor(new Cursor(Cursor.WAIT_CURSOR));
			}
		}
	}

	Thread transitionThread = null;

	public void setTransition(BufferedImage newImg) {
		synchronized (this) {
			while (transitionThread != null) {
				try {
					wait();
				} catch (InterruptedException ie) {
				}
			}
			transitionThread = new TransitionThread(newImg);
			transitionThread.start();
		}
	}

	long startLastTransition = 0;

	boolean paused = false;

	public void togglePause() {
		synchronized (this) {
			paused = !paused;
			Cursor c;
			if (paused) {
				c = new Cursor(Cursor.WAIT_CURSOR);
			} else {
				c = new Cursor(Cursor.DEFAULT_CURSOR);
				if (transitionThread != null) {
					synchronized (transitionThread) {
						transitionThread.notifyAll();
					}
				}
			}
			setCursor(c);
		}
	}

	class TransitionThread extends Thread {
		BufferedImage src;

		int blockw = 75;

		int blockh = 75;

		public TransitionThread(BufferedImage bi) {
			src = bi;
		}

		public void run() {
			int xblocks = (display.getWidth() + blockw - 1) / blockw;
			int yblocks = (display.getHeight() + blockh - 1) / blockh;
			int nblocks = xblocks * yblocks;

			int tblock = duration / nblocks;

			Point[] rects = new Point[nblocks];
			for (int y = 0; y < yblocks; y++)
				for (int x = 0; x < xblocks; x++)
					rects[y * xblocks + x] = new Point(x, y);

			Graphics2D g2d = display.createGraphics();
			g2d.setColor(new Color(0, 0, 0));

			long currTrans = System.currentTimeMillis();
			while ((currTrans - startLastTransition) < frameDelay) {
				try {
					long stime = frameDelay - (currTrans - startLastTransition);
					if (stime > 500) {
						System.gc();
						currTrans = System.currentTimeMillis();
						stime = frameDelay - (currTrans - startLastTransition);
					}
					if (stime > 0)
						sleep(stime);
				} catch (InterruptedException ie) {
				}
				currTrans = System.currentTimeMillis();
			}

			synchronized (this) {
				while (paused) {
					try {
						wait();
					} catch (InterruptedException ie) {
					}
				}
			}

			long last = startLastTransition = System.currentTimeMillis();

			for (int i = 0; i < rects.length; i++) {
				int idx = (int) (Math.random() * (rects.length - i));
				Point pt = rects[idx];
				for (int j = idx + 1; j < rects.length - i; j++)
					rects[j - 1] = rects[j];
				int x = pt.x * blockw, y = pt.y * blockh;
				int w = blockw, h = blockh;
				if (x + w > src.getWidth())
					w = src.getWidth() - x;
				if (y + h > src.getHeight())
					h = src.getHeight() - y;

				synchronized (display) {
					g2d.fillRect(x, y, w, h);
					BufferedImage sub;

					sub = src.getSubimage(x, y, w, h);
					g2d.drawImage(sub, null, x, y);
				}

				repaint(x, y, w, h);
				long current = System.currentTimeMillis();
				try {
					long dt = current - last;
					if (dt < tblock)
						sleep(tblock - dt);
				} catch (InterruptedException ie) {
				}
				last = current;
			}

			synchronized (SlideShow.this) {
				transitionThread = null;
				SlideShow.this.notifyAll();
			}
		}
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if (display == null)
			return;
		g2d.drawImage(display, null, 0, 0);
	}

	public static void readFileList(String file, Vector fileVec) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException fnfe) {
			trace("Unable to open file-list: " + file); //$NON-NLS-1$
			return;
		}
		try {
			URL flURL = new File(file).toURL();
			String line;
			while ((line = br.readLine()) != null) {
				String str = line;
				int idx = str.indexOf('#');
				if (idx != -1)
					str = str.substring(0, idx);
				str.trim();
				if (str.length() == 0)
					continue;
				try {
					URL imgURL = new URL(flURL, str);
					fileVec.add(imgURL.getFile());
				} catch (MalformedURLException mue) {
					trace("Can't make sense of line:\r\n  " + line); //$NON-NLS-1$
				}
			}
		} catch (IOException ioe) {
			trace("Error while reading file-list: " + file); //$NON-NLS-1$
		}
	}

	public static void main(String[] args) {

		Vector fileVec = new Vector();

		Dimension d = null;

		if (args.length == 0) {
			showUsage();
			return;
		}

		for (int i = 0; i < args.length; i++) {
			if ((args[i].equals("-h")) || (args[i].equals("-help")) //$NON-NLS-1$ //$NON-NLS-2$
					|| (args[i].equals("--help"))) { //$NON-NLS-1$
				showUsage();
				return;
			} else if (args[i].equals("--")) { //$NON-NLS-1$
				i++;
				while (i < args.length) {
					fileVec.add(args[i++]);
				}
				break;
			} else if ((args[i].equals("-fl")) //$NON-NLS-1$
					|| (args[i].equals("--file-list"))) { //$NON-NLS-1$
				if (i + 1 == args.length) {
					trace("Must provide name of file list file after " //$NON-NLS-1$
							+ args[i]);
					break;
				}
				readFileList(args[i + 1], fileVec);
				i++;
			} else if ((args[i].equals("-ft")) //$NON-NLS-1$
					|| (args[i].equals("--frame-time"))) { //$NON-NLS-1$
				if (i + 1 == args.length) {
					trace("Must provide time in millis after " + args[i]); //$NON-NLS-1$
					break;
				}
				try {
					frameDelay = Integer.decode(args[i + 1]).intValue();
					i++;
				} catch (NumberFormatException nfe) {
					trace("Can't parse frame time: " + args[i + 1]); //$NON-NLS-1$
				}
			} else if ((args[i].equals("-tt")) //$NON-NLS-1$
					|| (args[i].equals("--transition-time"))) { //$NON-NLS-1$
				if (i + 1 == args.length) {
					trace("Must provide time in millis after " + args[i]); //$NON-NLS-1$
					break;
				}
				try {
					duration = Integer.decode(args[i + 1]).intValue();
					i++;
				} catch (NumberFormatException nfe) {
					trace("Can't parse transition time: " + args[i + 1]); //$NON-NLS-1$
				}
			} else if ((args[i].equals("-ws")) //$NON-NLS-1$
					|| (args[i].equals("--window-size"))) { //$NON-NLS-1$

				if (i + 1 == args.length) {
					trace("Must provide window size [w,h] after " + args[i]); //$NON-NLS-1$
					break;
				}
				try {
					int idx = args[i + 1].indexOf(',');
					int w, h;
					if (idx == -1)
						w = h = Integer.decode(args[i + 1]).intValue();
					else {
						String wStr = args[i + 1].substring(0, idx);
						String hStr = args[i + 1].substring(idx + 1);
						w = Integer.decode(wStr).intValue();
						h = Integer.decode(hStr).intValue();
					}
					d = new Dimension(w, h);
					i++;
				} catch (NumberFormatException nfe) {
					trace("Can't parse window size: " + args[i + 1]); //$NON-NLS-1$
				}
			} else
				fileVec.add(args[i]);
		}

		File[] files = new File[fileVec.size()];

		for (int i = 0; i < fileVec.size(); i++) {
			try {
				files[i] = new File((String) fileVec.get(i));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		new SlideShow(files, d);
	}

	public static void showUsage() {
		trace("Options:\n" //$NON-NLS-1$
				+ "                                 -- : Remaining args are file names\n" //$NON-NLS-1$
				+ "                         -fl <file>\n" //$NON-NLS-1$
				+ "                 --file-list <file> : file contains list of images to\n" //$NON-NLS-1$
				+ "                                      show one per line\n" //$NON-NLS-1$
				+ "             -ws <width>[,<height>]\n" //$NON-NLS-1$
				+ "    -window-size <width>[,<height>] : Set the size of slideshow window\n" //$NON-NLS-1$
				+ "                                      defaults to full screen\n" //$NON-NLS-1$
				+ "                          -ft <int>\n" //$NON-NLS-1$
				+ "                 --frame-time <int> : Amount of time in millisecs to\n" //$NON-NLS-1$
				+ "                                      show each frame.\n" //$NON-NLS-1$
				+ "                                      Includes transition time.\n" //$NON-NLS-1$
				+ "                          -tt <int>\n" //$NON-NLS-1$
				+ "            --transition-time <int> : Amount of time in millisecs to\n" //$NON-NLS-1$
				+ "                                      transition between frames.\n" //$NON-NLS-1$
				+ "                             <file> : SVG file to display"); //$NON-NLS-1$
	}

	private static void trace(String s) {
		String option = Platform.getDebugOption("com.dlsc.batik.ui/debug/slideshow");//$NON-NLS-1$
		if (option != null && option.equals("true")) { //$NON-NLS-1$
			System.out.println(s);
		}
	}
}