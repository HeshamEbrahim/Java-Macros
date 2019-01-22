// STAR-CCM+ macro: test.java
// Written by STAR-CCM+ 11.04.012
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class test extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_2 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    PartDisplayer partDisplayer_1 = 
      ((PartDisplayer) scene_2.getDisplayerManager().getDisplayer("Geometry 1"));

    partDisplayer_1.setOpacity(1.0);

    ScalarDisplayer scalarDisplayer_1 = 
      ((ScalarDisplayer) scene_2.getDisplayerManager().getDisplayer("Scalar 1"));

    scalarDisplayer_1.setOpacity(0.7);
  }
}
