

/*
 * Created on Tue Aug 26 17:32:57 CEST 2008
 *
 * Generated by GEMS 
 */
 
package edu.unikiel.rtsys.gems.mealy.mealymachine;

import org.eclipse.gmt.gems.ElementGroup;
import org.eclipse.gmt.gems.ElementGroupImpl;
import org.eclipse.gmt.gems.ConstraintsChecker;
import org.eclipse.gmt.gems.GenericElementFactory;
import org.eclipse.gmt.gems.GraphicsProvider;
import org.eclipse.gmt.gems.LabelProvider;
import org.eclipse.gmt.gems.ModelElementFactory;
import org.eclipse.gmt.gems.ModelProvider;
import org.eclipse.gmt.gems.ModelRepository;
import org.eclipse.gmt.gems.PaletteProvider;
import org.eclipse.gmt.gems.model.Atom;
import org.eclipse.gmt.gems.model.Model;
import org.eclipse.emf.ecore.EPackage;


/**
 * 
 */
 
public class MealyMachineProvider implements ModelProvider, org.eclipse.gmt.gems.model.EMFModelProvider{
    public static final String MODEL_ID = "http://www.informatik.uni-kiel.de/rtsys/gems/mealy";
    private GraphicsProviderImpl graphicsProvider_ = new GraphicsProviderImpl();
    private LabelProviderImpl labelProvider_ = new LabelProviderImpl();
    private GenericElementFactory factory_ = new GenericElementFactory();
    private MealyMachinePaletteProvider paletteProvider_ = new MealyMachinePaletteProvider();
    private MealyMachineConstraintsChecker checker_ = new MealyMachineConstraintsChecker();
    private static MealyMachineProvider instance_;
    
    
    public static MealyMachineProvider getInstance(){
    	if(instance_ == null){
    		instance_ = new MealyMachineProvider();
        	ModelRepository.getInstance().registerModelProvider(instance_);
    	}
    	return instance_;
    }
    
	private class RootModel extends Model{
		
		public Atom[] getChildAtoms() {
			
			Atom[] atoms = {
				
			};
			return atoms;
		}
		public org.eclipse.gmt.gems.model.Model[] getChildModels() {
			
			Model[] models = {
			     
				   new MealyMachine(),
				   new State()};
			return models;
		}
        public String getModelID() {
            return MODEL_ID;
        }
}
	

	/* (non-Javadoc)
	 * @see org.eclipse.gmt.gems.ModelProvider#getRootModel()
	 */
	public org.eclipse.gmt.gems.model.Model getRootModel() {
		
		return new RootModel();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmt.gems.ModelProvider#getGraphicsProvider()
	 */
	public GraphicsProvider getGraphicsProvider() {
		
		return graphicsProvider_;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmt.gems.ModelProvider#getLabelProvider()
	 */
	public LabelProvider getLabelProvider() {
		
		return labelProvider_;
	}

	/**
	 * 
	 */
	public MealyMachineProvider() {
		super();
	}

	public ModelElementFactory getModelElementFactory() {
		return factory_;
	}


    public String getModelID() {
        return MODEL_ID;
    }
    
    public ConstraintsChecker getConstraintsChecker() {
        return checker_;
    }
    
    public PaletteProvider getPaletteProvider(){
        return paletteProvider_;
    }
    
    public ElementGroup[] getElementGroups() {
		ElementGroup[] els = {
			new ElementGroupImpl(getRootModel().getChildAtoms(),"Atoms"),
			new ElementGroupImpl(getRootModel().getChildModels(),"Models")
		};
		return els;
	}
	
	public EPackage getEMFPackage(){
		return de.cau.cs.kieler.gems.mealy.emf.mealymachine.impl.MealyMachinePackageImpl.eINSTANCE;
	}
 
}

