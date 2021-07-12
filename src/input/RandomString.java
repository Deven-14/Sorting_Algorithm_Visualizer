package input;

import java.lang.Math;

public class RandomString implements RandomType<String>
{
    public String getRandomValue()
    {
        int n = 3;//(int)(Math.random() * 10);
        char[] str = new char[n];//n=3 only 3 char string

        for(int i = 0; i < n; ++i)
            str[i] = (char)((97 + (int)((Math.random() * 100) % 26)));
            
        return new String(str);
    }
}