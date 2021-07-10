package datastructure;

import java.util.function.Consumer;

public class Sync {
    
    public Pair comparedIndices;
    public boolean transfer; //when transfer true we are sending(send()) data and when false we are receiving data
    public boolean isCompleted;

    public Sync()
    {
        comparedIndices = new Pair();
        transfer = true;
        isCompleted = false;
    }

    public synchronized void send(Pair p, Consumer<Pair> callback)
    {

        while(!transfer) //if true then while loop will fail then transfer will be set to false and we notify() i.e the receieve function which is waiting will continue
        {
            try{
                wait();
            }
            catch(InterruptedException e)
            {
                System.out.println("Interrupt caught in send()");
            }
        }
        transfer = false;

        comparedIndices.set(p);

        callback.accept(p);

        notify();
    }


    public synchronized Pair receive(Consumer<Pair> callback)
    {

        while(transfer)
        {
            try{
                wait();
            }catch(InterruptedException e)
            {
                System.out.println("Interrupt caught in receive()");
            }
        }
        transfer = true;

        callback.accept(comparedIndices);

        notify();
        return (new Pair(comparedIndices.first, comparedIndices.second));
    }

}
