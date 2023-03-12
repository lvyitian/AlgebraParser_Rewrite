/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algebraparser;

/**
 *
 * @author 53548
 */
public class NullNode implements Node {
    public static final NullNode INSTANCE=new NullNode();
    @Override
    public double apply(Node... args) {
        return Double.NaN;
    }

    @Override
    public int getArgsLength() {
        return 0;
    }

    @Override
    public String asString() {
        return "NULL";
    }
    @Override
    public String toString()
    {
        return asString();
    }
}
