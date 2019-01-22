// STAR-CCM+ macro: dev.java
// Written by STAR-CCM+ 11.04.012
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class extractRoadDatayLines extends StarMacro {

  double[] yCoordinates = new double[]{0.001, 0.25, 0.3, 0.4, 0.475, 0.5, 0.575, 0.65, 0.7, 0.75, 0.775};

  public void execute() {
    // Create Planes Based on Coordinates  

    for(int y=0; y<= 10; y++)
    {
      Simulation simulation_0 = 
        getActiveSimulation();

      Units units_3 = 
        simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

      Scene scene_0 = 
        simulation_0.getSceneManager().getScene("Mesh Scene 1");

      scene_0.setTransparencyOverrideMode(1);

      Region region_0 = 
        simulation_0.getRegionManager().getRegion("WT");

      scene_0.getCreatorGroup().setObjects(region_0);

      Boundary boundary_1 = 
        region_0.getBoundaryManager().getBoundary("Subtract.NL 2.Full Car.NL");

      Boundary boundary_2 = 
        region_0.getBoundaryManager().getBoundary("Subtract.NL 2.Gap Closure Faces");

      scene_0.getCreatorGroup().setObjects(boundary_1, boundary_2);

      PartDisplayer partDisplayer_62 = 
        scene_0.getDisplayerManager().createPartDisplayer("Section Geometry", -1, 1);

      partDisplayer_62.initialize();

      scene_0.setTransparencyOverrideMode(1);

      PlaneSection planeSection_382 = 
        (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}));

      LabCoordinateSystem labCoordinateSystem_0 = 
        simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

      planeSection_382.setCoordinateSystem(labCoordinateSystem_0);

      planeSection_382.getInputParts().setObjects(boundary_1, boundary_2);

      Coordinate coordinate_6 = 
        planeSection_382.getOriginCoordinate();

      coordinate_6.setValue(new DoubleVector(new double[] {0.0, yCoordinates[y], 0.0}));

      coordinate_6.setCoordinate(units_3, units_3, units_3, new DoubleVector(new double[] {0.0, yCoordinates[y], 0.0}));

      coordinate_6.setCoordinateSystem(labCoordinateSystem_0);

      Coordinate coordinate_7 = 
        planeSection_382.getOrientationCoordinate();

      coordinate_7.setValue(new DoubleVector(new double[] {0.0, 1.0, 0.0}));

      coordinate_7.setCoordinate(units_3, units_3, units_3, new DoubleVector(new double[] {0.0, 1.0, 0.0}));

      coordinate_7.setCoordinateSystem(labCoordinateSystem_0);

      SingleValue singleValue_3 = 
        planeSection_382.getSingleValue();

      singleValue_3.getValueQuantity().setValue(0.0);

      singleValue_3.getValueQuantity().setUnits(units_3);

      RangeMultiValue rangeMultiValue_3 = 
        planeSection_382.getRangeMultiValue();

      rangeMultiValue_3.setNValues(2);

      rangeMultiValue_3.getStartQuantity().setValue(0.0);

      rangeMultiValue_3.getStartQuantity().setUnits(units_3);

      rangeMultiValue_3.getEndQuantity().setValue(1.0);

      rangeMultiValue_3.getEndQuantity().setUnits(units_3);

      DeltaMultiValue deltaMultiValue_3 = 
        planeSection_382.getDeltaMultiValue();

      deltaMultiValue_3.setNValues(2);

      deltaMultiValue_3.getStartQuantity().setValue(0.0);

      deltaMultiValue_3.getStartQuantity().setUnits(units_3);

      deltaMultiValue_3.getDeltaQuantity().setValue(1.0);

      deltaMultiValue_3.getDeltaQuantity().setUnits(units_3);

      MultiValue multiValue_3 = 
        planeSection_382.getArbitraryMultiValue();

      multiValue_3.getValueQuantities().setUnits(units_3);

      multiValue_3.getValueQuantities().setArray(new DoubleVector(new double[] {0.0}));

      planeSection_382.setValueMode(0);

      partDisplayer_62.getVisibleParts().addParts(planeSection_382);

      partDisplayer_62.getHiddenParts().addParts();

      scene_0.setTransparencyOverrideMode(0);
        
    }

  }
}
