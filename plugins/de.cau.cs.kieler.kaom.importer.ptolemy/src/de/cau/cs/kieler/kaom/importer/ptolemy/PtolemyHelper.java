package de.cau.cs.kieler.kaom.importer.ptolemy;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.IExecutionContextAware;

import ptolemy.Moml.EntityType;
import ptolemy.actor.TypedCompositeActor;
import ptolemy.kernel.Entity;
import ptolemy.kernel.util.Attribute;
import ptolemy.kernel.util.NamedObj;
import ptolemy.moml.MoMLParser;

import com.microstar.xml.XmlException;

import de.cau.cs.kieler.annotations.Annotation;
import de.cau.cs.kieler.annotations.AnnotationsFactory;
import de.cau.cs.kieler.annotations.BooleanAnnotation;
import de.cau.cs.kieler.annotations.StringAnnotation;
import de.cau.cs.kieler.kaom.KaomFactory;
import de.cau.cs.kieler.kaom.Port;

public class PtolemyHelper implements IExecutionContextAware{

    ExecutionContext ctx;
    
    public PtolemyHelper() {}
    
    public List<Port> getPorts(List<EntityType> entities) {
        List<Port> ports = new BasicEList<Port>();
        for (EntityType entity : entities) {
            ports.addAll(getPorts(entity));
        }
        return ports;
    }

    public List<Port> getPorts(EntityType ptolemyEntity) {
        List<Port> kaomPorts = new LinkedList<Port>();
        try {
            NamedObj actor = instanciatePtolemyEntity(ptolemyEntity);
            
            // get lists of all ports
            List ptolemyPorts = new LinkedList();
            List inputs = ((ptolemy.actor.Actor) actor).inputPortList();
            List outputs = ((ptolemy.actor.Actor) actor).outputPortList();
            ptolemyPorts.addAll(inputs);
            // avoid duplicates. A port may be both, input and output
            for (Object output : outputs) {
                if (ptolemyPorts.contains(output)) {
                    continue;
                }
                ptolemyPorts.add(output);
            }
            
            for (Object obj : ptolemyPorts) {
                ptolemy.kernel.Port ptolemyPort = (ptolemy.kernel.Port) obj;
                Port kaomPort = KaomFactory.eINSTANCE.createPort();
                // find out whether it is an input or output (or both)
                if (inputs.contains(ptolemyPort)) {
                    Annotation isInput = AnnotationsFactory.eINSTANCE.createAnnotation();
                    isInput.setName("input");
                    kaomPort.getAnnotations().add(isInput);
                }
                if (outputs.contains(ptolemyPort)) {
                    Annotation isOutput = AnnotationsFactory.eINSTANCE.createAnnotation();
                    isOutput.setName("output");
                    kaomPort.getAnnotations().add(isOutput);
                }
                // set the name
                kaomPort.setName(ptolemyPort.getName());
                
                for(Object attribute : ptolemyPort.attributeList()){
                    if(attribute instanceof Attribute){
                        kaomPort.getAnnotations().add(getAnnotation((Attribute) attribute));
                    }
                }
                
                kaomPorts.add(kaomPort);
            }
        } catch (XmlException xe){
            System.out.println("Could not instanciate entity: "+xe.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kaomPorts;
    }

    /**
     * Instanciate a Ptolemy Entity for a given EntityType model object.
     * @param entity given EMF EntityType model object
     * @return corresponding Ptolemy object
     * @throws Exception may throw different Exceptions during parsing
     */
    private NamedObj instanciatePtolemyEntity(EntityType entity) throws Exception {
        String classname = entity.getClass1();
        // use the Ptolemy internal Model ML (MoML) parser parsing XML and creates Ptolemy models
        MoMLParser parser = new MoMLParser();
        // atomic actors require a valid parent so create a dummy parent
        String parent = "<entity name=\"TopLevel\" class=\"ptolemy.actor.TypedCompositeActor\">";
        // embed the real entity description in the parent
        String child = parent + "<entity name=\""+entity.getName()+"\"class=\""+classname+"\"/> </entity>";
        // let the parser do the job
        NamedObj actor = parser.parse(child);
        actor = (Entity)((TypedCompositeActor)actor).entityList().get(0);
        return actor;
    }

    /**
     * Transform Ptolemy Attribute to a KAOM Annotation including all nested Attributes.
     * @param ptolemyAttribute
     * @return the created KAOM Annotation
     */
    static private Annotation getAnnotation(Attribute ptolemyAttribute){
        StringAnnotation kaomAnnotation = AnnotationsFactory.eINSTANCE.createStringAnnotation();
        StringAnnotation classAnnotation = AnnotationsFactory.eINSTANCE.createStringAnnotation();
        
        kaomAnnotation.setName(ptolemyAttribute.getName());
        classAnnotation.setName("ptolemyClass");
        classAnnotation.setValue(ptolemyAttribute.getClassName());
        kaomAnnotation.getAnnotations().add(classAnnotation);
        
        for(Object childAttribute : ptolemyAttribute.attributeList()){
            if(childAttribute instanceof Attribute){
                kaomAnnotation.getAnnotations().add(getAnnotation((Attribute) childAttribute));
            }
        }
        return kaomAnnotation;
    }

    public void setExecutionContext(ExecutionContext ctx) {
        this.ctx = ctx;
    }

}
