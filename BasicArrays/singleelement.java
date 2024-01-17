package BasicArrays;

public class singleelement {
    public static int getSingleElement(int []arr){
        // Write your code here.
        int n=arr.length;
        HashMap<Integer,Integer> dict=new HashMap<>();
        for(int i=0;i<n;i++){
            if(!dict.containsKey(arr[i])){
                dict.put(arr[i], 1);
            }else{
                dict.put(arr[i], dict.get(arr[i])+1);
            }
        }
        for(Map.Entry<Integer,Integer>it:dict.entrySet()){
            if(it.getValue()==1){
                return it.getKey();
            }
        }
        return -1;
    }
}
