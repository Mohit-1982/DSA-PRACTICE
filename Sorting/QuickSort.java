Cleaner : 
  TC : O(nlogn)
  SC : O(n) Recursive stack space
   package Sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,6,9,3,5,3,8,2,8,1,1004521};
        quickSort(arr, 0, arr.length - 1);
        for(int ele : arr) System.out.print(ele + " ");
    }
    static void quickSort(int[] arr, int low, int high) {
        if(low >= high) return;
        int partition = partition(arr, low, high);
        quickSort(arr, low, partition - 1);
        quickSort(arr, partition + 1, high);
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        int j = high;
        while(true) {
            //find the ele lesser than pivot
            while(i <= high && arr[i] < pivot) i++;
            //find the ele greater than pivot
            while(j >= low && arr[j] > pivot) j--;
            if(i >= j) break;
            //swap those two
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        //put the pivot ele on its correct position
        arr[low] = arr[j];
        arr[j] = pivot;
        //last return the pivot(Partition) index sorted place index
        return j;
    }
}

Little not cleaner
class Solution {
    public void quickSort(int[] arr, int low, int high) {
        if(low >= high) return;
        int partition = partition(arr, low, high);
        quickSort(arr, low, partition - 1);
        quickSort(arr, partition + 1, high);
    }

    private int partition(int[] arr, int low, int high) {
        int partition = arr[low];
        int i = low + 1;
        int j = high;
        while(true) {
            //find the ele lesser than parition
            while(i <= high && arr[i] < partition) i++;
            //find the ele greater than partition
            while(j >= low && arr[j] > partition) j--;
            if(i >= j) break;
            //swap those two
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        //put the partition ele on its correct position
            arr[low] = arr[j];
            arr[j] = partition;
            //last return the partition index sorted place index
            return j;
    }
}
