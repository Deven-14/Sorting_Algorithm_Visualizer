package datastructure;

import java.util.function.Consumer;

public class Sync {
    
    public Pair comparedIndices;
    public boolean transfer; //when transfer true we are sending(send()) data and when false we are receiving data
    public boolean isCompleted;
    private boolean isReady;

    public Sync()
    {
        comparedIndices = new Pair();
        transfer = true;
        isCompleted = false;
        isReady = false;
    }

    public synchronized void send(Pair p, Consumer<Pair> callback)
    {
        // if(!isReady)
        // {
        //     try{
        //         wait();
        //     }catch(InterruptedException e)
        //     {
        //         System.out.println("Interrupt caught in send()");
        //     }
        // }

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


    public synchronized void receive(Consumer<Pair> callback)
    {
        // if(!isReady)
        // {
        //     isReady = true;
        //     notify();
        // }

        while(transfer)
        {
            try{
                wait();
                System.out.println("h1");
            }catch(InterruptedException e)
            {
                System.out.println("Interrupt caught in receive()");
            }
        }
        transfer = true;
        System.out.println("h2");

        callback.accept(comparedIndices);

        notify();
        //return (new Pair(comparedIndices.first, comparedIndices.second));
    }

}
