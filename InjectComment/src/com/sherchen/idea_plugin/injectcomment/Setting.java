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

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.sherchen.idea_plugin.injectcomment.util.InjectConstant;
import com.sherchen.idea_plugin.injectcomment.util.Utils;

import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The description of use:
 * <br />
 * Created time:2015/2/8 16:06
 * Created by Sherchen
 */
public class Setting implements Configurable {
    private JPanel panel1;
    private JTextField datetimeField;
    private JTextField usernameField;
    private JTextField addFlagField;
    private JTextField modifyFlagField;
    private JTextField removeFlagField;

    @Nls
    @Override
    public String getDisplayName() {
        return InjectConstant.SETTING_DISPLAY_NAME;
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        reset();
        return panel1;
    }

    @Override
    public boolean isModified() {
        return true;
    }

    @Override
    public void apply() throws ConfigurationException {
        Utils.setPropertyOfDateTimeFormat(datetimeField.getText());
        Utils.setPropertyOfUsername(usernameField.getText());
        Utils.setPropertyOfAddFlag(addFlagField.getText());
        Utils.setPropertyOfModifyFlag(modifyFlagField.getText());
        Utils.setPropertyOfRemoveFlag(removeFlagField.getText());
    }

    @Override
    public void reset() {
        datetimeField.setText(Utils.getPropertyOfDateTimeFormat());
        usernameField.setText(Utils.getPropertyOfUsername());
        addFlagField.setText(Utils.getPropertyOfAddFlag());
        modifyFlagField.setText(Utils.getPropertyOfModifyFlag());
        removeFlagField.setText(Utils.getPropertyOfRemoveFlag());
    }

    @Override
    public void disposeUIResources() {

    }
}
