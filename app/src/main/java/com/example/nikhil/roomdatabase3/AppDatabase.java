package com.example.nikhil.roomdatabase3;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by NIKHIL on 18-05-2018.
 */

//This class represent database, so we represent it with annotation "@Databse"
//Note "@Database" annotation need two things:
// 1) entities - This represent the class that represent the table. Here in our case we have one table represented by User.class.
// 2) version = Version of database ex 1 .

@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {


    public abstract DaoClass daoClass();



}
