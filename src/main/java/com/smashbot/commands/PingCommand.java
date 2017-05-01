package com.smashbot.commands;

import com.smashbot.commands.Command;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class PingCommand implements Command {

	private final String HELP = "~USAGE: !ping";
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		
		if(event.getMessage().getRawContent().toLowerCase().equals("!ping")){
			event.getTextChannel().sendMessage("pong!").queue();
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
