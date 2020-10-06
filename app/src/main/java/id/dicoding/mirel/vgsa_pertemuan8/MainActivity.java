package id.dicoding.mirel.vgsa_pertemuan8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnexternal,btninternal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btninternal =(Button)findViewById(R.id.btn_internal);
        btninternal.setOnClickListener(this);
        btnexternal=(Button)findViewById(R.id.btn_external);
        btnexternal.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_internal:
                Intent moveinternal = new Intent(MainActivity.this, InternalActivity.class);
                        startActivity(moveinternal);
                        break;
            case R.id.btn_external:
                Intent moveexternal = new Intent(MainActivity.this, ExternalActivity.class);
                startActivity(moveexternal);
                break;

        }
    }
}