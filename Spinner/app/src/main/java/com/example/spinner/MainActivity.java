package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppCompatSpinner srcSel, desSel;
    EditText srcIn;
    TextView desIn;
    List<MoneyFormat> money_list = new ArrayList<>();
    Double tu = 1D;
    Double mau = 1D;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        srcSel = (AppCompatSpinner) findViewById(R.id.srcSelect);
        desSel = (AppCompatSpinner) findViewById(R.id.desSelect);
        srcIn = (EditText) findViewById(R.id.srcInput);
        desIn = (TextView) findViewById(R.id.desInput);
        money_list = new ArrayList<>();

        money_list.add(new MoneyFormat("VNĐ", 1D));
        money_list.add(new MoneyFormat("USD", 23080D));
        money_list.add(new MoneyFormat("Vàng", 5580000D));
        money_list.add(new MoneyFormat("EUR", 27043D));
        money_list.add(new MoneyFormat("GBP", 29645D));
        money_list.add(new MoneyFormat("JPY", 217.2D));
        money_list.add(new MoneyFormat("CAD", 17237D));
        money_list.add(new MoneyFormat("AUD", 16231D));
        money_list.add(new MoneyFormat("AUD", 16231D));
        money_list.add(new MoneyFormat("SGD", 16747D));

        ArrayAdapter adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, money_list);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        srcSel.setAdapter(adapter);
        desSel.setAdapter(adapter);
        srcSel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                try {
                    Double factor = money_list.get(i).getFactor();
                    tu = factor;
                    Double tmp = Double.parseDouble(srcIn.getText().toString()) * tu / mau;
                    String output = String.valueOf(tmp);
                    desIn.setText(output);
                } catch (Exception e) {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        desSel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                try {
                    Double factor = money_list.get(i).getFactor();
                    mau = factor;
                    Double tmp = Double.parseDouble(srcIn.getText().toString()) * tu / mau;
                    String output = String.valueOf(tmp);
                    desIn.setText(output);
                } catch (Exception e) {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        srcIn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    Double tmp = Double.parseDouble(s.toString()) * tu / mau;
                    String output = String.valueOf(tmp);
                    desIn.setText(output);
                } catch (
                        Exception e
                ) {

                }
            }
        });
    }
}