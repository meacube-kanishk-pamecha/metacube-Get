package Q3;
// bowler class to create the objects of the bowler
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