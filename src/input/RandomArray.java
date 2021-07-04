package input;

public class RandomArray<T> {
    
    private RandomValue<T> randomValue;
    private int size;
    private final int minSize = 0;
    private final int maxSize = 20;

    RandomArray(RandomValue<T> randomValue)
    {
        this.randomValue = randomValue;
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
                list[i] = randomValue.getRandomValue();
        }
        catch(SizeOutOfBounds s)
        {
            System.out.println(s);
            list = null;
        }

    }
    
    /*public static void main(String[] args)
    {
        Integer[] i = new Integer[20];
        RandomArray<Integer> n1 = new RandomArray<Integer>(new ConvertDoubleToInteger());
        n1.generateRandomArray(i);
        for(Integer n2 : i)
            System.out.print(n2 +", ");
        System.out.println();

        Character[] c = new Character[20];
        RandomArray<Character> n3 = new RandomArray<Character>(new ConvertDoubleToCharacter());
        n3.generateRandomArray(c);
        for(Character n4 : c)
            System.out.print(n4 +", ");
        System.out.println();

        String[] s = new String[20];
        RandomArray<String> n5 = new RandomArray<String>(new ConvertDoubleToString());
        n5.generateRandomArray(s);
        for(String n6 : s)
            System.out.print(n6 +", ");
        System.out.println();
    }*/

}
