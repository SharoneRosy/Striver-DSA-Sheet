class MovingAverage {
    int size;
    Deque dq=new ArrayDeque<Integer>();
    int sum=0;
    public MovingAverage(int size) {
        this.size=size;
    }
    
    public double next(int val) {
        dq.add(val);
        int first=dq.size()>size?(int)dq.poll():0;
         sum=sum+val-first;
        return 1.0*sum/dq.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */