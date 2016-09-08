package id.sch.smktelkom_mlg.tugas01.xir5036.album;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText etNamaDp, etNamaBl;
    Button bK;
    TextView tvHasil, tvHasilItem;
    Spinner spProvinsi;
    CheckBox cbAM, cbPM, cbBM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//ini untuk Nama dan hasil TextView 1 yang untuk nama
        etNamaDp = (EditText) findViewById(R.id.editTextNamaDepan);
        etNamaBl = (EditText) findViewById(R.id.editTextNamaBelakang);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
//ini untuk Checkbox
        cbAM = (CheckBox) findViewById(R.id.checkBoxAM);
        cbPM = (CheckBox) findViewById(R.id.checkBoxPM);
        cbBM = (CheckBox) findViewById(R.id.checkBoxBM);
        tvHasilItem = (TextView) findViewById(R.id.textViewHasilItem);
//spinner
        spProvinsi = (Spinner) findViewById(R.id.spinnerProvinsi);

//ini untuk Button
        bK = (Button) findViewById(R.id.buttonKirim);
        bK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });


    }

    private void doProcess() {
        //ini untuk nama
        String namadp = etNamaDp.getText().toString();
        String namabl = etNamaBl.getText().toString();
        tvHasil.setText("Nama pemesan :" + namadp + " " + namabl + "");
        //ini untuk checkbox

        String hasil = "Item yang dipesan :\n";
        int startlen = hasil.length();
        if (cbAM.isChecked()) hasil += cbAM.getText() + "\n";
        if (cbPM.isChecked()) hasil += cbPM.getText() + "\n";
        if (cbBM.isChecked()) hasil += cbBM.getText() + "\n";

        if (hasil.length() == startlen) hasil += "Tidak ada yang dipilih";
        tvHasilItem.setText(hasil);
    }
}
