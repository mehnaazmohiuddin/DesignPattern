package model;

public class CopyCommand implements Command {
    ClipBoard clipBoard;
    Object toCopy;
    CopyCommand (Object toCopy){
        clipBoard = ClipBoard.getInstance();
        this.toCopy = toCopy;
    }

    @Override
    public void execute() {
        clipBoard.addToClipBoard(toCopy);

    }

    @Override
    public void unexecute() {
        clipBoard.deleteFromClipBoard(toCopy);
    }
}
