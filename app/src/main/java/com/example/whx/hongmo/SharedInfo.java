package com.example.whx.hongmo;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by whx on 2015/11/4.
 */
public class SharedInfo {

    private Context context;
    private String userName,userId;
    private boolean isUser;
    SharedPreferences sharedPre;
    SharedPreferences.Editor editor;

    public SharedInfo(){

    }
    public SharedInfo(Context context){
        this.context = context;
        sharedPre = context.getSharedPreferences("userInfo",Context.MODE_PRIVATE);
        editor = sharedPre.edit();
    }
    public void setInfo(String userName,String userId){

        this.userName = userName;
        this.userId = userId;

        saveInfo();
    }

    public void saveInfo(){


        editor.putString("name",userName);
//        editor.putString("sex",userSex);
        editor.putString("id",userId);
//        editor.putString("shebao",userSheBao);
//        editor.putString("phone", phoneNumber);


        editor.commit();
    }
    public void setIsUser(boolean isUser){

        this.isUser = isUser;
        editor.putBoolean("isUser", isUser);
        editor.commit();
    }
    public boolean getIsUser(){
        return sharedPre.getBoolean("isUser",false);
    }
    public String[] getInfo(){
        String[] infos = new String[5];
        infos[0] = sharedPre.getString("name","");
        infos[1] = sharedPre.getString("sex","");
        infos[2] = sharedPre.getString("id","");

        return infos;
    }
}
