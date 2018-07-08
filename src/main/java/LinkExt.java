import com.entranceplus.craw.crawler.Reddit;


public class LinkExt {

    public static void main(String[] args) {
        try {
            Reddit reddit = new Reddit();
            System.out.println(reddit.getSubreddits());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
