package model;


// all the things that need to be
public class ClipBoard {
    private static ClipBoard INSTANCE;
    Object object;

    private ClipBoard(){

    }
    public static ClipBoard getInstance(){
        if(INSTANCE == null) {
            INSTANCE = new ClipBoard();
        }
        return INSTANCE;
    }
    public void addToClipBoard(Object object) {
        System.out.println("adding to clipboard "+object.toString());
        this.object = object;
    }
    public void deleteFromClipBoard(Object object){
        if(this.object.equals(object)){
            System.out.println("removing from clipboard "+object);
            this.object = null;
        }
    }

    public Object getClipBoardObject(){
        return object;
    }
}
