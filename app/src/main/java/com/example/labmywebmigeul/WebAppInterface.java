package com.example.labmywebmigeul;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.Button;
import android.widget.Toast;

public class WebAppInterface {

    Context context;
    android.app.AlertDialog.Builder builder1;
    AlertDialog alert;
    WebAppInterface(Context c){
        context = c;
    }

    @JavascriptInterface
    public void showToastMessage(String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void showToastMessage2(String message){
       // Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
        Ver();
    }

    private  void  Ver(){
        builder1 = new AlertDialog.Builder(context);
        Button btcerrrar;

        View v = LayoutInflater.from(context).inflate(R.layout.dialogo, null);

        builder1.setView(v);


        alert  = builder1.create();
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        alert.show();
    }
}
