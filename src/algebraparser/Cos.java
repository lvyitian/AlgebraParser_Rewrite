/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algebraparser;

/**
 *
 * @author 53548
 */
public class Cos implements Function {
    public static final Cos INSTANCE=new Cos();
    @Override
    public double apply(Node... args) {
        return Math.cos(args[0].apply());
    }

    @Override
    public int getArgsLength() {
        return 1;
    }
     @Override
    public String asString() {
        return "cos";
    }
    @Override
    public String toString()
    {
        return asString();
    }
}
