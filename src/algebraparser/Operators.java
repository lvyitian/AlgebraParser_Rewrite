/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algebraparser;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 *
 * @author 53548
 */
public class Operators {
    public static ConcurrentMap<Character,Operator> operators=new ConcurrentHashMap<>();
    static{
        operators.put('+', Add.INSTANCE);
        operators.put('-',Sub.INSTANCE);
        operators.put('*', Mul.INSTANCE);
        operators.put('/',Div.INSTANCE);
        operators.put('%',Mod.INSTANCE);
    }
}
