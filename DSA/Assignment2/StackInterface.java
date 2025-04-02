import java.util.ArrayList;

interface Stack<T> {
    void push(T element);

    T pop();

    T peek();

    boolean isEmpty();
}

class StackArr<T> implements Stack<T> {
    private ArrayList<T> list = new ArrayList<>();

    @Override
    public void push(final T element) {
        this.list.add(element);
    }

    @Override
    public T peek() {
        if (this.list.isEmpty())
            return null;
        return this.list.get(this.list.size() - 1);
    }

    @Override
    public T pop() {
        if (this.list.isEmpty())
            return null;
        return this.list.remove(this.list.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
}

class Eval {
    public int evaluate(String str) {
        Stack<String> exp = new StackArr<>();
        Stack<Integer> nums = new StackArr<>();
        char[] ch = str.toCharArray();
        int i = 0;
        while (i < ch.length) {
            if (Character.isDigit(ch[i])) {
                int num = 0;
                while (i < ch.length && Character.isDigit(ch[i])) {
                    num = num * 10 + (ch[i] - '0');
                    i++;
                }
                nums.push(num);
                continue;
            }
            String curr = String.valueOf(ch[i]);

            if (i < ch.length - 1) {
                String twoChar = curr + ch[i + 1];
                if (expDual(twoChar)) {
                    curr = twoChar;
                    i++;
                }
            }

            if (curr.equals("(")) {
                exp.push(curr);
            }

            else if (curr.equals(")")) {
                while (!exp.isEmpty() && !exp.peek().equals("(")) {
                    int ans = calculate(nums, exp);
                    nums.push(ans);
                }
                exp.pop();
            }

            else if (opr(curr)) {
                while (!exp.isEmpty() && preference(curr) <= preference(exp.peek())) {
                    int ans = calculate(nums, exp);
                    nums.push(ans);
                }
                exp.push(curr);
            }
            i++;
        }

        while (!exp.isEmpty()) {
            int ans = calculate(nums, exp);
            nums.push(ans);
        }
        return nums.pop();
    }

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

    private boolean expDual(String curr) {
        return curr.equals("==") || curr.equals("!=") ||
                curr.equals("<=") || curr.equals(">=") ||
                curr.equals("&&") || curr.equals("||");
    }

    private int preference(String op) {
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

    private int calculate(Stack<Integer> nums, Stack<String> exp) {

        int a = nums.pop();
        if (nums.isEmpty())
            return a;

        int b = nums.pop();
        String oprtor = exp.pop();

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

public class Ans {
    public static void main(String[] args) {
        System.out.println("My name is Kanishk Pamecha");
        Eval e = new Eval();
        System.out.println(e.evaluate("5 + 10 <=  0"));

    }
}
