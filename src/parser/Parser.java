package parser;

import java.util.*;
import java.io.*;

public class Parser {
	
	void parse(String inputFile)
	{
		try 
		{
			Scanner fileReader = new Scanner(new File(inputFile));
			HashMap<String, Integer> tableHeaderMap = new HashMap<>();
			HashMap<String, HashMap<String, Integer>> dataMap = new HashMap<>();
			String[] tableHeaders = fileReader.nextLine().split(",");
			for(int i = 0; i < tableHeaders.length; i++)
			{
				tableHeaderMap.put(tableHeaders[i], i);
			}
			
			while(fileReader.hasNextLine())
			{
				String currentLine = fileReader.nextLine();
				String[] data = currentLine.split(",");
				if(data[tableHeaderMap.get("Schulart")].trim().toUpperCase().contains("Insgesamt".toUpperCase()))
				{
					for(int i = tableHeaderMap.get("Schüler insgesamt"); i <= tableHeaderMap.get("Schüler ausländisch"); i++)
					{
						if(dataMap.get(data[tableHeaderMap.get("Regionalschlüssel")]) != null)
						{
							
							dataMap.get(data[tableHeaderMap.get("Regionalschlüssel")]).put(getName(tableHeaderMap, i), !data[i].contains(".") ? Integer.decode(data[i]) : 0);
						}
						else
						{
							HashMap<String, Integer> map = new HashMap<>();
							map.put(getName(tableHeaderMap, i), !data[i].contains(".") ? Integer.decode(data[i]) : 0);
							dataMap.put(data[tableHeaderMap.get("Regionalschlüssel")], map);
						}
					}
				}
			}
			System.out.println("Finished");
			for(String val : dataMap.keySet())
			{
				System.out.println("Regionalschlüssel: " + val);
				int total = 0;
				int females = 0;
				for(Map.Entry<String, Integer> value : dataMap.get(val).entrySet())
				{
					if(value.getKey().contains("Schüler insgesamt"))
						total = value.getValue();
					
					if(value.getKey().contains("Schüler weiblich"))
						females = value.getValue();
					System.out.printf("\t%s: %s\n", value.getKey(), value.getValue());
				}
				System.out.printf("\tSchüler männlich: %s\n", total - females);
			}
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	private String getName(HashMap<String, Integer> map, int index)
	{
		for(String key : map.keySet())
		{
			if(map.get(key) == index)
				return key;
		}
		return "";
	}
	
	public static void main(String[] args)
	{
		new Parser().parse("/home/oliver/Downloads/data.csv");
	}
	
}
