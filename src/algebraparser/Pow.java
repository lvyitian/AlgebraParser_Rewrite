/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algebraparser;

/**
 *
 * @author 53548
 */
public class Pow implements Function {
    public static final Pow INSTANCE=new Pow();
    @Override
    public double apply(Node... args) {
        return Math.pow(args[0].apply(),args[1].apply());
    }

    @Override
    public int getArgsLength() {
        return 2;
    }
     @Override
    public String asString() {
        return "pow";
    }
    @Override
    public String toString()
    {
        return asString();
    }
}
