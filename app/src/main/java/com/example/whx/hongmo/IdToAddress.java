package com.example.whx.hongmo;



import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class IdToAddress {

    protected final String DATABASE_PATH = Environment
            .getExternalStorageDirectory().getAbsolutePath()+ "/HongMo";
    protected final String DATABASE_FILENAME = "idtoad.db";
    private SQLiteDatabase database;
    private Context mContext;
    private String id;

    public IdToAddress(Context context) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        TextView text = (TextView)findViewById(R.id.text);
        this.mContext = context;
        String databaseFilename = DATABASE_PATH + "/" + DATABASE_FILENAME;
        File dir = new File(DATABASE_PATH);
        if (!dir.exists()){
            dir.mkdirs();
        }else{

        }
        File file = new File(databaseFilename);
        try {
            if (!file.exists()) {

                file.createNewFile();
                InputStream is = mContext.getResources().openRawResource(R.raw.filesidtoaddress);
                FileOutputStream fos = new FileOutputStream(databaseFilename);
                byte[] buffer = new byte[is.available()];
                is.read(buffer);
                fos.write(buffer);

                is.close();
                fos.close();
            }
        }catch (Exception e){
            Log.i("------------", e.getMessage());
        }



        database = SQLiteDatabase.openOrCreateDatabase(
                databaseFilename, null);
//        Cursor cursor = database.rawQuery("select * from idad where id="+"123456",null);

    }
    public String getAddress(String id){
        Cursor cursor = database.rawQuery("select * from idad where id="+id,null);
        String result;

        try {
            while (cursor.moveToNext()) {
                //Log.i("-----------", new String(cursor.getBlob(1), "gbk"));
                result = new String(cursor.getBlob(1), "gbk");

                return result;
            }
        }catch (Exception e){
                return e.getMessage();
        }

        return "请检查身份证号是否正确";
    }
}
