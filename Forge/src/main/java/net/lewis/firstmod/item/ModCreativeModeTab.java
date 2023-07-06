package net.lewis.firstmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab FIRST_TAB = new CreativeModeTab("firsttab") {  //Makes a new tab in the creative mod window
        @Override
        public ItemStack makeIcon() {
        return new ItemStack(ModItems.ZIRCON.get());  //Creates the icon of the creative mode tab
        }
    };

}
