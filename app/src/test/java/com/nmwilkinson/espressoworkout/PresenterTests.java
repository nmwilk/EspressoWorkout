package com.nmwilkinson.espressoworkout;

import org.junit.Assert;
import org.junit.Test;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class PresenterTests {
    @Test
    public void selectionAndChoose() {

        final TestMainView testView = new TestMainView();

        final MainPresenter presenter = new MainPresenterImpl(testView);
        presenter.screenCreated();

        Assert.assertEquals("", testView.value);
        Assert.assertFalse(testView.openedSecondScreen);

        presenter.itemSelected("Foo");
        Assert.assertEquals("Foo", testView.value);
        Assert.assertFalse(testView.openedSecondScreen);

        presenter.itemCleared();
        Assert.assertEquals("", testView.value);
        Assert.assertFalse(testView.openedSecondScreen);

        presenter.itemSelected("Bar");

        presenter.itemChosen("Bar");
        Assert.assertEquals("Bar", testView.value);
        Assert.assertTrue(testView.openedSecondScreen);
    }

    private class TestMainView implements MainView {
        private boolean openedSecondScreen;
        private String value;

        @Override
        public void setValue(final String value) {
            this.value = value;
        }

        @Override
        public void clearValue() {
            this.value = "";
        }

        @Override
        public void openSecondScreen(final String itemChosen) {
            openedSecondScreen = true;
        }
    }
}