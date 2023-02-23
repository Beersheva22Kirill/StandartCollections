package telran.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;
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
	@Disabled
	void displayDigitStatisticsTest() {
		List<Integer> list = new LinkedList<>();
		List<String> strList = new LinkedList<>();
				
		new Random().ints(1,Integer.MAX_VALUE - 1).limit(1000000).flatMap(num -> (""+ num).chars()).map(num -> (char)num - '0').boxed()
		.collect(Collectors.groupingBy(num -> num, Collectors.counting())).entrySet().stream().sorted((el1, el2) -> Long.compare(el2.getValue(), el1.getKey()))
		.forEach((el) -> System.out.printf("%s - %s\n", el.getKey(), el.getValue()));
			
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

}
