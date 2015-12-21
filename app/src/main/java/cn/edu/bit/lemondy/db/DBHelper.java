package cn.edu.bit.lemondy.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lemon on 12-20.
 */
public class DBHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "post.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    //数据库第一次被创建时OnCreate会被调用
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists post" +
                "(id int primary key autoincrement," +
                "title varchar," +
                "time varchar," +
                "imageUrl varchar," +
                "author varchar," +
                "content text," +
                "postUrl varchar");
    }

    //如果DATABASE_VERSION值被改为2，系统发现现有数据库版本不同，机会调用onUpgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("ALTER table post add Column other String");
    }
}
