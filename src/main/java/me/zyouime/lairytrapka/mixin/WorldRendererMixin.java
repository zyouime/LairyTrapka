package me.zyouime.lairytrapka.mixin;

import me.zyouime.lairytrapka.LairyTrapka;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public abstract class WorldRendererMixin {


    @Inject(method = "renderEntity", at = @At("HEAD"), cancellable = true)
    private void render(Entity entity, double cameraX, double cameraY, double cameraZ, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, CallbackInfo ci) {
        if (LairyTrapka.itemRenderer) {
            if (entity instanceof ItemEntity) {
                ci.cancel();
            }
        }
    }
}
