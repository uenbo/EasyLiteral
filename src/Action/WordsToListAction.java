package Action;

/**
 * Created by wnbot on 16-10-4.
 */
public class WordsToListAction extends ABSTextEditAction {

    @Override
    public String getNewText(String text) {
        String[] words = text.trim().split("\\s+");
        StringBuilder newText = new StringBuilder("\"" + words[0] + "\"");

        for (int i = 1; i < words.length; i++) {
            newText.append(", \"").append(words[i]).append("\"");
        }

        return newText.toString();
    }


}
