package de.endergamer.utils.font;

import java.awt.Font;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

    public class Fonts {
        public static MinecraftFontRenderer fontMedium;

        public static MinecraftFontRenderer fontMediumBold;

        public static MinecraftFontRenderer fontBig;

        public static MinecraftFontRenderer fontSmall;

        public static MinecraftFontRenderer superFont;

        public static MinecraftFontRenderer dinofansSmall;

        public static MinecraftFontRenderer dinofans;

        private static Font getFont(Map<String, Font> locationMap, String location, int size) {
            Font font;
            try {
                if (locationMap.containsKey(location)) {
                    font = ((Font)locationMap.get(location)).deriveFont(0, size);
                } else {
                    InputStream is = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("endergamer", "/fonts/" + location)).getInputStream();
                    System.out.println(new ResourceLocation("endergamer", "/fonts/" + location).getResourcePath());
                    font = Font.createFont(0, is);
                    locationMap.put(location, font);
                    font = font.deriveFont(0, size);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error loading font");
                font = new Font("default", 0, size);
            }
            return font;
        }

        public static void bootstrap() {
            Map<String, Font> locationMap = new HashMap<>();
            fontSmall = new MinecraftFontRenderer(getFont(locationMap, "Regular.ttf", 17), true, false);
            fontMedium = new MinecraftFontRenderer(getFont(locationMap, "Regular.ttf", 19), true, false);
            fontBig = new MinecraftFontRenderer(getFont(locationMap, "SemiBold.ttf", 21), true, false);
            fontMediumBold = new MinecraftFontRenderer(getFont(locationMap, "SemiBold.ttf", 19), true, false);
            superFont = new MinecraftFontRenderer(getFont(locationMap, "Coffee.ttf", 35), true, false);
            dinofansSmall = new MinecraftFontRenderer(getFont(locationMap, "Dinofans.ttf", 25), true, false);
            dinofans = new MinecraftFontRenderer(getFont(locationMap, "Dinofans.ttf", 32), true, false);
        }
    }
