package com.company;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) {
	    var dataGrabber = HttpClient.newHttpClient();
	    var requestBuilder = HttpRequest.newBuilder();
	    var webURI = URI.create("http://universities.hipolabs.com/search?name=Young");
	    var dataRequest = requestBuilder.uri(webURI).build();
		HttpResponse<String> response = null;
		try	{
			response = dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString());
		} catch	(IOException exceptionObject){
			System.out.println("Error connecting to site or network is down.");
		} catch(InterruptedException e)	{
			System.out.println("Connection to server interrupted, please try again.");
		}
		if(response == null)	{
			System.out.println("Something went wrong getting data from the website.");
			System.exit(-1);
		}
		var usefulData = response.body();
		System.out.println(usefulData);
    }
}
