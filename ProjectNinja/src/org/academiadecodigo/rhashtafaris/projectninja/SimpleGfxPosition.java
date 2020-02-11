package org.academiadecodigo.rhashtafaris.projectninja;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxPosition extends LogicPosition{

    private Ellipse ellipse;
    private Rectangle rectangle;
    private SimpleGfxGrid grid;

    public SimpleGfxPosition(SimpleGfxGrid grid) {
        super((int)(Math.random() * (double)(grid.getCols() - 40)), 5, grid);
        this.grid = grid;
        this.ellipse = new Ellipse((double)this.getCol(), (double)this.getRow(), (double)(30 * grid.getCellSize()), (double)(30 * grid.getCellSize()));
        this.ellipseShow();
    }

    public SimpleGfxPosition(int col, int row, SimpleGfxGrid grid) {
        super(col, row, grid);
        this.grid = grid;
        this.rectangle = new Rectangle((double)this.getCol(), (double)this.getRow(), (double)(25 * grid.getCellSize()), (double)(25 * grid.getCellSize()));
        this.rectangleShow();
    }

    public void rectangleShow() {
        this.rectangle.setColor(Color.WHITE);
    }

    public void ellipseShow() {
        this.ellipse.setColor(Color.RED);
        this.ellipse.fill();
    }

    public void rectangleHide() {
        this.rectangle.delete();
    }

    public void ellipseHide() {
        this.ellipse.delete();
    }

    public void implementGravity(int speed) {
        int beforeRow = this.getRow();
        int beforeCol = this.getCol();
        super.implementGravity(speed);
        int afterRow = this.getRow();
        int afterCol = this.getCol();
        this.ellipse.translate((double)(afterCol - beforeCol * this.grid.getCellSize()), (double)(afterRow - beforeRow * this.grid.getCellSize()));
    }

    public void ninjaPosition() {
    }

}
