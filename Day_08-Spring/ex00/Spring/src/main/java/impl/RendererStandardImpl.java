package impl;

import interfaces.PreProcessor;
import interfaces.Renderer;

public class RendererStandardImpl implements Renderer {
    PreProcessor preProcessor;

    RendererStandardImpl(PreProcessor preProcessor)
    {
        this.preProcessor = preProcessor;
    }

    @Override
    public void printToConsole(String text) {
        System.err.println(preProcessor.preProcess(text));
    }
}
