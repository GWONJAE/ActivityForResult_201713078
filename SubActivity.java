package com.example.activityforresult_201713078;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    EditText edit;
    TextView text;
    static final int GET_STRING = 1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);

        edit = (EditText) findViewById(R.id.edit);
        text = (TextView) findViewById(R.id.TextView3);
        Button button_ok = (Button) findViewById(R.id.button_ok);
        button_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("INPUT_TEXT", edit.getText().toString());
                intent.putExtra("INPUT_TEXT2", text.getText().toString());//2차데이터에서 받아온 값을 인텐트에 추가한다.
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        Button button_cancel = (Button) findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        Button button_second = (Button) findViewById(R.id.button_second);//2차 데이터를 입력할 액티비티로 이동할 버튼
        button_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubActivity.this,SubActivity2.class);//세 번째 액티비티로 넘어간다. (SubActivity -> SubActivity2)
                startActivityForResult(intent, GET_STRING);//새로운 액티비티로 넘어감


            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GET_STRING) {
            if (resultCode == RESULT_OK) {
                text.setText(data.getStringExtra("INPUT_TEXT"));//2차 데이터를 TextView에 넣는다
            }
        }
    }
}