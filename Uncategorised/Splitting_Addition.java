// STAR-CCM+ macro: Splitting_Addition.java
// Written by STAR-CCM+ 11.04.012
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class Splitting_Addition extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Units units_0 = 
      ((Units) simulation_0.getUnitsManager().getObject("m"));

    NullFieldFunction nullFieldFunction_0 = 
      ((NullFieldFunction) simulation_0.getFieldFunctionManager().getFunction("NullFieldFunction"));

    ThresholdPart thresholdPart_0 = 
      simulation_0.getPartManager().createThresholdPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 1.0}), units_0, nullFieldFunction_0, 0);

    thresholdPart_0.setPresentationName("Copy of Threshold");

    ThresholdPart thresholdPart_1 = 
      ((ThresholdPart) simulation_0.getPartManager().getObject("Threshold"));

    thresholdPart_0.copyProperties(thresholdPart_1);

    ThresholdPart thresholdPart_2 = 
      simulation_0.getPartManager().createThresholdPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 1.0}), units_0, nullFieldFunction_0, 0);

    thresholdPart_2.setPresentationName("Copy of Threshold 2");

    ThresholdPart thresholdPart_3 = 
      ((ThresholdPart) simulation_0.getPartManager().getObject("Threshold 2"));

    thresholdPart_2.copyProperties(thresholdPart_3);

    thresholdPart_0.getInputParts().setQuery(null);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("WT");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Right Wing Mirror 2 2.Wing Mirror 2");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Front Wheels 2 2 2.Front Wheels.Front Wheels");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("Subtract.NL 2 2.Full Car.NL");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("Subtract.NL 2 2.Gap Closure Faces");

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Rear Wheels 2 2.Rear Wheels.Rear Wheels");

    thresholdPart_0.getInputParts().setObjects(boundary_0, boundary_1, boundary_2, boundary_3, boundary_4);

    thresholdPart_0.getInputParts().setQuery(null);

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Rear Wheels 2 2 2.Rear Wheels.Rear Wheels");

    thresholdPart_0.getInputParts().setObjects(boundary_0, boundary_1, boundary_2, boundary_3, boundary_5);

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Mesh Scene 1");

    CurrentView currentView_0 = 
      scene_0.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {5.471409260589624, 0.6613825552799666, 0.6660888398561513}), new DoubleVector(new double[] {4.365201275304952, -14.769787561281655, 1.2880357329736702}), new DoubleVector(new double[] {0.0015053233639813692, 0.04016410495969841, 0.9991919628751805}), 1.0, 0);

    thresholdPart_2.getInputParts().setQuery(null);

    thresholdPart_2.getInputParts().setObjects(boundary_0, boundary_1, boundary_2, boundary_3, boundary_5);

    currentView_0.setInput(new DoubleVector(new double[] {5.471409260589624, 0.6613825552799666, 0.6660888398561513}), new DoubleVector(new double[] {4.365201275304952, -14.769787561281655, 1.2880357329736702}), new DoubleVector(new double[] {0.0015053233639813676, 0.04016410495969839, 0.9991919628751806}), 1.0, 0);

    PlaneSection planeSection_0 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}));

    planeSection_0.setPresentationName("Copy of Plane Section 7");

    PlaneSection planeSection_1 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("Plane Section 7"));

    planeSection_0.copyProperties(planeSection_1);

    PlaneSection planeSection_2 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}));

    planeSection_2.setPresentationName("Copy of Plane Section 6");

    PlaneSection planeSection_3 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("Plane Section 6"));

    planeSection_2.copyProperties(planeSection_3);

    scene_0.setTransparencyOverrideMode(1);

    PartDisplayer partDisplayer_0 = 
      ((PartDisplayer) scene_0.getDisplayerManager().getDisplayer("Mesh 1"));

    partDisplayer_0.getInputParts().addObjects(planeSection_2);

    scene_0.getCreatorGroup().setObjects(thresholdPart_0);

    planeSection_2.setBatched(true);

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    planeSection_2.setCoordinateSystem(labCoordinateSystem_0);

    planeSection_2.getInputParts().setObjects(thresholdPart_0);

    Coordinate coordinate_0 = 
      planeSection_2.getOriginCoordinate();

    coordinate_0.setValue(new DoubleVector(new double[] {0.0, 0.001, 0.0}));

    coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.001, 0.0}));

    coordinate_0.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_1 = 
      planeSection_2.getOrientationCoordinate();

    coordinate_1.setValue(new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    coordinate_1.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    coordinate_1.setCoordinateSystem(labCoordinateSystem_0);

    SingleValue singleValue_0 = 
      planeSection_2.getSingleValue();

    singleValue_0.getValueQuantity().setValue(0.0);

    singleValue_0.getValueQuantity().setUnits(units_0);

    RangeMultiValue rangeMultiValue_0 = 
      planeSection_2.getRangeMultiValue();

    rangeMultiValue_0.setNValues(2);

    rangeMultiValue_0.getStartQuantity().setValue(0.0);

    rangeMultiValue_0.getStartQuantity().setUnits(units_0);

    rangeMultiValue_0.getEndQuantity().setValue(1.0);

    rangeMultiValue_0.getEndQuantity().setUnits(units_0);

    DeltaMultiValue deltaMultiValue_0 = 
      planeSection_2.getDeltaMultiValue();

    deltaMultiValue_0.setNValues(2);

    deltaMultiValue_0.getStartQuantity().setValue(0.0);

    deltaMultiValue_0.getStartQuantity().setUnits(units_0);

    deltaMultiValue_0.getDeltaQuantity().setValue(1.0);

    deltaMultiValue_0.getDeltaQuantity().setUnits(units_0);

    MultiValue multiValue_0 = 
      planeSection_2.getArbitraryMultiValue();

    multiValue_0.getValueQuantities().setUnits(units_0);

    multiValue_0.getValueQuantities().setArray(new DoubleVector(new double[] {0.0}));

    planeSection_2.setValueMode(0);

    planeSection_2.setBatched(false);

    partDisplayer_0.getVisibleParts().addParts();

    partDisplayer_0.getHiddenParts().addParts();

    scene_0.setTransparencyOverrideMode(0);

    SceneUpdate sceneUpdate_0 = 
      scene_0.getSceneUpdate();

    HardcopyProperties hardcopyProperties_1 = 
      sceneUpdate_0.getHardcopyProperties();

    hardcopyProperties_1.setCurrentResolutionWidth(1094);

    currentView_0.setInput(new DoubleVector(new double[] {5.1507646730822625, 1.0307559156211903, 0.6517243561951217}), new DoubleVector(new double[] {4.0198509449614, -14.745049681458289, 1.2875616390074633}), new DoubleVector(new double[] {0.0015053233639813676, 0.04016410495969839, 0.9991919628751806}), 1.0, 0);

    currentView_0.setInput(new DoubleVector(new double[] {5.095036851182156, 1.799583880001687, 0.618314460997273}), new DoubleVector(new double[] {7.398096071560198, -14.107946419871709, 1.3347211029742263}), new DoubleVector(new double[] {0.0013281621024257414, 0.045177524098345516, 0.9989780915023978}), 1.0, 0);

    scene_0.setTransparencyOverrideMode(1);

    partDisplayer_0.getInputParts().addObjects(planeSection_0);

    scene_0.getCreatorGroup().setObjects(thresholdPart_2);

    planeSection_0.setBatched(true);

    planeSection_0.setCoordinateSystem(labCoordinateSystem_0);

    planeSection_0.getInputParts().setObjects(thresholdPart_2);

    Coordinate coordinate_2 = 
      planeSection_0.getOriginCoordinate();

    coordinate_2.setValue(new DoubleVector(new double[] {0.0, 0.001, 0.0}));

    coordinate_2.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.001, 0.0}));

    coordinate_2.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_3 = 
      planeSection_0.getOrientationCoordinate();

    coordinate_3.setValue(new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    coordinate_3.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    coordinate_3.setCoordinateSystem(labCoordinateSystem_0);

    SingleValue singleValue_1 = 
      planeSection_0.getSingleValue();

    singleValue_1.getValueQuantity().setValue(0.0);

    singleValue_1.getValueQuantity().setUnits(units_0);

    RangeMultiValue rangeMultiValue_1 = 
      planeSection_0.getRangeMultiValue();

    rangeMultiValue_1.setNValues(2);

    rangeMultiValue_1.getStartQuantity().setValue(0.0);

    rangeMultiValue_1.getStartQuantity().setUnits(units_0);

    rangeMultiValue_1.getEndQuantity().setValue(1.0);

    rangeMultiValue_1.getEndQuantity().setUnits(units_0);

    DeltaMultiValue deltaMultiValue_1 = 
      planeSection_0.getDeltaMultiValue();

    deltaMultiValue_1.setNValues(2);

    deltaMultiValue_1.getStartQuantity().setValue(0.0);

    deltaMultiValue_1.getStartQuantity().setUnits(units_0);

    deltaMultiValue_1.getDeltaQuantity().setValue(1.0);

    deltaMultiValue_1.getDeltaQuantity().setUnits(units_0);

    MultiValue multiValue_1 = 
      planeSection_0.getArbitraryMultiValue();

    multiValue_1.getValueQuantities().setUnits(units_0);

    multiValue_1.getValueQuantities().setArray(new DoubleVector(new double[] {0.0}));

    planeSection_0.setValueMode(0);

    planeSection_0.setBatched(false);

    partDisplayer_0.getVisibleParts().addParts();

    partDisplayer_0.getHiddenParts().addParts();

    scene_0.setTransparencyOverrideMode(0);

    currentView_0.setInput(new DoubleVector(new double[] {5.095036851182156, 1.799583880001687, 0.618314460997273}), new DoubleVector(new double[] {7.398096071560198, -14.107946419871709, 1.3347211029742263}), new DoubleVector(new double[] {0.001327534507802844, 0.04518185897675183, 0.9989778962877685}), 1.0, 0);

    XYPlot xYPlot_0 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("XY Plot 1"));

    xYPlot_0.getParts().setObjects(planeSection_2);

    PlotUpdate plotUpdate_0 = 
      xYPlot_0.getPlotUpdate();

    HardcopyProperties hardcopyProperties_0 = 
      plotUpdate_0.getHardcopyProperties();

    hardcopyProperties_0.setCurrentResolutionWidth(1094);

    xYPlot_0.export(resolvePath("C:\\Users\\Windtunnel\\Desktop\\middle upper cp.csv"), ",");

    xYPlot_0.getParts().setObjects(planeSection_0);

    xYPlot_0.export(resolvePath("C:\\Users\\Windtunnel\\Desktop\\middle lower cp.csv"), ",");

    currentView_0.setInput(new DoubleVector(new double[] {5.095036851182156, 1.799583880001687, 0.618314460997273}), new DoubleVector(new double[] {7.398096071560198, -14.107946419871709, 1.3347211029742263}), new DoubleVector(new double[] {0.001327534507802844, 0.04518185897675183, 0.9989778962877685}), 1.0, 0);

    xYPlot_0.getParts().setObjects(planeSection_2);
  }
}
