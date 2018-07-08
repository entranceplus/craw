import com.entranceplus.craw.ExtractionInterface.Reddit;


public class LinkExt {

    public static void main(String[] args) {
        try {
            Reddit reddit = new Reddit();
            System.out.println(reddit.getLinksFromReddit("soccer"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
