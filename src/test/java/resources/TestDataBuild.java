package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Location;
import pojo.SerializePojoClass;

public class TestDataBuild {
	
	
	public SerializePojoClass AddPlacePayload(String name, String language, String address) {
		
		SerializePojoClass s=new SerializePojoClass();
		s.setAccuracy(50);
		s.setAddress(address);
		s.setPhone_number("(+91) 983 893 3937");
		s.setLanguage(language);
		s.setWebsite("http://google.com");
		s.setName(name);
		List<String> mylist=new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shop");
		
		s.setTypes(mylist);
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		s.setLocation(l);
		
		return s;
	}
	
	public String deletePayload(String place_id) {
		return "{\n" + 
				"    \"place_id\":\""+place_id+"\"\n" + 
				"}\n" + 
				"";
		
	}
}
