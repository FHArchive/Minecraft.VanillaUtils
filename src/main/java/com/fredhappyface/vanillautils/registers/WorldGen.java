package com.fredhappyface.vanillautils.registers;

import com.fredhappyface.vanillautils.Enum.Ethereal;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeManager;



public class WorldGen {


    public static void setupOreGeneration() {
        for (final BiomeManager.BiomeType btype : BiomeManager.BiomeType.values()) {
            for (final BiomeManager.BiomeEntry biomeEntry : BiomeManager.getBiomes(btype)) {

                for(final Ethereal gem : Ethereal.values()){
                    biomeEntry.biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                            gem.getOreBlock().getDefaultState(), gem.getOreGenAttrs().getVeinSize()), Placement.COUNT_RANGE, gem.getOreGenAttrs().getCountRangeConfig()));

                }


            }
        }
    }



}

