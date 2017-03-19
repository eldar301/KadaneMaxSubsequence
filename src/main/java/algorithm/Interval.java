package algorithm;

public class Interval {
    private int start;
    private int end;
    private int weight;

    public Interval(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void copyTo(Interval to) {
        to.start = this.start;
        to.end = this.end;
        to.weight = this.weight;
    }

    public void copyFrom(Interval from) {
        from.copyTo(this);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + start;
        result = 31 * result + end;
        result = 31 * result + weight;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Interval))
            return false;
        Interval second = (Interval)obj;

        return this.weight == second.weight && this.start == second.start && this.end == second.end;
    }

    @Override
    public String toString() {
        return String.format("from %1$d to %2$d with weight %3$d", start, end, weight);
    }
}
