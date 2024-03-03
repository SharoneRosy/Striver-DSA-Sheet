class Solution {
    public double myPow(double x, int N) {
        if(N==0) return 1;

        long n=N;
        if(n<0){
            n=-n;
            x=1.0/x;
        }
        int p=(int)( n / 2 );
        double temp=myPow(x,p);
        if(n%2==0){

            return temp*temp;
        }else{
            return x*temp*temp;
        }

   }
}