package telran.util;

import java.util.Arrays;
import java.util.HashMap;

public class MyArrayInt {
	
		private int size;
		private int value;
		private HashMap<Integer, Integer> hashArray;
		
		public MyArrayInt(int size, int number) {
			this.size = size;
			value = number;
		}
		
		public void set (int index,int value) {
			checkIndex(index);
			if (hashArray == null) {
				hashArray = new HashMap<>();
			}
			hashArray.put(index, value);
		}

		private void checkIndex(int index) {
			if (index > size || index < 0) {
				throw new IndexOutOfBoundsException();
			}
		}
		
		public int get(int index) {
			checkIndex(index);
			int res = value;
			if (hashArray != null) {
				res = hashArray.getOrDefault(index, value);
			}
			return res;
		}
		
		public void setAll(int value) {
			hashArray = null;
			this.value = value;
		
			// sets a given for all array element;
		}
	

}
