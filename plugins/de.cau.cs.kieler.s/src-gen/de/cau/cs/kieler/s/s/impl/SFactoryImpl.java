/**
 * <copyright>
 * </copyright>
 *

 */
package de.cau.cs.kieler.s.s.impl;

import de.cau.cs.kieler.s.s.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SFactoryImpl extends EFactoryImpl implements SFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SFactory init()
  {
    try
    {
      SFactory theSFactory = (SFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.cau.de/cs/kieler/s"); 
      if (theSFactory != null)
      {
        return theSFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case SPackage.PROGRAM: return createProgram();
      case SPackage.STATE: return createState();
      case SPackage.SIGNAL: return createSignal();
      case SPackage.INSTRUCTION: return createInstruction();
      case SPackage.PAUSE: return createPause();
      case SPackage.TERM: return createTerm();
      case SPackage.HALT: return createHalt();
      case SPackage.JOIN: return createJoin();
      case SPackage.ABORT: return createAbort();
      case SPackage.PRESENT: return createPresent();
      case SPackage.GOTO: return createGoto();
      case SPackage.FORK: return createFork();
      case SPackage.FORKE: return createForke();
      case SPackage.EMIT: return createEmit();
      case SPackage.AWAIT: return createAwait();
      case SPackage.PRIO: return createPrio();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Program createProgram()
  {
    ProgramImpl program = new ProgramImpl();
    return program;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State createState()
  {
    StateImpl state = new StateImpl();
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Signal createSignal()
  {
    SignalImpl signal = new SignalImpl();
    return signal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Instruction createInstruction()
  {
    InstructionImpl instruction = new InstructionImpl();
    return instruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pause createPause()
  {
    PauseImpl pause = new PauseImpl();
    return pause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Term createTerm()
  {
    TermImpl term = new TermImpl();
    return term;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Halt createHalt()
  {
    HaltImpl halt = new HaltImpl();
    return halt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Join createJoin()
  {
    JoinImpl join = new JoinImpl();
    return join;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Abort createAbort()
  {
    AbortImpl abort = new AbortImpl();
    return abort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Present createPresent()
  {
    PresentImpl present = new PresentImpl();
    return present;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Goto createGoto()
  {
    GotoImpl goto_ = new GotoImpl();
    return goto_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Fork createFork()
  {
    ForkImpl fork = new ForkImpl();
    return fork;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Forke createForke()
  {
    ForkeImpl forke = new ForkeImpl();
    return forke;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Emit createEmit()
  {
    EmitImpl emit = new EmitImpl();
    return emit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Await createAwait()
  {
    AwaitImpl await = new AwaitImpl();
    return await;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Prio createPrio()
  {
    PrioImpl prio = new PrioImpl();
    return prio;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SPackage getSPackage()
  {
    return (SPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static SPackage getPackage()
  {
    return SPackage.eINSTANCE;
  }

} //SFactoryImpl
