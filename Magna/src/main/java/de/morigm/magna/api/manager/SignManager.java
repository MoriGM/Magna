package de.morigm.magna.api.manager;

import de.morigm.magna.api.sign.SignListener;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class SignManager {

    @Getter
    private final List<SignListener> signs = new ArrayList<>();

    public void registerSign(SignListener listener) {
        if (!signs.contains(listener) && !contains(listener.getName()))
            signs.add(listener);
    }

    public boolean contains(String name) {
        return find(name) != null;
    }

    public SignListener find(String name) {
        for (SignListener sign : signs) {
            if (sign.getName().equals(name)) {
                return sign;
            }
        }
        return null;
    }

}
