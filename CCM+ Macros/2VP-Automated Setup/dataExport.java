// Written by Hesham Ebrahim
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.flow.*;

public class dataExport extends simSetup {

  public void execute() {
    Simulation simulation_0 = 
      getActiveSimulation();
// boundaries
    Region region_0 = 
      simulation_0.getRegionManager().getRegion("WT");
  
    Boundary boundary_0 = 
        region_0.getBoundaryManager().getBoundary(leadingVehicle.substring(0, LVtxtLength));
    
    Boundary boundary_1 = 
        region_0.getBoundaryManager().getBoundary(trailingVehicle.substring(0, TVtxtLength));
    
    Boundary boundary_2 = 
        region_0.getBoundaryManager().getBoundary("Inlet");
    
    Boundary boundary_3 = 
        region_0.getBoundaryManager().getBoundary("Outlet");
    
    Boundary boundary_4 = 
        region_0.getBoundaryManager().getBoundary("Road");
    
    Boundary boundary_5 = 
        region_0.getBoundaryManager().getBoundary("Symmetry");
    
    Boundary boundary_6 = 
        region_0.getBoundaryManager().getBoundary("Walls"); 
// export setup
    AutoExport autoExport_0 = 
      simulation_0.getSimulationIterator().getAutoExport();

    autoExport_0.getSolutionExportFormat().setSelected(SolutionExportFormat.Type.TRN);

    autoExport_0.setBaseName("EB-FB");

    PressureCoefficientFunction pressureCoefficientFunction_0 = 
      ((PressureCoefficientFunction) simulation_0.getFieldFunctionManager().getFunction("PressureCoefficient"));

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    VectorMagnitudeFieldFunction vectorMagnitudeFieldFunction_0 = 
      ((VectorMagnitudeFieldFunction) primitiveFieldFunction_0.getMagnitudeFunction());

    VectorComponentFieldFunction vectorComponentFieldFunction_0 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(0));

    VectorComponentFieldFunction vectorComponentFieldFunction_1 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(1));

    VectorComponentFieldFunction vectorComponentFieldFunction_2 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(2));

    autoExport_0.setScalars(new NeoObjectVector(new Object[] {pressureCoefficientFunction_0, vectorMagnitudeFieldFunction_0, vectorComponentFieldFunction_0, vectorComponentFieldFunction_1, vectorComponentFieldFunction_2}));

    autoExport_0.setBoundaries(new NeoObjectVector(new Object[] {boundary_0, boundary_1, boundary_5}));

    StarUpdate starUpdate_0 = 
      autoExport_0.getStarUpdate();

    starUpdate_0.setEnabled(true);

    IterationUpdateFrequency iterationUpdateFrequency_0 = 
      starUpdate_0.getIterationUpdateFrequency();

    iterationUpdateFrequency_0.setIterations(5);
  }

}
