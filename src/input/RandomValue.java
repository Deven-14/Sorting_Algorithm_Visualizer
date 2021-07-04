package input;

public interface RandomValue<T>
{
    T getRandomValue();
}

/*class ConvertDoubleToInteger implements ConvertRandomDoubleTo<Integer>//default class
{
    public Integer convert(Double data)
    {
        return data.intValue();
    }
}

class ConvertDoubleToFloat implements ConvertRandomDoubleTo<Float>//default class
{
    public Float convert(Double data)
    {
        return data.floatValue();
    }
}

class ConvertDoubleToDouble implements ConvertRandomDoubleTo<Double>//default class
{
    public Double convert(Double data)
    {
        return data.doubleValue();
    }
}

class ConvertDoubleToCharacter implements ConvertRandomDoubleTo<Character>//default class
{
    public Character convert(Double data)
    {
        return (char)((int)(97 + (data % 26)));
    }
}

class ConvertDoubleToString implements ConvertRandomDoubleTo<String>//default class
{
    public String convert(Double data)
    {
        char c1 = (char)((int)(97 + (data % 26)));
        char c2 = (char)((int)(97 + (data % 23)));
        char c3 = (char)((int)(97 + (data % 21)));
        char[] s = {c1, c2, c3};
        return new String(s);
    }
}*/