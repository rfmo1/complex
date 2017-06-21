public class Basis{
    private char sign;
    public Basis(char sign){
        this.sign = sign;
    }
    public String get(){
        String s = "|"+sign+">";
        return s;
    }
    public char getChar(){
        return this.sign;
    }
}