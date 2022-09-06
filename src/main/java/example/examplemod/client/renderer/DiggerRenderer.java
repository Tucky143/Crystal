
package example.examplemod.client.renderer;

import example.examplemod.examplemod;
import example.examplemod.client.models.DiggerEntityModel;
import example.examplemod.entity.DiggerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DiggerRenderer extends MobRenderer<DiggerEntity, DiggerEntityModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(examplemod.MODID, "textures/entitiy/diggerentity.png");

    public DiggerRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new DiggerEntityModel(ctx.bakeLayer(DiggerEntityModel.LAYER_LOCATION)), 0.5f);
    }

    public ResourceLocation getTextureLocation(DiggerEntity entity) {
        return TEXTURE;
    }
}