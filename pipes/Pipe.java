package pipes;

public abstract class Pipe  {

    //* To write on the Pipe
    abstract public  void write(String data);
    
    //* To read from the Pipe
    abstract public  String read();
}