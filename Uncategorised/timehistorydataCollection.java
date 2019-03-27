// STAR-CCM+ macro: timehistorydataCollection.java
// Written by STAR-CCM+ 9.06.009
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.post.*;

public class timehistorydataCollection extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {
      
      int x = 502; // initial time step 
      int y = 1; // the physical time

    Simulation simulation_0 = 
      getActiveSimulation();

    RecordedSolutionView recordedSolutionView_1 = 
      ((RecordedSolutionView) simulation_0.get(SolutionViewManager.class).getObject("TPC+Velocity_SST_0.001s"));

    TimeStepStateSelector timeStepStateSelector_0 = 
      recordedSolutionView_1.getTimeStepStateSelector();
    
    for (int i=1; i<152; i++){

    timeStepStateSelector_0.setTimeStep(x);

    XyzInternalTable xyzInternalTable_0 = 
      ((XyzInternalTable) simulation_0.getTableManager().getTable("Velocity"));
    
    xyzInternalTable_0.extract();

    xyzInternalTable_0.export(resolvePath("C:\\Users\\Windtunnel\\Documents\\Pressure Data\\V_"+y+"s.csv"), ",");
    
    x += 7;
    y ++; 
    
    }
  }
}
