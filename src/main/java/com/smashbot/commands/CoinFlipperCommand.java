package com.smashbot.commands;

import com.smashbot.commands.Command;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CoinFlipperCommand implements Command {

	private final String HELP = "~USAGE: !flip";
	public static int numberOfHeads = 0;
	public static int numberOfTails = 0;
	
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		
		if(event.getMessage().getRawContent().toLowerCase().equals("!flip")){
			
			if ( Math.random() < .5) {
				
				event.getTextChannel().sendMessage("Heads!").queue();
				numberOfHeads += 1;
				
			} else {
				
				event.getTextChannel().sendMessage("Tails").queue();
				numberOfTails += 1;
				
			}
			
			
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
		
		System.out.println("Number of Heads: " +numberOfHeads +"\n" + "Number of Tails: " +numberOfTails);
		
		return;
	}

}
