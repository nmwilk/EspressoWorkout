package com.nmwilkinson.espressoworkout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Just displays the String value supplied via the Intent extra.
 */
public class SecondActivity extends AppCompatActivity {
    public static final String KEY_DISPLAY_ITEM_TEXT = "display_item_text";

    @Bind(R.id.display_selected_item)
    TextView displayedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ButterKnife.bind(this);

        displayedItem.setText(getIntent().getStringExtra(KEY_DISPLAY_ITEM_TEXT));
    }

    public static Intent createLaunchIntent(final Context context, final String text) {
        final Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(KEY_DISPLAY_ITEM_TEXT, text);
        return intent;
    }
}
