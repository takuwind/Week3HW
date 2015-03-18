import java.io.*;
import java.util.*;

class Hw1
{
	public static void main(String[] args)
	{
		ArrayList<String> al = new ArrayList<String>();
		Scanner s = new Scanner(System.in);
		String str;
		int count = 0;
		System.out.println("Input a sentence : ");
		str = s.nextLine();		
		String[] temp = str.split(" |,|\\.|;|!|\\?");
		for(String arr : temp)
		{
			if(arr.matches("[A-Z]+"))	
			{
				al.add(arr.toLowerCase());
			}
			else if(arr.matches("[a-z]+"))
			{
				al.add(arr);
			}
			else if(arr.matches("[0-9]+"))
			{
				count += Integer.parseInt(arr);
			}
		}
		if(count != 0)
		{
			al.add(Integer.toString(count));
		}
		for(int i = 0; i < al.size(); i++)
		{
			System.out.println(al.get(i));
		}
	}
}
