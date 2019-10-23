package com.ctillnow.test;


import com.ctillnow.proto.BINlapArticleMessage;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by caiping on 2019/10/17.
 */


public class DemoApplicationTest {


    @Test
    public void testHttp() {
        BINlapArticleMessage.BINlpArticleRequest input = BINlapArticleMessage.BINlpArticleRequest.newBuilder()
                .setCityId(18)
                .setTime("2019-10-10 09:57:23")
                .build();

        BINlapArticleMessage.BINlapArticleResponse output =  httpPost(input.toByteArray(), "http://127.0.0.1:8080/test");
        if(output != null){
            final List<BINlapArticleMessage.BIArticleParagraph> paragraphList = output.getParagraphList();
            for(BINlapArticleMessage.BIArticleParagraph biArticleParagraph : paragraphList){
                System.out.println(biArticleParagraph.toString());
            }
        }
    }

    private BINlapArticleMessage.BINlapArticleResponse httpPost(byte[] bytes, String url) {
        BINlapArticleMessage.BINlapArticleResponse output = null;
        OutputStream out = null;
        InputStream in = null;
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/x-protobuf");
            conn.connect();
            out = conn.getOutputStream();
            out.write(bytes);
            out.flush();
            out.close();
            // 反序列化
            in = conn.getInputStream();
            byte[] bytesRe = toByteArray(in);
            output = BINlapArticleMessage.BINlapArticleResponse.parseFrom(bytesRe);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return output;
    }

    public byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }
}


