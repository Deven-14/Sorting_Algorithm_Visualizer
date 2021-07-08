package datastructure;

public class Pair {
    
    public int first;
    public int second;

    public Pair() { first = second = -1; }

    public Pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }

    public void set(int first, int second)
    {
        this.first = first;
        this.second = second;
    }

    public void set(Pair p)
    {
        set(p.first, p.second);
    }

}
