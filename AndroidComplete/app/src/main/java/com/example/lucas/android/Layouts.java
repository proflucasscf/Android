package com.example.lucas.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;

public class Layouts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layouts);
    }

    public void linearLayoutHorizontal(View v)
    {
        Intent intent = new Intent(Layouts.this, LayoutsLinearLayoutHorizontal.class);
        startActivity(intent);
    }

    public void linearLayoutVertical(View v)
    {
        Intent intent = new Intent(Layouts.this, LayoutsLinearLayoutVertical.class);
        startActivity(intent);
    }

    public void relativeLayout(View v)
    {
        Intent intent = new Intent(Layouts.this, LayoutsRelativeLayout.class);
        startActivity(intent);
    }

    public void tableLayout(View v)
    {
        Intent intent = new Intent(Layouts.this, LayoutsTableLayout.class);
        startActivity(intent);
    }

    public void frameLayout(View v)
    {
        Intent intent = new Intent(Layouts.this, LayoutsFrameLayout.class);
        startActivity(intent);
    }
}
