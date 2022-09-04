package example.examplemod.villager;
import com.google.common.collect.ImmutableSet;

import example.examplemod.examplemod;
import example.examplemod.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, examplemod.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, examplemod.MODID);

    public static final RegistryObject<PoiType> CRYSTAL_TABLE_POI = POI_TYPES.register("crystal_table_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.CRYSTAL_TABLE.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> CRYSTAL_MASTER = VILLAGER_PROFESSIONS.register("crystal_master",
            () -> new VillagerProfession("crystal_master", x -> x.get() == CRYSTAL_TABLE_POI.get(),
                    x -> x.get() == CRYSTAL_TABLE_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_ARMORER));
                    public static final RegistryObject<PoiType> NOOB_POI = POI_TYPES.register("noob_poi",
                    () -> new PoiType(ImmutableSet.copyOf(Blocks.CRAFTING_TABLE.getStateDefinition().getPossibleStates()),
                            1, 1));
        
            public static final RegistryObject<VillagerProfession> NOOB = VILLAGER_PROFESSIONS.register("noob",
                    () -> new VillagerProfession("noob", x -> x.get() == NOOB_POI.get(),
                            x -> x.get() == NOOB_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                            SoundEvents.ROOTED_DIRT_BREAK));

    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, CRYSTAL_TABLE_POI.get());
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}