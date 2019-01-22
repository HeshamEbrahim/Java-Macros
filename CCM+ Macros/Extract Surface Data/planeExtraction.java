// Written by Hesham Ebrahim
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class planeExtraction extends StarMacro {

  // Planes locations
//   public double x = -4.445;
//   public double xInc = 0.0889;
  public double y = 0.110625;
  public double yInc = 0.22125;
  public int yLoop = 4; // index = 1 (final = 10)
  public double z = 0.3742875;
  public double zInc = 0.279175;
  public int zLoop = 5; // Index = 1 (final = 11)

  // data extraction 
  public String carBoundary1 = "Subtract.NL.Full Car.NL";
  public String carBoundary2 = "Subtract.NL.Gap Closure Faces";
  public String Plane = "Plane Section ";
  public String Location = "C:\\Users\\Windtunnel\\Desktop\\New folder\\Plane ";
  public int number = 1; // specifies the number of planes
  public int locationNum = 1; // specifies the title or number of planes exported
  public int iteration = 25; // number of planes to iterate (index = 1)

  public void execute() {

    // new StarScript(getActiveRootObject(),
    //     new java.io.File(resolvePath("xaxisPlanes.java"))).play();
    new StarScript(getActiveRootObject(),
        new java.io.File(resolvePath("yaxisPlanes.java"))).play();
    new StarScript(getActiveRootObject(),
        new java.io.File(resolvePath("zaxisPlanes.java"))).play();
    new StarScript(getActiveRootObject(),
        new java.io.File(resolvePath("extractData.java"))).play();
    
  }

  }
