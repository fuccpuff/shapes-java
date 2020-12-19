package com.example.shapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {

    private Button btn;
    private MyView myView;
    private RadioGroup shape;
    private Spinner sp;

    private String[] colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colors =  getResources().getStringArray(R.array.colorNames);

        btn = findViewById(R.id.undoBtn);
        shape = findViewById(R.id.shapes);
        sp = findViewById(R.id.colors);

        btn.setOnClickListener(this);
        shape.setOnCheckedChangeListener(this);
        myView = findViewById(R.id.myView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, colors);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(this);

    }

    @Override
    public void onClick(View v) {
        myView.undo();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rectRadio: myView.setTypeShape(myView.TYPE_RECT); break;
            case R.id.circleRadio: myView.setTypeShape(myView.TYPE_CIRCLE); break;
            case R.id.triangleRadio: myView.setTypeShape(myView.TYPE_TRIANGLE); break;
            default: myView.setTypeShape(myView.TYPE_RECT); break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = (String)parent.getItemAtPosition(position);
        myView.setColor(item);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

