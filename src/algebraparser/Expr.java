/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algebraparser;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 53548
 */
public interface Expr extends Node {
    @Override
    default int getArgsLength(){return 0;}
    @Override
    default double apply(Node... args){return getValue(args);}
    default double getValue(Node... args){
        boolean firstNumberOccurred=false;
        double lastNumber=0;
        long skipCount=0;
        boolean twoOprandsOperator=false;
        Node lastNode=null;
        Operator lastOperator=null;
        int iteratorIndex=0;
        List<Node> child=getChild();
        for(Node i : child)
        {
            if(skipCount>0)
            {
                iteratorIndex++;
                skipCount--;
                continue;
            }
            if(i instanceof NullNode)
            {
                iteratorIndex++;
                continue;
            }
            if(i instanceof Number)
            {
                if(twoOprandsOperator){
                twoOprandsOperator=false;
                lastNumber=lastOperator.apply(Number.of(lastNumber),i);
                firstNumberOccurred=true;
                }else if(!firstNumberOccurred){ firstNumberOccurred=true;lastNumber=i.apply();}else throw new RuntimeException("SyntaxError");
            }else if(i instanceof Function)
            {
                if(firstNumberOccurred)
                {
                   if(twoOprandsOperator){
                      twoOprandsOperator=false;
                      int[] s={0};
                      lastNumber=lastOperator.apply(Number.of(lastNumber),Number.of(i.apply(((Function)i).readArgs(child.subList(iteratorIndex+1,child.size()),s))));
                      skipCount=s[0];
                   }else throw new RuntimeException("SyntaxError");
                }else{
                    firstNumberOccurred=true;
                    int[] s={0};
                    lastNumber=i.apply(((Function)i).readArgs(child.subList(iteratorIndex+1,child.size()),s));
                    skipCount=s[0];
                }
            }else if(i instanceof Operator)
            {
                if(!firstNumberOccurred)
                    throw new RuntimeException("SyntaxError");
                lastOperator=(Operator)i;
                if(twoOprandsOperator)
                    throw new RuntimeException("SyntaxError");
                int arglen=i.getArgsLength();
                switch(arglen)
                {
                    case 1:
                        lastNumber=i.apply(Number.of(lastNumber));
                        break;
                    case 2:
                        twoOprandsOperator=true;
                        break;
                    default:
                        throw new RuntimeException("args length of operator is either 1 or 2 but get: "+arglen);
                }
            }else if(i instanceof Expr)
            {
                if(twoOprandsOperator){
                twoOprandsOperator=false;
                lastNumber=lastOperator.apply(Number.of(lastNumber),i);
                firstNumberOccurred=true;
                }else{ 
                if(firstNumberOccurred)
                    throw new RuntimeException("SyntaxError");
                firstNumberOccurred=true;
                lastNumber=i.apply();
                }
            }else throw new RuntimeException("SyntaxError");
            iteratorIndex++;
            lastNode=i;
        }
        return lastNumber;
    }
    List<Node> getChild();
    public static Expr of(List<Node> nodes)
    {
        //return () -> nodes;
        return new Expr(){
        @Override
        public String toString()
        {
            return asString();
        }
        @Override
        public List<Node> getChild(){return nodes;}
        };
    }
    @Override
    default String asString()
    {
        return this.getClass().getName()+Arrays.toString(getChild().parallelStream().toArray(Node[]::new));
    }
}
