package com.smashbot.commands;

import com.smashbot.discordbot.SmashBotMain;
import com.smashbot.filecreator.ReminderFile;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class ReminderCommand implements Command{
	
	private final String HELP = "~USAGE: !reminder";

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		
		if(event.getMessage().getRawContent().toLowerCase().equals("!reminder")){
			
			ReminderFile.createReminder(event.getAuthor().getId(), event.getMessage().getCreationTime().toString());
				
					
		} else {
			event.getTextChannel().sendMessage("how this message get here?").queue();
		}
		
	}

	@Override
	public String help() {
		return HELP;
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		return;
	}

}
