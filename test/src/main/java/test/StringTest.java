package test;

public class StringTest {
	public static void main(String[] args) {
		String string="20,33";
		String[] array=string.split(",");
		int max=0;
		for (String tmp : array) {
			if(Integer.valueOf(tmp)>max){
				max=Integer.valueOf(tmp);
			}
		}
		System.out.println(max);
	}
}
