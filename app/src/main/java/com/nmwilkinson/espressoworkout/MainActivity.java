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
public class MainActivity extends AppCompatActivity implements SimpleListAdapter.SelectionListener, MainView {
    public static final int REQUEST_OPEN_NEXT_SCREEN = 1;

    private final List<String> items = Arrays.asList("Do to the Beast", "Black Love", "Gentlemen", "Up in it", "Congregation", "1965", "Big Top Halloween", "Unbreakable", "Historectomy", "Uptown Avondale", "Live at Howlin'Wolf");

    @Bind(R.id.button)
    Button submit;

    @Bind(R.id.list)
    RecyclerView list;
    @Bind(R.id.selected_item)
    TextView selectedItem;

    private MainPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        list.setAdapter(new SimpleListAdapter(items, this));

        presenter = new MainPresenterImpl(this);
        presenter.screenCreated();
    }

    @OnClick(R.id.button)
    public void buttonClicked() {
        presenter.itemChosen((String) selectedItem.getText());
    }

    @OnLongClick(R.id.selected_item)
    public boolean listItemLongClicked() {
        presenter.itemCleared();
        return true;
    }

    @Override
    public void valueSelected(final String value) {
        presenter.itemSelected(value);
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_OPEN_NEXT_SCREEN) {
            presenter.itemCleared();
        }
    }

    @Override
    public void setValue(final String value) {
        selectedItem.setText(value);
        submit.setVisibility(value == null || value.length() == 0 ? View.GONE : View.VISIBLE);
    }

    @Override
    public void clearValue() {
        setValue("");
    }

    @Override
    public void openSecondScreen(final String itemChosen) {
        startActivityForResult(SecondActivity.createLaunchIntent(this, itemChosen), REQUEST_OPEN_NEXT_SCREEN);
    }
}
