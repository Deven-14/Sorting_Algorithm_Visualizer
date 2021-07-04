package input;

import java.lang.Math;

public class RandomDouble implements RandomValue<Double>
{
    public Double getRandomValue()
    {
        Double data = Math.random() * 100;
        return data.doubleValue();
    }
}