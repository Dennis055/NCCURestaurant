import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.RowId;

public class MyDBHelper{
    public SQLiteDatabase db = null;
    private final static String database_name="db1.db";
    private final static String table_name="table01";
    private final static String _ID = "_id";
    private final static String NAME= "name";
    private final static String PRICE= "price";
    
    private final static String CREATE_TABLE="create table"+table_name+"("+_ID+"integer primary key,"+ NAME +"TEXT,"+PRICE+"INTEGER)";
   
    private Context context =null;
    public MyDBHelper(Context text){
        this.context=text;
    }
    
    public void open()throws SQLException {
        db = context.openOrCreateDatabase(database_name, 0, null);
            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
            } 
        }
    
        public void closs () {
            db.close();
        }
        public Cursor getAll(){
        return db.query(table_name,new String[]{_ID,NAME,PRICE},
                null,null,null,null,null,null);
        }
        public Cursor get(long rowId)throws SQLException{
        Cursor c= db.query(table_name,new String[]{_ID,NAME,PRICE},_ID+"="+rowId,null,null,null,null,null);
        if(c!=null){
            c.moveToFirst();
        } return c;
        }
        
        public long append(String name,int price){
        ContentValues cv = new ContentValues();
        cv.put(NAME,name);
        cv.put(PRICE,price);
        return db.insert(table_name,null,cv);
        }
        
        public boolean delete(long rowId){
        return db.delete(table_name,_ID+"="+rowId,null)>0;
        }
        
        public boolean update(long rowId,String name,int price){
        ContentValues cv =new ContentValues();
        cv.put(NAME,name);
        cv.put(PRICE,price);
        return db.update(table_name,cv,_ID+"="+rowId,null)>0;
        }
    
        
}
