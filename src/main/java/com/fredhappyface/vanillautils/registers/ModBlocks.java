package com.fredhappyface.vanillautils.registers;

import com.fredhappyface.vanillautils.CreativeTabGroups;
import com.fredhappyface.vanillautils.Enum.ModDecorBlock;
import com.fredhappyface.vanillautils.Enum.ModInclLamp;
import com.fredhappyface.vanillautils.Enum.ModInclTools;
import com.fredhappyface.vanillautils.Main;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;


public class ModBlocks {

    // Example block with public access
    /*
    public static Block myblock;
     */

    // Namespaces
    private static final String DECORATIONS  = "decorations/";


    public static void registerAll(final RegistryEvent.Register<Block> event){


        if (!event.getName().equals(ForgeRegistries.BLOCKS.getRegistryName())) {
            return;
        }



        // Example block registration
        /*
        myblock = register("myblock", new Block(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(1.5F, 6.0F)
                .sound(SoundType.STONE)));
         */

        register("decoration_block", new Block(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(1.5F, 6.0F)
                .sound(SoundType.STONE)), CreativeTabGroups.ITEM_GROUP_DECORATION);


        // Decoration Blocks, Slabs, Stairs
        for (final ModInclTools block : ModInclTools.values()) {
            register(DECORATIONS + block.getName() + "_bricks", block.getBricks(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + block.getName() + "_brick_slab", block.getBrickSlab(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + block.getName() + "_brick_stairs", block.getBrickStairs(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + block.getName() + "_slab", block.getSlab(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + block.getName() + "_stairs", block.getStairs(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + block.getName() + "_bars", block.getBars(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + block.getName() + "_door", block.getDoor(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + block.getName() + "_lamp", block.getLamp(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + block.getName() + "_lamp_inverted", block.getLampInverted(), CreativeTabGroups.ITEM_GROUP_DECORATION);


        }

        for (final ModInclLamp block : ModInclLamp.values()) {
            register("storage_blocks/" + block.getName() + "_block", block.getStorageBlock(), CreativeTabGroups.ITEM_GROUP_DECORATION);

            register(DECORATIONS + block.getName() + "_bricks", block.getBricks(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + block.getName() + "_brick_slab", block.getBrickSlab(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + block.getName() + "_brick_stairs", block.getBrickStairs(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + block.getName() + "_slab", block.getSlab(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + block.getName() + "_stairs", block.getStairs(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + block.getName() + "_bars", block.getBars(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + block.getName() + "_door", block.getDoor(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + block.getName() + "_lamp", block.getLamp(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + block.getName() + "_lamp_inverted", block.getLampInverted(), CreativeTabGroups.ITEM_GROUP_DECORATION);


        }

        for (final ModDecorBlock block : ModDecorBlock.values()) {
            register(DECORATIONS + block.getName() + "_bricks", block.getBricks(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + block.getName() + "_brick_slab", block.getBrickSlab(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + block.getName() + "_brick_stairs", block.getBrickStairs(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + block.getName() + "_slab", block.getSlab(), CreativeTabGroups.ITEM_GROUP_DECORATION);
            register(DECORATIONS + block.getName() + "_stairs", block.getStairs(), CreativeTabGroups.ITEM_GROUP_DECORATION);


        }

        

    }

    /**
     * Lazy block registration. Item to put in creative tab automatically generated with tag ITEM_GROUP_RESOURCES
     * @param name name of the block (unlocalized)
     * @param block the block object
     * @return block
     */
    @SuppressWarnings("UnusedReturnValue")
    private static <T extends Block> T register(final String name, final T block){
        return register(name, block, new BlockItem(block, new Item.Properties().group(CreativeTabGroups.ITEM_GROUP_DECORATION)));
    }

    @SuppressWarnings({"UnusedReturnValue", "SameParameterValue"})
    private static <T extends Block> T register(final String name, final T block, final ItemGroup itemGroup){
        return register(name, block, new BlockItem(block, new Item.Properties().group(itemGroup)));
    }

    /**
     * Long hand block registration. Can specify a different creative tab or hide from creative mode by passing null
     * @param name name of the block (unlocalized)
     * @param block the block object
     * @param item the item to add to the creative tab
     * @return block
     */
    private static <T extends Block> T register(final String name, final T block, @Nullable final BlockItem item ){
        final ResourceLocation resourceId = Main.getId(name);
        block.setRegistryName(resourceId);
        ForgeRegistries.BLOCKS.register(block);
        if (item != null){
            ModItems.BLOCKS_TO_REGISTER.put(name, item);
            return block;
        }
        return block;
    }


}
