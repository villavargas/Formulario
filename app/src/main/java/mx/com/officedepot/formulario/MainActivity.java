package mx.com.officedepot.formulario;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText etName, etEmail, etPassword, etMobile, etAddress;
    private TextInputLayout input_layout_name, input_layout_email, input_layout_password, input_layout_mobile, input_layout_address;
    private Button btnSignUp;
    String nombre = "", telefono ="", correo="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        Bundle parametros = getIntent().getExtras();
        if (parametros != null) {
            nombre = parametros.getString("name");
            telefono = parametros.getString("mobile");
            correo = parametros.getString("email");
            System.out.println("Nombre:" + nombre);
        }

        input_layout_name = (TextInputLayout) findViewById(R.id.input_layout_name);
        input_layout_email = (TextInputLayout) findViewById(R.id.input_layout_email);
        input_layout_password = (TextInputLayout) findViewById(R.id.input_layout_password);
        input_layout_mobile = (TextInputLayout) findViewById(R.id.input_layout_mobile);
        input_layout_address = (TextInputLayout) findViewById(R.id.input_layout_address);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etMobile = (EditText) findViewById(R.id.etMobile);
        etAddress = (EditText) findViewById(R.id.etAddress);

        if (nombre != null){
            etName.setText(nombre);
        }
        if (telefono != null){
            etMobile.setText(telefono);
        }
        if (correo != null){
            etEmail.setText(correo);
        }

        btnSignUp = (Button) findViewById(R.id.btn_signup);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
    }

    /**
     * Validating form
     */
    private Boolean submitForm() {
      /*  if (!validateName()) {
            return false;
        }

        if (!validateEmail()) {
            return false;
        }

        if (!validatePassword()) {
            return false;
        }

        if (!validateMobile()) {
            return false;
        }

        if (!validateAddress()) {
            return false;
        }*/
        Intent intent = new Intent(MainActivity.this, ConfirmacionDatos.class);
        intent.putExtra("name", etName.getText().toString().trim());
        intent.putExtra("mobile", etMobile.getText().toString().trim());
        intent.putExtra("email", etEmail.getText().toString().trim());
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
        return true;
    }







    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }




}