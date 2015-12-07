package com.example.whx.hongmo;
import java.util.Calendar;
/**
 * Created by 123 on 2015/12/7.
 */
public class IdOperate {

    private String id;

    public IdOperate(){

    }
    public IdOperate(String id){
        this.id = id;

    }

    public String getAddressStr(String id){
        return id.substring(0,6);
    }

    public String getBirthStr(String id){
        String birthYear = id.substring(6,10);
        int year = Integer.valueOf(birthYear).intValue();

        Calendar cal = Calendar.getInstance();
        int yearNow = cal.get(Calendar.YEAR);
        if(yearNow>=year)
        {
            int age = yearNow - year;
            String res = Integer.toString(age);
            return res;
        }
        else return "查无此人";
    }

    public String getSexStr(String id){
        char sexBit = id.charAt(16);

        int temp = (Integer.valueOf(sexBit).intValue())%2;
        switch(temp){
            case 0:
                return "女";
            default:
                return "男";
        }

    }
}
