package exam.complete;

//https://www.hackerrank.com/challenges/java-int-to-string/problem
//TODO UPLOAD


import java.security.Permission;
import java.util.Scanner;

public class JavaInttoString {
    public static void main(String[] args) {
        String A = "df";
        String B  = "dfjs";
        System.out.println(A.length() + B.length());
        String yesOrNo = A.compareTo(B) > 0 ? "Yes" : "No";
        System.out.println(yesOrNo);
        System.out.println(A.substring(0,1).toUpperCase() + A.substring(1)+ " " + B.substring(0,1).toUpperCase() + B.substring(1));

        DoNotTerminate.forbidExit();

        try {
            Scanner in = new Scanner(System.in);
            int n = in .nextInt();
            in.close();
            String s = n+"";
            if (n == Integer.parseInt(s)) {
                System.out.println("Good job");
            } else {
                System.out.println("Wrong answer.");
            }
        } catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }
}

//The following class will prevent you from terminating the code using exit(0)!
class DoNotTerminate {

    public static class ExitTrappedException extends SecurityException {

        private static final long serialVersionUID = 1;
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}
