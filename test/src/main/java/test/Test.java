package test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String args[]){
		String answer="Take it to!school for me and him tomorrow.".toLowerCase();
		
		String regEx="[`~!@#$%^&*()+=|{}:;,\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]"; 
		Pattern p = Pattern.compile(regEx); 
		Matcher m = p.matcher(answer);
		System.out.println("m="+m.replaceAll(" ").trim());
		List<String> answerList=Arrays.asList(answer.split("\\/"));
		String marks="2";
		String userAnsList="How are you, fine,and you. ".toLowerCase();
		List<Double> noMarks=new ArrayList<Double>();
		for (int i = 0; i < answerList.size(); i++) {
			Integer sum=0;
			System.out.println(answerList.get(i));
			List<String> userAnsArray = Arrays.asList(userAnsList.replaceAll("\\pP" , " ").split("\\s+"));
			//清楚标点符号
			String cardAns=answerList.get(i).replaceAll("\\pP" , " "); 
			List<String> cardsAnsArray = Arrays.asList(cardAns.split("\\s+")); 
			System.out.println("userAnsArray="+userAnsArray);
			System.out.println("cardsAnsArray="+cardsAnsArray);
			for (int k = 0; k < cardsAnsArray.size(); k++) {
				if(userAnsArray.contains(cardsAnsArray.get(k))){
					sum++;
					System.out.println(1);
				}
			}
			DecimalFormat df = new DecimalFormat("#.00");
			// 非选择题（填空题）最终得分算法
			Double zql = Double.valueOf((df.format(Double.valueOf(sum) / Double.valueOf(cardsAnsArray.size())*Double.valueOf(marks))));
			System.out.println(zql);
			if(zql.toString().length()>1){
				// TODO
				Double marksSum=0.0;
				//通过小数点后面的数值进行比较
				Double lastNumber=Double.valueOf("0."+zql.toString().substring(zql.toString().indexOf(".")+1));
				if(0.3<lastNumber && lastNumber<=0.8){
					marksSum=0.5;
				}else if(0.8<lastNumber){
					marksSum=1.0;
				}
				noMarks.add((Double) (Double.valueOf(zql.toString().substring(0,zql.toString().indexOf(".")))+marksSum));
			}else{
				noMarks.add(zql);
			}
		}
		if(answerList.size()==1){
			System.out.println(noMarks.get(0));
		}else{
			if(noMarks.get(0)>noMarks.get(1)){
				System.out.println(noMarks.get(0));
			}else{
				System.out.println(noMarks.get(1));
			}
		}
		
    }
	
	public int getSum(int n){
		int sum=0;
		int finalSum=0;
		for (int i = 1; i < n; i++) {
			sum+=i;
			finalSum+=sum;
		}
		return finalSum;
	}
}
