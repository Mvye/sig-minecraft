This plugin is intended be used as a base, by itself it will just make a message in the console saying the plugin has 
started/stopped.

## Prerequistes
This plugin uses spigot api 1.17.1. The file can be found in the sig-minecraft folder under `Dependencies`. Check the
setup.md file to see how to add the jar as a dependency in intellij. 

## Items to change
1. Plugin name, change `BasePlugin` to your desired plugin name in the following locations:
    * The biggest folder name `BasePlugin`
    * The package name `BasePlugin/src/com.mvye.baseplugin`
        * `mvye` to your github/developer name
        * `baseplugin` to your plugin name
    * idk what this file is for `BasePlugin/BasePlugin.iml`
    * The main plugin file `BasePlugin/src/com.mvye.baseplugin/BasePlugin.java`
        * every `baseplugin`
        * every `mvye`
        
## Building
Check the setup.md's `Building the Plugin` section.