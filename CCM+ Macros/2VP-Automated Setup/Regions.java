// Written by Hesham Ebrahim
package macro;

// Packages used 
import java.util.*;
import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.meshing.*;

public class Regions extends simSetup {

  public void execute() {
    
    Simulation simulation_0 = 
      getActiveSimulation();

    // create region
    Region region_0 = 
      simulation_0.getRegionManager().createEmptyRegion();

    region_0.setPresentationName("WT");

      simulation_0.getRegionManager().getRegion("WT");

    // select parts for the regions
    SimpleBlockPart simpleBlockPart_0 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Block"));

    MeshPart meshPart_0 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart(leadingVehicle.substring(0, LVtxtLength)));

    MeshPart meshPart_1 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart(trailingVehicle.substring(0, TVtxtLength)));

    region_0.getPartGroup().setObjects(simpleBlockPart_0, meshPart_0, meshPart_1);

    // create empty boundaries
    Boundary boundary_0 = 
      region_0.getBoundaryManager().createEmptyBoundary();

    Boundary boundary_1 = 
      region_0.getBoundaryManager().createEmptyBoundary();

    Boundary boundary_2 = 
      region_0.getBoundaryManager().createEmptyBoundary();
    
    Boundary boundary_3 = 
      region_0.getBoundaryManager().createEmptyBoundary();

    Boundary boundary_4 = 
      region_0.getBoundaryManager().createEmptyBoundary();

    Boundary boundary_5 = 
      region_0.getBoundaryManager().createEmptyBoundary();

    Boundary boundary_6 = 
      region_0.getBoundaryManager().createEmptyBoundary();

    // create inlet region
    PartSurface partSurface_0 = 
      ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Inlet"));

    boundary_0.getPartSurfaceGroup().setObjects(partSurface_0);

    boundary_0.setPresentationName("Inlet");

    boundary_0.setBoundaryType(InletBoundary.class);

    // create outlet region
    PartSurface partSurface_1 = 
      ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Outlet"));

    boundary_1.getPartSurfaceGroup().setObjects(partSurface_1);

    boundary_1.setPresentationName("Outlet");

    boundary_1.setBoundaryType(PressureBoundary.class);

    // create symmetry region
    PartSurface partSurface_2 = 
      ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Symmetry"));

    boundary_2.getPartSurfaceGroup().setObjects(partSurface_2);

    boundary_2.setPresentationName("Symmetry");

    boundary_2.setBoundaryType(SymmetryBoundary.class);

    // create road region
    PartSurface partSurface_3 = 
     ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Road"));

    boundary_3.getPartSurfaceGroup().setObjects(partSurface_3);

    boundary_3.setPresentationName("Road");

    // create walls region
    PartSurface partSurface_4 = 
     ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Walls"));

    boundary_4.getPartSurfaceGroup().setObjects(partSurface_4);

    boundary_4.setPresentationName("Walls");

    // leading vehicle region
    PartSurface partSurface_5 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("catia"));

    boundary_5.getPartSurfaceGroup().setObjects(partSurface_5);

    boundary_5.setPresentationName(leadingVehicle.substring(0, LVtxtLength));

    // trailing vehicle region
    PartSurface partSurface_6 = 
      ((PartSurface) meshPart_1.getPartSurfaceManager().getPartSurface("catia"));

    boundary_6.getPartSurfaceGroup().setObjects(partSurface_6);

    boundary_6.setPresentationName(trailingVehicle.substring(0, TVtxtLength));

    // delete default boundary
    Boundary boundary_7 = 
    region_0.getBoundaryManager().getBoundary("Default");

    region_0.getBoundaryManager().removeBoundaries(new NeoObjectVector(new Object[] {boundary_7}));

  }

}
