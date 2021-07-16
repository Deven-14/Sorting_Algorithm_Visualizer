package input;

public class RandomArray<T> {
    
    private RandomType<T> randomType;
    private int size;
    private final int minSize = 1;
    private final int maxSize = 20;

    public RandomArray(RandomType<T> randomType)
    {
        this.randomType = randomType;
    }
    
    public void generateRandomArray(T[] list)
    {

        try{
            
            size = list.length;

            if(size <= minSize)
                throw new SizeOutOfBounds("Length of Array is less than or equal to " + minSize);
            else if(size > maxSize)
                throw new SizeOutOfBounds("Length of Array is greater than " + maxSize);

            for(int i = 0; i < size; ++i)
                list[i] = randomType.getRandomValue();
        }
        catch(SizeOutOfBounds s)
        {
            System.out.println(s);
            list = null;
        }

    }

}
