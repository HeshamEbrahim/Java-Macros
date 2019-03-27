// STAR-CCM+ macro: Pressure.java
// Written by STAR-CCM+ 11.04.012
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.flow.*;

public class Pressure extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("Mesh Scene 1");

    CurrentView currentView_0 = 
      scene_1.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {-0.41025902063662023, 0.32412617796939214, -0.2101141149309764}), new DoubleVector(new double[] {1.2053509991276457, -2.0687073734443615, 1.1673758138751251}), new DoubleVector(new double[] {-0.24248313895553064, 0.35584569701250507, 0.9025385128846067}), 1.0, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.30442408495154194, 0.3787428361910241, -0.1612533315805962}), new DoubleVector(new double[] {1.2941976032258902, -1.9889297857247503, 1.2017521267271754}), new DoubleVector(new double[] {-0.24248313895553064, 0.35584569701250507, 0.9025385128846067}), 1.0, 0);

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    scene_1.setTransparencyOverrideMode(1);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Wind Tunnel");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Ahmed Body.Follower.EdgeFillet.4");

    scene_1.getCreatorGroup().setObjects(boundary_0);

    PartDisplayer partDisplayer_5 = 
      scene_1.getDisplayerManager().createPartDisplayer("Threshold Geometry", -1, 1);

    partDisplayer_5.initialize();

    scene_1.setTransparencyOverrideMode(1);

    PrimitiveFieldFunction primitiveFieldFunction_1 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Position"));

    VectorComponentFieldFunction vectorComponentFieldFunction_0 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_1.getComponentFunction(2));

    ThresholdPart thresholdPart_0 = 
      simulation_0.getPartManager().createThresholdPart(new NeoObjectVector(new Object[] {boundary_0}), new DoubleVector(new double[] {0.15, 0.15}), units_0, vectorComponentFieldFunction_0, 1);

    partDisplayer_5.getVisibleParts().addParts(thresholdPart_0);

    partDisplayer_5.getHiddenParts().addParts();

    PartDisplayer partDisplayer_6 = 
      scene_1.getDisplayerManager().createPartDisplayer("Threshold Geometry", -1, 1);

    partDisplayer_6.initialize();

    scene_1.setTransparencyOverrideMode(1);

    ThresholdPart thresholdPart_1 = 
      simulation_0.getPartManager().createThresholdPart(new NeoObjectVector(new Object[] {boundary_0}), new DoubleVector(new double[] {0.15, 0.15}), units_0, vectorComponentFieldFunction_0, 2);

    partDisplayer_6.getVisibleParts().addParts(thresholdPart_1);

    partDisplayer_6.getHiddenParts().addParts();

    scene_1.setTransparencyOverrideMode(0);

    scene_1.setTransparencyOverrideMode(1);

    scene_1.getCreatorGroup().setObjects(region_0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.3991010195860536, 0.48342717884994324, -0.25557060244880114}), new DoubleVector(new double[] {1.2837283653793157, -2.0089630418034603, 1.1792314236162476}), new DoubleVector(new double[] {-0.2424831389555307, 0.3558456970125052, 0.9025385128846066}), 1.0, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.5166512332354525, 0.5678989348635411, -0.2783594292788203}), new DoubleVector(new double[] {1.233028696484596, -2.0235017056699167, 1.213440232978289}), new DoubleVector(new double[] {-0.24248313895553064, 0.35584569701250507, 0.9025385128846066}), 1.0, 0);

    scene_1.setViewOrientation(new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    currentView_0.setInput(new DoubleVector(new double[] {-0.3807267035242743, 0.12527290221432064, -0.3096003427870384}), new DoubleVector(new double[] {-0.3807267035242743, 0.12527290221432064, 3.1860602001155165}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 1.0, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.2474254014672319, 0.03160171698504774, -0.42744503225856834}), new DoubleVector(new double[] {-0.2474254014672319, 0.03160171698504774, 3.1860602001155165}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 1.0, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.2474254014672319, 0.03160171698504774, -0.42744503225856834}), new DoubleVector(new double[] {-0.2474254014672319, 0.03160171698504774, 3.1860602001155165}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 0.9433141570980439, 1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.2825254631266939, -0.0930035019060427, -0.4865327532881163}), new DoubleVector(new double[] {-0.2825254631266939, -0.0930035019060427, 3.1860602001155165}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 0.9433141570980439, 1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.3111320133791555, -0.05079567776053953, -0.5217589048347842}), new DoubleVector(new double[] {-0.3111320133791555, -0.05079567776053953, 3.1860602001155165}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 0.849977931461758, 1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.38751142563888186, 0.05381090859517268, -0.546810870788422}), new DoubleVector(new double[] {-0.38751142563888186, 0.05381090859517268, 3.1860602001155165}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 0.5974242731746112, 1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.42018914402275825, 0.09571396924388494, -0.5562544481007654}), new DoubleVector(new double[] {-0.42018914402275825, 0.09571396924388494, 3.1860602001155165}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 0.4783161639551544, 1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.4284651260223544, 0.09789420106098286, -0.5572329296216605}), new DoubleVector(new double[] {-0.4284651260223544, 0.09789420106098286, 3.1860602001155165}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 0.4304984395454678, 1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.43591375018565276, 0.09945600935328734, -0.5580065166837915}), new DoubleVector(new double[] {-0.43591375018565276, 0.09945600935328734, 3.1860602001155165}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 0.38745847859903665, 1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.4426176829316454, 0.10078958737265147, -0.5586304004954341}), new DoubleVector(new double[] {-0.4426176829316454, 0.10078958737265147, 3.1860602001155165}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 0.3487198031633674, 1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.43029084337796364, 0.06640419282817063, -0.5594526130493032}), new DoubleVector(new double[] {-0.43029084337796364, 0.06640419282817063, 3.1860602001155165}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 0.3487198031633674, 1);

    PartDisplayer partDisplayer_7 = 
      scene_1.getDisplayerManager().createPartDisplayer("Section Geometry", -1, 1);

    partDisplayer_7.initialize();

    scene_1.setTransparencyOverrideMode(1);

    PlaneSection planeSection_1 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}));

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    planeSection_1.setCoordinateSystem(labCoordinateSystem_0);

    planeSection_1.getInputParts().setObjects(region_0);

    Coordinate coordinate_9 = 
      planeSection_1.getOriginCoordinate();

    coordinate_9.setValue(new DoubleVector(new double[] {0.0, 0.05, 0.0}));

    coordinate_9.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.05, 0.0}));

    coordinate_9.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_10 = 
      planeSection_1.getOrientationCoordinate();

    coordinate_10.setValue(new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    coordinate_10.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    coordinate_10.setCoordinateSystem(labCoordinateSystem_0);

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

    partDisplayer_7.getVisibleParts().addParts(planeSection_1);

    partDisplayer_7.getHiddenParts().addParts();

    currentView_0.setInput(new DoubleVector(new double[] {-0.43002325718262296, 0.0633264359671537, -0.5313979873159882}), new DoubleVector(new double[] {-0.34589769716063656, -0.904279606693705, 3.1598196866529262}), new DoubleVector(new double[] {0.002840341380847124, 0.9673306103069893, 0.25350231325167}), 0.3487198031633674, 1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.42025023002527834, 0.09853422850692573, -0.5250957224712169}), new DoubleVector(new double[] {-0.32052998054464177, -1.0484407924961376, 3.8503776442358135}), new DoubleVector(new double[] {0.0028403413808471244, 0.9673306103069894, 0.25350231325167005}), 0.3487198031633674, 1);

    scene_1.getCreatorGroup().setObjects(thresholdPart_0);

    PartDisplayer partDisplayer_8 = 
      scene_1.getDisplayerManager().createPartDisplayer("Section Geometry", -1, 1);

    partDisplayer_8.initialize();

    scene_1.setTransparencyOverrideMode(1);

    PlaneSection planeSection_2 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}));

    planeSection_2.setCoordinateSystem(labCoordinateSystem_0);

    planeSection_2.getInputParts().setObjects(thresholdPart_0);

    Coordinate coordinate_11 = 
      planeSection_2.getOriginCoordinate();

    coordinate_11.setValue(new DoubleVector(new double[] {0.0, 0.05, 0.0}));

    coordinate_11.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.05, 0.0}));

    coordinate_11.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_12 = 
      planeSection_2.getOrientationCoordinate();

    coordinate_12.setValue(new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    coordinate_12.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    coordinate_12.setCoordinateSystem(labCoordinateSystem_0);

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

    partDisplayer_8.getVisibleParts().addParts(planeSection_1, planeSection_2);

    partDisplayer_8.getHiddenParts().addParts();

    scene_1.setTransparencyOverrideMode(0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.41885808246374223, 0.06329611306680066, -0.4618202038679043}), new DoubleVector(new double[] {-0.35503681225642697, -3.2568234671937657, 2.6332869774500085}), new DoubleVector(new double[] {0.013300007444948152, 0.6819677717826075, 0.7312612857603151}), 0.3487198031633674, 1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.4087166696769145, 0.22601628046009603, -0.2961354291980933}), new DoubleVector(new double[] {-0.34481242563110287, -3.098419777127641, 2.802995691514278}), new DoubleVector(new double[] {0.013300007444948156, 0.6819677717826076, 0.7312612857603152}), 0.3487198031633674, 1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.4084162332252112, 0.2164009064473663, -0.28829033942610427}), new DoubleVector(new double[] {-0.18757284207918412, -3.7227187212153767, 1.9794688509548943}), new DoubleVector(new double[] {0.0204436281203775, 0.4996917591596736, 0.8659620106547323}), 0.3487198031633674, 1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.3888087956426265, 0.22479742406854225, -0.28531959436313936}), new DoubleVector(new double[] {-0.16773070131134177, -3.718508536356642, 1.9848496763133014}), new DoubleVector(new double[] {0.020443628120377498, 0.4996917591596735, 0.8659620106547321}), 0.3835581264140186, 1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.3669824407979999, 0.2294286274131503, -0.2794006864688914}), new DoubleVector(new double[] {-0.14590434646671518, -3.713877333012034, 1.9907685842075493}), new DoubleVector(new double[] {0.0204436281203775, 0.49969175915967357, 0.8659620106547322}), 0.42187769656232804, 1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.34297345046891065, 0.23452295109221927, -0.2728898877852187}), new DoubleVector(new double[] {-0.12189535613762595, -3.708783009332965, 1.997279382891222}), new DoubleVector(new double[] {0.0204436281203775, 0.49969175915967357, 0.8659620106547322}), 0.4640266370376558, 1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.2901536717449143, 0.24573046318617103, -0.2585661306811388}), new DoubleVector(new double[] {-0.06907557741362962, -3.697575497239013, 2.011603139995302}), new DoubleVector(new double[] {0.020444027700015608, 0.49968463200265534, 0.8659661138126431}), 0.5567625189397694, 1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.28843684819412535, 0.3118019291531775, -0.16754590921153856}), new DoubleVector(new double[] {-0.06678849539906244, -3.6416755663849787, 2.1084791349404624}), new DoubleVector(new double[] {0.02044402770001561, 0.49968463200265545, 0.8659661138126433}), 0.5567625189397694, 1);

    simulation_0.getPartManager().removeObjects(planeSection_1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.412613764156136, 0.3773976007029958, -0.06131736204484323}), new DoubleVector(new double[] {-0.19048644395529685, -3.584623097777812, 2.2196260214366963}), new DoubleVector(new double[] {0.020444027700015608, 0.49968463200265545, 0.8659661138126432}), 0.5567625189397694, 1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.4127860282068386, 0.3731222502150962, -0.05757639926898227}), new DoubleVector(new double[] {0.6685608376233577, -4.084403873225022, -0.07400906090295538}), new DoubleVector(new double[] {0.09473694490062956, 0.019432369138630612, 0.9953126615795435}), 0.5567625189397694, 1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.5775644930294629, 0.3366628849635761, 0.12325306495360167}), new DoubleVector(new double[] {0.5047401866887312, -4.12481153717889, 0.10680584792392053}), new DoubleVector(new double[] {0.09473694490062959, 0.019432369138630615, 0.9953126615795437}), 0.5567625189397694, 1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.5804488561553084, 0.338801499340497, 0.12313967519820329}), new DoubleVector(new double[] {3.3512391562680097, -2.031230345970708, 0.2864145519598159}), new DoubleVector(new double[] {0.026505058406192727, 0.11241513781371681, 0.9933077663389165}), 0.5567625189397694, 1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.4612269471140251, 0.23140183231820188, 0.13628312293390396}), new DoubleVector(new double[] {3.3352994443073607, -2.0571542333720707, 0.29394501694046105}), new DoubleVector(new double[] {0.026505058406192727, 0.11241513781371681, 0.9933077663389165}), 0.5567625189397694, 1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.6218684149252497, 0.3276179800253687, 0.1313617044344321}), new DoubleVector(new double[] {2.913361207173871, -2.2805009549810125, 1.6266386527573342}), new DoubleVector(new double[] {-0.20293381780120756, 0.26530081531238725, 0.9425674209239403}), 0.5567625189397694, 1);

    scene_1.setTransparencyOverrideMode(1);

    scene_1.getCreatorGroup().setObjects(region_0);

    scene_1.getCreatorGroup().setObjects(thresholdPart_1);

    PartDisplayer partDisplayer_9 = 
      scene_1.getDisplayerManager().createPartDisplayer("Section Geometry", -1, 1);

    partDisplayer_9.initialize();

    scene_1.setTransparencyOverrideMode(1);

    PlaneSection planeSection_3 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}));

    planeSection_3.setCoordinateSystem(labCoordinateSystem_0);

    planeSection_3.getInputParts().setObjects(thresholdPart_1);

    Coordinate coordinate_13 = 
      planeSection_3.getOriginCoordinate();

    coordinate_13.setValue(new DoubleVector(new double[] {0.0, 0.05, 0.0}));

    coordinate_13.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.05, 0.0}));

    coordinate_13.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_14 = 
      planeSection_3.getOrientationCoordinate();

    coordinate_14.setValue(new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    coordinate_14.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    coordinate_14.setCoordinateSystem(labCoordinateSystem_0);

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

    partDisplayer_9.getVisibleParts().addParts(planeSection_3);

    partDisplayer_9.getHiddenParts().addParts();

    scene_1.setTransparencyOverrideMode(0);

    XYPlot xYPlot_0 = 
      simulation_0.getPlotManager().createPlot(XYPlot.class);

    xYPlot_0.open();

    PlotUpdate plotUpdate_0 = 
      xYPlot_0.getPlotUpdate();

    HardcopyProperties hardcopyProperties_0 = 
      plotUpdate_0.getHardcopyProperties();

    hardcopyProperties_0.setCurrentResolutionWidth(1396);

    hardcopyProperties_0.setCurrentResolutionHeight(1075);

    xYPlot_0.getParts().setObjects(planeSection_3, planeSection_2);

    YAxisType yAxisType_0 = 
      ((YAxisType) xYPlot_0.getYAxes().getAxisType("Y Type 1"));

    FieldFunctionUnits fieldFunctionUnits_0 = 
      yAxisType_0.getScalarFunction();

    PressureCoefficientFunction pressureCoefficientFunction_0 = 
      ((PressureCoefficientFunction) simulation_0.getFieldFunctionManager().getFunction("PressureCoefficient"));

    fieldFunctionUnits_0.setFieldFunction(pressureCoefficientFunction_0);

    xYPlot_0.export(resolvePath("C:\\Users\\Windtunnel\\Desktop\\Cp.csv"), ",");
  }
}
