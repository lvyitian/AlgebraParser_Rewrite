/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algebraparser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author 53548
 */
public class Lexer {
    public static Expr lex(String code) {
        List<Node> nodes = new CopyOnWriteArrayList<>();
        ConcurrentMap<Integer,Operator> ops=new ConcurrentHashMap<>();
        ConcurrentMap<Integer,Integer> codeToNodes=new ConcurrentHashMap<>();
        Parser parser = new Parser(code);
        parser.skipSpaces();
        int cur = parser.currentChar();
        String words = "";
        while (cur != -1) {
            try {
                if (words.trim().isEmpty() && cur == '(') {
                    int position = parser.getPosition();
                    int quoteCount = 1;
                    while (quoteCount > 0) {
                        int c = parser.nextChar();
                        if (c == -1) {
                            throw new RuntimeException("SyntaxError");
                        }
                        if (c == ')') {
                            quoteCount--;
                        }
                        if (c == '(') {
                            quoteCount++;
                        }
                    }
                    if (quoteCount < 0) {
                        throw new RuntimeException("SyntaxError");
                    }
                    nodes.add(lex(parser.getCode().substring(position + 1, parser.getPosition())));
                    continue;
                }
                if(!words.trim().isEmpty()&&cur=='(')
                {
                    try{
                    Function func=Functions.functions.get(words.toLowerCase(Locale.ENGLISH));
                    if(func==null)
                        throw new RuntimeException("No such function: "+words);
                    nodes.add(func);
                    }finally{words="";}
                    continue;
                }
                if (cur == ')') {
                    //System.out.println(parser.getPosition());
                    //throw new RuntimeException("SyntaxError");
                    continue;
                }
                if (cur == ',') {
                    nodes.add(Separator.INSTANCE);
                    continue;
                }
                if(cur=='_')
                    continue;
                int pos=parser.getPosition();
                try{
                    nodes.add(Number.of(parser.readDouble()));
                    if(parser.hasNext())
                      parser.setPosition(parser.getPosition()-1);
                    //System.out.println("AddedNumber: "+nodes.get(nodes.size()-1));
                    //System.out.println("AfterReadPosition: "+parser.getPosition());
                    continue;
                }catch(Parser.ParseException exc){parser.setPosition(pos);}
                
                Operator op=Operators.operators.get((char)cur);
                //System.out.println("currentChar: "+(char)cur);
                if(op!=null)
                {
                    //System.out.println("currentOperatorChar: "+cur);
                    //System.out.println("currentOperatorChar_nodes: "+nodes);
                    ops.put(parser.getPosition(),op);
                    codeToNodes.put(parser.getPosition(),nodes.size()-1);
                    continue;
                }
                if (Character.isAlphabetic(cur)) {
                    words += Character.toLowerCase((char) cur);
                    continue;
                }else{
                    if(Character.isDigit(cur))
                        continue;
                    if(Character.isWhitespace(cur))
                        continue;
                    try{
                    Constant constant=Constants.constants.get(words);
                    if(constant==null)
                        throw new RuntimeException("No such constant: "+words);
                    nodes.add(constant);
                    }finally{words="";}
                }
                throw new RuntimeException("SyntaxError");
            } finally {
                cur = parser.nextChar();
            }
        }
        for(int i=0;i<nodes.size();i++)
        {
            if(nodes.get(i) instanceof Function)
            {
                List<Node> newNodes=new ArrayList<>();
                Function func=(Function)nodes.get(i);
                newNodes.add(func);
                int[] sc={0};
                func.readArgs(nodes.subList(i+1, nodes.size()), sc);
                nodes.remove(i);
                int off=0;
                for(int tmp=0;tmp-off<sc[0];tmp++)
                {
                    if(nodes.get(i+tmp) instanceof Separator)
                    {
                        off++;
                    }
                    newNodes.add(nodes.get(i+tmp));
                    nodes.remove(i+tmp);
                    nodes.add(i+tmp,NullNode.INSTANCE);
                }
                nodes.add(i,Expr.of(newNodes));
                i+=sc[0];
            }
        }
        ops.entrySet().stream().sorted((a,b)->(int)(a.getValue().priority()-b.getValue().priority())).forEach(i->{
            int nodeIndex=codeToNodes.get(i.getKey());
            Operator op=i.getValue();
            //System.out.println("nodes: "+nodes);
            Node oprand1=nodes.get(nodeIndex);
            Node oprand2=null;
            nodes.remove(nodeIndex);
            nodes.add(nodeIndex,NullNode.INSTANCE);
            if(op.getArgsLength()>1){
              oprand2=nodes.get(nodeIndex+1);
              nodes.remove(nodeIndex+1);
              nodes.add(nodeIndex+1,NullNode.INSTANCE);
            }
            if(op.getArgsLength()>1)
                nodes.add(nodeIndex,Expr.of(Arrays.asList(new Node[]{oprand1,op,oprand2})));
            else nodes.add(nodeIndex,Expr.of(Arrays.asList(new Node[]{oprand1,op})));
        });
        for(int i=0;i+1<nodes.size();i+=2)
        {
            if(nodes.get(i) instanceof Number && nodes.get(i+1) instanceof Number)
                nodes.add(i+1, Add.INSTANCE);
        }
        return Expr.of(nodes);
    }
}
