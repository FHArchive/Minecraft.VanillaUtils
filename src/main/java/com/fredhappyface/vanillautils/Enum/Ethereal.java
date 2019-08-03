package com.fredhappyface.vanillautils.Enum;

import com.fredhappyface.vanillautils.CreativeTabGroups;
import com.fredhappyface.vanillautils.lib.blocks.ModBlock;
import com.fredhappyface.vanillautils.lib.blocks.ModOreBlock;
import com.fredhappyface.vanillautils.lib.data.OreGenAttrs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.LazyLoadBase;

import java.util.Locale;

public enum Ethereal {
    ETHEREAL(new OreGenAttrs(4,2));


    // Attrs
    private final OreGenAttrs oreGenAttrs;



    // Resources
    private final LazyLoadBase<ModOreBlock> oreBlock;
    private final LazyLoadBase<Item> gemItem;




    private final LazyLoadBase<ModBlock> storageBlock;


    Ethereal(final OreGenAttrs oreGenAttrs) {
        // Attrs
        this.oreGenAttrs = oreGenAttrs;



        // Resources
        oreBlock = new LazyLoadBase<>(() -> new ModOreBlock(oreGenAttrs.getHarvestLevel()));
        gemItem = new LazyLoadBase<>(() -> new Item(new Item.Properties().group(CreativeTabGroups.ITEM_GROUP_DECORATION)));

        // Blocks

        final Block.Properties gemBlockProperties = Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL);



        storageBlock = new LazyLoadBase<>(() -> new ModBlock(gemBlockProperties));

    }


    // Attrs
    public String getName() {
        // Locale.ROOT will ensure consistent behavior (prevent crashes) on all locales
        return name().toLowerCase(Locale.ROOT);
    }
    public OreGenAttrs getOreGenAttrs() {
        return oreGenAttrs;
    }



    // Resources
    public ModOreBlock getOreBlock() {
        return oreBlock.getValue();
    }
    public Item getGemItem() {
        return gemItem.getValue();
    }


    // Blocks


    public ModBlock getStorageBlock() {
        return storageBlock.getValue();
    }


}
