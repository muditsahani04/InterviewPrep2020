class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    int count;
    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer> (Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer> ();

        count =0;
    }

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());

        if (maxHeap.size() < minHeap.size())
        {
            maxHeap.add(minHeap.poll());
        }

        count++;

    }

    public double findMedian() {
        if (count %2 == 0)
            return (((double) (maxHeap.peek() + minHeap.peek()))/2);
        else
            return ((double) (maxHeap.peek()));
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
