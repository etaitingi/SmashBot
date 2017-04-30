package com.smashbot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import javax.security.auth.login.LoginException;

public class MainClass {

    public static JDA jda; 
    public static final String BOT_TOKEN = "MzA3MDE2NzYzMjIzMTc5MjY1.C-MLpg.7RoFbCXT9_O0H7LNmJLo6hjOPr0";
	
	public static void main(String[] args) {
		
        try {
        	
            jda = new JDABuilder(AccountType.BOT).addEventListener(new SmashBotListener()).setToken(BOT_TOKEN).buildBlocking();
            
        } catch (LoginException | IllegalArgumentException | InterruptedException | RateLimitedException e) {
        	
            e.printStackTrace();
        
        }

	}

}
