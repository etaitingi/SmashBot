package com.smashbot.filecreator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReminderFile {
	
	
	public static void createReminder(String authorId, String timeStamp) {
		
		String osName = System.getProperty("os.name", "").toLowerCase();
		String userName = System.getProperty("user.name", "").toLowerCase();
		
		if (osName.startsWith("windows" )) {
	        try {
	            File file = new File("C:/Users/" +userName +"/Desktop/mytmp/ReminderLogger.txt");
	            BufferedWriter output = new BufferedWriter(new FileWriter(file));
	            output.write("AuthorId:" + authorId + " TimeStamp:" + timeStamp);
	            output.close();
	        } catch ( IOException e ) {
	            e.printStackTrace();
	        }
		} else if (osName.startsWith("linux")) {	
	        try {
	            File file = new File("/root/tmp/ReminderLogger.txt");
	            BufferedWriter output = new BufferedWriter(new FileWriter(file));
	            output.write("AuthorId:" + authorId + " TimeStamp:" + timeStamp);
	            output.close();
	        } catch ( IOException e ) {
	            e.printStackTrace();
	        }
		} else {
			System.out.println("Sorry, your operating system is different");	
		}
	
	}

}
