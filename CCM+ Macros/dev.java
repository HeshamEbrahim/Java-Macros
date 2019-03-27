// STAR-CCM+ macro: dev.java
// Written by STAR-CCM+ 11.04.012
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;

public class dev extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    StepStoppingCriterion stepStoppingCriterion_0 = 
      ((StepStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Steps"));

    stepStoppingCriterion_0.setMaximumNumberSteps(4000);
  }
}
