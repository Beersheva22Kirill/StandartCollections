package telran.structure;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;



public class ItemCounter implements MultiCounters {
	
	private Map<Object, Integer> items;
	private TreeMap <Integer, HashSet<Object>> itemsForMax;
	
	public ItemCounter() {
		items = new HashMap<Object, Integer>();			
		itemsForMax = new TreeMap<>(); 	  
	}
	
	@Override
	public Integer addItem(Object item) {
		
		Integer entry = items.getOrDefault(item, 0);
		removeFromSet(item, entry);	
		items.put(item, ++entry);	
		addFromSetIndexes(item, entry);
					
		return entry;
	}

	private void addFromSetIndexes(Object item, Integer entry) {
		HashSet<Object> set = itemsForMax.get(entry);		
		if (set == null) {
			set = new HashSet<>();
			itemsForMax.put(entry, set);
			} 
		set.add(item);
	}

	private void removeFromSet(Object item, Integer entry) {
		HashSet<Object> removedSet = itemsForMax.get(entry);
		if (removedSet != null) {
			removedSet.remove(item);
			if (removedSet.isEmpty()) {
				itemsForMax.remove(entry);
			}
		}
	}

	@Override
	public Integer getValue(Object item) {
	
		return items.get(item);
	}

	@Override
	public boolean remove(Object item) {
		Integer entry = items.get(item);
		
		
		boolean res = false;
		if (entry != null) {
			HashSet<Object> set = itemsForMax.get(entry);
			set.remove(item);
			if (set.isEmpty()) {
				itemsForMax.remove(entry);
			}
			items.remove(item);
			res = true;
		}
		return res;
	}

	@Override
	public Set<Object> getMaxItems() {
		var set = itemsForMax.get(itemsForMax.lastKey());
		// var заменяет запись Set<Object> set
		return set != null ? set : Collections.emptySet();
	}



}
