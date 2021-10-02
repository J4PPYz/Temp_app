package com.example.temp_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button ansBtn,againBtn;
    TextView ShowAns;
    EditText getVal;
    RadioButton c2f,f2c;
    Double x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ansBtn = (Button) findViewById(R.id.ansBtn);
        againBtn = (Button) findViewById(R.id.againBtn);
        ShowAns = (TextView) findViewById(R.id.ShowAns);
        getVal = (EditText) findViewById(R.id.getVal);
        c2f = (RadioButton) findViewById(R.id.c2f);
        f2c = (RadioButton) findViewById(R.id.f2c);
        ansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getVal.getText().toString().isEmpty()){
                    ShowAns.setText(" -โปรดใส่อุณหภูมฺที่ต้องการคำนวณ- ");
                }
                else{
                    x = Double.parseDouble(String.valueOf(getVal.getText()));
                    if (c2f.isChecked()){
                        x = (x*9)/5+32;
                        x =Double.parseDouble(new DecimalFormat("##.###").format(x));
                        ShowAns.setText(String.valueOf(x) + "องศาฟาเรนไฮต์");
                    }
                    else if (f2c.isChecked()){
                        x = (x-32)*5/9;
                        x =Double.parseDouble(new DecimalFormat("##.###").format(x));
                        ShowAns.setText(String.valueOf(x) + "องศาเซลเซียส");
                    }
                    else{
                        ShowAns.setText("-โปรดเลือกหน่วยอุณหภูมิที่ต้องการแปลง-");
                    }

                }
            }
        });
        againBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowAns.setText("โปรดใส่อุณหภูมิใหม่");
                getVal.setText("");
                c2f.setChecked(false);
                f2c.setChecked(false);
            }
        });
    }
}