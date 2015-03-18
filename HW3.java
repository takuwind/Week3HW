import java.io.*;
import java.util.*;

class Hw3
{
	public static void main(String[] args) throws Exception
	{
		Scanner s = new Scanner(System.in);
		String option;
		HashMap h = new HashMap();
		boolean exit = false;
		
		fileToHash("hwdata.txt", h);
		while(true)
		{
			System.out.println("Enter 1)Input data 2)Search -1)Save & Exit : ");
			option = s.next();
			
			switch(option)
			{
				case "1":
					System.out.println("Input the data : ");
					String temp1 = s.nextLine();
					temp1 = s.nextLine();
					temp1 = temp1.toLowerCase();
					String[] temp2 = temp1.split(" |,|\\.|;|!|\\?");
					for(String i : temp2)
					{
						if(h.get(i) != null)
						{
							int t = Integer.parseInt(h.get(i).toString()) + 1;
							h.put(i, t);
						}	
						else
						{
							h.put(i, 1);
						}
					}	
					break;
				case "2":
					System.out.println("Input the word you want to search : ");
					String temp3 = s.next();
					System.out.println("word\tcount");
					if(h.get(temp3) != null)
					{
						System.out.println(temp3 + "\t" + h.get(temp3));
					}
					else
					{
						System.out.println(temp3 + "\t0");
					}
					break;
				case "-1":
					textToFile(h, "hwdata.txt", "UTF-8");
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
	public static void fileToHash(String fileName, HashMap h) throws Exception
	{
		boolean check = true;
		File f = new File(fileName);
		if(f.exists())
		{
			int length = (int)(f.length());
			FileInputStream fin = new FileInputStream(f);
			DataInputStream in = new DataInputStream(fin);
			byte[] bytes = new byte[length];
			in.readFully(bytes);
			String st = new String(bytes);
			if(!st.isEmpty())
			{
				String[] str = st.split("\t|\r\n");
				for(int i = 0; i < str.length; i++)
				{
					if(str[i] != null && str.length % 2 == 0)
					{
						try
						{
							int test = Integer.parseInt(str[i + 1]);
							h.put(str[i], str[++i]);
						}
						catch(Exception e)
						{
							check = false;
							System.out.println("File Error!");
							break;
						}
					}
					else
					{
						check = false;
						System.out.println("File Error!");
						break;
					}
				}
			}
		}
		else
		{
			check = false;
			System.out.println("File is not here!");
		}
		if(check)
		{
			System.out.println("File open success!");
		}
	}
	public static void textToFile(HashMap h, String outFile, String pEncode) throws Exception 
	{
		FileOutputStream fos = new FileOutputStream(outFile);
		Writer writer;
		if (pEncode == null) 
		{
			writer =new OutputStreamWriter(fos);
		}
		else
		{
			writer = new OutputStreamWriter(fos, pEncode);
		}
		for(Object key : h.keySet())
		{
			writer.write(key + "\t" + h.get(key) + "\r\n");
		}
		writer.close();
		System.out.println("Save file success!");
	}
}