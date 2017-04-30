package com.smashbot;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
 
public class SmashBotListener extends ListenerAdapter {
 
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getMessage().getRawContent().equalsIgnoreCase("ping")) {
            e.getChannel().sendMessage(e.getAuthor().getAsMention() + " Pong!").queue();
        }
    }
 
}