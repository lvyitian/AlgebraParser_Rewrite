/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algebraparser;

import java.util.Optional;

/**
 *
 * @author 53548
 */
public class Parser {

    private final String code;
    private volatile int position;

    public Parser(String code) {
        this(code, 0);
    }

    public Parser(String code, int position) {
        this.code = Optional.ofNullable(code).orElse("");
        this.position = clamp(position, 0, code.length() - 1);
    }

    public static int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        } else if (value > max) {
            return max;
        } else {
            return value;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = clamp(position, 0, code.length() - 1);
    }

    public String getCode() {
        return this.code;
    }
    public boolean hasNext()
    {
        if (position >= code.length() - 1) {
            return false;
        }
        return true;
    }
    public boolean next() {
        if (position >= code.length() - 1) {
            return false;
        }
        setPosition(position + 1);
        return true;
    }

    @SuppressWarnings("empty-statement")
    public void skipSpaces() {
        while (Character.isWhitespace(code.charAt(position)) && next());
    }

    public int nextChar() {
        if (!next()) {
            return -1;
        }
        return currentChar();
    }

    public char currentChar() {
        return code.charAt(position);
    }

    public double readDouble() {
        //System.out.println("currentPosition: "+position);
        boolean isNegative = false;
        boolean isNumStart = false;
        double base = 1;
        double res = 0;
        boolean isPointStart = false;
        int c = currentChar();
        abc:
        while (c != -1) {
            switch (c) {
                case '-':
                    if (!isNumStart) {
                        isNegative = !isNegative;
                    } else break abc;//throw new ParseException("invalid character at "+position);
                    break;
                /*case '+':
                    if (isNumStart) 
                        throw new ParseException("invalid character at "+position);
                    break;*/
                case '+':
                  if (!isNumStart)
                    throw new ParseException("invalid character at "+position);
                  else break abc;
                case '.':
                    isNumStart=true;
                    isPointStart = true;
                    base *= 0.1;
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    isNumStart=true;
                    if (isPointStart) {
                        res += base * (c - '0');
                        base *= 0.1;
                    } else {
                        res *= 10;
                        res += c - '0';
                    }
                    break;
                case ' ':
                case '_':
                    break;
                default:
                    if(isNumStart)
                        break abc;
                    else throw new ParseException("invalid character at "+position);
            }
            c = nextChar();
        }
        if(!isNumStart)
            throw new ParseException("invalid number");
        if (isNegative) res *= -1;
        return res;
    }
    public String readUntilOrEnd(char c)
    {
        StringBuilder res=new StringBuilder();
        int cur=currentChar();
        while(cur!=-1)
        {
            if(cur==c)
                break;
            res.append((char)cur);
            cur=nextChar();
        }
        return res.toString();
    }
    public static class ParseException extends RuntimeException {

        public ParseException() {
        }

        public ParseException(String msg) {
            super(msg);
        }

        public ParseException(Throwable child) {
            super(child);
        }

        public ParseException(String msg, Throwable child) {
            super(msg, child);
        }
    }
}
