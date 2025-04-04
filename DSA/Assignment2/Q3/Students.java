package Q3;

import java.util.List;
// Student class for Storing the 
public class Students {
    private final int rank;
    private final String name;
    private final List<Programs> program;

    public Students(int rank, String name, List<Programs> program) {
        this.rank = rank;
        this.name = name;
        this.program = program;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Students [rank=" + rank + ", name=" + name + "]";
    }

    public String getName() {
        return name;
    }

    public List<Programs> getProgram() {
        return program;
    }

}
