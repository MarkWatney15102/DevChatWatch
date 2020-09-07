package Mute;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import DevChatWatch.DevChatWatchConfig;

public class Mute 
{
	public Mute()
	{
		this.tryToCreateMutedUserFile();
	}
	
	private void tryToCreateMutedUserFile()
	{
		JSONObject json = new JSONObject();
		
		String path = DevChatWatchConfig.PLUGIN_PATH + "/muted.json";
		
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
	public void mutePlayer(String username)
	{
		Player player = Bukkit.getPlayer(username);
		
		String file = DevChatWatchConfig.PLUGIN_PATH + "/muted.json";
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject json = (JSONObject) parser.parse(new FileReader(file));
			json.put(player.getName(), player.getName());
			
			this.updateJsonFile(json, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void unMutePlayer(String username) 
	{
		String file = DevChatWatchConfig.PLUGIN_PATH + "/muted.json";
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject json = (JSONObject) parser.parse(new FileReader(file));
			json.remove(username);
			
			this.updateJsonFile(json, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Player> getMutePlayerList()
	{
		ArrayList<Player> player = new ArrayList<Player>();
		
		String file = DevChatWatchConfig.PLUGIN_PATH + "/muted.json";
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject json = (JSONObject) parser.parse(new FileReader(file));
			
			for (Object key : json.keySet()) {
		        String keyStr = (String)key;
		        Object keyvalue = json.get(keyStr);
		        
		        Player p = Bukkit.getPlayer((String)keyvalue);

		        player.add(p);
		    }
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return player;
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
