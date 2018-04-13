package viktor.demo.ru.demochattingactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import viktor.demo.ru.demochattingactivity.activity.AnimalActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_layout_container);

        startActivity(new Intent(this, AnimalActivity.class));

    }
}
