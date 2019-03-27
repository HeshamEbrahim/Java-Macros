// STAR-CCM+ macro: historyfile.java
// Written by STAR-CCM+ 11.04.012
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.flow.*;
import star.post.*;

public class historyfile extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    SolutionHistory solutionHistory_0 = 
      simulation_0.get(SolutionHistoryManager.class).createForFile(resolvePath("D:\\Documents\\Northumbria University\\PhD Research\\CFD\\Nissan Leaf\\Platoon\\3 Cars\\historyfile.simh"), false);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Wind Tunnel");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Block.inlet");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("Block.outlet");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("Block.road");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("Block.side");

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("Block.symmetry");

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("Block.top");

    solutionHistory_0.getInputs().setObjects(boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5);

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    VectorMagnitudeFieldFunction vectorMagnitudeFieldFunction_0 = 
      ((VectorMagnitudeFieldFunction) primitiveFieldFunction_0.getMagnitudeFunction());

    solutionHistory_0.setFunctions(new NeoObjectVector(new Object[] {vectorMagnitudeFieldFunction_0}));

    StarUpdate starUpdate_18 = 
      solutionHistory_0.getUpdate();

    IterationUpdateFrequency iterationUpdateFrequency_18 = 
      starUpdate_18.getIterationUpdateFrequency();

    iterationUpdateFrequency_18.setIterations(5);

    iterationUpdateFrequency_18.setStart(38170);

    SolutionHistory solutionHistory_1 = 
      simulation_0.get(SolutionHistoryManager.class).createForFile(resolvePath("D:\\Documents\\Northumbria University\\PhD Research\\CFD\\Nissan Leaf\\Platoon\\3 Cars\\Cphistoryfile.simh"), false);

    Boundary boundary_6 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Leader.08_mrr_left");

    Boundary boundary_7 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Leader.08_mrr_right");

    Boundary boundary_8 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Leader.floor");

    Boundary boundary_9 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Leader.fr_end");

    Boundary boundary_10 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Leader.fr_wheel");

    Boundary boundary_11 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Leader.mid_end");

    Boundary boundary_12 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Leader.rr_end");

    Boundary boundary_13 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Leader.rr_wheel");

    Boundary boundary_14 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Middle.08_mrr_left");

    Boundary boundary_15 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Middle.08_mrr_right");

    Boundary boundary_16 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Middle.floor");

    Boundary boundary_17 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Middle.fr_end");

    Boundary boundary_18 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Middle.fr_wheel");

    Boundary boundary_19 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Middle.mid_end");

    Boundary boundary_20 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Middle.rr_end");

    Boundary boundary_21 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Middle.rr_wheel");

    Boundary boundary_22 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Trail.08_mrr_left");

    Boundary boundary_23 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Trail.08_mrr_right");

    Boundary boundary_24 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Trail.floor");

    Boundary boundary_25 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Trail.fr_end");

    Boundary boundary_26 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Trail.fr_wheel");

    Boundary boundary_27 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Trail.mid_end");

    Boundary boundary_28 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Trail.rr_end");

    Boundary boundary_29 = 
      region_0.getBoundaryManager().getBoundary("Nissan_Leaf_Trail.rr_wheel");

    solutionHistory_1.getInputs().setObjects(boundary_6, boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12, boundary_13, boundary_14, boundary_15, boundary_16, boundary_17, boundary_18, boundary_19, boundary_20, boundary_21, boundary_22, boundary_23, boundary_24, boundary_25, boundary_26, boundary_27, boundary_28, boundary_29);

    PressureCoefficientFunction pressureCoefficientFunction_0 = 
      ((PressureCoefficientFunction) simulation_0.getFieldFunctionManager().getFunction("PressureCoefficient"));

    solutionHistory_1.setFunctions(new NeoObjectVector(new Object[] {pressureCoefficientFunction_0}));

    StarUpdate starUpdate_19 = 
      solutionHistory_1.getUpdate();

    IterationUpdateFrequency iterationUpdateFrequency_19 = 
      starUpdate_19.getIterationUpdateFrequency();

    iterationUpdateFrequency_19.setIterations(5);

    iterationUpdateFrequency_19.setStart(38170);
    
    simulation_0.getSimulationIterator().run();
  }
}
