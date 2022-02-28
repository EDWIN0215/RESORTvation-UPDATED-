package ucucite.edu.resortvations;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Payments extends AppCompatActivity {

    EditText resort1,resort2,resort3,resort4,resort5;
    Button confirmbtn;
    EditText fullname,date_in,gcashnumber,pincode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);
        this.setTitle("Payment Method");


        resort1=findViewById(R.id.resort1);
        resort2=findViewById(R.id.resort2);
        resort3=findViewById(R.id.resort3);
        resort4=findViewById(R.id.resort4);
        resort5=findViewById(R.id.resort5);
        confirmbtn=findViewById(R.id.confirmbtn);

        fullname=findViewById(R.id.fullname);
        date_in=findViewById(R.id.day);
        gcashnumber=findViewById(R.id.gcashnumber);
        pincode=findViewById(R.id.pincode);


        date_in.setInputType(InputType.TYPE_NULL);
        date_in.setFocusable(false);

        date_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(date_in);
            }
        });


        Intent intent1 = getIntent();
        String str1 = intent1.getStringExtra("message1");
        resort1.setText(str1);

        Intent intent2 = getIntent();
        String str2 = intent2.getStringExtra("message2");
        resort2.setText(str2);

        Intent intent3 = getIntent();
        String str3 = intent3.getStringExtra("message3");
        resort3.setText(str3);

        Intent intent4 = getIntent();
        String str4 = intent4.getStringExtra("message4");
        resort4.setText(str4);

        Intent intent5 = getIntent();
        String str5 = intent5.getStringExtra("message5");
        resort5.setText(str5);

        confirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String val_fullname = fullname.getText().toString().trim();
                String val_date = date_in.getText().toString().trim();
                String val_gcashnumber = gcashnumber.getText().toString().trim();
                String val_pincode = pincode.getText().toString().trim();


                if (TextUtils.isEmpty(val_fullname)) {
                    fullname.setError("Full Name is Required!");
                    return;
                }

                if (TextUtils.isEmpty(val_date)) {
                    date_in.setError("Date is required!");
                    return;
                }

                if (TextUtils.isEmpty(val_gcashnumber)) {
                    gcashnumber.setError("Gcash Number is required!");
                    return;
                }

                if (val_gcashnumber.length() < 11) {
                    gcashnumber.setError("Must be 11 numbers!");
                    return;
                }

                if (val_gcashnumber.length() > 11) {
                    gcashnumber.setError("Must be 11 numbers!");
                    return;
                }

                if (val_pincode.length() < 4) {
                    pincode.setError("Must be 4 numbers!");
                    return;
                }

                if (val_pincode.length() > 4) {
                    pincode.setError("Must be 4 numbers!");
                    return;
                }

                String res1 = resort1.getText().toString();
                String res2 = resort2.getText().toString();
                String res3 = resort3.getText().toString();
                String res4 = resort4.getText().toString();
                String res5 = resort5.getText().toString();
                String fname = fullname.getText().toString();
                String fdate = date_in.getText().toString();
                String fgcashnumber = gcashnumber.getText().toString();

                Bundle args = new Bundle();
                args.putString("message1", res1);
                args.putString("message2", res2);
                args.putString("message3", res3);
                args.putString("message4", res4);
                args.putString("message5", res5);
                args.putString("message6", fname);
                args.putString("message7", fdate);
                args.putString("message8", fgcashnumber);

                ExampleDialog dialog=new ExampleDialog();
                dialog.setArguments(args);
                dialog.show(getSupportFragmentManager(),"dialog");
            }
        });

    }

    private void showDateDialog(final EditText date_in) {
        final Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MMM d, yyyy E");
                date_in.setText(simpleDateFormat.format(calendar.getTime()));

            }
        };

        new DatePickerDialog(Payments.this,dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }
}