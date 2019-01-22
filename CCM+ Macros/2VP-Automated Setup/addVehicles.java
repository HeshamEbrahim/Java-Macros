// STAR-CCM+ macro: simSetup.java
// Written by Hesham Ebrahim
package macro;

// Packages used 
import java.util.*;
import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.meshing.*;

public class addVehicles extends simSetup {

  public void execute() {

    Simulation simulation_0 = 
      getActiveSimulation();

    PartImportManager partImportManager_0 = 
      simulation_0.get(PartImportManager.class);

    // set units of the import
    Units units_1 = 
      ((Units) simulation_0.getUnitsManager().getObject("mm"));

    // set the path of the file
    partImportManager_0.importStlPart(resolvePath(mainDirectory+leadingVehicle), "OneSurfacePerPatch", units_1, true, 1.0E-5);
    
    // generate geometry scene
    simulation_0.getSceneManager().createGeometryScene("Geometry Scene", "Outline", "Geometry", 1);

    Scene scene_2 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 1");

    scene_2.initializeAndWait();

    partImportManager_0.importStlPart(resolvePath(mainDirectory+trailingVehicle), "OneSurfacePerPatch", units_1, true, 1.0E-5);

  }

}
