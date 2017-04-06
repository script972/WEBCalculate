/**
 * Created by script972 on 07.04.2017.
 */
public enum Operation {
    ADD("+"),
    MINUS("-"),
    MULT("*"),
    DIV("/");

    private String value;
    Operation(String value){
        this.value=value;
    }

    public String getValue(){
        return value;
    }
}
