/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algebraparser;

/**
 *
 * @author 53548
 */
public class ExprNullNode extends NullNode {
    public volatile Expr expr;
    public ExprNullNode(Expr expr)
    {
        this.expr=expr;
    }
    @Override
    public String asString()
    {
        return "ExprNullNode{"+expr+"}";
    }
    @Override
    public String toString()
    {
        return asString();
    }
}
