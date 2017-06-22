package com.example.shree.materialdesign8;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;


import com.example.shree.materialdesign8.vinod.navigationdrawer.Dashboard;
import com.example.shree.materialdesign8.vinod1.alertregistration.LoginAlert;
import com.example.shree.materialdesign8.vinod11.editprofile.RegisterProfile;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.ShowDetailsActivity;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.Specility;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter;
import com.maksim88.passwordedittext.PasswordEditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Otp extends AppCompatActivity {

    String Dfname,Dlname,Dcity,Dmob;
    final Context c = this;
    PasswordEditText pwText,repwText;
    EditText Inputuser,Email;
    AutoCompleteTextView acTextView;
    MultiAutoCompleteTextView auto;
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

/*
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.user_input_dialog_box,null);
                final AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

               */
/* final EditText userInputDialogEditText = (EditText) mView.findViewById(R.id.userInputDialog);
                final EditText uname=(EditText)mView.findViewById(R.id.userInputDialog);
                final EditText ulastname=(EditText)mView.findViewById(R.id.userlastname);
                final EditText ucity=(EditText)mView.findViewById(R.id.usercity);
                final EditText uregistration=(EditText)mView.findViewById(R.id.userregistration);
*//*

                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                // ToDo get user input here


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
*/
                final CharSequence[] items = {"Allopathic Doctor", "Ayush Medicine Practitioner","Homeopathy","Undergraduate Student","Siddha Medicine","Vetrinary Doctor","Other"};

                AlertDialog.Builder builder = new AlertDialog.Builder(Otp.this);

                builder.setTitle("I Am-");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (items[item].equals("Allopathic Doctor")) {


                            LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                            View mView = layoutInflaterAndroid.inflate(R.layout.allopathic, null);
                            AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                            alertDialogBuilderUserInput.setView(mView);

                            Inputuser =(EditText)mView.findViewById(R.id.userInputUname);
                            Email =(EditText)mView.findViewById(R.id.userInputemail);
                            pwText = (PasswordEditText) mView.findViewById(R.id.input_password);
                            repwText = (PasswordEditText) mView.findViewById(R.id.input_password2);
                             acTextView = (AutoCompleteTextView) mView.findViewById(R.id.userInputDialog);
                            acTextView.setAdapter(new SuggestionAdapter(Otp.this, acTextView.getText().toString()));
                            /*AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.userInputDialog);
                            acTextView.setAdapter(new SuggestionAdapter(Otp.this,acTextView.getText().toString()));
*/
                           auto = (MultiAutoCompleteTextView) mView.findViewById(R.id.subspeciality);

                            auto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
                            auto.setThreshold(1);
                            auto.setAdapter(new SuggestionAdapter(Otp.this, auto.getText().toString()));


                                alertDialogBuilderUserInput
                                        .setCancelable(false)
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialogBox, int id) {
                                                // ToDo get user input here

                                                if (TextUtils.isEmpty(pwText.getText().toString())) {
                                                    pwText.setError("Please Enter UserName & Password.");
                                                    Toast.makeText(c,"Please EnterUsername & Password.",Toast.LENGTH_LONG).show();
                                                    pwText.requestFocus();
                                                    return;
                                                }
                                                else
                                                {

                                                }
                                                LayoutInflater layoutInflaterAndroid1 = LayoutInflater.from(c);
                                                View mView = layoutInflaterAndroid1.inflate(R.layout.addressactivity, null);
                                                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                                                alertDialogBuilderUserInput.setView(mView);

                                                alertDialogBuilderUserInput
                                                        .setCancelable(false)
                                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                            public void onClick(DialogInterface dialogBox, int id) {
                                                                // ToDo get user input here
                                                                SharedPreferences prefs = getSharedPreferences(LoginAlert.OTP, MODE_PRIVATE);
                                                                String restoredText = prefs.getString("text", null);
                                                                Dfname = prefs.getString("name1", null);
                                                                Dlname = prefs.getString("lastname",null);
                                                                Dcity =prefs.getString("city",null);
                                                                Dmob =prefs.getString("mobile",null);


                                                                insertuser();

                                                                AlertDialog.Builder builder = new AlertDialog.Builder(Otp.this);
                                                                builder.setTitle("Registration Complete..!!");
                                                                builder.setCancelable(true);
                                                                builder.setMessage(getResources().getString(R.string.registration));
                                                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(DialogInterface dialog, int which) {
                                                                        Intent i = new Intent(Otp.this, Login.class);
                                                                        startActivity(i);
                                                                    }
                                                                });
                                                                builder.setNegativeButton("Cancel", null);
                                                                builder.show();

                                                            }

                                                            private void insertuser() {

                                                                RestAdapter adapter = new RestAdapter.Builder()
                                                                        .setEndpoint(ROOT_URL) //Setting the Root URL
                                                                        .build(); //Finally building the adapter

                                                                //Creating object for our interface
                                                                RegisterAPI1 api = adapter.create(RegisterAPI1.class);
//Hi 
                                                                api.insertUser(Dfname.toString(),
                                                                        Dlname.toString(),
                                                                        Dmob.toString(),
                                                                        Dcity.toString(),
                                                                        Dfname.toString(),
                                                                        "Allopathic Doctor",
                                                                        acTextView.getText().toString(),
                                                                        auto.getText().toString(),
                                                                        Inputuser.getText().toString(),
                                                                        Email.getText().toString(),
                                                                        pwText.getText().toString(),
                                                                        repwText.getText().toString(),
                                                                        //
                                                                        new Callback<Response>() {
                                                                            @Override
                                                                            public void success(Response result, Response response2) {
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
                                                                                Toast.makeText(Otp.this, error.toString(),Toast.LENGTH_LONG).show();
                                                                            }
                                                                        });

                                                            }





                                                        });

                                                alertDialogBuilderUserInput.setNeutralButton("Cancel",
                                                        new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialog, int id) {
                                                                dialog.cancel();
                                                            }
                                                        });


                                                alertDialogBuilderUserInput.setNegativeButton("Skip",
                                                                new DialogInterface.OnClickListener() {

                                                                    public void onClick(DialogInterface dialogBox, int id) {

                                                                        AlertDialog.Builder builder = new AlertDialog.Builder(Otp.this);
                                                                        builder.setTitle("Registration Complete..!!");
                                                                        builder.setCancelable(true);
                                                                        builder.setMessage(getResources().getString(R.string.registration));
                                                                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(DialogInterface dialog, int which) {
                                                                                Intent i = new Intent(Otp.this, Login.class);
                                                                                startActivity(i);
                                                                            }
                                                                        });
                                                                        builder.setNegativeButton("Cancel", null);
                                                                        builder.show();
                                                                    }
                                                                });


                                                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                                                alertDialogAndroid.show();

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




                        else if (items[item].equals("Ayush Medicine Practitioner"))
                        {




                            //Intent i=new Intent(LoginAlert.this, SpecilityAyush1.class);
                            //startActivity(i);

                            LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                            View mView = layoutInflaterAndroid.inflate(R.layout.ayush, null);
                            AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                            alertDialogBuilderUserInput.setView(mView);

                            alertDialogBuilderUserInput
                                    .setCancelable(false)
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogBox, int id) {
                                            // ToDo get user input here

                                            LayoutInflater layoutInflaterAndroid1 = LayoutInflater.from(c);
                                            View mView = layoutInflaterAndroid1.inflate(R.layout.addressactivity, null);
                                            AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                                            alertDialogBuilderUserInput.setView(mView);

                                            alertDialogBuilderUserInput
                                                    .setCancelable(false)
                                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialogBox, int id) {
                                                            // ToDo get user input here

                                                            AlertDialog.Builder builder = new AlertDialog.Builder(Otp.this);
                                                            builder.setTitle("Registration Complete..!!");
                                                            builder.setCancelable(true);
                                                            builder.setMessage(getResources().getString(R.string.registration));
                                                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                    Intent i = new Intent(Otp.this, Login.class);
                                                                    startActivity(i);
                                                                }
                                                            });
                                                            builder.setNegativeButton("Cancel", null);
                                                            builder.show();

                                                        }
                                                    });

                                            alertDialogBuilderUserInput.setNeutralButton("Cancel",
                                                    new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int id) {
                                                            dialog.cancel();

                                                        }
                                                    });

                                            alertDialogBuilderUserInput.setNegativeButton("Skip",
                                                            new DialogInterface.OnClickListener() {
                                                                public void onClick(DialogInterface dialogBox, int id) {

                                                                    AlertDialog.Builder builder = new AlertDialog.Builder(Otp.this);
                                                                    builder.setTitle("Registration Complete..!!");
                                                                    builder.setCancelable(true);
                                                                    builder.setMessage(getResources().getString(R.string.registration));
                                                                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                        @Override
                                                                        public void onClick(DialogInterface dialog, int which) {
                                                                            Intent i = new Intent(Otp.this, Login.class);
                                                                            startActivity(i);
                                                                        }
                                                                    });
                                                                    builder.setNegativeButton("Cancel", null);
                                                                    builder.show();
                                                                }
                                                            });



                                            AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                                            alertDialogAndroid.show();

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

                        else if (items[item].equals("Homeopathy")) {


                            //Intent i=new Intent(LoginAlert.this, SpecilityHomopathic.class);
                            //startActivity(i);

                            LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                            View mView = layoutInflaterAndroid.inflate(R.layout.homeopathy, null);
                            AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                            alertDialogBuilderUserInput.setView(mView);

                            alertDialogBuilderUserInput
                                    .setCancelable(false)
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogBox, int id) {
                                            // ToDo get user input here

                                            LayoutInflater layoutInflaterAndroid1 = LayoutInflater.from(c);
                                            View mView = layoutInflaterAndroid1.inflate(R.layout.addressactivity, null);
                                            AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                                            alertDialogBuilderUserInput.setView(mView);

                                            alertDialogBuilderUserInput
                                                    .setCancelable(false)
                                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialogBox, int id) {
                                                            // ToDo get user input here

                                                            AlertDialog.Builder builder = new AlertDialog.Builder(Otp.this);
                                                            builder.setTitle("Registration Complete..!!");
                                                            builder.setCancelable(true);
                                                            builder.setMessage(getResources().getString(R.string.registration));
                                                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                    Intent i = new Intent(Otp.this, Login.class);
                                                                    startActivity(i);
                                                                }
                                                            });
                                                            builder.setNegativeButton("Cancel", null);
                                                            builder.show();

                                                        }
                                                    });

                                            alertDialogBuilderUserInput.setNeutralButton("Cancel",
                                                    new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int id) {
                                                            dialog.cancel();

                                                        }
                                                    });

                                            alertDialogBuilderUserInput.setNegativeButton("Skip",
                                                            new DialogInterface.OnClickListener() {
                                                                public void onClick(DialogInterface dialogBox, int id) {

                                                                    AlertDialog.Builder builder = new AlertDialog.Builder(Otp.this);
                                                                    builder.setTitle("Registration Complete..!!");
                                                                    builder.setCancelable(true);
                                                                    builder.setMessage(getResources().getString(R.string.registration));
                                                                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                        @Override
                                                                        public void onClick(DialogInterface dialog, int which) {
                                                                            Intent i = new Intent(Otp.this, Login.class);
                                                                            startActivity(i);
                                                                        }
                                                                    });
                                                                    builder.setNegativeButton("Cancel", null);
                                                                    builder.show();

                                                                }
                                                            });


                                            AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                                            alertDialogAndroid.show();

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

                        else if (items[item].equals("Undergraduate Student")) {

                            //Intent i=new Intent(LoginAlert.this, SelectQualification.class);
                            //startActivity(i);

                            LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                            View mView = layoutInflaterAndroid.inflate(R.layout.undergraduate, null);
                            AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                            alertDialogBuilderUserInput.setView(mView);

                            alertDialogBuilderUserInput
                                    .setCancelable(false)
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogBox, int id) {
                                            // ToDo get user input here

                                            LayoutInflater layoutInflaterAndroid1 = LayoutInflater.from(c);
                                            View mView = layoutInflaterAndroid1.inflate(R.layout.addressactivity, null);
                                            AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                                            alertDialogBuilderUserInput.setView(mView);

                                            alertDialogBuilderUserInput
                                                    .setCancelable(false)
                                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialogBox, int id) {
                                                            // ToDo get user input here

                                                            AlertDialog.Builder builder = new AlertDialog.Builder(Otp.this);
                                                            builder.setTitle("Registration Complete..!!");
                                                            builder.setCancelable(true);
                                                            builder.setMessage(getResources().getString(R.string.registration));
                                                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                    Intent i = new Intent(Otp.this, Login.class);
                                                                    startActivity(i);
                                                                }
                                                            });
                                                            builder.setNegativeButton("Cancel", null);
                                                            builder.show();
                                                        }
                                                    });

                                            alertDialogBuilderUserInput.setNeutralButton("Cancel",
                                                    new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int id) {

                                                            dialog.cancel();
                                                        }
                                                    });

                                            alertDialogBuilderUserInput.setNegativeButton("Skip",
                                                            new DialogInterface.OnClickListener() {
                                                                public void onClick(DialogInterface dialogBox, int id) {


                                                                    AlertDialog.Builder builder = new AlertDialog.Builder(Otp.this);
                                                                    builder.setTitle("Registration Complete..!!");
                                                                    builder.setCancelable(true);
                                                                    builder.setMessage(getResources().getString(R.string.registration));
                                                                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                        @Override
                                                                        public void onClick(DialogInterface dialog, int which) {
                                                                            Intent i = new Intent(Otp.this, Login.class);
                                                                            startActivity(i);
                                                                        }
                                                                    });
                                                                    builder.setNegativeButton("Cancel", null);
                                                                    builder.show();

                                                                }
                                                            });



                                            AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                                            alertDialogAndroid.show();

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
                        else if (items[item].equals("Siddha Medicine")) {

                            //Intent i=new Intent(LoginAlert.this, SpecilitySiddha.class);
                            //startActivity(i);

                            LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                            View mView = layoutInflaterAndroid.inflate(R.layout.siddha, null);
                            AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                            alertDialogBuilderUserInput.setView(mView);

                            alertDialogBuilderUserInput
                                    .setCancelable(false)
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogBox, int id) {
                                            // ToDo get user input here

                                            LayoutInflater layoutInflaterAndroid1 = LayoutInflater.from(c);
                                            View mView = layoutInflaterAndroid1.inflate(R.layout.addressactivity, null);
                                            AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                                            alertDialogBuilderUserInput.setView(mView);

                                            alertDialogBuilderUserInput
                                                    .setCancelable(false)
                                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialogBox, int id) {
                                                            // ToDo get user input here

                                                            AlertDialog.Builder builder = new AlertDialog.Builder(Otp.this);
                                                            builder.setTitle("Registration Complete..!!");
                                                            builder.setCancelable(true);
                                                            builder.setMessage(getResources().getString(R.string.registration));
                                                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                    Intent i = new Intent(Otp.this, Login.class);
                                                                    startActivity(i);
                                                                }
                                                            });
                                                            builder.setNegativeButton("Cancel", null);
                                                            builder.show();

                                                        }
                                                    });

                                            alertDialogBuilderUserInput.setNeutralButton("Cancel",
                                                    new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int id) {

                                                            dialog.cancel();
                                                        }
                                                    });

                                            alertDialogBuilderUserInput.setNegativeButton("Skip",
                                                            new DialogInterface.OnClickListener() {
                                                                public void onClick(DialogInterface dialogBox, int id) {

                                                                    AlertDialog.Builder builder = new AlertDialog.Builder(Otp.this);
                                                                    builder.setTitle("Registration Complete..!!");
                                                                    builder.setCancelable(true);
                                                                    builder.setMessage(getResources().getString(R.string.registration));
                                                                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                        @Override
                                                                        public void onClick(DialogInterface dialog, int which) {
                                                                            Intent i = new Intent(Otp.this, Login.class);
                                                                            startActivity(i);
                                                                        }
                                                                    });
                                                                    builder.setNegativeButton("Cancel", null);
                                                                    builder.show();


                                                                }
                                                            });



                                            AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                                            alertDialogAndroid.show();

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
                        else if (items[item].equals("Vetrinary Doctor")) {


                            // Intent i=new Intent(LoginAlert.this, SpecilityVetrinary.class);
                            //startActivity(i);

                            LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                            View mView = layoutInflaterAndroid.inflate(R.layout.vertrinary, null);
                            AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                            alertDialogBuilderUserInput.setView(mView);

                            alertDialogBuilderUserInput
                                    .setCancelable(false)
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogBox, int id) {
                                            // ToDo get user input here

                                            LayoutInflater layoutInflaterAndroid1 = LayoutInflater.from(c);
                                            View mView = layoutInflaterAndroid1.inflate(R.layout.addressactivity, null);
                                            AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                                            alertDialogBuilderUserInput.setView(mView);

                                            alertDialogBuilderUserInput
                                                    .setCancelable(false)
                                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialogBox, int id) {
                                                            // ToDo get user input here

                                                            AlertDialog.Builder builder = new AlertDialog.Builder(Otp.this);
                                                            builder.setTitle("Registration Complete..!!");
                                                            builder.setCancelable(true);
                                                            builder.setMessage(getResources().getString(R.string.registration));
                                                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                    Intent i = new Intent(Otp.this, Login.class);
                                                                    startActivity(i);
                                                                }
                                                            });
                                                            builder.setNegativeButton("Cancel", null);
                                                            builder.show();

                                                        }
                                                    });

                                            alertDialogBuilderUserInput.setNeutralButton("Cancel",
                                                    new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int id) {
                                                            dialog.cancel();
                                                        }
                                                    });

                                            alertDialogBuilderUserInput.setNegativeButton("Skip",
                                                            new DialogInterface.OnClickListener() {
                                                                public void onClick(DialogInterface dialogBox, int id) {

                                                                    AlertDialog.Builder builder = new AlertDialog.Builder(Otp.this);
                                                                    builder.setTitle("Registration Complete..!!");
                                                                    builder.setCancelable(true);
                                                                    builder.setMessage(getResources().getString(R.string.registration));
                                                                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                        @Override
                                                                        public void onClick(DialogInterface dialog, int which) {
                                                                            Intent i = new Intent(Otp.this, Login.class);
                                                                            startActivity(i);
                                                                        }
                                                                    });
                                                                    builder.setNegativeButton("Cancel", null);
                                                                    builder.show();

                                                                }
                                                            });


                                            AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                                            alertDialogAndroid.show();

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
                        else if (items[item].equals("Other")) {
                            //dialog.dismiss();

                            LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                            View mView = layoutInflaterAndroid.inflate(R.layout.other, null);
                            AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                            alertDialogBuilderUserInput.setView(mView);

                            alertDialogBuilderUserInput
                                    .setCancelable(false)
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogBox, int id) {
                                            // ToDo get user input here

                                            LayoutInflater layoutInflaterAndroid1 = LayoutInflater.from(c);
                                            View mView = layoutInflaterAndroid1.inflate(R.layout.addressactivity, null);
                                            AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                                            alertDialogBuilderUserInput.setView(mView);

                                            alertDialogBuilderUserInput
                                                    .setCancelable(false)
                                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialogBox, int id) {
                                                            // ToDo get user input here

                                                            AlertDialog.Builder builder = new AlertDialog.Builder(Otp.this);
                                                            builder.setTitle("Registration Complete..!!");
                                                            builder.setCancelable(true);
                                                            builder.setMessage(getResources().getString(R.string.registration));
                                                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                    Intent i = new Intent(Otp.this, Login.class);
                                                                    startActivity(i);
                                                                }
                                                            });
                                                            builder.setNegativeButton("Cancel", null);
                                                            builder.show();

                                                        }
                                                    });

                                            alertDialogBuilderUserInput.setNeutralButton("Cancel",
                                                    new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int id) {
                                                            dialog.cancel();
                                                        }
                                                    });

                                            alertDialogBuilderUserInput.setNegativeButton("Skip",
                                                    new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialogBox, int id) {

                                                            AlertDialog.Builder builder = new AlertDialog.Builder(Otp.this);
                                                            builder.setTitle("Registration Complete..!!");
                                                            builder.setCancelable(true);
                                                            builder.setMessage(getResources().getString(R.string.registration));
                                                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                    Intent i = new Intent(Otp.this, Login.class);
                                                                    startActivity(i);
                                                                }
                                                            });
                                                            builder.setNegativeButton("Cancel", null);
                                                            builder.show();

                                                        }
                                                    });


                                            AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                                            alertDialogAndroid.show();

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
                    }
                });
                builder.show();
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
