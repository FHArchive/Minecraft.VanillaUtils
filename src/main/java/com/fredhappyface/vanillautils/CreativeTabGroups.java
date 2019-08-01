package com.fredhappyface.vanillautils;


import com.fredhappyface.vanillautils.Enum.ModInclTools;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CreativeTabGroups {


    public static final ItemGroup ITEM_GROUP_TOOLS = new ItemGroup(Main.MOD_ID + ".tools") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModInclTools.GRANITE.getPickaxeItem());
        }
    };

    public static final ItemGroup ITEM_GROUP_DECORATION = new ItemGroup(Main.MOD_ID + ".decoration") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModInclTools.GRANITE.getBricks());
        }
    };



    public static final ItemGroup ITEM_GROUP_ARMOUR = new ItemGroup(Main.MOD_ID + ".armor") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModInclTools.GRANITE.getChest());
        }
    };

    
    

}
