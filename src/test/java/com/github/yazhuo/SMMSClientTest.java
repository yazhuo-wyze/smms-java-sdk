package com.github.yazhuo;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import com.github.yazhuo.reponse.ImageItem;
import com.github.yazhuo.reponse.ResponseUserProfile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class SMMSClientTest {


    private SMMSClient smmsClient;


    @Before
    public void init() {
        this.smmsClient = new SMMSClient(System.getenv("SMMS_API_TOKEN"));

        final ImageItem imageItem = this.smmsClient.upload(FileUtil.file("lina.jpg"));
        final String url = imageItem.getUrl();
        final String hash = imageItem.getHash();
    }

    @Test
    public void login() {
        this.smmsClient = new SMMSClient(System.getenv("SMMS_USERNAME"), System.getenv("SMMS_PASSWORD"));
        Console.log("login test ok.");
    }

    @Test
    public void profile() {
        final ResponseUserProfile profile = this.smmsClient.profile();
        Assert.assertNotNull(profile);
        Console.log("profile : {}", profile);
        Console.log("profile test ok.");
    }

    @Test
    public void upload() {
        final ImageItem imageItem = this.smmsClient.upload(FileUtil.file("lina.jpg"));
        Assert.assertNotNull(imageItem);
        Console.log("upload file : {}", imageItem);
        Console.log("upload file test ok.");
        this.smmsClient.delete(imageItem.getHash());
    }

    @Test
    public void uploadHistory() {
        final ImageItem imageItem = this.smmsClient.upload(FileUtil.file("lina.jpg"));
        final List<ImageItem> imageItems = this.smmsClient.uploadHistory();
        Assert.assertFalse(imageItems.isEmpty());
        Console.log("upload history : {}", imageItems);
        Console.log("upload history test ok.");
        this.smmsClient.delete(imageItem.getHash());
    }

    @Test
    public void history() {
        final ImageItem imageItem = this.smmsClient.upload(FileUtil.file("lina.jpg"));
        final List<ImageItem> imageItems = this.smmsClient.history();
        Assert.assertFalse(imageItems.isEmpty());
        Console.log("history : {}", imageItems);
        Console.log("history test ok.");
        this.smmsClient.delete(imageItem.getHash());
    }

    @Test
    public void clear() {
        final Boolean cleared = this.smmsClient.clear();
        Assert.assertTrue(cleared);
        Console.log("clear test ok.");
    }


    @Test
    public void delete() {
        final ImageItem imageItem = this.smmsClient.upload(FileUtil.file("lina.jpg"));
        Assert.assertNotNull(imageItem);
        Console.log("upload file : {}", imageItem);
        Console.log("upload file test ok.");
        final Boolean delete = this.smmsClient.delete(imageItem.getHash());
        Assert.assertTrue(delete);
        Console.log("delete test ok.");
    }

}