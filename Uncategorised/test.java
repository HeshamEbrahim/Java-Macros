// STAR-CCM+ macro: test.java
// Written by STAR-CCM+ 11.04.012
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;

public class test extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    FftFieldFunction fftFieldFunction_0 = 
      ((FftFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Fft:Pressure Coefficient"));

    fftFieldFunction_0.getFrequency().setValue(1.0);
  }
}
