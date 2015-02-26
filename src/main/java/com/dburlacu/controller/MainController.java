package com.dburlacu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dburlacu.service.ConditieService;
import com.dburlacu.service.PrestatorService;
import com.dburlacu.service.RaionService;
import com.dburlacu.service.SpecificService;


@Controller
@SessionAttributes("idInsotitor")
public class MainController {
	
	@Autowired
	RaionService raionService;
	
	@Autowired
	SpecificService specificService;
	
	@Autowired
	ConditieService conditieService;
	
	@Autowired
	PrestatorService prestatorService;
	
	@RequestMapping(value = {"/", "/mainPage"})
	public String setupTest(Map<String, Object> map)
	{
		return "main";
	}
	
	@RequestMapping(value = "/choose", method=RequestMethod.POST)
	public String chooseOption(@RequestParam(value="action") String action,Map<String, Object> map)
	{
		String option = "main";
		
		System.out.println("action: "+action.toLowerCase());
		
		switch (action.toLowerCase()) {
		case "inregistrarea cererilor":
			
			map.put("raionList", raionService.getAllRaion());
			map.put("specificList", specificService.getAllSpecific());
			map.put("conditieList", conditieService.getAllConditie());
			map.put("conditieInsotitorList", conditieService.getAllConditieForInsotitor());
			
			option="Request";
			
			break;
			
		case "repartizarea biletelor dass":
			
			map.put("specificList", specificService.getAllSpecific());
			map.put("prestatorList", prestatorService.getAllPrestator());
			
			option="repartizareBilete";
			
			break;

		default:
			option="error";
			break;
		}
		
		
		return option;
	}
	
	
	
}

