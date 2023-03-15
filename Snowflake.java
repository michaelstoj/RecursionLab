/**
 * This class implements a Koch Snowflake.
 * This is fractal curve that has an infinite perimeter and a finite volume.
 *
 * @author Stuart Hansen
 * @version October 2017
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Snowflake extends Application {
    public Canvas canvas;    // Our drawing canvas
    private ArrayList<Line> lines;  //the list of lines to draw
    private ArrayList<Line> nextGen;  // the next generation of lines


    /**
     * A second level constructor that initializes the lines ArrayList
     */
    public void initialize() {
        lines = new ArrayList<Line>();

        // insert first lines into snowflake

        Point2D a = new Point2D(50, 110);
        Point2D b = new Point2D(350, 110);
        Point2D c = new Point2D(200, 370);
        lines.add(new Line(a, b));
        lines.add(new Line(b, c));
        lines.add(new Line(c, a));

        draw();

    }


    /**
     * Process one line segment, dividing it into 4 parts and
     * add them to the next Generation.
     * @param lne is the line to process
     */
    public void processLine(Line lne) {
        // the offset for 1/3 of the way along the line
        int dx = (int) (lne.end.getX() - lne.start.getX()) / 3;
        int dy = (int) (lne.end.getY() - lne.start.getY()) / 3;

        // the offset for the midpoint of the line segment.
        int mx = (int) (lne.end.getX() - lne.start.getX()) / 2;
        int my = (int) (lne.end.getY() - lne.start.getY()) / 2;

        // Find the new points
        Point2D a = new Point2D(lne.start.getX() + dx, lne.start.getY() + dy);
        Point2D b = new Point2D((int) (lne.start.getX() + mx + 1.732 / 2 * dy),
                (int) (lne.start.getY() + my - 1.732 / 2 * dx));
        Point2D c = new Point2D(lne.start.getX() + 2 * dx, lne.start.getY() + 2 * dy);

        // Add the four new line segments.
        nextGen.add(new Line(lne.start, a));
        nextGen.add(new Line(a, b));
        nextGen.add(new Line(b, c));
        nextGen.add(new Line(c, lne.end));
    }

    /**
     * Clear the canvas, then draw the lines
     */
    public void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int i = 0; i < lines.size(); i++) {
            Line l = lines.get(i);
            gc.strokeLine(l.start.getX(), l.start.getY(), l.end.getX(), l.end.getY());
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = new Pane();
        canvas = new Canvas(400, 400);
        root.getChildren().add(canvas);

        initialize();

        canvas.setOnMouseClicked(new MouseHandler());

        primaryStage.setTitle("KochSnowFlake");
        primaryStage.setScene(new Scene(root, 400, 400));

        primaryStage.show();

    }

    // PLACE CODE FOR CHECKPOINT #4 HERE
    class MouseHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            nextGen = new ArrayList<Line>();
            for (int i = 0; i < lines.size(); i++) {
                processLine(lines.get(i));
            }
            lines = nextGen;
            draw();
        }

    }



    /**
     * Line is a simple class with two points
     * representing the end points of a line segment.
     */
    class Line {

        // The lines two endpoints
        public Point2D start;
        public Point2D end;

        /**
         * The constructor makes a line
         *
         * @param s is the starting point
         * @param e is the ending point
         */
        Line(Point2D s, Point2D e) {
            start = s;
            end = e;
        }

        /**
         * Convert the Line to a String
         *
         * @return the string representation of the line
         */
        public String toString() {
            return "(" + start.getX() + "," + start.getY() + ") - (" + end.getX() + "," + end.getY() + ")";
        }
    }
}
