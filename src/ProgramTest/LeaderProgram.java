package ProgramTest;

public class LeaderProgram {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = new int[] {16, 17, 4, 3, 5, 2};
		int size = arr.length;
		int max_from_right = arr[size-1];
		System.out.print(max_from_right + " ");
		for (int i = size-2; i >= 0 ; i--)
		{
			if (arr[i] > max_from_right)
			{
				max_from_right = arr[i];
				System.out.print(max_from_right + " ");
			}
		}

	}

}
