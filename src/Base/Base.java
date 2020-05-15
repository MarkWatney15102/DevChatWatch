package Base;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

import DevChatWatch.DevChatWatchConfig;

public class Base 
{
	public static void init()
	{
		tryToCreatePluginFolder();
		tryToCreateConfigFile();
	}
	
	private static void tryToCreatePluginFolder()
	{
		try {
			new File("plugins/" + DevChatWatchConfig.PLUGIN_NAME).mkdirs();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private static void tryToCreateConfigFile()
	{
		JSONObject json = new JSONObject();
		
		String path = DevChatWatchConfig.PLUGIN_PATH + "/config.json";
		
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
}
