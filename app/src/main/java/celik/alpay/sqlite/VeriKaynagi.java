package celik.alpay.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALPAY on 30.12.2017.
 */

public class VeriKaynagi {
    SQLiteDatabase db;
    Sqlite_katmani bdb;
    public VeriKaynagi(Context c){
        bdb = new Sqlite_katmani(c);
    }
    public void ac(){
        db = bdb.getWritableDatabase();
    }
    public void kapat(){
        bdb.close();
    }
    public int kullaniciOlustur(String isim){
       // String isim = "ali demir";
       // Kullanici k = new Kullanici();
       // k.setIsim(isim);
        ContentValues val = new ContentValues();
        val.put("isim",isim);
        int sonid = (int)db.insert("kullanici",null,val);
        return sonid;
    }
    public  void kullaniciSil(Kullanici k){
        int id = k.getId();
        db.delete("kullanici","id="+id,null);
    }
    public List<Kullanici> listele(){
        String kolonlar[] = {"id","isim"};
        List<Kullanici> liste = new ArrayList<Kullanici>();
        Cursor c = db.query("kullanici", kolonlar,null,null,null,null,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            int id = c.getInt(0);
            String isim = c.getString(1);
            String eleman = " "+id+"-"+isim;

            Kullanici k = new Kullanici(isim,id);
            liste.add(k);
            c.moveToNext();
        }
        c.close();
        return liste;
    }
}
