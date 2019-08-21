package percapitaIncome;

import static java.util.stream.Collectors.averagingLong;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class IncomeParser {

	public List<Income> readFile(String inputFile) {
		
		BufferedReader fileReader;
		List<Income> listIncome  = new ArrayList<>();
		try {
			fileReader = new BufferedReader(new FileReader(inputFile));
			fileReader.readLine();
			int temp = 0;
			String data="";
			while((data=fileReader.readLine()) != null){
				Income income =new Income(data, data, data, null, temp);
				String[] s = data.split(",");
				income.setCity(s[0]);
				income.setCountry(s[1]);
				income.setGender(s[2]);
				income.setCurrency(Currency.valueOf(s[3]));
				income.setAvgIncome(Long.parseLong(s[4]));
				listIncome.add(income);
			
			}
			
			System.out.println("Size of Income Object processed" +listIncome.size());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listIncome;
		
		
	}
	
	private long getIncomeInUSDollars(final Income income) {
	    return income.getAvgIncome() / income.getCurrency().getConversionRate();
	  }
	
	
	private String joinCountryGenderAvgIncome( final LinkedHashMap<String, Map<String, Double>> avgGenderIncomeByCountry) {
		    return avgGenderIncomeByCountry.entrySet()
		        .stream()
		        .map(countryEntry -> countryEntry.getValue().entrySet()
		                .stream()
		                .map(genderEntry -> joinKeyValues(countryEntry, genderEntry))
		                .collect(joining("\n")))
		        .collect(joining("\n"));
		  }
	
	private LinkedHashMap<String, Map<String, Double>> calculateAvgIncomePerCountryByGender(
		      final List<Income> incomeList) {
		    return incomeList.stream()
		        .collect(groupingBy(Income::getCountry,
		            groupingBy(Income::getGender,
		            		
		                mapping(this::getIncomeInUSDollars,
		                		
		                    averagingLong(Long::valueOf)
		                    )
		                )
		            )
		        		)
		        .entrySet()
		        .stream()
		        .sorted(Entry.comparingByKey())
		        .collect(toMap(Entry::getKey, Entry::getValue,
		            (m1, m2) -> m1,
		            LinkedHashMap::new));
		  }
	
	
	private String joinKeyValues(final Entry<String, Map<String, Double>> countryEntry,
		      final Entry<String, Double> genderEntry) {
		    return countryEntry.getKey() + "," + genderEntry.getKey() + "," + genderEntry.getValue();
		  }
	
	
	public static void main(String[] args) {
		IncomeParser incomeParser = new IncomeParser();
		List<Income> list = incomeParser.readFile("/Users/vivek/Downloads/piyush/sampleInput.csv");
		incomeParser.calculateAvgIncomePerCountryByGender(list);
		
		System.out.println(incomeParser.calculateAvgIncomePerCountryByGender(list));
	}
	
}
