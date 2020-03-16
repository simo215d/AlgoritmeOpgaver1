public class SortingAlgorithm {
    public void selectionSort(){
        int[] list = new int[]{9,2,5,3,9,7};
        for (int i = 0; i < list.length; i++) {
            int smallest = list[i];
            int indexOfNumberToSwap = i;
            //i find the smallest number starting from what we already sorted
            for (int j = i; j < list.length; j++) {
                if (list[j]<smallest){
                    smallest=list[j];
                    indexOfNumberToSwap=j;
                }
            }
            //here i swap the smallest number with our 'checkpoint' element position
            list[indexOfNumberToSwap]=list[i];
            list[i]=smallest;
            System.out.println("smallest number: "+smallest+". index: "+indexOfNumberToSwap+". list: ");
            for (int j = 0; j < list.length; j++) {
                System.out.println(list[j]);
            }
        }
    }

    public void bubbleSort(){
        int[] list = new int[]{9,2,5,3,9,7};
        //i perform the loop as many times as the list is long, because the app told me so :P
        for (int k = 0; k < list.length; k++) {
            //in every loop i make the swaps if right is less the left.
            for (int i = list.length-1; i > 0; i--) {
                //store values
                int currentRightNumber = list[i];
                int currentLeftNumber = list[i-1];
                //perform swap
                if (currentRightNumber<currentLeftNumber){
                    list[i]=currentLeftNumber;
                    list[i-1]=currentRightNumber;
                }
            }
        }
    }

    public static void main(String[] args) {
        SortingAlgorithm sortingAlgorithm = new SortingAlgorithm();
        //sortingAlgorithm.selectionSort();
        sortingAlgorithm.bubbleSort();
    }
}
