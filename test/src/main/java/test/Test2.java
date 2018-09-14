package test;

import java.util.Arrays;
import java.util.List;

public class Test2 {
	public static void main(String[] args) {
		String answer="a|b";
		List<String> answerList=Arrays.asList(answer.split("\\|"));
		System.out.println(answerList.size());
		for (String string : answerList) {
			System.out.println(string);
		}
	}
	
}
