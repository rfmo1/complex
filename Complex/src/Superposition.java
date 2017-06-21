public class Superposition{
    private Basis[] B;
    private Comp[] coefs;
    public Superposition(Basis[] B, Comp[] coefs){
        if(B.length == coefs.length){
            this.B = B;
            this.coefs = coefs;
        } else {
            System.out.println("Error");
        }
    }
    public String get(){
        String s = "";
        String f = "+";
        for(int i = 0; i<B.length; i++){
            if(i+1 == B.length) f = "";
            s += "("+this.coefs[i].getLinear()+")"+this.B[i].get()+f;
        }
        return s;
    }
}