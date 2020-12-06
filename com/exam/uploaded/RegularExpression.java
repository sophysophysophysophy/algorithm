package exam.uploaded;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

    public static void main(String[] args) {
//        정규표현식 사용 예제 (단계별)

//        1. pattern complie
        Pattern pattern = Pattern.compile("[A-Z]+");

//        2. 검색 대상 문자열 matcher 생성
        String str = "program Programming Programmer";
        String str2 = "PROMGAM";

        Matcher matcher = pattern.matcher(str);
        Matcher matcher2 = pattern.matcher(str2);

//        3. 원하는 메소드 호출
        System.out.println(matcher.find());         //true
        System.out.println(matcher.lookingAt());    //false
        System.out.println(matcher2.matches());     //true
        System.out.println(matcher2.lookingAt());   //true


//
    }
}
