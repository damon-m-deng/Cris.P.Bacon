public class InsertionSortData {

    private int[] numbers;
    public int orderedIndex = -1; //data ordered from [0, orderedIndex)
    public int currentIndex = -1;

    public InsertionSortData(int N, int randomBound){
        numbers = new int[N];
        for(int i = 0; i<N; i++)
            numbers[i] = (int)(Math.random()*randomBound)+1;
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
