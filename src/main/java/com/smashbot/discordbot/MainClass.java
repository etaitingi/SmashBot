package com.smashbot.discordbot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import javax.security.auth.login.LoginException;

import com.smashbot.listeners.CoinFlipperListener;
import com.smashbot.listeners.SmashBotLoggerListener;

public class MainClass {

    public static JDA jda; 
    public static final String BOT_TOKEN = SECRET.TOKEN;
	
	public static void main(String[] args) {
		
        try {
        	
            jda = new JDABuilder(AccountType.BOT).setToken(BOT_TOKEN).buildBlocking();
            jda.addEventListener(new SmashBotLoggerListener());
            jda.addEventListener(new CoinFlipperListener());
            jda.setAutoReconnect(true);
            
        } catch (LoginException | IllegalArgumentException | InterruptedException | RateLimitedException e) {
        	
            e.printStackTrace();
        
        }

	}

}
