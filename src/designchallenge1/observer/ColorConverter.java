package designchallenge1.observer;

import java.awt.*;

public class ColorConverter {
    public Color convertColor(String color) {
        switch (color) {
            case "green": return Color.green;
            case "red": return Color.RED;
            case "blue": return Color.blue;
            case "orange": return Color.orange;
            case "purple": return Color.magenta;
            default: return Color.black;
        }
    }
}
