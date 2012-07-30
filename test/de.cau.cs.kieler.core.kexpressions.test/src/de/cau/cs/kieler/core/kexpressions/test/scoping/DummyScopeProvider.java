/*
 * generated by Xtext
 */
package de.cau.cs.kieler.core.kexpressions.test.scoping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import de.cau.cs.kieler.core.kexpressions.Signal;
import de.cau.cs.kieler.core.kexpressions.Variable;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class DummyScopeProvider extends AbstractDeclarativeScopeProvider {
    public static EObject parent;

    @Override
    public IScope getScope(EObject context, EReference reference) {
        if (parent != null){
                IScope scope = createHierarchicScope(parent);
                return scope;
        }
        // this is likely to return the NULLSCOPE
        return super.getScope(context, reference);
    }

    @SuppressWarnings("unchecked")
    private Iterable<IEObjectDescription> getElements(EObject parent){
        ArrayList<IEObjectDescription> elements = new ArrayList<IEObjectDescription>();
                if (parent != null && parent instanceof DummyScope) {
                        List<Signal> signals = ((DummyScope) parent).getSignals();
                        for (Signal signal : signals) {
                                elements.add(new EObjectDescription(QualifiedName.create(
                                        signal.getName()), signal, Collections.EMPTY_MAP));
                        }
                        List<Variable> variables = ((DummyScope) parent).getVariables();
                        for (Variable variable : variables) {
                                elements.add(new EObjectDescription(QualifiedName.create(
                                        variable.getName()), variable, Collections.EMPTY_MAP));
                        }
                }
                return elements;
    }
    
    private IScope createHierarchicScope(EObject child){
        if(child.eContainer()!=null){
                IScope parentScope = createHierarchicScope(child.eContainer());
                SimpleScope scope = new SimpleScope(parentScope, this.getElements(child));
                return scope;
        }
        else{
                return new SimpleScope(this.getElements(child));
        }
    }
}
