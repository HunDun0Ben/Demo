package java8;

import java.io.*;

public class TryWithResource {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:/tmp/tmpfile.txt");
        try ( // fis 和 bfis 实践上的流的引用使用是同一个。
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bfis = new BufferedInputStream(fis);
        ) {
            byte[] buffer = new byte[4096];
            while (bfis.read(buffer) != -1) {
                System.out.println(new String(buffer));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
