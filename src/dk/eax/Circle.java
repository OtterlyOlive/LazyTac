package dk.eax;

import dk.eax.graphics.Ellipse;

/**
 * Created by eax on 19/02/16.
 */
public class Circle extends Token {
    public Boolean draw(Field field){
        if(field.getToken() == null) {
            int y = field.getCoordinate_y();
            int x = field.getCoordinate_x();

            Ellipse ellipsis = new Ellipse(x, y, 200, 200);
            ellipsis.draw();

            field.setToken(this);

            return true;
        }

        return false;
    }
}
