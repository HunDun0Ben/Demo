package concurrency;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WriterFile {

    public static int LINE_NUMBER = 100000;

    public static void main(String[] args) {
        int fileNum = 20;
        String path = "D:\\tmp\\fileTest";
        String filename = "test";
        String fileSuffix = ".txt";

        startTimer();
        writeFileGroup(fileNum, path, filename, fileSuffix);
        System.out.println("Writer file. All spend time is : " + printTime() + "ms");
        // Writer file. All spend time is : 12312ms

        startTimer();
        writeFileBufferGroup(20, path, filename, fileSuffix);
        System.out.println("Writer buffer file. All spend time is : " + printTime() + "ms");
        // Writer buffer file. All spend time is : 6406ms

        startTimer();
        multiThreadWrite(20, path, filename, fileSuffix);
        System.out.println("Writer buffer file multi Thread. All spend time is : " + printTime() + "ms");
        // Writer buffer file multi Thread. All spend time is : 111ms
    }

    public static Map<Long, Long> timerMap = new HashMap<>();

    public static void startTimer() {
        timerMap.put(Thread.currentThread().getId(), System.currentTimeMillis());
    }

    public static long printTime() {
        return System.currentTimeMillis() - timerMap.get(Thread.currentThread().getId());
    }

    public static void multiThreadWrite(int fileNum, String dir, String filePrefix, String fileSuffix) {
        ExecutorService service = Executors.newFixedThreadPool(fileNum);
        for (int i = 0; i < fileNum; i++) {
            String path = dir + File.separator + filePrefix + "_" + i + fileSuffix;
            service.submit(()-> writeFileBuffer(path));
        }
    }

    public static void writeFileBufferGroup(int fileNum, String dir, String filePrefix, String fileSuffix) {
        for (int i = 0; i < fileNum; i++) {
            String path = dir + File.separator + filePrefix + "_" + i + fileSuffix;
            writeFileBuffer(path);
        }
    }

    public static void writeFileGroup(int fileNum, String dir, String filePrefix, String fileSuffix) {
        for (int i = 0; i < fileNum; i++) {
            String path = dir + File.separator + filePrefix + "_" + i + fileSuffix;
            writeFile(path);
        }
    }

    public static void writeFileBuffer(String path) {
        File file = new File(path);
        try (OutputStream fos = new BufferedOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < LINE_NUMBER; i++) {
                fos.write(upperLetter().getBytes());
                fos.write("\n".getBytes());
                fos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String path) {
        File file = new File(path);
        try (OutputStream fos = new FileOutputStream(file)) {
            for (int i = 0; i < LINE_NUMBER; i++) {
                fos.write(upperLetter().getBytes());
                fos.write("\n".getBytes());
                fos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String upperLetter() {
        char ch = 'A';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append((char) (ch + i));
        }
        return sb.toString();
    }

    public static String lowerLetter() {
        char ch = 'a';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append((char) (ch + i));
        }
        return sb.toString();
    }
}
