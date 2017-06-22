package com.example.shree.materialdesign8.vinod.SqliteFav;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shree.materialdesign8.R;
import com.example.shree.materialdesign8.vinod.confirmation.ConfirmationMassage;

public class ShowDb extends AppCompatActivity {

    SQLiteHelper SQLITEHELPER;
    SQLiteDatabase SQLITEDATABASE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_db);
        Button bLosuj = (Button) findViewById(R.id.button1);
        bLosuj.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                TextView tekst = (TextView) findViewById(R.id.editText1);
                StringBuffer b=new StringBuffer();
                SQLITEHELPER = new SQLiteHelper(getApplicationContext());
                Cursor res=SQLITEHELPER.getAll();
                if (res != null)

                while (res.moveToNext())
                {
                   // b.append(res.getString(0));
                    b.append(res.getString(1));
                    b.append("\n");
//                   /* String a=res.getString(0);
//                    String b =res.getString(1);*/
                }


              //  String[] text = SQLITEHELPER.getAppCategoryDetail(); //this is the method to query

                SQLITEHELPER.close();
                // set text to your TextView
                // set text to your TextView
                //tekst.setText(b.toString());\

                Bundle c=new Bundle();
                c.getString("abc",b.toString());
                Intent a=new Intent(ShowDb.this,ConfirmationMassage.class);
                a.putExtras(c);
                startActivity(a);
                Toast.makeText(ShowDb.this,"you "+b.toString(),Toast.LENGTH_LONG).show();


            }
        });
    }
}
