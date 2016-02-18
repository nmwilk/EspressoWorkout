package com.nmwilkinson.espressoworkout;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionInflater;
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setSharedElementEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.second_activity_enter));
        }

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        ButterKnife.bind(this);

        ViewCompat.setTransitionName(displayedItem, getResources().getString(R.string.transition_name_album_title));

        displayedItem.setText(getIntent().getStringExtra(KEY_DISPLAY_ITEM_TEXT));
    }

    public static Intent createLaunchIntent(final Context context, final String text) {
        final Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(KEY_DISPLAY_ITEM_TEXT, text);
        return intent;
    }
}
