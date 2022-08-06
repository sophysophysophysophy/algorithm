package exam.todo.grammerStudy.enumStudy;

import java.util.Arrays;

public enum Number {

    일(1) , 이(2) , 삼(3) , 사(4) ,오(5);

    private final int number;

    Number(int i) {
        this.number = i;
    }

    public int getNumber() {
        return number;
    }

    public static Number of(int number) {
        return Arrays.stream(values())
                .filter(v -> v.number == number)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }




}
