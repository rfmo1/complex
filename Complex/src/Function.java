public class Function{
    private String type;
    public Function(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public Comp evaluate(Comp x);
    public Function derivative();
}