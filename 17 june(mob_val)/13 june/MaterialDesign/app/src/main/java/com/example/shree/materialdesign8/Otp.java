package com.example.shree.materialdesign8;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.shree.materialdesign8.vinod.navigationdrawer.Dashboard;
import com.example.shree.materialdesign8.vinod1.alertregistration.LoginAlert;
import com.example.shree.materialdesign8.vinod11.editprofile.RegisterProfile;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.ShowDetailsActivity;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.Specility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Otp extends AppCompatActivity {
    final Context c = this;

    public static final String OTP = "Myotp";
    public static final String ROOT_URL = "http://35.154.210.22/";

    //public static final String ENAME="ename";
   // public static final String ELNAME="elname";
   // public static final String ECITY="ecity";
   // public static final String EREGISTNUM="registnum";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);



        Button b=(Button) findViewById(R.id.dashboard);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   Intent i=new Intent(Otp.this, Dashboard.class);
                startActivity(i);*/
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.user_input_dialog_box,null);
                final AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

                final EditText userInputDialogEditText = (EditText) mView.findViewById(R.id.userInputDialog);
                final EditText uname=(EditText)mView.findViewById(R.id.userInputDialog);
                final EditText ulastname=(EditText)mView.findViewById(R.id.userlastname);
                final EditText ucity=(EditText)mView.findViewById(R.id.usercity);
                final EditText uregistration=(EditText)mView.findViewById(R.id.userregistration);

                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                // ToDo get user input here

                                SharedPreferences prefs = getSharedPreferences(LoginAlert.MY_PREFS_MOBILE, MODE_PRIVATE);
                                String restoredText = prefs.getString("text", null);
                                String mobile=prefs.getString("mobile", null);
                                String ald=prefs.getString("ald", null);
                                if (restoredText != null) {
                                    String name = prefs.getString("mobile", "No value defined");//"No name defined" is the default value.
                                    String name1 = prefs.getString("aid", "No value defined");
                                }
                               mobile.toString();
                                ald.toString();


                                SharedPreferences prefs1 = getSharedPreferences(Specility.MY_PREFS_SPEC, MODE_PRIVATE);
                                String restoredText1 = prefs1.getString("text", null);
                                String spec=prefs1.getString("spec", null);

                                if (restoredText1 != null) {
                                    String name2 = prefs1.getString("spec", "No value defined");//"No name defined" is the default value.

                                }

                                spec.toString();

                                SharedPreferences prefs2 = getSharedPreferences(ShowDetailsActivity.MY_PREFS_SUBSEPC, MODE_PRIVATE);
                                String restoredText2 = prefs2.getString("text", null);
                                String spec2=prefs2.getString("subspec", null);

                                if (restoredText2 != null) {
                                    String name3 = prefs2.getString("subspec", "No value defined");//"No name defined" is the default value.

                                }

                                spec2.toString();
                                    try
                                    { if(userInputDialogEditText.getText().toString() == null || userInputDialogEditText.getText().toString().length() == 0)
                                    {

                                       Toast.makeText(Otp.this,"please enter valid name",Toast.LENGTH_LONG).show();
                                        userInputDialogEditText.setError("enter name");
                                        // 3. Get the AlertDialogfrom create()
                                       /* AlertDialog dialogsnd = alertDialogBuilderUserInput.create();

                                        // 4. Show dialog
                                        dialogsnd.show();*/

                                        AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                                        alertDialogAndroid.dismiss();


                                    }
                                    else
                                    {

                                        RestAdapter adapter = new RestAdapter.Builder()
                                                .setEndpoint(ROOT_URL) //Setting the Root URL
                                                .build(); //Finally building the adapter

                                        //Creating object for our interface
                                        RegisterAPI1 api = adapter.create(RegisterAPI1.class);

                                        //Defining the method insertuser of our interface
                                        api.insertUser(

                                                //Passing the values by getting it from editTexts
                                                userInputDialogEditText.getText().toString(),
                                                ulastname.getText().toString(),
                                                ucity.getText().toString(),
                                                uregistration.getText().toString(),
                                                mobile.toString(),
                                                ald.toString(),
                                                spec.toString(),
                                                spec2.toString(),

                                                //Creating an anonymous callback
                                                new Callback<Response>() {
                                                    @Override
                                                    public void success(Response result, Response response) {
                                                        //On success we will read the server's output using bufferedreader
                                                        //Creating a bufferedreader object
                                                        BufferedReader reader = null;

                                                        //An string to store output from the server
                                                        String output = "";

                                                        try {
                                                            //Initializing buffered reader
                                                            reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                                                            //Reading the output in the string
                                                            output = reader.readLine();
                                                        } catch (IOException e) {
                                                            e.printStackTrace();
                                                        }

                                                        //Displaying the output as a toast
                                                        Toast.makeText(Otp.this, output, Toast.LENGTH_LONG).show();
                                                    }

                                                    @Override
                                                    public void failure(RetrofitError error) {
                                                        //If any error occured displaying the error as toast
                                                        Toast.makeText(Otp.this, error.toString(),Toast.LENGTH_LONG).show();
                                                    }
                                                });
                                        SharedPreferences.Editor editor = getSharedPreferences(OTP, MODE_PRIVATE).edit();
                                        editor.putString("name", userInputDialogEditText.getText().toString());
                                        //editor.putInt("idName", 12);
                                        editor.commit();

                                        //final EditText fname=(EditText)findViewById(R.id.userInputDialog);
                                        //Intent i=new Intent(Otp.this, Dashboard.class);
                                        //startActivity(i);


                                        //Intent I=new Intent(Otp.this, Dashboard.class);
                                        //startActivity(I);
                                        editor.putString("name1", uname.getText().toString());
                                        editor.putString("lastname", ulastname.getText().toString());
                                        editor.putString("city", ucity.getText().toString());
                                        editor.putString("registration", uregistration.getText().toString());
                                        editor.commit();

                                        Intent intent = new Intent(Otp.this, Dashboard.class);
                                        startActivity(intent);

                                    }



                                    }
                                    catch (Exception e)
                                    {
                                        e.printStackTrace();
                                    }

                            }
                        })

                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        dialogBox.cancel();
                                    }
                                });

                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.show();


            }
        });


    }
    void showtoast(String title,String message)
    {
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setCancelable(true);
        b.setMessage(message);
        b.show();
    }
}
