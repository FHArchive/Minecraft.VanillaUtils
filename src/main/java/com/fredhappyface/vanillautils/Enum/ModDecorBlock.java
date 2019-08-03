package com.fredhappyface.vanillautils.Enum;

import com.fredhappyface.vanillautils.lib.blocks.ModBlock;
import com.fredhappyface.vanillautils.lib.blocks.ModStairsBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.LazyLoadBase;

import java.util.Locale;

public enum ModDecorBlock {
    DIRT(Items.DIRT,
            Blocks.DIRT),
    GLASS(Items.GLASS,
            Blocks.GLASS),

    REDSTONE(Items.REDSTONE,
            Blocks.REDSTONE_BLOCK),
    WOOL_WHITE(Items.WHITE_WOOL,
            Blocks.WHITE_WOOL),
    WOOL_ORANGE(Items.ORANGE_WOOL,
            Blocks.ORANGE_WOOL),
    WOOL_MAGENTA(Items.MAGENTA_WOOL,
            Blocks.MAGENTA_WOOL),
    WOOL_BLUE_LIGHT(Items.LIGHT_BLUE_WOOL,
            Blocks.LIGHT_BLUE_WOOL),
    WOOL_YELLOW(Items.YELLOW_WOOL,
            Blocks.YELLOW_WOOL),
    WOOL_LIME(Items.LIME_WOOL,
            Blocks.LIME_WOOL),
    WOOL_PINK(Items.PINK_WOOL,
            Blocks.PINK_WOOL),
    WOOL_GRAY(Items.GRAY_WOOL,
            Blocks.GRAY_WOOL),
    WOOL_GRAY_LIGHT(Items.LIGHT_GRAY_WOOL,
            Blocks.LIGHT_GRAY_WOOL),
    WOOL_CYAN(Items.CYAN_WOOL,
            Blocks.CYAN_WOOL),
    WOOL_PURPLE(Items.PURPLE_WOOL,
            Blocks.PURPLE_WOOL),
    WOOL_BLUE(Items.BLUE_WOOL,
            Blocks.BLUE_WOOL),
    WOOL_BROWN(Items.BROWN_WOOL,
            Blocks.BROWN_WOOL),
    WOOL_GREEN(Items.GREEN_WOOL,
            Blocks.GREEN_WOOL),
    WOOL_RED(Items.RED_WOOL,
            Blocks.RED_WOOL),
    WOOL_BLACK(Items.BLACK_WOOL,
            Blocks.BLACK_WOOL),
    GLASS_WHITE(Items.WHITE_STAINED_GLASS,
            Blocks.WHITE_STAINED_GLASS),
    GLASS_ORANGE(Items.ORANGE_STAINED_GLASS,
            Blocks.ORANGE_STAINED_GLASS),
    GLASS_MAGENTA(Items.MAGENTA_STAINED_GLASS,
            Blocks.MAGENTA_STAINED_GLASS),
    GLASS_BLUE_LIGHT(Items.LIGHT_BLUE_STAINED_GLASS,
            Blocks.LIGHT_BLUE_STAINED_GLASS),
    GLASS_YELLOW(Items.YELLOW_STAINED_GLASS,
            Blocks.YELLOW_STAINED_GLASS),
    GLASS_LIME(Items.LIME_STAINED_GLASS,
            Blocks.LIME_STAINED_GLASS),
    GLASS_PINK(Items.PINK_STAINED_GLASS,
            Blocks.PINK_STAINED_GLASS),
    GLASS_GRAY(Items.GRAY_STAINED_GLASS,
            Blocks.GRAY_STAINED_GLASS),
    GLASS_GRAY_LIGHT(Items.LIGHT_GRAY_STAINED_GLASS,
            Blocks.LIGHT_GRAY_STAINED_GLASS),
    GLASS_CYAN(Items.CYAN_STAINED_GLASS,
            Blocks.CYAN_STAINED_GLASS),
    GLASS_PURPLE(Items.PURPLE_STAINED_GLASS,
            Blocks.PURPLE_STAINED_GLASS),
    GLASS_BLUE(Items.BLUE_STAINED_GLASS,
            Blocks.BLUE_STAINED_GLASS),
    GLASS_BROWN(Items.BROWN_STAINED_GLASS,
            Blocks.BROWN_STAINED_GLASS),
    GLASS_GREEN(Items.GREEN_STAINED_GLASS,
            Blocks.GREEN_STAINED_GLASS),
    GLASS_RED(Items.RED_STAINED_GLASS,
            Blocks.RED_STAINED_GLASS),
    GLASS_BLACK(Items.BLACK_STAINED_GLASS,
            Blocks.BLACK_STAINED_GLASS);

    // Attrs


    private final Item item;
    private final Block block;



    // Blocks


    private final LazyLoadBase<ModBlock> bricks;
    private final LazyLoadBase<SlabBlock> slab;
    private final LazyLoadBase<StairsBlock> stairs;
    private final LazyLoadBase<SlabBlock> brickSlab;
    private final LazyLoadBase<StairsBlock> brickStairs;



    ModDecorBlock(final Item item, final Block block) {
        // Attrs
        this.item = item;
        this.block = block;


        // Blocks

        final Block.Properties blockProperties = Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL);



        bricks = new LazyLoadBase<>(() -> new ModBlock(blockProperties));
        slab = new LazyLoadBase<>(() -> new SlabBlock(blockProperties));
        stairs = new LazyLoadBase<>(() -> new ModStairsBlock(getBlock().getDefaultState(),blockProperties));
        brickSlab = new LazyLoadBase<>(() -> new SlabBlock(blockProperties));
        brickStairs = new LazyLoadBase<>(() -> new ModStairsBlock(getBlock().getDefaultState(),blockProperties));




    }


    // Attrs
    public String getName() {
        // Locale.ROOT will ensure consistent behavior (prevent crashes) on all locales
        return name().toLowerCase(Locale.ROOT);
    }

    public Item getItem(){ return item;}
    public Block getBlock(){ return block;}



    // Blocks



    public ModBlock getBricks() {
        return bricks.getValue();
    }
    public SlabBlock getSlab() {
        return slab.getValue();
    }
    public StairsBlock getStairs() {
        return stairs.getValue();
    }
    public SlabBlock getBrickSlab() {
        return brickSlab.getValue();
    }
    public StairsBlock getBrickStairs() {
        return brickStairs.getValue();
    }



    }
