GFG
  Brute : O(n) Space And Time Uding HashMap
    class Solution {
    int majorityElement(int arr[]) {
        //HashMap (Freq Array Also)
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
        }
        int mostFreq = -1;
        int mostFreqNo = -1;
        for(int ele : map.keySet()) {
            if(mostFreq < map.get(ele)) {
                mostFreq = map.get(ele);
                mostFreqNo = ele;
            }
        }
        if(mostFreq > arr.length / 2) {
            return mostFreqNo;
        }
        return -1;
    }
}

Optimal : O(n)  Moores voting Algorithm
  class Solution {
    int majorityElement(int arr[]) {
        //Moores voting Algorithm
        int mostFreq = 0;
        int mostFrequent = 0;
        for(int i = 0; i < arr.length; i++) {
            if(mostFreq == 0) {
                mostFrequent = arr[i];
                mostFreq++;
            }
            else if(arr[i] == mostFrequent) {
                mostFreq++;
            }else{
                mostFreq--;
            }
        }
        //Verification loop
        int freqOfMostFreqInt = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == mostFrequent) {
                freqOfMostFreqInt++;
            }
        }
        if(freqOfMostFreqInt > arr.length / 2) {
            return mostFrequent;
        }
        return -1;
    }
}
