package example.examplemod.enchantment;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class SwipeEnchantment extends Enchantment {
   private int type;

public SwipeEnchantment(Enchantment.Rarity p_45186_, EnchantmentCategory pCategory, EquipmentSlot... p_45187_) {
    super(p_45186_, pCategory, p_45187_);
}
public float getDamageBonus(int p_44635_, MobType p_44636_) {
    if (this.type == 0) {
       return 1.0F + (float)Math.max(0, p_44635_ - 1) * 0.5F;
    } else if (this.type == 1 && p_44636_ == MobType.UNDEAD) {
       return (float)p_44635_ * 2.5F;
    } else {
       return this.type == 2 && p_44636_ == MobType.ARTHROPOD ? (float)p_44635_ * 2.5F : 0.0F;
    }
 }

 public boolean checkCompatibility(Enchantment p_44644_) {
    return !(p_44644_ instanceof SwipeEnchantment);
 }

 public boolean canEnchant(ItemStack p_44642_) {
    return p_44642_.getItem() instanceof AxeItem ? true : super.canEnchant(p_44642_);
 }

 public void doPostAttack(LivingEntity p_44638_, Entity p_44639_, int p_44640_) {
    if (p_44639_ instanceof LivingEntity livingentity) {
       if (this.type == 2 && p_44640_ > 0 && livingentity.getMobType() == MobType.ARTHROPOD) {
          int i = 20 + p_44638_.getRandom().nextInt(10 * p_44640_);
          livingentity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, i, 3));
       }
    }

 }

   public int getMinCost(int p_45190_) {
      return 5 + (p_45190_ - 1) * 9;
   }

   public int getMaxCost(int p_45192_) {
      return this.getMinCost(p_45192_) + 15;
   }

   public int getMaxLevel() {
      return 3;
   }

   public static float getSweepingDamageRatio(int p_45194_) {
      return 1.0F - 1.0F / (float)(p_45194_ + 1);
   }
}