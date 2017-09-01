package method;

public class Ex1 
{
	void method1()
	{
System.out.println("Good Morning");

}

	void method2 (int a,int b)
	
	{
		System.out.println(a+b);
	}
	
	boolean method3()
	
	{
		return false;
	}
	
	int method4(int a,int b)
	
	{
		int c =a*b;
		return c;
	}
		
		public static void main(String[]args)
		
		{
			  Ex1 x = new Ex1();
			
			x.method1();
			x.method2(10,20);
			boolean res=x.method3();
			System.out.println(res);
			int res1=x.method4(10,20);
			System.out.println(res1);
			
		}
	}
	

	