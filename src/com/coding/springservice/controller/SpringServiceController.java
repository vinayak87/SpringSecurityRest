package com.coding.springservice.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import au.com.bytecode.opencsv.CSVWriter;

import com.coding.springservice.dao.SearchService;
import com.coding.springservice.domain.MyRequest;
import com.coding.springservice.domain.SearchCriteria;
import com.coding.springservice.response.CustomResponse;

/**
 * SpringServiceController handles the 2 REST request's 
 * 
 * 1. http://host/counter-api/search  (POST)
 * 
 * 2. http://host/counter-api/top/20   (GET)
 * 
 * It invokes the SearchService which performs the Search.
 * A SearchCriteria is formed from the RequestBody
 * 
 * The ParaGraphResourceLoader is used to Load the resources/paragraph.txt
 * 
 * 
 * @author ADMINIBM
 *
 */

@RestController
public class SpringServiceController {
	
	@Autowired
	public SearchService searchService;
	     	    
	/*@RequestMapping(value = "/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public SearchCriteria getUser(@PathVariable int id) {
		SearchCriteria user=searchService.getUserById(id);
		return user;
	}
	
	@RequestMapping(method = RequestMethod.GET,headers="Accept=application/json")
	public List<SearchCriteria> getAllUsers() {
		List<SearchCriteria> users=searchService.getAllUsers();
		return users;
	}*/
	
	
	
	@RequestMapping(value = "/search",method = RequestMethod.POST,headers="Accept=application/json")
	public HashMap<String, Integer> getSearch(@RequestBody SearchCriteria searchText) {
		int count  =9;
		System.out.println("getSearch ... "); 
		System.out.println(" searchText to String "+searchText.toString());
		HashMap<String, Integer> mMap =searchService.performSearch(searchText.getSearchText());
		return mMap;
		
		
	}
	
	@RequestMapping(value = "/top/{id}",method = RequestMethod.GET, headers="Accept=text/csv")
    @ResponseBody // indicate to use a compatible HttpMessageConverter
	public void getTopCSV(@PathVariable int id ,HttpServletRequest request, HttpServletResponse response) {
		int count=id;
		System.out.println("get Top CSV Called ....... ");
		response.setContentType("text/csv;charset=utf-8"); 
	    response.setHeader("Content-Disposition","attachment; filename=\""+id+".csv\"");
		HashMap myMap  = new HashMap();
		myMap.put("text", 100);
		myMap.put("text2", 91);
		myMap.put("text3", 80);
		myMap.put("text4", 70);
		myMap.put("text5", 60);
		
		OutputStream resOs =null;
		try {
			resOs = response.getOutputStream();
		} catch (IOException e) {
			System.out.println("getTopCSV response getOutputStream error ");
		}  
	    OutputStream buffOs= new BufferedOutputStream(resOs);   
	    OutputStreamWriter outputwriter = new OutputStreamWriter(buffOs);  
	    CSVWriter writer = new CSVWriter(outputwriter, '\u0009');
	      
	       Set keys  = myMap.keySet();
	       Iterator valIter = keys.iterator();
	       while (valIter.hasNext())
	       {    String key =  (String)valIter.next();
	            Integer value =  (Integer)myMap.get(key);
	            String[] arry = new String [2];
	            arry[0] = key; 
	            arry[1] = value.toString();
	            writer.writeNext(arry);
	       }
	       try {
			writer.close();
		   } catch (IOException e) {
			System.out.println("CSVWriter writer close failed ");
		  }
		
		//return new CustomResponse(myMap, id);
	}
	
	
	/*@RequestMapping(value = "/search",method = RequestMethod.POST,headers="Accept=application/json")
	public HashMap<String, Integer> getSearch(@RequestBody SearchCriteria searchCriteria) {
		
		List <String > wordList  = searchCriteria.getValues();
		
		
		HashMap<String, Integer> mMap =searchService.performSearch(wordList.toArray(new String [wordList.size()]));
		return mMap;
	}*/
	
	
	/*@RequestMapping(value = "/top/{id}",method = RequestMethod.GET,headers="Accept=application/json")
	public Integer getTop(@PathVariable int id) {
		int count=id;
		System.out.println("get Top Called ....... ");
		
		return count;
	}
	*/
	
}
