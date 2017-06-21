public class Polynomial extends Function{
    private Comp[] coefs;
    public Polynomial (Comp[] coefs){
        super("Polynomial");
        this.coefs = coefs;
    }
    public double evaluate(Comp z){
        Comp r = new Comp(0.,0.);
        for(int i = 0; i<this.coefs.length; i++){
            Comp iz = new Comp((double) (i),0.);
            Operation op1 = new Operation(z,iz);
            Operation op2 = new Operation(this.coefs[i],op1.power());
            Operation op3 = new Operation(r,op2.multiply());
            r = op3.add();
        }
        return r;
    }
    public Function derivative(){
        Comp[] coefsd = new Comp[coefs.length];
        for(int i = 0; i<this.coefs.length; i++){
            Comp iz1 = new Comp((double) (i+1),0.);
            Operation op = new Operation(coefs[i+1],iz1);
            coefsd[i] = op.multiply();
        }
        Function d = new Polynomial(coefsd);
        return d;
    }
    public int getDegree(){
        return coefs.length-1;
    }
}