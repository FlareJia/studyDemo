package algrithm;

import java.util.PriorityQueue;

public class UnOrderListMedian {

    public static void main(String[] args) {
        double[] list = {0,1,2,3,4,5};
        GetMedian getMedian = new GetMedian();
        System.out.println(getMedian.getMedianNumber(list));
    }

    public static class GetMedian{
        public double getMedianNumber(double[] list){
            int heapSize = list.length / 2 + 1;
            PriorityQueue<Double> minHeap = new PriorityQueue<>();

            for (int i=0; i < heapSize; i++){
                minHeap.add(list[i]);
            }

            for (int i=heapSize; i<list.length; i++){
                if (list[i] > minHeap.peek()){
                    minHeap.poll();
                    minHeap.add(list[i]);
                }
            }
            if (list.length%2==1){
                return minHeap.peek();
            }
            else {
                return (minHeap.poll()+minHeap.peek())/2;
            }

        }
    }
}
