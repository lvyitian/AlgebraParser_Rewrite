/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algebraparser;

/**
 *
 * @author 53548
 */
public class Sub implements Operator {
    public static Sub INSTANCE=new Sub();
    @Override
    public double apply(Node... args) {
        return args[0].apply()-args[1].apply();
    }

    @Override
    public int getArgsLength() {
        return 2;
    }
    @Override
    public long priority(){return 10;}
    @Override
    public String asString() {
        return "-";
    }
    @Override
    public String toString()
    {
        return asString();
    }
}
