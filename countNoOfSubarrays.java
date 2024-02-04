package MediumArrays;

import java.util.* ;
import java.io.*; 
public class countNoOfSubarrays {
 
    public static int findAllSubarraysWithGivenSum(int arr[], int s) {
        // Write your code here.

        HashMap<Integer,Integer>map=new HashMap<>();
        int presum=0;
        int count=0;
        map.put(0, 1);
        for(int i=0;i<arr.length;i++){
            presum+=arr[i];
            int remove=presum-s;
            count+=map.getOrDefault(remove,0);
            map.put(presum, map.getOrDefault(presum, 0)+1);
        }return count;
    }
}


