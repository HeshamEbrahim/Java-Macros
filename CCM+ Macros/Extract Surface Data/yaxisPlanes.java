// Written by Hesham Ebrahim
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class yaxisPlanes extends planeExtraction {

  public void execute() {
    Simulation simulation_0 = 
      getActiveSimulation();
    
for(int i=1; i<yLoop; i++)
{ 
// setup
    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Mesh Scene 1");

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("WT");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary(carBoundary1);

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary(carBoundary2);

    scene_0.getCreatorGroup().setObjects(boundary_3, boundary_4);

    PartDisplayer partDisplayer_3 = 
      scene_0.getDisplayerManager().createPartDisplayer("Section Geometry", -1, 1);

    partDisplayer_3.initialize();

    PlaneSection planeSection_1 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}));

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    planeSection_1.setCoordinateSystem(labCoordinateSystem_0);

    planeSection_1.getInputParts().setObjects(boundary_3, boundary_4);
    
// set the axis coordinates
        Coordinate coordinate_4 = 
          planeSection_1.getOriginCoordinate();

        coordinate_4.setValue(new DoubleVector(new double[] {0.0, y, 0.0}));

        coordinate_4.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, y, 0.0}));

        coordinate_4.setCoordinateSystem(labCoordinateSystem_0);

// set the axis orientation
        Coordinate coordinate_5 = 
          planeSection_1.getOrientationCoordinate();

        coordinate_5.setValue(new DoubleVector(new double[] {0.0, 1.0, 0.0}));

        coordinate_5.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 1.0, 0.0}));

        coordinate_5.setCoordinateSystem(labCoordinateSystem_0);

        partDisplayer_3.getVisibleParts().addParts(planeSection_1);

        partDisplayer_3.getHiddenParts().addParts();
        
        y += (yInc);
  }

  }
}
