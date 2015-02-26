package com.dburlacu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dburlacu.model.Conditie;
import com.dburlacu.model.JsonResponse;
import com.dburlacu.model.Requests;
import com.dburlacu.model.SubConditie;
import com.dburlacu.service.ConditieService;
import com.dburlacu.service.PrestatorService;
import com.dburlacu.service.RequestsService;
import com.dburlacu.service.SolicitantService;
import com.dburlacu.service.SpecificService;
import com.dburlacu.service.SubConditieService;
import com.dburlacu.service.TichetService;


@Controller
@SessionAttributes("idInsotitor")
public class RequestsController {
	
	private List<SubConditie> subConditieList = new ArrayList<SubConditie>(); 
	
	@Autowired
	private RequestsService reqService;
	
	@Autowired
	private ConditieService conditieService;
	
	@Autowired
	private SubConditieService subConditieService;
	
	@Autowired
	private SolicitantService solicitantService;
	
	@Autowired
	private PrestatorService prestatorService;
	
	@Autowired
	private SpecificService specificService;
	
	@Autowired
	private TichetService tichetService;
	
	
	
	@RequestMapping(value = {"/as"})
	public String setupForm(Map<String, Object> map)
	{

//		Requests requests = new Requests();
//		map.put("requests", requests);
//		map.put("requestsList", reqService.getAllRequests());
		map.put("conditieList", conditieService.getAllConditie());
		return "Request";
	}
	
	@RequestMapping(value = {"/seesionT"})
	public String setupForm1(Map<String, Object> map)
	{
		
		map.put("solicitantiList", solicitantService.getAllSolicitanti());
		return "sessionT";
	}

	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
    public String save(@RequestBody Requests cond){       
		reqService.addRequest(cond);
		return "main";
    }
	
	//private List<SubConditie> condList = new ArrayList<SubConditie>(); 
	
	@RequestMapping(value="/as",method=RequestMethod.POST)
	public @ResponseBody JsonResponse addUser( ){
		JsonResponse res = new JsonResponse();
		return res;
	}
	
	  @RequestMapping(value = "/asaasa", method = RequestMethod.GET)
	   public @ResponseBody  List<SubConditie> productsForCategory(@RequestParam(value="conditionName") String conditie) throws IllegalStateException {
		  Conditie cond = conditieService.getConditieByName(conditie);
			subConditieList = subConditieService.getSubConditieByConditieId(cond);
			System.out.println(subConditieList);
	    return subConditieList;
	   }

	  
}
