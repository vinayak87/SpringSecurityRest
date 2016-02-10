package com.coding.springservice.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.springservice.utility.ParaGraphResourceLoader;
import com.coding.springservice.utility.ParaGraphUtility;
import com.coding.springservice.domain.SearchCriteria;
import com.coding.springservice.utility.ParaGraphUtility;

@Service
public class SearchService {

	@Autowired
	public ParaGraphResourceLoader paraGraphResourceLoader;
	private HashMap<String, Integer> mMap;

	public SearchService() {
		System.out.println("SearchService ...  ");
		if (paraGraphResourceLoader != null) {
			System.out.println("ParaGraph Loader is not Null");
		} else {
			System.out.println("ParaGraph Loader is Null");
		}
	}

	public int getWordCount() {
		int count = 0;
		try {
			paraGraphResourceLoader.showResourceData();
		} catch (IOException e) {
			System.out.println("ParaGraph to Search could not be loaded ");
		}
		String paraText = paraGraphResourceLoader.getParaGraphText();
		System.out.println("getWorCount ...  " + paraText);

		return count;
	}

	public HashMap<String, Integer> performSearch(String[] wordsToSearch) {
		int count = 0;
		System.out.println("performSearch started...  ");

		try {
			paraGraphResourceLoader.showResourceData();
		} catch (IOException e) {
			System.out.println("ParaGraph to Search could not be loaded ");
		}
		String paraText = paraGraphResourceLoader.getParaGraphText();
		mMap = makeWordList(paraText);
		HashMap<String, Integer> searchedMap = new HashMap<String, Integer>();
		int freq = 0;
		for (int k = 0; k < wordsToSearch.length; k++) {
			freq = getFrequencyForWord(wordsToSearch[k], mMap);
			searchedMap.put(wordsToSearch[k], freq);
		}

		return searchedMap;
	}

	public HashMap<String, Integer> makeWordList(String theText) {
		Scanner scan = new Scanner(theText);
		HashMap<String, Integer> listOfWords = new HashMap<String, Integer>();

		while (scan.hasNext()) {
			String word = scan.next(); // scanner automatically uses " " as a
										// delimeter
			int countWord = 0;
			if (!listOfWords.containsKey(word)) { // add word if it isn't added
													// already
				listOfWords.put(word, 1); // first occurance of this word
			} else {
				countWord = listOfWords.get(word) + 1; // get current count and
														// increment
				// now put the new value back in the HashMap
				listOfWords.remove(word); // first remove it (can't have
											// duplicate keys)
				listOfWords.put(word, countWord); // now put it back with new
													// value
			}
		}
		return listOfWords; // return the HashMap you made of distinct words
	}

	public int getDistinctWordCount(HashMap<String, Integer> list) {
		return list.size();
	}

	// get the frequency of the given word
	public int getFrequencyForWord(String word, HashMap<String, Integer> list) {
		Integer cnt = list.get(word);
		return (cnt == null ? 0 : cnt.intValue());
	}

	// get the frequency of the given word
	public int getFrequencyForWord(String word) {
		return mMap.get(word);
	}

	public void performSearchBasic() {
		int count = 0;
		System.out.println("performSearchBasic started...  ");

		try {
			paraGraphResourceLoader.showResourceData();
		} catch (IOException e) {
			System.out.println("ParaGraph to Search could not be loaded ");
		}
		String paraText = paraGraphResourceLoader.getParaGraphText();
		mMap = makeWordList(paraText);
	}
	 public Map<String, Integer> getTopMap(int topSize){
		 HashMap<String, Integer> topMap = new HashMap<String, Integer>();
		 int cnt  = 0; 
		 if( topSize <= mMap.size())
		  {Object[] a = mMap.entrySet().toArray();
		    Arrays.sort(a, new Comparator() {
		        public int compare(Object o1, Object o2) {
		            return ((Map.Entry<String, Integer>) o2).getValue().compareTo(
		                    ((Map.Entry<String, Integer>) o1).getValue());
		        }
		    });
		    
		    for (Object e : a) {
				//System.out.println(((Map.Entry<String, Integer>) e).getKey()) + " : " + ((Map.Entry<String, Integer>) e).getValue());
		       if (cnt < topSize)
		    	{  topMap.put(((Map.Entry<String, Integer>) e).getKey(), ((Map.Entry<String, Integer>) e).getValue());
		    	   cnt++;
		    	}
		    }
		  }
		 else {
			 topMap.put(""+topSize, 0);
		 }
		 
		 return topMap;
	 }

}
