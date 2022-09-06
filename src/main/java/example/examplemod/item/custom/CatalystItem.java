package example.examplemod.item.custom;

import example.examplemod.block.ModBlocks;
import example.examplemod.block.custom.*;
import example.examplemod.item.ModCreativeModeTab;
import example.examplemod.world.dimension.ModDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class CatalystItem extends Item {
    public CatalystItem() {
        super(new Properties()
                .tab(ModCreativeModeTab.TUTORIAL_TAB)
                .stacksTo(1)
                .rarity(Rarity.RARE)
        );
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if(context.getPlayer() != null) {
            if(context.getPlayer().level.dimension() == ModDimensions.C_KEY
                    || context.getPlayer().level.dimension() == Level.OVERWORLD) {
                for(Direction direction : Direction.Plane.VERTICAL) {
                    BlockPos framePos = context.getClickedPos().relative(direction);
                    if(((CrystalPortalBlock) ModBlocks.CRYSTAL_PORTAL.get()).trySpawnPortal(context.getLevel(), framePos)) {
                        context.getLevel().playSound(context.getPlayer(), framePos,
                                SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);
                        return InteractionResult.CONSUME;
                    }
                    else return InteractionResult.FAIL;
                }
            }
        }
        return InteractionResult.FAIL;
    }
    
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
       
       if(!pAttacker.level.isClientSide()) {
           ServerLevel world = ((ServerLevel) pAttacker.level);
           BlockPos position = pTarget.blockPosition();
               EntityType.EVOKER_FANGS.spawn(world, null, null, position, 
               MobSpawnType.MOB_SUMMONED, true, true);
               EntityType.EXPERIENCE_ORB.spawn(world, null, null, position, 
               MobSpawnType.MOB_SUMMONED, true, true);

       }
   }
}