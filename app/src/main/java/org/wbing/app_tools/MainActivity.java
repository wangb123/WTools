package org.wbing.app_tools;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.wbing.app_tools.databinding.ActivityMainBinding;
import org.wbing.base.ui.impl.WAct;
import org.wbing.tools.WEncryptTool;
import org.wbing.tools.WLogTool;

public class MainActivity extends WAct<ActivityMainBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void loadData() {
        long millis = SystemClock.uptimeMillis();
        String str = WEncryptTool.decryptDES("uTy6P\\/e8T4ntC+q2eCpUnQo7FAHlEvJMDTySNnlS8V7AJUvEirSsx1umTCmZHWPZL1xlZe2kMrGzrTSFayDEYt88DLz3Z7CLlfWOt5bqt5new0lQ3ITkCTyN1xnE0k2DyNc9abP0np30ZtaR7S+N4fB\\/KGx4qNhohgquL71HjKMAREolFoZy4TMsgaafHRLdtavZHJU3xXtMt5SyW7h8GgxZ2DgRX2fxdxUJAbb4Im9sRCk+7Yx5C3TWB0P27bu3WCNlXJ7T\\/KdYmG+qdp4ej1RG2c5rw1KmuQZqcrdKnO5yI3awBhKfHgnBesXKQDjuGlpuJ2jhMFp0zrmDWoq0nvr0SqhG+vPH3UCxm69PBuz7FIqC5azWpvPOV2gZELU7VsbduPfNCLPw\\/JVjSe1hnWilGi7h817swBKe92beAQD\\/D\\/GLL3OpOIM\\/gShX+yUJhFS7fo4seRaTbr+XnyuU4\\/mAAAaZFU53GyQjdVkxTok+VS2twCSHqrb8m4jquoek2icD6957jK5\\/0Y4Agv49VfziuswO\\/wROnA2DoriqWYzVBp5MIQXlCsuWUscvXwUFWJPiul8DepY\\/r7sm+Dygn6fKatv4UunpMz0l\\/407cVT9Soiy80H+1AwEhf5AxJZGWTVrmkZxOsRtE2PQVI+tkYkDJzUjutxe1xMnpKrruK6b\\/UtQ0B6T3zO7x5WFDMiZyyoFTuJbGPNjZ7dMV+6DBXlPdleQw1pFQKpzLnI45d0BgI\\/eAhKVWYtA9v1s4rtjNs6VJExcEKOtG1q4SdwYDSs+yN3PfEBqKXLA97Dkm2HmT0uxOh1+7r9q2WyY\\/3xI7+UjurRFnMuVoWx9Txd1rXZ\\/7r1bpyb70H+1\\/E\\/Poiu+KI+waOeYaGwUhMe0cVUnlQN09\\/Szz\\/4xcGkoUzFzoQ2ddQ6vMyzD5hdTBcG8pUcbr1T+4zeyIfzL\\/A0myBVSgQLSyhEiuUUu5jGOScNm5nayN+WLfYniTQYqzXWgh7Q+7MyTKbYpWYX\\/fWZhLzCMCQFdFi7ACztG7jTKKE48AdLZobpXuDR80sL0SD3aCFbR6TQUZlTxIgSum5xIWs0+zdDA1tb6MepVlMoVEAMddaShvY1RnHMYs5PXUT5B+wLHL5joQsWcUIs8wkimIZvW8Q21zjMwP717AyHSotmrSgd4vZNhZLXoziDkoYLtJY51GD6anTBCZtonA+vee4yuf9GOAIL+PVX84rrMDv8ETpwNg6K4qlmM1QaeTCEF5QrLllLHL18FBViT4rpfA3qWP6+7Jvg8oJ+nymrb+FLp6dX52SLoX3A4cagndeZDNBEIKnr3Ce1AAl2gGtxepo4SpCsW7D3M11GU+mdOKb28shqYYIU9XkdSz6iIcS0Qgv8G5rIIOVAl9I5gedCJ7\\/7X4W7DrO5kX9Y2n6BJaCBc8120u8xM4RiawTN9Fu4BiPYhq\\/C20GAzwZuVwxyKlzSiBzQISZiBgHfSS8vOiaHyaMowXyUrgDctX10wUZIRP6hzuelt\\/wiPx0ItD5ZaQC7z+ubegSCkwfREhUdcndQs6VkoeyNmNfbeGL09eK7i6M6sFmgRYguL2YBS5SeXXpv5mXn1Ciu6WLsHZiAf7vGs\\/K2ooTrcC8yvSD5Of1MyWFauk\\/JpTIp2znwCxTNosUFD+v5YAH1zvBkNT\\/YyJquVaxshrmIaQZhtKgDz8C2Zr3wB0xC597fSl7\\/Sa6qpVsXeiY30bniPTaF8cFmWKgwzXLvu2URtGGPcUdFDIi3oQBLqB3P5rnXw\\/bmd7CV24u7Dm34a3AUcQWmp9\\/fJjBvYUXMSzL0Z\\/iioEYJ70OrU\\/0BbZuW9b\\/L0\\/nzgdmrl4bAWuLvP26TbZjKotSNxVJT\\/9DUNXRVgy\\/itdyNThb6xxUNGZu5s3tslAjo0YbZdhpyh2yFgEqvzlHLzyb0xPR+jU8aBCK9u\\/eWIhWUxbgvfXVH8UoPT82r1xuc8ELjuZLxjU6FGbmoRIa14+k9V3ge9fyv6gqhmMqMSAYCP3gISlVmLQPb9bOK7YzbOlSRMXBCjrRtauEncGA0rPsjdz3xAailywPew5JthrT+ODIJrBhuj90guk52+BW8vOvAN\\/9Y7l6JmPjOeRs92f+69W6cm+9B\\/tfxPz6IrviiPsGjnmGhsFITHtHFVJ5UDdPf0s8\\/+lWFdeY6nl5P55sASnxPpe+YXUwXBvKVHG69U\\/uM3siH3pSdQ9AlJksXN8t1Wr6qSLuYxjknDZuZ2sjfli32J4k0GKs11oIe0Lwo7Djq8sDA7kDwIJ0qCJLyaCkJVNhkpDaR9PvJ\\/MC3S2aG6V7g0fNLC9Eg92ghW0ek0FGZU8SI7\\/mIggsPI6AFFwC9FUZfQ7sDBIuPmhv9A3vKYYmmmk1fBa+fDDYBzkoG5AocnOzD9MxolPsGp8gIaZMV0VUG0Zo0ZZccAdENooxny5d5\\/H1Q2nRaJHbUWYZcHdz3x\\/QLi4ngIopMMS38Yt7us960ZnA2DoriqWYz5wb5KDgLiToy5zfQzyZ+JdsccHSBwT5lQYuhiB053bmHzpy+LiTZgXCjvobNZFAxMOXqYVlCsGbidzCwDc2JJhCP593BwqNWvpbOVarQyndgMgcijRIUeapib+XIeykfnDRX2ygVJJzVcONknS+vvqwqUV6FNwZTMWzsTR1Wxusfm5LEaUbFRrJ8a+faeO41ck3VwnnS4wPxrFsGW0KP8O28bDDJ0ToB5QWk1SDUJkDpANTU8EpSfA2nfgKlDkTqblcMcipc0ogc0CEmYgYB30kvLzomh8mjKMF8lK4A3LV9dMFGSET+oc7npbf8Ij8dtmSBKctGDiS3ztzmMOVXtRIVHXJ3ULOlZKHsjZjX23tKlbjeyGH1ksMyASHOVSsuAUuUnl16b+Zl59Qoruli7B2YgH+7xrPzB+5oaeytZU\\/u9GZOj2fX2t7gCw8Lv2SDpno2TYX9I2YIqVuz102UREVycJzBSvos0WudHTSNguw==", "0942e12fcb6e7f6218185095480643fe");

        long l = SystemClock.uptimeMillis()-millis;
        WLogTool.e("l:" + l);

        String encryptDES = WEncryptTool.encryptDES("wbing123", "yaolan_app");
        WLogTool.e("encryptDES:" + encryptDES);
        String decryptDES = WEncryptTool.decryptDES(encryptDES, "yaolan_app");
        WLogTool.e("decryptDES:" + decryptDES);
    }

    @Override
    public void recycle() {

    }
}
