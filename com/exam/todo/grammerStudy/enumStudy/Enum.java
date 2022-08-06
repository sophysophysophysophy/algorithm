package exam.todo.grammerStudy.enumStudy;

import org.junit.jupiter.api.Test;

//한정된 데이터들을 갖는 데이터들은 열거형으로 묶어주면 편합니다.
public class Enum {


    //        클래스 내부에서 선언도 가능
    public enum Season{
        봄, 여름, 가을, 겨울
    }


//    enum에 value 넣어 사용하기
    public enum Weeks {
    MON(0, "first"),
    TUE(1, "second");

    private final int num;
    private final String numName;

//    value가 있을 때 contructor 필수
    Weeks(int num, String numName) {
        this.num = num;
        this.numName = numName;
    }

    public String getNumName() {
        return numName;
    }
}

    @Test
    void enumTest() {
        Season season = Season.가을;

//        열거형 변수 enum을 사용할때에는 위와 같이 마치 class에서 특정값을 땡겨갈때와 똑같이 사용
        System.out.println("season = " + season);
        System.out.println("season. = " + Season.여름);

        Season favoriteSeason = Season.가을;
        System.out.println("favoriteSeason = " + favoriteSeason);
//        ordinal() :  전체 열거 객체 중 몇번째 열거 객체인지 알려줍니다. 열거 객체의 순번은 배열과 마찬가지로 인덱스가 0부터 시작합니다.
        System.out.println("favoriteSeason.ordinal() = " + favoriteSeason.ordinal());

//        name() : 열거 객체가 가지고 있는 문자열을 리턴합니다. 이때 리턴되는 문자열은 열거 타입을 정의할때 사용한 상수 이름과 동일합니다.
        System.out.println("favoriteSeason.name() = " + favoriteSeason.name());

//        values() : 모든 열거 객체들을 배열로 만들어 리턴
        for (Season value : Season.values()) {
            System.out.println("value = " + value);
        }



//        compareTo()메소드는 매개값으로 주어진 열거 객체를 기준으로 전후로 몇번째 위치하는지 비교합니다. 만약 열거 객체가 매개값의 열거 객체보다 순번이 빠르다면 음수가, 순번이 늦다면 양수가 리턴됩니다.


        Weeks first = Weeks.MON;
        Weeks mon = Weeks.valueOf("MON");

        System.out.println("first.getNumName() = " + first.getNumName());
        System.out.println("mon = " + mon.name());
    }
}
