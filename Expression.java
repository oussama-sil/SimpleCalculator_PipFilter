
import java.util.Map;

public interface Expression {
    public int interpret(Map<String, Expression> variables);
}

class Plus implements Expression {
    Expression leftOperand;
    Expression rightOperand;

    public Plus(Expression left, Expression right) {
        leftOperand = left;
        rightOperand = right;
    }

    public int interpret(Map<String, Expression> variables) {
        return leftOperand.interpret(variables) +
                rightOperand.interpret(variables);
    }
}

class Minus implements Expression {
    Expression leftOperand;
    Expression rightOperand;

    public Minus(Expression left, Expression right) {
        leftOperand = left;
        rightOperand = right;
    }

    public int interpret(Map<String, Expression> variables) {
        return leftOperand.interpret(variables) -
                rightOperand.interpret(variables);
    }
}

class Multiplication implements Expression {
    Expression leftOperand;
    Expression rightOperand;

    public Multiplication(Expression left, Expression right) {
        leftOperand = left;
        rightOperand = right;
    }

    public int interpret(Map<String, Expression> variables) {
        return leftOperand.interpret(variables) *
                rightOperand.interpret(variables);
    }
}


class Factorial implements Expression {
    Expression operand;

    public Factorial(Expression operand) {
        this.operand = operand;
    }

    public int interpret(Map<String, Expression> variables) {
        int tmp = 1;
        for(int i = 1;i<=operand.interpret(variables);i++){
            tmp = tmp * i;
        }
        return tmp;
    }
}


class Variable implements Expression {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    public int interpret(Map<String, Expression> variables) {
        if (null == variables.get(name))
            return 0;
        return variables.get(name).interpret(variables);
    }
}