package com.fredhappyface.vanillautils.Enum;

import com.fredhappyface.vanillautils.Main;
import com.fredhappyface.vanillautils.lib.blocks.InvertedRedstoneLampBlock;
import com.fredhappyface.vanillautils.lib.blocks.ModDoorBlock;
import com.fredhappyface.vanillautils.lib.blocks.ModPaneBlock;
import com.fredhappyface.vanillautils.lib.blocks.ModStairsBlock;
import com.fredhappyface.vanillautils.lib.data.ArmorAttrs;
import com.fredhappyface.vanillautils.lib.data.ModArmorMaterial;
import com.fredhappyface.vanillautils.lib.data.ModItemTier;
import com.fredhappyface.vanillautils.lib.data.ToolAttrs;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;

import java.util.Locale;
import java.util.function.Supplier;

public enum ModInclTools {

    GRANITE(Items.GRANITE,
            Blocks.GRANITE,
            new ToolAttrs(1,-2.4F, 1, 131,4.0f, 1.5f, 5),
            new ArmorAttrs(5, new int[]{1, 2, 3, 1}, 0.0F)),
    DIORITE(Items.DIORITE,
            Blocks.DIORITE,
            new ToolAttrs(1,-2.4F, 1, 131,4.0f, 1.5f, 5),
            new ArmorAttrs(5, new int[]{1, 2, 3, 1}, 0.0F)),
    GLOWSTONE(Items.GLOWSTONE,
            Blocks.GLOWSTONE,
            new ToolAttrs(5,5.0f, 4, 1000,8.0f, 3.0f, 22),
            new ArmorAttrs(33, new int[]{3, 6, 8, 3},  2.0F)),
    LAPIS_LAZULI(Items.LAPIS_LAZULI,
            Blocks.LAPIS_BLOCK,
            new ToolAttrs(3,4.0f, 3, 800,6.0f, 2.0f, 10),
            new ArmorAttrs(25, new int[]{2, 4, 6, 2},  1.0F));

    // Attrs
    private final ToolAttrs toolAttrs;
    private final ArmorAttrs armorAttrs;

    private final Item item;
    private final Block block;



    // Blocks

    private final LazyLoadBase<ModPaneBlock> bars;
    private final LazyLoadBase<ModDoorBlock> door;
    private final LazyLoadBase<RedstoneLampBlock> lamp;
    private final LazyLoadBase<InvertedRedstoneLampBlock> lampInverted;


    private final LazyLoadBase<Block> bricks;
    private final LazyLoadBase<SlabBlock> slab;
    private final LazyLoadBase<StairsBlock> stairs;
    private final LazyLoadBase<SlabBlock> brickSlab;
    private final LazyLoadBase<StairsBlock> brickStairs;

    // Tools

    private final LazyLoadBase<ShearsItem> shears;

    private final LazyLoadBase<PickaxeItem> pickaxe;
    private final LazyLoadBase<AxeItem> axe;
    private final LazyLoadBase<ShovelItem> shovel;
    private final LazyLoadBase<SwordItem> sword;
    private final LazyLoadBase<HoeItem> hoe;

    // Armour
    private final LazyLoadBase<ArmorItem> helm;
    private final LazyLoadBase<ArmorItem> chest;
    private final LazyLoadBase<ArmorItem> leggings;
    private final LazyLoadBase<ArmorItem> boots;



    ModInclTools(final Item item, final Block block, final ToolAttrs toolAttrs, final ArmorAttrs armorAttrs) {
        // Attrs
        this.item = item;
        this.block = block;
        this.toolAttrs = toolAttrs;
        this.armorAttrs = armorAttrs;



        // Blocks

        final Block.Properties blockProperties = Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL);


        bars = new LazyLoadBase<>(() -> new ModPaneBlock(blockProperties));
        door = new LazyLoadBase<>(() -> new ModDoorBlock(blockProperties));

        final  Block.Properties gemLightProperties = Block.Properties.create(Material.REDSTONE_LIGHT).hardnessAndResistance(0.3f, 15).lightValue(15);

        lamp = new LazyLoadBase<>(() -> new RedstoneLampBlock(gemLightProperties));
        lampInverted = new LazyLoadBase<>(() -> new InvertedRedstoneLampBlock(gemLightProperties));


        bricks = new LazyLoadBase<>(() -> new Block(blockProperties));
        slab = new LazyLoadBase<>(() -> new SlabBlock(blockProperties));
        stairs = new LazyLoadBase<>(() -> new ModStairsBlock(getBlock().getDefaultState(),blockProperties));
        brickSlab = new LazyLoadBase<>(() -> new SlabBlock(blockProperties));
        brickStairs = new LazyLoadBase<>(() -> new ModStairsBlock(getBlock().getDefaultState(),blockProperties));


        // Tools

        final Supplier<Ingredient> gemIngredient =  () -> { return Ingredient.fromItems(getItem());};

        final ModItemTier itemTier = new ModItemTier(getToolAttrs().getHarvestLevelIn(), getToolAttrs().getMaxUsesIn(), getToolAttrs().getEfficiencyIn(), getToolAttrs().getAttackDamageIn(), getToolAttrs().getEnchantabilityIn(), gemIngredient);


        shears = new LazyLoadBase<>(() -> new ShearsItem(getToolAttrs().getItemProperties()));

        pickaxe = new LazyLoadBase<>(() -> new PickaxeItem(itemTier, getToolAttrs().getAttackDamageIn(), getToolAttrs().getAttackSpeedIn(), getToolAttrs().getItemProperties()));
        axe = new LazyLoadBase<>(() -> new AxeItem(itemTier, getToolAttrs().getAttackDamageIn(), getToolAttrs().getAttackSpeedIn(), getToolAttrs().getItemProperties()));
        hoe = new LazyLoadBase<>(() -> new HoeItem(itemTier, getToolAttrs().getAttackSpeedIn(), getToolAttrs().getItemProperties()));
        sword  = new LazyLoadBase<>(() -> new SwordItem(itemTier, getToolAttrs().getSwordAttackDamageIn(), getToolAttrs().getSwordAttackSpeedIn(), getToolAttrs().getItemProperties()));
        shovel  = new LazyLoadBase<>(() -> new ShovelItem(itemTier, getToolAttrs().getAttackDamageIn(), getToolAttrs().getAttackSpeedIn(), getToolAttrs().getItemProperties()));


        // Armour (enchantability is from tool attributes)

        final ModArmorMaterial armorMaterial = new ModArmorMaterial(Main.MOD_ID + ":" + getName(),getArmorAttrs().getMaxDamageFactor(), getArmorAttrs().getDamageReductionAmountArray(), getToolAttrs().getEnchantabilityIn(),  getArmorAttrs().getToughness(), gemIngredient);

        helm = new LazyLoadBase<>(() -> new ArmorItem(armorMaterial, EquipmentSlotType.HEAD, getArmorAttrs().getItemProperties()));
        chest = new LazyLoadBase<>(() -> new ArmorItem(armorMaterial, EquipmentSlotType.CHEST, getArmorAttrs().getItemProperties()));
        leggings = new LazyLoadBase<>(() -> new ArmorItem(armorMaterial, EquipmentSlotType.LEGS, getArmorAttrs().getItemProperties()));
        boots = new LazyLoadBase<>(() -> new ArmorItem(armorMaterial, EquipmentSlotType.FEET, getArmorAttrs().getItemProperties()));



    }


    // Attrs
    public String getName() {
        // Locale.ROOT will ensure consistent behavior (prevent crashes) on all locales
        return name().toLowerCase(Locale.ROOT);
    }

    public ToolAttrs getToolAttrs() {
        return toolAttrs;
    }

    public ArmorAttrs getArmorAttrs(){
        return armorAttrs;
    }

    public Item getItem(){ return item;}
    public Block getBlock(){ return block;}



    // Blocks


    public ModPaneBlock getBars(){return bars.getValue();}
    public ModDoorBlock getDoor(){return door.getValue();}
    public RedstoneLampBlock getLamp(){return lamp.getValue();}
    public InvertedRedstoneLampBlock getLampInverted(){return lampInverted.getValue();}


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

    // Tools

    public ShearsItem getShearsItem(){return  shears.getValue();}

    public PickaxeItem getPickaxeItem(){
        return  pickaxe.getValue();
    }
    public AxeItem getAxeItem(){
        return  axe.getValue();
    }
    public HoeItem getHoeItem(){
        return  hoe.getValue();
    }
    public ShovelItem getShovelItem(){
        return  shovel.getValue();
    }
    public SwordItem getSwordItem(){
        return  sword.getValue();
    }

    // Armour

    public ArmorItem getHelm(){
        return helm.getValue();
    }
    public ArmorItem getChest(){
        return chest.getValue();
    }
    public ArmorItem getLeggings(){
        return leggings.getValue();
    }
    public ArmorItem getBoots(){
        return boots.getValue();
    }


    }
