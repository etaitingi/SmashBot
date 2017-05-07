package com.smashbot.discordbot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import java.util.HashMap;

import javax.security.auth.login.LoginException;

import com.smashbot.commands.CoinFlipperCommand;
import com.smashbot.commands.Command;
import com.smashbot.commands.CommandParser;
import com.smashbot.commands.PingCommand;
import com.smashbot.commands.ReminderCommand;
import com.smashbot.listeners.CoinFlipperListener;
import com.smashbot.listeners.SmashBotListener;

public class SmashBotMain {

    public static JDA jda; 
	public static HashMap<String, Command> commands = new HashMap<String, Command>();
	public static final CommandParser parser = new CommandParser();
	
	public static void main(String[] args) {
		
        try {        	
            jda = new JDABuilder(AccountType.BOT).setToken(SECRET.TOKEN).buildBlocking();
            jda.addEventListener(new SmashBotListener());
            jda.addEventListener(new CoinFlipperListener());
            jda.setAutoReconnect(true);
        } catch (LoginException | IllegalArgumentException | InterruptedException | RateLimitedException e) {
            e.printStackTrace();
        }
        
        commands.put("ping", new PingCommand());
        commands.put("flip", new CoinFlipperCommand());
        commands.put("reminder", new ReminderCommand());
	commands.put("trivia", new TriviaCommand());

	}
	
	public static void handleCommand(CommandParser.CommandContainer cmd){
		
		if(commands.containsKey(cmd.invoke)){
			boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);
			
			if(safe) {
				commands.get(cmd.invoke).action(cmd.args, cmd.event);
				commands.get(cmd.invoke).executed(safe, cmd.event);
			} else {
				commands.get(cmd.invoke).executed(safe, cmd.event);
			}
		}
		
	}

}
