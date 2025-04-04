package Q3;

public class Programs {

    String course;
    int seats;

    public Programs(String course, int seats) {
        this.course = course;
        this.seats = seats;
    }

    public String getCourse() {
        return course;
    }

    public int getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return "Programs [course=" + course + ", seats=" + seats + "]";
    }

}
