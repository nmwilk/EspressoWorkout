package com.nmwilkinson.espressoworkout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

/**
 * Simple vertical list of {@link TextView}, {@link RecyclerView} and {@link Button}.
 */
public class MainActivity extends AppCompatActivity implements SimpleListAdapter.SelectionListener {
    public static final int REQUEST_OPEN_NEXT_SCREEN = 1;

    private final List<String> items = Arrays.asList("Do to the Beast", "Black Love", "Gentlemen", "Up in it", "Congregation", "1965", "Big Top Halloween", "Unbreakable", "Historectomy", "Uptown Avondale", "Live at Howlin'Wolf");

    @Bind(R.id.button)
    Button submit;

    @Bind(R.id.list)
    RecyclerView list;
    @Bind(R.id.selected_item)
    TextView selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        list.setAdapter(new SimpleListAdapter(items, this));

        selectedItem.setText("");
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.button)
    public void itemSelected() {
        startActivityForResult(SecondActivity.createLaunchIntent(this, (String) selectedItem.getText()), REQUEST_OPEN_NEXT_SCREEN);
    }

    @OnLongClick(R.id.selected_item)
    public boolean clearSelected() {
        valueSelected("");
        return true;
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_OPEN_NEXT_SCREEN) {
            clearSelected();
        }
    }

    @Override
    public void valueSelected(final String value) {
        selectedItem.setText(value);
        submit.setVisibility(value == null || value.length() == 0 ? View.GONE : View.VISIBLE);
    }
}
