// Written by Hesham Ebrahim
package macro;

// Packages used 
import java.util.*;
import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class derviedParts extends simSetup {

  public void execute() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 1");

    scene_0.setTransparencyOverrideMode(1);

    PartDisplayer partDisplayer_2 = 
      ((PartDisplayer) scene_0.getCreatorDisplayer());

    partDisplayer_2.initialize();

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("WT");

    scene_0.getCreatorGroup().setObjects(region_0);

    PartDisplayer partDisplayer_3 = 
      scene_0.getDisplayerManager().createPartDisplayer("Section Geometry", -1, 1);

    partDisplayer_3.initialize();

    scene_0.setTransparencyOverrideMode(1);

    PlaneSection planeSection_0 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}));

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    planeSection_0.setCoordinateSystem(labCoordinateSystem_0);

    planeSection_0.getInputParts().setObjects(region_0);

    Coordinate coordinate_0 = 
      planeSection_0.getOriginCoordinate();

    coordinate_0.setValue(new DoubleVector(new double[] {1.11125, 0.0, 0.0}));

    coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1.11125, 0.0, 0.0}));

    coordinate_0.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_1 = 
      planeSection_0.getOrientationCoordinate();

    coordinate_1.setValue(new DoubleVector(new double[] {1.0, 0.0, 0.0}));

    coordinate_1.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1.0, 0.0, 0.0}));

    coordinate_1.setCoordinateSystem(labCoordinateSystem_0);

    SingleValue singleValue_0 = 
      planeSection_0.getSingleValue();

    singleValue_0.getValueQuantity().setValue(0.0);

    singleValue_0.getValueQuantity().setUnits(units_0);

    RangeMultiValue rangeMultiValue_0 = 
      planeSection_0.getRangeMultiValue();

    rangeMultiValue_0.setNValues(2);

    rangeMultiValue_0.getStartQuantity().setValue(0.0);

    rangeMultiValue_0.getStartQuantity().setUnits(units_0);

    rangeMultiValue_0.getEndQuantity().setValue(1.0);

    rangeMultiValue_0.getEndQuantity().setUnits(units_0);

    DeltaMultiValue deltaMultiValue_0 = 
      planeSection_0.getDeltaMultiValue();

    deltaMultiValue_0.setNValues(2);

    deltaMultiValue_0.getStartQuantity().setValue(0.0);

    deltaMultiValue_0.getStartQuantity().setUnits(units_0);

    deltaMultiValue_0.getDeltaQuantity().setValue(1.0);

    deltaMultiValue_0.getDeltaQuantity().setUnits(units_0);

    MultiValue multiValue_0 = 
      planeSection_0.getArbitraryMultiValue();

    multiValue_0.getValueQuantities().setUnits(units_0);

    multiValue_0.getValueQuantities().setArray(new DoubleVector(new double[] {0.0}));

    planeSection_0.setValueMode(0);

    partDisplayer_3.getVisibleParts().addParts(planeSection_0);

    partDisplayer_3.getHiddenParts().addParts();

    scene_0.setTransparencyOverrideMode(0);

    planeSection_0.setPresentationName("1.111m");
  }
}
