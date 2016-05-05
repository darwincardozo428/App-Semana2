package doc.cardozo.darwin.formulariodoc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Informacion extends AppCompatActivity {

    private TextView nombre2;
    private TextView telefono2;
    private TextView email2;
    private TextView descrpcion2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        btnatras();
        Bundle b = getIntent().getExtras();
        String nombre =  b.getString("NOMBRE");
        String telefono = b.getString("TELEFONO");
        String email =  b.getString("EMAIL");
        String descrpcion =  b.getString("DESCRPCION");

        nombre2 = (TextView) findViewById(R.id.nombre2);
        telefono2 = (TextView) findViewById(R.id.telefono2);
        email2 = (TextView) findViewById(R.id.email2);
        descrpcion2 = (TextView) findViewById(R.id.descpcion2);

        nombre2.setText(nombre);
        telefono2.setText(telefono);
        email2.setText(email);
        descrpcion2.setText(descrpcion);




    }

    public void btnatras(){
        Button miBtnatras = (Button) findViewById(R.id.btnAtras);
        miBtnatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento2 = new Intent(Informacion.this, Informacion.class);
                Bundle b2 = new Bundle();
                b2.putString("NOMBRE", nombre2.getText().toString());
                b2.putString("TELEFONO", telefono2.getText().toString());
                b2.putString("EMAIL", email2.getText().toString());
                b2.putString("DESCRPCION", descrpcion2.getText().toString());
                intento2.putExtras(b2);
                setResult( Activity.RESULT_OK, intento2 );
                finish();
            }
        });

    }


}
