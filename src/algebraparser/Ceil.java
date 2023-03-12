/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algebraparser;

/**
 *
 * @author 53548
 */
public class Ceil implements Function {
    public static final Ceil INSTANCE=new Ceil();
    @Override
    public double apply(Node... args) {
        return Math.ceil(args[0].apply());
    }
    @Override
    public int getArgsLength() {
        return 1;
    }
     @Override
    public String asString() {
        return "ceil";
    }
    @Override
    public String toString()
    {
        return asString();
    }
}

