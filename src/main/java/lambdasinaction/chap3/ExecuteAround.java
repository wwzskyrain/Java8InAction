package lambdasinaction.chap3;

import java.io.*;

public class ExecuteAround {

    public static void main(String... args) throws IOException {

        // method we want to refactor to make more flexible
        String result = processFileLimited();
        System.out.println(result);

        System.out.println("---");

        String oneLine = processFile((BufferedReader b) -> b.readLine());
        System.out.println(oneLine);

        String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
        System.out.println(twoLines);

    }

    public static String processFileLimited() throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("lambdasinaction/chap3/data.txt"))) {
            return br.readLine();
        }
    }


    public static String processFile(BufferedReaderProcessor p) throws IOException {
        //	改写processFile——给函数式接口BufferedReaderProcessor提供应用上下文
        try (BufferedReader br = new BufferedReader(
                new FileReader("lambdasinaction/chap3/data.txt"))) {
            return p.process(br);
        }

    }

    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;

    }
}
