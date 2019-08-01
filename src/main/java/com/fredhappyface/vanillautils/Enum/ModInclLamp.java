package com.fredhappyface.vanillautils.Enum;

import com.fredhappyface.vanillautils.lib.blocks.InvertedRedstoneLampBlock;
import com.fredhappyface.vanillautils.lib.blocks.ModDoorBlock;
import com.fredhappyface.vanillautils.lib.blocks.ModPaneBlock;
import com.fredhappyface.vanillautils.lib.blocks.ModStairsBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.LazyLoadBase;

import java.util.Locale;

public enum ModInclLamp {
    IRON(Items.IRON_INGOT,
            Blocks.IRON_BLOCK),
    GOLD(Items.GOLD_INGOT,
            Blocks.GOLD_BLOCK),
    DIAMOND(Items.DIAMOND,
            Blocks.DIAMOND_BLOCK),
    COAL(Items.COAL,
            Blocks.COAL_BLOCK),
    CHARCOAL(Items.CHARCOAL,
            Blocks.COAL_BLOCK),
    EMERALD(Items.EMERALD,
            Blocks.EMERALD_BLOCK);

    // Attrs


    private final Item item;
    private final Block block;



    // Blocks

    private final LazyLoadBase<Block> storageBlock;
    private final LazyLoadBase<ModPaneBlock> bars;
    private final LazyLoadBase<ModDoorBlock> door;
    private final LazyLoadBase<RedstoneLampBlock> lamp;
    private final LazyLoadBase<InvertedRedstoneLampBlock> lampInverted;


    private final LazyLoadBase<Block> bricks;
    private final LazyLoadBase<SlabBlock> slab;
    private final LazyLoadBase<StairsBlock> stairs;
    private final LazyLoadBase<SlabBlock> brickSlab;
    private final LazyLoadBase<StairsBlock> brickStairs;





    ModInclLamp(final Item item, final Block block) {
        // Attrs
        this.item = item;
        this.block = block;




        // Blocks

        final Block.Properties blockProperties = Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL);



        bars = new LazyLoadBase<>(() -> new ModPaneBlock(blockProperties));
        door = new LazyLoadBase<>(() -> new ModDoorBlock(blockProperties));

        final  Block.Properties gemLightProperties = Block.Properties.create(Material.REDSTONE_LIGHT).hardnessAndResistance(0.3f, 15).lightValue(15);

        lamp = new LazyLoadBase<>(() -> new RedstoneLampBlock(gemLightProperties));
        lampInverted = new LazyLoadBase<>(() -> new InvertedRedstoneLampBlock(gemLightProperties));


        storageBlock = new LazyLoadBase<>(() -> new Block(blockProperties));

        bricks = new LazyLoadBase<>(() -> new Block(blockProperties));
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


    public ModPaneBlock getBars(){return bars.getValue();}
    public ModDoorBlock getDoor(){return door.getValue();}
    public RedstoneLampBlock getLamp(){return lamp.getValue();}
    public InvertedRedstoneLampBlock getLampInverted(){return lampInverted.getValue();}

    public Block getStorageBlock() {
        return storageBlock.getValue();
    }
    public Block getBricks() {
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
