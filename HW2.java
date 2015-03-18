import java.io.*;
import java.util.*;

class Hw2
{
	public static void main(String[] args)
	{
		HashMap h = new HashMap();
		Scanner s = new Scanner(System.in);
		String option;
		boolean exit = false;
		
		while(true)
		{
			System.out.println("Enter  1)Input 2)Search  -1)Exit :");
			option = s.next();
			switch(option)
			{
				case "1":
					try
					{
						System.out.println("Input student name : ");
						String t1 = s.next();
						System.out.println("Input the grade : ");
						int t2 = s.nextInt();
						h.put(t1, t2);
					}
					catch(Exception e)
					{
						System.out.println("error : " + e);
					}
					break;
				case "2":
					try
					{
						System.out.println("Input student name : ");
						String t3 = s.next();
						if(h.get(t3) != null)
						{
							System.out.println("Name\t Grade");
							System.out.println(t3 + "\t" + "\t" + h.get(t3));
						}
						else
						{
							System.out.println("No data!");
						}
					}
					catch(Exception e)
					{
						System.out.println("error : " + e);
					}
					break;
				case "-1":
					exit = true;
					break;
				default:
					System.out.println("Error!");
					break;
			}
			if(exit)
			{
				break;
			}
		}
	}
}