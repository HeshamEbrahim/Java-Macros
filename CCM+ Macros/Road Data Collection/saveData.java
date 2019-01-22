// STAR-CCM+ macro: saveData.java
// Written by STAR-CCM+ 11.04.012
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.flow.*;

public class saveData extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_4 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    // scene_4.printAndWait(resolvePath("C:\\Users\\Windtunnel\\OneDrive - Northumbria University - Production Azure AD\\Drag Prediction Paper\\Figures\\Wake Data\\velocity1.png"), 1, 700, 624, true, false);

    CurrentView currentView_2 = 
      scene_4.getCurrentView();

    currentView_2.setInput(new DoubleVector(new double[] {1.1130453495694042, 0.0, 0.5}), new DoubleVector(new double[] {72.99561115565193, 0.0, 0.5}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 1.0, 1);

    ScalarDisplayer scalarDisplayer_2 = 
      ((ScalarDisplayer) scene_4.getDisplayerManager().getDisplayer("Scalar 1"));

    VorticityVectorFunction vorticityVectorFunction_0 = 
      ((VorticityVectorFunction) simulation_0.getFieldFunctionManager().getFunction("VorticityVector"));

    VectorComponentFieldFunction vectorComponentFieldFunction_0 = 
      ((VectorComponentFieldFunction) vorticityVectorFunction_0.getComponentFunction(2));

    scalarDisplayer_2.getScalarDisplayQuantity().setFieldFunction(vectorComponentFieldFunction_0);

    StreamDisplayer streamDisplayer_2 = 
      ((StreamDisplayer) scene_4.getDisplayerManager().getDisplayer("Streamline Stream 1"));

    streamDisplayer_2.setVisibilityOverrideMode(2);

    scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-50.0, 66.91222261030052}));

    scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-50.0, 50.0}));

    scalarDisplayer_2.getScalarDisplayQuantity().setClip(0);

    // scene_4.printAndWait(resolvePath("C:\\Users\\Windtunnel\\OneDrive - Northumbria University - Production Azure AD\\Drag Prediction Paper\\Figures\\Wake Data\\vorticity1.png"), 1, 700, 624, true, false);

    PlaneSection planeSection_4 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("1.111m"));

    Coordinate coordinate_2 = 
      planeSection_4.getOriginCoordinate();

    Units units_0 = 
      ((Units) simulation_0.getUnitsManager().getObject("m"));

    // set second coordinates \\
    // coordinate_2.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {10.00125, 0.0, 0.0}));

    // currentView_2.setInput(new DoubleVector(new double[] {1.1130453495694042, 0.0, 0.5}), new DoubleVector(new double[] {72.99561115565193, 0.0, 0.5}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 1.0, 1);

    // scene_4.printAndWait(resolvePath("C:\\Users\\Windtunnel\\OneDrive - Northumbria University - Production Azure AD\\Drag Prediction Paper\\Figures\\Wake Data\\vorticity2.png"), 1, 700, 624, true, false);

    // currentView_2.setInput(new DoubleVector(new double[] {1.1130453495694042, 0.0, 0.5}), new DoubleVector(new double[] {72.99561115565193, 0.0, 0.5}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 1.0, 1);

    // PrimitiveFieldFunction primitiveFieldFunction_0 = 
    //   ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    // VectorMagnitudeFieldFunction vectorMagnitudeFieldFunction_0 = 
    //   ((VectorMagnitudeFieldFunction) primitiveFieldFunction_0.getMagnitudeFunction());

    // scalarDisplayer_2.getScalarDisplayQuantity().setFieldFunction(vectorMagnitudeFieldFunction_0);

    // scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.0, 13.772813384943955}));

    // scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.0, 15.0}));

    // streamDisplayer_2.setVisibilityOverrideMode(0);

    // scene_4.printAndWait(resolvePath("C:\\Users\\Windtunnel\\OneDrive - Northumbria University - Production Azure AD\\Drag Prediction Paper\\Figures\\Wake Data\\velocity2.png"), 1, 700, 624, true, false);

    // set third coordinates \\
    // coordinate_2.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {18.89125, 0.0, 0.0}));

    // scene_4.printAndWait(resolvePath("C:\\Users\\Windtunnel\\OneDrive - Northumbria University - Production Azure AD\\Drag Prediction Paper\\Figures\\Wake Data\\velocity3.png"), 1, 700, 624, true, false);

    // currentView_2.setInput(new DoubleVector(new double[] {1.1130453495694042, 0.0, 0.5}), new DoubleVector(new double[] {72.99561115565193, 0.0, 0.5}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 1.0, 1);

    // scalarDisplayer_2.getScalarDisplayQuantity().setFieldFunction(vectorComponentFieldFunction_0);

    // streamDisplayer_2.setVisibilityOverrideMode(2);

    // scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-50.0, 46.01222242055721}));

    // scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-50.0, 50.0}));

    // scene_4.printAndWait(resolvePath("C:\\Users\\Windtunnel\\OneDrive - Northumbria University - Production Azure AD\\Drag Prediction Paper\\Figures\\Wake Data\\vorticity3.png"), 1, 700, 624, true, false);
  }
}
