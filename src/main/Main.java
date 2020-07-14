package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		//Questão 1
		List<Integer> result1 = question1Answer(Arrays.asList(1,3,0,5,8,7), 6);
		System.out.println("-----------Questão 1-----------");
		System.out.print("Resultado:  ");
		System.out.println(result1);
		
		//Questão 2
		String result2 = question2Answer("{{[[(())]]}}");
		System.out.println("-----------Questão 2-----------");
		System.out.print("Resultado:  ");
		System.out.println(result2);
		
		//Questão 3
		Integer result3 = question3Answer(Arrays.asList(1,7,2,5,3,6,4,9));
		System.out.println("-----------Questão 3-----------");
		System.out.print("Resultado:  ");
		System.out.println(result3);
		
		//Questão 4
		Integer result4 = question4Answer(Arrays.asList(0,1,0,2,1,0,1,3,2,1,2,1));
		System.out.println("-----------Questão 4-----------");
		System.out.print("Resultado:  ");
		System.out.println(result4);
	}
	
	public static List<Integer> question1Answer(List<Integer> numbers, Integer target) {
		List<Integer> answer1 = new ArrayList<>();;
		
		for(int firstElementIndex = 0; firstElementIndex < numbers.size(); firstElementIndex++) {
			for(Integer n : numbers) {
				int secondElementIndex = numbers.indexOf(n);
				if ((secondElementIndex != firstElementIndex) && (numbers.get(firstElementIndex) + n == target)) {
					answer1.add(firstElementIndex);
					answer1.add(secondElementIndex);
					break;
				}
			}
			
			if(answer1.size() > 0)
				break;
		}
		
		return answer1;
	}
	
	public static String question2Answer(String problem) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();
		
		List<Integer> list4 = new ArrayList<>();
		List<Integer> list5 = new ArrayList<>();
		List<Integer> list6 = new ArrayList<>();
		
		List<Character> brackets = problem.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

		for(int i = 0; i < brackets.size(); i++) {
			if( String.valueOf(brackets.get(i)).equals("{")) {
				list1.add(i);
			} else if( String.valueOf(brackets.get(i)).equals("[")) {
				list2.add(i);
			} else if( String.valueOf(brackets.get(i)).equals("(")){
				list3.add(i);
			} else if( String.valueOf(brackets.get(i)).equals("}")) {
				list4.add(i);
			} else if( String.valueOf(brackets.get(i)).equals("]")) {
				list5.add(i);
			} else if( String.valueOf(brackets.get(i)).equals(")")) {
				list6.add(i);
			}
		}
		
		if(list1.size() != list4.size())
			return "NAO";
		if(list2.size() != list5.size())
			return "NAO";
		if(list3.size() != list6.size())
			return "NAO";
		
		for(Integer i : list1) {
			Integer pair = null;
			for(int j = 0; j < list4.size(); j++) {
				if((brackets.size() - 1) - i == list4.get(j)) {
					pair = list4.get(j);
				}
			}
			
			if(pair == null)
				return "NAO";
		}
		
		for(Integer i : list2) {
			Integer pair = null;
			for(int j = 0; j < list5.size(); j++) {
				if((brackets.size() - 1) - i == list5.get(j)) {
					pair = list5.get(j);
				}
			}
			
			if(pair == null)
				return "NAO";
		}
		
		for(Integer i : list3) {
			Integer pair = null;
			for(int j = 0; j < list6.size(); j++) {
				if((brackets.size() - 1) - i == list6.get(j)) {
					pair = list6.get(j);
				}
			}
			
			if(pair == null)
				return "NAO";
		}
		
		return "SIM";
	}
	
	public static Integer question3Answer(List<Integer> values) {
		List<Integer> combinationsValues = new ArrayList<>();
		for(int i = 0; i < values.size(); i++) {
			Integer purchaseValue = values.get(i);
			for(int j = values.size() - 1; j > i; j--) {
				Integer saleValue = values.get(j);
				combinationsValues.add(saleValue - purchaseValue);
			}
		}
		
		Collections.sort(combinationsValues);
		
		return combinationsValues.get(combinationsValues.size() - 1) > 0 ? combinationsValues.get(combinationsValues.size() - 1) : 0;
	}
	
	public static Integer question4Answer(List<Integer> values) {
		Integer total = 0;
		
		for(int i = 0; i < values.size(); i++) {
			Integer sum = (values.get(i) - (i + 1 > values.size() - 1 ? values.get(1) : values.get(i + 1)));
			if (sum < 0) {
				total += sum;
			}
		}
		
		return Math.abs(total) - 1;
	}

}
