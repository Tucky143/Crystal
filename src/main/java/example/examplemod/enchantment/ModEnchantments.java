package example.examplemod.enchantment;

import example.examplemod.examplemod;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
    DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, examplemod.MODID);
public static RegistryObject<Enchantment> Striker = ENCHANTMENTS.register("striker", () -> new StrikerEnchantment(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
public static RegistryObject<Enchantment> Piercer = ENCHANTMENTS.register("piercer", () -> new PiercerEnchantment(Enchantment.Rarity.COMMON, EnchantmentCategory.BOW, EquipmentSlot.MAINHAND));
public static RegistryObject<Enchantment> Boom = ENCHANTMENTS.register("boom", () -> new BoomEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
public static RegistryObject<Enchantment> Swipe = ENCHANTMENTS.register("swipe", () -> new SwipeEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));

public static void register(IEventBus eventBus) {
    ENCHANTMENTS.register(eventBus);
}
}