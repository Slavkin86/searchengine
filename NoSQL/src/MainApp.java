package NoSQL.src;

import redis.clients.jedis.Jedis;

public class MainApp {

    public static <Jedis> void main(String[] args) {

        Jedis client = new Jedis("localhost", 6379);
        MeetingWebsiteLog log = new MeetingWebsiteLog(client);
        log.start();
    }
}