// STAR-CCM+ macro: exportThreshold.java
// Written by STAR-CCM+ 11.04.012
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;

public class exportThreshold extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {
      
  String Location = "C:\\Users\\Windtunnel\\Desktop\\Data\\Cp ";
  int fileNum = 1;
  double timeStep = 0.4; 
  
    Simulation simulation_0 = 
      getActiveSimulation();

    for(double i =0; i<1.295;)
    {
        String fileNumAsString = Integer.toString(fileNum);
        
        TransientImportedModel transientImportedModel_0 = 
          ((TransientImportedModel) simulation_0.get(ImportedModelManager.class).getImportedModel("trn:historyFile"));

        SingleSliderValue singleSliderValue_0 = 
          transientImportedModel_0.getDisplayTime();

        singleSliderValue_0.setValue(timeStep);

        XyzInternalTable xyzInternalTable_0 = 
          ((XyzInternalTable) simulation_0.getTableManager().getTable("XYZ Internal Table"));

        xyzInternalTable_0.extract();

        xyzInternalTable_0.export(Location.concat(fileNumAsString) + ".csv", ",");
        
        i += 0.005;
        timeStep += 0.005;
        fileNum += 1;
  }
    
  }
}
