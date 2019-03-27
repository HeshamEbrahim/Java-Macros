// STAR-CCM+ macro: shearData.java
// Written by STAR-CCM+ 11.04.012
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class shearData extends simSetup {

  public void execute() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_3 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    CurrentView currentView_1 = 
      scene_3.getCurrentView();

    currentView_1.setInput(new DoubleVector(new double[] {1.1130453495694042, 0.0, 0.5}), new DoubleVector(new double[] {72.99561115565193, 0.0, 0.5}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 1.0, 1);

    ScalarDisplayer scalarDisplayer_3 = 
      ((ScalarDisplayer) scene_3.getDisplayerManager().getDisplayer("Scalar 1"));

    UserFieldFunction userFieldFunction_1 = 
      ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Shear Part"));

    SymmetricTensorComponentFieldFunction symmetricTensorComponentFieldFunction_4 = 
      ((SymmetricTensorComponentFieldFunction) userFieldFunction_1.getComponentFunction(2, 0));

    scalarDisplayer_3.getScalarDisplayQuantity().setFieldFunction(symmetricTensorComponentFieldFunction_4);

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-100.0, 99.6130419480294}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-100.0, 100.0}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-50.0, 100.0}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-100.0, 100.0}));

    scene_3.printAndWait(resolvePath("C:\\Users\\Windtunnel\\Desktop\\Isolation_Shear[i,k].png"), 1, 700, 624, true, false);

    currentView_1.setInput(new DoubleVector(new double[] {1.1130453495694042, 0.0, 0.5}), new DoubleVector(new double[] {72.99561115565193, 0.0, 0.5}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 1.0, 1);

    SymmetricTensorComponentFieldFunction symmetricTensorComponentFieldFunction_5 = 
      ((SymmetricTensorComponentFieldFunction) userFieldFunction_1.getComponentFunction(2, 1));

    scalarDisplayer_3.getScalarDisplayQuantity().setFieldFunction(symmetricTensorComponentFieldFunction_5);

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-1961.1875105107374, 500.0}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-500.0, 500.0}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-100.0, 500.0}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-100.0, 100.0}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-50.0, 100.0}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-50.0, 50.0}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-50.0, 20.0}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-20.0, 20.0}));

    scene_3.printAndWait(resolvePath("C:\\Users\\Windtunnel\\Desktop\\Isolation_Shear[j,k].png"), 1, 700, 624, true, false);

    currentView_1.setInput(new DoubleVector(new double[] {1.1130453495694042, 0.0, 0.5}), new DoubleVector(new double[] {72.99561115565193, 0.0, 0.5}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 1.0, 1);

    SymmetricTensorComponentFieldFunction symmetricTensorComponentFieldFunction_2 = 
      ((SymmetricTensorComponentFieldFunction) userFieldFunction_1.getComponentFunction(2, 2));

    scalarDisplayer_3.getScalarDisplayQuantity().setFieldFunction(symmetricTensorComponentFieldFunction_2);

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-27.48217833452149, 20.0}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-20.0, 20.0}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-25.0, 20.0}));

    scalarDisplayer_3.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-25.0, 25.0}));

    scene_3.printAndWait(resolvePath("C:\\Users\\Windtunnel\\Desktop\\Isolation_Shear[k,k].png"), 1, 700, 624, true, false);
  }
}
