package input;

import java.lang.Math;

public class RandomFloat implements RandomValue<Float>
{
    public Float getRandomValue()
    {
        Double data = Math.random() * 100;
        return data.floatValue();
    }
}
