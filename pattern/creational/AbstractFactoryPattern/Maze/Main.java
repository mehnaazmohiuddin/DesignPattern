import factory.AbstractMazeFactory;
import mac.MacMazeFactory;
import model.MagicalMaze;
import model.SimpleMaze;
import windows.WindowsMazeFactory;

public class Main {

    public static void main(String args[]){
        System.out.println("Starting game");
        System.out.println("Using magical maze");
        AbstractMazeFactory mazeFactory = new WindowsMazeFactory();
        MagicalMaze magicalMaze =  mazeFactory.createMagicalMaze();
        magicalMaze.render();
        SimpleMaze simpleMaze =  mazeFactory.createSimpleMaze();
        simpleMaze.render();

        // now if we want to use Mac's mze we can simple change the maze factory to Mac
        // be rest assured that the game will work with the same code.

        System.out.println("Using simple maze");
        mazeFactory = new MacMazeFactory();
        magicalMaze =  mazeFactory.createMagicalMaze();
        magicalMaze.render();
        simpleMaze =  mazeFactory.createSimpleMaze();
        simpleMaze.render();




    }
}
