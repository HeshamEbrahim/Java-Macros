// Written by Hesham Ebrahim
package macro;

// Packages used 
import java.util.*;
import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.meshing.*;

public class createDomain extends simSetup {

  public void execute() {
    
    Simulation simulation_0 = 
      getActiveSimulation();

      Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    // create block
      MeshPartFactory meshPartFactory_0 = 
      simulation_0.get(MeshPartFactory.class);

      SimpleBlockPart simpleBlockPart_0 = 
        meshPartFactory_0.createNewBlockPart(simulation_0.get(SimulationPartManager.class));

      LabCoordinateSystem labCoordinateSystem_0 = 
        simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

      simpleBlockPart_0.setCoordinateSystem(labCoordinateSystem_0);

    // leading corner
      Coordinate coordinate_0 = 
      simpleBlockPart_0.getCorner1();

      coordinate_0.setCoordinateSystem(labCoordinateSystem_0);

      coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-leadingVehicleLength*4, 0.0, 0.001}));

    // trailing corner
      Coordinate coordinate_1 = 
      simpleBlockPart_0.getCorner2();

      coordinate_1.setCoordinateSystem(labCoordinateSystem_0);

      coordinate_1.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {leadingVehicleLength*8, leadingVehicleWidth*5, leadingVehicleHeight*5}));

      simpleBlockPart_0.rebuildSimpleShapePart();
    
    // split block surfaces
      simulation_0.get(SimulationPartManager.class).getPart("Block");

      PartSurface partSurface_0 = 
        ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Block Surface"));

      simpleBlockPart_0.splitPartSurfaceByPatch(partSurface_0, new IntVector(new int[] {80}), "Symmetry");

      simpleBlockPart_0.splitPartSurfaceByPatch(partSurface_0, new IntVector(new int[] {81}), "Inlet");

      simpleBlockPart_0.splitPartSurfaceByPatch(partSurface_0, new IntVector(new int[] {83}), "Road");

      simpleBlockPart_0.splitPartSurfaceByPatch(partSurface_0, new IntVector(new int[] {79, 82}), "Walls");

      partSurface_0.setPresentationName("Outlet");
  
    // wake block
      SimpleBlockPart simpleBlockPart_1 = 
        meshPartFactory_0.createNewBlockPart(simulation_0.get(SimulationPartManager.class));

      simpleBlockPart_1.setCoordinateSystem(labCoordinateSystem_0);

      Coordinate coordinate_2 = 
      simpleBlockPart_1.getCorner1();

      coordinate_2.setCoordinateSystem(labCoordinateSystem_0);

      coordinate_2.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-leadingVehicleLength*1.5, 0.0, -0.01}));

      Coordinate coordinate_3 = 
      simpleBlockPart_1.getCorner2();

      coordinate_3.setCoordinateSystem(labCoordinateSystem_0);

      coordinate_3.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {leadingVehicleLength*3, leadingVehicleWidth*1.5, leadingVehicleHeight*1.5}));

      simpleBlockPart_1.rebuildSimpleShapePart();
    }

}
