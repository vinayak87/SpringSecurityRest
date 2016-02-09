package com.coding.springservice.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

	// private Connection connection;

	@Autowired
	public ParaGraphResourceLoader paraGraphResourceLoader;
	private HashMap<String, Integer>  mMap ;

	public SearchService() {
		System.out.println("SearchService ...  ");
		if (paraGraphResourceLoader != null) {
			System.out.println("ParaGraph Loader is not Null");
		} else {
			System.out.println("ParaGraph Loader is Null");
		}
	}

	/*
	 * public int getUserCount(){ int count=0; try { Statement statement =
	 * connection.createStatement(); ResultSet rs =
	 * statement.executeQuery("select count(*) as count from tblUser"); while
	 * (rs.next()) { count=rs.getInt("count"); } } catch (SQLException e) {
	 * e.printStackTrace(); } return count; }
	 */
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

	public HashMap<String, Integer> performSearch(String [] wordsToSearch) {
		int count = 0;
		System.out.println("performSearch started...  ");

		try {
			paraGraphResourceLoader.showResourceData();
		} catch (IOException e) {
			System.out.println("ParaGraph to Search could not be loaded ");
		}
		String paraText = paraGraphResourceLoader.getParaGraphText();
		mMap =  makeWordList(paraText);
		HashMap<String, Integer> searchedMap  = new HashMap<String, Integer>();
		int freq = 0;
		for (int k =0 ; k <wordsToSearch.length ; k++ ){
			  freq  = getFrequencyForWord(wordsToSearch[k],mMap);
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
		return list.get(word);
	}

	/*
	 * public void addUser(SearchCriteria user) { try {
	 * 
	 * PreparedStatement preparedStatement = connection .prepareStatement(
	 * "insert into tblUser(userid,firstname,lastname,email) values (?,?, ?, ? )"
	 * ); // Parameters start with 1 preparedStatement.setInt(1,
	 * user.getUserid()); preparedStatement.setString(2, user.getFirstName());
	 * preparedStatement.setString(3, user.getLastName());
	 * preparedStatement.setString(4, user.getEmail());
	 * preparedStatement.executeUpdate();
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } }
	 * 
	 * public void deleteUser(int userId) { try { PreparedStatement
	 * preparedStatement = connection
	 * .prepareStatement("delete from tblUser where userid=?"); // Parameters
	 * start with 1 preparedStatement.setInt(1, userId);
	 * preparedStatement.executeUpdate(); } catch (SQLException e) {
	 * e.printStackTrace(); } }
	 * 
	 * public void updateUser(SearchCriteria user) throws ParseException { try {
	 * PreparedStatement preparedStatement = connection
	 * .prepareStatement("update tblUser set lastname=?,email=?" +
	 * "where userid=?"); // Parameters start with 1
	 * preparedStatement.setString(1, user.getLastName());
	 * preparedStatement.setString(2, user.getEmail());
	 * preparedStatement.setInt(3, user.getUserid());
	 * preparedStatement.executeUpdate();
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } }
	 * 
	 * public List<SearchCriteria> getAllUsers() { List<SearchCriteria> users =
	 * new ArrayList<SearchCriteria>(); try { Statement statement =
	 * connection.createStatement(); ResultSet rs =
	 * statement.executeQuery("select * from tblUser limit 15"); while
	 * (rs.next()) { SearchCriteria user = new SearchCriteria();
	 * user.setUserid(rs.getInt("userid"));
	 * user.setFirstName(rs.getString("firstname"));
	 * user.setLastName(rs.getString("lastname"));
	 * user.setEmail(rs.getString("email")); users.add(user); } } catch
	 * (SQLException e) { e.printStackTrace(); }
	 * 
	 * return users; }
	 */

	/*
	 * public SearchCriteria getUserById(int userId) { SearchCriteria user = new
	 * SearchCriteria(); try { PreparedStatement preparedStatement = connection.
	 * prepareStatement("select * from tblUser where userid=?");
	 * preparedStatement.setInt(1, userId); ResultSet rs =
	 * preparedStatement.executeQuery();
	 * 
	 * if (rs.next()) { user.setUserid(rs.getInt("userid"));
	 * user.setFirstName(rs.getString("firstname"));
	 * user.setLastName(rs.getString("lastname"));
	 * 
	 * user.setEmail(rs.getString("email")); } } catch (SQLException e) {
	 * e.printStackTrace(); } return user; }
	 */
}
