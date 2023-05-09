package filters.interpreter;

import java.util.HashMap;
import java.util.Map;

import filters.Filter;
import pipes.Pipe;

public class Interpreter extends Filter{
    private static String alphabet[] = {"a","b","c","d","e","f","g"};

    public Interpreter(Pipe pipe_in,Pipe pipe_out){
        super(pipe_in,pipe_out);
    }

    public void run(){
        while(true){
            String out = "";
            //* Reading from the pip the expression to compute 
            String expression = this.getData();
            if(expression.length()>0){
                try{
                    //* Conversion to postFix format
                    Converter converter = new SimpleConverter(expression);
                    String postFixForm = converter.toPostFix();
                    
                    //* Initializing the context
                    Map<String, Expression> variables = new HashMap<String, Expression>();
                    String[] parts = expression.split(" ");
                    if(parts.length==2){ // case ! operator 
                        variables.put(alphabet[0], new Number(Integer.valueOf(parts[0])));
                    }else if (parts.length==3){ // other operators 
                        variables.put(alphabet[0], new Number(Integer.valueOf(parts[0])));
                        variables.put(alphabet[1], new Number(Integer.valueOf(parts[2])));

                    }
                    //* Evaluating the expression
                    Evaluator exp = new Evaluator(postFixForm);
                    int result = exp.interpret(variables);
                    out = expression + " = "+Integer.toString(result);
                }catch(Exception e){
                    out = expression + " = 0";
                    e.printStackTrace();
                }
            }
    
            //* Writing to the output pipe
            sendData(out);
        }

    }

}
