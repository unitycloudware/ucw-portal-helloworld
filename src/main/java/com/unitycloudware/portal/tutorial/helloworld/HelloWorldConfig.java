/* Copyright 2017 Unity{Cloud}Ware - UCW Industries Ltd. All rights reserved.
 */

package com.unitycloudware.portal.tutorial.helloworld;

import java.util.Properties;

import org.nsys.util.ConfigurationManager;

/**
 * Hello World Config
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://unitycloudware.com">Unity{Cloud}Ware</a>
 */
public class HelloWorldConfig {

    public static final String CONFIG_NAME = "ucw-helloworld.cfg";
    public static final String CONFIG_NAME_INTERNAL = "ucw-helloworld.cfg.internal";
    public static final String VERSION = "ucw.helloworld.version";
    public static final String PLUGIN_KEY = "ucw.helloworld.pluginKey";

    public static void loadConfig() {
        ConfigurationManager config = ConfigurationManager.getInstance();

        Properties props = config.loadConfig(String.format("/%s", CONFIG_NAME), HelloWorldConfig.class);

        if (props != null) {
            config.merge(props);
        }

        props = config.loadConfig(String.format("/%s", CONFIG_NAME_INTERNAL), HelloWorldConfig.class);

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