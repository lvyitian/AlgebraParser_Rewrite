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
public class Functions {
    public static ConcurrentMap<String,Function> functions=new ConcurrentHashMap<>();
    static{
      functions.put("acos", Acos.INSTANCE);
      functions.put("acot", Acot.INSTANCE);
      functions.put("acsc",Acsc.INSTANCE);
      functions.put("asec",Asec.INSTANCE);
      functions.put("asin",Asin.INSTANCE);
      functions.put("atan",Atan.INSTANCE);
      functions.put("clamp",Clamp.INSTANCE);
      functions.put("cos",Cos.INSTANCE);
      functions.put("cot",Cot.INSTANCE);
      functions.put("csc",Csc.INSTANCE);
      functions.put("fac",Fac.INSTANCE);
      functions.put("max",Max.INSTANCE);
      functions.put("min",Min.INSTANCE);
      //functions.put("mod",Mod.INSTANCE);
      functions.put("pow",Pow.INSTANCE);
      functions.put("sec",Sec.INSTANCE);
      functions.put("sin",Sin.INSTANCE);
      functions.put("tan",Tan.INSTANCE);
      functions.put("toint",ToInt.INSTANCE);
      functions.put("floor", Floor.INSTANCE);
      functions.put("round",Round.INSTANCE);
      functions.put("ceil",Ceil.INSTANCE);
    }
}
