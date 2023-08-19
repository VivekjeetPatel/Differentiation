package Differentiation;
<<<<<<< HEAD


=======
>>>>>>> dev

import java.math.BigDecimal;
import java.util.function.DoubleUnaryOperator;
import Function.Function;

public class Derivative {
    public static double derivative(DoubleUnaryOperator fx,double a)throws UnsupportedOperationException{
        if(Differentiability.deriable(fx, a)){
            double f_a = Differentiability.derivative;
            return f_a;
        }
        throw new UnsupportedOperationException("Derivative Does Not Exist");
    }

    public static void main(String[] args) {
        try {
        DoubleUnaryOperator fx = x->Function.pow(x,4);
        // DoubleUnaryOperator fx = x->(1-Function.cos(x))/Function.pow(x, 2);
        
        System.out.println("Final Derivative : "+derivative(fx, 2));
        } catch (Exception e) {
            System.out.println("caught");
            
        }
    }
    
}




