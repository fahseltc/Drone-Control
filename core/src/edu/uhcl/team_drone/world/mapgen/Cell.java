package edu.uhcl.team_drone.world.mapgen;

public class Cell {

    public int x;
    public int y;

    public boolean visited = false;
    public boolean isWall = false;
    
    private char image = 'X';

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void visit(boolean bool) {
        this.visited = bool;
    }

    public void setImage(char image) {
        this.image = image;
    }

    public char getImage() {
        if (visited) {
            if (image == '#') {
                return '#';
            }
            return '.';
        } else {
            return 'X';
        }

    }
}