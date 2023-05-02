
import java.util.LinkedList;
import java.util.Queue;

public class PipeQueue  extends Pipe{

    //* To store the elements of the Queue Pipe on a queue
    private Queue<String> queue = new LinkedList<String>();

    //* To write on the Pipe
    public synchronized void write(String data){
        // System.out.println("Writing to the Pip");
        queue.add(data);
        notify(); //* Notifying threads waiting on the pip 
    }
    
    //* To read from the Pipe
    public synchronized String read(){
        while (queue.size()==0) {
            try { 
                // System.out.println("Nothing to read , waiting");
                wait(); //* Waiting till notify is called 
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        // System.out.println("Reading from the Pip");
        return queue.remove();
    }
}
