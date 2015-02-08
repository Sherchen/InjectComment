/*
 * Copyright (C) 2013-2015 Sherchen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sherchen.idea_plugin.injectcomment;

import com.intellij.codeInsight.CodeInsightActionHandler;
import com.intellij.codeInsight.generation.actions.BaseGenerateAction;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.editor.VisualPosition;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiUtilBase;

/**
 * The description of use:
 * <br />
 * Created time:2015/2/3 22:07
 * Created by Sherchen
 */
public class InjectComment extends BaseGenerateAction {
    public InjectComment() {
        super(new GenerateActionHandler());
    }

    public static class GenerateActionHandler implements CodeInsightActionHandler, InjectWriteAction{
        private int m_StartOffset;
        private int m_EndOffset;

        @Override
        public void invoke(Project project, Editor editor, PsiFile psiFile) {
            SelectionModel selection = editor.getSelectionModel();
            CaretModel caretModel = editor.getCaretModel();
            final int startLine = selection.getSelectionStartPosition().line;
            final int endLine = selection.getSelectionEndPosition().line;
            caretModel.moveToVisualPosition(new VisualPosition(endLine + 1, 0));
            m_EndOffset = caretModel.getOffset();
            caretModel.moveToVisualPosition(new VisualPosition(startLine, 0));
            m_StartOffset = caretModel.getOffset();
            InjectCommentDialog dialog = new InjectCommentDialog(this, project, editor);
            dialog.show();
        }

        @Override
        public boolean startInWriteAction() {
            return false;
        }

        private void warning(String title, String message) {
            Notification notification = new Notification("inject-comment-tag", title, message, NotificationType.WARNING);
            Notifications.Bus.notify(notification);
        }

        private void warning(String message){
            warning("Inject Comment", message);
        }

        @Override
        public void write(Project project, final Editor editor, final String startComment, final String endComment) {
            PsiFile file = PsiUtilBase.getPsiFileInEditor(editor, project);
            WriteCommandAction.Simple simple = new WriteCommandAction.Simple(project, "InjectCommand", file) {
                @Override
                protected void run() throws Throwable {
                    final Document document = editor.getDocument();
                    document.insertString(m_EndOffset, "\n");
                    document.insertString(m_EndOffset, endComment);
                    document.insertString(m_StartOffset, "\n");
                    document.insertString(m_StartOffset, startComment);
                }
            };
            simple.executeSilently();
        }
    }
}
