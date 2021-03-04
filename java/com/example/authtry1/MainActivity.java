package com.example.authtry1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    AlertDialog.Builder builder;
FirebaseAuth auth;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =(Toolbar)findViewById(R.id.mainactvityToolbar);
        setSupportActionBar(toolbar);
        auth = FirebaseAuth.getInstance();
//        button=findViewById(R.id.vedio);
//        button.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, mailforvedio.class);
//                startActivity(intent);
//            }
//
//        });
        builder=new AlertDialog.Builder(this);
        drawerLayout = findViewById(R.id.mainactvityDrawer);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragement_layout,
                    new ClassFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_class);
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent i;
        switch (item.getItemId()){
            case R.id.nav_Insitutechat:
                Toast.makeText(this, "Urder Development", Toast.LENGTH_SHORT).show();
i=new Intent(MainActivity.this,LibraryView.class);
startActivity(i);
               break;
            case R.id.nav_Library:
              i = new Intent(MainActivity.this,BooksActivity.class);
              startActivity(i);
                break;
            case R.id.nav_liveClass:
                i = new Intent(MainActivity.this,addvideo.class);
                startActivity(i);
                break;
            case R.id.videoClasses:
                i=new Intent(MainActivity.this,dashboard.class);
                startActivity(i);

                break;
            case R.id.nav_Syllabus:
                i = new Intent(MainActivity.this,uploadfile.class);
                startActivity(i); break;
            case R.id.Logout:
                auth.signOut();
                i = new Intent(MainActivity.this,InstutionLoginActivity.class);
                startActivity(i);
                finish();
                break;
            default:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragement_layout,
                        new ClassFragment()).commit();

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
@Override
public void onBackPressed() {
    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
        drawerLayout.closeDrawer(GravityCompat.START);
    } else {
        builder.setMessage("Welcome to AD").setTitle("AlertDialog");
        builder.setMessage("Do you want to close this Application?")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog=builder.create();
        alertDialog.setTitle("Alert Dialog ex");
        alertDialog.show();
        super.onBackPressed();
    }
}

}
