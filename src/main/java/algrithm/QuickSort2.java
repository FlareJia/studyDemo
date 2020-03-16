package algrithm;

public class QuickSort2 {
    public static void main(String[] args) {
        int[] list = {6, 11, 3, 9 ,8};
        Sort sort = new Sort();
        sort.sortMethod(list);
        for (int i=0; i<list.length; i++){
            System.out.println(list[i]);
        }
    }

    public static class Sort{
        public void sortMethod(int[] list){
            int size = list.length;
            sortMethodImpl(list, 0, size-1);
        }
        private void sortMethodImpl(int[] list, int startIndex, int endIndex){
            if (startIndex >= endIndex){
                return;
            }
            int pivot = partition(list, startIndex, endIndex);
            sortMethodImpl(list, startIndex, pivot-1);
            sortMethodImpl(list, pivot+1, endIndex);
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
