package dk.eax;

import dk.eax.graphics.Line;

/**
 * Created by eax on 19/02/16.
 */
public class Cross extends Token {
    public Boolean draw(Field field){
        if(field.getToken() == null){
            Line segment = new Line(field.getCoordinate_x(), field.getCoordinate_y(), field.getCoordinate_x() + 200, field.getCoordinate_y() + 200);
            segment.draw();

            Line line = new Line(field.getCoordinate_x(), field.getCoordinate_y() + 200, field.getCoordinate_x() + 200, field.getCoordinate_y());
            line.draw();

            field.setToken(this);

            return true;
        }

        return false;
    }
}
