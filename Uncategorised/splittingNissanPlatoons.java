// STAR-CCM+ macro: splittingNissanPlatoons.java
// Written by STAR-CCM+ 11.04.012
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.flow.*;

public class splittingNissanPlatoons extends StarMacro {

  public void execute() {
    execute0();
    execute1();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    SceneUpdate sceneUpdate_0 = 
      scene_0.getSceneUpdate();

    HardcopyProperties hardcopyProperties_0 = 
      sceneUpdate_0.getHardcopyProperties();

    hardcopyProperties_0.setCurrentResolutionWidth(1655);

    hardcopyProperties_0.setCurrentResolutionHeight(716);

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    scene_0.setTransparencyOverrideMode(1);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("WT");

    scene_0.getCreatorGroup().setObjects(region_0);

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Right Wing Mirror.Wing Mirror 2");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Front Wheels 2.Front Wheels.Front Wheels");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("Subtract.NL.Full Car.NL");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("Subtract.NL.Gap Closure Faces");

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Rear Wheels 2.Rear Wheels.Rear Wheels");

    scene_0.getCreatorGroup().setObjects(boundary_0, boundary_1, boundary_2, boundary_3, boundary_4);

    PartDisplayer partDisplayer_3 = 
      scene_0.getDisplayerManager().createPartDisplayer("Threshold Geometry", -1, 1);

    partDisplayer_3.initialize();

    scene_0.setTransparencyOverrideMode(1);

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Position"));

    VectorComponentFieldFunction vectorComponentFieldFunction_0 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(2));

    ThresholdPart thresholdPart_0 = 
      simulation_0.getPartManager().createThresholdPart(new NeoObjectVector(new Object[] {boundary_0, boundary_1, boundary_2, boundary_3, boundary_4}), new DoubleVector(new double[] {0.1, 0.1}), units_0, vectorComponentFieldFunction_0, 1);

    partDisplayer_3.getVisibleParts().addParts(thresholdPart_0);

    partDisplayer_3.getHiddenParts().addParts();

    PartDisplayer partDisplayer_4 = 
      scene_0.getDisplayerManager().createPartDisplayer("Threshold Geometry", -1, 1);

    partDisplayer_4.initialize();

    scene_0.setTransparencyOverrideMode(1);

    ThresholdPart thresholdPart_1 = 
      simulation_0.getPartManager().createThresholdPart(new NeoObjectVector(new Object[] {boundary_0, boundary_1, boundary_2, boundary_3, boundary_4}), new DoubleVector(new double[] {0.2, 0.2}), units_0, vectorComponentFieldFunction_0, 1);

    partDisplayer_4.getVisibleParts().addParts(thresholdPart_1);

    partDisplayer_4.getHiddenParts().addParts();

    PartDisplayer partDisplayer_5 = 
      scene_0.getDisplayerManager().createPartDisplayer("Threshold Geometry", -1, 1);

    partDisplayer_5.initialize();

    scene_0.setTransparencyOverrideMode(1);

    ThresholdPart thresholdPart_2 = 
      simulation_0.getPartManager().createThresholdPart(new NeoObjectVector(new Object[] {boundary_0, boundary_1, boundary_2, boundary_3, boundary_4}), new DoubleVector(new double[] {0.3, 0.3}), units_0, vectorComponentFieldFunction_0, 1);

    partDisplayer_5.getVisibleParts().addParts(thresholdPart_2);

    partDisplayer_5.getHiddenParts().addParts();

    PartDisplayer partDisplayer_6 = 
      scene_0.getDisplayerManager().createPartDisplayer("Threshold Geometry", -1, 1);

    partDisplayer_6.initialize();

    scene_0.setTransparencyOverrideMode(1);

    ThresholdPart thresholdPart_3 = 
      simulation_0.getPartManager().createThresholdPart(new NeoObjectVector(new Object[] {boundary_0, boundary_1, boundary_2, boundary_3, boundary_4}), new DoubleVector(new double[] {0.3, 0.3}), units_0, vectorComponentFieldFunction_0, 2);

    partDisplayer_6.getVisibleParts().addParts(thresholdPart_3);

    partDisplayer_6.getHiddenParts().addParts();

    scene_0.setTransparencyOverrideMode(0);

    hardcopyProperties_0.setCurrentResolutionWidth(1396);

    simulation_0.getPartManager().removeObjects(thresholdPart_0, thresholdPart_1);

    scene_0.setTransparencyOverrideMode(1);

    scene_0.getCreatorGroup().setObjects(region_0);

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("Right Wing Mirror 2.Wing Mirror 2");

    Boundary boundary_6 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Front Wheels 2 2.Front Wheels.Front Wheels");

    Boundary boundary_7 = 
      region_0.getBoundaryManager().getBoundary("Subtract.NL 2.Full Car.NL");

    Boundary boundary_8 = 
      region_0.getBoundaryManager().getBoundary("Subtract.NL 2.Gap Closure Faces");

    Boundary boundary_9 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Rear Wheels 2 2.Rear Wheels.Rear Wheels");

    scene_0.getCreatorGroup().setObjects(boundary_5, boundary_6, boundary_7, boundary_8, boundary_9);

    PartDisplayer partDisplayer_7 = 
      scene_0.getDisplayerManager().createPartDisplayer("Threshold Geometry", -1, 1);

    partDisplayer_7.initialize();

    scene_0.setTransparencyOverrideMode(1);

    ThresholdPart thresholdPart_4 = 
      simulation_0.getPartManager().createThresholdPart(new NeoObjectVector(new Object[] {boundary_5, boundary_6, boundary_7, boundary_8, boundary_9}), new DoubleVector(new double[] {0.3, 0.3}), units_0, vectorComponentFieldFunction_0, 1);

    partDisplayer_7.getVisibleParts().addParts(thresholdPart_4);

    partDisplayer_7.getHiddenParts().addParts();

    PartDisplayer partDisplayer_8 = 
      scene_0.getDisplayerManager().createPartDisplayer("Threshold Geometry", -1, 1);

    partDisplayer_8.initialize();

    scene_0.setTransparencyOverrideMode(1);

    ThresholdPart thresholdPart_5 = 
      simulation_0.getPartManager().createThresholdPart(new NeoObjectVector(new Object[] {boundary_5, boundary_6, boundary_7, boundary_8, boundary_9}), new DoubleVector(new double[] {0.3, 0.3}), units_0, vectorComponentFieldFunction_0, 2);

    partDisplayer_8.getVisibleParts().addParts(thresholdPart_5);

    partDisplayer_8.getHiddenParts().addParts();

    scene_0.setTransparencyOverrideMode(0);

    scene_0.setTransparencyOverrideMode(1);

    PartDisplayer partDisplayer_9 = 
      ((PartDisplayer) scene_0.getCreatorDisplayer());

    partDisplayer_9.initialize();

    scene_0.getCreatorGroup().setObjects(region_0);

    scene_0.getCreatorGroup().setObjects(thresholdPart_4);

    PartDisplayer partDisplayer_10 = 
      scene_0.getDisplayerManager().createPartDisplayer("Section Geometry", -1, 1);

    partDisplayer_10.initialize();

    scene_0.setTransparencyOverrideMode(1);

    PlaneSection planeSection_0 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}));

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    planeSection_0.setCoordinateSystem(labCoordinateSystem_0);

    planeSection_0.getInputParts().setObjects(thresholdPart_4);

    Coordinate coordinate_0 = 
      planeSection_0.getOriginCoordinate();

    coordinate_0.setValue(new DoubleVector(new double[] {0.0, 0.001, 0.0}));

    coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.001, 0.0}));

    coordinate_0.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_1 = 
      planeSection_0.getOrientationCoordinate();

    coordinate_1.setValue(new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    coordinate_1.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 1.0, 0.0}));

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

    partDisplayer_10.getVisibleParts().addParts(planeSection_0);

    partDisplayer_10.getHiddenParts().addParts();

    scene_0.setTransparencyOverrideMode(0);

    CurrentView currentView_0 = 
      scene_0.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {-0.6172395912906463, -1.4700242914672126, 0.6086729940326854}), new DoubleVector(new double[] {-6.207603566305381, 14.364737409523556, 2.2539029105754356}), new DoubleVector(new double[] {0.016665584911917667, -0.09750632607105324, 0.9950953595790049}), 1.0, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.8310275146094988, -0.1068492073355447, 0.7285631393877587}), new DoubleVector(new double[] {-5.463212113769467, 13.013859857498504, 2.0918032996970846}), new DoubleVector(new double[] {0.01666558491191767, -0.09750632607105325, 0.995095359579005}), 1.0, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.6166805391814361, -0.032132358820385676, 0.716756981379375}), new DoubleVector(new double[] {-4.793259806487145, 11.798070060675958, 1.9459136499065688}), new DoubleVector(new double[] {0.01666558491191767, -0.09750632607105325, 0.995095359579005}), 1.0, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.22934110468961233, 0.09806705942385996, 0.6950600720048767}), new DoubleVector(new double[] {-3.587345653378965, 9.609648426395372, 1.6833122802836404}), new DoubleVector(new double[] {0.01666558491191767, -0.09750632607105325, 0.995095359579005}), 1.0, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.07501496609437863, 0.15187362450849484, 0.6865607223462101}), new DoubleVector(new double[] {-3.1049799921356933, 8.734279772683138, 1.578271732434469}), new DoubleVector(new double[] {0.01666567390661903, -0.09750657814943403, 0.9950953333881265}), 1.0, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.06387731943445374, 0.2003030431505035, 0.6789116723488464}), new DoubleVector(new double[] {-2.6708508970167486, 7.946447984342127, 1.4837352393702148}), new DoubleVector(new double[] {0.01666567390661903, -0.09750657814943403, 0.9950953333881265}), 1.0, 0);

    currentView_0.setInput(new DoubleVector(new double[] {3.795623100235346E-4, 0.464301970236173, 0.7178213226635134}), new DoubleVector(new double[] {0.4391533334463443, 8.73227822454474, 2.874518586395845}), new DoubleVector(new double[] {0.03970358529514982, -0.25407177615791715, 0.9663700936363212}), 1.0, 0);

    currentView_0.setInput(new DoubleVector(new double[] {3.795623100235346E-4, 0.464301970236173, 0.7178213226635134}), new DoubleVector(new double[] {0.4391533334463443, 8.73227822454474, 2.874518586395845}), new DoubleVector(new double[] {0.039698015892469345, -0.2541767283806534, 0.9663427229942329}), 1.0, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.026945666471551947, 0.005992940893713251, 0.6759621010152319}), new DoubleVector(new double[] {0.5071022715230327, 9.125644757072315, 1.7593760363310817}), new DoubleVector(new double[] {0.047191474643202766, -0.12007512238580677, 0.9916425412945096}), 1.0, 0);

    scene_0.setTransparencyOverrideMode(1);

    scene_0.getCreatorGroup().setObjects(region_0);

    scene_0.getCreatorGroup().setObjects(thresholdPart_5);

    PartDisplayer partDisplayer_11 = 
      scene_0.getDisplayerManager().createPartDisplayer("Section Geometry", -1, 1);

    partDisplayer_11.initialize();

    scene_0.setTransparencyOverrideMode(1);

    PlaneSection planeSection_1 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}));

    planeSection_1.setCoordinateSystem(labCoordinateSystem_0);

    planeSection_1.getInputParts().setObjects(thresholdPart_5);

    Coordinate coordinate_2 = 
      planeSection_1.getOriginCoordinate();

    coordinate_2.setValue(new DoubleVector(new double[] {0.0, 0.001, 0.0}));

    coordinate_2.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.001, 0.0}));

    coordinate_2.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_3 = 
      planeSection_1.getOrientationCoordinate();

    coordinate_3.setValue(new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    coordinate_3.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    coordinate_3.setCoordinateSystem(labCoordinateSystem_0);

    SingleValue singleValue_1 = 
      planeSection_1.getSingleValue();

    singleValue_1.getValueQuantity().setValue(0.0);

    singleValue_1.getValueQuantity().setUnits(units_0);

    RangeMultiValue rangeMultiValue_1 = 
      planeSection_1.getRangeMultiValue();

    rangeMultiValue_1.setNValues(2);

    rangeMultiValue_1.getStartQuantity().setValue(0.0);

    rangeMultiValue_1.getStartQuantity().setUnits(units_0);

    rangeMultiValue_1.getEndQuantity().setValue(1.0);

    rangeMultiValue_1.getEndQuantity().setUnits(units_0);

    DeltaMultiValue deltaMultiValue_1 = 
      planeSection_1.getDeltaMultiValue();

    deltaMultiValue_1.setNValues(2);

    deltaMultiValue_1.getStartQuantity().setValue(0.0);

    deltaMultiValue_1.getStartQuantity().setUnits(units_0);

    deltaMultiValue_1.getDeltaQuantity().setValue(1.0);

    deltaMultiValue_1.getDeltaQuantity().setUnits(units_0);

    MultiValue multiValue_1 = 
      planeSection_1.getArbitraryMultiValue();

    multiValue_1.getValueQuantities().setUnits(units_0);

    multiValue_1.getValueQuantities().setArray(new DoubleVector(new double[] {0.0}));

    planeSection_1.setValueMode(0);

    partDisplayer_11.getVisibleParts().addParts(planeSection_1);

    partDisplayer_11.getHiddenParts().addParts();

    scene_0.getCreatorGroup().setObjects(thresholdPart_2);

    PartDisplayer partDisplayer_12 = 
      scene_0.getDisplayerManager().createPartDisplayer("Section Geometry", -1, 1);

    partDisplayer_12.initialize();

    scene_0.setTransparencyOverrideMode(1);

    PlaneSection planeSection_2 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}));

    planeSection_2.setCoordinateSystem(labCoordinateSystem_0);

    planeSection_2.getInputParts().setObjects(thresholdPart_2);

    Coordinate coordinate_4 = 
      planeSection_2.getOriginCoordinate();

    coordinate_4.setValue(new DoubleVector(new double[] {0.0, 0.001, 0.0}));

    coordinate_4.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.001, 0.0}));

    coordinate_4.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_5 = 
      planeSection_2.getOrientationCoordinate();

    coordinate_5.setValue(new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    coordinate_5.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    coordinate_5.setCoordinateSystem(labCoordinateSystem_0);

    SingleValue singleValue_2 = 
      planeSection_2.getSingleValue();

    singleValue_2.getValueQuantity().setValue(0.0);

    singleValue_2.getValueQuantity().setUnits(units_0);

    RangeMultiValue rangeMultiValue_2 = 
      planeSection_2.getRangeMultiValue();

    rangeMultiValue_2.setNValues(2);

    rangeMultiValue_2.getStartQuantity().setValue(0.0);

    rangeMultiValue_2.getStartQuantity().setUnits(units_0);

    rangeMultiValue_2.getEndQuantity().setValue(1.0);

    rangeMultiValue_2.getEndQuantity().setUnits(units_0);

    DeltaMultiValue deltaMultiValue_2 = 
      planeSection_2.getDeltaMultiValue();

    deltaMultiValue_2.setNValues(2);

    deltaMultiValue_2.getStartQuantity().setValue(0.0);

    deltaMultiValue_2.getStartQuantity().setUnits(units_0);

    deltaMultiValue_2.getDeltaQuantity().setValue(1.0);

    deltaMultiValue_2.getDeltaQuantity().setUnits(units_0);

    MultiValue multiValue_2 = 
      planeSection_2.getArbitraryMultiValue();

    multiValue_2.getValueQuantities().setUnits(units_0);

    multiValue_2.getValueQuantities().setArray(new DoubleVector(new double[] {0.0}));

    planeSection_2.setValueMode(0);

    partDisplayer_12.getVisibleParts().addParts(planeSection_1, planeSection_2);

    partDisplayer_12.getHiddenParts().addParts();

    scene_0.getCreatorGroup().setObjects(thresholdPart_3);

    PartDisplayer partDisplayer_13 = 
      scene_0.getDisplayerManager().createPartDisplayer("Section Geometry", -1, 1);

    partDisplayer_13.initialize();

    scene_0.setTransparencyOverrideMode(1);

    PlaneSection planeSection_3 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}));

    planeSection_3.setCoordinateSystem(labCoordinateSystem_0);

    planeSection_3.getInputParts().setObjects(thresholdPart_3);

    Coordinate coordinate_6 = 
      planeSection_3.getOriginCoordinate();

    coordinate_6.setValue(new DoubleVector(new double[] {0.0, 0.001, 0.0}));

    coordinate_6.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.001, 0.0}));

    coordinate_6.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_7 = 
      planeSection_3.getOrientationCoordinate();

    coordinate_7.setValue(new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    coordinate_7.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    coordinate_7.setCoordinateSystem(labCoordinateSystem_0);

    SingleValue singleValue_3 = 
      planeSection_3.getSingleValue();

    singleValue_3.getValueQuantity().setValue(0.0);

    singleValue_3.getValueQuantity().setUnits(units_0);

    RangeMultiValue rangeMultiValue_3 = 
      planeSection_3.getRangeMultiValue();

    rangeMultiValue_3.setNValues(2);

    rangeMultiValue_3.getStartQuantity().setValue(0.0);

    rangeMultiValue_3.getStartQuantity().setUnits(units_0);

    rangeMultiValue_3.getEndQuantity().setValue(1.0);

    rangeMultiValue_3.getEndQuantity().setUnits(units_0);

    DeltaMultiValue deltaMultiValue_3 = 
      planeSection_3.getDeltaMultiValue();

    deltaMultiValue_3.setNValues(2);

    deltaMultiValue_3.getStartQuantity().setValue(0.0);

    deltaMultiValue_3.getStartQuantity().setUnits(units_0);

    deltaMultiValue_3.getDeltaQuantity().setValue(1.0);

    deltaMultiValue_3.getDeltaQuantity().setUnits(units_0);

    MultiValue multiValue_3 = 
      planeSection_3.getArbitraryMultiValue();

    multiValue_3.getValueQuantities().setUnits(units_0);

    multiValue_3.getValueQuantities().setArray(new DoubleVector(new double[] {0.0}));

    planeSection_3.setValueMode(0);

    scene_0.setTransparencyOverrideMode(0);

    partDisplayer_13.getVisibleParts().addParts(planeSection_1, planeSection_2, planeSection_3);

    partDisplayer_13.getHiddenParts().addParts();

    XYPlot xYPlot_0 = 
      simulation_0.getPlotManager().createPlot(XYPlot.class);

    xYPlot_0.open();

    hardcopyProperties_0.setCurrentResolutionWidth(1398);

    hardcopyProperties_0.setCurrentResolutionHeight(717);

    PlotUpdate plotUpdate_0 = 
      xYPlot_0.getPlotUpdate();

    HardcopyProperties hardcopyProperties_1 = 
      plotUpdate_0.getHardcopyProperties();

    hardcopyProperties_1.setCurrentResolutionWidth(1396);

    hardcopyProperties_1.setCurrentResolutionHeight(716);

    xYPlot_0.getParts().setObjects(planeSection_0);

    YAxisType yAxisType_0 = 
      ((YAxisType) xYPlot_0.getYAxes().getAxisType("Y Type 1"));

    FieldFunctionUnits fieldFunctionUnits_0 = 
      yAxisType_0.getScalarFunction();

    PressureCoefficientFunction pressureCoefficientFunction_0 = 
      ((PressureCoefficientFunction) simulation_0.getFieldFunctionManager().getFunction("PressureCoefficient"));

    fieldFunctionUnits_0.setFieldFunction(pressureCoefficientFunction_0);

    hardcopyProperties_0.setCurrentResolutionWidth(1396);

    hardcopyProperties_0.setCurrentResolutionHeight(716);

    xYPlot_0.export(resolvePath("C:\\Users\\Windtunnel\\Desktop\\trailing upper cp.csv"), ",");

    xYPlot_0.getParts().setObjects(planeSection_1);

    xYPlot_0.export(resolvePath("C:\\Users\\Windtunnel\\Desktop\\trailing lower cp.csv"), ",");

    xYPlot_0.getParts().setObjects(planeSection_2);

    xYPlot_0.export(resolvePath("C:\\Users\\Windtunnel\\Desktop\\leading upper cp.csv"), ",");

    xYPlot_0.getParts().setObjects(planeSection_3);
  }

  private void execute1() {

    Simulation simulation_0 = 
      getActiveSimulation();

    XYPlot xYPlot_0 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("XY Plot 1"));

    xYPlot_0.export(resolvePath("C:\\Users\\Windtunnel\\Desktop\\leading lower cp.csv"), ",");
  }
}
