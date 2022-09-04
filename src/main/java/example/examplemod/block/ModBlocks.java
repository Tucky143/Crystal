package example.examplemod.block;

import java.util.function.Supplier;

import example.examplemod.examplemod;
import example.examplemod.block.custom.CaveberryCrop;
import example.examplemod.block.custom.CrystalEnderChest;
import example.examplemod.block.custom.CrystalPortalBlock;
import example.examplemod.block.custom.CrystalTable;
import example.examplemod.fluid.ModFluids;
import example.examplemod.item.ModCreativeModeTab;
import example.examplemod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {   
    public static final DeferredRegister<Block> BLOCKS =
   DeferredRegister.create(ForgeRegistries.BLOCKS, examplemod.MODID);
   
   public static final RegistryObject<Block> EXAMPLE_ORE = registerBlock("example_ore",
    () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.AMETHYST)
   .strength(6f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModeTab.TUTORIAL_TAB);
   public static final RegistryObject<Block> BLOCK_EXAMPLE_BLOCK = registerBlock("example_block",
    () -> new Block(BlockBehaviour.Properties.of(Material.AMETHYST)
   .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.TUTORIAL_TAB);
   public static final RegistryObject<Block> DEEPSLATE_EXAMPLE_ORE = registerBlock("deepslate_example_ore",
    () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.AMETHYST)
   .strength(6f).requiresCorrectToolForDrops(),UniformInt.of(3, 7)), ModCreativeModeTab.TUTORIAL_TAB);
   public static final RegistryObject<Block> C_ENDER_CHEST = registerBlock("c_enderchest",
   () -> new CrystalEnderChest(BlockBehaviour.Properties.of(Material.AMETHYST)
  .strength(3f).requiresCorrectToolForDrops()), ModCreativeModeTab.TUTORIAL_TAB);
   public static final RegistryObject<Block> CAVEBERRY_CROP = BLOCKS.register("caveberry_crop",
   () -> new CaveberryCrop(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

   public static final RegistryObject<Block> CRYSTAL_TABLE = registerBlock("crystal_table",
            () -> new CrystalTable(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.TUTORIAL_TAB);
                    void EnderChestBlockEntity(BlockPos pos, BlockState state){
                    }
                    //liquid
public static final RegistryObject<LiquidBlock> CRYSTAL_WATER_BLOCK = BLOCKS.register("crystal_water_block",
            () -> new LiquidBlock(ModFluids.SOURCE_CRYSTAL_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));
//Portal
public static final RegistryObject<Block> CRYSTAL_PORTAL = registerBlockWithoutBlockItem("crystal_portal",
CrystalPortalBlock::new);

   private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
    RegistryObject<T> toReturn = BLOCKS.register(name, block);
    registerBlockItem(name, toReturn, tab);
    return toReturn;
   }
public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, Supplier<T> block, CreativeModeTab tab) {
    return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
   }
   private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
    return BLOCKS.register(name, block);
}

    
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
    