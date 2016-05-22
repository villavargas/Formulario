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
import java.util.Calendar;
import android.app.DatePickerDialog;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText etName, etEmail, etPassword, etMobile, etAddress;
    private TextInputLayout input_layout_name, input_layout_email, input_layout_password, input_layout_mobile, input_layout_address;
    private Button btnSignUp, btnCalendar;
    String nombre = "", telefono ="", correo="", date ="", descr="";
    private Calendar calendar;
    private int year, month, day;
    // Variable for storing current date and time
    private int mYear, mMonth, mDay;
    EditText txtDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDate = (EditText) findViewById(R.id.txtDate);
        btnCalendar = (Button) findViewById(R.id.btnCalendar);

        Bundle parametros = getIntent().getExtras();
        if (parametros != null) {
            nombre = parametros.getString("name");
            telefono = parametros.getString("mobile");
            correo = parametros.getString("email");
            date = parametros.getString("date");
            descr = parametros.getString("descr");
        }

        input_layout_name = (TextInputLayout) findViewById(R.id.input_layout_name);
        input_layout_email = (TextInputLayout) findViewById(R.id.input_layout_email);
        input_layout_mobile = (TextInputLayout) findViewById(R.id.input_layout_mobile);
        input_layout_address = (TextInputLayout) findViewById(R.id.input_layout_address);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
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
        if (date != null){
            txtDate.setText(date);
        }
        if (descr != null){
            etAddress.setText(descr);
        }

        btnSignUp = (Button) findViewById(R.id.btn_signup);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });


        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickCalendar(view);
            }
        });
    }

    /**
     * Validating form
     */
    private Boolean submitForm() {

        Intent intent = new Intent(MainActivity.this, ConfirmacionDatos.class);
        intent.putExtra("name", etName.getText().toString().trim());
        intent.putExtra("mobile", etMobile.getText().toString().trim());
        intent.putExtra("email", etEmail.getText().toString().trim());
        intent.putExtra("descr", etAddress.getText().toString().trim());
        intent.putExtra("date", txtDate.getText().toString().trim());
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
        return true;
    }



    public void onClickCalendar(View v) {

            // Process to get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            // Launch Date Picker Dialog
            DatePickerDialog dpd = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            // Display Selected date in textbox
                            txtDate.setText(dayOfMonth + "-"
                                    + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            dpd.show();
    }


    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


}