package ProgramTest;

public class SortingTechinque {
	//Time Complexity: The time complexity of Selection Sort is O(N2) as there are two nested loops:
	public void selectionSort(int[] arr, int n)
	{
		for(int i=0 ; i < n-1 ; i++)
		{
			int min_idx = i;
			for(int j=i+1 ; j < n ; j++)
			{
				
				if(arr[j] < arr[min_idx])
				{
					 min_idx = j;	
				}
			}
			int temp = arr[min_idx];
			arr[min_idx]= arr[i];
			arr[i]= temp;
		}
		
		for(int i=0 ; i< n-1 ; i++)
		{
			System.out.println(arr[i]+ " ");
		}
	}

	public void bubbleSort(int[] arr, int n)
	{
		int temp;
		boolean swapped;
		for(int i = 0; i < n -1 ; i++)
		{
			swapped=false;
			for (int j = 0 ; j< n-i-1 ; j++)
			{
				if (arr[j] > arr[j+1])
				{
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1]=temp;
					swapped=true;
				}
			}
			if(swapped==false)
				break;
		}
		for(int i=0;i<n;i++)
		{
			System.out.println("Bubble Sort: "+arr[i]);
		}
	}
	
	public void insertionSort(int[] arr, int n)
	{
 		for(int i = 1; i<n; ++i)
		{
			int key = arr[i];
			int j = i-1;
			while(j >=0 && arr[j] > key)
			{
				arr[j+1] = arr[j];
				j=j-1;
			}
			arr[j+1] = key;
		}
		for(int i=0;i<n;i++)
		{
			System.out.println("Insertion Sort: "+arr[i]);
		}
		
	}
	
	static void sort(int arr[],int l,int r)
	{
		if(l < r)
		{
			// Find the middle point
			 int m = l + (r - l) / 2;
         // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
		}
	}
	
	static void merge(int[] arr, int l, int m, int r) {
		 // Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
        int n2 = r - m;
		// Create temp arrays
		int L[] = new int[n1];
		int R[] = new int[n2];
		
		// Copy data to temp arrays
		
		for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m +1 + j];
		
		// Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while(i < n1 && j < n2)
        {
        	if (L[i] <= R[j])
        	{
        		arr[k]= L[i];
        		i++;
        	}
        	else
        	{
        		arr[k]= R[j];
        		j++;
        	}
        	k++;
        }
        // Copy remaining elements of L[] if any
        while(i < n1)
        {
        	arr[k]=L[i];
        	i++;
        	k++;
        }
        while(j < n2)
        {
        	arr[k]=R[j];
        	j++;
        	k++;
        	
        }
		
	}

	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	
	public static void main(String[] args) {
		SortingTechinque ss = new SortingTechinque();
		int arr[] = {12,65,14,3,78,34,23};
		int n = arr.length;
//		ss.selectionSort(arr,n);
//		ss.bubbleSort(arr, n);
//		ss.insertionSort(arr, n);
		sort(arr,0,n-1);
		printArray(arr);
		

	}

}
