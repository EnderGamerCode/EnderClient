package de.endergamer.utils;

import gg.essential.elementa.font.FontRenderer;
import gg.essential.elementa.font.data.Font;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class DelayedTask {
    private int counter;
    private Runnable runnable;

    public DelayedTask(Runnable run, int ticks){
        counter = ticks;
        this.runnable = run;
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event){
        if (event.phase != TickEvent.Phase.START) return;

        if(counter <= 0){
            MinecraftForge.EVENT_BUS.unregister(this);
            runnable.run();
        }

        counter--;
    }
}