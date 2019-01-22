// Written by Hesham Ebrahim
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.base.report.*;
import star.flow.*;
import star.vis.*;

public class Reports extends simSetup {

  public void execute() {
    Simulation simulation_0 = 
      getActiveSimulation();

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("WT");

    // area report
        FrontalAreaReport frontalAreaReport_0 = 
            simulation_0.getReportManager().createReport(FrontalAreaReport.class);

        Coordinate coordinate_0 = 
            frontalAreaReport_0.getViewUpCoordinate();

        Units units_0 = 
            ((Units) simulation_0.getUnitsManager().getObject("m"));

        coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.0, 1.0}));

        Coordinate coordinate_1 = 
            frontalAreaReport_0.getNormalCoordinate();

        coordinate_1.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1.0, 0.0, 0.0}));

        Boundary boundary_0 = 
            region_0.getBoundaryManager().getBoundary(leadingVehicle.substring(0, LVtxtLength));

        frontalAreaReport_0.getParts().setObjects(boundary_0);

        FrontalAreaReport frontalAreaReport_1 = 
            simulation_0.getReportManager().createReport(FrontalAreaReport.class);

        Coordinate coordinate_2 = 
            frontalAreaReport_1.getViewUpCoordinate();

        coordinate_2.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.0, 1.0}));

        Coordinate coordinate_3 = 
            frontalAreaReport_1.getNormalCoordinate();

        coordinate_3.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1.0, 0.0, 0.0}));

        Boundary boundary_1 = 
            region_0.getBoundaryManager().getBoundary(trailingVehicle.substring(0, TVtxtLength));

        frontalAreaReport_1.getParts().setObjects(boundary_1);

    // leading vehicle drag
        ForceCoefficientReport forceCoefficientReport_0 = 
            simulation_0.getReportManager().createReport(ForceCoefficientReport.class);

        forceCoefficientReport_0.getDirection().setComponents(1.0, 0.0, 0.0);

        forceCoefficientReport_0.getReferenceDensity().setValue(density);

        forceCoefficientReport_0.getReferenceVelocity().setValue(velocity);

        forceCoefficientReport_0.getParts().setObjects(boundary_0);

        forceCoefficientReport_0.getReferenceArea().setValue(frontalAreaReport_0.getValue());

        forceCoefficientReport_0.setPresentationName("Leading CD");

    // trailing vehicle drag
        ForceCoefficientReport forceCoefficientReport_1 = 
            simulation_0.getReportManager().createReport(ForceCoefficientReport.class);

        forceCoefficientReport_1.getDirection().setComponents(1.0, 0.0, 0.0);

        forceCoefficientReport_1.getReferenceDensity().setValue(density);

        forceCoefficientReport_1.getReferenceVelocity().setValue(velocity);

        forceCoefficientReport_1.getParts().setObjects(boundary_1);

        forceCoefficientReport_1.getReferenceArea().setValue(frontalAreaReport_1.getValue());

        forceCoefficientReport_1.setPresentationName("Trailing CD");

    // leading vehicle lift
        ForceCoefficientReport forceCoefficientReport_2 = 
            simulation_0.getReportManager().createReport(ForceCoefficientReport.class);

        forceCoefficientReport_2.getDirection().setComponents(0.0, 0.0, 1.0);

        forceCoefficientReport_2.getReferenceDensity().setValue(density);

        forceCoefficientReport_2.getReferenceVelocity().setValue(velocity);

        Boundary boundary_2 = 
            region_0.getBoundaryManager().getBoundary(leadingVehicle.substring(0, LVtxtLength));

        forceCoefficientReport_2.getParts().setObjects(boundary_2);

        forceCoefficientReport_2.getReferenceArea().setValue(frontalAreaReport_0.getValue());

        forceCoefficientReport_2.setPresentationName("Leading CL");

    // trailing vehicle lift
        ForceCoefficientReport forceCoefficientReport_3 = 
            simulation_0.getReportManager().createReport(ForceCoefficientReport.class);

        forceCoefficientReport_3.getDirection().setComponents(0.0, 0.0, 1.0);

        forceCoefficientReport_3.getReferenceDensity().setValue(density);

        forceCoefficientReport_3.getReferenceVelocity().setValue(velocity);

        Boundary boundary_3 = 
            region_0.getBoundaryManager().getBoundary(trailingVehicle.substring(0, TVtxtLength));

        forceCoefficientReport_3.getParts().setObjects(boundary_3);

        forceCoefficientReport_3.getReferenceArea().setValue(frontalAreaReport_1.getValue());

        forceCoefficientReport_3.setPresentationName("Trailing CL");

    // report monitors
        
        simulation_0.getMonitorManager().createMonitorAndPlot(new NeoObjectVector(new Object[] {forceCoefficientReport_0, forceCoefficientReport_1, forceCoefficientReport_2, forceCoefficientReport_3}), false, "%1$s Plot");
        ReportMonitor reportMonitor_1 = 
            ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Trailing CL Monitor"));
  
        MonitorPlot monitorPlot_0 = 
            simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_1}), "Trailing CL Monitor Plot");
  
        ReportMonitor reportMonitor_2 = 
            ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Leading CD Monitor"));
  
        MonitorPlot monitorPlot_1 = 
            simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_2}), "Leading CD Monitor Plot");
  
        ReportMonitor reportMonitor_3 = 
            ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Leading CL Monitor"));
    
        MonitorPlot monitorPlot_2 = 
            simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_3}), "Leading CL Monitor Plot");
    
        ReportMonitor reportMonitor_4 = 
            ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Trailing CD Monitor"));
    
        MonitorPlot monitorPlot_3 = 
            simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_4}), "Trailing CD Monitor Plot");
  }

}
