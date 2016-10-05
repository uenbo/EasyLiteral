package Action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;

/**
 * Created by wnbot on 16-10-4.
 */
public abstract class ABSTextEditAction extends AnAction {


    @Override
    public void update(AnActionEvent e) {
        super.update(e);
        // Get required data keys
        final Project project = e.getData(CommonDataKeys.PROJECT);
        final Editor editor = e.getData(CommonDataKeys.EDITOR);

        // Set visibility only in case of existing project and editor
        // and if some text in the editor is selected
        e.getPresentation().setVisible(project != null && editor != null && editor.getSelectionModel().hasSelection());
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        // Get all the required data from data keys
        final Editor editor = anActionEvent.getRequiredData(CommonDataKeys.EDITOR);
        final Project project = anActionEvent.getRequiredData(CommonDataKeys.PROJECT);

        // Access document, caret, and selection
        final Document document = editor.getDocument();
        final SelectionModel selectionModel = editor.getSelectionModel();

        final CaretModel caretModel = editor.getCaretModel();

        // New instance of Runnable to make a replacement
        Runnable runnable = () -> {
            String text = "";
            int start = 0;
            int end = 0;
            if (selectionModel.hasSelection()) {
                start = selectionModel.getSelectionStart();
                end = selectionModel.getSelectionEnd();
                text = selectionModel.getSelectedText();
            } else {
                // Get current line text
                int lineStart = caretModel.getVisualLineStart();
                end = caretModel.getOffset();
                String lineText = document.getText(new TextRange(lineStart, end));

                // Check if the text we need convert is start with `
                int index = lineText.indexOf("`");
                if (index != -1) {
                    start = lineStart + index;
                    text = lineText.substring(index+1);
                } else {
                    return;
                }
            }

            // Get new string text
            String newText = getNewText(text);

            document.replaceString(start, end, newText);
        };

        // Making the replacement
        WriteCommandAction.runWriteCommandAction(project, runnable);
        selectionModel.removeSelection();
    }


    public abstract String getNewText(String text);

}