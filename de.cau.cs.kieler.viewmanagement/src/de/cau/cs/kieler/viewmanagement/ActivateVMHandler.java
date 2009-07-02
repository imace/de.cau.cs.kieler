/**
 * 
 */
package de.cau.cs.kieler.viewmanagement;

import java.util.Map;

import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.commands.AbstractHandler;
import org.eclipse.ui.commands.ExecutionException;

/**
 * @author nbe
 *
 */
public class ActivateVMHandler extends AbstractHandler implements IHandler {

	/**
	 * 
	 */
	public ActivateVMHandler() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.commands.IHandler#execute(java.util.Map)
	 */
	@Override
	public Object execute(Map parameterValuesByName) throws ExecutionException {
		// TODO Auto-generated method stub
		
		System.out.println("Now on");
		return null;
	}

}
