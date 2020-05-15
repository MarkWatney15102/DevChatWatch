package BadWord;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import DevChatWatch.DevChatWatchConfig;

public class BadWords 
{
	public BadWords() 
	{
		this.tryToCreateBadWordFile();
	}
	
	private void tryToCreateBadWordFile()
	{
		JSONObject json = new JSONObject();
		
		String path = DevChatWatchConfig.PLUGIN_PATH + "/badWords.json";
		
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
		try {
			String file = DevChatWatchConfig.PLUGIN_PATH + "/badWords.json";
			
			JSONParser parser = new JSONParser();
			
			JSONObject json = (JSONObject) parser.parse(new FileReader(file));
			json.put(badWord, badWord);
			
			@SuppressWarnings("resource")
			FileWriter fw = new FileWriter(file);
			fw.write(json.toJSONString());
			fw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
