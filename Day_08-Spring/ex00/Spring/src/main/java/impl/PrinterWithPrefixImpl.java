package impl;

import interfaces.Printer;
import interfaces.Renderer;

import java.time.LocalDateTime;

public class PrinterWithPrefixImpl implements Printer{
    private Renderer renderer;
    private String prefix;

    PrinterWithPrefixImpl(Renderer renderer)
    {
        this.renderer = renderer;
    }

    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }

    @Override
    public void print(String str) {
        renderer.printToConsole(prefix + " " + str);
    }
}
