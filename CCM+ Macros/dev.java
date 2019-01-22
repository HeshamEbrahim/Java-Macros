// STAR-CCM+ macro: dev.java
// Written by STAR-CCM+ 11.04.012
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class dev extends StarMacro {

  public String Plane = "Plane Section ";
  public String Location = "C:\\Users\\Windtunnel\\Desktop\\New folder\\Plane ";
  public int number = 1; // specifies the number of planes
  public int locationNum = 1; // specifies the title or number of planes exported
  public int iteration = 25; // number of planes to iterate (index = 1)

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

      PlaneSection planeSection_0 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("Plane Section"));

        planeSection_0.setPresentationName("Plane Section 1");  

    for(int i=1; i<iteration; i++)
    {        

        String numberAsString = Integer.toString(number);
        String locationNumAsString = Integer.toString(locationNum);
    
        XyzInternalTable xyzInternalTable_1 = 
          simulation_0.getTableManager().createTable(XyzInternalTable.class);

        // PrimitiveFieldFunction primitiveFieldFunction_1 = 
        //   ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("StaticPressure"));

        // PressureCoefficientFunction pressureCoefficientFunction_0 = 
        //   ((PressureCoefficientFunction) simulation_0.getFieldFunctionManager().getFunction("PressureCoefficient"));

        // UserFieldFunction userFieldFunction_0 = 
        //   ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Surface Normal"));

        // VectorComponentFieldFunction vectorComponentFieldFunction_0 = 
        //   ((VectorComponentFieldFunction) userFieldFunction_0.getComponentFunction(0));

        UserFieldFunction userFieldFunction_1 = 
          ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Pnx"));

        xyzInternalTable_1.setFieldFunctions(new NeoObjectVector(new Object[] {userFieldFunction_1}));

        PlaneSection planeSection_20 = 
          ((PlaneSection) simulation_0.getPartManager().getObject(Plane.concat(numberAsString)));

        xyzInternalTable_1.getParts().setObjects(planeSection_20);

        xyzInternalTable_1.extract();

        xyzInternalTable_1.export(Location.concat(locationNumAsString)+ ".csv" , ",");
        
        number += 1;
        locationNum += 1;
    }
  }
}
