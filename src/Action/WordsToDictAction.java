package Action;

/**
 * Created by wnbot on 16-10-4.
 */
public class WordsToDictAction extends ABSTextEditAction {
    @Override
    public String getNewText(String text) {

        String[] words = text.trim().split(",");

        StringBuilder newText = new StringBuilder(processKV(words[0].trim()));

        for (int i = 1; i < words.length; i++) {
            newText.append(", ").append(processKV(words[i].trim()));
        }
        return newText.toString();
    }

    private String processKV(String s) {
        String[] kv = s.split("\\s?=\\s?");
        if (kv.length == 2) {
            if (kv[1].startsWith("+")) {
                return  "\"" + kv[0] + "\": " + kv[1].substring(1);
            }
            return "\"" + kv[0] + "\": \"" + kv[1] + "\"";
        } else {
            return s;
        }
    }
}
