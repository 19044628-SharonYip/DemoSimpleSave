package sg.edu.rp.c346.id19044628.demosimplesave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs= getPreferences(MODE_PRIVATE);
        String msg=prefs.getString("greetings", "No greetings");
        Toast toast = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        String msg="Activity is closed!";
        Toast toast = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT);
        toast.show();

        SharedPreferences prefs= getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit= prefs.edit();
        prefEdit.putString("greetings", "hello");
        prefEdit.commit();
    }
}