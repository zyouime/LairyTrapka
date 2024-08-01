package me.zyouime.lairytrapka.mixin;

import me.zyouime.lairytrapka.LairyTrapka;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityRenderDispatcher.class)
public class EntityRenderDispatcherMixin {

    @Inject(method = "shouldRender", at = @At("HEAD"), cancellable = true)
    private void should(Entity entity, Frustum frustum, double x, double y, double z, CallbackInfoReturnable<Boolean> cir) {
        if (LairyTrapka.itemRenderer) {
            if (entity instanceof ItemEntity) {
                double distance = 0.0;
                double distance1 = entity.squaredDistanceTo(x, y, z);
                if (distance1 > distance * distance) {
                    cir.setReturnValue(false);
                }
            }
        }
    }
}
