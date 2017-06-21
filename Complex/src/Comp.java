public class Comp{
    private double r;
    private double i;
    private double rad;
    private double theta;
    public Comp(double r,double i){
        this.r = r;
        this.i = i;
        this.theta = Math.atan(i/r);
        this.rad = Math.pow(Math.pow(r,2)+Math.pow(i,2),0.5);
    }
    public String getLinear(){
        String s = this.r+"+"+this.i+"i";
        return s;
    }
    public double getReal(){
        double real = this.r;
        return real;
    }
    public double getImaginary(){
        double imaginary = this.i;
        return imaginary;
    }
    public double getRadius(){
        double rad = this.rad;
        return rad;
    }
    public double getTheta(){
        double theta = this.theta;
        return theta;
    }
    public String getPolar(){
        double rad = this.rad;
        double theta = this.theta;
        String res = rad+"[cos("+theta+")+isin("+theta+")]";
        return res;
    }
    public Comp getSymmetric(){
        Comp z = new Comp(-this.r,-this.i);
        return z;
    }
    public Comp getInverse(){
        double r;
        double i;
        double sq = Math.pow(this.r,2)+Math.pow(this.i,2);
        r = this.r/sq;
        i = -this.i/sq;
        Comp z = new Comp(r,i);
        return z;
    }
    public Comp getConjugate(){
        Comp z = new Comp(this.r,-this.i);
        return z;
    }
    public double getModSquared(){
        double R = Math.pow(this.r,2)+Math.pow(this.i,2);
        return R;
    }
    public double getMod(){
        double ro = Math.pow(this.getModSquared(),0.5);
        return ro;
    }
    public boolean isGaussian(){
        if((this.r % 1. == 0.)&&(this.i % 1. == 0.)){
            return true;
        } else {
            return false;
        }
    }
    public boolean isEqualTo(Comp z){
        if(this.r == z.getReal() && this.i == z.getImaginary()) return true;
        return false;
    }
    public boolean isReal(){
        if(this.i == 0.) return true;
        return false;
    }
    public boolean isImaginary(){
        if(this.r == 0.) return true;
        return false;
    }
    public boolean isDivisibleBy(Comp z){
        Operation op = new Operation(this, z);
        Comp n = op.divide();
        if(n.isGaussian()) return true;
        return false;
    }
    public boolean isGaussianPrime(){
        if(!this.isGaussian()) return false;
        Comp half = new Comp(0.5,0.);
        Operation op = new Operation(this,half);
        Comp limit = op.power();
        int limit_x = (int) limit.getReal();
        int limit_y = (int) limit.getImaginary();
        Comp[][] Space = new Comp[2*(limit_x)+1][2*(limit_y)+1];
        for(int x = 0; x <= 2*limit_x; x++){
            for(int y = 0; y <= 2*limit_y; y++){
                int xr;
                int yr;
                if(x<=limit_x){
                    xr = x-limit_x;
                } else {
                    xr = x;
                }
                if(y<=limit_y){
                    yr = y-limit_y;
                } else {
                    yr = y;
                }
                Comp p = new Comp(xr,yr);
                Space[x][y] = p;
            }
        }
        for(int x = 0; x<=2*limit_x ;x++){
            for(int y = 0; y<=2*limit_y ;y++){
                Comp e1 = new Comp(0,0);
                Comp e2 = new Comp(1,0);
                Comp e3 = new Comp(0,1);
                Comp e4 = new Comp(-1,0);
                Comp e5 = new Comp(0,-1);
                Comp t = Space[x][y];
                if(t.isEqualTo(e1)||t.isEqualTo(e2)||t.isEqualTo(e3)||t.isEqualTo(e4)||t.isEqualTo(e5)) {
                    if(this.isEqualTo(t)) return false;
                }
                if(this.isDivisibleBy(t)&&!this.isEqualTo(t)) return false;
            }
        }
        return true;
        
    }
    public void rotate(double th){
        Comp M = new Comp(Math.cos(Math.toRadians(th)), Math.sin(Math.toRadians(th)));
        Operation op = new Operation(this, M);
        Comp nw = op.multiply();
        this.r = nw.getReal();
        this.i = nw.getImaginary();
    }
}