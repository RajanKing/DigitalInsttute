package com.example.authtry1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LibraryView extends AppCompatActivity {
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_view);
    }
    public void OpenWebsite(View view) {
        switch (view.getId()) {
         //   Toast.makeText(this,s , Toast.LENGTH_SHORT).show();
            case R.id.krobit:
                url = "https://korbit.ai/";
                break;
            case R.id.kaggle:
                url = "https://www.kaggle.com/";
                break;
            case R.id.andDoc:
                url = "https://developer.android.com/docs";
                break;
            case R.id.javaDoc:
                url = "https://docs.oracle.com/en/java/javase/14/docs/api/index.html";
                break;
            case R.id.pyDoc:
                url = "https://docs.python.org/3/";
                break;
            case R.id.Programming:
                url = "https://devdocs.io/";
                break;
            case R.id.BooksPdf:
                url = "https://www.pdfdrive.com/";
                break;
            case R.id.Clab:
                url = "https://www.onlinegdb.com/online_c_compiler";
                break;
            case R.id.javalab:
                url = "https://www.jdoodle.com/online-java-compiler/";
                break;
            case R.id.pythonlab:
                url = "http://www.pythontutor.com/visualize.html#mode=edit";
                break;
            case R.id.Alogrithmlab:
                url = "https://algorithm-visualizer.org/";
                break;
            case R.id.programVizulizer:
                url = "https://visualgo.net/en";
                break;
        }
        Intent i = new Intent(LibraryView.this, libweb.class);
        i.putExtra("url", url);
        startActivity(i);

    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(LibraryView.this,MainActivity.class);
        startActivity(i);
        super.onBackPressed();
    }
}
