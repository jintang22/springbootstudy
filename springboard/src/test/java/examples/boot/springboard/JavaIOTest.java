package examples.boot.springboard;


import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class JavaIOTest {

    @Test
    public void copy() {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {

            inputStream = new FileInputStream("D:\\input.txt");

            outputStream = new FileOutputStream("D:\\output.txt");

            byte[] buffer = new byte[1024];
            int readCount = 0;

            while((readCount = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, readCount);
            }


        } catch(Exception e ) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            }
            catch(IOException e ) {
                e.printStackTrace();;
            }
            try {
                outputStream.close();
            }
            catch(IOException e ) {
                e.printStackTrace();;
            }
        }
    }

    @Test
    public void copy2() {

        // 키보드로부터 한줄씩 입력 받아, 파일에 한줄씩 저장하고
        // quir를 입력하면 프로그램은 종료된다.

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String line = null;
            while(null != ( line = bufferedReader.readLine()) ) {

                if( "quit".equals(line)) {
                    break;
                }
                System.out.println(line);
            }

            System.out.println( line );


        } catch ( Exception e) {
            e.printStackTrace();
        }

    }


}
