public class Operation{
    private Comp z1;
    private Comp z2;
    public Operation(Comp z1, Comp z2){
        this.z1 = z1;
        this.z2 = z2;
    }
    public Comp add(){
        double r;
        double i;
        r = this.z1.getReal()+this.z2.getReal();
        i = this.z1.getImaginary()+this.z2.getImaginary();
        Comp sum = new Comp(r,i);
        return sum;
    }
    public Comp subtract(){
        Operation op = new Operation(this.z1,this.z2.getSymmetric());
        return op.add();
    }
    public Comp multiply(){
        double r;
        double i;
        r = this.z1.getReal()*this.z2.getReal()-this.z1.getImaginary()*this.z2.getImaginary();
        i = this.z1.getReal()*this.z2.getImaginary()+this.z1.getImaginary()*this.z2.getReal();
        Comp product = new Comp(r,i);
        return product;
    }
    public Comp divide(){
        Operation op = new Operation(this.z1,this.z2.getInverse());
        return op.multiply();
    }
    public Comp power(){
        double arg = this.z1.getTheta();
        double sq = this.z1.getModSquared();
        double l = Math.log(sq);
        double c = this.z2.getReal();
        double d = this.z2.getImaginary();
        double P = Math.pow(sq,c/2.0)*Math.exp(-d*arg);
        double r = P*Math.cos((c*arg)+(0.5*d*l));
        double i = P*Math.sin((c*arg)+(0.5*d*l));
        Comp power = new Comp(r,i);
        return power;
    }
    public Comp root(){
        Operation op = new Operation(this.z1,this.z2.getInverse());
        return op.power();
    }
}