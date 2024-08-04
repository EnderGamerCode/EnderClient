package de.endergamer;

import de.endergamer.gui.guiCommand;
import de.endergamer.utils.EnderFont;
import de.endergamer.utils.font.Fonts;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "enderclient",name = "EnderClient", useMetadata=true, version = EnderClient.VERSION)
public class EnderClient {

    public static final String PREFIX = "§8[§6Ender Client§8]§1 ";
    public static final String VERSION = "1.0.0";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new guiCommand());
        EnderFont.INSTANCE.init();
    }
    public static void message(String message) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(PREFIX+message));
    }
}
