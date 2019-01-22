// Written by Hesham Ebrahim
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class scalarSceneSetup extends simSetup {

  public void execute() {

    Simulation simulation_0 = 
      getActiveSimulation();

    simulation_0.getSceneManager().createScalarScene("Scalar Scene", "Outline", "Scalar");

    Scene scene_4 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    scene_4.initializeAndWait();

    PartDisplayer partDisplayer_5 = 
      ((PartDisplayer) scene_4.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_5.initialize();

    ScalarDisplayer scalarDisplayer_3 = 
      ((ScalarDisplayer) scene_4.getDisplayerManager().getDisplayer("Scalar 1"));

    scalarDisplayer_3.initialize();

    scene_4.open(true);

    ResidualPlot residualPlot_0 = 
      ((ResidualPlot) simulation_0.getPlotManager().getPlot("Residuals"));

    PlotUpdate plotUpdate_0 = 
      residualPlot_0.getPlotUpdate();

    HardcopyProperties hardcopyProperties_1 = 
      plotUpdate_0.getHardcopyProperties();

    hardcopyProperties_1.setCurrentResolutionWidth(1001);

    hardcopyProperties_1.setCurrentResolutionHeight(614);

    SceneUpdate sceneUpdate_2 = 
      scene_4.getSceneUpdate();

    HardcopyProperties hardcopyProperties_3 = 
      sceneUpdate_2.getHardcopyProperties();

    hardcopyProperties_3.setCurrentResolutionWidth(999);

    hardcopyProperties_3.setCurrentResolutionHeight(613);

    scene_4.resetCamera();

    scene_4.getDisplayerManager().deleteDisplayers(new NeoObjectVector(new Object[] {partDisplayer_5}));

    scalarDisplayer_3.getInputParts().setQuery(null);

    PlaneSection planeSection_1 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("1.111m"));

    scalarDisplayer_3.getInputParts().setObjects(planeSection_1);

    PartDisplayer partDisplayer_6 = 
      scene_4.getDisplayerManager().createPartDisplayer("Geometry", -1, 4);

    partDisplayer_6.initialize();

    partDisplayer_6.setOutline(false);

    partDisplayer_6.setSurface(true);

    partDisplayer_6.getInputParts().setQuery(null);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("WT");

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

    partDisplayer_6.getInputParts().setObjects(boundary_0, boundary_1, boundary_2, boundary_3, boundary_4);

    SymmetricRepeat symmetricRepeat_0 = 
      ((SymmetricRepeat) simulation_0.getTransformManager().getObject("Subtract.WT.symmetry 1"));

    partDisplayer_6.setVisTransform(symmetricRepeat_0);

    partDisplayer_6.setColorMode(1);

    scalarDisplayer_3.setVisTransform(symmetricRepeat_0);

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    VectorMagnitudeFieldFunction vectorMagnitudeFieldFunction_0 = 
      ((VectorMagnitudeFieldFunction) primitiveFieldFunction_0.getMagnitudeFunction());

    scalarDisplayer_3.getScalarDisplayQuantity().setFieldFunction(vectorMagnitudeFieldFunction_0);

    CurrentView currentView_1 = 
      scene_4.getCurrentView();

    currentView_1.setInput(new DoubleVector(new double[] {3.7879209258698134, 2.235528552150932, 3.9401980153126837}), new DoubleVector(new double[] {1.8035378211972517, 0.6185638526665573, 78.45368481026799}), new DoubleVector(new double[] {-3.3551652863319213E-4, 0.9997660542989978, 0.021626929973354678}), 19.15431674584153, 0);

    scene_4.setViewOrientation(new DoubleVector(new double[] {-1.0, 0.0, 0.0}), new DoubleVector(new double[] {0.0, 0.0, 1.0}));

    currentView_1.setInput(new DoubleVector(new double[] {3.7879209258698134, 2.235528552150932, 3.9401980153126837}), new DoubleVector(new double[] {-70.76952045651312, 2.235528552150932, 3.9401980153126837}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 19.463397850624286, 1);

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.0, 13.759800433102294}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.0, 15.0}));

    scalarDisplayer_3.getScalarDisplayQuantity().setClip(0);

    Legend legend_0 = 
      scalarDisplayer_3.getLegend();

    PredefinedLookupTable predefinedLookupTable_0 = 
      ((PredefinedLookupTable) simulation_0.get(LookupTableManager.class).getObject("blue-red balanced"));

    legend_0.setLookupTable(predefinedLookupTable_0);

    partDisplayer_6.setOpacity(1);

    currentView_1.setInput(new DoubleVector(new double[] {1.2705741334551703, 1.806889284641262, 3.727465934400477}), new DoubleVector(new double[] {-70.76952045651312, 1.806889284641262, 3.727465934400477}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 17.5218336689653, 1);

    currentView_1.setInput(new DoubleVector(new double[] {1.2705741334551703, 1.421113943882559, 3.536007061579491}), new DoubleVector(new double[] {-70.76952045651312, 1.421113943882559, 3.536007061579491}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 15.773867932920117, 1);

    currentView_1.setInput(new DoubleVector(new double[] {1.2705741334551703, 1.0739161371997263, 3.3636940760406033}), new DoubleVector(new double[] {-70.76952045651312, 1.0739161371997263, 3.3636940760406033}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 14.200218531709368, 1);

    currentView_1.setInput(new DoubleVector(new double[] {1.2087807760648417, 0.7079072419289134, 2.710437693342065}), new DoubleVector(new double[] {-70.76952045651312, 0.7079072419289134, 2.710437693342065}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 11.364979672942114, 1);

    currentView_1.setInput(new DoubleVector(new double[] {1.1792596814714926, 0.42980822872478347, 2.150531680091083}), new DoubleVector(new double[] {-70.76952045651312, 0.42980822872478347, 2.150531680091083}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 9.094666023565845, 1);

    currentView_1.setInput(new DoubleVector(new double[] {1.1792596814714926, 0.31856862344313147, 1.9265692747906902}), new DoubleVector(new double[] {-70.76952045651312, 0.31856862344313147, 1.9265692747906902}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 8.186119160792435, 1);

    currentView_1.setInput(new DoubleVector(new double[] {1.1365602436251123, 0.23710805756901415, 1.7543002092536226}), new DoubleVector(new double[] {-70.76952045651312, 0.23710805756901415, 1.7543002092536226}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 7.367826690221741, 1);

    currentView_1.setInput(new DoubleVector(new double[] {1.1365602436251123, 0.017164529708897397, 1.2891737323035402}), new DoubleVector(new double[] {-70.76952045651312, 0.017164529708897397, 1.2891737323035402}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 5.158524379385691, 1);

    currentView_1.setInput(new DoubleVector(new double[] {1.1365602436251123, -0.03415562679179651, 1.1806442210151875}), new DoubleVector(new double[] {-70.76952045651312, -0.03415562679179651, 1.1806442210151875}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 4.642861103613501, 1);

    currentView_1.setInput(new DoubleVector(new double[] {1.1192245383528814, -0.1265584089518043, 0.9882646581574667}), new DoubleVector(new double[] {-70.76952045651312, -0.1265584089518043, 0.9882646581574667}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 3.7144167624982054, 1);

    currentView_1.setInput(new DoubleVector(new double[] {1.1192245383528814, -0.16351952181580742, 0.9113128330143783}), new DoubleVector(new double[] {-70.76952045651312, -0.16351952181580742, 0.9113128330143783}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 3.3430189197607065, 1);

    currentView_1.setInput(new DoubleVector(new double[] {1.1192245383528814, -0.23004952497101303, 0.7727995477568192}), new DoubleVector(new double[] {-70.76952045651312, -0.23004952497101303, 0.7727995477568192}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 2.6744983452061915, 1);

    currentView_1.setInput(new DoubleVector(new double[] {1.1192245383528814, -0.25666152623309524, 0.7173942336537956}), new DoubleVector(new double[] {-70.76952045651312, -0.25666152623309524, 0.7173942336537956}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 2.407079063143642, 1);

    currentView_1.setInput(new DoubleVector(new double[] {1.1192245383528814, -0.28061232736896924, 0.6675294509610744}), new DoubleVector(new double[] {-70.76952045651312, -0.28061232736896924, 0.6675294509610744}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 2.166398468652859, 1);

    currentView_1.setInput(new DoubleVector(new double[] {1.1192245383528814, -0.3021680483912559, 0.6226511465376253}), new DoubleVector(new double[] {-70.76952045651312, -0.3021680483912559, 0.6226511465376253}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 1.9497830673341867, 1);

    currentView_1.setInput(new DoubleVector(new double[] {1.1192245383528814, -0.3215681973113138, 0.5822606725565211}), new DoubleVector(new double[] {-70.76952045651312, -0.3215681973113138, 0.5822606725565211}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 1.7548266631574376, 1);

    currentView_1.setInput(new DoubleVector(new double[] {1.1130453495694042, -0.1097294157882297, 0.754021846764427}), new DoubleVector(new double[] {-70.76952045651312, -0.1097294157882297, 0.754021846764427}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 1.7548266631574376, 1);

    scene_4.setAxesVisible(false);

    scene_4.setBackgroundColorMode(0);

    Coordinate coordinate_2 = 
      currentView_1.getFocalPointCoordinate();

    Units units_0 = 
      ((Units) simulation_0.getUnitsManager().getObject("m"));

    coordinate_2.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1.1130453495694042, 0.0, 0.754021846764427}));

    Coordinate coordinate_3 = 
      currentView_1.getPositionCoordinate();

    coordinate_3.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-70.76952045651312, 0.0, 0.754021846764427}));

    currentView_1.setInput(new DoubleVector(new double[] {1.1130453495694042, 0.0, 0.754021846764427}), new DoubleVector(new double[] {-70.76952045651312, 0.0, 0.754021846764427}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 1.9, 1);

    ParallelScale parallelScale_0 = 
      currentView_1.getParallelScale();

    parallelScale_0.setValue(1.9);

    currentView_1.setInput(new DoubleVector(new double[] {1.1130453495694042, 0.0, 0.754021846764427}), new DoubleVector(new double[] {-70.76952045651312, 0.0, 0.754021846764427}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 1.4, 1);

    parallelScale_0.setValue(1.4);

    legend_0.setLevels(100);

    scalarDisplayer_3.setFillMode(1);

    legend_0.setPositionCoordinate(new DoubleVector(new double[] {0.22, 0.05}));

    legend_0.setPositionCoordinate(new DoubleVector(new double[] {0.21, 0.05}));

    legend_0.setPositionCoordinate(new DoubleVector(new double[] {0.21, 0.03}));

    currentView_1.setInput(new DoubleVector(new double[] {1.1130453495694042, 0.0, 0.5}), new DoubleVector(new double[] {-70.76952045651312, 0.0, 0.5}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 1.0, 1);

    parallelScale_0.setValue(1.0);

    coordinate_3.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-70.76952045651312, 0.0, 0.9}));

    coordinate_2.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1.1130453495694042, 0.0, 0.9}));

    coordinate_2.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1.1130453495694042, 0.0, 0.5}));

    coordinate_3.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-70.76952045651312, 0.0, 0.5}));

    scalarDisplayer_3.getScalarDisplayQuantity().setClip(3);

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.0, 13.7}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.0, 20.0}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.0, 13.7}));

    scalarDisplayer_3.getScalarDisplayQuantity().setClip(1);

    scalarDisplayer_3.getScalarDisplayQuantity().setClip(3);

    scene_4.setViewOrientation(new DoubleVector(new double[] {1.0, 0.0, 0.0}), new DoubleVector(new double[] {0.0, 0.0, 1.0}));

    scene_4.saveCurrentView();

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.0, 15.0}));

    scalarDisplayer_3.setOpacity(0.7);
  }
}
