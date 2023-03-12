/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package algebraparser;

/**
 *
 * @author 53548
 */
public interface Separator extends Node {
    public static final Separator INSTANCE=new Separator(){@Override
    public String toString()
    {
        return asString();
    }};
    @Override
    default int getArgsLength(){return 0;}
    @Override
    default double apply(Node... args){return Double.NaN;}
    @Override
    default String asString() {
        return "Separator";
    }
}
