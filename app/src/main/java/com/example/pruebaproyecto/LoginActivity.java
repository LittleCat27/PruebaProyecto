package com.example.pruebaproyecto;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalTime;
import java.time.temporal.TemporalAmount;
import java.util.Calendar;
import java.util.Date;


@RequiresApi(api = Build.VERSION_CODES.O)
public class LoginActivity extends AppCompatActivity {

    byte intentos = 0;
    Date tiempo = Calendar.getInstance().getTime();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        interaccionObjetos();

    }

    private void validadInicio(String password, String username)
    {
        
        if (intentos >= 3)
        {
            long aux = tiempo.getTime() - Calendar.getInstance().getTimeInMillis();
            long segundos = aux/1000;
            Toast.makeText(this, "Demasiados Intentos, espere "+ segundos +" segundos", Toast.LENGTH_SHORT).show();

            if(tiempo.getTime() <= Calendar.getInstance().getTimeInMillis())
            intentos = 0;
            else return;
        }
        
        if (password.equals("1234") && username.equalsIgnoreCase("alumno")) {
            Intent mainActivity = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(mainActivity);
            Toast.makeText(this, R.string.LoginSucces, Toast.LENGTH_SHORT).show();
        }
        else
        {
            intentos++;
            Toast.makeText(this, R.string.LoginFail, Toast.LENGTH_SHORT).show();
            if (intentos >= 3)
            {
                tiempo.setTime(Calendar.getInstance().getTimeInMillis() + 10000);
            }
        }
    }

    private void interaccionObjetos()
    {
        Button button = findViewById(R.id.btnLogin);
        button.setOnClickListener(v -> {
            EditText password = findViewById(R.id.txtPassword);
            EditText username = findViewById(R.id.txtUsername);

            validadInicio(password.getText().toString(), username.getText().toString());
        });
    }

}