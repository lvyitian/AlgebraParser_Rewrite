/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algebraparser;

import java.util.Scanner;

/**
 *
 * @author 53548
 */
public class AlgebraParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try(Scanner input=new Scanner(System.in)){
            do{
              System.out.print(">");
              String code=input.nextLine();
              try{
              System.out.println(Lexer.lex(code));
              System.out.println(Interpreter.interpret(code));
              }catch(Throwable t){t.printStackTrace();}
            }
            while(input.hasNextLine());
        }
    }
    
}
