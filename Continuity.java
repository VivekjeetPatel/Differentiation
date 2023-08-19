package Differentiation;

import java.math.BigDecimal;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;
import javax.naming.OperationNotSupportedException;
import Function.Function;


public class Continuity { 
    public static boolean continuous(DoubleUnaryOperator fx,double a) {
        boolean continous = false;
        
        try {
        BigDecimal limit = Limit.limitvalue(fx, a);
        System.out.println("Limit : "+limit);
        BigDecimal fa = new BigDecimal(fx.applyAsDouble(a));
        System.out.println("fa : "+fa);
        BigDecimal dellimitvalue_fa = fa.subtract(limit);
        System.out.println("dellimitvalue_fa : "+dellimitvalue_fa);
        if((dellimitvalue_fa.doubleValue()<=0.0001&dellimitvalue_fa.doubleValue()>=0.0)||(dellimitvalue_fa.doubleValue()>=-0.0001&dellimitvalue_fa.doubleValue()<=0.0)){
            continous = true;
            System.out.println("Continuous : "+continous);
            System.out.println("No Exception in the Continuity class");
            System.out.println();
            return continous;
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
           System.out.println("Exception in continuous");
        }
        return continous;

    } 
    public static void main(String[] args)  {
        // DoubleUnaryOperator fx = x -> Function.sin(x) / x;
        // DoubleUnaryOperator fx = x -> (1 - Function.cos(x)) / (x * x);
        // DoubleUnaryOperator fx = x->Function.cube(x)*Function.sqr(x);
        // DoubleUnaryOperator fx = x->1/x;
        DoubleUnaryOperator fx = x->Function.pow(x,2);
        // DoubleUnaryOperator fx = x->x;

        double a = 2;
       try {
        boolean c = continuous(fx, a);
        System.out.println(c);
       } catch (Exception e) {
        System.out.println(e.getMessage());
       }
       
    }
    
   
    
}
