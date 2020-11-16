package com.example.activityforresult_201713078;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity2 extends AppCompatActivity {
    EditText edit;

    public void onCreate(Bundle sub){
        super.onCreate(sub);
        setContentView(R.layout.sub2); //2차 데이터를 받을 레이아웃을 띄운다.

        edit = (EditText) findViewById(R.id.edit2);//2차 데이터를 입력할 창을 생성
        Button button_ok = (Button) findViewById(R.id.button_ok);//2차 데이터를 넘기는 버튼
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(); //인텐트 객체 생성
                intent.putExtra("INPUT_TEXT", edit.getText().toString());// EditText에 입력한 값을 넘긴다.
                setResult(RESULT_OK, intent);//인텐트 객체에 결과 코드를 전달
                finish();//이 액티비티를 끝냄
            }
        });
        Button button_cancel = (Button) findViewById(R.id.button_cancel);//3번째 액티비티를 취소하는버튼
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }



}
