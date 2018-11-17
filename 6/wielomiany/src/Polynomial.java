public class Polynomial {

    private double [] factors;

    Polynomial(double [] factors){
        this.factors = factors;
    }

    public double value(int x){
        double v = 0;

        for ( int i = 0 ; i < factors.length; ++i ){
            v += factors[i] * Math.pow( x , i );
        }

        return v;
    }

}