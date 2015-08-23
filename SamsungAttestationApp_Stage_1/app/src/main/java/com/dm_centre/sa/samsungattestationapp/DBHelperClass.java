package com.dm_centre.sa.samsungattestationapp;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Berlin on 23.08.15.
 */
public class DBHelperClass extends SQLiteOpenHelper {
    static final String DB_TABLE = "notes";
    static final String COLUMN_NAME = "name";
    static final String COLUMN_COMMENT = "comment";
    private static final String DB_NAME = "notes.db";
    private static final int DB_VERSION = 1;
    private static final String DB_CREATE_TABLE = "CREATE TABLE " + DB_TABLE +
            " ( _id INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " TEXT NOT NULL, " + COLUMN_COMMENT +" TEXT NOT NULL );";

    public DBHelperClass(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
        onCreate(db);
    }
//---------------------------------------------------------------
//add a new comment item
    public void addComment(dataModelClass comment){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, comment.getName()); // Contact Name
        values.put(COLUMN_COMMENT, comment.getComment()); // Contact Comment

        // Inserting Row
        db.insert(DB_TABLE, null, values);
        db.close(); // Closing database connection

    }

//---------------------------------------------------------------
//get a comment item
    public Cursor getOneComment(long id){
        SQLiteDatabase db = this.getWritableDatabase();

        String id_string = Long.toString(id);
        String [] where = {id_string};
//this.DB_TABLE, null, "_id = ?", where, null, null, null, null
        Cursor cursor = db.rawQuery("SELECT * FROM "+this.DB_TABLE+" where _id=?",where);
        if(cursor!=null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
//---------------------------------------------------------------
//get all list
    public Cursor getAllComment(){
        SQLiteDatabase db = this.getWritableDatabase();
        //String where = " note LIKE '%" + word + "%'";
        Cursor cursor = db.query(this.DB_TABLE, null, null, null, null, null, "_id DESC");

        return cursor;
    }
//---------------------------------------------------------------
//get a comment item
    public void updateComment(dataModelClass comment, long id){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, comment.getName()); // Contact Name
        values.put(COLUMN_COMMENT, comment.getComment()); // Contact Comment

        //update my row
        db.update(DB_TABLE, values, "_id "+"="+id, null);

        db.close(); // Closing database connection

    }
//---------------------------------------------------------------
//get a comment item
    public void deleteComment(long id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DB_TABLE, "_id = " + id, null);
        db.close();
    }

}
