package footballseason;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			System.out.println(run("arsenal"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int run(String teamKey) throws IOException {
		
		int goals = 0;
		String readLine = "";
		StringBuilder result = new StringBuilder();
		
		URL url = new URL("https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/football_session/football.json");
		HttpURLConnection httpURLConnection  = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		
		while((readLine = bufferedReader.readLine()) != null)
		{
			result.append(readLine);
		}
		
		bufferedReader.close();
		
		JSONObject jsonObj = new JSONObject(result.toString());
		JSONArray rounds = jsonObj.getJSONArray("rounds");
		JSONArray matches = null;
		
		for (int i = 0; i < rounds.length(); i++) {
			matches = rounds.getJSONObject(i).getJSONArray("matches");
			for (int j = 0; j < matches.length(); j++)
			{
				if(matches.getJSONObject(j).getJSONObject("team1").getString("key").equals(teamKey))
				{
					goals += Integer.valueOf(matches.getJSONObject(j).get("score1").toString());
				}
				
				if(matches.getJSONObject(j).getJSONObject("team2").getString("key").equals(teamKey))
				{
					goals += Integer.valueOf(matches.getJSONObject(j).get("score2").toString());
				}
			}
		}
		
		
		return goals;
	}

}
