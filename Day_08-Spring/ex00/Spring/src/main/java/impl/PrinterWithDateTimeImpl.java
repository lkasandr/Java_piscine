package impl;

import interfaces.Printer;
import interfaces.Renderer;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer {
    private Renderer renderer;

    PrinterWithDateTimeImpl(Renderer renderer)
    {
        this.renderer = renderer;
    }

    @Override
    public void print(String str) {
        renderer.printToConsole(LocalDateTime.now() + str);
    }
}
