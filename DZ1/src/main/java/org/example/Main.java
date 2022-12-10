package org.example;
import java.awt.*;
import java.util.HashMap;

public class Main
{
    int r = 255;
    int g = 0;
    int b = 0;

    HashMap<Color, String> colors = new HashMap<Color, String>();{
    colors.put(Color.BLACK,"BLACK");
    colors.put(Color.BLUE,             "BLUE");
    colors.put(Color.CYAN,             "CYAN");
    colors.put(Color.DARK_GRAY,        "DARK_GRAY");
    colors.put(Color.GRAY,             "GRAY");
    colors.put(Color.GREEN,            "GREEN");
    colors.put(Color.LIGHT_GRAY,       "LIGHT_GRAY");
    colors.put(Color.MAGENTA,          "MAGENTA");
    colors.put(Color.ORANGE,           "ORANGE");
    colors.put(Color.PINK,             "PINK");
    colors.put(Color.RED,              "RED");
    colors.put(Color.WHITE,            "WHITE");
    colors.put(new Color(192, 0, 255), "PURPLE");
    colors.put(new Color(0xBADA55),    "BADASS_GREEN");
    colors.put(new Color(0, 0, 128),   "DARK_BLUE");
}
    Color color = new Color(r, g, b);
    String colorName = colors.get(color);
}


