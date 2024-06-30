package model;

import exceptions.MazeBoundryException;
import model.Cell;

public class Door implements Boundry {
    Cell sideA;
    Cell sideB;

    public Door(Cell sideA, Cell sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public void enter(  Character character) throws MazeBoundryException {
        if(sideA.equals(character.getCurrentCell())){
            character.setCurrentCell(sideB);
        }
        else if (sideB.equals((character.getCurrentCell()))){
            character.setCurrentCell(sideA);
        }
        else {
            throw  new MazeBoundryException("Character cannot open this door");
        }
    }

}
