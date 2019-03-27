// Written by Hesham Ebrahim
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.segregatedflow.*;

public class Solvers extends simSetup {

  public void execute() {
    Simulation simulation_0 = 
      getActiveSimulation();
    // stopping criteria
    StepStoppingCriterion stepStoppingCriterion_0 = 
      ((StepStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Steps"));

    stepStoppingCriterion_0.setMaximumNumberSteps(5000);
    
    // simulation time-step
        ImplicitUnsteadySolver implicitUnsteadySolver_0 = 
            ((ImplicitUnsteadySolver) simulation_0.getSolverManager().getSolver(ImplicitUnsteadySolver.class));

        implicitUnsteadySolver_0.getTimeStep().setValue(timeStep);
    // adjust pressure sweeps
        SegregatedFlowSolver segregatedFlowSolver_0 = 
        ((SegregatedFlowSolver) simulation_0.getSolverManager().getSolver(SegregatedFlowSolver.class));

        PressureSolver pressureSolver_0 = 
        segregatedFlowSolver_0.getPressureSolver();

        AMGLinearSolver aMGLinearSolver_0 = 
        pressureSolver_0.getAMGLinearSolver();

        ((AMGVCycle) aMGLinearSolver_0.getCycleType()).setPreSweeps(4);

        ((AMGVCycle) aMGLinearSolver_0.getCycleType()).setPostSweeps(5);
    // simulation physical time
        PhysicalTimeStoppingCriterion physicalTimeStoppingCriterion_0 = 
            ((PhysicalTimeStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Physical Time"));

        physicalTimeStoppingCriterion_0.getMaximumTime().setValue(physicalTime);

    
  }

}