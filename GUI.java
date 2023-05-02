public class GUI extends Filter {
    
    public GUI(Pipe pipe_in,Pipe pipe_out){
        super(pipe_in,pipe_out);
    }

    public void run(){

        //TODO: Put the code of the GUI here         
        
        //? What to send on the pipe_out (using sendData())
        //* To Compute an operation:
        //*     If (+ or - or *)  str= "op1 + op2"
        //*     If (!)  str = "op !"
        //* To get the list of logs  str = "" 
        //! Attention to spaces in str 
        //? What are the returned values  on the pipe_in (using getData())
        //* Case operation  : "op1 + op2 = result" or "op ! = result"
        //* Case list of logs : list of old operations seperated by ";" */


    }



}
