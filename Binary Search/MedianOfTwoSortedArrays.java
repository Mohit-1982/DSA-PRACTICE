Leetcode - 4
  class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        //If len of 1st array is greater then 2nd then just make nums2 as nums1 using reverse as we are considering nums1 as smaller array
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);
        int s = 0;
        int e = n1;
        int symm = (n1 + n2 + 1) >> 1; 
        int len = n1 + n2;
        while(s <= e) {
            int mid1 = s + ((e - s) >> 1);
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            int mid2 = symm - mid1;
            if(mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            if(mid2 - 1 >= 0) l2 = nums2[mid2 - 1];
            if(mid1 < n1) r1 = nums1[mid1];
            if(mid2 < n2) r2 = nums2[mid2];
            if(l1 <= r2 && l2 <= r1) {
                if(len % 2 == 0) {
                    int leftMax = Math.max(l1, l2);
                    int rightMin = Math.min(r1, r2);
                    double res = (double)(leftMax + rightMin) / 2.0;
                    return res;
                }else {
                    //Giving Priority to left Side
                    return Math.max(l1, l2);
                }
            }else if(l1 > r2) {
                e = mid1 - 1;
            }else {
                s = mid1 + 1;
            }
        }
        return 0;
    }
}
