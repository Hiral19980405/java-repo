package task;

import java.util.Scanner;

public class Exe2CheckGreatestNumber {

	public static void main(String[] args) {

		//get three numbers through Scanner
		
		int v1;
		int v2;
		int v3;
		
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter numbers:");
			v1 = scan.nextInt();
			v2 = scan.nextInt();
			v3 = scan.nextInt();
			
			if (v1>v2 & v1>v3)
			{
				System.out.println("V1 is greater :"+ v1);
			}
			else if (v2>v1 & v2>v3)
			{
				System.out.println("v2 is greater:"+v2);
				
			}
			else
			{
				System.out.println("v3 is greater:"+v3);
				
			}
			
	}
	}
	
			
			
	


