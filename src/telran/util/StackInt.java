package telran.util;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalInt;

public class StackInt {
	
	List<Integer> list = new LinkedList<>();
	Integer currentMax;
	
	public void push(int element) {
		if (currentMax == null) {
			currentMax = element;
		}else if (element > currentMax) {
			currentMax = element;
		}
		list.add(element);
	}
	
	public int pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		return list.get(list.size() - 1);
	}
	
	public boolean isEmpty () {

		return list.size() < 0;
	}
	
	public Integer getMax() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return currentMax;
	}
}
