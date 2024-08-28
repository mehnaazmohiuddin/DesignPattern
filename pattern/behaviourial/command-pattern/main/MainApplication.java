package main;

import model.Application;

public class MainApplication {
    public static void main(String[] args) {
        // the application will do 2 ways to copy and also will maintain history of what the user copied etc.
        // cntrl-C is one way and the other way is to choose 'copy-sticker-button' .
        // the selected item will be in the Class Selected.
        // the Editor will have the 'copy-sticker-button' and will also recive the cntrl-c from the user.
        // the Editor will also have the selected item .
        // the editor also has to maintain what all was copied as a history

        Application ap = new Application();
        ap.addText("Mehnaaz");
        ap.addText("Mohiuddin");
        ap.selectText(0,5);
        ap.pressCopyButton();

        ap.selectText(0,7);
        ap.pressCopyButton();

        ap.undo();
        ap.redo();
        ap.cntrlC();

    }
}
