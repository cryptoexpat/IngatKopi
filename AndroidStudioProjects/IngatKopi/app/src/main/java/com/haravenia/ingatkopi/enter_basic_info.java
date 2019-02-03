package com.haravenia.ingatkopi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class enter_basic_info extends AppCompatActivity {

    // 選択肢
    private String bean_type_items[] = {"Arabica", "Robusta"};
    private String roast_items[] = {"Light", "Medium", "Medium Dark", "Dark"};
    private String grind_size_items[] = {"Coarse", "Medicum Coarse", "Medium", "Medium Fine", "Fine", "Turkish"};
    private String origin_items[] = {"Indonesia", "Ethiopia", "Nicaragua"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_basic_info);

        Spinner spinner_origin = findViewById(R.id.spinner_origin);
        Spinner spinner_bean_type = findViewById(R.id.spinner_bean_type);
        Spinner spinner_roast = findViewById(R.id.spinner_roast);
        Spinner spinner_grind_size = findViewById(R.id.spinner_grind_size);

        // Spinnerに対してAdaptorをセットする
        // ArrayAdapter (Origin)
        ArrayAdapter<String> adapter_origin
                = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, origin_items);

        adapter_origin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_origin.setAdapter(adapter_origin);

        // ArrayAdapter (Bean)
        ArrayAdapter<String> adapter_bean_type
                = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, bean_type_items);

        adapter_bean_type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_bean_type.setAdapter(adapter_bean_type);

        // ArrayAdapter (Roast)
        ArrayAdapter<String> adapter_roast
                = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, roast_items);

        adapter_roast.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_roast.setAdapter(adapter_roast);

        // ArrayAdapter (Grind_Size)
        ArrayAdapter<String> adapter_grind_size
                = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, grind_size_items);

        adapter_grind_size.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_grind_size.setAdapter(adapter_grind_size);


        // リスナーを登録
        spinner_bean_type.setOnItemSelectedListener(new OnItemSelectedListener() {
            //　アイテムが選択された時
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int position, long id) {
                //
            }

            //　アイテムが選択されなかった
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });

        Button goToEvaluate = findViewById(R.id.button_gotoevaluate);
        goToEvaluate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
