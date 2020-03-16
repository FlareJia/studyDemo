package algrithm;

public class UnOrderListTopK {
    public static void main(String[] args) {
        int[] list = {6, 11, 3, 9 ,8};
        Find find = new Find();
        System.out.println(find.findTopK(list, 1));
    }

    public static class Find{
        public int findTopK(int[] list, int k){
            if (k > list.length){
                throw new IndexOutOfBoundsException();
            }
            int res = findTopKImpl(list, 0, list.length-1, k);
            return res;
        }

        private int findTopKImpl(int[] list, int startIndex, int endIndex, int k){
            if (startIndex==endIndex){
                return list[startIndex];
            }
            int pivotIndex = partition(list, startIndex, endIndex);
            if (pivotIndex == list.length - k){
                return list[pivotIndex];
            }
            else if (pivotIndex < list.length - k){
                return findTopKImpl(list, pivotIndex+1, endIndex, k);
            }
            else {
                return findTopKImpl(list, startIndex, pivotIndex-1, k);
            }
        }

        private int partition(int[] list, int startIndex, int endIndex){
            int pivot = list[endIndex];
            int i=startIndex;
            for (int j=startIndex; j<endIndex; j++){
                if (list[j]<pivot){
                    swap(list, i ,j);
                    i++;
                }
            }
            swap(list,i,endIndex);
            return i;
        }

        private void swap(int[] list, int p, int q){
            int temp = list[p];
            list[p] = list[q];
            list[q] = temp;
        }
    }
}
