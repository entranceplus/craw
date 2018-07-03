import com.ep.LinkExtractor.ExtractionInterface.Reddit;
import com.ep.LinkExtractor.dao.CustomResponseDAOImpl;
import com.ep.LinkExtractor.utils.HttpClientUtil;

public class LinkExt {

    public static void main(String[] args) {
        try {
            Reddit reddit = new Reddit();
            System.out.println(reddit.getSubreddits("http://www.reddit.com/reddits.json"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
