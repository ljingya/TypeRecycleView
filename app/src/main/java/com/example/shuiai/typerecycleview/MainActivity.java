package com.example.shuiai.typerecycleview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Button headFootBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        headFootBtn = (Button) findViewById(R.id.headFootBtn);
        headFootBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.headFootBtn:
                Intent intent = new Intent(this, HeaderFooterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
