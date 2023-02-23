package telran.util;


import java.util.LinkedList;
import java.util.NoSuchElementException;


public class StackInt {
	private LinkedList<Integer> list;
	private LinkedList<Integer> listMax;
	
	public StackInt() {
		list = new LinkedList<>();
		listMax = new LinkedList<>();

	}

	public void push(int element) {
		if (listMax.isEmpty()) {
			listMax.add(element);
		} else if (element  > listMax.getLast()) {
			listMax.add(element);
		} else {
			Integer currentMax = listMax.getLast();
			listMax.add(currentMax);
		}
		list.add(element);
	}
	
	public int pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		listMax.removeLast();
		return list.pollLast();
		
	}
	
	public boolean isEmpty () {

		return list.size() < 1;
	}
	
	public Integer getMax() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		return listMax.getLast();
	}


}
