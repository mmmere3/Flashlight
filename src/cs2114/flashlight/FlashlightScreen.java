package cs2114.flashlight;

import sofia.graphics.RectangleShape;
import sofia.graphics.OvalShape;
import android.view.MotionEvent;
import sofia.app.ShapeScreen;
import sofia.graphics.Color;

// -------------------------------------------------------------------------
/**
 * This creates an app for Android that creates a white oval that follows the
 * movement of a touch on the screen
 *
 * @author Laura Graham (laura10)
 * @author Meredith McGlynn (mmmere3)
 * @version 2012.10.04
 */
public class FlashlightScreen
    extends ShapeScreen
{
    private OvalShape      light;
    private RectangleShape box;
    private RectangleShape box2;
    private RectangleShape box3;
    private RectangleShape box4;


    // ----------------------------------------------------------
    /**
     * This sets the background to black
     */
    public void initialize()
    {
        setBackgroundColor(Color.black);
        box = new RectangleShape(0, 0, 25, 25);
        box.setColor(Color.white);
        box.setFilled(true);
        add(box);

        box2 = new RectangleShape(getWidth() - 25, 0, getWidth(), 25);
        box2.setColor(Color.red);
        box2.setFilled(true);
        add(box2);

        box3 = new RectangleShape(0, getHeight() - 25, 25, getHeight());
        box3.setColor(Color.green);
        box3.setFilled(true);
        add(box3);

        box4 =
            new RectangleShape(
                getWidth() - 25,
                getHeight() - 25,
                getWidth(),
                getHeight());
        box4.setColor(Color.blue);
        box4.setFilled(true);
        add(box4);

    }


    // ----------------------------------------------------------
    /**
     * This creates a white oval when the screen is touched
     *
     * @param event
     *            the touch
     */
    public void onTouchDown(MotionEvent event)
    {
        float x = event.getX();
        float y = event.getY();
        light = new OvalShape(x, y, 50);
        light.setColor(Color.white);
        light.setFilled(true);
        add(light);
    }


    // ----------------------------------------------------------
    /**
     * This is what the shape does when the touch moves - the oval moves with
     * the touch
     *
     * @param event
     *            the touch
     */
    public void onTouchMove(MotionEvent event)
    {
        float x = event.getX() - 50;
        float y = event.getY() - 50;
        light.setPosition(x, y);
    }


    // ----------------------------------------------------------
    /**
     * This removes the white oval when the touch is removed
     *
     * @param event
     *            the touch
     */
    public void onTouchUp(MotionEvent event)
    {
        light.animate(500).alpha(0).removeWhenComplete().play();
    }


    // ----------------------------------------------------------
    /**
     * This method changes the color of the oval when it is collied with the
     * rectangles.
     *
     * @param oval
     *            is the oval that is being moved
     * @param rectangle
     *            is the rectangle that the oval hits
     */
    public void onCollisionBetween(OvalShape oval, RectangleShape rectangle)
    {
        oval.animate(500).fillColor(rectangle.getColor()).play();
    }

}
