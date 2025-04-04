import java.util.ArrayList;

// interface stack of generic tyep t 
interface Stack<T> {
    void push(T element);

    T pop();

    T peek();

    boolean isEmpty();
}

// Implementation of the Stack of the generic type t
class StackArr<T> implements Stack<T> {
    private ArrayList<T> list = new ArrayList<>();

    /**
     * push overides the push function of stack
     * 
     * @param T element of type element T
     * @return void
     */
    @Override
    public void push(final T element) {
        this.list.add(element);
    }

    /**
     * peek return the
     */
    @Override
    public T peek() {
        // checking Stack is empty or not
        if (this.list.isEmpty())
            return null;
        return this.list.get(this.list.size() - 1);
    }

    /**
     * pop removes the top element in the stack
     * 
     * @return T the element which is at top
     */
    @Override
    public T pop() {
        // checking Stack is empty or not
        if (this.list.isEmpty())
            return null;
        return this.list.remove(this.list.size() - 1);
    }

    /**
     * isEmpty check the stack is empty or not
     */
    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
}

/**
 * Eval class that evaluates
 */
class Eval {
    /**
     * evaluate it evaluates the string and then gives the int result
     * 
     * @param String str contains numbers, operators
     * @return int num the overall calculation of the string
     */
    public int evaluate(String str) {
        Stack<String> exp = new StackArr<>();
        Stack<Integer> nums = new StackArr<>();
        char[] ch = str.toCharArray();
        int i = 0;
        // going throught the string
        while (i < ch.length) {
            // checing the character are digit or not
            if (Character.isDigit(ch[i])) {
                int num = 0;
                // going through until the full num is calculated
                while (i < ch.length && Character.isDigit(ch[i])) {
                    num = num * 10 + (ch[i] - '0');
                    i++;
                }
                // adding the num to stack
                nums.push(num);
                continue;
            }
            String curr = String.valueOf(ch[i]);

            if (i < ch.length - 1) {
                String twoChar = curr + ch[i + 1];
                // checking the operation is like == ,<= ,>= or not of two character in it.
                if (expDual(twoChar)) {
                    curr = twoChar;
                    i++;
                }
            }
            // cheking it is start of the operation
            if (curr.equals("(")) {
                exp.push(curr);
            }

            // checking it is end of the operation if yes and calculate the until the open
            // paran meets
            else if (curr.equals(")")) {
                while (!exp.isEmpty() && !exp.peek().equals("(")) {
                    int ans = calculate(nums, exp);
                    nums.push(ans);
                }
                exp.pop();
            }
            // CHECKing the operator and expresion stack is empty and the precedence of the
            // operator
            else if (opr(curr)) {
                while (!exp.isEmpty() && preference(curr) <= preference(exp.peek())) {
                    int ans = calculate(nums, exp);
                    nums.push(ans);
                }
                exp.push(curr);
            }
            i++;
        }

        // doing calculation until expression is empty
        while (!exp.isEmpty()) {
            int ans = calculate(nums, exp);
            nums.push(ans);
        }
        return nums.pop();
    }

    /**
     * opr checks the given string is operator or not
     * 
     * @param String curr current string wich we are checking
     * @return boolean it is operator or not
     */
    private boolean opr(String curr) {
        switch (curr) {
            case "||":
                return true;
            case "&&":
                return true;
            case "==":
                return true;
            case "!=":
                return true;
            case "<":
                return true;
            case ">":
                return true;
            case "<=":
                return true;
            case ">=":
                return true;
            case "+":
                return true;
            case "-":
                return true;
            case "*":
                return true;
            case "/":
                return true;
            case "^":
                return true;
            default:
                return false;
        }

    }

    /**
     * expDual checks if the given string matches with operators with two character
     * @param String curr  the string from which we have to check
     * @return boolean if it matches any one of them else false
     */
    private boolean expDual(String curr) {
        return curr.equals("==") || curr.equals("!=") ||
                curr.equals("<=") || curr.equals(">=") ||
                curr.equals("&&") || curr.equals("||");
    }

    /**
     * preference getting the preference of the operator
     * 
     * @param String op the input operator
     * @return the predence of the operator
     */
    private int preference(String op) {
        // checking the precedence of the operator
        switch (op) {
            case "||":
                return 1;
            case "&&":
                return 2;
            case "==":
                return 3;
            case "!=":
                return 3;
            case "<":
                return 4;
            case ">":
                return 4;
            case "<=":
                return 4;
            case ">=":
                return 4;
            case "+":
                return 5;
            case "-":
                return 5;
            case "*":
                return 6;
            case "/":
                return 6;
            case "^":
                return 7;
            default:
                return -1;
        }
    }

    /**
     * calculate it calculates the
     * 
     * @param Stack<Integer> nums stores the number in this stack
     * @param Stack<String>  exp stores the operator in this stack
     * @return int answer of the given string
     */
    private int calculate(Stack<Integer> nums, Stack<String> exp) {

        int a = nums.pop();
        if (nums.isEmpty())
            return a;

        int b = nums.pop();
        String oprtor = exp.pop();

        // searching for the operation to be performed
        switch (oprtor) {
            case "+":
                return b + a;
            case "-":
                return b - a;
            case "*":
                return b * a;
            case "/":
                return a == 0 ? 10020200 : b / a;
            case "^":
                return (int) Math.pow(b, a);
            case "<":
                return (b < a) ? 1 : 0;
            case ">":
                return (b > a) ? 1 : 0;
            case "<=":
                return (b <= a) ? 1 : 0;
            case ">=":
                return (b >= a) ? 1 : 0;
            case "==":
                return (b == a) ? 1 : 0;
            case "!=":
                return (b != a) ? 1 : 0;
            case "&&":
                return ((b != 0) && (a != 0)) ? 1 : 0;
            case "||":
                return ((b != 0) || (a != 0)) ? 1 : 0;
            default:
                return 0;
        }
    }
}

public class StackInterface {

    // main class
    public static void main(String[] args) {
        Eval e = new Eval();
        System.out.println(e.evaluate("5 + 10 <=  0"));

    }
}
