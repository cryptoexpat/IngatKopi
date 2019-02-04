package com.haravenia.ingatkopi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class EnterEvaluationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_evaluation);

        // 各Viewを取得
        final RatingBar rb_body = findViewById(R.id.ratingBarBody);
        final RatingBar rb_acidity = findViewById(R.id.ratingBarAcidity);
        final RatingBar rb_bitterness = findViewById(R.id.ratingBarBitterness);
        final RatingBar rb_total_evaluation = findViewById(R.id.ratingBarTotal);

        // Submitボタンが押された時の処理
        Button button_submit = findViewById(R.id.buttonSubmit);
        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 各項目の値を取得
                float rate_body = rb_body.getRating();
                float rate_acidity = rb_acidity.getRating();
                float rate_bitterness = rb_bitterness.getRating();
                float rate_total_evaluation = rb_total_evaluation.getRating();

                // データベースの書き込み


                // 画面遷移（一覧画面へ）
                Intent intent = new Intent(getApplication(), MainActivity.class);
                startActivity(intent);
            }
        });








    }
}
