package filters;
import pipes.Pipe;

public abstract class Filter  extends Thread {

    protected Pipe pipe_in;
    protected Pipe pipe_out;

    public Filter(Pipe pipe_in,Pipe pipe_out){
        this.pipe_in = pipe_in;
        this.pipe_out = pipe_out;
    }

    protected String getData(){
        String data = this.pipe_in.read();
        return data;
    }
    
    protected void sendData(String data){
        this.pipe_out.write(data);;
    }


}