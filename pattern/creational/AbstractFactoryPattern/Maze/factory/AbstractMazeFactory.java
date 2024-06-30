package factory; /**
 *  This is the abstract maze factory which will give Maze depending on what the client wants
 */

import model.MagicalMaze;
import model.SimpleMaze;

/**
 *  Abstract Factory is used to create similary family of things. 
 */


public interface AbstractMazeFactory {
                MagicalMaze createMagicalMaze();
                SimpleMaze createSimpleMaze();
        }


