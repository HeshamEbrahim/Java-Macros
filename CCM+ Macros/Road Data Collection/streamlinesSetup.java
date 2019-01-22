// Written by Hesham Ebrahim
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class streamlinesSetup extends simSetup {

  public void execute() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    Scene scene_4 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    scene_4.setTransparencyOverrideMode(1);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("WT");

    scene_4.getCreatorGroup().setObjects(region_0);

    PlaneSection planeSection_1 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("1.111m"));

    scene_4.getCreatorGroup().setObjects(planeSection_1);

    StreamDisplayer streamDisplayer_2 = 
      scene_4.getDisplayerManager().createStreamDisplayer("Streamline Stream");

    streamDisplayer_2.initialize();

    scene_4.setTransparencyOverrideMode(1);

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    ConstrainedStreamPart constrainedStreamPart_1 = 
      simulation_0.getPartManager().createConstrainedStreamPart(new NeoObjectVector(new Object[] {planeSection_1}), new NeoObjectVector(new Object[] {planeSection_1}), primitiveFieldFunction_0, 10, 10, 2);

    streamDisplayer_2.getVisibleParts().addParts(constrainedStreamPart_1);

    streamDisplayer_2.getHiddenParts().addParts();

    scene_4.setTransparencyOverrideMode(0);

    SourceSeed sourceSeed_1 = 
      constrainedStreamPart_1.getSourceSeed();

    sourceSeed_1.setRandom(true);

    RK2 rK2_1 = 
      constrainedStreamPart_1.getSecondOrderIntegrator();

    rK2_1.setInitialIntegrationStep(0.05);

    Legend legend_3 = 
      streamDisplayer_2.getLegend();

    legend_3.setVisible(false);

    streamDisplayer_2.setColorMode(1);

    streamDisplayer_2.setOpacity(0.3);

    streamDisplayer_2.setDisplayerColor(new DoubleVector(new double[] {0.0, 0.0, 0.0}));

    SymmetricRepeat symmetricRepeat_0 = 
      ((SymmetricRepeat) simulation_0.getTransformManager().getObject("Subtract.WT.symmetry 1"));

    streamDisplayer_2.setVisTransform(symmetricRepeat_0);
  }
}
