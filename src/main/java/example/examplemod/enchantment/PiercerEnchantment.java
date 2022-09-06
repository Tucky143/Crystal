package example.examplemod.enchantment;

import example.examplemod.item.ModCreativeModeTab;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class PiercerEnchantment extends Enchantment{

    public PiercerEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
        this.isTradeable();
        ModCreativeModeTab.TUTORIAL_TAB.getId();
        ModCreativeModeTab.TUTORIAL_TAB.hasEnchantmentCategory(pCategory);

    }
   
     @Override
     public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        
        if(!pAttacker.level.isClientSide()) {
            ServerLevel world = ((ServerLevel) pAttacker.level);
            BlockPos position = pTarget.blockPosition();

            if(pLevel == 1){
                EntityType.TNT.spawn(world, null, null, position, 
                MobSpawnType.TRIGGERED, true, true);
            }
            if(pLevel == 2){
                EntityType.TNT.spawn(world, null, null, position, 
                MobSpawnType.TRIGGERED, true, true);
                EntityType.DRAGON_FIREBALL.spawn(world, null, null, position, 
                MobSpawnType.TRIGGERED, true, true);
            }
            if(pLevel == 3){
                EntityType.TNT.spawn(world, null, null, position, 
                MobSpawnType.TRIGGERED, true, true);
                EntityType.TNT.spawn(world, null, null, position, 
                MobSpawnType.TRIGGERED, true, true);
                EntityType.DRAGON_FIREBALL.spawn(world, null, null, position, 
                MobSpawnType.TRIGGERED, true, true);
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
    @Override
    public int getMaxLevel() {
        return 3;
     }
     @Override
     public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return stack.canApplyAtEnchantingTable(this);
     }
}
