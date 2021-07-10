package input;

import java.lang.Math;

public class RandomInteger implements RandomType<Integer>
{
    public Integer getRandomValue()
    {
        Double data = Math.random() * 100;
        return data.intValue();
    }
}
