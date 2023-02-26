package telran.structure;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalInt;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class ItemCounter implements MultiCounters {
	
	private Map<Object, Integer> items;
	private Map.Entry<Object, Integer> entry;
	private TreeMap <Integer, HashSet<Object>> itemsForMax;
	
	public ItemCounter() {
		items = new HashMap<Object, Integer>();			
		itemsForMax = new TreeMap<>(); 	  
	}
	
	@Override
	public Integer addItem(Object item) {
	
		
		Integer entry = items.get(item);
		if (entry != null) {
			items.put(item, ++entry);
			
			} else {
				items.put(item, 1);
				entry = 1;
			}	
		
		HashSet<Object> set = itemsForMax.get(entry);
		if (set != null) {
			set.add(item);
			} else {
				set = new HashSet<>();
				set.add(item);
				itemsForMax.put(entry, set);
			}
			
		return entry;
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
	
		return itemsForMax.get(itemsForMax.lastKey());
	}



}
