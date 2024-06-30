package windows;

import factory.AbstractMazeFactory;
import model.MagicalMaze;
import model.SimpleMaze;
import windows.WindowsMagicalMaze;

public class WindowsMazeFactory implements AbstractMazeFactory {
   public MagicalMaze createMagicalMaze(){
        return  new WindowsMagicalMaze();
    }
    public SimpleMaze createSimpleMaze() {
        return  new WindowsSimpleMaze();
    }
}