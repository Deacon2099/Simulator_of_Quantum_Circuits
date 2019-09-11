package com.atlunametultra.simulatorofquantumcircuits;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.MenuItem;
//import android.support.v4.app.NavUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class circuit_setup extends Activity implements AdapterView.OnItemSelectedListener {

    private View mContentView;
    private View mCreateButton;
    private int numberOfqubits;
    private int initialState;
    private Integer states[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_circuit_setup);
        mCreateButton = findViewById(R.id.create_circuit_button);

        mCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuantumCircuit theQcircuit = new QuantumCircuit(numberOfqubits,initialState);
                theQcircuit.AddGate(0,1,2); //(targetqubit,step,gateId)
                theQcircuit.AddGate(0,2,4); //(targetqubit,step,gateId)
                theQcircuit.Calculate();
                goToAddGate();
            }
        });

        Spinner number_of_qubits_spinner = findViewById(R.id.number_of_qubits_spinner);
        Integer[] qubits = new Integer[]{1,2,3,4,5,6,7,8};
        ArrayAdapter<Integer> adapterQubit = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, qubits);
        number_of_qubits_spinner.setAdapter(adapterQubit);
        numberOfqubits=1;

        number_of_qubits_spinner.setOnItemSelectedListener(this);

        Spinner initial_state_spinner = findViewById(R.id.initial_state_spinner);
        int totalStates=(int)Math.pow(2,qubits[0]);
        states= new Integer[totalStates];
        for(int i=0; i<totalStates; i++) {
            states[i]=i;
        }

        ArrayAdapter<Integer> adapterState = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, states);
        initial_state_spinner.setAdapter(adapterState);
        initialState=1;

        initial_state_spinner.setOnItemSelectedListener(this);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == android.R.id.home) {
//            // This ID represents the Home or Up button.
//            NavUtils.navigateUpFromSameTask(this);
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    private void goToAddGate() {
        startActivity(new Intent(circuit_setup.this, welcome_screen.class));
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        if(adapterView.getId() == R.id.number_of_qubits_spinner)
        {
            int qubits = Integer.parseInt(adapterView.getItemAtPosition(position).toString());
            int totalStates=(int)Math.pow(2,qubits);
            states= new Integer[totalStates];
            for(int i=0; i<totalStates; i++) {
                states[i]=i;
            }
            ArrayAdapter<Integer> adapterState = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, states);
            Spinner initial_state_spinner= findViewById(R.id.initial_state_spinner);
            initial_state_spinner.setAdapter(adapterState);

            numberOfqubits=qubits;
            initialState=states[0];
        }

        if(adapterView.getId() == R.id.initial_state_spinner)
        {
            initialState = Integer.parseInt(adapterView.getItemAtPosition(position).toString());
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
