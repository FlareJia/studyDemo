package algrithm;

public class QuickSort {
    public static void main(String[] args) {
        int[] list = {6, 11, 3, 9 ,8};
        Sort sort = new Sort();
        sort.quickSort(list, list.length);

        for (int i=0; i<list.length; i++){
            System.out.println(list[i]);
        }
    }

    public static class Sort{
        public void quickSort(int[] list, int n){
            quickSortImpl(list, 0, n-1);
        }

        private void quickSortImpl(int[] list, int startIndex, int endIndex){
            if (startIndex >= endIndex){
                return;
            }
            int partitionNode = partition(list, startIndex, endIndex);
            quickSortImpl(list, startIndex, partitionNode-1);
            quickSortImpl(list, partitionNode+1, endIndex);
        }

        private int partition(int[] list, int startIndex, int endIndex){
            int pivot = list[endIndex];
            int i = startIndex;
            for (int j=startIndex; j<endIndex; j++){
                if (list[j] < pivot){
                    swap(list, i, j);
                    i++;
                }
            }
            swap(list,i, endIndex);
            return i;
        }

        private void swap(int[] list, int p, int q){
            int temp = list[p];
            list[p] = list[q];
            list[q] = temp;
        }
    }
}
