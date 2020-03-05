package com.example.testproject;
import com.parse.ParseObject;
import com.parse.ParseClassName;

@ParseClassName("InternalUser")
public class InternalUser extends ParseObject
{

    private String  userID;
    private String Fname;
    private String Lname;
    private String type;

    private String username;
    private String password;
    private String status;
    private String created;
    private String last_update;

    public InternalUser()
    {
        this.userID = "";
        this.Fname = "";
        this.Lname = "";
        this.type = "";
        this.username = "";
        this.password = "";
        this.status = "";
        this.created = "";
        this.last_update = "";
    }

    public InternalUser(String userID, String Fname, String Lname, String type, String username, String password,
    String status, String created, String last_update)
    {
        this.userID = userID;
        this.Fname = Fname;
        this.Lname = Lname;
        this.type = type;
        this.username = username;
        this.password = password;
        this.status = status;
        this.created = created;
        this.last_update = last_update;
    }


    public void UserID(String userID)
    {
        this.userID = userID;
    }

    public String UserID()
    {
        return userID;
    }

    public void setFirstName(String Fname)
    {
        this.Fname = Fname;
    }

    public String getFirstName()
    {
        return Fname;
    }

    public void setLastName(String Lname)
    {
        this.Lname = Lname;
    }

    public String getLastName()
    {
        return Lname;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

    public void setUserName(String username)
    {
        this.username = username;
    }

    public String getUserName()
    {
        return username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    public void setCreated(String created)
    {
        this.created = created;
    }

    public String getCreated()
    {
        return created;
    }

    public void setLastUpdated(String last_update)
    {
        this.last_update = last_update;
    }

    public String getLastUpdated()
    {
        return last_update;
    }

}
