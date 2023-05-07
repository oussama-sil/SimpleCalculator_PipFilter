import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Trace extends Filter{

    private IOInterface writer_reader;

    public Trace(Pipe pipe_in,Pipe pipe_out,String fileName){
        super(pipe_in,pipe_out);
        this.writer_reader = new FileManager(fileName);
    }


    public void run(){
        while(true){
            //*Reading from the input pipe
            String in = getData();
            String out;
            if(in==""){ // Load all the logs
                out = this.writer_reader.load();
            }else{ // Save a new log 
                this.writer_reader.store(in+";");
                out = in;
            }
            //* Writing the result to the output pipe 
            sendData(out);
        }
    }


}
