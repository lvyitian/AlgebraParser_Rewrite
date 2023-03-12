/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package algebraparser;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 53548
 */
public interface Number extends Expr {
    @Override
    default String asString() {
        return ""+apply();
    }

    @Override
    default int getArgsLength() {
        return 0;
    }

    @Override
    default List<Node> getChild() {
        return Arrays.asList();
    }

    static Number of(double value) {
        return new Number() {
            @Override
            public double getValue(Node... args) {
                return value;
            }
            @Override
            public String toString()
            {
                return asString();
            }
        };
    }
}
