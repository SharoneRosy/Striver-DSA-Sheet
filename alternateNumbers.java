package MediumArrays;

public class alternateNumbers {

        public static int[] alternateNumber(int []a) {
            // Write your code here.
            int n=a.length;
            int ans[]=new int[n];
            int pos=0,neg=1;
            for(int i=0;i<n;i++){
                if(a[i]>0){
                    ans[pos]=a[i];
                    pos+=2;
                }
                else{
                    ans[neg]=a[i];
                    neg+=2;
                }
            }return ans;
    
        }
    }

