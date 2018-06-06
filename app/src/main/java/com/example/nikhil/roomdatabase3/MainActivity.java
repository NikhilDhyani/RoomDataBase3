package com.example.nikhil.roomdatabase3;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText name;
    EditText email;
    Button button;

    //Here we are creating a variable of type AppDatabase
    public static AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"userdb").build();

        name = findViewById(R.id.ed2);
        email = findViewById(R.id.ed3);
        button = findViewById(R.id.Btn1);


        String myname = name.getText().toString();
        String myemail = email.getText().toString();


          final User user = new User();

       user.setName(myname);
       user.setEmail(myemail);

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               AsyncTaskRunner runner = new AsyncTaskRunner();

               runner.execute(user);


           }
       });



       //appDatabase.daoClass().addUser(user);

        //Toast.makeText(getApplicationContext(),"User added",Toast.LENGTH_LONG).show();

        //name.setText("");
        //email.setText("");
//        insertUser(user);

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


    private class AsyncTaskRunner extends AsyncTask<User, Void, String> {

        private String resp;







        @Override
        protected String doInBackground(User... users) {

            User one = users[0];

            appDatabase.daoClass().addUser(one);


            return null;
        }

        @Override
        protected void onPostExecute(String two) {
            super.onPostExecute(two);
            Toast.makeText(getApplicationContext(),"Added Successfully",Toast.LENGTH_LONG).show();
        }
    }



}
