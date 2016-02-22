package dk.eax;

/**
 * Created by eax on 18/02/16.
 */
public class Field {
    private int width;
    private int height;
    private String label;

    // Coordinates are for the upper left corner pixel
    private int coordinate_x;
    private int coordinate_y;

    private Token token = null;

    public Field(int width, int height, String label, int coordinate_x, int coordinate_y) {
        this.width = width;
        this.height = height;
        this.label = label;
        this.coordinate_x = coordinate_x;
        this.coordinate_y = coordinate_y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getCoordinate_x() {
        return coordinate_x;
    }

    public void setCoordinate_x(int coordinate_x) {
        this.coordinate_x = coordinate_x;
    }

    public int getCoordinate_y() {
        return coordinate_y;
    }

    public void setCoordinate_y(int coordinate_y) {
        this.coordinate_y = coordinate_y;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
