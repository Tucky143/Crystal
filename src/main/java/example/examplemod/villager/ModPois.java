package example.examplemod.villager;

import com.google.common.collect.ImmutableSet;

import example.examplemod.examplemod;
import example.examplemod.block.ModBlocks;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPois {
    public static final DeferredRegister<PoiType> POI
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, examplemod.MODID);

    public static final RegistryObject<PoiType> CRYSTAL_PORTAL =
            POI.register("crystal_portal", () -> new PoiType(
                    ImmutableSet.copyOf(ModBlocks.CRYSTAL_PORTAL.get().getStateDefinition().getPossibleStates())
                    , 0, 1));


    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
    }
}