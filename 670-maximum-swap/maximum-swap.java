class Solution {
    public int maximumSwap(int num) {
        String s=Integer.toString(num);
        int maxdigitindex=-1,swapId1=-1,swapId2=-1;
        char []arr=s.toCharArray();
        int n=arr.length;
        for(int i=n-1;i>=0;i--){
            if(maxdigitindex==-1 || arr[i]>arr[maxdigitindex]){
                maxdigitindex=i;
            }else if(arr[i]<arr[maxdigitindex]){
                swapId1=i;
                swapId2=maxdigitindex;
            }
        }
        if(swapId1!=-1 && swapId2!=-1){
            char temp=arr[swapId1];
            arr[swapId1]=arr[swapId2];
            arr[swapId2]=temp;
        }
        return Integer.parseInt(new String(arr));
    }
}