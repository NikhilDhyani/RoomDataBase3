package com.example.nikhil.roomdatabase3;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by NIKHIL on 18-05-2018.
 */


//This class represents our entity i.e "TABLE"

@Entity(tableName = "users")
public class User {


    //These are our 3 columns

    // Each entity class (or Table) must contain one field as "Primary Key"

    @PrimaryKey(autoGenerate = true)
    private int id;

    //Note: You can customize column name by using annotation @ColumnInfo(name="")

    @ColumnInfo(name = "user_name")
    private String name;

    @ColumnInfo(name = "user_email")
    private String email;

    //Note: As you can see above fields are private fields so to access these fields we need getters and setters


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}


//Note: After creating entity class create DAO which is an interface (Data Access Object).