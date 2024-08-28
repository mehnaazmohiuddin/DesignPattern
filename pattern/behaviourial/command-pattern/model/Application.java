package model;

import java.util.Stack;

public class Application {
    TextDocument document;
    Stack<Command> commandsToDo;
    Stack<Command> reDo;

    CopyCommand copyCommand;

    public Application(){
        document = new TextDocument();
        commandsToDo = new Stack<>();
        reDo = new Stack<>();
    }

    public void addText(String s){
        document.addObject( new Text(s));
    }
    public  void  selectText( int s, int e){
        document.setSelectedString(s,e);
    }

    public  void copy(){
        copyCommand = new CopyCommand( document.getSelectedObject() );
        commandsToDo.add(copyCommand);
        copyCommand.execute();
    }

    public void cntrlC(){
       copy();
    }
    public void pressCopyButton(){
        copy();
    }


    public void undo(){
     if(commandsToDo.size()>0){
        // uncopy
        Command command =    commandsToDo.pop();
        reDo.add(command);
        command.unexecute();
        }
    }
    public void redo(){
        if(reDo.size() >0){
            // uncopy
            Command command =  reDo.pop();
            command.execute();
        }
    }





}
