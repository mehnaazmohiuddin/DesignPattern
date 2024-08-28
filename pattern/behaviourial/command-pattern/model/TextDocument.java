package model;

public class TextDocument implements Document<Text> {
    StringBuilder sb ;
    String selectedString ;
    TextDocument(){
        sb  = new StringBuilder();
    }
    @Override
    public Text getSelectedObject() {
        return new Text(selectedString);
    }

    @Override
    public void addObject(Text object) {
        sb.append(object.toString());
    }
    public void setSelectedString(int start, int end){
        selectedString =  sb.substring(start,end);
    }
}
