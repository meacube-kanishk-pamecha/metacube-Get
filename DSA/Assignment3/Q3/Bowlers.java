package Q3;

class Bowler implements Comparable<Bowler> {
    String name;
    int balls;

    public Bowler(String name, int balls) {
        this.name = name;
        this.balls = balls;
    }

    @Override
    public int compareTo(Bowler other) {
        return other.balls - this.balls; 
    }
}