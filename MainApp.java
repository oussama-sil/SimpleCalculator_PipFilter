import java.util.Scanner;

//! Make sure to create logs.txt 

public class MainApp{
    public static void main(String argv[]){
        
        //* Main function
        // Pipe pipe1 = new PipeQueue();
        // Pipe pipe2 = new PipeQueue();
        // Pipe pipe3 = new PipeQueue();
        

        // Filter gui = new GUI(pipe3,pipe1);
        // gui.start();

        // Filter interpreter = new Interpreter(pipe1, pipe2);
        // interpreter.start();

        // Filter trace = new Trace(pipe2, pipe3, "logs.txt");
        // trace.start();



        //* For testing 
        //* producer  -> Interpreter -> Trace -> Consumer 
        //* Check TestFilter 

        Pipe pipe1 = new PipeQueue();
        Pipe pipe2 = new PipeQueue();
        Pipe pipe3 = new PipeQueue();
        

        //Filter prod = new TestFilter(null,pipe1,0);
        //prod.start();

        Filter interpreter = new Interpreter(pipe1, pipe2);
        interpreter.start();

        Filter trace = new Trace(pipe2, pipe3, "logs.txt");
        trace.start();
         
        Filter gui= new GUI(pipe3,pipe1);
        gui.start();
        
        //Filter cons1 = new TestFilter(pipe3,null,1);
        //cons1.start();


    }
}