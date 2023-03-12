/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algebraparser;

/**
 *
 * @author 53548
 */
public class Round implements Function {
    public static final Round INSTANCE=new Round();
    @Override
    public double apply(Node... args) {
        return Math.round(args[0].apply());
    }
    @Override
    public int getArgsLength() {
        return 1;
    }
     @Override
    public String asString() {
        return "round";
    }
    @Override
    public String toString()
    {
        return asString();
    }
}