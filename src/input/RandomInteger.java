package input;

import java.lang.Math;

public class RandomInteger implements RandomValue<Integer>
{
    public Integer getRandomValue()
    {
        Double data = Math.random() * 100;
        return data.intValue();
    }
}