package application.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Properties;

public class Victory {
	
	private static HashMap<String, String> newVictor=new HashMap<String,String>();
    private static Properties properties=new Properties();
    private static HashMap<Object, Object> victors=new HashMap<Object,Object>();
    
    public static void addVictor(String name, String score) throws IOException{
    	if (name==null || name.isEmpty()||score==null || score.isEmpty() )
    	{
    		
    	}
    	else
    	{
    		properties.load(new FileInputStream("data/victors.properties"));  
        	for(Object keys: properties.stringPropertyNames()){
        		victors.put(keys, properties.get(keys).toString());
        	}			
        	
        	newVictor.put(name,score);
        	properties.putAll(newVictor);
        	FileOutputStream file=new FileOutputStream("data/victors.properties", true);
        	properties.store(file, null);
    	}
    	
    }
    	
    public static ArrayList<Champions> sendVictors() throws IOException{
    	
    	ArrayList<Champions> winList= new ArrayList<Champions>();
        properties.load(new FileInputStream("data/victors.properties")); 
        		
        for(Object keys: properties.stringPropertyNames()){
        	victors.put(keys, properties.get(keys).toString());
        }
        
        for (HashMap.Entry<Object, Object> entry : victors.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            
            winList.add(new Champions(key,value));
        }
        
        Collections.sort(winList, new Comparator<Champions>() {
		    @Override
		    public int compare(Champions o1, Champions o2) {
		        if((Integer.parseInt(o1.getScore())-Integer.parseInt(o2.getScore())<0))
		        {
		        	return 1;
		        }
		        else if ((Integer.parseInt(o1.getScore())-Integer.parseInt(o2.getScore())>0))
				{
					return -1;
				}
				else
				{
					return 0;
				}
		    }
		});
        
        return winList;
        	
    	
    }

}