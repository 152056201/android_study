package com.example.viewactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button1);
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view_1);
        progressBar = (ProgressBar) findViewById(R.id.progressbar_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editText.getText().toString();
                switch (v.getId()) {
                    case R.id.button1:
                        /*Toast.makeText(MainActivity.this, data, Toast.LENGTH_LONG).show();
                        imageView.setImageResource(R.drawable.b);*/
                        /*if(progressBar.getVisibility()==View.GONE){
                            progressBar.setVisibility(View.VISIBLE);
                        }else {
                            progressBar.setVisibility(View.GONE);
                        }*/
                        /*int progress = progressBar.getProgress();
                        progress = progress + 10;
                        progressBar.setProgress(progress);*/
                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("This is Dialog");
                        dialog.setMessage("确定要删除?");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        dialog.show();
                        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                        progressDialog.setTitle("This is ProgressDialog");
                        progressDialog.setMessage("Loading....");
                        progressDialog.setCancelable(true);
                        progressDialog.show();
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
