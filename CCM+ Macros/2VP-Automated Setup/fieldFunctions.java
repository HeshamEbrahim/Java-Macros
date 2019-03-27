// Written by Hesham Ebrahim
package macro;

// Packages used 
import star.turbulence.*;
import star.material.*;
import star.common.*;
import star.keturb.*;
import star.flow.*;
import star.segregatedflow.*;
import star.metrics.*;
import java.util.*;
import star.base.neo.*;
import star.vis.*;
import star.meshing.*;
import star.resurfacer.*;
import star.trimmer.*;
import star.prismmesher.*;

public class fieldFunctions extends simSetup {

  public void execute() {
    
    Simulation simulation_0 = 
      getActiveSimulation();
// PC Mean
    UserFieldFunction userFieldFunction_0 = 
      simulation_0.getFieldFunctionManager().createFieldFunction();

      userFieldFunction_0.getTypeOption().setSelected(FieldFunctionTypeOption.Type.SCALAR);

      userFieldFunction_0.setPresentationName("PCMean");

      userFieldFunction_0.setFunctionName("PCMean");

      userFieldFunction_0.setDefinition("${PCMonitor}");
// Mean Velocity
    UserFieldFunction userFieldFunction_1 = 
      simulation_0.getFieldFunctionManager().createFieldFunction();

      userFieldFunction_1.getTypeOption().setSelected(FieldFunctionTypeOption.Type.VECTOR);

      userFieldFunction_1.setPresentationName("Mean Velocity");

      userFieldFunction_1.setFunctionName("Mean Velocity");

      userFieldFunction_1.setDefinition("[$FieldMeaniMonitor, $FieldMeanjMonitor, $FieldMeankMonitor]");
// SD PC
    UserFieldFunction userFieldFunction_3 = 
      simulation_0.getFieldFunctionManager().createFieldFunction();

      userFieldFunction_3.getTypeOption().setSelected(FieldFunctionTypeOption.Type.SCALAR);

      userFieldFunction_3.setPresentationName("SD PC");

      userFieldFunction_3.setFunctionName("SD PC");

      userFieldFunction_3.setDefinition("sqrt(${FieldVariancePCMonitor})");
// Turbulent Length Scale
    UserFieldFunction userFieldFunction_4 = 
      simulation_0.getFieldFunctionManager().createFieldFunction();

      userFieldFunction_4.getTypeOption().setSelected(FieldFunctionTypeOption.Type.SCALAR);

      userFieldFunction_4.setPresentationName("Turbulent Length Scale");

      userFieldFunction_4.setFunctionName("Turbulent Length Scale");

      userFieldFunction_4.setDefinition("pow(0.09,-1)*sqrt(($TurbulentKineticEnergy)/($SpecificDissipationRate))");
// Grid Size
    UserFieldFunction userFieldFunction_5 = 
      simulation_0.getFieldFunctionManager().createFieldFunction();

      userFieldFunction_5.getTypeOption().setSelected(FieldFunctionTypeOption.Type.SCALAR);

      userFieldFunction_5.setPresentationName("Grid Size");

      userFieldFunction_5.setFunctionName("Grid Size");

      userFieldFunction_5.setDefinition("pow($Volume, 1.0/3.0)");

// Length Ratio
    UserFieldFunction userFieldFunction_6 = 
      simulation_0.getFieldFunctionManager().createFieldFunction();

      userFieldFunction_6.getTypeOption().setSelected(FieldFunctionTypeOption.Type.SCALAR);

      userFieldFunction_6.setPresentationName("Length Ratio");

      userFieldFunction_6.setFunctionName("Length Ratio");

      userFieldFunction_6.setDefinition("(${Turbulent Length Scale})/(2*${Grid Size})");
// Surface Normal
    UserFieldFunction userFieldFunction_7 = 
      simulation_0.getFieldFunctionManager().createFieldFunction();

      userFieldFunction_7.getTypeOption().setSelected(FieldFunctionTypeOption.Type.VECTOR);

      userFieldFunction_7.setPresentationName("Surface Normal");

      userFieldFunction_7.setFunctionName("Surface Normal");

      userFieldFunction_7.setDefinition("$$Area/($$Area.mag())");
// DragX
    UserFieldFunction userFieldFunction_8 = 
      simulation_0.getFieldFunctionManager().createFieldFunction();

      userFieldFunction_8.getTypeOption().setSelected(FieldFunctionTypeOption.Type.SCALAR);

      userFieldFunction_8.setPresentationName("DX");

      userFieldFunction_8.setFunctionName("DX");

      userFieldFunction_8.setDefinition("$${Surface Normal}[0]*${StaticPressure}*($${Area}.mag())");

// Pxn
  UserFieldFunction userFieldFunction_9 = 
  simulation_0.getFieldFunctionManager().createFieldFunction();

  userFieldFunction_9.getTypeOption().setSelected(FieldFunctionTypeOption.Type.SCALAR);

  userFieldFunction_9.setPresentationName("Pxn");

  userFieldFunction_9.setFunctionName("Pxn");

  userFieldFunction_9.setDefinition("$${Surface Normal}[0]*${StaticPressure}");

// Pressure Coefficient Value
    PressureCoefficientFunction pressureCoefficientFunction_0 = 
      ((PressureCoefficientFunction) simulation_0.getFieldFunctionManager().getFunction("PressureCoefficient"));

      pressureCoefficientFunction_0.getReferenceVelocity().setValue(velocity);

      pressureCoefficientFunction_0.getReferenceDensity().setValue(density);

  }

// Shear Stress Tensor
// UserFieldFunction userFieldFunction_10 = 
// simulation_0.getFieldFunctionManager().createFieldFunction();

// userFieldFunction_9.getTypeOption().setSelected(FieldFunctionTypeOption.Type.SYMMETRICTENSOR);

// userFieldFunction_9.setPresentationName("Shear Stress Tensor");

// userFieldFunction_9.setFunctionName("Shear Stress Tensor");

// userFieldFunction_9.setDefinition("2*${DynamicViscosity}*[$${U_VelocityGrad}[0] ; .5*($${U_VelocityGrad}[1]+$${V_VelocityGrad}[0]),$${V_VelocityGrad}[1] ; .5*($${U_VelocityGrad}[2]+$${W_VelocityGrad}[0]),.5*($${V_VelocityGrad}[2]+$${W_VelocityGrad}[1]),$${W_VelocityGrad}[2]]");
// viscosity term has been removed to increase the magnitudes of the values
// have to turn solvers>Segregated flow>properties - tick Temporary Storage Retained and step sim
}
