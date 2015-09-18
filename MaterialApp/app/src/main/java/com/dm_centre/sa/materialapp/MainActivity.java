package com.dm_centre.sa.materialapp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements
        SearchView.OnQueryTextListener{

    static final String NOTE_PREFIX = "Note #";
    static final int NOTES_QTY = 30;
    String[] mNotes = new String[NOTES_QTY];

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private MenuItem mSearchItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        for(int i = 0; i < NOTES_QTY; i++) {
            mNotes[i] = NOTE_PREFIX + i+1; }
            mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);
            mAdapter = new NotesAdapter(mNotes);
            mRecyclerView.setAdapter(mAdapter);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Hello buddy");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        mSearchItem = menu.findItem(R.id.action_search);
        SearchView mSearcher = (SearchView) MenuItemCompat.getActionView(mSearchItem);
        mSearcher.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
    //    if (id == R.id.action_settings) {
     //       return true;
     //   }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Toast.makeText(this, "Here we could search '" + query + "'", Toast.LENGTH_LONG).show();
        MenuItemCompat.collapseActionView(mSearchItem);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }


    public void onButtonClick(View v) {
        View coordinator = findViewById(R.id.coordinator);
        Snackbar.make(coordinator, "Hello from Snake Bar!", Snackbar.LENGTH_LONG)
                .setAction("Some snake action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,
                                "Здесь могла быть ваша реклама", Toast.LENGTH_SHORT).show();
                }
            }).setActionTextColor(0xFFFFB300).show();

    }
}
