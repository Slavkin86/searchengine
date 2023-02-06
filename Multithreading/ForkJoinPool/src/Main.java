package src;

import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) throws IOException {
        ForkJoinPool pool = new ForkJoinPool();
        LinkParseTask lentaParser = new LinkParseTask(1, "https://lenta.ru");
        LinkParseTask.treeWriter(pool.invoke(lentaParser));
    }
}