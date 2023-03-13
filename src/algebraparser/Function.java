/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package algebraparser;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 53548
 */
public interface Function extends Node {
    public static final Function EMPTY_TWO_OPERAND_OPERATOR=new Function(){@Override public int getArgsLength(){return 2;}@Override public double apply(Node... args){return Double.NaN;} 
    @Override
    public boolean hasOperatorBehind()
    {
        throw new UnsupportedOperationException();
    }
    @Override
    public void setHasOperatorBehind(boolean b)
    {
        throw new UnsupportedOperationException();
    }
    @Override
    public String asString() {
        return "EMPTY_TWO_OPERAND_OPERATOR";
    }
    @Override
    public String toString()
    {
        return asString();
    }};
    public static final Function EMPTY_SINGLE_OPERAND_OPERATOR=new Function(){@Override public int getArgsLength(){return 2;}@Override public double apply(Node... args){return Double.NaN;} 
    @Override
    public boolean hasOperatorBehind()
    {
        throw new UnsupportedOperationException();
    }
    @Override
    public void setHasOperatorBehind(boolean b)
    {
        throw new UnsupportedOperationException();
    }
    @Override
    public String asString() {
        return "EMPTY_SINGLE_OPERAND_OPERATOR";
    }
    @Override
    public String toString()
    {
        return asString();
    }};
    boolean hasOperatorBehind();
    void setHasOperatorBehind(boolean b);
    default Node[] readArgs(List<Node> ori, int[] skipCount) {
        List<Node> res = new ArrayList<>();
        for (int t = 0; t < getArgsLength(); t++) {
            List<Node> nodes = new ArrayList<>();
            for (int i = 0; i < ori.size(); i++) {
                Node cur = ori.get(i);
                skipCount[0]++;
                if (cur instanceof Separator) {
                    break;
                }
                nodes.add(cur);
            }
            res.add(Expr.of(nodes));
        }
        return res.parallelStream().toArray(Node[]::new);
    }
}
