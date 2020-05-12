package ema.mosis.elfak.rs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class StartActivity extends AppCompatActivity {

    Button btnLogin, btnRegister;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btnLogin = findViewById(R.id.login_start_btn);
        btnRegister = findViewById(R.id.register_start_btn);
        fAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent loginIntent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent registerIntent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        if(fAuth.getCurrentUser() != null)
        {
            Intent mainIntent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(mainIntent);
        }
    }
}