package ucucite.edu.resortvations;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private EditText mEmail, mPassword;
    private Button   mLoginBtn;
    private TextView mCreateBtn;
    private ProgressBar progressBar;

    FirebaseAuth mAuth;


    private FirebaseAuth fAuth;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mEmail      = (EditText)    findViewById(R.id.Email);
        mPassword   = (EditText)    findViewById(R.id.password);
        mLoginBtn   = (Button)      findViewById(R.id.loginBtn);
        mCreateBtn  = (TextView)    findViewById(R.id.createText);
        progressBar = findViewById(R.id.progressBar2);



//        passButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String str = mEmail.getText().toString();
//                String str2 = mPassword.getText().toString();
//
//
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                intent.putExtra("message", str);
//                intent.putExtra("message1", str2);
//
//                startActivity(intent);
//            }
//        });




        mAuth = FirebaseAuth.getInstance();

        fAuth = FirebaseAuth.getInstance();

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();


                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is required");
                    return;
                }

                if(password.length()<8){
                    mPassword.setError("Password must be >= 8 Characters");
                    return;
                }


                // authenticate the user
                progressBar.setVisibility(View.VISIBLE);
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this,"Logged in successfully", Toast.LENGTH_SHORT).show();
                            String str = mEmail.getText().toString();
                            String str2 = mPassword.getText().toString();


                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.putExtra("message", str);
                            intent.putExtra("message1", str2);

                            startActivity(intent);
                            progressBar.setVisibility(View.INVISIBLE);

//                          startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        }else{
                            Toast.makeText(Login.this,"Error ! " + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.INVISIBLE);
                        }

                    }
                });
            }
        });

        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });


    }



//    public void login(View view) {
//
//        String email, password;
//
//        email=mEmail.getText().toString().trim();
//        password=mPassword.getText().toString().trim();
//
//        progressBar.setVisibility(View.VISIBLE);
//        mAuth.signInWithEmailAndPassword(email,password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful()){
//                            Intent intent = new Intent(getApplicationContext(),Profile.class);
//                            startActivity(intent);
//                            progressBar.setVisibility(View.INVISIBLE);
//
//                        }else {
//                            Toast.makeText(Login.this, "invalid credentials", Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
//    }
}