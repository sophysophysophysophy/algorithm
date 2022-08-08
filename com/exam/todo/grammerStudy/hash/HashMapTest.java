package exam.todo.grammerStudy.hash;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {

    @Test
    void hashMapTest() {

//        thread safe 보장 안됨, null허용
      HashMap<String, String> map = new HashMap<>();

//      동기화 보장. null 비허용. Dictionary 클래스 상속
        Hashtable<String, String> table = new Hashtable<>();


//        동기화 보장(thread safe). null 비허용., 메소드 전체에 synchronize block 설정
//        HashTable보다 성능 우수
        ConcurrentHashMap<String, String> cmap = new ConcurrentHashMap<>();


    }
}
