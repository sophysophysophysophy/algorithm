package exam.todo;

import lombok.Builder;

@Builder
public record obzect(String Id, String Id2) implements Comparable<obzect> {


    @Override
    public int compareTo(obzect o) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.Id, o.Id);
    }
}
