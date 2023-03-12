/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algebraparser;

/**
 *
 * @author 53548
 */
public class Clamp implements Function {
    public static final Clamp INSTANCE=new Clamp();
    @Override
    public double apply(Node... args) {
        return clamp(args[0].apply(),args[1].apply(),args[2].apply());
    }
    public static double clamp(double value, double min, double max) {
        if (value < min) {
            return min;
        } else if (value > max) {
            return max;
        } else {
            return value;
        }
    }
    @Override
    public int getArgsLength() {
        return 3;
    }
     @Override
    public String asString() {
        return "clamp";
    }
    @Override
    public String toString()
    {
        return asString();
    }
}

