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
		
		if (listMax.isEmpty() || element >= listMax.getLast()) {
			listMax.add(element);
		} 
		list.add(element);
	}
	
	public int pop() {
		int res = list.removeLast();
			if (res == listMax.getLast() ) {
			listMax.removeLast();
			}
		return res;
		
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
