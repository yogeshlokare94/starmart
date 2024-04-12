package com.tejovat.starmart.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class WelcomeController {
	
	@Value("${third.party.api.gettodos}")
	private String todaAPIName;
	
	static Map<String, String> stateMap = new HashMap<>();
	
	static 
	{
		stateMap.put("TX", "TEXAS");
		stateMap.put("TN", "Tennessee");
		stateMap.put("NC", "NorthCarilona");
	}
	
	@GetMapping("")
	public String getWelcomeMesage() {
		return "Hey, I'm up now.";
	}
	
	@GetMapping("/welcome")
	public Map<String, String> getWelcomeMesage1() {
		Map<String, String> map = new HashMap<>();
		map.put("status", "Success");
		map.put("data", new Date().toString());
		map.put("errorMessage", "");
		map.put("Thrid party API Name", todaAPIName);
		return map;
	}
	
	@GetMapping("/getFullNameByAbbrevation")
	public Map<String, String> getFullNameByAbbrevation(@RequestParam(value = "countryName", required = false, defaultValue = "TN") String countryName, 
			@RequestParam(value = "countryName2", required = false) String countryName2){
		Map<String, String> map = new HashMap<>();
		if(countryName == null) {
			map.put("Abbrevation", "Pls Enter Name");
		}else {
			String fullName = stateMap.get(countryName);
			map.put("Abbrevation", fullName != null ? fullName : "Not Present in Our Data");
			String fullName2 = stateMap.get(countryName2);
			map.put("Abbrevation2", fullName2 != null ? fullName2 : "Not Present in Our Data");
		}
		return map;
	}
	
	@GetMapping("/getFullNameByAbbrevation/{countryName}/{countryName2}")
	public Map<String, String> getFullNameByAbbrevationByPV(@PathVariable("countryName") String countryName,@PathVariable("countryName2") String countryName2){
		Map<String, String> map = new HashMap<>();
		if(countryName == null) {
			map.put("Abbrevation", "Pls Enter Name");
		}else {
			String fullName = stateMap.get(countryName);
			map.put("Abbrevation", fullName != null ? fullName : "Not Present in Our Data");
			String fullName2 = stateMap.get(countryName2);
			map.put("Abbrevation2", fullName2 != null ? fullName2 : "Not Present in Our Data");
		}
		return map;
	}
}