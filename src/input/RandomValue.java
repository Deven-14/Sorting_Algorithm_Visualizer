package input;

import java.lang.Math;

public interface RandomValue<T>
{
    T getRandomValue();
}

class RandomInteger implements RandomValue<Integer>//default class
{
    public Integer getRandomValue()
    {
        Double data = Math.random() * 100;
        return data.intValue();
    }
}

class RandomFloat implements RandomValue<Float>//default class
{
    public Float getRandomValue()
    {
        Double data = Math.random() * 100;
        return data.floatValue();
    }
}

class RandomDouble implements RandomValue<Double>//default class
{
    public Double getRandomValue()
    {
        Double data = Math.random() * 100;
        return data.doubleValue();
    }
}

class RandomCharacter implements RandomValue<Character>//default class
{
    public Character getRandomValue()
    {
        Double data = Math.random() * 100;
        return (char)((int)(97 + (data % 26)));
    }
}

class RandomString implements RandomValue<String>//default class
{
    public String getRandomValue()
    {
        int n = (int)(Math.random() * 10);
        char[] str = new char[n];

        for(int i = 0; i < n; ++i)
            str[i] = (char)((int)(97 + ((Math.random() * 100) % 26)));
            
        return new String(str);
    }
}