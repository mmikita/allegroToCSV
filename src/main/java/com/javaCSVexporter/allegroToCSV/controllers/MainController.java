package com.javaCSVexporter.allegroToCSV.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.javaCSVexporter.allegroToCSV.services.GenerateCSV;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

@RestController
public class MainController {
	
@Autowired
GenerateCSV service;

	@RequestMapping(value = "/generate", method= RequestMethod.GET )
	public String products() throws Exception {
		
		
		String command = "curl -X POST https://postman-echo.com/post --data foo1=bar1&foo2=bar2";
		Process process = Runtime.getRuntime().exec(command);


		
		List<String> list = new ArrayList<String>();
		
		try {
			service.generate();
		} catch (CsvDataTypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.call_me();
        return ":)";
	}
	
	
	
	public static void call_me() throws Exception {
	     String url = "http://api.ipinfodb.com/v3/ip-city/?key=d64fcfdfacc213c7ddf4ef911dfe97b55e4696be3532bf8302876c09ebd06b&ip=74.125.45.100&format=json";
	     URL obj = new URL(url);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	     // optional default is GET
	     con.setRequestMethod("GET");
	     //add request header
	     con.setRequestProperty("User-Agent", "Mozilla/5.0");
	     int responseCode = con.getResponseCode();
	     System.out.println("\nSending 'GET' request to URL : " + url);
	     System.out.println("Response Code : " + responseCode);
	     BufferedReader in = new BufferedReader(
	             new InputStreamReader(con.getInputStream()));
	     String inputLine;
	     StringBuffer response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	     //print in String
	     System.out.println(response.toString());
	     //Read JSON response and print
	     JSONObject myResponse = new JSONObject(response.toString());
	     System.out.println("result after Reading JSON Response");
	     System.out.println("statusCode- "+myResponse.getString("statusCode"));
	     System.out.println("statusMessage- "+myResponse.getString("statusMessage"));
	     System.out.println("ipAddress- "+myResponse.getString("ipAddress"));
	     System.out.println("countryCode- "+myResponse.getString("countryCode"));
	     System.out.println("countryName- "+myResponse.getString("countryName"));
	     System.out.println("regionName- "+myResponse.getString("regionName"));
	     System.out.println("cityName- "+myResponse.getString("cityName"));
	     System.out.println("zipCode- "+myResponse.getString("zipCode"));
	     System.out.println("latitude- "+myResponse.getString("latitude"));
	     System.out.println("longitude- "+myResponse.getString("longitude"));
	     System.out.println("timeZone- "+myResponse.getString("timeZone"));  
	   }
	

}
