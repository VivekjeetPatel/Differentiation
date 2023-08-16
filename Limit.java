
package Calculus;
import java.math.BigDecimal;
import java.util.function.DoubleUnaryOperator;

import javax.naming.OperationNotSupportedException;

import Function.Function;

public class Limit {
    private static final BigDecimal DELTA = new BigDecimal(Function.pow(10, -10));

    public static BigDecimal limitvalue(DoubleUnaryOperator fx, double a) throws OperationNotSupportedException {
       try {
        BigDecimal LHL = new BigDecimal(fx.applyAsDouble(a - DELTA.doubleValue()));
        System.out.println("LHL : "+LHL);
        
        BigDecimal RHL = new BigDecimal(fx.applyAsDouble(a + DELTA.doubleValue()));
        System.out.println("RHL : "+RHL);
       
        BigDecimal delrhl_lhl = RHL.subtract(LHL);

        if (delrhl_lhl.doubleValue()<0.001||delrhl_lhl.doubleValue()<-0.001) {
            BigDecimal limit = LHL.add(RHL).divide(BigDecimal.valueOf(2));
            System.out.println("*");
            return limit;
            
            
        }
       } catch (Exception e) {
        System.out.println(e);
        System.out.println("ex");
        System.out.println("**");
       }
    throw new OperationNotSupportedException("Limit Does not exist");
    }

    public static void main(String[] args)  {
        // DoubleUnaryOperator fx = x -> Function.sin(x) / x;
        // DoubleUnaryOperator fx = x -> (1 - Function.cos(x)) / (x * x);
        // DoubleUnaryOperator fx = x->Function.cube(x)*Function.sqr(x);
        DoubleUnaryOperator fx = x->x;

        double a = 0;
       try {
         BigDecimal l = limitvalue(fx, a);
        System.out.println(l);
       } catch (Exception e) {
        System.out.println(e);
       }
       
    }
}