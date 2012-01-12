package de.cau.cs.kieler.kaom.importer.ptolemy.improved.xtend;

import com.google.inject.Inject;
import de.cau.cs.kieler.core.annotations.Annotatable;
import de.cau.cs.kieler.core.annotations.Annotation;
import de.cau.cs.kieler.core.annotations.AnnotationsFactory;
import de.cau.cs.kieler.core.annotations.TypedStringAnnotation;
import de.cau.cs.kieler.kaom.KaomFactory;
import de.cau.cs.kieler.kaom.Port;
import de.cau.cs.kieler.kaom.importer.ptolemy.improved.Messages;
import de.cau.cs.kieler.kaom.importer.ptolemy.improved.PtolemyImportPlugin;
import de.cau.cs.kieler.kaom.importer.ptolemy.improved.xtend.TransformationUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.ptolemy.moml.ClassType;
import org.ptolemy.moml.EntityType;
import ptolemy.actor.IOPort;
import ptolemy.actor.TypedCompositeActor;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.Entity;
import ptolemy.kernel.util.Attribute;
import ptolemy.kernel.util.NamedObj;
import ptolemy.kernel.util.StringAttribute;
import ptolemy.moml.MoMLParser;
import ptolemy.moml.filter.BackwardCompatibility;

/**
 * Provides an interface to the Ptolemy library to instantiate actors. This is used during the
 * transformation to get our hands at the list of ports defined for an actor.
 * 
 * @author cds
 * @author haf
 */
@SuppressWarnings("all")
public class PtolemyInterface {
  /**
   * Utility methods.
   */
  @Inject
  private TransformationUtils _transformationUtils;
  
  /**
   * A cache mapping qualified class names of Ptolemy actors to their actual instances. If an actor
   * was already instantiated, there's no need to instantiate it again since that's quite a
   */
  private HashMap<String,Entity> entityCache = new Function0<HashMap<String,Entity>>() {
    public HashMap<String,Entity> apply() {
      HashMap<String,Entity> _hashMap = new HashMap<String,Entity>();
      return _hashMap;
    }
  }.apply();
  
  /**
   * Tries to instantiate the given entity to return a list of its ports. The entity must either be
   * an {@code EntityType} or a {@code ClassType}. If the entity could not be instantiated, an empty
   * list is returned.
   * 
   * @param entity description of the entity.
   * @return list of ports which will be empty if the entity could not be instantiated.
   * @throws Exception if the instantiation fails.
   */
  public List<Port> getPortsFromImplementation(final EObject entity) {
    ArrayList<Port> _xblockexpression = null;
    {
      ArrayList<Port> _arrayList = new ArrayList<Port>();
      final ArrayList<Port> result = _arrayList;
      Entity actor = null;
      Entity _instantiatePtolemyEntity = this.instantiatePtolemyEntity(entity);
      actor = _instantiatePtolemyEntity;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(actor, null);
      if (_operator_notEquals) {
        List _portList = actor.portList();
        for (final Object o : _portList) {
          if ((o instanceof IOPort)) {
            {
              final IOPort ptPort = ((IOPort) o);
              Port _createPort = KaomFactory.eINSTANCE.createPort();
              final Port kaomPort = _createPort;
              boolean _isInput = ptPort.isInput();
              if (_isInput) {
                this._transformationUtils.markAsInputPort(kaomPort);
              }
              boolean _isOutput = ptPort.isOutput();
              if (_isOutput) {
                this._transformationUtils.markAsOutputPort(kaomPort);
              }
              String _name = ptPort.getName();
              kaomPort.setName(_name);
              this._transformationUtils.addStringAnnotation(kaomPort, "language", "ptolemy");
              List _attributeList = ptPort.attributeList();
              for (final Object attribute : _attributeList) {
                if ((attribute instanceof Attribute)) {
                  this.turnAttributeIntoAnnotation(kaomPort, ((Attribute) attribute));
                }
              }
              result.add(kaomPort);
            }
          }
        }
      }
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  /**
   * Makes an annotation out of the given attribute and attaches it to the given annotatable object.
   * Recursively adds attributes of the attributes to the correspondingly created annotations.
   * 
   * @param annotatable the object to annotate with the transformed attribute.
   * @param ptAttribute the attribute to turn into an annotation
   */
  private void turnAttributeIntoAnnotation(final Annotatable annotatable, final Attribute ptAttribute) {
      TypedStringAnnotation _createTypedStringAnnotation = AnnotationsFactory.eINSTANCE.createTypedStringAnnotation();
      final TypedStringAnnotation kaomAnnotation = _createTypedStringAnnotation;
      String _name = ptAttribute.getName();
      kaomAnnotation.setName(_name);
      String _className = ptAttribute.getClassName();
      kaomAnnotation.setType(_className);
      if ((ptAttribute instanceof StringAttribute)) {
        String _valueAsString = ((StringAttribute) ptAttribute).getValueAsString();
        kaomAnnotation.setValue(_valueAsString);
      }
      EList<Annotation> _annotations = annotatable.getAnnotations();
      _annotations.add(kaomAnnotation);
      List _attributeList = ptAttribute.attributeList();
      for (final Object attribute : _attributeList) {
        if ((attribute instanceof Attribute)) {
          this.turnAttributeIntoAnnotation(kaomAnnotation, ((Attribute) attribute));
        }
      }
  }
  
  /**
   * Tries to instantiate the entity referenced by the given entity type.
   * 
   * @param ptEntity entity type describing the entity to instantiate.
   * @throws Exception if the instantiation fails.
   */
  private Entity _instantiatePtolemyEntity(final EntityType ptEntity) {
    String _class1 = ptEntity.getClass1();
    String _name = ptEntity.getName();
    Entity _instantiatePtolemyEntityWithCache = this.instantiatePtolemyEntityWithCache(_class1, _name);
    return _instantiatePtolemyEntityWithCache;
  }
  
  /**
   * Tries to instantiate the entity referenced by the given class type.
   * 
   * @param ptClass class type describing the entity to instantiate.
   * @throws Exception if the instantiation fails.
   */
  private Entity _instantiatePtolemyEntity(final ClassType ptClass) {
    String _extends = ptClass.getExtends();
    String _name = ptClass.getName();
    Entity _instantiatePtolemyEntityWithCache = this.instantiatePtolemyEntityWithCache(_extends, _name);
    return _instantiatePtolemyEntityWithCache;
  }
  
  /**
   * Instantiates the Ptolemy actor with the given class name. The entity name doesn't matter, but
   * makes errors make more sense.
   * 
   * @param className the fully qualified class name of the actor to instantiate.
   * @param entityName the actor's name in the model. Useful for error messages.
   * @return the instantiated entity.
   * @throws CoreException if the actor couldn't be instantiated.
   */
  private Entity instantiatePtolemyEntityWithCache(final String className, final String entityName) {
    try {
      Entity _xblockexpression = null;
      {
        Entity _get = this.entityCache.get(className);
        final Entity cachedEntity = _get;
        Entity _xifexpression = null;
        boolean _operator_equals = ObjectExtensions.operator_equals(cachedEntity, null);
        if (_operator_equals) {
          try {
            boolean _equals = className.equals("ptolemy.domains.modal.kernel.State");
            if (_equals) {
              {
                Entity _instantiatePtolemyState = this.instantiatePtolemyState(className, entityName);
                final Entity entity = _instantiatePtolemyState;
                this.entityCache.put(className, entity);
                return entity;
              }
            } else {
              {
                Entity _instantiatePtolemyActor = this.instantiatePtolemyActor(className, entityName);
                final Entity entity_1 = _instantiatePtolemyActor;
                this.entityCache.put(className, entity_1);
                return entity_1;
              }
            }
          } catch (final Throwable _t) {
            if (_t instanceof Exception) {
              final Exception e = (Exception)_t;
              String _replace = Messages.PtolemyTransformation_exception_actorInstantiationFailed.replace("%1", entityName);
              String _replace_1 = _replace.replace("%2", className);
              Status _status = new Status(IStatus.WARNING, PtolemyImportPlugin.PLUGIN_ID, _replace_1, e);
              CoreException _coreException = new CoreException(_status);
              throw _coreException;
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        } else {
          _xifexpression = cachedEntity;
        }
        _xblockexpression = (_xifexpression);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Instantiates a Ptolemy actor of the given class with the given name.
   * 
   * @param className the name of the actor's class.
   * @param entityName the name that should be used for the actor when instantiating it. This has no
   *                   influence on the functionality, but results in more readable error messages if
   *                   anything goes wrong.
   * @return the instantiated actor.
   * @throws Exception if the instantiation fails.
   */
  private Entity instantiatePtolemyActor(final String className, final String entityName) {
    try {
      Entity _xblockexpression = null;
      {
        List _allFilters = BackwardCompatibility.allFilters();
        MoMLParser.setMoMLFilters(_allFilters);
        MoMLParser _moMLParser = new MoMLParser();
        final MoMLParser parser = _moMLParser;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("<entity name=\"TopLevel\" class=\"ptolemy.actor.TypedCompositeActor\">");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("<entity name=\"");
        _builder.append(entityName, "    ");
        _builder.append("\" class=\"");
        _builder.append(className, "    ");
        _builder.append("\" />");
        _builder.newLineIfNotEmpty();
        _builder.append("</entity>");
        _builder.newLine();
        final CharSequence xml = _builder;
        String _string = xml.toString();
        NamedObj _parse = parser.parse(_string);
        final NamedObj parentElement = _parse;
        List _entityList = ((TypedCompositeActor) parentElement).entityList();
        Object _get = _entityList.get(0);
        _xblockexpression = (((Entity) _get));
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Instantiates a Ptolemy state entity of the given class with the given name.
   * 
   * @param className the name of the actor's class.
   * @param entityName the name that should be used for the actor when instantiating it. This has no
   *                   influence on the functionality, but results in more readable error messages if
   *                   anything goes wrong.
   * @return the instantiated actor.
   * @throws Exception if the instantiation fails.
   */
  private Entity instantiatePtolemyState(final String className, final String entityName) {
    try {
      Entity _xblockexpression = null;
      {
        List _allFilters = BackwardCompatibility.allFilters();
        MoMLParser.setMoMLFilters(_allFilters);
        MoMLParser _moMLParser = new MoMLParser();
        final MoMLParser parser = _moMLParser;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("<entity name=\"TopLevel\" class=\"ptolemy.domains.modal.modal.ModalController\">");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("<entity name=\"");
        _builder.append(entityName, "    ");
        _builder.append("\" class=\"");
        _builder.append(className, "    ");
        _builder.append("\" />");
        _builder.newLineIfNotEmpty();
        _builder.append("</entity>");
        _builder.newLine();
        final CharSequence xml = _builder;
        String _string = xml.toString();
        NamedObj _parse = parser.parse(_string);
        final NamedObj parentElement = _parse;
        List _entityList = ((CompositeEntity) parentElement).entityList();
        Object _get = _entityList.get(0);
        _xblockexpression = (((Entity) _get));
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private Entity instantiatePtolemyEntity(final EObject ptClass) {
    if (ptClass instanceof ClassType) {
      return _instantiatePtolemyEntity((ClassType)ptClass);
    } else if (ptClass instanceof EntityType) {
      return _instantiatePtolemyEntity((EntityType)ptClass);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ptClass).toString());
    }
  }
}
