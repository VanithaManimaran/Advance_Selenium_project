package practice;

public class GenericMethodPractice {

	public static void main(String[] args) {
		
		/*Hard coded*/
		
//		int a =10;
//		int b = 20;
//		int c = a+b;
//		System.out.println(c);
		int sum = add(3,4);
		System.out.println(sum);
	}
	
	//generic method (or) reusable method
	public static int add(int a, int b)
	{
		int c = a+b;
		return c;
	}

}
