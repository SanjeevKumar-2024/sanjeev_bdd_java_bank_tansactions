package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
 
public class jsonHelper {
	
	public String updateJsonBody(HashMap<String, String> payloadData) {
		String jsonBody = null;
		try {
			String payloadFile = payloadData.get("RESOURCE").contains("create")?"createAccount":"accountTransaction";
			jsonBody = new String(Files.readAllBytes(Paths.get("src/test/resources/payloads/" + payloadFile + ".json")));

			for (Map.Entry<String,String> entry : payloadData.entrySet()) {
				if(jsonBody.contains(entry.getKey()))
					jsonBody = jsonBody.replace(entry.getKey(), entry.getValue());
			}   			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonBody;
	}
}
