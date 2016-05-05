package doc.cardozo.darwin.formulariodoc;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtnombre1;
    private EditText edttelefono1;
    private EditText edtemail1;
    private EditText edtdescrpcion1;
    String nombre2;
    String telefono2;
    String email2;
    String descrpcion2;
    private static final int REQUEST_TEXT = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsiguiente();


        edtnombre1 = (EditText) findViewById(R.id.nombreUsuario);
        edttelefono1 = (EditText) findViewById(R.id.etTelefono);
        edtemail1 = (EditText) findViewById(R.id.etEmail);
        edtdescrpcion1 = (EditText) findViewById(R.id.edDescrpcion);

        /*
        Bundle b2 = getIntent().getExtras();
        nombre2 =  b2.getString("NOMBRE2");
        telefono2 = b2.getString("TELEFONO2");
        email2 =  b2.getString("EMAIL2");
        descrpcion2 =  b2.getString("DESCRPCION2");

        /*edtnombre1.setText(nombre2);
        edttelefono1.setText(telefono2);
        edtemail1.setText(email2);
        edtdescrpcion1.setText(descrpcion2);*/


    }


    public void btnsiguiente(){
        Button mibtnSiguiente= (Button) findViewById(R.id.btnSiguiente);
        mibtnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getBaseContext(), getResources().getString(R.string.Actualizando),Toast.LENGTH_SHORT).show();
                //Snackbar.make(v, getResources().getString(R.string.Actualizando), Snackbar.LENGTH_SHORT).show();
                nombre2=edtnombre1.getText().toString();
                telefono2=edttelefono1.getText().toString();
                email2=edtemail1.getText().toString();
                descrpcion2=edtdescrpcion1.getText().toString();
                Intent intent = new Intent(MainActivity.this, Informacion.class );
                Bundle b = new Bundle();
                b.putString("NOMBRE", edtnombre1.getText().toString());
                b.putString("TELEFONO", edttelefono1.getText().toString());
                b.putString("EMAIL", edtemail1.getText().toString());
                b.putString("DESCRPCION", edtdescrpcion1.getText().toString());
                intent.putExtras(b);
                startActivity(intent);

            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ( requestCode == REQUEST_TEXT ){
            if ( resultCode == Activity.RESULT_OK ){
                edtnombre1.setText(data.getExtras().get("NOMBRE2").toString());
                edttelefono1.setText(data.getExtras().get("TELEFONO2").toString());
                edtemail1.setText(data.getExtras().get("EMAIL2").toString());
                edtdescrpcion1.setText(data.getExtras().get("DESCRPCION2").toString());
            }
        }

    }

}
