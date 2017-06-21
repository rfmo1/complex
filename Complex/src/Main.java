public class Main {
    public static void main(String[] args) {
        Comp a = new Comp(2.,0.);
        Comp b = new Comp(1.,0.);
        Comp c = new Comp(3.,0.);
        Comp[] coefs = {a, b, c};
        Function P = new Polynomial(coefs);
        System.out.println(P.evaluate(c)+ "  " + P.getDegree() + "  " + P.getType());
    }
    
}
