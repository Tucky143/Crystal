package example.examplemod.init;

import example.examplemod.examplemod;
import example.examplemod.item.ModCreativeModeTab;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, examplemod.MODID);
    public static final RegistryObject<ForgeSpawnEggItem> DIGGER_ENTITY_SPAWN_EGG = ITEMS.register("digger_entity_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.EXAMPLE, 0xFF55AA, 0x27DA9F, props().stacksTo(16)));

    private static Item.Properties props() {
        return new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB);
    }

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
