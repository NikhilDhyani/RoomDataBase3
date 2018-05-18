package com.example.nikhil.roomdatabase3;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText name;
    EditText email;

    //Here we are creating a variable of type AppDatabase
    public static AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"userdb").build();

        name = findViewById(R.id.ed2);
        email = findViewById(R.id.ed3);

        String myname = name.getText().toString();
        String myemail = email.getText().toString();


          User user = new User();

       user.setName(myname);
       user.setEmail(myemail);



       //appDatabase.daoClass().addUser(user);

        //Toast.makeText(getApplicationContext(),"User added",Toast.LENGTH_LONG).show();

        //name.setText("");
        //email.setText("");
        insertUser(user);

    }

    public void insertUser(final User user) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void...voids) {

                appDatabase.daoClass().addUser(user);



                return null;
            }
        }.execute();



    }



}
