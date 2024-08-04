package de.endergamer.gui.buttons;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

public class MainButton extends GuiButton {

    ResourceLocation gui = new ResourceLocation("endergamer", "gui.png");
    int v = 153;
    int u = 0;

    public MainButton(int buttonId, int x, int y, String buttonText) {
        super(buttonId, x, y, 48, 23,"");
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if(visible){
            Minecraft.getMinecraft().renderEngine.bindTexture(gui);
            boolean isHovered = mouseX >= xPosition && mouseX <= xPosition + width && mouseY >= yPosition && mouseY <= yPosition + height;
            // Calculate v-coordinate based on hover state
            drawTexturedModalRect(xPosition, yPosition, u, v, width, height);
        }
    }
}
