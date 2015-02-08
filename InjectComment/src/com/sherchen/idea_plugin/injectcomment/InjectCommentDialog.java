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

import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.ValidationInfo;
import com.sherchen.idea_plugin.injectcomment.util.InjectConstant;
import com.sherchen.idea_plugin.injectcomment.util.Utils;

import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.Nullable;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * The description of use:
 * <br />
 * Created time:2015/2/5 21:07
 * Created by Dave
 */
public class InjectCommentDialog extends DialogWrapper{

private static final String LOG_TAG = InjectCommentDialog.class.getSimpleName();
private static final boolean DEBUG = true;
	private void debug(String msg) {
		if(DEBUG) android.util.Log.v(LOG_TAG, msg);
	}
    private JPanel panel1;
    private JTextField etComment;
    private JRadioButton rbAddRadioButton;
    private JRadioButton rbModifyRadioButton;
    private JRadioButton rbRemoveRadioButton;
    private ButtonGroup buttonGroup;

    private Editor m_Editor;
    private Project m_Project;

    private InjectWriteAction injectWriteAction;

    protected InjectCommentDialog(InjectWriteAction injectWriteAction, @Nullable Project project, Editor editor) {
        super(project, true);
        this.injectWriteAction = injectWriteAction;

//&M& some test code.Sherchen.2015.02.08 19:47:08
        m_Project = project;
        m_Editor = editor;
//End.Sherchen.2015.02.08 19:47:08
        setTitle("Please add the comment");
        setResizable(true);


//[A] some test code.Sherchen.2015.02.08
        buttonGroup = new ButtonGroup();
        buttonGroup.add(rbAddRadioButton);
        buttonGroup.add(rbModifyRadioButton);
        buttonGroup.add(rbRemoveRadioButton);
//End.Sherchen.2015.02.08

        buttonGroup.setSelected(rbAddRadioButton.getModel(), true);
        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return panel1;
    }

    @Nullable
    @Override
    protected ValidationInfo doValidate() {
        String comment = etComment.getText();
        if(StringUtils.isEmpty(comment)){
            return new ValidationInfo("Please type the comment", etComment);
        }
        return super.doValidate();
    }

    @Override
    protected void doOKAction() {
        String comment = etComment.getText();
        String flag = null;
        ButtonModel selectionModel = buttonGroup.getSelection();
        if(selectionModel == rbAddRadioButton.getModel()){
            flag = Utils.getPropertyOfAddFlag();
        }else if(selectionModel == rbModifyRadioButton.getModel()){
            flag = Utils.getPropertyOfModifyFlag();
        }else if(selectionModel == rbRemoveRadioButton.getModel()){
            flag = Utils.getPropertyOfRemoveFlag();
        }

        String endComment = String.format(InjectConstant.END, Utils.getPropertyOfUsername(), Utils.getDateTime());
        String startComment = String.format(InjectConstant.START, flag, comment, Utils.getPropertyOfUsername(), Utils.getDateTime());
        injectWriteAction.write(m_Project, m_Editor, startComment, endComment);
        super.doOKAction();
    }
}
