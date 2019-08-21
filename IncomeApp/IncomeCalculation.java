package IncomeApp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class IncomeCalculation {
	
	public boolean averageIncome() throws IOException{
		Map<String,Float> countryMap=new HashMap<String,Float>();
		
		try{
			//File file= new File("C:/Users/indiahiring.LL/Desktop/Amit_Kumar_Gupta_Code/sampleInput.xlsx");
			//FileInputStream fileIn = new FileInputStream(file);
			//DataInputStream dataIn = new DataInputStream(fileIn);			
			//String data = dataIn.readLine();	
			BufferedReader fileReader=new BufferedReader(new FileReader("/Users/vivek/Documents/Sapient/Percapita/sampleInput.csv"));
			fileReader.readLine();
			int temp = 0;
			String data="";
			while((data=fileReader.readLine()) != null){
				String[] s = data.split(" ");
				String city=s[0];
				String country=s[1];
				String gender=s[2];
				String currency=s[3];
				int averageIncome=Integer.parseInt(s[4]);
				float covertAvgIncome=(float) 0.0;
				if(currency.equals("INR"))
					{
					covertAvgIncome=averageIncome/66;
					}
				else if(currency.equals("GBP"))
				{
					covertAvgIncome=(float) (averageIncome/0.67);
				}
				else if(currency.equals("SGD"))
				{
					covertAvgIncome=(float) (averageIncome/1.5);
				}
				else if(currency.equals("HKD"))
				{
					covertAvgIncome=averageIncome/8;
				}
				else if(currency.equals("USD"))
				{
					covertAvgIncome=averageIncome;
				}
				
				if(country.equals(" "))
					{
				    	if(countryMap.containsKey(city+","+gender))
				    	  {
				    		float avg=countryMap.get(city+","+gender);
				    		avg=avg+covertAvgIncome;
				    		countryMap.put(city+","+gender,avg);
				    	  }
				    	else{
				    		countryMap.put(city+","+gender,covertAvgIncome);
				    	 }
					}
				else{
					if(countryMap.containsKey(country+","+gender))
			    	  {
			    		float avg=countryMap.get(country+","+gender);
			    		avg=avg+covertAvgIncome;
			    		countryMap.put(country+","+gender,avg);
			    	  }
			    	else{
			    		countryMap.put(country+","+gender,covertAvgIncome);
			    	 }
				}
			
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		File fileout = new File("C:/Users/indiahiring.LL/Desktop/Amit_Kumar_Gupta/sampleOutput1.xlsx");
		try {
			FileOutputStream outfile = new FileOutputStream(fileout);
			DataOutputStream ds = new DataOutputStream(outfile);
			String msg="City/Country Gender Average Income(in USD)";
			FileWriter fw=new FileWriter("C:/Users/indiahiring.LL/Desktop/Amit_Kumar_Gupta/sampleOutput.csv");
			fw.append(msg);
			fw.append("\n");
			//ds.write(msg);
			//Collections.sort(countryMap);
			//Iterator<Map.entry<String,Float>> mt=countryMap.iterator();
			for(Map.Entry<String,Float> ms:countryMap.entrySet())
			   {
				
				String key=ms.getKey();
				float value=ms.getValue();
				String countryGen[]=key.split(",");
				String recard=countryGen[0]+" "+countryGen[1]+" "+value;
				fw.append(recard);
				fw.append("\n");
			   }
			return true;
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
			return false;
		}
		
	}
	public static void main(String... s){
		IncomeCalculation ob=new IncomeCalculation();
		try {
			ob.averageIncome();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
