package binaryblitz.com.binaryblitz.presentation.createuser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import binaryblitz.com.binaryblitz.R;

/**
 * Created by ikakus on 10/28/17.
 */

public class ActivityCreateUser extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        DialogFragmentCreateUser fragment = new DialogFragmentCreateUser();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.create_user_container, fragment)
                .commitAllowingStateLoss();
    }
}