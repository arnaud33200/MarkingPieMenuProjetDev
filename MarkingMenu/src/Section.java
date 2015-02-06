import java.awt.Color;

public class Section {
    private int number;
    private float angle;
    private Color color;
    private String name;

    public Section(int number, float angle, Color color, String name) {
        this.number = number;
        this.angle = angle;
        this.color = color;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public float getAngle() {
        return angle;
    }

    public Color getColor() {
        return color;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void setNumber(int number) {
        this.number = number;
    }      
}
