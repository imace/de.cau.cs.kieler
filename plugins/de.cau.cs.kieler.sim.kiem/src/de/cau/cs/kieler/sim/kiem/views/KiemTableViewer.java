/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright ${year} by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 ******************************************************************************/

package de.cau.cs.kieler.sim.kiem.views;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

public class KiemTableViewer extends TreeViewer{

	public KiemTableViewer(Table table) {
		super(table);
	}

	public KiemTableViewer(Composite parent, int style) {
		super(parent, style);
	}

	public KiemTableViewer(Composite parent) {
		super(parent);
	}
}
