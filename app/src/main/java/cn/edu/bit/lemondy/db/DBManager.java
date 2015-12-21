package cn.edu.bit.lemondy.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cn.edu.bit.lemondy.beans.Post;

/**
 * Created by lemon on 12-20.
 * 封装业务操作
 */
public class DBManager {
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public DBManager(Context context){
        dbHelper = new DBHelper(context);

        db = dbHelper.getWritableDatabase();
    }

    public void add(List<Post> posts){
        db.beginTransaction();

        try{
            for(Post p:posts){
                db.execSQL("insert into post values(null,?,?,?,?,?,?)",
                             new Object[]{p.getPostTitle(),p.getPostTime(),p.getPostImage(),
                                     p.getAuthorName(),p.getPostContent(),p.getPostUrl()});
            }
        }finally{
            db.endTransaction();
        }
    }

    public void updataPost(List<Post> posts){

    }

    public void deletePost(Post p){
        db.delete("post","title=?",new String[]{p.getPostTitle()});
    }

    public List<Post> queryAll(){
        List<Post> posts = new ArrayList<>();

        Cursor c = queryTheCursor();

        while(c.moveToNext()){
            Post p = new Post();
            p.setId(c.getString(c.getColumnIndex("id")));
            p.setPostTitle(c.getString(c.getColumnIndex("title")));
            p.setPostTime(c.getString(c.getColumnIndex("time")));
            p.setPostImage(c.getString(c.getColumnIndex("imageUrl")));;
            p.setAuthorName(c.getString(c.getColumnIndex("author")));
            p.setPostContent(c.getString(c.getColumnIndex("content")));
            p.setPostUrl(c.getString(c.getColumnIndex("postUrl")));
        }
        c.close();

        return posts;
    }

    public Cursor queryTheCursor(){
        return db.rawQuery("select * from post",null);
    }



    public void closeDB(){
        db.close();
    }



}
