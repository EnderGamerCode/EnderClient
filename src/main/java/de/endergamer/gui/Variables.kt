package de.endergamer.gui

import net.minecraft.client.Minecraft

class Variables {
    companion object {
        @JvmStatic
        var currentCategory = "main"
            set(value) {
                field = value
                when (value) {
                    "main" -> Minecraft.getMinecraft().displayGuiScreen(ConfigMain())
                    "dung" -> Minecraft.getMinecraft().displayGuiScreen(ConfigDung())
                }
            }
    }
}