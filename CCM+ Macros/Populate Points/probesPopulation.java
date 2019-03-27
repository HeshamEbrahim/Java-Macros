// Written by Hesham Ebrahim
package macro;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JFileChooser;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class probesPopulation extends StarMacro {

    public void execute() {
        execute0();
    }

    private void execute0() {

        Simulation sim = getActiveSimulation();
        Scene scene_1 = sim.getSceneManager().createScene("Probe_Scene");
        PartDisplayer partDisplayer_0 = scene_1.getDisplayerManager().createPartDisplayer("Geometry", -1, 4);
        PartDisplayer partDisplayer_2 = scene_1.getDisplayerManager().createPartDisplayer("Probes", -1, 4);

        scene_1.initializeAndWait();
        partDisplayer_0.initialize();
        partDisplayer_2.initialize();
        partDisplayer_0.setOpacity(0.2);
        partDisplayer_0.setSurface(true);

        Collection<Region> regions = sim.getRegionManager().getRegions();
        List<Boundary> boundaries = new ArrayList<>();

        for (Region ri : regions) {
            Collection<Boundary> colb = ri.getBoundaryManager().getBoundaries();
            for (Boundary bou : colb) {
                boundaries.add(bou);
            }

        }

        sim.println(boundaries);
        partDisplayer_0.getInputParts().addObjects(boundaries);

        scene_1.open(true);

        CurrentView currentView_0 = scene_1.getCurrentView();
        currentView_0.setInput(new DoubleVector(new double[]{5.280963583405624E-4, 0.07167807182777301, -0.009389237076966827}), new DoubleVector(new double[]{-0.02154979710385694, 0.21065168804168466, 0.41702085604184463}), new DoubleVector(new double[]{0.0078053121782873285, 0.9508679367009188, -0.30949837488416143}), 0.11323071983682062, 1);
        String filetoOpen = "C:\\Users\\Windtunnel\\Documents\\GitHub\\Java-Macros\\CCM+ Macros\\Populate Points\\Points csv file.csv";
        // JFileChooser fileChooser = new JFileChooser();
        // fileChooser.setCurrentDirectory(sim.getSessionDirFile());

        // if (fileChooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
        //     return;
        // }
        // String table = fileChooser.getSelectedFile().getPath();
        // sim.println(table);

        FileTable fileTable_0 = ((FileTable) sim.getTableManager().createFromFile(resolvePath(filetoOpen)));

        int rows = fileTable_0.getNumRows();
        sim.println(rows + " rows");

        for (int i = 0; i < rows; i++) {

            Object position_x = fileTable_0.getTableDataItem(i, 0);
            Object position_y = fileTable_0.getTableDataItem(i, 1);
            Object position_z = fileTable_0.getTableDataItem(i, 2);

            Double xpos = new Double(position_x.toString());
            Double ypos = new Double(position_y.toString());
            Double zpos = new Double(position_z.toString());
            PointPart pointPart_1 = sim.getPartManager().createPointPart(new NeoObjectVector(new Object[]{}), new DoubleVector(new double[]{xpos, ypos, zpos}));

            pointPart_1.getInputParts().setObjects(regions);

            partDisplayer_2.addPart(pointPart_1);

            pointPart_1.setPresentationName("Point_" + i);
            sim.println("");
            sim.println(pointPart_1.getPresentationName());
            sim.println("x-location = " + position_x + "m");
            sim.println("y-location = " + position_y + "m");
            sim.println("z-location = " + position_z + "m");
            sim.println("");

        }
    }
}
