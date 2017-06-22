import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) throws IOException {

		String[] directives = new String[44]; // We created a array to keep directives in.
		String line = null; // we are having the operation to read from file
		Scanner inputStream = null;
		int i = 0;
		
		try
		{
			 FileReader fileReader = new FileReader("/home/omer/Desktop/test_hw1.txt");
			 BufferedReader bufferedReader = new BufferedReader(fileReader);
			 
			 while((line = bufferedReader.readLine()) != null)
			 {
				 directives[i] = line;
				 i++;
	         }   
			 
			 bufferedReader.close();  
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
			System.exit(0);
		}
			
		Sequences list = new Sequences(Integer.parseInt(directives[0])); // we created object of sequence class to access methods.
		
		// for insert        a[1] is index, a[2] is type, a[3] is sequence
		// for display-all   only directive
		// for remove        a[1] is index
		// for display       a[1] is index
		// for copy          a[1] is index of sequence ,a[2] is copying index
		// for clip          a[1] index of sequence, a[2] is start index, a[3] is end index
		// for max-overlap   a[1] start, a[2] end
		// for transcribe    a[1] is index of dna that will be converted to RNA
		// for swap			 a[1] is pos1, a[2] is start1, a[3] is pos2, a[4] is start2
		
		int j = 1;
		String[] a;
		
		while(j<directives.length)
		{	
			a = null;
			a = new String[directives[j].split(" ").length];
			a = directives[j].split(" "); // informations in a single line will be stored in an array
			//always first element of array a is directive
			if(a[0].equals("insert") && a.length == 3) // if there is no sequence, we will check it not to face null pointer exception
				list.insert(Integer.parseInt(a[1]), " ", a[2]);
			else if(a[0].equals("insert"))
			{
				list.insert(Integer.parseInt(a[1]), a[3], a[2]);
			}
			else if(a[0].equals("display-all"))
				list.displayAll();
			else if(a[0].equals("display"))
				list.display(Integer.parseInt(a[1]));
			else if(a[0].equals("copy"))
				list.copy(Integer.parseInt(a[1]), Integer.parseInt(a[2]));
			else if(a[0].equals("transcribe"))
				list.transcribe(Integer.parseInt(a[1]));
			else if(a[0].equals("remove"))
				list.remove(Integer.parseInt(a[1]));
			else if(a[0].equals("clip"))
				list.clip(Integer.parseInt(a[1]), Integer.parseInt(a[2]), Integer.parseInt(a[3]));
			else if(a[0].equals("max-overlap"))
				list.maxOverlap(Integer.parseInt(a[1]),Integer.parseInt(a[2]));
			else if(a[0].equals("swap"))
				list.swap(Integer.parseInt(a[1]), Integer.parseInt(a[2]), Integer.parseInt(a[3]), Integer.parseInt(a[4]));
			
			j++; 
		} 
		
		
		
		
		
	}

}
