package com.example.currency2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText edNtd;
    private Button btGo;
    private  static  double exchangerate= 30.9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        btGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String ntd  =  edNtd.getText().toString();
                //如果是空值
                if (ntd.isEmpty()){
                    new AlertDialog.Builder(MainActivity.this).setTitle("Problem").setMessage("Please enter you NTD amount").setPositiveButton("OK",null).show();
                }else {
                    double us   =  Double.parseDouble(ntd)/exchangerate;
                    DecimalFormat df = new DecimalFormat("#.0000");
                    us=Double.parseDouble(df.format(us));

                    new AlertDialog.Builder(MainActivity.this).setTitle("Result").setMessage("USD is "+us).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                           if (!edNtd.getText().toString().isEmpty()){
                               edNtd.setText("");
                           }
                        }
                    }).show();
                }
            }
        });
    }

    private void findViews() {
        edNtd = findViewById(R.id.edNtd);
        btGo = findViewById(R.id.btGo);
    }


}
