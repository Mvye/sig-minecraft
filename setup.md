# SIG Minecraft Coding Environment Setup

This will be a walkthrough of setting up the code environment for sig minecraft. By the end of this document you should have an empty plugin which we can build upon in future meetings. You do not have to do this before the first meeting, but if you are able to then you can skip the first meeting. In the first meeting, I will go over this entire setup and provide help. 


## Initial Setup Steps
1. Download Java JDK 17 from here [https://www.oracle.com/java/technologies/downloads/#jdk17](https://www.oracle.com/java/technologies/downloads/#jdk17)
    1. Select Windows x64 Installer and click on the exe to the right (instructions will vary for other Operating Systems)
    2. Note: you will need an oracle account to download it. 
2. Open and run the .exe you got from step 1. Click next for any prompts 
3. Get Intellij from here [https://www.jetbrains.com/idea/download/#section=windows](https://www.jetbrains.com/idea/download/#section=windows)
    1. Can get free one OR use njit email, install it. During setup add 64 bit launcher to desktop and add to PATH
4. Get latest version of paper mc from here : [https://papermc.io/downloads](https://papermc.io/downloads)
5. Create a new folder, call it whatever you want (I called it `Plugin`. This folder will house everything for your plugin.
    1. Inside of this folder make two more folders. One called `Server` and one called `Dependencies`


## Minecraft Server Setup
1. Take the jar file you downloaded from papermc and put it in your `Server` folder you created earlier
2. Rename the file to `sever.jar`
3. Create a text file with the name run
4. Open the text file 
    1. Paste this inside:
        ```html
        java -Xmx1G -jar server.jar nogui
        PAUSE
        ```
5. Save this file as `run.bat` and put inside your `Server` folder. 
6. Double click `run.bat` to start your server. 
    1. The server starting process will stop because you need to agree to the eula. Look in your `Server` for a `eula.txt`
    2. Open `eula.txt` and change the `false` to `true`
    3. Save and close `eula.txt`
7. Double click `run.bat` again, this time it will create your server. This file will be how you start your server in the future.
8. After it finishes setting up, you can close the server by typing `stop`


## Creating an Empty Plugin
1. In your `Plugin` folder, create a new folder that will be the name of your plugin. I named it `FirstPlugin` 
2. Open up Intelij
    1. Make a new project via File > New > Project
    2. Make sure it's in Java, don't click any of the additional libraries and frameworks just press next
    3. On the 'Create project from template" part, press next
    4. Then it will ask you to name the project, use the name of your plugin, in my case `FirstPlugin`
    5. Change your project location to the new folder you created in step 1
    6. Click Finish.


## Adding the Spigot dependency
1. Go to this link [https://hub.spigotmc.org/nexus/content/repositories/snapshots/org/spigotmc/spigot-api/](https://hub.spigotmc.org/nexus/content/repositories/snapshots/org/spigotmc/spigot-api/) and click on the link of the minecraft version you want to make your plugin on (we'll be using 1.17.1)
2. Click on the closest pure .jar file (without shaded or sources) to download it
3. Rename the jar file to just `spigot-api-{milecraft version}.jar` and put it in your `Dependecies` folder we made in the `Plugins` folder
4. In Intellij, go to File>Project Structure; then on the project settings (on the left) click on modules 
5. Then click on dependencies, and click the plus icon 
    ![](https://i.imgur.com/knatjSu.png)
    1. (You shouldn't see spigot-api there initially)
6. After clicking on the plug icon, click JARS or directories and navigate to and select the jar file you placed in your `Dependecies` folder
7. Press Okay to select the jar and then press Apply.
8. Press Okay once again, then you're done

## Creating the Plugin
1. Right click on the src folder, then new, then package; name this package in this format `com.<github username>.<plugin name>`. Replace `<github username>` and `<plugin name>` with your github and plugin names. All lowercase, no spaces. Note: You don't have to use github username, use whatever you want to use to identify yourself as the developer of the plugin.
2. Right click your package, then new, then java class; name this class the same as your plugin name. example: `FirstPlugin`
3. Enter this code in. I do not recommend just copy pasting it. First extend `JavaPlugin`, then manually create both the `onEnable` and `onDisable` functions. Replace `<Plugin_Name>` with your plugin name. 
```java
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class <Plugin_Name> extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[<Plugin_Name>]: Plugin is enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[<Plugin_Name>]: Plugin is disabled!");
    }
}
```
4. Then right click src, then new, then file; name this file `plugin.yml`
```yaml
name: EmptyPlugin
version: 1.0
author: Mvye
main: com.mvye.emptyplugin.EmptyPlugin
api-version: 1.17
```
This is what a plugin.yml file should look like. The least straightforward part of this file is the main. It's just the path to your Java class. Update the name, author, and main sections to have your plugin name, github name, and path to class file. 

## Building the Plugin
1. Go to File > Project Structure > Artifacts (on the left under project settings)
2. Click on the + icon, then JAR, from module with dependencies
![](https://i.imgur.com/7awz2Ci.png)
3. All the settings should be the same on the window that pops up, press Ok.
4. Then change your output directory to the Plugins folder in your Server folder which houses your papermc. This is so whenever you build your plugin it's always ready to go.

## Testing out the Plugin
This is for whenever you want to test the plugin/build it

1. On the top bar, go to Build > Build Artifacts , a pop up will pop up, press Build.
2. This should build the plugin into your plugins folder and you can then just start the server to test out the plugin. Please note that you should always restart if you made a change to a plugin while the server is running.

## Final Product

When you run the server after building it, you should see something similar to this in the console. If you get any errors or problems, see if you can figure out the issue. If you're stuck for over 30 minutes, DM me on discord and I'll try to help. 
![](https://i.imgur.com/pQ3iugB.png)


## Resources Used
1. [TechnoVision's Spigot Tutorial #1](https://youtu.be/lJyTEuqLQfU)
2. [TechnoVision's Spigot Tutorial #2](https://youtu.be/WcFb0GO14zY)
3. [Kody Simpson's How to Make a Spigot Minecraft Server with Java 16](https://youtu.be/B0CyGUDxkDI)
