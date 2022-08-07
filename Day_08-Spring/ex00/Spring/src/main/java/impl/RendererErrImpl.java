package impl;

import interfaces.PreProcessor;
import interfaces.Renderer;

public class RendererErrImpl implements Renderer {
    PreProcessor preProcessor;

    RendererErrImpl(PreProcessor preProcessor)
    {
        this.preProcessor = preProcessor;
    }

    @Override
    public void printToConsole(String text) {
        System.out.println(preProcessor.preProcess(text));
    }
}
