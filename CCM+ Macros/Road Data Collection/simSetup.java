// STAR-CCM+ macro: simSetup.java
// Written by Hesham Ebrahim
package macro;

// Packages used 
import java.util.*;
import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.meshing.*;

public class simSetup extends StarMacro {

  // main variables
  //   public String mainDirectory = "D:\\Documents\\Northumbria University\\PhD Research\\CFD\\Platoon Surface Pressure Sensitivity\\Models\\";
  //   public String leadingVehicle = "Estate Back.stl";
  //   public String trailingVehicle = "FB.stl";

  // // vehicle geometry 
  //   public double leadingVehicleLength = 4.612;
  //   public double leadingVehicleWidth = 1.015;
  //   public double leadingVehicleHeight = 1.42;

  // // remove .stl extension from string
  //   int LVtxtLength = (leadingVehicle.length() - 4);
  //   int TVtxtLength = (trailingVehicle.length() - 4);
  
  // // simulation variables
  //   public double timeStep = 0.001;
  //   public double physicalTime = 1;
  //   public double velocity = 30.0;
  //   public double density = 1.18415;

  public void execute() {

  new StarScript(getActiveRootObject(),
    new java.io.File(resolvePath("derviedParts.java"))).play();
  new StarScript(getActiveRootObject(),
    new java.io.File(resolvePath("scalarSceneSetup.java"))).play();
  new StarScript(getActiveRootObject(),
    new java.io.File(resolvePath("streamlinesSetup.java"))).play();
  new StarScript(getActiveRootObject(),
    new java.io.File(resolvePath("saveData.java"))).play();
  // new StarScript(getActiveRootObject(),
  //   new java.io.File(resolvePath("shearData.java"))).play();  
  }
}


