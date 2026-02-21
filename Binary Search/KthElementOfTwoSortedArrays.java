GFG
  Brute : O(n1 + n2) and O(n1 + n2)
    class Solution {
    public int kthElement(int a[], int b[], int m) {
        int n1 = a.length;
        int n2 = b.length;
        int[] arr = new int[n1 + n2];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < n1 && j < n2) {
            if(a[i] < b[j]) arr[k++] = a[i++];
            else arr[k++] = b[j++];
        }
        while(i < n1) arr[k++] = a[i++];
        while(j < n2) arr[k++] = b[j++];
        return arr[m - 1];
    }
}
Better : O(n1 + n2) and O(1)
  class Solution {
    public int kthElement(int a[], int b[], int m) {
        int n1 = a.length;
        int n2 = b.length;
        int i = 0;
        int j = 0;
        int k = 1;
        while(i < n1 && j < n2) {
            if(a[i] < b[j]) {
                if(k == m) return a[i];
                k++;
                i++;
            }else {
                if(k == m) return b[j];
                k++;
                j++;
            }
        }
        while(i < n1) {
            if(k == m) return a[i];
            k++;
            i++;
        }
        while(j < n2) {
            if(k == m) return b[j];
            k++;
            j++;
        }
        return -1;
    }
}

Optimal : O(log(min(a, b))
            Using Median of Two Sorted Array Concept
  class Solution {
    public int kthElement(int a[], int b[], int k) {
        int n1 = a.length;
        int n2 = b.length;
        if(n1 > n2) return kthElement(b, a, k);
        int s = Math.max(0, k - n2);
        int e = Math.min(k, n1);
        while(s <= e) {
            int mid1 = s + ((e - s) >> 1);
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            int mid2 = k - mid1;
            if(mid1 - 1 >= 0) l1 = a[mid1 - 1];
            if(mid2 - 1 >= 0) l2 = b[mid2 - 1];
            if(mid1 < n1) r1 = a[mid1];
            if(mid2 < n2) r2 = b[mid2];
            if(l1 <= r2 && l2 <= r1) return Math.max(l1, l2);
            else if(l1 > r2) e = mid1 - 1;
            else s = mid1 + 1;
        }
        return -1;
    }
}
