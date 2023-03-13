/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algebraparser;

/**
 *
 * @author 53548
 */
public class Fac implements Function {
    public static final Fac INSTANCE=new Fac();
    public volatile boolean hasOp;
    @Override
    public double apply(Node... args) {
        return factorial((long)args[0].apply());
    }
    public static long factorial(long n)
    {
        long res=1;
        for(long i=2;i<=n;i++) res*=i;
        return res;
    }
    @Override
    public int getArgsLength() {
        return 1;
    }
     @Override
    public String asString() {
        return "fac";
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
