package id.dicoding.mirel.vgsa_pertemuan8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class ExternalActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String FILENAME="namafile.txt";
    Button btnbuat,btnubah,btnbaca,btnhapus;
    TextView textbaca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option__chose);
        setContentView(R.layout.activity_option__chose);
        btnbuat=(Button)findViewById(R.id.btn_buatfile);
        btnbuat.setOnClickListener(this);
        btnubah=(Button)findViewById(R.id.btn_ubahfile);
        btnubah.setOnClickListener(this);
        btnbaca=(Button)findViewById(R.id.btn_bacafile);
        btnbaca.setOnClickListener(this);
        btnhapus=(Button)findViewById(R.id.btn_hapusfile);
        btnhapus.setOnClickListener(this);
        textbaca=(TextView)findViewById(R.id.teksbaca);
    }
    void buatfile(){
        String isifile = "Coba isi data file txt";
        File file =new File(getExternalFilesDir(null),FILENAME);
        FileOutputStream outputStream=null;
        try {
            file.createNewFile();
            outputStream= new FileOutputStream(file,true);
            outputStream.write(isifile.getBytes());
            outputStream.flush();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    void ubahfile(){
        String ubahfile = "update data isi txt";
        File file =new File(getExternalFilesDir(null),FILENAME);
        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, false);
            outputStream.write(ubahfile.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void bacafile() {
        File sdcard =getExternalFilesDir(null);
        File file = new File(sdcard, FILENAME);
        if(file.exists()) {
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                while (line != null) {
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
            } catch (IOException e) {
                System.out.println("Error"+e.getMessage());
            }
            textbaca.setText(text.toString());
        }
    }
    void hapusfile(){
        File file=new File(getExternalFilesDir(null),FILENAME);
        if (file.exists()){
            file.delete();
        }
    }

    @Override
    public void onClick(View v) {
        jalankanPerintah(v.getId());
    }
    public void jalankanPerintah(int id){
        switch (id){
            case R.id.btn_buatfile:
                buatfile();
                break;
            case R.id.btn_ubahfile:
                ubahfile();
                break;
            case R.id.btn_bacafile:
                bacafile();
                break;
            case R.id.btn_hapusfile:
                hapusfile();
                break;
        }
    }
}