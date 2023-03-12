/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algebraparser;

/**
 *
 * @author 53548
 */
public class E implements Constant {
    public static final E INSTANCE=new E();
    @Override
    public double getValue(Node... args)
    {
        return Math.E;
    }
     @Override
    public String asString() {
        return "E";
    }
    @Override
    public String toString()
    {
        return asString();
    }
}
