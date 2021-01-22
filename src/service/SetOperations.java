package service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import model.TouristPlace;

public class SetOperations
{
	static HashSet<TouristPlace> touristPlaceSet=new HashSet<>();
	static Stack<TouristPlace> lastAdded=new Stack<>();
	
	//Adding new element to list
	public HashSet add(TouristPlace places)
	{
		touristPlaceSet.add(places);
		lastAdded.add(places);
		return touristPlaceSet;
	}
	
	//deleting the last added element
	public HashSet remove()
	{
		if(lastAdded.size()!=0)touristPlaceSet.remove(lastAdded.pop());
		System.out.println("removed"+touristPlaceSet.toString()+lastAdded.pop());
		return touristPlaceSet;
	}
	
	
	//Sorting by destination
	public Set sortByDestination()
	{
		TreeSet<TouristPlace> sortedSet=new TreeSet<>(Comparator.comparing(TouristPlace :: getDestination));
		sortedSet.addAll((touristPlaceSet));
		return sortedSet;
	}
	
	//Sorting the set based on rank
	public Set sortByRank()
	{
		TreeSet<TouristPlace> sortedSet=new TreeSet<>(Comparator.comparing(TouristPlace :: getRank));
		sortedSet.addAll((touristPlaceSet));
		return sortedSet;
	}
	
	//Resseting the set
	public Set reset()
	{
		touristPlaceSet.clear();
		lastAdded=null;
		return touristPlaceSet;
	}
}