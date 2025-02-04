public class Movie {
    private String name;
    private int duration;

    public Movie(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String toString() {
        return "{" +
                "Movie=" + name +
                ", Duration=" + duration +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
