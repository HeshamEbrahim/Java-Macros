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
import star.surfacewrapper.*;
import star.resurfacer.*;
import star.trimmer.*;
import star.prismmesher.*;

public class Continua extends simSetup {

  public void execute() {
    
    Simulation simulation_0 = 
      getActiveSimulation();

    // physics of the problem
    PhysicsContinuum physicsContinuum_0 = 
      simulation_0.getContinuumManager().createContinuum(PhysicsContinuum.class);

        physicsContinuum_0.enable(ThreeDimensionalModel.class);

        physicsContinuum_0.enable(ImplicitUnsteadyModel.class);

        physicsContinuum_0.enable(SingleComponentGasModel.class);

        physicsContinuum_0.enable(SegregatedFlowModel.class);

        physicsContinuum_0.enable(ConstantDensityModel.class);

        physicsContinuum_0.enable(TurbulentModel.class);

        physicsContinuum_0.enable(RansTurbulenceModel.class);

        physicsContinuum_0.enable(KEpsilonTurbulence.class);

        physicsContinuum_0.enable(RkeTwoLayerTurbModel.class);

        physicsContinuum_0.enable(KeTwoLayerAllYplusWallTreatment.class);

    // meshing
    MeshContinuum meshContinuum_0 = 
      simulation_0.getContinuumManager().createContinuum(MeshContinuum.class);

        meshContinuum_0.enable(ResurfacerMeshingModel.class);

        meshContinuum_0.enable(TrimmerMeshingModel.class);

        meshContinuum_0.enable(PrismMesherModel.class);

        meshContinuum_0.enable(SurfaceWrapperMeshingModel.class);

    // overall meshing details
    NumPrismLayers numPrismLayers_0 = 
      meshContinuum_0.getReferenceValues().get(NumPrismLayers.class);

        numPrismLayers_0.setNumLayers(15);

    PrismMesherModel prismMesherModel_0 = 
      meshContinuum_0.getModelManager().getModel(PrismMesherModel.class);

        prismMesherModel_0.getPrismStretchingOption().setSelected(PrismStretchingOption.Type.THICKNESS_RATIO);

    PrismLayerThicknessRatio prismLayerThicknessRatio_0 = 
      meshContinuum_0.getReferenceValues().get(PrismLayerThicknessRatio.class);

        prismLayerThicknessRatio_0.setThicknessRatio(1.2);

    PrismThickness prismThickness_0 = 
      meshContinuum_0.getReferenceValues().get(PrismThickness.class);

        GenericRelativeSize genericRelativeSize_0 = 
            ((GenericRelativeSize) prismThickness_0.getRelativeSize());

        genericRelativeSize_0.setPercentage(1.5);

    Region region_0 = 
        simulation_0.getRegionManager().getRegion("WT");
    // leading vehicle mesh details
    Boundary boundary_0 = 
        region_0.getBoundaryManager().getBoundary(leadingVehicle.substring(0, LVtxtLength));
  
    CustomSurfaceGrowthRateOption customSurfaceGrowthRateOption_0 = 
        boundary_0.get(MeshConditionManager.class).get(CustomSurfaceGrowthRateOption.class);
  
      customSurfaceGrowthRateOption_0.setEnabled(true);

    SurfaceSizeOption surfaceSizeOption_0 = 
        boundary_0.get(MeshConditionManager.class).get(SurfaceSizeOption.class);
  
      surfaceSizeOption_0.setSurfaceSizeOption(true);
    
    CustomSimpleSurfaceGrowthRate customSimpleSurfaceGrowthRate_0 = 
      boundary_0.get(MeshValueManager.class).get(CustomSimpleSurfaceGrowthRate.class);

        customSimpleSurfaceGrowthRate_0.getSurfaceGrowthRateOption().setSelected(SurfaceGrowthRateOption.Type.CUSTOM);

    SurfaceSize surfaceSize_0 = 
        boundary_0.get(MeshValueManager.class).get(SurfaceSize.class);
  
      RelativeMinimumSize relativeMinimumSize_0 = 
        surfaceSize_0.getRelativeMinimumSize();
  
      relativeMinimumSize_0.setPercentage(0.1);

    RelativeTargetSize relativeTargetSize_0 = 
        surfaceSize_0.getRelativeTargetSize();
  
      relativeTargetSize_0.setPercentage(50.0);
    // trailing vehicle mesh details
    Boundary boundary_1 = 
        region_0.getBoundaryManager().getBoundary(trailingVehicle.substring(0, TVtxtLength));
  
    CustomSurfaceGrowthRateOption customSurfaceGrowthRateOption_1 = 
        boundary_1.get(MeshConditionManager.class).get(CustomSurfaceGrowthRateOption.class);
  
      customSurfaceGrowthRateOption_1.setEnabled(true);
  
    SurfaceSizeOption surfaceSizeOption_1 = 
        boundary_1.get(MeshConditionManager.class).get(SurfaceSizeOption.class);
  
      surfaceSizeOption_1.setSurfaceSizeOption(true);
      
    CustomSimpleSurfaceGrowthRate customSimpleSurfaceGrowthRate_1 = 
        boundary_1.get(MeshValueManager.class).get(CustomSimpleSurfaceGrowthRate.class);
  
      customSimpleSurfaceGrowthRate_1.getSurfaceGrowthRateOption().setSelected(SurfaceGrowthRateOption.Type.CUSTOM);
  
    SurfaceSize surfaceSize_1 = 
        boundary_1.get(MeshValueManager.class).get(SurfaceSize.class);
  
      RelativeMinimumSize relativeMinimumSize_1 = 
        surfaceSize_1.getRelativeMinimumSize();
  
      relativeMinimumSize_1.setPercentage(0.1);
  
    RelativeTargetSize relativeTargetSize_1 = 
        surfaceSize_1.getRelativeTargetSize();
  
      relativeTargetSize_1.setPercentage(50.0);

    // overall mesh values
    OneGroupContactPreventionSet oneGroupContactPreventionSet_0 = 
        region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

        oneGroupContactPreventionSet_0.getFloor().setValue(0.001);

        Boundary boundary_2 = 
          region_0.getBoundaryManager().getBoundary("Symmetry");

        Boundary boundary_3 = 
          region_0.getBoundaryManager().getBoundary("Road");

        oneGroupContactPreventionSet_0.getBoundaryGroup().setObjects(boundary_0, boundary_1, boundary_2);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_1 = 
        region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

        oneGroupContactPreventionSet_1.getFloor().setValue(0.0001);

        oneGroupContactPreventionSet_1.getBoundaryGroup().setObjects(boundary_0, boundary_1, boundary_3);

    // wake box refinement
      VolumeSource volumeSource_0 = 
        meshContinuum_0.getVolumeSources().createVolumeSource();
  
      SimpleBlockPart simpleBlockPart_0 = 
        ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Block 2"));
  
        volumeSource_0.getPartGroup().setObjects(simpleBlockPart_0);

      TrimmerSizeOption trimmerSizeOption_0 = 
        volumeSource_0.get(MeshConditionManager.class).get(TrimmerSizeOption.class);
  
        trimmerSizeOption_0.setTrimmerSizeOption(true);
  
      VolumeSourceSize volumeSourceSize_0 = 
        volumeSource_0.get(MeshValueManager.class).get(VolumeSourceSize.class);
  
      GenericRelativeSize genericRelativeSize_1 = 
        ((GenericRelativeSize) volumeSourceSize_0.getRelativeSize());
  
        genericRelativeSize_1.setPercentage(5);

    // create mesh
        MeshPipelineController meshPipelineController_0 = 
        simulation_0.get(MeshPipelineController.class);

        meshPipelineController_0.generateVolumeMesh();

    // boundary condition physics
      Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("Inlet");

      VelocityMagnitudeProfile velocityMagnitudeProfile_0 = 
        boundary_4.getValues().get(VelocityMagnitudeProfile.class);

      velocityMagnitudeProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(velocity);

  }

}
