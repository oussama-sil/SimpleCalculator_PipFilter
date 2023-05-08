package filters.interpreter;
public class SimpleConverter  implements Converter{
    
    private static String alphabet[] = {"a","b","c","d","e","f","g"};
    
    private String expression;

    public SimpleConverter(String expression){
        this.expression = expression;
    }

    @Override
    public String toPostFix() throws Exception{
        String[] parts = expression.split(" ");
        String postFixForm = "";
        if(parts.length==2){ // case ! operand 
            postFixForm = alphabet[0]+" !";
        }else if (parts.length==3){ // other operands 
            postFixForm = alphabet[0]+" "+alphabet[1]+" "+parts[1];
        }else{
            throw new Exception("Expression <"+this.expression+"> doesn't respect onfix format", null);
        }
        return postFixForm;
    }
    

}
