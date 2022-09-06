package example.examplemod;

import com.mojang.logging.LogUtils;

import example.examplemod.block.ModBlocks;
import example.examplemod.enchantment.ModEnchantments;
import example.examplemod.fluid.ModFluidTypes;
import example.examplemod.fluid.ModFluids;
import example.examplemod.init.EntityInit;
import example.examplemod.init.ItemInit;
import example.examplemod.item.ModItems;
import example.examplemod.villager.ModPois;
import example.examplemod.villager.ModVillagers;
import example.examplemod.world.dimension.ModDimensions;
import example.examplemod.world.feature.ModConfiguredFeatures;
import example.examplemod.world.feature.ModPlacedFeatures;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(examplemod.MODID)
public class examplemod
{
    public static final String MODID = "examplemod";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public examplemod()
    {                              
            IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
            ModDimensions.register();
            ModPois.register(modEventBus);
            ModItems.register(modEventBus);
            ModBlocks.register(modEventBus);
            ModEnchantments.register(modEventBus);
            ModConfiguredFeatures.register(modEventBus);
            ModVillagers.register(modEventBus);
            ModPlacedFeatures.register(modEventBus);
            ModFluids.register(modEventBus);
            ModFluidTypes.register(modEventBus);
            ItemInit.register(modEventBus);
            EntityInit.register(modEventBus);
            

            modEventBus.addListener(this::commonSetup);
    
            MinecraftForge.EVENT_BUS.register(this);
        }
    
        private void commonSetup(final FMLCommonSetupEvent event) {
            event.enqueueWork(() -> {
                ModVillagers.registerPOIs();
            });
    
        }
    
        // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
        @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
        public static class ClientModEvents {
            @SubscribeEvent
            public static void onClientSetup(FMLClientSetupEvent event) {
                
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_CRYSTAL_WATER.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_CRYSTAL_WATER.get(), RenderType.translucent());
            }
        }
    }