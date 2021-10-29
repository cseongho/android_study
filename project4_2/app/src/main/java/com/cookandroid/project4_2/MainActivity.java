package com.cookandroid.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    CheckBox chkAgree;
    RadioGroup rGroup1;
    RadioButton rdoA, rdoB, rdoC;
    Button btnOk;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        chkAgree = (CheckBox) findViewById(R.id.ChkAgree);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rdoA = (RadioButton) findViewById(R.id.RdoA);
        rdoB = (RadioButton) findViewById(R.id.RdoB);
        rdoB = (RadioButton) findViewById(R.id.RdoC);

        btnOk = (Button) findViewById(R.id.BtnOk);
        img = (ImageView) findViewById(R.id.Img);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chkAgree.isChecked() == true) {
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnOk.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                } else {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnOk.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                switch(rGroup1.getCheckedRadioButtonId()) {
                    case R.id.RdoA:
                        img.setImageResource(R.drawable.a);
                        break;
                    case R.id.RdoB:
                        img.setImageResource(R.drawable.b);
                        break;
                    case R.id.RdoC:
                        img.setImageResource(R.drawable.c);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "배경을 먼저 선택하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
    }
}