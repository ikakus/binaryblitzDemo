package binaryblitz.com.binaryblitz;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import binaryblitz.com.binaryblitz.presentation.userlist.LoaderUserList;
import binaryblitz.com.binaryblitz.presentation.userlist.PresenterUserList;
import binaryblitz.com.binaryblitz.presentation.userlist.interfaces.ViewUserList;

public class MainActivity extends AppCompatActivity implements  LoaderManager.LoaderCallbacks<PresenterUserList>,
        ViewUserList {

    private PresenterUserList mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public Loader<PresenterUserList> onCreateLoader(int i, Bundle bundle) {
        return new LoaderUserList(this);
    }

    @Override
    public void onLoadFinished(Loader<PresenterUserList> loader, PresenterUserList presenter) {
        mPresenter = presenter;
        // Ready to use mPresenter
        mPresenter.onViewAttached(this);
    }

    @Override
    public void onLoaderReset(Loader<PresenterUserList> loader) {
        mPresenter = null;
    }

    @Override
    public void show(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
