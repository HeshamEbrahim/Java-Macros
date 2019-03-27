// STAR-CCM+ macro: ABhistoryFile.java
// Written by STAR-CCM+ 11.04.012
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.flow.*;
import star.post.*;

public class ABhistoryFile extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    SolutionHistory solutionHistory_0 = 
      simulation_0.get(SolutionHistoryManager.class).createForFile(resolvePath("C:\\Users\\Windtunnel\\Desktop\\ABhistoryFile.simh"), false);

    PressureCoefficientFunction pressureCoefficientFunction_0 = 
      ((PressureCoefficientFunction) simulation_0.getFieldFunctionManager().getFunction("PressureCoefficient"));

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    VectorMagnitudeFieldFunction vectorMagnitudeFieldFunction_1 = 
      ((VectorMagnitudeFieldFunction) primitiveFieldFunction_0.getMagnitudeFunction());

    VectorComponentFieldFunction vectorComponentFieldFunction_3 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(0));

    VectorComponentFieldFunction vectorComponentFieldFunction_4 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(1));

    VectorComponentFieldFunction vectorComponentFieldFunction_5 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(2));

    solutionHistory_0.setFunctions(new NeoObjectVector(new Object[] {pressureCoefficientFunction_0, primitiveFieldFunction_0, vectorMagnitudeFieldFunction_1, vectorComponentFieldFunction_3, vectorComponentFieldFunction_4, vectorComponentFieldFunction_5}));

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Wind Tunnel");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Ahmed Body.PartBody");

    PlaneSection planeSection_0 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("x=0"));

    PlaneSection planeSection_1 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("x=0.261m"));

    PlaneSection planeSection_2 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("x=0.522m"));

    PlaneSection planeSection_3 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("y=0"));

    PlaneSection planeSection_4 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("y=0.1945m"));

    PlaneSection planeSection_5 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("y=0.09725m"));

    PlaneSection planeSection_6 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("z=0.194m"));

    solutionHistory_0.getInputs().setObjects(boundary_0, planeSection_0, planeSection_1, planeSection_2, planeSection_3, planeSection_4, planeSection_5, planeSection_6);

    StarUpdate starUpdate_1 = 
      solutionHistory_0.getUpdate();

    IterationUpdateFrequency iterationUpdateFrequency_1 = 
      starUpdate_1.getIterationUpdateFrequency();

    iterationUpdateFrequency_1.setIterations(108);
    
    simulation_0.getSimulationIterator().run();
  }
}
