package me.petterim1.disableblockupdates;

import cn.nukkit.event.Listener;
import cn.nukkit.level.Level;
import cn.nukkit.plugin.PluginBase;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Plugin extends PluginBase implements Listener {

    public void onLoad() {
        try {
            Field f_randomTickBlocks = Level.class.getDeclaredField("randomTickBlocks");
            f_randomTickBlocks.setAccessible(true);
            Field f_modifiers = Field.class.getDeclaredField("modifiers");
            f_modifiers.setAccessible(true);
            f_modifiers.setInt(f_randomTickBlocks, f_randomTickBlocks.getModifiers() & ~Modifier.FINAL);
            f_randomTickBlocks.set(null, new boolean[((boolean[]) f_randomTickBlocks.get(null)).length]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
