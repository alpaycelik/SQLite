package celik.alpay.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ALPAY on 30.12.2017.
 */

public class Sqlite_katmani extends SQLiteOpenHelper {

    public Sqlite_katmani(Context c){
        super(c, "kullanici",null,1);
    }
    public void onCreate(SQLiteDatabase db){
        String sql = "create table kullanici (id integer primary key autoincrement, isim text not null)";
        db.execSQL(sql);
    }
    public void onUpgrade(SQLiteDatabase db, int eski, int yeni){
        db.execSQL("drop table if exists kullanici");
    }
}
