/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.informatik.aiw.generated.epc.validation;

import edu.unikiel.informatik.aiw.generated.epc.Function;
import edu.unikiel.informatik.aiw.generated.epc.LogicalOperator;

/**
 * A sample validator interface for {@link edu.unikiel.informatik.aiw.generated.epc.OperatorToFunctionConnection}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface OperatorToFunctionConnectionValidator {
	boolean validate();

	boolean validateFunction(Function value);
	boolean validateOperator(LogicalOperator value);
}
