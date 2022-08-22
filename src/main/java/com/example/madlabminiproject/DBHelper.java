package com.example.madlabminiproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String dbname = "dbitems";
    ArrayList<Items> itemsArrayList = new ArrayList<Items>();

    public DBHelper(Context context) {
        super(context, dbname, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "create table items ( name text primary key,contact text,bloodgroup text)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String qry = "drop table if exists items";
        db.execSQL(qry);
        onCreate(db);
    }
    public long addItem(String name,String contact,String bloodgroup)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("contact",contact);
        cv.put("bloodgroup",bloodgroup);
        long res = db.insert("items",null,cv);
        return res;
    }
    public ArrayList<Items> selectItems()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String[] columns = {"name","contact","bloodgroup"};
        Cursor cursor = db.query("items",columns,null,null,null,null,null);
        while(cursor.moveToNext())
        {
            int index1=cursor.getColumnIndex("name");
            String rowName = cursor.getString(index1);
            int index2=cursor.getColumnIndex("contact");
            String rowContact = cursor.getString(index2);
            int index3=cursor.getColumnIndex("bloodgroup");
            String rowBloodgroup = cursor.getString(index3);
            Items rowItem = new Items(rowName,rowContact,rowBloodgroup);
            itemsArrayList.add(rowItem);

        }
        return itemsArrayList;
    }

    public Cursor searchItem(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[]{"name", "contact", "bloodgroup"};
        Cursor cursor = db.rawQuery("select * from items where name=?", new String[]{name});
        return cursor;
    }

    public long updateItem(String uname, String ucontact, String ubloodgroup) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",uname);
        cv.put("contact",ucontact);
        cv.put("bloodgroup",ubloodgroup);
//String sargs[] = new String[]{String.valueOf(id)};
        long res = db.update("items",cv,"name = ?",new String[]{uname});
        return res;
    }

    public long deleteItem(String name) {
        SQLiteDatabase db=this.getWritableDatabase();
        long res = db.delete("items","name=?",new
                String[]{String.valueOf(name)});
        return res;

    }
}
