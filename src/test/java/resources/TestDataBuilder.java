package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.PayloadAlt;
import pojo.Location;

public class TestDataBuilder {
	
	//for use in version 2 test
	public PayloadAlt AddPlacePayload() 
	{
		PayloadAlt p = new PayloadAlt();
		
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("https://rahulshettyacademy.com");
		p.setName("Rahul Shetty Academy");
		List<String> myList =new ArrayList<String>();  //create list object to set nested JSON objects
		myList.add("shoe park");   
		myList.add("shop");

		p.setTypes(myList);  //then load into parent JSON
		Location l =new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		
		return p;
	}

}
