package advancedJavaHomeworks;

import java.util.*;

public class SortingHomework {
	
	public static ArrayList<Integer> populateAL(ArrayList<Integer> AL, int length) {
		Random rand = new Random();
		for(int i=0; i < length; i++ ) {
			AL.add(rand.nextInt());
		}
		return AL;
	}
	
	//bubblesort and combsort logic found at https://www.geeksforgeeks.org/comb-sort/
    static int nextGap(int gap)
    {
        gap = (gap*10)/13;
        if (gap < 1)
            return 1;
        return gap;
    }
    
    static ArrayList<Integer> combSort(ArrayList<Integer> AL)
    {
        int n = AL.size();
 
        // initialize gap
        int gap = n;
 
        // Initialize swapped as true to make sure that
        // loop runs
        boolean swapped = true;
 
        // Keep running while gap is more than 1 and last
        // iteration caused a swap
        while (gap != 1 || swapped == true)
        {
            // Find next gap
            gap = nextGap(gap);
 
            // Initialize swapped as false so that we can
            // check if swap happened or not
            swapped = false;
 
            // Compare all elements with current gap
            for (int i=0; i<n-gap; i++)
            {
                if (AL.get(i) > AL.get(i+gap))
                {
                    // Swap
                    int temp = AL.get(i);
                    AL.set(i, AL.get(i+gap));
                    AL.set(i+gap, temp);
 
                    // Set swapped
                    swapped = true;
                }
            }
        }
        return AL;
    }
    
    static ArrayList<Integer> bubbleSort(ArrayList<Integer> AL)
    {
        int n = AL.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (AL.get(j) > AL.get(j+1)) {
                    // swap
                    int temp = AL.get(j);
                    AL.set(j, AL.get(j+1));
                    AL.set(j+1, temp);
                }
        return AL;
    }

	public static void main(String[] args) {
		ArrayList<Integer> BubbleSortArray = new ArrayList();
		ArrayList<Integer> CombSortArray = new ArrayList();
		populateAL(BubbleSortArray, 50);
		populateAL(CombSortArray, 50);
		
		//testing the sort; vestigial
		//for(int i = 0; i < CombSortArray.size(); i++) {
		//	System.out.println(CombSortArray.get(i));
		//	}
		// combSort(CombSortArray);
		//for(int i = 0; i < CombSortArray.size(); i++) {
		//	System.out.println(CombSortArray.get(i));
		//	}
		
		long startTime = System.nanoTime();
		bubbleSort(BubbleSortArray);
		long endTime = System.nanoTime();
		System.out.println("The amount of time it takes for Bubble Sort to organize 50 entries is "+(endTime-startTime));
		startTime = System.nanoTime();
		combSort(CombSortArray);
		endTime = System.nanoTime();
		System.out.println("The amount of time it takes for Comb Sort to organize 50 entries is "+(endTime-startTime));
		BubbleSortArray.clear();
		CombSortArray.clear();
		
		
		populateAL(BubbleSortArray, 500);
		populateAL(CombSortArray, 500);
		startTime = System.nanoTime();
		bubbleSort(BubbleSortArray);
		endTime = System.nanoTime();
		System.out.println("The amount of time it takes for Bubble Sort to organize 500 entries is "+(endTime-startTime));
		startTime = System.nanoTime();
		combSort(CombSortArray);
		endTime = System.nanoTime();
		System.out.println("The amount of time it takes for Comb Sort to organize 500 entries is "+(endTime-startTime));
		BubbleSortArray.clear();
		CombSortArray.clear();
		
		
		populateAL(BubbleSortArray, 5000);
		populateAL(CombSortArray, 5000);
		startTime = System.nanoTime();
		bubbleSort(BubbleSortArray);
		endTime = System.nanoTime();
		System.out.println("The amount of time it takes for Bubble Sort to organize 5,000 entries is "+(endTime-startTime));
		startTime = System.nanoTime();
		combSort(CombSortArray);
		endTime = System.nanoTime();
		System.out.println("The amount of time it takes for Comb Sort to organize 5,000 entries is "+(endTime-startTime));
		BubbleSortArray.clear();
		CombSortArray.clear();
		
		
		populateAL(BubbleSortArray, 50000);
		populateAL(CombSortArray, 50000);
		startTime = System.nanoTime();
		bubbleSort(BubbleSortArray);
		endTime = System.nanoTime();
		System.out.println("The amount of time it takes for Bubble Sort to organize 50,000 entries is "+(endTime-startTime));
		startTime = System.nanoTime();
		combSort(CombSortArray);
		endTime = System.nanoTime();
		System.out.println("The amount of time it takes for Comb Sort to organize 50,000 entries is "+(endTime-startTime));
	}

}
