/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algebraparser;

/**
 *
 * @author 53548
 */
public class Sin implements Function {
    public static final Sin INSTANCE=new Sin();
    public volatile boolean hasOp;
    @Override
    public double apply(Node... args) {
        return Math.sin(args[0].apply());
    }

    @Override
    public int getArgsLength() {
        return 1;
    }
    @Override
    public String asString() {
        return "sin";
    }
    @Override
    public String toString()
    {
        return asString();
    }
    @Override
    public boolean hasOperatorBehind() {
        return hasOp;
    }

    @Override
    public void setHasOperatorBehind(boolean b) {
        hasOp=b;
    }
}
