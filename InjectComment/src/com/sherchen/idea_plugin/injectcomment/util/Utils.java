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
package com.sherchen.idea_plugin.injectcomment.util;

import com.intellij.ide.util.PropertiesComponent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * The description of use:
 * <br />
 * Created time:2015/2/5 19:25
 * Created by Dave
 */
public class Utils {

    private static String s_UserName;

    static{
        Map<String, String> map = System.getenv();
        s_UserName = map.get("USERNAME");
    }

    public static String getDefaultUserName(){
        return s_UserName;
    }


    public static String getDateTime(){
        SimpleDateFormat sdf = new SimpleDateFormat(getPropertyOfDateTimeFormat());
        return sdf.format(new Date(System.currentTimeMillis()));
    }

    public static final String getPropertyOfDateTimeFormat(){
        return PropertiesComponent.getInstance().getValue(InjectConstant.PROPERTY_DATE_TIME_FORMAT, InjectConstant.DEFAULT_DATETIME_FORMAT);
    }

    public static final void setPropertyOfDateTimeFormat(String dateTimeFormat){
        PropertiesComponent.getInstance().setValue(InjectConstant.PROPERTY_DATE_TIME_FORMAT, dateTimeFormat);
    }

    public static final String getPropertyOfUsername(){
        return PropertiesComponent.getInstance().getValue(InjectConstant.PROPERTY_USERNAME, InjectConstant.DEFAULT_USERNAME);
    }

    public static final void setPropertyOfUsername(String username){
        PropertiesComponent.getInstance().setValue(InjectConstant.PROPERTY_USERNAME, username);
    }

    public static final String getPropertyOfAddFlag(){
        return PropertiesComponent.getInstance().getValue(InjectConstant.PROPERTY_ADD_FLAG, InjectConstant.DEFAULT_ADD_FLAG);
    }

    public static final void setPropertyOfAddFlag(String addFlag){
        PropertiesComponent.getInstance().setValue(InjectConstant.PROPERTY_ADD_FLAG, addFlag);
    }

    public static final String getPropertyOfModifyFlag(){
        return PropertiesComponent.getInstance().getValue(InjectConstant.PROPERTY_MODIFY_FLAG, InjectConstant.DEFAULT_MODIFY_FLAG);
    }

    public static final void setPropertyOfModifyFlag(String modifyFlag){
        PropertiesComponent.getInstance().setValue(InjectConstant.PROPERTY_MODIFY_FLAG, modifyFlag);
    }

    public static final String getPropertyOfRemoveFlag(){
        return PropertiesComponent.getInstance().getValue(InjectConstant.PROPERTY_REMOVE_FLAG, InjectConstant.DEFAULT_REMOVE_FLAG);
    }

    public static final void setPropertyOfRemoveFlag(String removeFlag){
        PropertiesComponent.getInstance().setValue(InjectConstant.PROPERTY_REMOVE_FLAG, removeFlag);
    }
}
