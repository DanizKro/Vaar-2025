package Sorting;

public class MergeSort {
	
	// https://www.youtube.com/watch?v=3j0SWDX4AtU
	
	public static void main(String[]args) {
		
		int[] array = {8,2,5,7,3,8,1,4,3};
		
		
		System.out.println("Tabell:");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("\n");
		
		
		mergeSort(array);
		
		
		System.out.println("Sortert tabell:");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
		
		
	}

	// O-notasjon = O(n*log(n))
	private static void mergeSort(int[] array) {
		
		int length = array.length;
		
		//Basetilfelle
		if(length <= 1) {
			return;
		}
		
		int middle = length/2;
		int[] leftArray = new int[middle];
		int[] rightArray = new int[length-middle];
			
		int i = 0; //left array
		int j = 0; //right array
		
		for(; i < length; i++) {
			if(i < middle) {
				leftArray[i] = array[i];
			} else {
				rightArray[j] = array[i];
				j++;
			}
		} 
		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(leftArray, rightArray, array);
		
	}
	
	private static void merge(int[] leftArray, int[] rightArray, int[] array) {
		
		int leftSize = array.length/2;
		int rightSize = array.length - leftSize;
		
		//index
		int i = 0;
		int l = 0;
		int r = 0;
		
		while(l < leftSize && r < rightSize) {
			if(leftArray[l] < rightArray[r]) {
				array[i] = leftArray[l];
				i++;
				l++;
			} else {
				array[i] = rightArray[r];
				i++;
				r++;
			}
		}
		
		//om oddetalls tabell på en av sidene må det siste elemente taes i betrakning, sjekker begge sider
		while(l < leftSize) {
			array[i] = leftArray[l];
			i++;
			l++;
		}
		while(r < rightSize) {
			array[i] = rightArray[r];
			i++;
			r++;
		}
	}
	
	
	

}
