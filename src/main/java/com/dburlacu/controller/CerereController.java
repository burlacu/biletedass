package com.dburlacu.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.dburlacu.model.Conditie;
import com.dburlacu.model.Documente;
import com.dburlacu.model.Insotitori;
import com.dburlacu.model.Localitate;
import com.dburlacu.model.Requests;
import com.dburlacu.model.Solicitanti;
import com.dburlacu.model.SubConditie;
import com.dburlacu.service.ConditieService;
import com.dburlacu.service.DocumenteService;
import com.dburlacu.service.InsotitorService;
import com.dburlacu.service.LocalitateService;
import com.dburlacu.service.RaionService;
import com.dburlacu.service.RequestsService;
import com.dburlacu.service.SolicitantService;
import com.dburlacu.service.SpecificService;
import com.dburlacu.service.SubConditieService;


@Controller
@SessionAttributes("idInsotitor")
public class CerereController {
	
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
	private DocumenteService documenteService;
		
	private List<Localitate> localitateList = new ArrayList<Localitate>(); 
	
	 @RequestMapping(value = "/asa", method = RequestMethod.GET)
	   public @ResponseBody  List<Localitate> productsForCategory(@RequestParam(value="conditionName") String conditie) throws IllegalStateException {
		 localitateList = localitateService.getLocalitateByRaionId(raionService.getRaionByName(conditie));
	    return localitateList;
	   }
	 
	 private List<SubConditie> subConditieList = new ArrayList<SubConditie>();

	 
	 @RequestMapping(value = "/subconditie", method = RequestMethod.GET)
	 public @ResponseBody  List<SubConditie> subconditionForCategory(@RequestParam(value="conditionName") String conditie) throws IllegalStateException {
		  Conditie cond = conditieService.getConditieByName(conditie);
			subConditieList = subConditieService.getSubConditieByConditieId(cond);
	    return subConditieList;
	 }
	 
	 private List<SubConditie> subConditieListInsotitor = new ArrayList<SubConditie>();
	 @RequestMapping(value = "/subconditieinsotitor", method = RequestMethod.GET)
	 public @ResponseBody  List<SubConditie> subconditionForInsotitori(@RequestParam(value="conditionName") String conditie) throws IllegalStateException {
		  
		 System.out.println(conditie);
		 Conditie cond = conditieService.getConditieByName(conditie);
		  subConditieListInsotitor = subConditieService.getAllSubConditieForInsotitoriByCondition(cond);
	    return subConditieListInsotitor;
	 }
	 
	@RequestMapping(value="/saveCerere",method=RequestMethod.POST)
	public String save(@RequestParam(value="inputIdnp") String inputIdnpSolicitant, 
			   @RequestParam(value="selectSpecific") String selectSpecific, 
			   @RequestParam(value="inputIdnpInsotitor", required=false) String inputIdnpInsotitor,
			   @RequestParam(value="selectUrgenta") String selectUrgenta, 
			   @RequestParam(value="inregistrareaCererii") String inregistrareaCererii,
			   @RequestParam(value="isAngajat" , required=false) Boolean isAngajat, 
			   @RequestParam(value="inputNameSolicitant" , required=false) String solicitantNume,
			   @RequestParam(value="inputPreNameSolicitant" , required=false) String solicitantPreName,
			   @RequestParam(value="selectLocalitate" , required=false) Integer localitateId,
			   @RequestParam(value="selectSubconditie" , required=false) Integer subconditieId,
			   @RequestParam(value="inputNameInsotitor" , required=false) String inputNameInsotitor,
			   @RequestParam(value="inputPreNameInsotitor" , required=false) String inputPreNameInsotitor,
			   @RequestParam(value="selectLocalitateInsotitor" , required=false) Integer selectLocalitateInsotitor,
			   @RequestParam(value="selectSubconditieInsotitor" , required=false) Integer selectSubconditieInsotitor,
			   @RequestParam(value="isAngajatInsotitor" , required=false) Boolean isAngajatInsotitor, 
			   @RequestParam("file") MultipartFile[] files,
			   Map<String, Object> map) throws ParseException, IOException{      
		
		Integer solNr = solicitantService.findSolicitantByIdnp(inputIdnpSolicitant);
		Integer insNr = insotitorService.findInsotitorByIdnp(inputIdnpInsotitor);
		Solicitanti sol;
		if(solNr < 1)
		{
			sol = new Solicitanti();
			sol.setIdnp(inputIdnpSolicitant);
			sol.setNumeSolicitant(solicitantNume);
			sol.setPrenumeSolicitant(solicitantPreName);
			sol.setLocalitate(localitateService.getLocalitateById(localitateId));
			sol.setSubConditieSolicitant(subConditieService.getSubConditieById(subconditieId));
			if(!isAngajat.equals(null))
			{
				sol.setIsAngajat(1);
			}
			else
			{
				sol.setIsAngajat(0);
			}
			solicitantService.add(sol);
			
		}
		else
		{
			sol = solicitantService.getSolicitantByIdnp(inputIdnpSolicitant);
		}
		
		Insotitori ins;
		if(insNr < 1 && !inputIdnpInsotitor.isEmpty())
		{
			ins = new Insotitori();
			ins.setIdnp(inputIdnpInsotitor);
			if(!isAngajatInsotitor.equals(null))
			{
				ins.setIsAngajat(1);
			}
			else
			{
				ins.setIsAngajat(0);
			}
			ins.setLocalitate(localitateService.getLocalitateById(selectLocalitateInsotitor));
			ins.setSubConditieInsotitor(subConditieService.getSubConditieById(selectSubconditieInsotitor));
			ins.setNumeInsotitor(inputNameInsotitor);
			ins.setPrenumeInsotitor(inputPreNameInsotitor);
			insotitorService.add(ins);
			
		}
		else
		{
			if(!inputIdnpInsotitor.equals(null)){
			sol = solicitantService.getSolicitantByIdnp(inputIdnpSolicitant);
			}
		}
		Requests requests2 = new Requests();
		if(selectUrgenta.equals("-"))
		{
			requests2.setIsUrgent(0);
		}
		else
		{
			requests2.setIsUrgent(1);
		}
		if(inputIdnpInsotitor!=null && !inputIdnpInsotitor.isEmpty())
		{
			requests2.setInsotitori(insotitorService.getInsotitoriByIdnp(inputIdnpInsotitor));
		}
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
		Date date = sf.parse(inregistrareaCererii);
		requests2.setRequestDate(date);

		requests2.setSolicitanti(sol);
		requests2.setSpecificari(specificService.getSpecificByName(selectSpecific));
		
		reqService.addRequest(requests2);
		
		for (int i = 0; i < files.length; i++) {
			Documente doc = null;
			if(files[i].getSize()>2)
			{
				MultipartFile file = files[i];

				Blob blob = Hibernate.createBlob(file.getInputStream());
				
				doc = new Documente();
				doc.setDocName(convert(file).getName());
				doc.setDocumentBlob(blob);
				doc.setRequest(requests2);
				
				documenteService.add(doc);
			}
		}
		return "main";
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
	  
}
