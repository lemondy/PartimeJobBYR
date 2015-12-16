package cn.edu.bit.lemondy.beans;

import android.graphics.Bitmap;

/**
 * Created by lemon on 12-15.
 * @description:
 *
 */
public class Post {
    private String postImage;
    private Bitmap postBitmap;
    private String postTitle;
    private String postTime;
    private String authorName;
    private String replyAmount;

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
}