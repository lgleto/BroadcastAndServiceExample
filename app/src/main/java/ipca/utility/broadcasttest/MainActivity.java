package ipca.utility.broadcasttest;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager=getSupportFragmentManager();

        Fragment plusOne =  new PlusOneFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.container1,plusOne)
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();

        Fragment plusTwo =  new PlusTwoFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.container2,plusTwo)
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();

        Intent intent=new Intent(this,AppReminderService.class);
        startService(intent);
    }
}
