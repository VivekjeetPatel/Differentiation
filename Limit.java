
package Differentiation;
import java.math.BigDecimal;
import java.util.function.DoubleUnaryOperator;

import javax.naming.OperationNotSupportedException;

import Function.Function;

public class Limit {
    private static final BigDecimal DELTA = new BigDecimal(Function.pow(10, -10));

    public static double limitvalue(DoubleUnaryOperator fx, double a) throws OperationNotSupportedException {
       try {
        BigDecimal LHL = new BigDecimal(fx.applyAsDouble(a - DELTA.doubleValue()));
        System.out.println("LHL : "+LHL);
        
        BigDecimal RHL = new BigDecimal(fx.applyAsDouble(a + DELTA.doubleValue()));
        System.out.println("RHL : "+RHL);
       
        BigDecimal delrhl_lhl = RHL.subtract(LHL);

<<<<<<< HEAD
        if (delrhl_lhl.doubleValue()<0.001||delrhl_lhl.doubleValue()<-0.001) {
            double limit = LHL.add(RHL).divide(BigDecimal.valueOf(2)).doubleValue();
            
            System.out.println("Limit : "+limit);
=======
        if ((delrhl_lhl.doubleValue()<0.0001&delrhl_lhl.doubleValue()>0.0)||(delrhl_lhl.doubleValue()>-0.0001)&delrhl_lhl.doubleValue() <0.0) {
            BigDecimal limit = LHL.add(RHL).divide(BigDecimal.valueOf(2));
            System.out.println("Limit : "+limit.doubleValue());
            System.out.println("No Error in Limit class");
            System.out.println();
>>>>>>> dev
            return limit;
                
        }
       } catch (Exception e) {
        System.out.println(e);
<<<<<<< HEAD
        
        System.out.println("**");
=======
        System.out.println("Exception in Limit class");
>>>>>>> dev
       }
    throw new OperationNotSupportedException("Limit Does not exist");
    }

    public static void main(String[] args)  {
        // DoubleUnaryOperator fx = x -> Function.sin(x) / x;
        // DoubleUnaryOperator fx = x -> (1 - Function.cos(x)) / (x * x);
        // DoubleUnaryOperator fx = x->Function.cube(x)*Function.sqr(x);
<<<<<<< HEAD
        DoubleUnaryOperator fx = x->1/x;
=======
        // DoubleUnaryOperator fx = x->1/x;
        DoubleUnaryOperator fx = x->Function.pow(x,2);
        // DoubleUnaryOperator fx = x->x;
>>>>>>> dev

        double a = 2;
       try {
<<<<<<< HEAD
        double l = limitvalue(fx, a);
=======
        BigDecimal l = limitvalue(fx, a);
>>>>>>> dev
        System.out.println(l);
       } catch (Exception e) {
        System.out.println(e.getMessage());
       }
       
    }
}
