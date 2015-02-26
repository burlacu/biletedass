package com.dburlacu.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dburlacu.model.BeneficiarData;
import com.dburlacu.model.Raion;
import com.dburlacu.model.Requests;
import com.dburlacu.service.BeneficiarService;
import com.dburlacu.service.ConditieService;
import com.dburlacu.service.InsotitorService;
import com.dburlacu.service.LocalitateService;
import com.dburlacu.service.PrestatorService;
import com.dburlacu.service.RaionService;
import com.dburlacu.service.RequestsService;
import com.dburlacu.service.SolicitantService;
import com.dburlacu.service.SpecificService;
import com.dburlacu.service.SubConditieService;
import com.dburlacu.service.TichetService;


@Controller
@SessionAttributes("idInsotitor")
public class RepartizareController {
	
	@Autowired
	private RaionService raionService;
	
	@Autowired
	private LocalitateService localitateService;
	
	@Autowired
	private RequestsService reqService;
	
	@Autowired
	private SpecificService specificService;
	
	@Autowired
	private InsotitorService insotitorService;
	
	@Autowired
	private SolicitantService solicitantService;
	
	@Autowired
	private ConditieService conditieService;
	
	@Autowired
	private SubConditieService subConditieService;
		
	@Autowired
	private PrestatorService prestatorService;
	
	@Autowired
	private TichetService tichetService;
	
	@Autowired
	private BeneficiarService beneficiarService;
	
//	@RequestMapping(value = {"/repartizareperaion"})
//	public String setupTest(Map<String, Object> map) throws ParseException
//	{
//		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		Date date = sf.parse("2015-02-20 14:00:00");
//		
//		Integer total = beneficiarService.getTotalBeneficiariByDate(date);
//		
//		for(Raion r:raionService.getAllRaion())
//		{
//			BeneficiarData b = beneficiarService.getBeneficiarByRaionAndDate(r, date);
//			float d = ((float)b.getNrBeneficiari()*100)/total;
//			System.out.print(" : "+d+": ");
//			System.out.println();
//		}
//
//		Requests requests = new Requests();
//		map.put("requests", requests);
//		map.put("specificList", specificService.getAllSpecific());
//		map.put("prestatorList", prestatorService.getAllPrestator());
//		return "main";
//	}

}

