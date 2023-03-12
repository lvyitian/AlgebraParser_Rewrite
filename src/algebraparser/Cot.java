/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algebraparser;

/**
 *
 * @author 53548
 */
public class Cot implements Function {
    public static final Cot INSTANCE=new Cot();
    @Override
    public double apply(Node... args) {
        return 1/Math.tan(args[0].apply());
    }

    @Override
    public int getArgsLength() {
        return 1;
    }
     @Override
    public String asString() {
        return "cot";
    }
    @Override
    public String toString()
    {
        return asString();
    }
}