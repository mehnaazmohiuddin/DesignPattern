package mac;

import factory.AbstractMazeFactory;
import model.MagicalMaze;
import model.SimpleMaze;



public class MacMazeFactory implements AbstractMazeFactory {
    public MagicalMaze createMagicalMaze(){
        return  new MacMagicalMaze();
    }
    public SimpleMaze createSimpleMaze() {
        return  new MacSimpleMaze();
    }
}