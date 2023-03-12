/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package algebraparser;

/**
 *
 * @author 53548
 */
public interface Node {
    double apply(Node... args);
    int getArgsLength();
    String asString();
}
