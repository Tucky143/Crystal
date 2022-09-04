package example.examplemod.world.dimension;
import example.examplemod.examplemod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {
    public static final ResourceKey<Level> C_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(examplemod.MODID, "crystal"));
    public static final ResourceKey<DimensionType> C_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,
                    new ResourceLocation(examplemod.MODID, "crystal"));

    public static void register() {
        System.out.println("Registering ModDimensions for " + examplemod.MODID);
    }
}