// STAR-CCM+ macro: caseData.java
// Written by STAR-CCM+ 13.02.011
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.post.*;
import star.mapping.*;

public class caseData extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    String State = "State ";
    String Location = "I:\\0.125L Data Export .case\\ ";
    int number = 1; // specifies the number of state
    int locationNum = 1; // specifies the title or number of planes exported

    Simulation simulation_0 = 
      getActiveSimulation();

    for(int i=1; i<481; i++)
      {  

        String numberAsString = Integer.toString(number);
        String locationNumAsString = Integer.toString(locationNum);

        RecordedSolutionView recordedSolutionView_0 = 
          ((RecordedSolutionView) simulation_0.get(SolutionViewManager.class).getObject("AB2VP_IDDES_historyFile"));

        recordedSolutionView_0.setStateName(State.concat(numberAsString));

        VolumeDataMapper volumeDataMapper_0 = 
          ((VolumeDataMapper) simulation_0.get(DataMapperManager.class).getObject("Volume Data Mapper 1"));

        volumeDataMapper_0.mapData();

        ImportManager importManager_0 = 
          simulation_0.getImportManager();
         
        importManager_0.setExportPath(Location.concat(locationNumAsString)+".case");

        importManager_0.setFormatType(SolutionExportFormat.Type.CASE);

        importManager_0.setExportParts(new NeoObjectVector(new Object[] {}));

        importManager_0.setExportPartSurfaces(new NeoObjectVector(new Object[] {}));

        importManager_0.setExportBoundaries(new NeoObjectVector(new Object[] {}));

        importManager_0.setExportRegions(new NeoObjectVector(new Object[] {}));

        PrimitiveFieldFunction primitiveFieldFunction_2 = 
          ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("MappedVertexVelocity_0"));

        PrimitiveFieldFunction primitiveFieldFunction_3 = 
          ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("MappedVertexVelocity_1"));

        PrimitiveFieldFunction primitiveFieldFunction_4 = 
          ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("MappedVertexVelocity_2"));

        PrimitiveFieldFunction primitiveFieldFunction_1 = 
          ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("MappedVertexVelocityMagnitude"));

        importManager_0.setExportScalars(new NeoObjectVector(new Object[] {primitiveFieldFunction_2, primitiveFieldFunction_3, primitiveFieldFunction_4, primitiveFieldFunction_1}));

        importManager_0.setExportVectors(new NeoObjectVector(new Object[] {}));

        importManager_0.setExportOptionAppendToFile(false);

        importManager_0.setExportOptionDataAtVerts(false);

        importManager_0.setExportOptionSolutionOnly(false);

        importManager_0.export(resolvePath(Location.concat(locationNumAsString)+".case"), new NeoObjectVector(new Object[] {}), new NeoObjectVector(new Object[] {}), new NeoObjectVector(new Object[] {}), new NeoObjectVector(new Object[] {}), new NeoObjectVector(new Object[] {primitiveFieldFunction_2, primitiveFieldFunction_3, primitiveFieldFunction_4, primitiveFieldFunction_1}), NeoProperty.fromString("{\'exportFormatType\': 2, \'appendToFile\': false, \'solutionOnly\': false, \'dataAtVerts\': false}"));
      
        number += 1;
        locationNum += 1;
      }
  }
}
