package devicemagic.map.toggle.example;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import devicemagic.map.toggle.ToggleListener;
import devicemagic.map.toggle.ToggleView;

public class JavaActivity extends AppCompatActivity {
    private ToggleView toggleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toggleView = (ToggleView) findViewById(R.id.toggle_view);

        toggleView.setToggleModeListener(new ToggleListener() {
            @Override
            public void onMapModeSelected() {
                Snackbar.make(toggleView, "Map Mode Selected", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

            @Override
            public void onSatelliteModeSelected() {
                Snackbar.make(toggleView, "Satellite Mode Selected", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
