class Solution {
    public int candy(int[] ratings) {
        int sum=0;
        int n=ratings.length;
        int []lr=new int[n];
        int []rl=new int[n];
        Arrays.fill(lr,1);
        Arrays.fill(rl,1);
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                lr[i]=lr[i-1]+1;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                rl[i]=rl[i+1]+1;
            }
        }
        for(int i=0;i<ratings.length;i++){
            sum+=Math.max(lr[i],rl[i]);
        }
        return sum;
    }
}