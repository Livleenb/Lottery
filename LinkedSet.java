package proj3sp17;
import java.util.Random;
/**
 * <p>Title: The LinkedSet Class</p>
 *
 * <p>Description: This class will define methods that will be used to play
 * CSC Lotto games. There will be methods to add in a set, remove an 
 * element from the set, or removing a random element. This class
 * can also return the size of the set or if it contains a certain element.
 * It can also compare two sets and return what is the same or what is
 * different in the sets. All of these methods will be implemented to play
 * CSC Lotto games.</p>
 *
 * @author Livleen Bhullar
 */
public class LinkedSet<E> implements SetADT<E> {
	protected Node<E> start;

	/**
	 * default LinkedSet constructor - initializes
	 * the instance variable start
	 * 
	 */
	public LinkedSet()
	{
		start = null;
	}

	/**
	 * add method - adds one element to the set, ignoring duplicates
	 * @param element - the element being added to the set 
	 */
	public void add(E element) {
		start = new Node<E>(element,start);
	}
	/**
	 * removeRand method - removes and returns a random element from the set
	 * @return E, the random element being removed from the set 
	 */
	public E removeRandom() {
		int size = this.size();
		//random object to get random index 
		Random rand = new Random();
		E item = null;
		Node<E> current = start;
		int randNum = rand.nextInt(size);
		//if set is empty exception must be thrown
		if(isEmpty())
			throw new EmptyCollectionException();
		//getting to random location and removing 
		else
		{
			for(int i = 0; i < randNum; i++)
			{
				current = current.getNext();
			}
			item = this.remove(current.getItem());
		}
		return item;
	}

	/**
	 * remove method - Removes and returns the specified element from the set
	 * @param - element that will be removed from the set 
	 * @return - E - element thats being removed from the set 
	 */
	public E remove(E element) {

		E item = null;
		Node<E> current = start;

		//if not empty take paramter and remove it, start will equal to next
		//item
		if (!isEmpty())
		{
			if(start.getItem().equals(element))
			{
				item = start.getItem();
				start = start.getNext();
				return item;
			}
		}
		//if empty throw exception
		else
			throw new EmptyCollectionException();
		if(size() > 1)
		{
			while(!current.getNext().getItem().equals(element))
			{
				if(current.getNext().getNext() == null)
					throw new ElementNotFoundException("LinkedSet");
				current = current.getNext();
			}
			item = current.getNext().getItem();
			current.setNext(current.getNext().getNext());
		}
		else
			throw new ElementNotFoundException("LinkedSet");
		return item;
	}

	/**
	 * contains method -Returns true if the set contains the parameter
	 * @param - element that will be looked for in the set 
	 * @return - boolean - true if element is in the set, false if element isnt
	 * in the set
	 */	
	public boolean contains(E target) 
	{
		if(isEmpty())
			throw new EmptyCollectionException("LinkedSet");
		//finding the parameter 
		boolean found = false;
		Node<E> current = start;
		while(current != null && !found)
			if(target.equals(current.getItem()))
				found = true;
			else
			{
				current = current.getNext();
			}
		return found;
	}

	/**
	 * isEmpty method - Returns true if the set contains no elements
	 * @return - boolean - true if the set is empty, false if the set has
	 * elements in it
	 */	
	public boolean isEmpty() {
		return (start == null);
	}

	/**
	 * size method - Returns the number of elements in the set 
	 * @return - int - number of elements in the set
	 */	
	public int size() {
		Node<E> current = start;
		int count = 0;
		while(current != null)
		{
			current = current.getNext();
			//counting items in set
			count ++;
		}
		return count;
	}

	/**
	 * toString method - method to display the state of the set
	 * @return - str - returns a String representation of the set 
	 */
	public String toString()
	{
		String str = " ";
		Node<E> current = start;
		while(current != null)
		{
			str += "\n" + current.getItem();
			current = current.getNext();
		}
		return str;
	}

	/**
	 * intersection method - method which determines the common elements in 
	 * two sets 
	 * @return - returns a new set with the common elements from both sets 
	 * @param - aSet - set that is being compared with the one the method is
	 * called on
	 */
	public LinkedSet<E> intersection(LinkedSet<E> aSet)
	{
		//new set to add same items 
		LinkedSet<E> otherSet = new LinkedSet<E>();
		Node<E> current = start;
		while(current != null)
		{
			//checking both sets 
			if(aSet.contains(current.getItem()) == true)
			{
				//if same adding to new set 
				otherSet.add(current.getItem());
			}
			current = current.getNext();
		}
		return otherSet;
	}

	/**
	 * difference method - method which determines the different elements in 
	 * two sets 
	 * @return - returns a new set with the different elements from both sets 
	 * @param - aSet - set that is being compared with the one the method is
	 * called on
	 */
	public LinkedSet<E> difference(LinkedSet<E> aSet)
	{
		LinkedSet<E> otherSet = new LinkedSet<E>();
		Node<E> current = start;
		while(current!= null)
		{
			if(aSet.contains(current.getItem()) == false)
			{
				otherSet.add(current.getItem());
			}
			current = current.getNext();
		}
		return otherSet;
	}
}
