package lambdasinaction.chap8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class BufferReaderProcessorDemo {

    public static String CONTENT = "hello,world! \n I am a bird!";

    interface BufferReaderProcessor {
        String process(BufferedReader bufferedReader) throws IOException;
    }


    public static void main(String[] args) {

        try {
            System.out.println(processFile(BufferedReader::readLine));

            System.out.println(processFile(br ->br.readLine()+br.readLine()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String processFile(BufferReaderProcessor processor) throws IOException {

        try (BufferedReader br = new BufferedReader(new StringReader(CONTENT))) {

            return  processor.process(br);

        }
    }

}
