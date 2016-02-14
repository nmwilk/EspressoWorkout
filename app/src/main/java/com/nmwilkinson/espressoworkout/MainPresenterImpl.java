package com.nmwilkinson.espressoworkout;

/**
 * Created by neil on 14/02/16.
 */
public class MainPresenterImpl implements MainPresenter {
    private MainView mainView;

    public MainPresenterImpl(final MainView mainView) {

        this.mainView = mainView;
    }

    @Override
    public void itemChosen(final String valueChosen) {
        mainView.openSecondScreen(valueChosen);
    }

    @Override
    public void itemSelected(final String valueSelected) {
        mainView.setValue(valueSelected);
    }

    @Override
    public void itemCleared() {
        mainView.clearValue();
    }

    @Override
    public void screenCreated() {
        itemCleared();
    }
}
