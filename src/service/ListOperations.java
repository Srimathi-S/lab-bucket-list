package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import model.TouristPlace;

public class ListOperations
{
	private static List<TouristPlace> touristPlaceList=new ArrayList<TouristPlace>();
	
	//Adding elements
	public List add(TouristPlace places)
	{
		touristPlaceList.add(places);
		return touristPlaceList;
	}
	
	//Removing the last added element
	public List remove()
	{
		touristPlaceList.remove(touristPlaceList.size()-1);
		return touristPlaceList;
	}
	
	
	//Sorting the list based on destination
	public List sortByDestination()
	{
		List<TouristPlace>sortedList=new ArrayList<>(touristPlaceList);
		Collections.sort(sortedList ,(TouristPlace place1,TouristPlace place2)-> (place1.getDestination().toUpperCase()).compareTo(place2.getDestination().toUpperCase()));
		return sortedList;
	}
	
	
	//Sorting the ist based on rank 
	public List sortByRank()
	{
		List<TouristPlace>sortedList=new ArrayList<>(touristPlaceList);
		Collections.sort(sortedList ,(TouristPlace place1,TouristPlace place2) -> (place1.getRank()).compareTo(place2.getRank()));
		return sortedList;
	}
	
	//resetting the list
	public List reset()
	{
		touristPlaceList.clear();
		return touristPlaceList;
		
	}
}