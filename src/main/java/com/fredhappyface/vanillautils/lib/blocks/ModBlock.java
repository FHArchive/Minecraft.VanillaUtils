package com.fredhappyface.vanillautils.lib.blocks;

import net.minecraft.util.BlockRenderLayer;

/**
 * @author FredHappyface
 * @version latest update 2019.07.18
 *
 * Custom ore block with custom implementation of get exp and get harvest level
 */
public class ModBlock extends net.minecraft.block.Block {


    /**
     * Define an ModBlock
     */


    @SuppressWarnings("WeakerAccess")
    public ModBlock(final Properties builder) {
        super(builder);

    }



    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    
}