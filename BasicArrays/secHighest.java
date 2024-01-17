package BasicArrays;

public class secHighest {
    public static int[] getSecondOrderElements(int n, int []a) {
        // Write your code here.

        int h=Integer.MIN_VALUE;
        int sh=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(a[i]>h){
                sh=h;
                h=a[i]; 
            }
            else if(a[i]>sh){
                sh=a[i];
            }
        }

        int s=Integer.MAX_VALUE;
        int ss=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(a[i]<s){
                ss=s;
                s=a[i];
            }else if(a[i]<ss){
                ss=a[i];
            }
        }
        int []ans=new int[2];
        ans[0]=sh;
        ans[1]=ss;
        return ans;
    }
    
}
