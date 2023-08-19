package Differentiation;

import java.math.BigDecimal;
import java.util.function.DoubleUnaryOperator;

import Function.Function;


public class Differentiability {
    public static double derivative;
    public static boolean deriable(DoubleUnaryOperator fx,double a){
        boolean continuous = false;
        try {
            continuous = Continuity.continuous(fx, a);
            System.out.println("c " + continuous);
        } catch (Exception e) {
            // TODO: handle exception
        }
        boolean lhd_rhd = false ;
        boolean lhd_rhd_finite = false ;
       
        try {
        BigDecimal delta = new BigDecimal(Function.pow(10, -7));
        DoubleUnaryOperator f = x->(fx.applyAsDouble(x)-fx.applyAsDouble(a))/(x-a);
        double l = a-delta.doubleValue();
        BigDecimal LHD = Limit.limitvalue(f, l);

        double r = a+delta.doubleValue();
        BigDecimal RHD = Limit.limitvalue(f, r);

        double LHD_RHD = LHD.doubleValue()-RHD.doubleValue();
        if((LHD_RHD<0.0001&LHD_RHD>0.0)||(LHD_RHD>-0.0001&LHD_RHD<0.0)){
            derivative = (LHD.doubleValue()+RHD.doubleValue())/2;
            lhd_rhd = true;
            lhd_rhd_finite = true;

        }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Exception in Differentiablilty class ");
        }

        boolean derivable = continuous&lhd_rhd&lhd_rhd_finite;
        return derivable;
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
        boolean l = deriable(fx, a);
        System.out.println(l);
       } catch (Exception e) {
        System.out.println(e.getMessage());
       }
       
    }
    
}
