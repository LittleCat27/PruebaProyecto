package com.example.pruebaproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ProgramadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programador);

        EscucharTexto();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_basic, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuHome:
                finish();
                return true;
            case R.id.mnuAbout:
                return true;
            case R.id.mnuCerrar:
                setResult(RESULT_OK, null);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void EscucharTexto()
    {
        TextView txE = findViewById(R.id.txmail);
        TextView txP = findViewById(R.id.txphone);

        txE.setOnClickListener(v ->{
            Intent i =new Intent(Intent.ACTION_SENDTO);
            i.setData(Uri.parse("mailto:"+"pablo@gmail.com"));
            try {
                startActivity(i);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getApplicationContext(), "No se encontró ninguna aplicación para realizar la acción deseada.", Toast.LENGTH_SHORT).show();
            }
        });
        txP.setOnClickListener(v ->{
            Intent i =new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:"+"2954253051"));
            try {
                startActivity(i);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getApplicationContext(), "No se encontró ninguna aplicación para realizar la acción deseada.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}