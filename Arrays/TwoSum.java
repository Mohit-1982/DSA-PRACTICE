Brute : O(n^2) Using Nested Loops
  class Solution {
    boolean twoSum(int arr[], int target) {
        //i and j should not be on same index 
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}

Better : O(nlogn) Using Sorting
  class Solution {
    public List<Integer> twoSum(int arr[], int target) {
        List<Integer> list = new ArrayList<>();
        sort(arr);
        int i = 0;
        int j = arr.length - 1;
        int sum = 0;
        while(i < j) {
            sum += (arr[i] + arr[j]);
            if(sum > target) {
                sum = 0;
                j--;
            }else if(sum < target) {
                sum = 0;
                i++;
            }else {
                list.add(arr[i]);
                list.add(arr[j]);
                break;
            }
        }
        return list;
    }
    public void sort(int[] arr) {
        int n = arr.length;
        if(n <= 1) {
            //Base Case when only 1 element is remaining in the array
            return;
        }
        //Create Arrays
        int[] a = new int[n / 2];;
        int[] b = new int[n - n / 2];
        //fill elements in these arrays
        int k = 0;
        for(int i = 0; i < a.length; i++) {
            a[i] = arr[k++];
        }
        for(int i = 0; i < b.length; i++) {
            b[i] = arr[k++];
        }
        sort(a);
        sort(b);
        merge(arr,a,b);
    }
    public void merge(int[] arr, int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < a.length && j < b.length) {
            if(a[i] < b[j]) {
                arr[k++] = a[i++];
            }else {
                arr[k++] = b[j++];
            }
        }
        while(i < a.length) {
            arr[k++] = a[i++];
        }
        while(j < b.length) {
            arr[k++] = b[j++];
        }
    }
}

Optimal : O(n) O(n) Space Using HashMap
  class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //we sill insert the value and index of element in map
        for(int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if(map.containsKey(remaining)) {
                int j = map.get(remaining);
                return new int[]{i,j};
            }
            map.put(nums[i],i);
        }
        //if we are not able to find it then we will return arrays containing negative indexes
        return new int[]{-1,-1};
    }
}
