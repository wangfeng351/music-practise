package com.soft1851.springboot.demo.util;

import com.soft1851.springboot.demo.entity.Music;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/3
 * @Version 1.0
 */
public class Spider {

    public static List<Music> getMusic() {
        String url = "https://y.qq.com/n/yqq/playlist/7382629476.html";
        List<Music> musics = new ArrayList<>();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet post = new HttpGet(url);
        HttpClientContext context = HttpClientContext.create();
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(post, context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            String content = null;
            try {
                content = EntityUtils.toString(entity, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }

            Document document = Jsoup.parse(content, "utf-8");
            Elements div = document.getElementsByClass("songlist__list");
            div.forEach(x -> {
                Elements divs = x.children();
                divs.forEach(o -> {
                    String musicName = o.child(0).child(2).getElementsByClass("songlist__songname_txt").text();
                    String singer = o.child(0).child(3).text();
                    String album = o.child(0).child(4).text();
                    String totalTime = o.child(0).child(5).text();
                    Music music = Music.builder()
                            .name(musicName)
                            .singer(singer)
                            .album(album)
                            .totalTime(totalTime)
                            .status(1)
                            .build();
                    musics.add(music);
                });
            });
        }
        return musics;
    }

    public static void main(String[] args) {
        List<Music> music = getMusic();
        System.out.println(music.size());
    }
}
