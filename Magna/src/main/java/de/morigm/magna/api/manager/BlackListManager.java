package de.morigm.magna.api.manager;

import de.morigm.magna.Main;
import de.morigm.magna.api.censor.BlackWord;

import java.util.List;

public class BlackListManager {

    public void addBlackWord(BlackWord bword) {
        if (!containsBlackWord(bword.word()))
            getBlackWords().add(bword);
    }

    public void removeBlackWord(BlackWord bword) {
        if (containsBlackWord(bword.word()))
            getBlackWords().remove(bword);
    }

    public boolean containsBlackWord(String word) {
        return getBlackWord(word) != null;
    }

    public BlackWord getBlackWord(String word) {
        for (BlackWord bword : getBlackWords())
            if (bword.word().equals(word))
                return bword;
        return null;
    }

    public List<BlackWord> getBlackWords() {
        return Main.Companion.getInstance().getBlackListLoader().getBlackWords();
    }

    public BlackWord getBlackWordFromText(String text) {
        for (BlackWord bword : getBlackWords())
            if (text.toLowerCase().contains(bword.word().toLowerCase()))
                return bword;
        return null;
    }

    public boolean hasBlackWord(String text) {
        return getBlackWordFromText(text) != null;
    }

}
