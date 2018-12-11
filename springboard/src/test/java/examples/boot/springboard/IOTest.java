package examples.boot.springboard;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class IOTest {
    public static void main(String args[]) {


        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            printWriter = new PrintWriter(new FileWriter("d:\\outputtest.txt"));


            String line = null;
            while(null != ( line = bufferedReader.readLine()) ) {

                if( "quit".equals(line)) {
                    break;
                }
                System.out.println(line);
                printWriter.println(line);
            }


        } catch ( Exception e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }
    }
}
