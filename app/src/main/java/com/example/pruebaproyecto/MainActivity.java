package com.example.pruebaproyecto;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;


@RequiresApi(api = Build.VERSION_CODES.O)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonBerreta();
    }


    public void botonBerreta()
    {
        Button b = findViewById(R.id.BTN_ABOUT);
        ImageView iC = findViewById(R.id.img_cartoon);
        ImageView iP = findViewById(R.id.img_powerpuff);
        ImageView iD = findViewById(R.id.img_drama);
        ImageView iG = findViewById(R.id.img_gumball);

        iC.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.cartoonnetwork.com"));
            startActivity(i);
        });

        iP.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.cartoonnetwork.com.ar/show/las-chicas-superpoderosas"));
            startActivity(i);
        });

        iG.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.cartoonnetwork.com.ar/show/el-increible-mundo-de-gumball"));
            startActivity(i);
        });

        iD.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.cartoonnetwork.com.ar/show/drama-total-todos-estrellas/juegos"));
            startActivity(i);
        });


        b.setOnClickListener(view -> {
        Intent i = new Intent(this, ProgramadorActivity.class);
        startActivity(i);
        });
    }

}