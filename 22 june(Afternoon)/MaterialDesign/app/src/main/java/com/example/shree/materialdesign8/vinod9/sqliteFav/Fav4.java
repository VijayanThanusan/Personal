package com.example.shree.materialdesign8.vinod9.sqliteFav;


import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shree.materialdesign8.R;
import com.example.shree.materialdesign8.spinnerFav.FavEdit3;
import com.example.shree.materialdesign8.spinnerFav.FavName3;
import com.example.shree.materialdesign8.vinod8.sqliteFav.*;
import com.example.shree.materialdesign8.vinod8.sqliteFav.ListViewActivity;

public class Fav4 extends AppCompatActivity {

    EditText GetName,GetPhoneNumber,GetSubject;
    Button Submit, EditData, DisplayData;
    SQLiteDatabase SQLITEDATABASE;
    String Name, PhoneNumber, Subject ;
    Boolean CheckEditTextEmpty ;
    String SQLiteQuery ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav4);

       /* Button edit3=(Button)findViewById(R.id.button_edit);

        edit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5=new Intent(getApplicationContext(),FavEdit3.class);
                startActivity(intent5);
            }
        });

        Button name3=(Button)findViewById(R.id.button_change);

        name3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6=new Intent(getApplicationContext(),FavName3.class);
                startActivity(intent6);}
        });*/

        GetName = (EditText)findViewById(R.id.editText1);

      /*  GetPhoneNumber = (EditText)findViewById(R.id.editText2);

        GetSubject = (EditText)findViewById(R.id.editText3);*/

        Submit = (Button)findViewById(R.id.button1);

        EditData = (Button)findViewById(R.id.button2);

      //  DisplayData = (Button)findViewById(R.id.button3);

        Submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                DBCreate();

                SubmitData2SQLiteDB();

            }
        });

        EditData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(Fav4.this,EditDataActivity.class);
                startActivity(intent);

            }
        });

       /* DisplayData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(Fav4.this, com.example.shree.materialdesign8.vinod9.sqliteFav.ListViewActivity.class);
                startActivity(intent);

            }
        });*/

    }

    public void DBCreate(){

        SQLITEDATABASE = openOrCreateDatabase("DemoDataBase", Context.MODE_PRIVATE, null);

        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS demoTable19(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name VARCHAR);");
    }

    public void SubmitData2SQLiteDB(){

        Name = GetName.getText().toString();

        /*PhoneNumber = GetPhoneNumber.getText().toString();

        Subject = GetSubject.getText().toString();
        */
        CheckEditTextIsEmptyOrNot(Name);

        if(CheckEditTextEmpty == true)
        {

            SQLiteQuery = "INSERT INTO demoTable19 (name) VALUES('"+Name+"');";

            SQLITEDATABASE.execSQL(SQLiteQuery);

            Toast.makeText(Fav4.this,"Data Submit Successfully", Toast.LENGTH_LONG).show();

            ClearEditTextAfterDoneTask();

        }
        else {

            Toast.makeText(Fav4.this,"Please Fill All the Fields", Toast.LENGTH_LONG).show();
        }
    }

    public void CheckEditTextIsEmptyOrNot(String Name)
    {

        if(TextUtils.isEmpty(Name) )
        {

            CheckEditTextEmpty = false ;

        }
        else
        {
            CheckEditTextEmpty = true ;
        }
    }

    public void ClearEditTextAfterDoneTask()
    {

        GetName.getText().clear();
       /* GetPhoneNumber.getText().clear();
        GetSubject.getText().clear();*/
    }
}
