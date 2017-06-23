
public class Sequences {

	public DoubleCircularLinkedList<String>[] arrayseq;
	
	public Sequences(int cap) // We here creating a array that will hold all the sequences
	{
		arrayseq = new DoubleCircularLinkedList[cap]; // capacity read from txt file
		for(int i = 0; i<arrayseq.length;i++)
		{
			arrayseq[i] = new DoubleCircularLinkedList(); // I am making all the list EMPTY type
			arrayseq[i].setType("EMPTY");
		}
	}
	
	private boolean isRNA(String rna) // It checks if given sequence is suitable for RNA type
	{
		//RNA cannot include "T"
		boolean a = true;
		for(int i = 0; i < rna.length(); i++) // Checking all the letters of sequence and if it is not okay
			{//we are making a variable false, it will be used in insert method
				if(rna.charAt(i) == 'T')
					a = false;
			}
		return a;
	}
	
	private boolean isDNA(String dna) // It checks if given sequence is suitable for DNA type
	{
		//DNA cannot include "U"
		boolean a = true;
		for(int i = 0; i < dna.length(); i++)// Checking all the letters of sequence and if it is not okay
			{//we are making a variable false, it will be used in insert method
				if(dna.charAt(i) == 'U')
				a = false;
			}
		return a;
	}
	
	public void insert(int index, String seq, String type)
	{
		if(index>=arrayseq.length) // if given index is more than length of array, error message is shown up
			System.out.println("Given number is larger than the last index of list!");
		else if(seq.length() == 0) // if sequence has no letter, then we make type of list empty
			arrayseq[index].setType("EMPTY");
		else if(type.equals("DNA")) //if type is DNA then we go on here
		{
			if(!arrayseq[index].getType().equals("EMPTY")) // If that index of array is not empty, then we
			{// will make it empty and create empty list 
				DoubleCircularLinkedList helper = arrayseq[index];
				arrayseq[index] = null;
				arrayseq[index] = new DoubleCircularLinkedList<String>();
				helper = null;
			}
			
			if(isDNA(seq)) // checking if it is okay for DNA type, if so we go on here
			{
				int a = seq.length();
				while(a > 0) // filling the list with given sequences letters
				{
				arrayseq[index].addFirst(Character.toString(seq.charAt(a-1)));
				a--;
				}
				arrayseq[index].setType("DNA"); // set type DNA
				System.out.println("Inserted!" + index + ". sequence." );
			}
			else
				System.out.println("This sequence includes unsuitable character(s)"); //if unsuitable char exist
		}// we give an error message and make no operation
		else if(type.equals("RNA")) // all is same with methods for DNA
		{
			if(!arrayseq[index].getType().equals("EMPTY"))
			{
				DoubleCircularLinkedList helper = arrayseq[index];
				arrayseq[index] = null;
				arrayseq[index] = new DoubleCircularLinkedList<String>();
				helper = null;
			}
			
			if(isRNA(seq))
			{
				int a = seq.length();
				while(a > 0)
				{
				arrayseq[index].addFirst(Character.toString(seq.charAt(a-1)));
				a--;
				}
				arrayseq[index].setType("RNA");
				System.out.println("Inserted!" + index + ". sequence." );
			}
			else
				System.out.println("This sequence includes unsuitable character(s)");
		}
		
	}
	
	private void insert2(int index, String seq, String type) // not to have a inserted! message, it is created, only difference from insert is that this method dont show "inserted" message
	{
		if(index>=arrayseq.length) // if given index is more than length of array, error message is shown up
			System.out.println("Given number is larger than the last index of list!");
		else if(seq.length() == 0) // if sequence has no letter, then we make type of list empty
			arrayseq[index].setType("EMPTY");
		else if(type.equals("DNA")) //if type is DNA then we go on here
		{
			if(!arrayseq[index].getType().equals("EMPTY")) // If that index of array is not empty, then we
			{// will make it empty and create empty list 
				DoubleCircularLinkedList helper = arrayseq[index];
				arrayseq[index] = null;
				arrayseq[index] = new DoubleCircularLinkedList<String>();
				helper = null;
			}
			
			if(isDNA(seq)) // checking if it is okay for DNA type, if so we go on here
			{
				int a = seq.length();
				while(a > 0) // filling the list with given sequences letters
				{
				arrayseq[index].addFirst(Character.toString(seq.charAt(a-1)));
				a--;
				}
				arrayseq[index].setType("DNA"); // set type DNA
			}
			else
				System.out.println("This sequence includes unsuitable character(s)"); //if unsuitable char exist
		}// we give an error message and make no operation
		else if(type.equals("RNA")) // all is same with methods for DNA
		{
			if(!arrayseq[index].getType().equals("EMPTY"))
			{
				DoubleCircularLinkedList helper = arrayseq[index];
				arrayseq[index] = null;
				arrayseq[index] = new DoubleCircularLinkedList<String>();
				helper = null;
			}
			
			if(isRNA(seq))
			{
				int a = seq.length();
				while(a > 0)
				{
				arrayseq[index].addFirst(Character.toString(seq.charAt(a-1)));
				a--;
				}
				arrayseq[index].setType("RNA");
			}
			else
				System.out.println("This sequence includes unsuitable character(s)");
		}
	}
	
	public void displayAll() //kind of toString method 
	{		
		for(int z = 0; z<arrayseq.length;z++)
		{
			System.out.println(z + " " + arrayseq[z].getType() + " " + arrayseq[z].toString());
		}
		
	}
	
	public void display(int pos) // just one line
	{
		if(pos>arrayseq.length) //if given index is more than length of array, error message is shown up
			System.out.println("Given number is larger than the last index of list!");
		else if(arrayseq[pos].getType().equals("EMPTY"))	
			System.out.println("There is no sequence in that position!");
		else
		System.out.println(pos + " " + arrayseq[pos].getType() + " " + arrayseq[pos].toString());
	}
	
	
	
	public void clip(int pos, int start, int end)
	{
		if(pos>arrayseq.length) //if given index is more than length of array, error message is shown up
			System.out.println("Given number is larger than the last index of list!");
		else if(arrayseq[pos].getType().equals("EMPTY"))
			System.out.println("There is no sequence in that position!");
		else //Here, we are having clipped sequence and transfer it to new linked list and then we add new list to seqarray
		{
			DoubleCircularLinkedList<String> newest = new DoubleCircularLinkedList<>();
			while(start <= end)
			{
				newest.addFirst(arrayseq[pos].get(end));
				end--;
			}
			String bckp = arrayseq[pos].getType();
			arrayseq[pos] = null;
			arrayseq[pos] = new DoubleCircularLinkedList<>();
			arrayseq[pos] = newest;
			newest.setType(bckp);
			System.out.println("Clipped " + pos + ". position");
		}
		
	}
	
	public void copy(int pos1, int pos2)
	{
		if(pos1>arrayseq.length || pos2>arrayseq.length) //if at least one of the given index is more than length of array, error message is shown up
			System.out.println("Given number is larger than the last index of list!");
		else if(arrayseq[pos1].getType().equals("EMPTY"))// if that index of array has empty sequence, error message is shown up
			System.out.println("There is no sequence to copy at this position!");
		else
		{
		insert2(pos2,arrayseq[pos1].toString(), arrayseq[pos1].getType()); // if it can handle all the conditions, we can insert it to array
		System.out.println("Copied " + pos1 + " to " + pos2);
		}
	}
	
	public void transcribe(int pos1)
	{
		if(arrayseq[pos1].getType().equals("RNA")) //  if given index includes RNA error message is shown up
			System.out.println("RNA type cannot be transcribed");
		else
		{
			arrayseq[pos1].setType("RNA");// setting type DNA to RNA
			int p = 0;
			int p1 = 0;
			int p2 = 0;
			int p3 = 0;
			int p4 = 0;
			int p5 = 0;
			int p6 = 0;
			
			while(p < arrayseq[pos1].size()) // we are making every T to U
			{
				if(arrayseq[pos1].get(p).equals("T"))
					arrayseq[pos1].set(p, "U");
				p++;
			}
			
			while(p1 < arrayseq[pos1].size()) // we are making every A to U1
			{
				if(arrayseq[pos1].get(p1).equals("A"))
					arrayseq[pos1].set(p1, "U1");
				p1++;
			}
			
			while(p2 < arrayseq[pos1].size()) // we are making every U to A
			{
				if(arrayseq[pos1].get(p2).equals("U"))
					arrayseq[pos1].set(p2, "A");
				p2++;
			}
			
			while(p3 < arrayseq[pos1].size()) // we are making every U1 to U
			{
				if(arrayseq[pos1].get(p3).equals("U1"))
					arrayseq[pos1].set(p3, "U");
				p3++;
			}
			
			while(p4 < arrayseq[pos1].size()) // we are making every G to C1
			{
				if(arrayseq[pos1].get(p4).equals("G"))
					arrayseq[pos1].set(p4, "C1");
				p4++;
			}
			
			while(p5 < arrayseq[pos1].size()) // we are making every C to G
			{
				if(arrayseq[pos1].get(p5).equals("C"))
					arrayseq[pos1].set(p5, "G");
				p5++;
			}
			
			while(p6 < arrayseq[pos1].size()) // we are making every C1 to C
			{
				if(arrayseq[pos1].get(p6).equals("C1"))
					arrayseq[pos1].set(p6, "C");
				p6++;
			}
			
			insert2(pos1, arrayseq[pos1].reverse().toString(),"RNA"); // reversing list with reverse method in the linkedlist class
		}
		
	}
	
	
	
	
	public void remove(int index)
	{
		if(arrayseq[index].getType().equals("EMPTY"))
			System.out.println("This position is empty so no operation will be done");
		else
		{
			arrayseq[index].setType("EMPTY");
			while(!arrayseq[index].isEmpty())
			{
			arrayseq[index].removeFirst();
			}
			System.out.println("Removed! " + index + ". sequence");
		}
	}
	
	
	
	
	/*
	 * In swap method, I create 4 new linked list. tail1 holds the start to end elements of pos1;
	 * tail2 holds the start to end elements of pos2;
	 * beg1 holds the 0 to start1 - 1 elements of pos1;
	 * beg2 holds the 0 to start2 - 1 elements of pos2;
	 * After making operations above, now we can bond beg1 + tail2 and beg2 + tail1 and insert it to arrayseq
	 */
	public void swap(int pos1, int start1, int pos2, int start2)
	{
		if(start1 < 0 || start1 >= arrayseq[pos1].size() || start2 < 0 || start2 >= arrayseq[pos2].size())
			System.out.println("No swap");
		else
		{
		DoubleCircularLinkedList<String> tail1 = new DoubleCircularLinkedList<>();
		DoubleCircularLinkedList<String> tail2 = new DoubleCircularLinkedList<>();
		DoubleCircularLinkedList<String> beg1 = new DoubleCircularLinkedList<>();
		DoubleCircularLinkedList<String> beg2 = new DoubleCircularLinkedList<>();

		int s1 = start1;
		int s2 = start2;
		int s12 = start1;
		int s22 = start2;
		while(s1 < arrayseq[pos1].size())
		{
			tail1.addFirst(arrayseq[pos1].get(s1));
			s1++;
		}
		tail1 = tail1.reverse();	
			
		while(s2 < arrayseq[pos2].size())
		{
			tail2.addFirst(arrayseq[pos2].get(s2));
			s2++;
		}
		tail2 = tail2.reverse();
			
		while(1 <= start1)
		{
			beg1.addFirst(arrayseq[pos1].get(start1-1));
			start1--;
		}
		
		while(1 <= start2)
		{
			beg2.addFirst(arrayseq[pos2].get(start2-1));
			start2--;
		}
		
		String type1 = arrayseq[pos1].getType();
		String type2 = arrayseq[pos2].getType();
		
		arrayseq[pos1] = null;
		arrayseq[pos2] = null;
		
		arrayseq[pos1] = new DoubleCircularLinkedList<>();
		arrayseq[pos1].setType(type1);
		arrayseq[pos2] = new DoubleCircularLinkedList<>();
		arrayseq[pos2].setType(type2);

		insert2(pos1, beg1.toString()+tail2.toString(), type1);
		insert2(pos2, beg2.toString()+tail1.toString(), type2);

		System.out.println("Swapped " +  pos1 + " from index " + s12 + " with " + pos2 + " sequence from index " + s22);
		}
	}
	

}

