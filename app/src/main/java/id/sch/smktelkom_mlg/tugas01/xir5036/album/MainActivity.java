package id.sch.smktelkom_mlg.tugas01.xir5036.album;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText etNamaDp, etNamaBl, etAlamat;
    Button bK;
    TextView tvHasil;
    Spinner spProvinsi;
    CheckBox cbAM, cbPM, cbBM;
    RadioButton rbK, rbC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//ini untuk Nama dan hasil TextView 1 yang untuk nama
        etNamaDp = (EditText) findViewById(R.id.editTextNamaDepan);
        etNamaBl = (EditText) findViewById(R.id.editTextNamaBelakang);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
//ini untuk Checkbox
        cbAM = (CheckBox) findViewById(R.id.checkBoxAM);
        cbPM = (CheckBox) findViewById(R.id.checkBoxPM);
        cbBM = (CheckBox) findViewById(R.id.checkBoxBM);

//ini untuk Radio Button
        rbK = (RadioButton) findViewById(R.id.radioButtonKilat);
        rbC = (RadioButton) findViewById(R.id.radioButtonCepat);

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
        String alamat = etAlamat.getText().toString();

        //ini untuk checkbox
        String hasil = "Item yang dipesan :\n";
        int startlen = hasil.length();
        if (cbAM.isChecked()) hasil += cbAM.getText() + "\n";
        if (cbPM.isChecked()) hasil += cbPM.getText() + "\n";
        if (cbBM.isChecked()) hasil += cbBM.getText() + "\n";
        if (hasil.length() == startlen) hasil += "Tidak ada yang dipilih";

        //ini untuk radio button
        String hasil2 = null;
        if (rbK.isChecked()) {
            hasil2 = rbK.getText().toString();
        } else if (rbC.isChecked()) {
            hasil2 = rbC.getText().toString();
        } else {
            hasil2 = "Belum memilih";
        }
        //ini untuk spinner
        String provinsi = spProvinsi.getSelectedItem().toString();

        tvHasil.setText("Nama pemesan :\n" + namadp + " " + namabl + "\n\n" + hasil + "\n\n Metode Pengiriman :\n" + hasil2 + "\n\n" + "Provinsi Tujuan :\n" + provinsi + "\n" + alamat);

    }
}
