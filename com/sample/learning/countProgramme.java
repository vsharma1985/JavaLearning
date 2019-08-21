package com.sample.learning;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class countProgramme {

	Map<String,Integer> countingMap = new HashMap<>();
	
	String str = "4,4,4,4,4,4,4,7,3,3,3,2,2,1,1,1,1";
	
	public Map<String,Integer> processString() {
		
		String[] strArr = str.split(",");
		int count=0;
		for(int i=0;i<strArr.length;i++) {
			//System.out.println(strArr[i]);
			if(countingMap.containsKey(strArr[i])) {
				++count;
				countingMap.put(strArr[i], countingMap.get(strArr[i])+1);
			}
			else {
				countingMap.put(strArr[i], 1);
			}
		}
		return countingMap;
	}
	
	
	
	public static void main(String[] args) {
		countProgramme c = new countProgramme();
		Map<String,Integer> resp= c.processString();
		
		for(Entry<String, Integer> map : resp.entrySet()) {
			
			System.out.println(map.getKey() +" "+map.getValue() );
		}
	}
}
