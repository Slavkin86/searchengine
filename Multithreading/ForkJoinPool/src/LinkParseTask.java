package src;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;


public class LinkParseTask extends RecursiveTask<List<LinkParseTask>> {
    private String path;
    private int page;

    public LinkParseTask(int page, String path)
    {
        this.page = page;
        this.path = path;
    }
    public String getPath() {
        return path;
    }
    public int getPage() {
        return page;
    }

    //Парсинг всех ссылок со страницы
    public List<String> pageLinkList(String link1) throws InterruptedException {
        Thread.sleep(150);
        Document doc = null;
        {
            try {
                doc = Jsoup.connect(link1)
                        .userAgent("Chrome/4.0.249.0 Safari/532.5")
                        .referrer("http://www.google.com")
                        .get();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Elements el = doc.select("a");
        List<String> list = new ArrayList<>();
        for (Element subLink: el) {
            list.add(subLink.absUrl("href"));
        }
        return list;
    }

    @Override
    protected List<LinkParseTask> compute()
    {
        List<String> list = new ArrayList<String>();
        List<LinkParseTask> tasks = new ArrayList<LinkParseTask>();
        try {
            list = pageLinkList(path);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page += 1;
        for (String link: list)
        {
            if (!link.equals(path) && checkLink(link, tasks))
            {
                LinkParseTask task = new LinkParseTask(this.page, link);
                task.fork();
                tasks.add(task);
            }
            else continue;
        }
        try {
            treeWriter(tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    //Проверка на цикличность ссылок
    private boolean checkLink(String link, List<LinkParseTask>list)
    {
        int cL = 0;
        if (link.startsWith("https://lenta.ru")) {
            for (LinkParseTask link1: list) {
                if (link.equals(link1.getPath())) {
                    cL = cL + 1;
                }
            }
            return cL == 0;
        }
        else return false;
    }
    //Запись в файл
    public static void  treeWriter(List<LinkParseTask> linkTreeParsers) throws IOException {
        String filePath = "src/1.txt";
        String l;
        for (LinkParseTask ltp: linkTreeParsers) {
            String tab = "";
            for(int i = 1; i < ltp.getPage(); i++) {
                tab += "\t";
            }
            if (ltp.getPath().equals("https://lenta.ru/")) {
                l = ltp.getPath();
            }
            else l = tab + ltp.getPath();
            FileWriter fw = new FileWriter(filePath, true);
            fw.write(l + "\n");
            fw.close();
        }
    }
}