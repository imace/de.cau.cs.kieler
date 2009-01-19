  


/*
 * Created on Tue Aug 26 17:32:57 CEST 2008
 *
 * Generated by GEMS 
 */
 
package edu.unikiel.rtsys.gems.mealy.mealymachine;


import org.eclipse.gmt.gems.model.ModelObject;
import org.eclipse.gmt.gems.ModelRepository;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmt.gems.model.Container;
import org.eclipse.gmt.gems.model.ModelObject;
import org.eclipse.gmt.gems.model.event.ModelChangeEvent;

public class EMFSubtypeImpl extends org.eclipse.gmt.gems.SubtypeImpl {
	public class EMFInstanceUpdater extends InstanceUpdater{
		private de.cau.cs.kieler.gems.mealy.emf.mealymachine.SubtypeLink link_;
		
		public EMFInstanceUpdater(ModelObject base, ModelObject m) {
			super(base, m);
			link_ = de.cau.cs.kieler.gems.mealy.emf.mealymachine.impl.MealyMachineFactoryImpl.eINSTANCE.createSubtypeLink();
			link_.setBase(((EMFModelObject)base).getEMFObject());
			link_.setInstance(((EMFModelObject)m).getEMFObject());
			getModel().getLinks().add(link_);
		}
		
		public EMFInstanceUpdater(ModelObject base, ModelObject m, de.cau.cs.kieler.gems.mealy.emf.mealymachine.SubtypeLink link) {
			super(base, m);
			link_ = link;
		}
		

		@Override
		public void unRegister() {
			getModel().getLinks().remove(link_);
			super.unRegister();
		}
		
	}
    de.cau.cs.kieler.gems.mealy.emf.mealymachine.Subtype model_;

	public EMFSubtypeImpl(ModelObject obj, String name){
		super(obj,name);
		register();
	}
	
	public EMFSubtypeImpl(ModelObject obj, de.cau.cs.kieler.gems.mealy.emf.mealymachine.Subtype emfobj, String name){
		super(obj,name);
		model_ = emfobj;
		
	}
	
	public void createUpdater(ModelObject base, ModelObject cop){
		new EMFInstanceUpdater(base,cop);
	}
	
	public void createUpdater(ModelObject base, ModelObject cop, de.cau.cs.kieler.gems.mealy.emf.mealymachine.SubtypeLink link){
		new EMFInstanceUpdater(base,cop,link);
	}
	
	public void addInstance(ModelObject subt){
		addInstance(subt,true);
	}
	
	public void addInstance(ModelObject subt, boolean modifymodel){
		if(modifymodel)
			getModel().getInstances().add(((edu.unikiel.rtsys.gems.mealy.mealymachine.EMFModelObject)subt).getEMFObject());
		super.addInstance(subt);
	}
	
	public void removeInstance(ModelObject subt){
		getModel().getInstances().remove(((edu.unikiel.rtsys.gems.mealy.mealymachine.EMFModelObject)subt).getEMFObject());
		super.removeInstance(subt);
	}
	
	public void unRegister(){
		Root root = (Root)ModelRepository.getInstance().getInstanceRepository().getInstance(getBase().getModelInstanceID()).getRoot();
		if(root != null)
			root.getEMFObject().getSubtypes().remove(getModel());
	}
	
	public void register(){
		Root root = (Root)ModelRepository.getInstance().getInstanceRepository().getInstance(getBase().getModelInstanceID()).getRoot();
		if(root != null && !root.getEMFObject().getSubtypes().contains(getModel()))
			root.getEMFObject().getSubtypes().add(getModel());
	}
	
    public de.cau.cs.kieler.gems.mealy.emf.mealymachine.Subtype getModel(){
		if(model_ == null){
			model_ = de.cau.cs.kieler.gems.mealy.emf.mealymachine.impl.MealyMachineFactoryImpl.eINSTANCE.createSubtype();
			model_.setBase(((edu.unikiel.rtsys.gems.mealy.mealymachine.EMFModelObject)getBase()).getEMFObject());
			//model_.eAdapters().add(this);
			model_.setName(getName());
			register();
		}
		return model_;
	}
}