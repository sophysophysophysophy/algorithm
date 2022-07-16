package exam.todo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ToothBrushSale {
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        List<String> enrollList = Arrays.asList(enroll);
        List<String> referralList = Arrays.asList(referral);
        int[] result = new int[enroll.length];

        for (int i = 0; i < seller.length; i++) {
            String nowSeller = seller[i];
            int nowAmount = amount[i];
            result[enrollList.indexOf(nowSeller)] += (nowAmount * 100) * 0.9;

            nowAmount = (int) (( amount[i] * 100 ) * 0.1);
            while (true) {
//                next 인물 찾기
                String referralSeller = referralList.get(enrollList.indexOf(nowSeller));

                if (referralSeller.equals("-")) break;

                if (nowAmount < 10) {
                    result[enrollList.indexOf(referralSeller)] += nowAmount;
                    break;
                }

                result[enrollList.indexOf(referralSeller)] += Math.round(nowAmount * 0.9);
                nowAmount = (int) Math.round(nowAmount * 0.1);
                nowSeller = referralSeller;

            }
        }

        return result;
    }

    @Test
    void solutionTest() {
//        int[] answer = ToothBrushSale.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}
//                , new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}
//                , new String[]{"young", "john", "tod", "emily", "mary"}
//                , new int[]{12, 4, 2, 5, 10});
//        int[] result = {360, 958, 108, 0, 450, 18, 180, 1080};
//
//        for (int i = 0; i < answer.length; i++) {
//            assertEquals(result[i], answer[i]);
//        }
//
//        answer = ToothBrushSale.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}
//                , new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}
//                , new String[]{"sam", "emily", "jaimie", "edward"}
//                , new int[]{2, 3, 5, 4});
//        result = new int[] {0, 110, 378, 180, 270, 450, 0, 0};
//
//        for (int i = 0; i < answer.length; i++) {
//            assertEquals(result[i], answer[i]);
//        }

    }

}
