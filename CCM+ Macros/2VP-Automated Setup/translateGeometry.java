// Written by Hesham Ebrahim
package macro;

// Packages used 
import java.util.*;
import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.meshing.*;

public class translateGeometry extends simSetup {

  int LVtxtLength = (leadingVehicle.length() - 4);
  int TVtxtLength = (trailingVehicle.length() - 4);

  public void execute() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 1");

    // First Vehicle
    MeshPart meshPart_0 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart(leadingVehicle.substring(0, LVtxtLength)));

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    // translate in z
    simulation_0.get(SimulationPartManager.class).translateParts(new NeoObjectVector(new Object[] {meshPart_0}), new DoubleVector(new double[] {0.0, 0.0, 0.31848791241645813}), new NeoObjectVector(new Object[] {units_0, units_0, units_0}), labCoordinateSystem_0);

    // translate in x
    simulation_0.get(SimulationPartManager.class).translateParts(new NeoObjectVector(new Object[] {meshPart_0}), new DoubleVector(new double[] {-3.8049778938293457, 0.0, 0.0}), new NeoObjectVector(new Object[] {units_0, units_0, units_0}), labCoordinateSystem_0);
    

    // Second Vehicle
    MeshPart meshPart_1 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart(trailingVehicle.substring(0, TVtxtLength)));

    // translate in z
    simulation_0.get(SimulationPartManager.class).translateParts(new NeoObjectVector(new Object[] {meshPart_1}), new DoubleVector(new double[] {0.0, 0.0, 0.31848791241645813}), new NeoObjectVector(new Object[] {units_0, units_0, units_0}), labCoordinateSystem_0);

    // translate in x
    simulation_0.get(SimulationPartManager.class).translateParts(new NeoObjectVector(new Object[] {meshPart_1}), new DoubleVector(new double[] {3.113023, 0.0, 0.0}), new NeoObjectVector(new Object[] {units_0, units_0, units_0}), labCoordinateSystem_0);

  }

}
