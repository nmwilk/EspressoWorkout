package com.nmwilkinson.espressoworkout;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Prevent scrolling to workaround this: http://stackoverflow.com/a/28432632.
 */
public class FixScrollRecyclerView extends RecyclerView {
    public FixScrollRecyclerView(final Context context, @Nullable final AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void scrollTo(final int x, final int y) {
        // do nothing.
    }
}
