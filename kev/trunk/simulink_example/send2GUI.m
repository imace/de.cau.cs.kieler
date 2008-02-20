function level2sfunc(block)
%MSFUNTMPL A template for an M-file S-function
%   The M-file S-function is written as a MATLAB function with the
%   same name as the S-function. Replace 'msfuntmpl' with the name
%   of your S-function.  
%
%   It should be noted that the M-file S-function is very similar
%   to Level-2 C-Mex S-functions. You should be able to get more 
%   information for each of the block methods by referring to the
%   documentation for C-Mex S-functions.
%  
%   Copyright 2003-2005 The MathWorks, Inc.
%   $Revision: 1.1 $  
  
%%
%% The setup method is used to setup the basic attributes of the
%% S-function such as ports, parameters, etc. Do not add any other
%% calls to the main body of the function.  
%% 

setup(block);
  
%endfunction

%% Function: setup ===================================================
%% Abstract:
%%   Set up the S-function block's basic characteristics such as:
%%   - Input ports
%%   - Output ports
%%   - Dialog parameters
%%   - Options
%% 
%%   Required         : Yes
%%   C-Mex counterpart: mdlInitializeSizes
%%
function setup(block)
  % Register number of ports
  block.NumInputPorts  = 1;
  block.NumOutputPorts = 1;
  % Setup port properties to be inherited or dynamic
  block.SetPreCompInpPortInfoToDynamic;
  block.SetPreCompOutPortInfoToDynamic;

  % Override input port properties
  block.InputPort(1).DatatypeID  = -1;  % inherit
  block.InputPort(1).Complexity  = 'Real';
  
  % Override output port properties
  block.OutputPort(1).DatatypeID  = -1; % inherit
  block.OutputPort(1).Complexity  = 'Real';
  
  javaaddpath('guiclient.jar');
  
  disp('Setting output port dimensions');
  %if block.DialogPrm(2).Data == 0
    block.OutputPort(1).Dimensions = block.DialogPrm(2).Data;
    disp(block.DialogPrm(2).Data);
    disp(block.OutputPort(1).Dimensions);
    
%  else
 %   block.OutputPort(1).Dimensions = 1; 
  %end;
  

  %modelgui.ControlAnimationSimulinkClient.initialize('10.6.0.24',port);
  %if modelgui.ControlAnimationSimulinkClient.isExit()
  %    disp('error in setup');
  %    modelgui.ControlAnimationSimulinkClient.terminate();
  %    error(modelgui.ControlAnimationSimulinkClient.getException());
  %end
  %[x,y] = size(  modelgui.ControlAnimationSimulinkClient.getControlData());
  %block.OutputPort(1).Dimensions  = x;

  % Register parameters
   block.NumDialogPrms     = 3;
  % block.DialogPrmsTunable = {'Tunable'};

  % Register sample times
  %  [0 offset]            : Continuous sample time
  %  [positive_num offset] : Discrete sample time
  %
  %  [-1, 0]               : Port-based sample time
  %  [-2, 0]               : Variable sample time
  block.SampleTimes = [block.DialogPrm(3).Data, 0];
  
  %% -----------------------------------------------------------------
  %% Options
  %% -----------------------------------------------------------------
  % Specify if Accelerator should use TLC or call back into 
  % M-file
  block.SetAccelRunOnTLC(false);
  
  %% -----------------------------------------------------------------
  %% The M-file S-function uses an internal registry for all
  %% block methods. You should register all relevant methods
  %% (optional and required) as illustrated below. You may choose
  %% any suitable name for the methods and implement these methods
  %% as local functions within the same file.
  %% -----------------------------------------------------------------
    
  %% -----------------------------------------------------------------
  %% Register methods called during update diagram/compilation
  %% -----------------------------------------------------------------
  
  %% 
  %% CheckParameters:
  %%   Functionality    : Called in order to allow validation of
  %%                      block's dialog parameters. User is 
  %%                      responsible for calling this method
  %%                      explicitly at the start of the setup method
  %%   C-Mex counterpart: mdlCheckParameters
  %%
  %block.RegBlockMethod('CheckParameters', @CheckPrms);

  %%
  %% SetInputPortSamplingMode:
  %%   Functionality    : Check and set input and output port 
  %%                      attributes specifying if port is operating 
  %%                      in sample-based or frame-based mode
  %%   C-Mex counterpart: mdlSetInputPortFrameData
  %%   (Signal Processing Blockset is required in order to set a port
  %%    to be frame-based)
  %%
  block.RegBlockMethod('SetInputPortSamplingMode', @SetInpPortFrameData);
  
  %%
  %% SetInputPortDimensions:
  %%   Functionality    : Check and set input and optionally output
  %%                      port dimensions
  %%   C-Mex counterpart: mdlSetInputPortDimensionInfo
  %%
  block.RegBlockMethod('SetInputPortDimensions', @SetInpPortDims);

  %%
  %% SetOutputPortDimensions:
  %%   Functionality    : Check and set output and optionally input
  %%                      port dimensions
  %%   C-Mex counterpart: mdlSetOutputPortDimensionInfo
  %%
  block.RegBlockMethod('SetOutputPortDimensions', @SetOutPortDims);
  
  %%
  %% SetInputPortDatatype:
  %%   Functionality    : Check and set input and optionally output
  %%                      port datatypes
  %%   C-Mex counterpart: mdlSetInputPortDataType
  %%
  block.RegBlockMethod('SetInputPortDataType', @SetInpPortDataType);
  
  %%
  %% SetOutputPortDatatype:
  %%   Functionality    : Check and set output and optionally input
  %%                      port datatypes
  %%   C-Mex counterpart: mdlSetOutputPortDataType
  %%
  block.RegBlockMethod('SetOutputPortDataType', @SetOutPortDataType);
  
  %%
  %% SetInputPortComplexSignal:
  %%   Functionality    : Check and set input and optionally output
  %%                      port complexity attributes
  %%   C-Mex counterpart: mdlSetInputPortComplexSignal
  %%
  block.RegBlockMethod('SetInputPortComplexSignal', @SetInpPortComplexSig);
  
  %%
  %% SetOutputPortComplexSignal:
  %%   Functionality    : Check and set output and optionally input
  %%                      port complexity attributes
  %%   C-Mex counterpart: mdlSetOutputPortComplexSignal
  %%
  block.RegBlockMethod('SetOutputPortComplexSignal', @SetOutPortComplexSig);
  
  %%
  %% PostPropagationSetup:
  %%   Functionality    : Setup work areas and state variables. Can
  %%                      also register run-time methods here
  %%   C-Mex counterpart: mdlSetWorkWidths
  %%
  block.RegBlockMethod('PostPropagationSetup', @DoPostPropSetup);

  %% -----------------------------------------------------------------
  %% Register methods called at run-time
  %% -----------------------------------------------------------------
  
  %% 
  %% ProcessParameters:
  %%   Functionality    : Called in order to allow update of run-time
  %%                      parameters
  %%   C-Mex counterpart: mdlProcessParameters
  %%  
  block.RegBlockMethod('ProcessParameters', @ProcessPrms);

  %% 
  %% InitializeConditions:
  %%   Functionality    : Called in order to initalize state and work
  %%                      area values
  %%   C-Mex counterpart: mdlInitializeConditions
  %% 
  block.RegBlockMethod('InitializeConditions', @InitializeConditions);
  
  %% 
  %% Start:
  %%   Functionality    : Called in order to initalize state and work
  %%                      area values
  %%   C-Mex counterpart: mdlStart
  %%
  block.RegBlockMethod('Start', @Start);

  %% 
  %% Outputs:
  %%   Functionality    : Called to generate block outputs in
  %%                      simulation step
  %%   C-Mex counterpart: mdlOutputs
  %%
  block.RegBlockMethod('Outputs', @Outputs);

  %% 
  %% Update:
  %%   Functionality    : Called to update discrete states
  %%                      during simulation step
  %%   C-Mex counterpart: mdlUpdate
  %%
  block.RegBlockMethod('Update', @Update);

  %% 
  %% Derivatives:
  %%   Functionality    : Called to update derivatives of
  %%                      continuous states during simulation step
  %%   C-Mex counterpart: mdlDerivatives
  %%
  block.RegBlockMethod('Derivatives', @Derivatives);
  
  %% 
  %% Projection:
  %%   Functionality    : Called to update projections during 
  %%                      simulation step
  %%   C-Mex counterpart: mdlProjections
  %%
  block.RegBlockMethod('Projection', @Projection);

  %% 
  %% ZeroCrossings:
  %%   Functionality    : For S-functions with continuous sample
  %%                      time, if input signals have discontinuities,
  %%                      this method is called to detect 
  %%                      discontinuities
  %%   C-Mex counterpart: mdlZeroCrossings
  %%
  block.RegBlockMethod('ZeroCrossings', @ZeroCrosssings);
  
  %% 
  %% SimStatusChange:
  %%   Functionality    : Called when simulation goes to pause mode
  %%                      or continnues from pause mode
  %%   C-Mex counterpart: mdlSimStatusChange
  %%
  block.RegBlockMethod('SimStatusChange', @SimStatusChange);
  
  %% 
  %% Terminate:
  %%   Functionality    : Called at the end of simulation for cleanup
  %%   C-Mex counterpart: mdlTerminate
  %%
  block.RegBlockMethod('Terminate', @Terminate);

  %% -----------------------------------------------------------------
  %% Register methods called during code generation
  %% -----------------------------------------------------------------
  
  %%
  %% WriteRTW:
  %%   Functionality    : Write specific information to RTW file
  %%   C-Mex counterpart: mdlRTW
  %%
  block.RegBlockMethod('WriteRTW', @WriteRTW);
%endfunction

%% -------------------------------------------------------------------
%% The local functions below are provided for illustrative purposes
%% to show how you may implement the various block methods listed
%% above.
%% -------------------------------------------------------------------

function CheckPrms(block)
  
  a = block.DialogPrm(1).Data;
  if ~strcmp(class(a), 'double')
    error('Invalid parameter');
  end
  
%endfunction

function ProcessPrms(block)
  
 
%endfunction

function SetInpPortFrameData(block, idx, fd)
  
  block.InputPort(idx).SamplingMode = fd;
  block.OutputPort(1).SamplingMode  = fd;
  
%endfunction

function SetInpPortDims(block, idx, di)
  
  block.InputPort(idx).Dimensions = di;
  %block.OutputPort(1).Dimensions  = di; 
  % would inherit output port dims
  % from inport

%endfunction

function SetOutPortDims(block, idx, di)
  
  block.OutputPort(idx).Dimensions = di;
  %block.InputPort(1).Dimensions    = di;

%endfunction

function SetInpPortDataType(block, idx, dt)
  
  block.InputPort(idx).DataTypeID = dt;
  block.OutputPort(1).DataTypeID  = dt;

%endfunction
  
function SetOutPortDataType(block, idx, dt)

  block.OutputPort(idx).DataTypeID  = dt;
  block.InputPort(1).DataTypeID     = dt;

%endfunction  

function SetInpPortComplexSig(block, idx, c)
  
  block.InputPort(idx).Complexity = c;
  block.OutputPort(1).Complexity  = c;

%endfunction 
  
function SetOutPortComplexSig(block, idx, c)

  block.OutputPort(idx).Complexity = c;
  block.InputPort(1).Complexity    = c;

%endfunction 
    
function DoPostPropSetup(block)
  block.NumDworks = 0;
  %% Register all tunable parameters as runtime parameters.
  block.AutoRegRuntimePrms;

  %javaclasspath
  
%endfunction

function InitializeConditions(block)
  block.AutoUpdateRuntimePrms;    
%endfunction

function Start(block)

disp('setting port');
port = block.DialogPrm(1).Data;
modelgui.RemoteSimulinkClient.initialize('10.6.0.41',port);
    
%endfunction

function WriteRTW(block)
  
   block.WriteRTWParam('matrix', 'M',    [1 2; 3 4]);
   block.WriteRTWParam('string', 'Mode', 'Auto');
   
%endfunction

function Outputs(block)
% isExit is set within Java program whenever some fatal exception occurs
  if modelgui.RemoteSimulinkClient.isExit()
      disp('error in outputs');
      modelgui.RemoteSimulinkClient.terminate();
      error(modelgui.RemoteSimulinkClient.getException()); 
  end
  command = mat2str(block.InputPort(1).Data);
  modelgui.RemoteSimulinkClient.send(command);
%endfunction

function Update(block)
modelgui.RemoteSimulinkClient.stepDelay();
   if modelgui.RemoteSimulinkClient.isExit()
       disp('error in delay');
       modelgui.RemoteSimulinkClient.terminate();
       error(modelgui.RemoteSimulinkClient.getException());
   end
   doubles = modelgui.RemoteSimulinkClient.getControlData();
   if modelgui.RemoteSimulinkClient.isExit()
       disp('error in getControlData');
       modelgui.RemoteSimulinkClient.terminate();
       error(modelgui.RemoteSimulinkClient.getException());
   end
    if block.DialogPrm(2).Data > 0
   %if block.OutputPort(1).Dimensions > 0
       block.OutputPort(1).Data = doubles;
   end;
%endfunction

function Derivatives(block)
%endfunction

function Projection(block)
%endfunction
  
function ZeroCrosssings(block)
%endfunction

function SimStatusChange(block, status)  
%endfunction
    
function Terminate(block)
    disp('closing client');
    modelgui.RemoteSimulinkClient.terminate();
%endfunction
 
