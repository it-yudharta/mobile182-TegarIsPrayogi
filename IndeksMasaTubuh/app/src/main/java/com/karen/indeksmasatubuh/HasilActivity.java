package com.karen.indeksmasatubuh;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HasilActivity extends AppCompatActivity {
    TextView txtNama, txtJk, txtBb, txtTb, txtBmi, txtHasil, txtKet;
    String nama, jk, hasil, ket;
    double bb, tb, bmi;
    double defaultValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        txtNama = (TextView) findViewById(R.id.text_view_hasil_nama);
        txtJk = (TextView) findViewById(R.id.text_view_hasil_jk);
        txtBb = (TextView) findViewById(R.id.text_view_hasil_bb);
        txtTb = (TextView) findViewById(R.id.text_view_hasil_tb);
        txtBmi = (TextView) findViewById(R.id.text_view_hasil_bmi);
        txtHasil = (TextView) findViewById(R.id.text_view_hasil);
        txtKet = (TextView) findViewById(R.id.text_view_hasil_ket);

        //mengambil variabel dari activity lain
        Intent intent = getIntent();
        //String pesan = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        nama = intent.getStringExtra("EXTRA_NAMA");
        jk = intent.getStringExtra("EXTRA_JK");
        bb = intent.getDoubleExtra("EXTRA_BB", defaultValue);
        tb = intent.getDoubleExtra("EXTRA_TB", defaultValue);
        bmi = intent.getDoubleExtra("EXTRA_BMI", defaultValue);
        hasil = intent.getStringExtra("EXTRA_HASIL");
        ket = intent.getStringExtra("EXTRA_KET");

        txtNama.setText("Nama : " + nama);
        txtJk.setText("Jenis Kelamin : " + jk);
        txtBb.setText("Berat Badani : " + bb);
        txtTb.setText("Tinggi Badan : " + tb);
        txtBmi.setText("BMI : " + bmi);
        txtHasil.setText("Hasil : " + hasil);
        txtKet.setText("Keterangan : " + ket);
    }

    public void bagikanKeWhatsapp(View view) {

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Nama : " + nama + "\nJenis Kelamin : " + jk + "\nBerat Badan : " + bb + "\nTinggi Badan : " + tb + "\nBMI : "
                + bmi + "\nHasil : " + hasil + "\nKeterangan : " + ket);
        sendIntent.setType("text/plain");
        sendIntent.setPackage("com.whatsapp");
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);

       /* Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:")); // only email apps should handle this
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Laporan Berat Badan "+nama);
        emailIntent.putExtra(Intent.EXTRA_TEXT,"Nama : "+nama+"\nJenis Kelamin : "+jk+"\nBerat Badan : "+bb+"\nTinggi Badan : "+tb+"\nBMI : "
                +bmi+"\nHasil : "+hasil+"\nKeterangan : "+ket );
        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);*/
        }
    }
}
