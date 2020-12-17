package com.example.shapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MyView myView = findViewById(R.id.myView);
        RadioGroup selectFigure = findViewById(R.id.shapes);

        class Listener implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

            @Override
            public void onClick(View v) {
                myView.undo();
            }

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rectRadio:
                        myView.setTypeShape(myView.TYPE_RECT);
                        break;
                    case R.id.circleRadio:
                        myView.setTypeShape(myView.TYPE_CIRCLE);
                        break;
                    case R.id.triangleRadio:
                        myView.setTypeShape(myView.TYPE_TRIANGLE);
                        break;
                    default:
                        myView.setTypeShape(myView.TYPE_RECT);
                        break;
                }
            }

        }
        Button undoBtn = findViewById(R.id.undoBtn);
        undoBtn.setOnClickListener(new Listener());
        selectFigure.setOnCheckedChangeListener(new Listener());


    }
}


