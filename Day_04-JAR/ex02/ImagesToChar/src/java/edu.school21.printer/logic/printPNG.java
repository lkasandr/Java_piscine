package edu.school21.printer.logic;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class printPNG {
    private String white;
    private String black;
    ColoredPrinter cp = new ColoredPrinter.Builder(1, false).build();

    public printPNG(String white, String black)
    {
        this.white = white;
        this.black = black;
    }

    public void print()
    {
        try {
            BufferedImage source = ImageIO.read(new File("src/resources/it.bmp"));
            for (int x = 0; x < source.getWidth(); x++) {
                for (int y = 0; y < source.getHeight(); y++)
                {
                    Color color = new Color(source.getRGB(y, x));
                    int blue = color.getBlue();
                    int red = color.getRed();
                    int green = color.getGreen();
                    if (blue == 0 && red == 0 && green == 0)
                        cp.print(" ", Ansi.Attribute.NONE, Ansi.FColor.NONE, Ansi.BColor.valueOf(this.black));
                    else
                        cp.print(" ", Ansi.Attribute.NONE, Ansi.FColor.NONE, Ansi.BColor.valueOf(this.white));
                }
                System.out.println();
            }
        }
        catch (IOException e)
        {
            System.out.println("Error in print");
        }

    }
}
