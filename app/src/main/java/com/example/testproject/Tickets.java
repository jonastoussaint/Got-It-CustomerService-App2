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
    public static final String KEY_DESCRIPTION="sup_description";
    public static final String KEY_COMPLAINT="sup_complainant_type";
    public static final String KEY_RESOLUTION="sup_resolution";
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

    public void setType(String type)
    {
        put(KEY_TYPE, type);
    }

    public String getStatus(){
        return getString(KEY_STATUS);
    }

    public void setStatus(String status){
        put(KEY_STATUS, status);
    }

    public String getDescription(){
        return getString(KEY_DESCRIPTION);
    }

    public void setDescription(String description){
        put(KEY_DESCRIPTION, description);
    }

    public String getComplaint(){
        return getString(KEY_COMPLAINT);
    }

    public void setComplaint(String complaint){
        put(KEY_COMPLAINT, complaint);
    }
    public String getResolution(){
        return getString(KEY_RESOLUTION);
    }

    public void setResolution(String resolution){
        put(KEY_RESOLUTION, resolution);
    }
}
