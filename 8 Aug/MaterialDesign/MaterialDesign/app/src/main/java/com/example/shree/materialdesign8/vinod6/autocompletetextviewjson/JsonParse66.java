package com.example.shree.materialdesign8.vinod6.autocompletetextviewjson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class JsonParse66 {
	 double current_latitude,current_longitude;
	 public JsonParse66(){}
	 public JsonParse66(double current_latitude, double current_longitude){
		 this.current_latitude=current_latitude;
		 this.current_longitude=current_longitude;
	 }
	 public List<SuggestGetSet66> getParseJsonWCF(String sName)
		{
		 List<SuggestGetSet66> ListData = new ArrayList<SuggestGetSet66>();
		 try {
			String temp=sName.replace(" ", "%20");
			URL js = new URL("http://35.154.210.22/dpts/doctor/ecommerce/onclickfilter/multisiddha.php?Specility="+temp);
			URLConnection jc = js.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(jc.getInputStream()));
            String line = reader.readLine();
            JSONObject jsonResponse = new JSONObject(line);
            JSONArray jsonArray = jsonResponse.getJSONArray("results");
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject r = jsonArray.getJSONObject(i);
                ListData.add(new SuggestGetSet66(r.getString("Id"),r.getString("Specility")));
        	}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 return ListData;
		 
		}
	 
}
