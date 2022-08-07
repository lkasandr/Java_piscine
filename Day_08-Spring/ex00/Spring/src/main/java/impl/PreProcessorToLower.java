package impl;

import interfaces.PreProcessor;

public class PreProcessorToLower implements PreProcessor {
    @Override
    public String preProcess(String message) {
        return message.toLowerCase();
    }
}
