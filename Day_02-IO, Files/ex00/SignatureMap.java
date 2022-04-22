package ex00;

import java.util.HashMap;
import java.util.Map;

public class SignatureMap {
    private Map<String, String> signatures = new HashMap<>();

    public void add(String key, String value)
    {
        key = key.replace(" ", "");
        this.signatures.put(key, value);
    }

    public Map<String, String> getSignatures()
    {
        return this.signatures;
    }
}
