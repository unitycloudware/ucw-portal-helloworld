/* Copyright 2018 Unity{Cloud}Ware - UCW Industries Ltd. All rights reserved.
 */

package com.unitycloudware.portal.template;

import java.util.Properties;

import org.nsys.util.ConfigurationManager;

/**
 * Template Config
 *
 * @author Author <author@email>
 * @see <a href="http://some.url">Some text</a>
 */
public class TemplateConfig {

    public static final String CONFIG_NAME = "ucw-template.cfg";
    public static final String CONFIG_NAME_INTERNAL = "ucw-template.cfg.internal";
    public static final String VERSION = "ucw.template.version";
    public static final String PLUGIN_KEY = "ucw.template.pluginKey";

    public static void loadConfig() {
        ConfigurationManager config = ConfigurationManager.getInstance();

        Properties props = config.loadConfig(String.format("/%s", CONFIG_NAME), TemplateConfig.class);

        if (props != null) {
            config.merge(props);
        }

        props = config.loadConfig(String.format("/%s", CONFIG_NAME_INTERNAL), TemplateConfig.class);

        if (props != null) {
            config.merge(props, true);
        }
    }

    public static String getVersion() {
        String version = ConfigurationManager.getInstance().getProperty(VERSION);
        return ConfigurationManager.getVersion(version);
    }

    public static String getBuildNumber() {
        String version = ConfigurationManager.getInstance().getProperty(VERSION);
        return ConfigurationManager.getBuildNumber(version);
    }

    public static String getPluginKey() {
        return ConfigurationManager.getInstance().getProperty(PLUGIN_KEY);
    }
}
