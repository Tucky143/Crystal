package example.examplemod.block.custom;

import java.util.Optional;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.CompoundContainer;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.PlayerEnderChestContainer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.EnderChestBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.entity.EnderChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;

public class CrystalEnderChest extends EnderChestBlock{
    private static final Component CONTAINER_TITLE = Component.translatable("block.examplemod.c_enderchest");
    public static final EnumProperty<ChestType> TYPE = BlockStateProperties.CHEST_TYPE;
    public Optional<Container> acceptDouble(ChestBlockEntity p_51591_, ChestBlockEntity p_51592_) {
      return Optional.of(new CompoundContainer(p_51591_, p_51592_));
   }
    public CrystalEnderChest(Properties prop) {
        super(prop);
    }
    
         public void getMaxStackSize(Container con, Inventory inv){
ChestMenu.sixRows(17, inv, con);
         }
         private static final DoubleBlockCombiner.Combiner<ChestBlockEntity, Optional<MenuProvider>> MENU_PROVIDER_COMBINER = new DoubleBlockCombiner.Combiner<ChestBlockEntity, Optional<MenuProvider>>() {
            public Optional<MenuProvider> acceptDouble(final ChestBlockEntity p_51604_, final ChestBlockEntity p_51605_) {
               final Container container = new CompoundContainer(p_51604_, p_51605_);
               return Optional.of(new MenuProvider() {
                  @Nullable
                  public AbstractContainerMenu createMenu(int p_51622_, Inventory p_51623_, Player p_51624_) {
                     if (p_51604_.canOpen(p_51624_) && p_51605_.canOpen(p_51624_)) {
                        p_51604_.unpackLootTable(p_51623_.player);
                        p_51605_.unpackLootTable(p_51623_.player);
                        return ChestMenu.sixRows(p_51622_, p_51623_, container);
                     } else {
                        return null;
                     }
                  }
      
                  public Component getDisplayName() {
                     if (p_51604_.hasCustomName()) {
                        return p_51604_.getDisplayName();
                     } else {
                        return (Component)(p_51605_.hasCustomName() ? p_51605_.getDisplayName() : Component.translatable("block.examplemod.c_enderchest"));
                     }
                  }
               });
            }
            public static DoubleBlockCombiner.BlockType getBlockType(BlockState p_51583_) {
               ChestType chesttype = p_51583_.getValue(TYPE);
               if (chesttype == ChestType.SINGLE) {
                  return DoubleBlockCombiner.BlockType.SINGLE;
               } else {
                  return chesttype == ChestType.RIGHT ? DoubleBlockCombiner.BlockType.FIRST : DoubleBlockCombiner.BlockType.SECOND;
               }
            }
            public Optional<MenuProvider> acceptSingle(ChestBlockEntity p_51602_) {
               return Optional.of(p_51602_);
            }
      
            public Optional<MenuProvider> acceptNone() {
               return Optional.empty();
            }
         };
      
    
    
    @Nullable
   public static Container getContainer(CrystalEnderChest p_51512_, BlockState p_51513_, Level p_51514_, BlockPos p_51515_, boolean p_51516_) {
      return p_51512_.combine(p_51513_, p_51514_, p_51515_, p_51516_).<Optional<Container>>apply(null).orElse((Container)getContainer(p_51512_, p_51513_, p_51514_, p_51515_, p_51516_));
   }
    public InteractionResult use(BlockState p_53137_, Level p_53138_, BlockPos p_53139_, Player p_53140_, InteractionHand p_53141_, BlockHitResult p_53142_) {
        PlayerEnderChestContainer playerenderchestcontainer = p_53140_.getEnderChestInventory();
        BlockEntity blockentity = p_53138_.getBlockEntity(p_53139_);
        if (playerenderchestcontainer != null && blockentity instanceof EnderChestBlockEntity) {
           BlockPos blockpos = p_53139_.above();
           if (p_53138_.getBlockState(blockpos).isRedstoneConductor(p_53138_, blockpos)) {
              return InteractionResult.sidedSuccess(p_53138_.isClientSide);
           } else if (p_53138_.isClientSide) {
              return InteractionResult.SUCCESS;
           } else {
              EnderChestBlockEntity enderchestblockentity = (EnderChestBlockEntity)blockentity;
              playerenderchestcontainer.setActiveChest(enderchestblockentity);
              p_53140_.openMenu(new SimpleMenuProvider((p_53124_, p_53125_, p_53126_) -> {
                 return ChestMenu.threeRows(p_53124_, p_53125_, playerenderchestcontainer);
              }, CONTAINER_TITLE));
              p_53140_.awardStat(Stats.OPEN_ENDERCHEST);
              PiglinAi.angerNearbyPiglins(p_53140_, true);
              return InteractionResult.CONSUME;
           }
        } else {
           return InteractionResult.sidedSuccess(p_53138_.isClientSide);
        }
     }
     @Override
   public
      RenderShape getRenderShape(BlockState p_49232_) {
      return RenderShape.MODEL;
   }
     public BlockEntity newBlockEntity(BlockPos p_153208_, BlockState p_153209_) {
        return new EnderChestBlockEntity(p_153208_, p_153209_);
     }
    
    
}
