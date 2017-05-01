package com.smashbot.listeners;

import com.smashbot.discordbot.SmashBotMain;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
 
public class SmashBotListener extends ListenerAdapter {
 
	@Override
	public void onReady(ReadyEvent event) {	
		System.out.println("Bot Listener Ready!");
		//Main.log("status", "Logged in as: " + event.getJDA().getSelfUser().getName());
	}
	
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
        
		if(event.getMessage().getContent().startsWith("!")) {	
			SmashBotMain.handleCommand(SmashBotMain.parser.parse(event.getMessage().getContent().toLowerCase(), event));
		}

    }

}