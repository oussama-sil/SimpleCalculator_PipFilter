import filters.Filter;
import filters.gui.GUI;
import filters.interpreter.Interpreter;
import filters.trace.Trace;
import pipes.Pipe;
import pipes.PipeQueue;

//! Make sure to create logs.txt before the execution 

public class MainApp{
    public static void main(String argv[]){
        
        //? Pipes
        Pipe pipe1 = new PipeQueue();  // GUI -> Interpreter
        Pipe pipe2 = new PipeQueue();  // Interpreter -> Trace 
        Pipe pipe3 = new PipeQueue();  // Trace -> GUI
        
        //? Filters 
        Filter interpreter = new Interpreter(pipe1, pipe2);
        Filter trace = new Trace(pipe2, pipe3, "logs.txt");
        Filter gui= new GUI(pipe3,pipe1);    
        interpreter.start();
        trace.start();
        gui.start();
    
    }
}