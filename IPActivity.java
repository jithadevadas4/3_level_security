package com.aumento.there_level_atm_security;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.aumento.there_level_atm_security.utils.GlobalPreference;

public class IPActivity extends AppCompatActivity {

    final Context c = this;
    GlobalPreference mGlobalPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGlobalPreference= new GlobalPreference(getApplicationContext());
        getIP();

    }

    public void getIP(){


        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
        View mView = layoutInflaterAndroid.inflate(R.layout.user_input_dialog_box, null);
        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
        alertDialogBuilderUserInput.setView(mView);
        final EditText userInputDialogEditText = mView.findViewById(R.id.userInputDialog);
        userInputDialogEditText.setText(mGlobalPreference.RetriveIP());

        alertDialogBuilderUserInput
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogBox, int id) {

                        mGlobalPreference.addIP(userInputDialogEditText.getText().toString());
                        //startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        userInputDialogEditText.setText(userInputDialogEditText.getText().toString());

                        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                        finish();


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

