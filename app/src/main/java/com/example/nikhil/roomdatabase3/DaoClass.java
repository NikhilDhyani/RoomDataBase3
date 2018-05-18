package com.example.nikhil.roomdatabase3;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

/**
 * Created by NIKHIL on 18-05-2018.
 */

  //This is our DAO interface. Which contains all possible operations or methods needed for Database.
  //Like creation,read,update,delete (CRUD)


 //Since this is DAO (Data Access Object), we need annotation "@Dao".

@Dao
public interface DaoClass {

    //Note: This operation represents insertion operation.
    //So for that we need to use annotation "@Insert"

    @Insert
    public void addUser(User user);


    //After this create Database class that extends room database
    //Note: The database class must be an abstract class.

}
