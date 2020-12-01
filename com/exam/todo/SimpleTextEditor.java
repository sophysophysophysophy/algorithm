package exam.todo;
//https://www.hackerrank.com/challenges/simple-text-editor/problem

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class SimpleTextEditor {

    public static void main(String[] args) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in))) {
            int iterCnt = parseInt(bufferedReader.readLine());
            System.out.println(iterCnt);
            StringBuffer nowS = new StringBuffer();
            List<String> beforeStrList = new ArrayList<>();

            while(iterCnt-- > 0) {
                StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
                int nowK = parseInt(tokenizer.nextToken());
                String nowW  = "";
                if(nowK != 4) nowW = tokenizer.nextToken();
                switch (nowK) {
                    case 1 :
                        if(nowW.length() != 0) beforeStrList.add(nowW);
                        nowS.append(nowW);
                        break;
                    case 2:
                        nowS.delete(nowS.length() - 1 - (parseInt(nowW) - 1), nowS.length());
                        if(nowS.length() != 0) beforeStrList.add(String.valueOf(nowS));
                        break;
                    case 3 :
                        System.out.println(nowS.charAt(parseInt(nowW) - 1));
                        break;
                    case 4 :
                        nowS = new StringBuffer();
                        nowS.append(beforeStrList.get(beforeStrList.size() - 1));
                        beforeStrList.remove(beforeStrList.size() - 1);
                        break;
                }
            }
        }
    }
}
