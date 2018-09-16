import com.entranceplus.craw.crawler.Reddit;
import com.entranceplus.craw.dto.Subreddit;


public class LinkExt {

    public static void main(String[] args) {
        try {
            Reddit reddit = new Reddit();
//
//            for(Subreddit subreddit:reddit.getSubreddits().getMetadata()) {
//                System.out.println("Name followers "+subreddit.getFollowers()+" "+subreddit.getSubreddit());
           // }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
