package telran.util;

import java.util.Comparator;

@SuppressWarnings("hiding")
public class CompareSumDigit<Integer> implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		
		int res = 0;
		
		int num1 = (int)o1; 
		int num2 = (int)o2; 
		
		int sum1 = 0;
		int sum2 = 0;
		
		while (num1 > 0) {	          
			sum1 += num1 % 10;
			num1 /= 10; 
		}
		
		while (num2 > 0) {	          
			sum2 += num2 % 10;
			num2 /= 10; 
		}
		
		if (sum1 > sum2) {
			res = 1;
		} else if (sum1 < sum2) {
			res = -1;
		}
		
		return res;
	}

}
