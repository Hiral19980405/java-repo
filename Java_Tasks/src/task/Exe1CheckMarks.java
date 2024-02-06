package task;

import java.util.Scanner;

public class Exe1CheckMarks {

	public static void main(String[] args) {

		//Get the marks through Scanner
		
		int marks;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter marks: ");
	    marks = scan.nextInt();
		
	    //91-100 -> Grade A
		//71-90 -> Grade B
		//51-70 -> Grade C
		//0-50 -> Fail
		if(marks>90 & marks<=100) //(marks>=91 & marks<=100)
		{
			System.out.println("Grade A");
		
		}
		else if(marks>70 & marks<=90) //(marks>=71 & marks<=90)
		{
			System.out.println("Grade B");
			
		}
		else if(marks>50 & marks<=70) //(marks>=51 & marks<=70)
		{
			System.out.println("Grade C");
		}
		else if(marks>=0 & marks<=50)
		{
			System.out.println("fail");
		}
		else
		{
			System.out.println("Invalid marks");
		}
	}
}
