import java.util.Arrays;

public class InsertionSortData {

    public enum Type{
        Default,
        NearlyOrdered
    }
    private int[] numbers;
    public int orderedIndex = -1; //data ordered from [0, orderedIndex)
    public int currentIndex = -1;

    //Insertion Sort takes O(N^2) normally,
    //but when data is nearly ordered, the run time is closer to O(N)
    //when N is small(<16), insertion sort is faster than O(nlogn) algorithms
    //can be used to test a subset while using advanced sorting algorithms
    public InsertionSortData(int N, int randomBound, Type dataType){
        numbers = new int[N];
        for(int i = 0; i<N; i++)
            numbers[i] = (int)(Math.random()*randomBound)+1;
        if(dataType == Type.NearlyOrdered){
            Arrays.sort(numbers);
            int SwapTime = (int)(0.02*N);
            for(int i = 0; i<SwapTime; i++){
                int a = (int)(Math.random()*N);
                int b = (int)(Math.random()*N);
                swap(a,b);
            }
        }
    }

    public InsertionSortData(int N, int randomBound){
        this(N, randomBound, Type.Default); //call original ctor with default type
    }

    public int N() {return numbers.length;}

    public int get(int index){
        if(index<0 || index >= numbers.length)
            throw new IllegalArgumentException("Invalid index");
        return numbers[index];
    }

    public void swap(int i, int j){
        if(i<0 || i >= numbers.length)
            throw new IllegalArgumentException("Invalid index");
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }
}
