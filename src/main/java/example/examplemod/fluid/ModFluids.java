package example.examplemod.fluid;

import example.examplemod.examplemod;
import example.examplemod.block.ModBlocks;
import example.examplemod.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, examplemod.MODID);

    public static final RegistryObject<FlowingFluid> SOURCE_CRYSTAL_WATER = FLUIDS.register("crystal_water_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.CRYSTAL_WATER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_CRYSTAL_WATER = FLUIDS.register("flowing_crystal_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.CRYSTAL_WATER_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties CRYSTAL_WATER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.CRYSTAL_WATER_FLUID_TYPE, SOURCE_CRYSTAL_WATER, FLOWING_CRYSTAL_WATER)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.CRYSTAL_WATER_BLOCK)
            .bucket(ModItems.CRYSTAL_WATER_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}