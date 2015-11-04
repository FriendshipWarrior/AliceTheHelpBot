/**
* @author Dustin Hurst
* CS 3250
* Assignment 4
* The Alice Server Bot that will make simple dynamic replies to the clients messages (questions)
**/

import java.net.*; 
import java.io.*; 

public class AliceServer{
 
	public static void main(String[] args) throws IOException { 
    
	ServerSocket serverSocket = null; 

    	try { 
         	serverSocket = new ServerSocket(9000); 
        } 
    	catch (IOException e) 
        { 
         	System.err.println("Could not listen on port: 9000."); 
         	System.exit(1); 
        } 

    	Socket clientSocket = null; 
    	System.out.println ("Waiting for connection.....");

    	try { 
         	clientSocket = serverSocket.accept(); 
        } 
    	catch (IOException e) { 
         	System.err.println("Accept failed."); 
         	System.exit(1); 
        } 

   	 System.out.println ("You are now connected to Alice");

    	PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true); 
    	BufferedReader in = new BufferedReader( new InputStreamReader( clientSocket.getInputStream())); 

    	String inputLine; 
	
	while ((inputLine = in.readLine()) != null) 
  	{ 
			String userEcho = "You: " + inputLine;
        	String botResponse = "Allice: " + AI.getResponse(inputLine);
			
			System.out.println (userEcho); 
        	out.println(inputLine);
        	
        	System.out.println (botResponse);
        	out.println(botResponse);
        } 
	/*
    	out.close(); 
    	in.close(); 
    	clientSocket.close(); 
    	serverSocket.close(); 
	*/
   	} 

} 
