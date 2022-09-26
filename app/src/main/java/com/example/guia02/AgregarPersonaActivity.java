package com.example.guia02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.guia02.MainActivity.lstPersona;

import com.example.guia02.Model.Persona;

public class AgregarPersonaActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNombre, edtApellido, edtiID;
    private Button btnAgregarPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_persona);

        edtNombre = findViewById(R.id.edtNombre);
        edtApellido = findViewById(R.id.edtApellido);
        edtiID = findViewById(R.id.edtID);
        btnAgregarPersona = findViewById(R.id.btnAgregarPersona);
        btnAgregarPersona.setOnClickListener(this);
    }

    private void agregar(int idPersona, String nombre, String apellido) {
        Persona persona = new Persona(idPersona, nombre, apellido);
        lstPersona.add(persona);

        new AlertDialog.Builder(this).setTitle("¡Confirmación!")
                .setMessage("Registro exitoso")
                .setPositiveButton("Ok", (dialogInterface, i) -> finish()).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAgregarPersona:
                agregar(Integer.parseInt(edtiID.getText().toString()),
                        edtNombre.getText().toString(),
                        edtApellido.getText().toString());
                break;
        }
    }
}