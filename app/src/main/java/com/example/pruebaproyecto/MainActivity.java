package com.example.pruebaproyecto;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_basic, menu);
        return true;
    }

    public void finishParent()
    {
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 3) {
            if (resultCode == RESULT_OK) {
                this.finish();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuHome:
                return true;
            case R.id.mnuAbout:
                Intent i = new Intent(this, ProgramadorActivity.class);
                super.startActivityForResult(i,3);
                return true;
            case R.id.mnuCerrar:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void botonBerreta()
    {
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
    }

}