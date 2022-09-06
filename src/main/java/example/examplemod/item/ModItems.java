package example.examplemod.item;

import example.examplemod.examplemod;
import example.examplemod.base.ModArmorMaterial;
import example.examplemod.block.ModBlocks;
import example.examplemod.fluid.ModFluids;
import example.examplemod.item.custom.CatalystItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, examplemod.MODID);
    
public static final RegistryObject<Item> CRYSTAL = ITEMS.register("crystal", () -> new Item(props()));
public static final RegistryObject<Item> RAWCRYSTAL = ITEMS.register("rawcrystal", () -> new Item(props()));
public static final RegistryObject<Item> CAVEBERRY_SEEDS = ITEMS.register("caveberry_seeds", () -> new ItemNameBlockItem(ModBlocks.CAVEBERRY_CROP.get(), props()));
public static final RegistryObject<Item> CAVEBERRY = ITEMS.register("caveberry", () -> new Item(props().food(new FoodProperties.Builder().nutrition(3).saturationMod(5f).build())));
//  tools
public static final RegistryObject<SwordItem> EXAMPLE_SWORD = ITEMS.register("example_sword", () -> new SwordItem(ToolTiers.EXAMPLE, 3, 2.5f, props()));
public static final RegistryObject<PickaxeItem> EXAMPLE_PICKAXE = ITEMS.register("example_pickaxe", () -> new PickaxeItem(ToolTiers.EXAMPLE, 1, 2.5f, props()));
public static final RegistryObject<ShovelItem> EXAMPLE_SHOVEL = ITEMS.register("example_shovel", () -> new ShovelItem(ToolTiers.EXAMPLE, 1, 1.5f, props()));
public static final RegistryObject<AxeItem> EXAMPLE_AXE = ITEMS.register("example_axe", () -> new AxeItem(ToolTiers.EXAMPLE, 3, 3f, props()));
public static final RegistryObject<HoeItem> EXAMPLE_HOE = ITEMS.register("example_hoe", () -> new HoeItem(ToolTiers.EXAMPLE, 0, 0.1f, props()));
public static final RegistryObject<Item> ROD = ITEMS.register("rod", () -> new Item(props()));
// armor
public static final RegistryObject<ArmorItem> EXAMPLE_HELMET = ITEMS.register("example_helmet", () -> new ArmorItem(ArmorTiers.CRYSTAL, EquipmentSlot.HEAD, props()));
public static final RegistryObject<ArmorItem> EXAMPLE_CHESTPLATE = ITEMS.register("example_chestplate", () -> new ArmorItem(ArmorTiers.CRYSTAL, EquipmentSlot.CHEST, props()));
public static final RegistryObject<ArmorItem> EXAMPLE_LEGS = ITEMS.register("example_leggings", () -> new ArmorItem(ArmorTiers.CRYSTAL, EquipmentSlot.LEGS, props()));
public static final RegistryObject<ArmorItem> EXAMPLE_BOOTS = ITEMS.register("example_boots", () -> new ArmorItem(ArmorTiers.CRYSTAL, EquipmentSlot.FEET, props()));
//fluid
public static final RegistryObject<Item> CRYSTAL_WATER_BUCKET = ITEMS.register("crystal_water_bucket",
            () -> new BucketItem(ModFluids.SOURCE_CRYSTAL_WATER,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));
//Igniter
public static final RegistryObject<Item> CRYSTAL_STAFF = ITEMS.register("crystal_staff", CatalystItem::new);


private static Item.Properties props(){
    return new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB);
}

public static class ToolTiers{
    public static final Tier EXAMPLE = new ForgeTier(5, 5000, 7.5f, 5, 30, null, () -> Ingredient.of(ModItems.CRYSTAL.get()));
}
public static class ArmorTiers{
    private static final ModArmorMaterial CRYSTAL = new ModArmorMaterial(
"example", 5000, new int[] {20, 40, 50, 10}, 30, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0f, 2.0f, () -> Ingredient.of(ModItems.CRYSTAL.get()));
}

public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
    
}
