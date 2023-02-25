package telran.structure;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalInt;
import java.util.Set;

public class ItemCounter implements MultiCounters {
	
	private Map<Object, Integer> items;
	
	public ItemCounter() {
		items = new HashMap<Object, Integer>();
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
			items.remove(item);
			res = true;
		}
		return res;
	}

	@Override
	public Set<Object> getMaxItems() {
		Set<Object> res = new HashSet<>();
		Set<Entry<Object, Integer>> setEntry = items.entrySet();
		
			Collection<Integer> itemsValues = items.values();
			OptionalInt max = itemsValues.stream().mapToInt(n -> n).max();		
						
		setEntry.stream().filter(n -> n.getValue().equals(max.getAsInt())).forEach(n -> res.add(n.getKey()));
		
		return res;
	}



}
