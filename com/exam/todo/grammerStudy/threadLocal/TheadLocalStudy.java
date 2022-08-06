package exam.todo.grammerStudy.threadLocal;

// ThreadLocal은 JDK 1.2부터 제공된 오래된 클래스다.
// 이 클래스를 활용하면 스레드 단위로 로컬 변수를 사용할 수 있기 때문에 마치 전역변수처럼 여러 메서드에서 활용할 수 있다.
// 다만 잘못 사용하는 경우 큰 부작용(side-effect)이 발생할 수 있기 때문에 다른 스레드와 변수가 공유되지 않도록 주의해야 한다

import exam.todo.grammerStudy.enumStudy.Number;
import org.junit.jupiter.api.Test;

import java.lang.ref.WeakReference;


public class TheadLocalStudy {

    public class ThreadLocal<T> {

        //ThreadLocalMap
        //ThreadLocalMap은 ThreadLocal 클래스의 정적 내부 클래스다.
        // 모두 private 클래스로 구성되어 있어 외부에서 접근 가능한 메서드가 없으며,
        // 내부적으로 해시 테이블 정보를 갖는데,
        // 요소는 WeakReference를 확장하고 ThreadLocal 객체를 키로 사용하는 Entry 클래스다.
        static class ThreadLocalMap {
            static class Entry extends WeakReference<ThreadLocal<?>> {
                public Entry(ThreadLocal<?> referent) {
                    super(referent);
                }
            }
        }
    }

//    Thread
//    Threa class는 ThreadLocalMap 타입 멤버 필드로 가지고 있는데,
//    이는 특정 스레드의 정보를 ThreadLocal 에서 직접 호출할 수 있도록 한다.

    //    Tread class
    public class Tread implements Runnable {
        ThreadLocal.ThreadLocalMap threadlocals = null;
        @Override
        public void run() {

        }
    }

//    ThreadLocal
//    외부에 공개되는 public 메소드 :
//          set과 get 메소드 : threadlocal에 값을 저장하는 set method, 값을 가져오는 get method
//          withInitial method : 스레드 로컬 변수를 생성하면서 특정 값으로 초기화하는 메소드. withInitial 메소드는 JDK 1.8에 추가됨
//          remove method : 스레드 로컬 변수 값을 삭제하는 메소드. JDK1.5에 추가됨. thread pool을 사용하는 환경에서는 스레드 로컬 변수 사용이 끝낫을 때 remove 명시적을 호출해야 함


    //    ThreadLocal : 외부에서 접근하지 못하도록 private keyword, 레퍼런스 재할당 불가하게 final. 스레드당 로컬 변수로  활용할 수 있도록 static keyword 등으로 선언되어 있음
//     스레드 class
    static class MadThread extends Thread {
        private static final java.lang.ThreadLocal<String> threadLocal = java.lang.ThreadLocal.withInitial(() -> "defaultName");
        private final String name;

        public MadThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.printf("%s Started, ThreadLocal: %s, withoutThread %s%n", name, threadLocal.get(), MadThreadWithoutThread.threadLocal.get());
//            threadlocal에 값(현재 스레드 이름) 저장
            threadLocal.set(name);
            MadThreadWithoutThread.threadLocal.set(Number.of(Integer.parseInt(name)));
            System.out.printf("thread %s finished, ThreadLocal: %s onlyStaticClassThreadLocal: %s%n", name, threadLocal.get(), MadThreadWithoutThread.threadLocal.get());

//            사용 종료시 필수로 비워줘야 함
            threadLocal.remove();
            MadThreadWithoutThread.threadLocal.remove();
        }
    }


    static class MadThreadWithoutThread  {
        private static final java.lang.ThreadLocal<Number> threadLocal = new java.lang.ThreadLocal<>();
        private final String name;

        public MadThreadWithoutThread(String name) {
            this.name = name;
        }
    }

    void runTest () {
        for (int threadCount = 1; threadCount <= 5; threadCount++) {
            final MadThread thread = new MadThread(threadCount+"");
            thread.start();
        }
    }

    @Test
    void threadLocalTest() {
        runTest();

    }

}
