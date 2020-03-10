package com.example.testproject;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.Date;

@ParseClassName("SupportTicket")

public class Tickets extends ParseObject {

    public static final String KEY_TICKETID="objectId";
    public static final String KEY_DATE="createdAt";
    public static final String KEY_TYPE="sup_complainant_type";
    public static final String KEY_STATUS="sup_status";
    //tickets class
    public String getKeyObjid(){
        return getString(KEY_TICKETID);
    }


    public Date getDate(){

        return getCreatedAt();
    }

    public void setDate(String date){
        put(KEY_DATE, date);
    }

    public String getType(){
        return getString(KEY_TYPE);
    }

    public void setType(String type){
        put(KEY_TYPE, type);
    }

    public String getStatus(){
        return getString(KEY_STATUS);
    }

    public void setStatus(String status){
        put(KEY_STATUS, status);
    }
}
