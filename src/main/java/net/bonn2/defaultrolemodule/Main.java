package net.bonn2.defaultrolemodule;

import net.bonn2.Bot;
import net.bonn2.modules.Module;
import net.bonn2.modules.settings.Settings;
import net.bonn2.modules.settings.types.Setting;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;

public class Main extends Module {

    @Override
    public void registerLoggingChannels() {

    }

    @Override
    public void registerSettings() {
        Settings.register(this, "default_roles", Setting.Type.ROLE_LIST, Setting.Type.ROLE_LIST.unset,
                "A list of roles that will be added to a user when they join the server.");
    }

    @Override
    public void load() {
        Bot.jda.addEventListener(new JoinListener(this));
    }

    @Override
    public CommandData[] getCommands() {
        return new CommandData[0];
    }
}