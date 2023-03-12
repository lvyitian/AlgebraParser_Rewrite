/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algebraparser;

/**
 *
 * @author 53548
 */
public class PI implements Constant {
    public static final PI INSTANCE=new PI();
    @Override
    public double getValue(Node... args)
    {
        return Math.PI;
    }
     @Override
    public String asString() {
        return "PI";
    }
    @Override
    public String toString()
    {
        return asString();
    }
}

