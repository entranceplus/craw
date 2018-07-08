# link-crawler

To see javadocs clone the repo 
1. `git clone https://github.com/entranceplus/craw.git`
2. open the file `javadoc/index.html` in any browser

### Usage:
```Java
Reddit reddit = new Reddit()
reddit.getLinksFromReddit("soccer").getLinks() //Returns the links list
reddit.getLinksFromReddit("soccer").getsubreddit() //Returns the subreddit
```
