package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import model.TouristPlace;

public class MapOperations
{
	static Map<Integer,TouristPlace>touristMap=new HashMap<Integer,TouristPlace>();
	static int noOfPlaces=0;
	public Map add(TouristPlace places)
	{
		touristMap.put(noOfPlaces,places);
		noOfPlaces++;
		return touristMap;
	}
	
	//Sorting the map randomly
	public Map sortRandomly()
	{
		    List<Integer> touristKey = new ArrayList<>(touristMap.keySet());
		    Collections.shuffle(touristKey);
		    Map<Integer, TouristPlace> shuffleMap = new LinkedHashMap<>();
		    touristKey.forEach(k->shuffleMap.put(k, touristMap.get(k)));
		    return shuffleMap;
	}
	
	//sorting the map in entry order
	public Map sortInEntryOrder()
	{
		Map<Integer,TouristPlace> orderedMap=new TreeMap<>(touristMap);
		return orderedMap;
	}
	
	//sorting albabetically based on name
	public Map sortAlphabetically()
	{
		Map<Integer,TouristPlace> sortedNewMap = touristMap.entrySet().stream().sorted((e1,e2)->
        (e1.getValue().getName()).compareTo(e2.getValue().getName()) )
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (e1, e2) -> e1, LinkedHashMap::new));
		return sortedNewMap;
	}
	
	//resetting the map
	public Map reset()
	{
		touristMap.clear();
		return touristMap;
	}
	
	//Removing the last element
	public Map remove()
	{
		touristMap.remove(noOfPlaces);
		noOfPlaces--;
		return touristMap;
		
	}
}