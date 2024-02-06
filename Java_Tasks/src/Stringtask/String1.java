package Stringtask;

public class String1 {

	public static void main(String[] args) {

		String price="$250";
		String quantity="4";
		
		String expectedResult ="$1000";
		String actualResult;
		
		String price1 =price.replace("$"," ");
		System.out.println(price1);
		String price2 = price1.trim();
		
		  int p=Integer.parseInt(price2);
		  int q=Integer.parseInt(quantity);
		  
		  System.out.println(price2);
		  System.out.println(quantity);
		  
		  int w = p*q;
		
		  /* while we are concating string + integer and than store the result in sting variable
		   than it will converted in string format */
		  
		  actualResult="$"+w;   
		  		  
		  System.out.println(actualResult); 
		  
		  if(actualResult.equalsIgnoreCase(expectedResult))
		  {
			  System.out.println("pass");
		  }
		  else
		  {
			  System.out.println("fail");
		  }
		  
		  
		  
		  
		  
		  
	}
}
