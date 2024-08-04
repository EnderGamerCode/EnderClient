package de.endergamer.gui;

import de.endergamer.utils.DelayedTask;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import java.util.ArrayList;
import java.util.List;

public class guiCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "enderclient";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getCommandAliases() {
        List<String> aliases = new ArrayList<String>();
        aliases.add("ec");
        return aliases;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        new DelayedTask(new Runnable() {
            @Override
            public void run() {
                Minecraft.getMinecraft().displayGuiScreen(new ConfigMain());
            }
        },1);
    }
}
