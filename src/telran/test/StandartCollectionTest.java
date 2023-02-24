package telran.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.util.CompareSumDigit;
import telran.util.MyArrayInt;
import telran.util.StackInt;

class StandartCollectionTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Disabled
	void subListTest() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8, 70,-20)) ;
		list.add(9);
		List<Integer> subList = list.subList(3, 7);
		subList.add(30);
		subList.add(2, 99);
		subList.sort(Integer :: compare);
		
		
		System.out.println(subList.stream().filter(n -> n < 30).collect(Collectors.toList()));
		System.out.println(subList.toString());
		System.out.println(list);
		
	}
	
	@Test
	@Disabled
	void displayOccurenciesCountTest() {
		String[] strings = {"lmn","abc" , "abc", "lmn", "a", "lmn"};	
		Arrays.stream(strings).collect(Collectors
				.groupingBy(s -> s, Collectors.counting()))
				.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
				.forEach(e -> System.out.printf("%s: %d\n",e.getKey(), e.getValue()));	
	}
	
	@Test
	void displayDigitStatisticsTest() {
		
		System.out.println("--------------------");
			//variant 1 boxed
		new Random().ints(1,Integer.MAX_VALUE - 1).limit(1000000).flatMap(num -> (""+ num).chars()).map(num -> (char)num - '0').boxed()
		.collect(Collectors.groupingBy(num -> num, Collectors.counting())).entrySet().stream().sorted((el1, el2) -> Long.compare(el2.getValue(), el1.getKey()))
		.forEach((el) -> System.out.printf("%s - %s\n", el.getKey(), el.getValue()));
			
		System.out.println("--------------------");
			//variant 2 mapToObj
		new Random().ints(1, Integer.MAX_VALUE).limit(1000000).flatMap(n -> Integer.toString(n).chars()).mapToObj(digit -> digit)
		.collect(Collectors.groupingBy(digit -> digit, Collectors.counting()))
		.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
		.forEach(e -> System.out.printf("%c: %d\n",e.getKey(), e.getValue()));
		System.out.println("--------------------");
		
		//Generate 1000000 random numbers [1 - Integer.MAX_VALUE)
		//Display digits and counts of their occurrences in descending order of the counts
		//consider using flatMap for getting many from one
	}
	
	@Test
	void stackTests() {
		StackInt stack = new StackInt();
		assertTrue(stack.isEmpty());
			stack.push(45);
		assertFalse(stack.isEmpty());
			stack.push(5);
			stack.push(2);
		
		assertEquals(2, stack.pop());
		assertEquals(45, stack.getMax());
		
			stack.push(65);
		
		assertEquals(65, stack.getMax());
		assertEquals(65, stack.pop());
		assertEquals(45, stack.getMax());
		
	}
	
	@Test
	void myArraysTest() {
		MyArrayInt array = new MyArrayInt(5, 9);
		assertEquals(9, array.get(1));
		array.set(1, 5);
		assertEquals(5, array.get(1));
		
	}
	
	@Test
	void maxValueWithNegativeImageTest() {
		Integer[] array = {1000000, 3, -2, -200, 200, -3, 2};
		Integer[] array1 = {100000,-100000000, 3, -4};
		assertEquals(200, maxNumberWithNegativeImage(array));
		assertEquals(-1, maxNumberWithNegativeImage(array1));	
	}
		
	
	int maxNumberWithNegativeImage( Integer[] array) {
		//return maximal positive number having it negative image or -1 if none such numbers
		int res = -1;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < array.length; i++) {		
			if (set.contains(-array[i])) {
				if (Math.abs(array[i]) > res) {
					res = Math.abs(array[i]);
				}	
			}
			set.add(array[i]);
		}
		return res;
	}
	@Test
	void treeIteratingTest() {
		
		int[] array = {1,11,111,32,9,1234,99,992};
		TreeSet<Integer> tree = createAndIterateTreeInOrder(array);
		int[] expected = new int[array.length];
			
		Iterator<Integer> iterator = tree.iterator();
		int i = 0;
		
			while (iterator.hasNext()) {
				expected[i++] = iterator.next();
			}
		assertArrayEquals(expected, array);
	}

	private TreeSet<Integer> createAndIterateTreeInOrder(int[] array) {
		Comparator<Integer> comparator = new CompareSumDigit<Integer>();
		TreeSet<Integer> tree = new TreeSet<>(comparator);
		for (int i = 0; i < array.length; i++) {
			tree.add(array[i]);
		}	
		return tree;
		}
		

}
