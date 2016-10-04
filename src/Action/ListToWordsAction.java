package Action;

/**
 * Created by wnbot on 16-10-4.
 */
public class ListToWordsAction extends ABSTextEditAction {

    @Override
    public String getNewText(String text) {
        String[] words = text.trim().split(",");
        StringBuilder newText = new StringBuilder(words[0].trim().replace("\"", ""));

        for (int i = 1; i < words.length; i++) {
            newText.append(" " + words[i].trim().replace("\"", ""));
        }
        return newText.toString();
    }
}
