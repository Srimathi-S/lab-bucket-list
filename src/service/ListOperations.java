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
		Collections.sort(touristPlaceList ,(TouristPlace place1,TouristPlace place2)-> (place1.getDestination().toUpperCase()).compareTo(place2.getDestination().toUpperCase()));
		return touristPlaceList;
	}
	
	
	//Sorting the ist based on rank 
	public List sortByRank()
	{
		Collections.sort(touristPlaceList ,(TouristPlace place1,TouristPlace place2) -> (place1.getRank()).compareTo(place2.getRank()));
		return touristPlaceList;
	}
	
	//resetting the list
	public List reset()
	{
		touristPlaceList.clear();
		return touristPlaceList;
		
	}
}