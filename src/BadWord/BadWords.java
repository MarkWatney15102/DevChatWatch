package BadWord;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import DevChatWatch.Config;

public class BadWords 
{
	public BadWords() 
	{
		this.tryToCreateBadWordFile();
	}
	
	private void tryToCreateBadWordFile()
	{
		JSONObject json = new JSONObject();
		
		String path = Config.PLUGIN_PATH + "/badWords.json";
		
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
				FileWriter fw = new FileWriter(path);
				fw.write(json.toJSONString());
				fw.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void addBadWord(String badWord)
	{
		String file = Config.PLUGIN_PATH + "/badWords.json";
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject json = (JSONObject) parser.parse(new FileReader(file));
			json.put(badWord, badWord);
			
			this.updateJsonFile(json, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeBadWord(String badWord) 
	{
		String file = Config.PLUGIN_PATH + "/badWords.json";
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject json = (JSONObject) parser.parse(new FileReader(file));
			json.remove(badWord);
			
			this.updateJsonFile(json, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<String> getBadWordsList()
	{
		ArrayList<String> badWords = new ArrayList<String>();
		
		String file = Config.PLUGIN_PATH + "/badWords.json";
		JSONParser parser = new JSONParser();
		try {
			JSONObject json = (JSONObject) parser.parse(new FileReader(file));
			
			for (Object key : json.keySet()) {
		        String keyStr = (String)key;
		        Object keyvalue = json.get(keyStr);

		        badWords.add((String) keyvalue);
		    }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return badWords;
	}
	
	private void updateJsonFile(JSONObject json, String filePath)
	{
		try {
			@SuppressWarnings("resource")
			FileWriter fw = new FileWriter(filePath);
			fw.write(json.toJSONString());
			fw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
