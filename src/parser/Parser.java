package parser;

import java.util.*;
import java.io.*;

public class Parser {

	public HashMap<String, Integer> parse(String inputFile) {
		try {
			Scanner fileReader = new Scanner(new File(inputFile));
			HashMap<String, Integer> tableHeaderMap = new HashMap<>();
			HashMap<String, HashMap<String, Integer>> dataMap = new HashMap<>();
			String[] tableHeaders = fileReader.nextLine().split(",");
			for (int i = 0; i < tableHeaders.length; i++) {
				tableHeaderMap.put(tableHeaders[i], i);
			}

			while (fileReader.hasNextLine()) {
				String[] data = fileReader.nextLine().split(",");
				if (data[tableHeaderMap.get("Schulart")].contains("Insgesamt")) {
					for (int i = tableHeaderMap.get("Schüler insgesamt"); i <= tableHeaderMap
							.get("Schüler ausländisch"); i++) {
						if (dataMap.get(data[tableHeaderMap
								.get("Regionalschlüssel")]) != null) {

							dataMap.get(
									data[tableHeaderMap
											.get("Regionalschlüssel")]).put(
									getName(tableHeaderMap, i),
									!data[i].contains(".") ? Integer
											.decode(data[i]) : 0);
						} else {
							HashMap<String, Integer> map = new HashMap<>();
							map.put(getName(tableHeaderMap, i), !data[i]
									.contains(".") ? Integer.decode(data[i])
									: 0);
							dataMap.put(data[tableHeaderMap
									.get("Regionalschlüssel")], map);
						}
					}
				}
			}

			HashMap<String, Integer> output = new HashMap<>();
			for (String val : dataMap.keySet()) {
				for (Map.Entry<String, Integer> value : dataMap.get(val)
						.entrySet()) {
					output.put(
							value.getKey(),
							((output.get(value.getKey()) != null) ? output
									.get(value.getKey()) : 0)
									+ value.getValue());
				}
				output.put(
						"Schüler männlich",
						((output.get("Schüler männlich") != null) ? output
								.get("Schüler männlich") : 0)
								+ (dataMap.get(val).get("Schüler insgesamt"))
								- dataMap.get(val).get("Schüler weiblich"));
			}
			return output;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getName(HashMap<String, Integer> map, int index) {
		for (String key : map.keySet()) {
			if (map.get(key) == index)
				return key;
		}
		return "";
	}

}
