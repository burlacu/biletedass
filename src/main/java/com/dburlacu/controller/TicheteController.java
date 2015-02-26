package com.dburlacu.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.dburlacu.file.services.ReadTicheteFromExcel;
import com.dburlacu.model.Raion;
import com.dburlacu.model.Repartizare;
import com.dburlacu.model.Requests;
import com.dburlacu.model.Specificari;
import com.dburlacu.model.Tichete;
import com.dburlacu.service.BeneficiarService;
import com.dburlacu.service.ConditieService;
import com.dburlacu.service.InsotitorService;
import com.dburlacu.service.LocalitateService;
import com.dburlacu.service.PrestatorService;
import com.dburlacu.service.RaionService;
import com.dburlacu.service.RepartizareService;
import com.dburlacu.service.RequestsService;
import com.dburlacu.service.SolicitantService;
import com.dburlacu.service.SpecificService;
import com.dburlacu.service.SubConditieService;
import com.dburlacu.service.TichetService;


@Controller
@SessionAttributes("idInsotitor")
public class TicheteController {
	
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
	
	@Autowired
	private RepartizareService repartizareService;
	
	@RequestMapping(value = {"/repartizareFromFile"})
	public String setupTest(Map<String, Object> map)
	{
		
		for(Specificari spec:specificService.getAllSpecific())
		{
			System.out.println(spec.getId_Specific());
		}
		
		for(Tichete tichet:tichetService.getAllTichete())
		{
			System.out.println(tichet.getSpecific().getSpecificName());
			System.out.println(tichet.getPrestator().getPrestatorName());
		}
		
		Requests requests = new Requests();
		map.put("requests", requests);
		map.put("specificList", specificService.getAllSpecific());
		map.put("prestatorList", prestatorService.getAllPrestator());
		return "repartizareBilete";
	}
	
	List<Tichete> lTichet;

	@RequestMapping(value = "/readFile", method=RequestMethod.POST)
	public String someMethod(
			@RequestParam("fileName") MultipartFile file, 
			@RequestParam("prestator") String prestator, 
			@RequestParam("specific") String specific,  
			@RequestParam("costTichet") String costTichet,
			Map<String, Object> map) throws IOException{
	    	lTichet = ReadTicheteFromExcel.readFile(convert(file), prestatorService.getPrestatorByName(prestator), specificService.getSpecificByName(specific), Double.valueOf(costTichet));
			for(Tichete tic:lTichet)
			{
				tichetService.add(tic);
			}
			
			map.put("ticheteList", lTichet);
			
			return "bileteInserate";
		}
	
	public File convert(MultipartFile file) 
	{    
	    File convFile = new File(file.getOriginalFilename());
	    try(FileOutputStream fos = new FileOutputStream(convFile))
	    {
		    convFile.createNewFile(); 
		    fos.write(file.getBytes());
	    }
	    catch(IOException e)
	    {
	    	e.printStackTrace();
	    }
	    
	    
	    return convFile;
	}
	  

	@RequestMapping(value = {"/repartizareperaion"})
	public String setupRepartizarePeRaion(Map<String, Object> map) throws ParseException
	{
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = sf.parse("2015-02-20 14:00:00");
		
		Integer total = beneficiarService.getTotalBeneficiariByDate(date);
		List<Repartizare> repartizareList = new ArrayList<Repartizare>();
		for(Raion r:raionService.getAllRaion())
		{
			Repartizare rep;// = new Repartizare();			
//			BeneficiarData b = beneficiarService.getBeneficiarByRaionAndDate(r, date);
			float k = ((float)beneficiarService.getBeneficiarByRaionAndDate(r, date).getNrBeneficiari()*100)/total;
			System.out.print(" : "+k+": ");
			for(Tichete t:lTichet)
			{
				rep = new Repartizare();
				rep.setRaionId(r);
				rep.setTichet(t);
				rep.setTotalTichet(Math.round((k*(t.getToTichet()-t.getFromTichet()))/100));
				repartizareList.add(rep);
				repartizareService.add(rep);
			}
			System.out.println();
		}
		System.out.println("Tichete List: "+lTichet.size());
		System.out.println("Repartizare List: "+repartizareList.size());
		
		for(Repartizare repar:repartizareList)
		{
			System.out.println(repar.getRaionId().getRaionName()+" : "+Math.round(repar.getTotalTichet())+" : "+repar.getTotalTichet());
		}

		Requests requests = new Requests();
		map.put("requests", requests);
		map.put("specificList", specificService.getAllSpecific());
		map.put("repartizareList", repartizareList);
		return "bileteRepartizate";
	}
}
