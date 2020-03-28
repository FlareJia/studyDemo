package algrithm;

public class InsertSort {
    public static void main(String[] args) {
    int[] list = {4,5,6,1,3,2};
    InsertSortImpl insertSort = new InsertSortImpl();
    insertSort.insertionSort(list, list.length);
    for (int i=0; i<list.length; i++){
        System.out.println(list[i]);
    }
    }

    public static class InsertSortImpl{
        public void insertionSort(int[] list, int n){
            if(n <= 1){
                return;
            }

            for(int i=1; i<n; i++){
                int curValue = list[i];
                int j = i-1;
                for(;j>=0; j--){
                    if(list[j]>curValue){
                        list[j+1] = list[j];
                    }
                    else {
                        break;
                    }
                }
                list[j+1] = curValue;
            }
        }
    }
}
