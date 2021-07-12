package input;

import java.lang.Math;

public class RandomCharacter implements RandomType<Character>
{
    public Character getRandomValue()
    {
        Double data = Math.random() * 100;
        return (char)((97 + (int)(data % 26)));
    }
}
