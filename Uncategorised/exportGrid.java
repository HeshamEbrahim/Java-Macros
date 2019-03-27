// STAR-CCM+ macro: exportGrid.java
// Written by STAR-CCM+ 11.04.012
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;

public class exportGrid extends StarMacro {

  public void execute() {
    execute0();
  }
  
  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();
    
    int frequency = 5; 
    String Location = "C:\\Users\\Windtunnel\\Desktop\\Data\\";
    
    for(int i=1; i<65; i++)
    {
        
    // convert frequency number to string
    String frequencyAsString = Integer.toString(frequency);    
        
    // change frequency range
    FftFieldFunction fftFieldFunction_0 = 
      ((FftFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Fft:Pressure Coefficient"));

    fftFieldFunction_0.getFrequency().setValue(frequency);

    // export data to file
    XyzInternalTable xyzInternalTable_0 = 
      ((XyzInternalTable) simulation_0.getTableManager().getTable("XYZ Internal Table"));

    xyzInternalTable_0.extract();

    xyzInternalTable_0.export(Location.concat(frequencyAsString)+  " Hz.csv", ",");
    
    frequency += 1;
    }
  }
}
