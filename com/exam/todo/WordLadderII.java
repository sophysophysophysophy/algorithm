package exam.todo;

import java.util.*;

//https://leetcode.com/problems/word-ladder-ii/
//TODO
public class WordLadderII {

    public static void main(String[] args) {
//        System.out.println(findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
//        System.out.println(findLadders("a","c", Arrays.asList("a","b", "c")));
//        System.out.println(findLadders("hot", "dog", Arrays.asList("hot", "dog", "dot")));
//        System.out.println(findLadders("red",
//                "tax",
//                        Arrays.asList("ted","tex","red","tax","tad","den","rex","pee")));
        System.out.println(findLadders("cet",
                "ism",
        Arrays.asList("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob")));
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ArrayList<List<String>> answer = new ArrayList<>();

//        Exception Handling
        if(wordList.size() < 1) return answer;
        else if(!wordList.contains(endWord)) return answer;

        Queue<StrSet> queue = new ArrayDeque<>();
        boolean[][] flag = new boolean[wordList.size()][wordList.size() + 2];



//        Initialization
        if (beginWord.equals(endWord)) {
            answer.add(Arrays.asList(beginWord));
            return answer;
        }
        for(int i = 0 ; i < wordList.size(); i++) {
            String nowWord = wordList.get(i);
            if (checkVal(beginWord, nowWord)) {
                if (nowWord.equals(endWord)) {
                    answer.add(Arrays.asList(beginWord, nowWord));
                    return answer;
                }
                flag[i][2] = true;
                queue.add(new StrSet(nowWord, 2, Arrays.asList(beginWord, nowWord), i));
            }
        }

        boolean minValFlag = false;
        int minValCnt = 0;

        while (true) {
            if (queue.size() < 1) {
                break;
            }

            StrSet nowSet = queue.poll();
            String nowWord = nowSet.getWord();
            flag[nowSet.getIdx()][nowSet.getCircleVal()] = true;

            for (int i = 0; i < wordList.size(); i++) {
                String nextWord = wordList.get(i);
                if(!flag[i][nowSet.getCircleVal() + 1]&& checkVal(nowWord, nextWord)){
                    if (nextWord.equals(endWord)) {
                        if(!minValFlag) {
                            minValFlag = true;
                            minValCnt = nowSet.circleVal + 1;
                            List<String> nowSetList = new ArrayList<>(nowSet.getList());
                            nowSetList.add(nextWord);
                            answer.add(nowSetList);
                        } else if (minValCnt == nowSet.circleVal + 1) {
                            List<String> nowSetList = new ArrayList<>(nowSet.getList());
                            nowSetList.add(nextWord);
                            answer.add(nowSetList);
                        }
                        continue;
                    }
                    if(minValFlag && nowSet.getCircleVal() + 1 > minValCnt) {
                       continue;
                    }
                    List<String> nowList = new ArrayList<>(nowSet.getList());
                    nowList.add(nextWord);
                    queue.add(new StrSet(nextWord, nowSet.circleVal + 1, nowList, i));
                }
            }

        }

        return answer;

    }


    public static boolean checkVal(String beginWord, String nowWord) {
        char[] beginWordArray = beginWord.toCharArray(), targetWordArray = nowWord.toCharArray();

        int sameCharCnt = 0 ;
        for (int i = 0; i < beginWordArray.length; i++) {
            if (beginWordArray[i] != targetWordArray[i]) {
                sameCharCnt++;
            }
        }

        return sameCharCnt == 1;
    }

    public static class StrSet {
        private String word;
        private int circleVal;
        private List<String> list;
        private int idx;

        public StrSet(String word, int circleVal, List<String> list, int idx) {
            this.word = word;
            this.circleVal = circleVal;
            this.list = list;
            this.idx=idx;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public int getCircleVal() {
            return circleVal;
        }

        public void setCircleVal(int circleVal) {
            this.circleVal = circleVal;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }
    }
}
