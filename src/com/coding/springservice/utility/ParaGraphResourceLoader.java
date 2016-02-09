package com.coding.springservice.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class ParaGraphResourceLoader implements ResourceLoaderAware {

	private ResourceLoader resourceLoader;
	
	private StringBuffer paraGraphToSearch = new StringBuffer();
	
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		
		this.resourceLoader = resourceLoader;
	}
   
	public void showResourceData() throws IOException 
    {
        //This line will be changed for all versions of other examples
        Resource banner = resourceLoader.getResource("classpath:paragraph.txt");
        InputStream in = banner.getInputStream();
 
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        while (true) {
            String line = reader.readLine();
            if (line == null)
                break;
            System.out.println(line);
            paraGraphToSearch.append(line);
        }
        reader.close();
    }
	public String getParaGraphText(){
		return paraGraphToSearch.toString();
	}
	
}
