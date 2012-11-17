package data;

import java.util.ArrayList;
import java.util.HashMap;

import android.text.format.Time;

public class MisArticulos extends ArrayList<HashMap<String, Object>> {
	
	
	 public MisArticulos () {
	 	 
		addFeed("Articulo 1", "2012-10-13T16:00:00.000Z");
	 	addFeed("Otro artículo", "2012-10-13T16:00:00.000Z");
	 	addFeed("Mas de lo mismo", "2012-10-17T15:00:00.000Z");
	 	addFeed("Otro", "2012-10-13T10:30:00.000Z");
	 	
		}
	 public void addFeed(String title, String date){
		 //creamos el HashMap
		 HashMap<String, Object> feedMap = new HashMap<String, Object>();
		 
		 //insertamos los datos
		 feedMap.put(FeedContract.TITLE, title);
		 
		 
		 //vamos a tratar la fecha para colocarla en un formato mas vistoso
		 Long millis = parseDate(date);
		 feedMap.put(FeedContract.DATE, millis);
		 add(feedMap);
		 		 
	 }
	 
	 private Long parseDate(String date){
		 Time time = new Time();
		 time.parse3339(date);
		 Long millis = time.normalize(false);
		 return millis;
		 
	 }

}
