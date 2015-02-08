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

/**
 * The description of use:
 * <br />
 * Created time:2015/2/5 19:19
 * Created by Dave
 */
public class InjectConstant {
    public static final String START = "//%1$s %2$s.%3$s.%4$s";

    public static final String END = "//End.%1$s.%2$s";

    public static final String PROPERTY_DATE_TIME_FORMAT = "sherchen.injectcomment.property.datetime";
    public static final String PROPERTY_USERNAME = "sherchen.injectcomment.property.username";
    public static final String PROPERTY_ADD_FLAG = "sherchen.injectcomment.property.add_flag";
    public static final String PROPERTY_MODIFY_FLAG = "sherchen.injectcomment.property.modify_flag";
    public static final String PROPERTY_REMOVE_FLAG = "sherchen.injectcomment.property.remove_flag";

    public static final String DEFAULT_DATETIME_FORMAT = "yyyy.MM.dd";
    public static final String DEFAULT_USERNAME = Utils.getDefaultUserName();
    public static final String DEFAULT_ADD_FLAG = "[A]";
    public static final String DEFAULT_MODIFY_FLAG = "[M]";
    public static final String DEFAULT_REMOVE_FLAG = "[R]";


    public static final String SETTING_DISPLAY_NAME = "Sherchen.InjectComment";
}
