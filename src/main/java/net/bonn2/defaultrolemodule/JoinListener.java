package net.bonn2.defaultrolemodule;

import net.bonn2.modules.Module;
import net.bonn2.modules.settings.Settings;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class JoinListener extends ListenerAdapter {

    private final Module module;

    public JoinListener(Module module) {
        this.module = module;
    }

    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        for (Role role : Settings.get(module, event.getGuild().getId(), "default_roles").getAsRoleList(event.getGuild())) {
            event.getGuild().addRoleToMember(event.getMember(), role).queue();
        }
    }
}
