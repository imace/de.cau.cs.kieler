/**
 * 
 */
package de.cau.cs.kieler.viewmanagement;


import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;

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
     * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
     */
    public Object execute(ExecutionEvent event) throws ExecutionException {
        // TODO Auto-generated method stub
        System.out.println("Now on");
        return null;
    }

}
