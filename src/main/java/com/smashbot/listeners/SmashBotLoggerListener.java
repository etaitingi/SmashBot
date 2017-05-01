package com.smashbot.listeners;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
 
public class SmashBotLoggerListener extends ListenerAdapter {
 
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
    	
        if (event.isFromType(ChannelType.PRIVATE))
        {
            System.out.printf("[PM] %s: %s\n", 
            		event.getAuthor().getName(),
                    event.getMessage().getContent());
        }
        else
        {
            System.out.printf("[%s][%s] %s: %s\n", 
        			event.getGuild().getName(),
                    event.getTextChannel().getName(), 
                    event.getMember().getEffectiveName(),
                    event.getMessage().getContent());
        }

    }

}