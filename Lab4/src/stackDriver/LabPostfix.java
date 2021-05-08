package stackDriver;
import stack.*;
import java.util.Scanner;
/**
 * Evaluate postfix expressions
 * Assume that numbers and operators are separated by one space.
 * Assume that the expressions are well-formed.
 * @author (Kyle Evangelisto)
 * @version (Feb 2021)
 */
public class LabPostfix {
    // read postfix expressions from the keyboard, and evaluate
    //not using BlueJ (intelliJ) must create a main method.
    public static void main (String ... args) {
        postfixEval();
    }

    public static void postfixEval() {
        Stack <Integer> stack = new Stack <Integer> ();
        // read expression from the keyboard
        Scanner scanner = new Scanner (System.in);
        
        String input;       // store an entire expression
        String [] opInts;   // Each string is an operator or an int.
        int right;           // store right operand
            
        System.out.println ("Enter postfix expressions, or Enter to terminate");
        input = scanner.nextLine();
        // Empty input line terminates the program
        while (input.length() > 0) {
            opInts = input.split (" "); // An array of Strings, delimiter is space
            char first;
            ////////////////  fill in the body of this loop:
            for (String s : opInts) {
                // Is the string s a number or operator?
                // If the first character in the string is a numeric digit,
                // then it must be a number.
                first = s.charAt(0);
                if(!Character.isDigit(first)) {
                    int a = stack.pop();
                    int b = stack.pop();
                    switch (s) {
                        case "+":
                            stack.push(a + b); //add
                            System.out.println(stack);
                            break;
                        case "-":
                            stack.push(a - b); //subtract
                            System.out.println(stack);
                            break;
                        case "*":
                            stack.push(a * b); //multiply
                            System.out.println(stack);
                            break;
                        case "/":
                            stack.push(a / b); //divide
                            System.out.println(stack);
                            break;
                        case "%":
                            stack.push(a % b); //mod
                            System.out.println(stack);
                            break;
                    }
                }
                else {
                    stack.push(Integer.parseInt(s));
                    System.out.println(stack);
                }

            } // reached end of an expression
            if (!stack.isEmpty()) {
                System.out.println(stack.peek());
            }
            stack.clear();
                    
            input = scanner.nextLine();
        }
    }
}
