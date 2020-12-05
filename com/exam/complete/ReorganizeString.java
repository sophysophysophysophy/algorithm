package exam.complete;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Math.max;

//https://leetcode.com/problems/reorganize-string/
//TODO UPLOAD
public class ReorganizeString {
    public static void main(String[] args) {
        System.out.println(reorganizeString(
                "tndsewnllhrtwsvxenkscbivijfqnysamckzoyfnapuotmdexzkkrpmppttficzerdndssuveompqkemtbwbodrhwsfpbmkafpwyedpcowruntvymxtyyejqtajkcjakghtdwmuygecjncxzcxezgecrxonnszmqmecgvqqkdagvaaucewelchsmebikscciegzoiamovdojrmmwgbxeygibxxltemfgpogjkhobmhwquizuwvhfaiavsxhiknysdghcawcrphaykyashchyomklvghkyabxatmrkmrfsppfhgrwywtlxebgzmevefcqquvhvgounldxkdzndwybxhtycmlybhaaqvodntsvfhwcuhvuccwcsxelafyzushjhfyklvghpfvknprfouevsxmcuhiiiewcluehpmzrjzffnrptwbuhnyahrbzqvirvmffbxvrmynfcnupnukayjghpusewdwrbkhvjnveuiionefmnfxao"));
    }

    public static String reorganizeString(String S) {
        int maxSameAlpa = 0;

//        1. Make a Map
        char[] chars = S.toCharArray();
        char[] answerCharList = new char[chars.length];
        boolean[] checkFlagList = new boolean[chars.length];
        Map<Character, Integer> map = new HashMap<>();
        for (Character character : chars) {
            int nowCnt = 1 ;
            if(map.containsKey(character)) nowCnt = map.remove(character) + 1;
            map.put(character, nowCnt);
            maxSameAlpa = max(nowCnt, maxSameAlpa);
        }

//        2. MaxSameAlpa Check
        if(chars.length < maxSameAlpa * 2 - 1 ) return "";

//        a map sort by using stream
        List<Map.Entry<Character, Integer>> collect = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());

        Map<Character, Integer> lastMap = new HashMap<>();
        //        3. return answer
        for (Map.Entry<Character, Integer> entry : collect) {
            int totalCnt = entry.getValue();
            for (int i = 0; i < checkFlagList.length; i++) {
                if(!checkFlagList[i]) {
                    answerCharList[i] = entry.getKey();
                    checkFlagList[i++] = true;
                    totalCnt--;
                }
                if(totalCnt <= 0) break;
            }
            if(totalCnt > 0) lastMap.put(entry.getKey(), totalCnt);
        }


        for (Map.Entry<Character, Integer> entry : lastMap.entrySet()) {
            int startIdx = 0 ;
            while(true) {
                int nowCntLast = entry.getValue();
                for (int i = 0; i < checkFlagList.length; i++) {
                    if (!checkFlagList[i]) {
//                        Swapping
                        answerCharList[i] = answerCharList[startIdx];
                        answerCharList[startIdx] = entry.getKey();
                        if (checkValid(answerCharList)) {
                            nowCntLast--;
                            checkFlagList[i] = true;
                        } else answerCharList[startIdx] = answerCharList[i];
                        startIdx++;
                    }
                }
                if(nowCntLast <= 0) break;
            }
        }

//      Char array to String
        return new String(answerCharList);
    }

    private static boolean checkValid(char[] chars) {
        for (int i = 0; i < chars.length - 1; i++) if(chars[i] == chars[i+1]) return false;
        return true;
    }

//    public static String reorganizeString(String S) {
//
//        char[] chars = S.toCharArray();
//        boolean[] makeCharArray ;
//
//        Set<String> list = new HashSet<>();
//
//        for (int i = 0; i < chars.length; i++) {
//            makeCharArray = new boolean[chars.length];
//            String nowStr = String.valueOf(chars[i]);
//            makeCharArray[i] = true;
//            String answer  = recursivelyMakeList(list, chars, makeCharArray, i, nowStr);
//            if(!answer.equals("")) {
//                return answer;
//            }
//        }
//
//
////        Optional : java8
//        Optional<String> answer = list.stream().filter(ReorganizeString::checkValid).findFirst();
//        return answer.orElse("");
//    }
//

//
//
//    private static String recursivelyMakeList(Set<String> list, char[] chars, boolean[] makeCharArray, int i, String nowStr) {
//        if(nowStr.length() == chars.length) {
//            boolean flag = false;
//            if(!list.contains(nowStr)) flag = checkValid(nowStr);
//            if(flag) return nowStr;
//
//        }
//        else {
//            for (int j = 0; j < chars.length; j++) {
//                if(!makeCharArray[j]) {
//                    makeCharArray[j] = true;
//                    recursivelyMakeList(list, chars, makeCharArray, j, nowStr + chars[j]);
//                    makeCharArray[j] = false;
//                }
//            }
//        }
//
//        return "";
//    }
}
