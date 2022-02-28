package ucucite.edu.resortvations;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class confirm extends AppCompatActivity {
    private TextView resort1;
    private TextView resort2;
    private TextView resort3;
    private TextView resort4;
    private TextView resort5;
    private TextView fullname;
    private TextView f_date;
    private TextView f_gcashnumber;
    Button gohome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        this.setTitle("Receipt");

        resort1 =findViewById(R.id.confirm_resort1);
        resort2 =findViewById(R.id.confirm_resort2);
        resort3=findViewById(R.id.confirm_resort3);
        resort4=findViewById(R.id.confirm_resort4);
        resort5=findViewById(R.id.confirm_resort5);
        fullname =findViewById(R.id.confirm_fullname);
        f_date =findViewById(R.id.confirm_date);
        f_gcashnumber =findViewById(R.id.confirm_gcashnumber);
        gohome =findViewById(R.id.button2);


        Intent intent = getIntent();
        String s_str1 = intent.getStringExtra("message1");
        String s_str2 = intent.getStringExtra("message2");
        String s_str3 = intent.getStringExtra("message3");
        String s_str4 = intent.getStringExtra("message4");
        String s_str5 = intent.getStringExtra("message5");
        String s_str6 = intent.getStringExtra("message6");
        String s_str7 = intent.getStringExtra("message7");
        String s_str8 = intent.getStringExtra("message8");
        resort1.setText(s_str1);
        resort2.setText(s_str2);
        resort3.setText(s_str3);
        resort4.setText(s_str4);
        resort5.setText(s_str5);
        fullname.setText(s_str6);
        f_date.setText(s_str7);
        f_gcashnumber.setText(s_str8);

        gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}