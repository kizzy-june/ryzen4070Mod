package veemo.kizzyjune.ryzen4070;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(ryzen4070.MODID)
public class ryzen4070 {
    public static final String MODID = "ryzen4070";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ryzen4070(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
    }

    @SubscribeEvent
    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Congratulations on your new Ryzen 4070");
    }
}