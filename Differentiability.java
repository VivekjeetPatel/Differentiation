package Calculus;

import java.math.BigDecimal;
import java.util.function.DoubleUnaryOperator;

import Function.Function;


public class Differentiability {
    public static double derivative;
    public static boolean deriable(DoubleUnaryOperator fx,double a){
        boolean continuous = false;
        try {
            continuous = Continuity.continuous(fx, a);
        } catch (Exception e) {
            // TODO: handle exception
        }
        boolean lhd_rhd = false ;
        boolean lhd_rhd_finite = false ;
       
        try {
        BigDecimal delta = new BigDecimal(Function.pow(10, -10));
        DoubleUnaryOperator f = x->(fx.applyAsDouble(x)-fx.applyAsDouble(a))/(x-a);
        double l = a-delta.doubleValue();
        BigDecimal LHD = Limit.limitvalue(f, l);

        double r = a+delta.doubleValue();
        BigDecimal RHD = Limit.limitvalue(f, r);

        double LHD_RHD = LHD.doubleValue()-RHD.doubleValue();
        if(LHD_RHD<0.00001||LHD_RHD<-0.00001){
            derivative = (LHD.doubleValue()+RHD.doubleValue())/2;
            lhd_rhd = true;
            lhd_rhd_finite = true;

        }else{
            lhd_rhd = false;
            lhd_rhd_finite = false;
            
        }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("rr");
        }

        boolean derivable = continuous&lhd_rhd&lhd_rhd_finite;
        return derivable;



    }
    
}
