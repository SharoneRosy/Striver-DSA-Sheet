class MedianFinder {
    PriorityQueue<Integer>maxHeap;
    PriorityQueue<Integer>minHeap;
    int size;
    public MedianFinder() {
        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        minHeap=new PriorityQueue<>();
        size=0;
    }
    public void addNum(int num) {
        if(size%2==0){
            if(minHeap.isEmpty()|| num<=minHeap.peek()){
                maxHeap.add(num);
            }else{
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }
        }else{
            if(num>=maxHeap.peek()){
                minHeap.add(num);
            }else{
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }
        }
        size++;
    } 
    public double findMedian() {
        if(size%2==0){
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }else{
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */