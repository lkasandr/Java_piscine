package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class printPNG {
    private char white;
    private char black;
    private String path;

    public printPNG(char white, char black, String path)
    {
        this.white = white;
        this.black = black;
        this.path = path;
    }

    public void print()
    {
        try {
            BufferedImage source = ImageIO.read(new File(this.path));
            for (int x = 0; x < source.getWidth(); x++) {
                for (int y = 0; y < source.getHeight(); y++)
                {
                    if (source.getRGB(y, x) == -1)
                        System.out.print(this.white);
                    else
                        System.out.print(this.black);
                }
                System.out.println();
            }
        }
        catch (IOException e)
        {
            System.out.println("Invalid path to file");
        }

    }
}
