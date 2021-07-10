package input;

import java.lang.Math;

public class RandomString implements RandomType<String>
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