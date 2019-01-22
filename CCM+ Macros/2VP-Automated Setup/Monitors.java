// Written by Hesham Ebrahim
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.base.report.*;
import star.flow.*;

public class Monitors extends simSetup {  

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
// mean velocity i component
    FieldMeanMonitor fieldMeanMonitor_0 = 
      simulation_0.getMonitorManager().createMonitor(FieldMeanMonitor.class);

      fieldMeanMonitor_0.getParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6);

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    VectorComponentFieldFunction vectorComponentFieldFunction_0 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(0));

    fieldMeanMonitor_0.setFieldFunction(vectorComponentFieldFunction_0);

    fieldMeanMonitor_0.setPresentationName("FieldMeani");

// mean velocity j component
    FieldMeanMonitor fieldMeanMonitor_1 = 
        simulation_0.getMonitorManager().createMonitor(FieldMeanMonitor.class);

        fieldMeanMonitor_1.getParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6);

    PrimitiveFieldFunction primitiveFieldFunction_1 = 
        ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    VectorComponentFieldFunction vectorComponentFieldFunction_1 = 
        ((VectorComponentFieldFunction) primitiveFieldFunction_1.getComponentFunction(1));

        fieldMeanMonitor_1.setFieldFunction(vectorComponentFieldFunction_1);

        fieldMeanMonitor_1.setPresentationName("FieldMeanj");
// mean velocity k component
    FieldMeanMonitor fieldMeanMonitor_2 = 
        simulation_0.getMonitorManager().createMonitor(FieldMeanMonitor.class);

        fieldMeanMonitor_2.getParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6);

    PrimitiveFieldFunction primitiveFieldFunction_2 = 
        ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    VectorComponentFieldFunction vectorComponentFieldFunction_2 = 
        ((VectorComponentFieldFunction) primitiveFieldFunction_2.getComponentFunction(2));

        fieldMeanMonitor_2.setFieldFunction(vectorComponentFieldFunction_2);

        fieldMeanMonitor_2.setPresentationName("FieldMeank");

// mean pressure coefficient 
    FieldMeanMonitor fieldMeanMonitor_3 = 
        simulation_0.getMonitorManager().createMonitor(FieldMeanMonitor.class);

        fieldMeanMonitor_3.getParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6);

    PressureCoefficientFunction pressureCoefficientFunction_0 = 
        ((PressureCoefficientFunction) simulation_0.getFieldFunctionManager().getFunction("PressureCoefficient"));

        fieldMeanMonitor_3.setFieldFunction(pressureCoefficientFunction_0);

        fieldMeanMonitor_3.setPresentationName("PCMean");

// variance velocity i component
    FieldVarianceMonitor fieldVarianceMonitor_0 = 
        simulation_0.getMonitorManager().createMonitor(FieldVarianceMonitor.class);

        fieldVarianceMonitor_0.getParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6);

        fieldVarianceMonitor_0.setFieldFunction(vectorComponentFieldFunction_0);

        fieldVarianceMonitor_0.setPresentationName("FieldVariancei");

// variance velocity j component
    FieldVarianceMonitor fieldVarianceMonitor_1 = 
        simulation_0.getMonitorManager().createMonitor(FieldVarianceMonitor.class);

        fieldVarianceMonitor_1.getParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6);

        fieldVarianceMonitor_1.setFieldFunction(vectorComponentFieldFunction_1);

        fieldVarianceMonitor_1.setPresentationName("FieldVariancej");

// variance velocity k component
    FieldVarianceMonitor fieldVarianceMonitor_2 = 
        simulation_0.getMonitorManager().createMonitor(FieldVarianceMonitor.class);

        fieldVarianceMonitor_2.getParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6);

        fieldVarianceMonitor_2.setFieldFunction(vectorComponentFieldFunction_2);

        fieldVarianceMonitor_2.setPresentationName("FieldVariancek");

// variance pressure coefficient

    FieldVarianceMonitor fieldVarianceMonitor_3 = 
        simulation_0.getMonitorManager().createMonitor(FieldVarianceMonitor.class);

        fieldVarianceMonitor_3.getParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6);

        fieldVarianceMonitor_3.setFieldFunction(pressureCoefficientFunction_0);

        fieldVarianceMonitor_3.setPresentationName("PCVariance");
  }

}
