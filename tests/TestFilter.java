package tests;

//? Simple class to test the implementation

import filters.*;
import pipes.*;

public class TestFilter extends Filter{

    private int choice = 0;

    public TestFilter(Pipe pipe_in,Pipe pipe_out,int choice){
        super(pipe_in,pipe_out);
        this.choice = choice;
    }


    //* For test
    public void run(){
        if(choice==0){ //Producer 
            String tab[] = {"10 + 10","5 + 5","5 * 5","5 - 5","3 !",""};
            for(int i=0;i<tab.length;i++){
                sendData(tab[i]);
                System.out.println("Producer "+getId()+" have written : "+tab[i]);
                try{
                    Thread.sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }  
            }
                
        }else{ //Consumer
            String str;
            while(true){
                str = getData();
                System.out.println("Consumer "+getId()+" have read : "+str);
            }
        }
    }

}
