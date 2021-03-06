package exam.todo;

import java.util.*;

//https://leetcode.com/problems/word-ladder-ii/
public class WordLadderII {

    public static void main(String[] args) {
//        System.out.println(findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
//        System.out.println(findLadders("a","c", Arrays.asList("a","b", "c")));
//        System.out.println(findLadders("hot", "dog", Arrays.asList("hot", "dog", "dot")));
//        System.out.println(findLadders("hot", "dog", Arrays.asList("hot", "dog")));
//        System.out.println(findLadders("red",
//                "tax",
//                        Arrays.asList("ted","tex","red","tax","tad","den","rex","pee")));
        System.out.println(findLadders("leet",
                "code",
                        Arrays.asList("lest","leet","lose","code","lode","robe","lost")));
//        System.out.println(findLadders("hot",
//                "dog",
//                Arrays.asList("hot","cog","dog","tot","hog","hop","pot","dot")));
//        System.out.println(findLadders("cet",
//                "ism",
//        Arrays.asList("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob")));
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> answer = new ArrayList<>();

//        Exception Handling
        if(wordList.size() < 1) return answer;
        else if(!wordList.contains(endWord)) return answer;

        Map<Integer, List<String>> map = new HashMap<>();

        for (String str : wordList) {
            int key = checkVal(beginWord, str);
            List<String> list;
            if (map.containsKey(key)) list = map.remove(key);
            else list = new ArrayList<>();
            list.add(str);
            map.put(key, list);
        }
        if (map.containsKey(0)) {
            List<String> answerList = map.get(0);
            for (String str : answerList) {
                List<String> el = new ArrayList<>();
                el.add(str);
                answer.add(el);
            }
        }

//            1. Count from the beginWord to the lastWord
//            int cnt = checkVal(beginWord, endWord);

            List<String> startList = map.get(1);
            if(startList == null) return  new ArrayList<>();
            for (String startStr : startList) {
                List<String> list = new ArrayList<>();
                list.add(beginWord);
                list.add(startStr);
                answer.add(list);
                if(startStr.equals(endWord)) {
                    answer = new ArrayList<>();
                    answer.add(list);
                    return answer;
                }
            }

//            2. Looping keys ( 1 ~ lastWord - 1)
            int i = 2;
            int minSize = Integer.MAX_VALUE;
            while(true) {
                List<String> list = map.get(i);
                List<List<String>> newCopyAnswerList = new ArrayList<>();
                for (List<String> strings : answer) {
                    for (String s : list) {
                        if (checkVal(strings.get(strings.size() - 1), s) == 1) {
                            if(s.equals(endWord)) minSize = Math.min(minSize, strings.size());
                            ArrayList<String> copyList = new ArrayList<>(strings);
                            copyList.add(s);
                            newCopyAnswerList.add(copyList);
                        }
                    }
                }
//                    Remove losers
                answer = newCopyAnswerList;
                if(!map.containsKey(++i)) break;
            }

//            3. Step from the last ele to the endWord == 1 ? put : continue
            for (int ii = 0 ; ii < answer.size(); ii++) {
                List<String> strings = answer.get(ii);
                if(checkVal(strings.get(strings.size() - 1) , endWord) == 1) {
                    if(minSize != Integer.MAX_VALUE && strings.size() != minSize) {
                        answer.remove(ii);
                        ii--;
                        continue;
                    }
                    strings.add(endWord);
                }
            }

            return answer;
    }


    public static int checkVal(String beginWord, String nowWord) {
        char[] beginWordArray = beginWord.toCharArray(), targetWordArray = nowWord.toCharArray();

        int sameCharCnt = 0 ;
        for (int i = 0; i < beginWordArray.length; i++) {
            if (beginWordArray[i] != targetWordArray[i]) {
                sameCharCnt++;
            }
        }
        return sameCharCnt;
    }
}
