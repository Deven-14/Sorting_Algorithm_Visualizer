package input;

import java.lang.Math;

public class RandomDouble implements RandomType<Double>
{
    public Double getRandomValue()
    {
        Double data = Math.random() * 100;
        return data.doubleValue();
    }
}