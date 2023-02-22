package telran.util;


import java.util.LinkedList;
import java.util.NoSuchElementException;


public class StackInt {
	private LinkedList<Integer> list;
	
	public StackInt() {
		list = new LinkedList<>();

	}

	public void push(int element) {
		
		list.add(element);
	}
	
	public int pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		return list.pollLast();
	}
	
	public boolean isEmpty () {

		return list.size() < 1;
	}
	
	public Integer getMax() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		return list.stream().mapToInt(num -> num).max().getAsInt();
	}


}
