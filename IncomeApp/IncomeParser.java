package IncomeApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IncomeParser {

	public static void main(String[] args) {
		String str = "/Users/vivek/Documents/Sapient/Percapita/input_file.csv";
		List<IncomeO> list = IncomeParser.readFile(str);
		Map<String, Map<String, Double>> resp = IncomeParser.calculateAvgIncomePerCountryByGender(list);

		System.out.println(resp);
	}

	private static List<IncomeO> readFile(String str) {
		BufferedReader fileReader;
		List<IncomeO> listIncome = new ArrayList<>();
		try {
			fileReader = new BufferedReader(new FileReader(str));
			fileReader.readLine();
			String data = "";
			while ((data = fileReader.readLine()) != null) {
				populateIncomeList(listIncome, data);

			}

			System.out.println("Size of Income Object processed " + listIncome.size());
			

		} catch (IOException e) {

			e.printStackTrace();
		}
		return listIncome;

	}

	private static void populateIncomeList(List<IncomeO> listIncome, String data) {
		IncomeO income = new IncomeO();
		String[] s = data.split(",");
		income.setCity(s[0]);
		income.setCountry(s[1]);
		income.setGender(s[2]);
		income.setCurrency(s[3]);

		income.setAvgIncome(getAverageIncome(Integer.parseInt(s[4]), s[3]));

		listIncome.add(income);
	}

	private static Map<String, Map<String, Double>> calculateAvgIncomePerCountryByGender(List<IncomeO> listIncome) {
		Map<String, Map<String, Double>> map = new TreeMap<>();

		System.out.println(listIncome.size());

		Double avgIncome = 0.0;
		for (IncomeO income : listIncome) {
			Map<String, Double> map1 = new HashMap<>();
			String mapKey = checkIfCountryisPresent(income);

			if (map.containsKey(mapKey)) {
				map1 = map.get(mapKey);
				if (map1.containsKey(income.getGender())) {
					avgIncome = map1.get(income.getGender()) + income.getAvgIncome();
					map1.put(income.getGender(), avgIncome);
					map.put(mapKey, map1);
				} else {
					map1.put(income.getGender(), income.getAvgIncome());
					map.put(mapKey, map1);
				}
			}
			
			else {
				map1.put(income.getGender(), income.getAvgIncome());
				map.put(mapKey, map1);
			}

		}
		return map;

	}

	private static String checkIfCountryisPresent(IncomeO income) {
		return income.getCountry().isEmpty() ? income.getCity() : income.getCountry();
	}

	public static double getAverageIncome(int averageIncome, String currency) {
		double covertAvgIncome = 0.00;

		switch (currency) {
		case "INR":
			covertAvgIncome = averageIncome / 66;
			break;
		case "GBP":
			covertAvgIncome = averageIncome / 0.67;
			break;
		case "SGP":
			covertAvgIncome = averageIncome / 1.5;
			break;
		case "HKD":
			covertAvgIncome = averageIncome / 8;
			break;
		case "USD":
			covertAvgIncome = averageIncome;
			break;

		default:
			break;
		}
		return covertAvgIncome;

	}

}


//{HONG KONG={Female=22744.12, Male=32118.75}, IND={Female=2560.64, Male=3660.36}, New Delhi={Female=1718.68, Male=3652.2}, SINGAPORE={Female=40228.67, Male=51240.0}, UK={Female=30516.42, Male=41091.04}, USA={Female=53760.0, Male=66564.33}}
//{HONG KONG={F=22744.0, M=32118.0}, IND={F=10240.0, M=10980.0}, New Delhi={F=1718.0, M=3652.0}, SINGAPORE={F=40228.666666666664, M=51240.0}, UK={F=30516.41791044776, M=41091.0447761194}, USA={F=161280.0, M=199693.0}}

