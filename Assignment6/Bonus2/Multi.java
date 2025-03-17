import java.util.*;

class Term {
    Integer coefficient;
    String variables;

    public Term(Integer coefficient, String variables) {
        this.coefficient = coefficient;
        this.variables = variables;
    }

    @Override
    public String toString() {
        return coefficient + variables;
    }
}

class MultiVariable {
    private final List<Term> terms = new ArrayList<>();

    public void addTerm(Integer coefficient, String variables) {
        terms.add(new Term(coefficient, variables));
    }

    @Override
    public String toString() {
        if (terms.isEmpty()) return "0";

        StringBuilder result = new StringBuilder();
        for (Term term : terms) {
            result.append(term).append(" + ");
        }
        return result.substring(0, result.length() - 3); 
    }
}

public class Multi {
    public static void main(String[] args) {
        MultiVariable poly = new MultiVariable();
        
        poly.addTerm(3, "x^2");  
        poly.addTerm(2, "y^3");  
        
        poly.addTerm(3, "x^2");  
        poly.addTerm(2, "y^3");  
        System.out.println(poly);
    }
}
