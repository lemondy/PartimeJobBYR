package cn.edu.bit.lemondy.beans;

import android.graphics.Bitmap;

/**
 * Created by lemon on 12-15.
 * @description: 描述发表的一条帖子的信息
 *
 */
public class Post {
    private String id;
    private String postImage;
    private Bitmap postBitmap;
    private String postTitle;
    private String postTime;
    private String authorName;
    private String replyAmount;
    private String postUrl;
    private String postContent;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public String getPostImage() {
        return postImage;
    }

    public Bitmap getPostBitmap() {
        return postBitmap;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostTime() {
        return postTime;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getReplyAmount() {
        return replyAmount;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public void setPostBitmap(Bitmap postBitmap) {
        this.postBitmap = postBitmap;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setReplyAmount(String replyAmount) {
        this.replyAmount = replyAmount;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
}
