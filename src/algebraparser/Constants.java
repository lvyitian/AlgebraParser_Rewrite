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
public class Constants {
    public static ConcurrentMap<String,Constant> constants=new ConcurrentHashMap<>();
    static{
    constants.put("pi", PI.INSTANCE);
    constants.put("e",E.INSTANCE);
    }
}
