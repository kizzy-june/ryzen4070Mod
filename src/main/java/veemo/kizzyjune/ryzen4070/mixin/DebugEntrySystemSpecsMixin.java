package veemo.kizzyjune.ryzen4070.mixin;

import com.mojang.blaze3d.platform.GLX;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.debug.DebugEntrySystemSpecs;
import net.minecraft.client.gui.components.debug.DebugScreenDisplayer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunk;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.util.List;
import java.util.Locale;

@Mixin(DebugEntrySystemSpecs.class)
public class DebugEntrySystemSpecsMixin {
    @Shadow @Final
    public static Identifier GROUP;

    @Inject(method = "display", at = @At("HEAD"), cancellable = true)
    public void customF3(DebugScreenDisplayer displayer, Level serverOrClientLevel, LevelChunk clientChunk, LevelChunk serverChunk, CallbackInfo ci) {
        displayer.addToGroup(GROUP, List.of(
                String.format(Locale.ROOT, "Java: %s", System.getProperty("java.version")),
                String.format(Locale.ROOT, "CPU: %s", GLX._getCpuInfo()),
                "GPU: Ryzen 4070",
                String.format(Locale.ROOT, "Display: %dx%d (AMD)",
                        Minecraft.getInstance().getWindow().getWidth(),
                        Minecraft.getInstance().getWindow().getHeight()
                )
        ));
        ci.cancel();
    }
}