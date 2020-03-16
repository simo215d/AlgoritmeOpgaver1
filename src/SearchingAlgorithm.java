import java.util.ArrayList;
import java.util.Arrays;

public class SearchingAlgorithm {

    private String[] data = new String[]{"borrow","original","pot","scramble","heel","breakfast","mist","autonomy","discriminate","rush"};

    //linear search algorithm
    private boolean find(String x){
        for (String currentWord : data) {
            if (x.equals(currentWord)) {
                return true;
            }
        }
        return false;
    }

    //linear search algorithm
    private int findAll(String x){
        int result = 0;
        for (String currentWord : data) {
            if (x.equals(currentWord)) {
                result++;
            }
        }
        return result;
    }

    //linear search algorithm
    private String findMax(){
        String largest = data[0];
        for (String currentWord : data) {
            if (currentWord.length()>largest.length()) {
                largest=currentWord;
            }
        }
        return largest;
    }

    //binary search algorithm combined with recursion
    public boolean searchForNumber(ArrayList<Integer> presortedArray, int x){
        //souts help me debug and see what is going on
        if (presortedArray.size() > 0) {
            System.out.println("i begun an iteration. current size: "+presortedArray.size()+". x= "+x+" get(0)= "+presortedArray.get(0)+" middle element index: "+presortedArray.size()/2);
        } else {
            System.out.println("array is empty!");
            return false;
        }
        for (int number : presortedArray){
            System.out.println(number);
        }

        int indexOfMiddleElement = presortedArray.size()/2;
        //this is our win condition
        if (presortedArray.get(indexOfMiddleElement)==x){
            return true;
        }
        //if our middle element is less than x, we then remove everything from beginning of array till and with indexOfMiddleElement
        if (presortedArray.get(indexOfMiddleElement)<x){
            //i first find how many elements we want to remove
            int candidatesToRemove = indexOfMiddleElement+1;
            //then i repeatedly remove from 0 until we removed as many as candidatesToRemove was.
            //i can remove from same index, because array list will adjust to the deletion and put the next number there.
            for (int i = 0; i < candidatesToRemove; i++) {
                presortedArray.remove(0);
            }
            //repeat till list is empty or we find x.
            return searchForNumber(presortedArray, x);
        }
        //if our middle element is greater than x, we then remove everything from indexOfMiddleElement till and with the end of array
        if (presortedArray.get(indexOfMiddleElement)>x){
            //i first find how many elements we want to remove
            int candidatesToRemove = presortedArray.size()-indexOfMiddleElement;
            //then i repeatedly remove from the indexOfMiddleElement until we removed as many as candidatesToRemove was.
            //i can remove from same index, because array list will adjust to the deletion and put the next number there.
            for (int i = 0; i < candidatesToRemove; i++) {
                presortedArray.remove(indexOfMiddleElement);
            }
            //repeat till list is empty or we find x.
            return searchForNumber(presortedArray, x);
        }
        return false;
    }

    public static void main(String[] args) {
        //testing the binary search algorithm
        SearchingAlgorithm searchingAlgorithm = new SearchingAlgorithm();
        int x = 3;
        System.out.println("I found "+x+": "+searchingAlgorithm.searchForNumber(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10)), x));
    }
}
