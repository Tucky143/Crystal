package example.examplemod.init;


import example.examplemod.examplemod;
import example.examplemod.entity.DiggerEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, examplemod.MODID);

    public static final RegistryObject<EntityType<DiggerEntity>> EXAMPLE = ENTITIES.register("digger_entity",
            () -> EntityType.Builder.of(DiggerEntity::new, MobCategory.MONSTER).sized(1.0f, 1.0f).build(examplemod.MODID + ":example"));

            public static void register(IEventBus modEventBus) {
                ENTITIES.register(modEventBus); // ADD THIS
            }
}
