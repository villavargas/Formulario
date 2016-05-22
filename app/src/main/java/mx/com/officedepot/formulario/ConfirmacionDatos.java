package mx.com.officedepot.formulario;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmacionDatos extends AppCompatActivity {

    private Button btnEdit;
    String nombre, telefono, correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_datos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Bundle parametros = getIntent().getExtras();
        nombre = parametros.getString("name");
        telefono = parametros.getString("mobile");
        correo = parametros.getString("email");

        TextView tvName = (TextView) findViewById(R.id.tvName);
        TextView tvMobile = (TextView) findViewById(R.id.tvMobile);
        TextView tvEmail = (TextView) findViewById(R.id.tvEmail);

        tvName.setText(nombre);
        tvMobile.setText(telefono);
        tvEmail.setText(correo);

        btnEdit = (Button) findViewById(R.id.btn_edit);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmacionDatos.this, MainActivity.class);
                intent.putExtra("name", nombre);
                intent.putExtra("mobile", telefono);
                intent.putExtra("email", correo);
                startActivity(intent);
            }
        });


    }

}
