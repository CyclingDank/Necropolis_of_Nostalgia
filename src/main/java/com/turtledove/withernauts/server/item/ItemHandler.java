package com.turtledove.withernauts.server.item;
import com.turtledove.withernauts.Necropolis_of_Nostalgia;
import com.turtledove.withernauts.server.blocks.BlockHandler;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID)
@Mod.EventBusSubscriber(modid = Necropolis_of_Nostalgia.MODID)
public final class ItemHandler
{
    public ItemHandler(){};

    public  static final ItemRiceSeed RICE_SEED = null;
    public  static final ItemCatTail CAT_TAIL = null;
    public static final ItemDuckWeed DUCKWEED = null;

    public static final ItemFood STEAK_POTATO = null;
    public static final ItemFood TOASTED_SANDWICH = null;
    public static final ItemFood BROTH = null;
    public static final ItemFood ROAST = null;
    public static final ItemFood PORK_STEW = null;
    public static final ItemFood SEAFOOD_FRIED_RICE = null;
    public static final ItemFood OMURICE = null;
    public static final ItemFood STEAMED_RICE = null;
    public static final ItemFood MUSHROOM_BURGER = null;
    public static final ItemFood VEGGIE_STIR_FRY = null;
    public static final ItemFood MYSTERY_MEAL = null;


    public static final ItemWoodenRapier WOODEN_RAPIER = null;
    public static final ItemGoldRapier GOLD_RAPIER = null;
    public static final ItemStoneRapier STONE_RAPIER = null;
    public static final ItemIronRapier IRON_RAPIER = null;
    public static final ItemDiamondRapier DIAMOND_RAPIER = null;

    public static final ItemNecropolisSword KNIGHT_SWORD = null;
    public static final ItemNecropolisSword KNIGHT_SWORD_P1 = null;
    public static final ItemNecropolisSword KNIGHT_SWORD_P2 = null;

    public static final ItemNecropolisSword RUNE_BLADE = null;
    public static final ItemNecropolisSword RUNE_BLADE_P1 = null;
    public static final ItemNecropolisSword RUNE_BLADE_P2 = null;

    public static final ItemNecropolisSword HIGH_DAMASCUS = null;
    public static final ItemNecropolisSword HIGH_DAMASCUS_P1 = null;
    public static final ItemNecropolisSword HIGH_DAMASCUS_P2 = null;

    public static final ItemNecropolisSword MOONLIGHT_AQUA = null;
    public static final ItemNecropolisSword MOONLIGHT_AQUA_P1 = null;


    public static final ItemNecropolisSpear SCYTHE = null;
    public static final ItemNecropolisSpear SCYTHE_P1 = null;

    public static final ItemNecropolisSpear LONGINUS = null;
    public static final ItemNecropolisSpear LONGINUS_P1 = null;

    public static final ItemNecropolisSpear EXCALIBER = null;
    public static final ItemNecropolisSpear EXCALIBER_P1 = null;

    public static final ItemNecropolisSpear POSEIDON = null;
    public static final ItemNecropolisSpear POSEIDON_P1 = null;



    public static final ItemNecropolisRapier HOLY_AVENGER = null;
    public static final ItemNecropolisRapier HOLY_AVENGER_P1 = null;
    public static final ItemNecropolisRapier HOLY_AVENGER_P2 = null;

    public static final ItemNecropolisRapier MERCURIUS = null;
    public static final ItemNecropolisRapier MERCURIUS_P1 = null;
    public static final ItemNecropolisRapier MERCURIUS_P2 = null;

    public static final ItemNecropolisRapier IRON_MAIDEN = null;
    public static final ItemNecropolisRapier IRON_MAIDEN_P1 = null;
    public static final ItemNecropolisRapier IRON_MAIDEN_P2 = null;

    public static final ItemNecropolisRapier RADIANT_STAR = null;
    public static final ItemNecropolisRapier RADIANT_STAR_P1 = null;



    public static final ItemNecropolisTome PSYCHEDELIA = null;
    public static final ItemNecropolisTome PSYCHEDELIA_P1 = null;

    public static final ItemNecropolisTome GRIMOIRE = null;
    public static final ItemNecropolisTome GRIMOIRE_P1 = null;

    public static final ItemNecropolisTome SERAPHIM = null;
    public static final ItemNecropolisTome SERAPHIM_P1 = null;

    public static final ItemNecropolisTome NOTUNG = null;
    public static final ItemNecropolisTome NOTUNG_P1 = null;




    public static final ItemNecropolisArmor LAMELLAR_HELMET_DEFAULT = null;
    public static final ItemNecropolisArmor LAMELLAR_PLATE_DEFAULT = null;
    public static final ItemNecropolisArmor LAMELLAR_LEGS_DEFAULT = null;
    public static final ItemNecropolisArmor LAMELLAR_FEET_DEFAULT = null;
    public static final ItemNecropolisArmor LAMELLAR_HELMET_BLACK = null;
    public static final ItemNecropolisArmor LAMELLAR_PLATE_BLACK = null;
    public static final ItemNecropolisArmor LAMELLAR_LEGS_BLACK = null;
    public static final ItemNecropolisArmor LAMELLAR_FEET_BLACK = null;
    public static final ItemNecropolisArmor LAMELLAR_HELMET_BLUE = null;
    public static final ItemNecropolisArmor LAMELLAR_PLATE_BLUE = null;
    public static final ItemNecropolisArmor LAMELLAR_LEGS_BLUE = null;
    public static final ItemNecropolisArmor LAMELLAR_FEET_BLUE = null;
    public static final ItemNecropolisArmor LAMELLAR_HELMET_RED = null;
    public static final ItemNecropolisArmor LAMELLAR_PLATE_RED = null;
    public static final ItemNecropolisArmor LAMELLAR_LEGS_RED = null;
    public static final ItemNecropolisArmor LAMELLAR_FEET_RED = null;
    public static final ItemNecropolisArmor LAMELLAR_HELMET_YELLOW = null;
    public static final ItemNecropolisArmor LAMELLAR_PLATE_YELLOW = null;
    public static final ItemNecropolisArmor LAMELLAR_LEGS_YELLOW = null;
    public static final ItemNecropolisArmor LAMELLAR_FEET_YELLOW = null;
    public static final ItemNecropolisArmor LAMELLAR_HELMET_WHITE = null;
    public static final ItemNecropolisArmor LAMELLAR_PLATE_WHITE = null;
    public static final ItemNecropolisArmor LAMELLAR_LEGS_WHITE = null;
    public static final ItemNecropolisArmor LAMELLAR_FEET_WHITE = null;
    public static final ItemNecropolisArmor LAMELLAR_HELMET_GREEN = null;
    public static final ItemNecropolisArmor LAMELLAR_PLATE_GREEN = null;
    public static final ItemNecropolisArmor LAMELLAR_LEGS_GREEN = null;
    public static final ItemNecropolisArmor LAMELLAR_FEET_GREEN = null;

    public static final ItemNecropolisArmor LAMELLAR_HELMET_DEFAULT_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_PLATE_DEFAULT_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_LEGS_DEFAULT_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_FEET_DEFAULT_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_HELMET_BLACK_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_PLATE_BLACK_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_LEGS_BLACK_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_FEET_BLACK_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_HELMET_BLUE_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_PLATE_BLUE_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_LEGS_BLUE_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_FEET_BLUE_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_HELMET_RED_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_PLATE_RED_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_LEGS_RED_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_FEET_RED_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_HELMET_YELLOW_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_PLATE_YELLOW_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_LEGS_YELLOW_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_FEET_YELLOW_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_HELMET_WHITE_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_PLATE_WHITE_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_LEGS_WHITE_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_FEET_WHITE_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_HELMET_GREEN_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_PLATE_GREEN_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_LEGS_GREEN_P1 = null;
    public static final ItemNecropolisArmor LAMELLAR_FEET_GREEN_P1 = null;

    public static final ItemNecropolisArmor LAMELLAR_HELMET_DEFAULT_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_PLATE_DEFAULT_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_LEGS_DEFAULT_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_FEET_DEFAULT_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_HELMET_BLACK_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_PLATE_BLACK_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_LEGS_BLACK_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_FEET_BLACK_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_HELMET_BLUE_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_PLATE_BLUE_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_LEGS_BLUE_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_FEET_BLUE_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_HELMET_RED_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_PLATE_RED_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_LEGS_RED_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_FEET_RED_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_HELMET_YELLOW_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_PLATE_YELLOW_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_LEGS_YELLOW_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_FEET_YELLOW_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_HELMET_WHITE_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_PLATE_WHITE_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_LEGS_WHITE_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_FEET_WHITE_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_HELMET_GREEN_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_PLATE_GREEN_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_LEGS_GREEN_P2 = null;
    public static final ItemNecropolisArmor LAMELLAR_FEET_GREEN_P2 = null;

    public static final ItemNecropolisArmor SACRED_ARMOR_HELMET = null;
    public static final ItemNecropolisArmor SACRED_ARMOR_PLATE = null;
    public static final ItemNecropolisArmor SACRED_ARMOR_LEGS = null;
    public static final ItemNecropolisArmor SACRED_ARMOR_FEET = null;
    public static final ItemNecropolisArmor SACRED_ARMOR_HELMET_P1 = null;
    public static final ItemNecropolisArmor SACRED_ARMOR_PLATE_P1 = null;
    public static final ItemNecropolisArmor SACRED_ARMOR_LEGS_P1 = null;
    public static final ItemNecropolisArmor SACRED_ARMOR_FEET_P1 = null;
    public static final ItemNecropolisArmor SACRED_ARMOR_HELMET_P2 = null;
    public static final ItemNecropolisArmor SACRED_ARMOR_PLATE_P2 = null;
    public static final ItemNecropolisArmor SACRED_ARMOR_LEGS_P2 = null;
    public static final ItemNecropolisArmor SACRED_ARMOR_FEET_P2 = null;

    public static final ItemNecropolisArmor SPLINT_MAIL_HELMET = null;
    public static final ItemNecropolisArmor SPLINT_MAIL_PLATE = null;
    public static final ItemNecropolisArmor SPLINT_MAIL_LEGS = null;
    public static final ItemNecropolisArmor SPLINT_MAIL_FEET = null;
    public static final ItemNecropolisArmor SPLINT_MAIL_HELMET_P1 = null;
    public static final ItemNecropolisArmor SPLINT_MAIL_PLATE_P1 = null;
    public static final ItemNecropolisArmor SPLINT_MAIL_LEGS_P1 = null;
    public static final ItemNecropolisArmor SPLINT_MAIL_FEET_P1 = null;
    public static final ItemNecropolisArmor SPLINT_MAIL_HELMET_P2 = null;
    public static final ItemNecropolisArmor SPLINT_MAIL_PLATE_P2 = null;
    public static final ItemNecropolisArmor SPLINT_MAIL_LEGS_P2 = null;
    public static final ItemNecropolisArmor SPLINT_MAIL_FEET_P2 = null;

    public static final ItemNecropolisArmor BASTILLE_PLATE_HELMET = null;
    public static final ItemNecropolisArmor BASTILLE_PLATE_PLATE = null;
    public static final ItemNecropolisArmor BASTILLE_PLATE_LEGS = null;
    public static final ItemNecropolisArmor BASTILLE_PLATE_FEET = null;
    public static final ItemNecropolisArmor BASTILLE_PLATE_HELMET_P1 = null;
    public static final ItemNecropolisArmor BASTILLE_PLATE_PLATE_P1 = null;
    public static final ItemNecropolisArmor BASTILLE_PLATE_LEGS_P1 = null;
    public static final ItemNecropolisArmor BASTILLE_PLATE_FEET_P1 = null;
    public static final ItemNecropolisArmor BASTILLE_PLATE_HELMET_P2 = null;
    public static final ItemNecropolisArmor BASTILLE_PLATE_PLATE_P2 = null;
    public static final ItemNecropolisArmor BASTILLE_PLATE_LEGS_P2 = null;
    public static final ItemNecropolisArmor BASTILLE_PLATE_FEET_P2 = null;

    public static final ItemNecropolisArmor AVALON_MAIL_HELMET = null;
    public static final ItemNecropolisArmor AVALON_MAIL_PLATE = null;
    public static final ItemNecropolisArmor AVALON_MAIL_LEGS = null;
    public static final ItemNecropolisArmor AVALON_MAIL_FEET = null;
    public static final ItemNecropolisArmor AVALON_MAIL_HELMET_P1 = null;
    public static final ItemNecropolisArmor AVALON_MAIL_PLATE_P1 = null;
    public static final ItemNecropolisArmor AVALON_MAIL_LEGS_P1 = null;
    public static final ItemNecropolisArmor AVALON_MAIL_FEET_P1 = null;
    public static final ItemNecropolisArmor AVALON_MAIL_HELMET_P2 = null;
    public static final ItemNecropolisArmor AVALON_MAIL_PLATE_P2 = null;
    public static final ItemNecropolisArmor AVALON_MAIL_LEGS_P2 = null;
    public static final ItemNecropolisArmor AVALON_MAIL_FEET_P2 = null;

    public static final ItemNecropolisArmor SORCERERS_SALLET = null;
    public static final ItemNecropolisArmor SORCERERS_SALLET_P1 = null;

    public static final ItemNecropolisArmor SORCERERS_HAT = null;
    public static final ItemNecropolisArmor SORCERERS_HAT_P1 = null;

    public static final ItemNecropolisArmor SORCERERS_ROBE = null;
    public static final ItemNecropolisArmor SORCERERS_ROBE_P1 = null;
    public static final ItemNecropolisArmor SORCERERS_ROBE_P2 = null;

    public static final ItemNecropolisArmor THIEFS_HOOD = null;
    public static final ItemNecropolisArmor THIEFS_HOOD_P1 = null;

    public static final ItemNecropolisArmor SKELETON_HELMET = null;
    public static final ItemNecropolisArmor SKELETON_HELMET_P1 = null;

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll
        (
                new ItemBlock(BlockHandler.BAKE_KETTLE).setRegistryName(BlockHandler.BAKE_KETTLE.getRegistryName()),

                new ItemBlock(BlockHandler.REPITIFLEUR).setRegistryName(BlockHandler.REPITIFLEUR.getRegistryName()),

                new ItemBlock(BlockHandler.FOREST_SHRUB).setRegistryName(BlockHandler.FOREST_SHRUB.getRegistryName()),

                new ItemRiceSeed("rice_seed"),

                new ItemCatTail("cat_tail"),

                new ItemDuckWeed("duckweed"),

                new ItemBlock(BlockHandler.KELP).setRegistryName("kelp"),

                new ItemBlock(BlockHandler.BARRIER_BLASTIA).setRegistryName("barrier_blastia"),

                new ItemBlock(BlockHandler.YAM_BLUEPRINT).setRegistryName("yam_blueprint"),
                new ItemBlock(BlockHandler.FARM_PLOT).setRegistryName("farm_plot"),

                new ItemBlock(BlockHandler.TEA_BLUEPRINT).setRegistryName("tea_blueprint"),
                new ItemBlock(BlockHandler.RICE_FARM_PLOT).setRegistryName("rice_farm_plot"),

                new ItemBlock(BlockHandler.DWIGT_BLUEPRINT).setRegistryName("dwigt_blueprint"),
                new ItemBlock(BlockHandler.RITA_BLUEPRINT).setRegistryName("rita_blueprint"),
                new ItemBlock(BlockHandler.CARLSON_BLUEPRINT).setRegistryName("carlson_blueprint"),


                new ItemWoodenRapier(Item.ToolMaterial.WOOD),
                new ItemGoldRapier(Item.ToolMaterial.GOLD),
                new ItemStoneRapier(Item.ToolMaterial.STONE),
                new ItemIronRapier(Item.ToolMaterial.IRON),
                new ItemDiamondRapier(Item.ToolMaterial.DIAMOND),

                new ItemFood(4, 0.8F, false).setRegistryName("steak_potato").setUnlocalizedName("steakPotato").setMaxStackSize(16),
                new ItemFood(4, 0.8F, false).setRegistryName("toasted_sandwich").setUnlocalizedName("toastedSandwich").setMaxStackSize(16),
                new ItemFood(4, 0.8F, false).setRegistryName("broth").setUnlocalizedName("broth").setMaxStackSize(1),
                new ItemFood(4, 0.8F, false).setRegistryName("roast").setUnlocalizedName("roast").setMaxStackSize(16),
                new ItemFood(4, 0.8F, false).setRegistryName("pork_stew").setUnlocalizedName("pork_stew").setMaxStackSize(16),
                new ItemFood(4, 0.8F, false).setRegistryName("seafood_fried_rice").setUnlocalizedName("seafood_fried_rice").setMaxStackSize(16),
                new ItemFood(4, 0.8F, false).setRegistryName("omurice").setUnlocalizedName("omurice").setMaxStackSize(16),
                new ItemFood(4, 0.8F, false).setRegistryName("steamed_rice").setUnlocalizedName("steamed_rice").setMaxStackSize(16),
                new ItemFood(4, 0.8F, false).setRegistryName("mushroom_burger").setUnlocalizedName("mushroom_burger").setMaxStackSize(16),
                new ItemFood(4, 0.8F, false).setRegistryName("veggie_stir_fry").setUnlocalizedName("veggie_stir_fry").setMaxStackSize(16),
                new ItemFood(4, 0.8F, false).setRegistryName("mystery_meal").setUnlocalizedName("mystery_meal").setMaxStackSize(16),


                new ItemNecropolisSword(9, "knight_sword", "knight_sword", new String[]{"HP Recover"}),
                new ItemNecropolisSword(15, "knight_sword_p1", "knight_sword_p1", new String[]{"HP Recover 2"}),
                new ItemNecropolisSword(25, "knight_sword_p2", "knight_sword_p2", new String[]{"HP Recover 2", "Critical"}),

                new ItemNecropolisSword(10, "rune_blade", "rune_blade", new String[]{"TP Recover"}),
                new ItemNecropolisSword(15, "rune_blade_p1", "rune_blade_p1", new String[]{"TP Recover 2"}),
                new ItemNecropolisSword(25, "rune_blade_p2", "rune_blade_p2", new String[]{"TP Recover 2", "Adrenaline"}),

                new ItemNecropolisSword(12, "high_damascus", "high_damascus", new String[]{"Adrenaline"}),
                new ItemNecropolisSword(24, "high_damascus_p1", "high_damascus_p1", new String[]{"Adrenaline 2"}),
                new ItemNecropolisSword(28, "high_damascus_p2", "high_damascus_p2", new String[]{"Adrenaline 2", "Taunt"}),

                new ItemNecropolisSword(14, "moonlight_aqua", "moonlight_aqua", new String[]{"Magic Shield"}),
                new ItemNecropolisSword(25, "moonlight_aqua_p1", "moonlight_aqua_p1", new String[]{"Magic Shield"}),


                new ItemNecropolisSpear(13, "scythe", "scythe", new String[]{}),
                new ItemNecropolisSpear(25, "scythe_p1", "scythe_p1", new String[]{}),

                new ItemNecropolisSpear(14, "longinus", "longinus", new String[]{}),
                new ItemNecropolisSpear(25, "longinus_p1", "longinus_p1", new String[]{}),

                new ItemNecropolisSpear(13, "excaliber", "excaliber", new String[]{}),
                new ItemNecropolisSpear(25, "excaliber_p1", "excaliber_p1", new String[]{}),

                new ItemNecropolisSpear(12, "poseidon", "poseidon", new String[]{}),
                new ItemNecropolisSpear(25, "poseidon_p1", "poseidon_p1", new String[]{}),



                new ItemNecropolisRapier(8, 6, "holy_avenger", "holy_avenger", new String[]{"HP Recover"}),
                new ItemNecropolisRapier(16, 10, "holy_avenger_p1", "holy_avenger_p1", new String[]{"HP Recover 2"}),
                new ItemNecropolisRapier(22, 15, "holy_avenger_p2", "holy_avenger_p2", new String[]{"HP Recover 2", "Taunt"}),

                new ItemNecropolisRapier(6, 7, "mercurius", "mercurius", new String[]{"Recover"}),
                new ItemNecropolisRapier(10, 15, "mercurius_p1", "mercurius_p1", new String[]{"Recover", "Status Guard"}),
                new ItemNecropolisRapier(15, 25, "mercurius_p2", "mercurius_p2", new String[]{"Recover", "Status Guard", "Guard Plus"}),

                new ItemNecropolisRapier(7, 6, "iron_maiden", "iron_maiden", new String[]{"Taunt"}),
                new ItemNecropolisRapier(15, 10, "iron_maiden_p1", "iron_maiden_p1", new String[]{"Taunt 2"}),
                new ItemNecropolisRapier(25, 15, "iron_maiden_p2", "iron_maiden_p2", new String[]{"Taunt 2", "TP Recover"}),

                new ItemNecropolisRapier(10, 10, "radiant_star", "radiant_star", new String[]{"Defend Conversion"}),
                new ItemNecropolisRapier(20, 20, "radiant_star_p1", "radiant_star_p1", new String[]{"Defend Conversion"}),

                new ItemNecropolisTome(12, "psychedelia", "psychedelia", new String[]{"TP Condition"}),
                new ItemNecropolisTome(21, "psychedelia_p1", "psychedelia_p1", new String[]{"TP Condition 2"}),

                new ItemNecropolisTome(13, "grimoire", "grimoire", new String[]{"Status Guard"}),
                new ItemNecropolisTome(20, "grimoire_p1", "grimoire_p1", new String[]{"Status Guard", "Fatal Exceed"}),

                new ItemNecropolisTome(12, "seraphim", "seraphim", new String[]{"Absorption"}),
                new ItemNecropolisTome(20, "seraphim_p1", "seraphim_p1", new String[]{"Absorption", "Light Magic"}),

                new ItemNecropolisTome(12, "notung", "notung", new String[]{"Critical"}),
                new ItemNecropolisTome(18, "notung_p1", "notung_p1", new String[]{"Critical", "Heavy Magic"}),



                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "lamellar_helmet_default", "lamellar_helmet_default", "default",0, 4, 2, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "lamellar_plate_default", "lamellar_plate_default", "default",1, 7, 2, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 2, EntityEquipmentSlot.LEGS, "lamellar_legs_default", "lamellar_legs_default","default", 1, 4, 2, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 3, EntityEquipmentSlot.FEET, "lamellar_feet_default", "lamellar_feet_default","default", 1, 2, 1, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "lamellar_helmet_black", "lamellar_helmet_black", "black",0, 4, 2, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "lamellar_plate_black", "lamellar_plate_black", "black",1, 7, 2, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 2, EntityEquipmentSlot.LEGS, "lamellar_legs_black", "lamellar_legs_black","black", 1, 4, 2, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 3, EntityEquipmentSlot.FEET, "lamellar_feet_black", "lamellar_feet_black","black", 1, 2, 1, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "lamellar_helmet_blue", "lamellar_helmet_blue", "blue",0, 4, 2, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "lamellar_plate_blue", "lamellar_plate_blue", "blue",1, 7, 2, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 2, EntityEquipmentSlot.LEGS, "lamellar_legs_blue", "lamellar_legs_blue","blue", 1, 4, 2, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 3, EntityEquipmentSlot.FEET, "lamellar_feet_blue", "lamellar_feet_blue","blue", 1, 2, 1, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "lamellar_helmet_red", "lamellar_helmet_red", "red",0, 4, 2, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "lamellar_plate_red", "lamellar_plate_red", "red",1, 7, 2, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 2, EntityEquipmentSlot.LEGS, "lamellar_legs_red", "lamellar_legs_red","red", 1, 4, 2, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 3, EntityEquipmentSlot.FEET, "lamellar_feet_red", "lamellar_feet_red","red", 1, 2, 1, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "lamellar_helmet_yellow", "lamellar_helmet_yellow", "yellow",0, 4, 2, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "lamellar_plate_yellow", "lamellar_plate_yellow", "yellow",1, 7, 2, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 2, EntityEquipmentSlot.LEGS, "lamellar_legs_yellow", "lamellar_legs_yellow","yellow", 1, 4, 2, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 3, EntityEquipmentSlot.FEET, "lamellar_feet_yellow", "lamellar_feet_yellow","yellow", 1, 2, 1, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "lamellar_helmet_white", "lamellar_helmet_white", "white",0, 4, 2, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "lamellar_plate_white", "lamellar_plate_white", "white",1, 7, 2, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 2, EntityEquipmentSlot.LEGS, "lamellar_legs_white", "lamellar_legs_white","white", 1, 4, 2, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 3, EntityEquipmentSlot.FEET, "lamellar_feet_white", "lamellar_feet_white","white", 1, 2, 1, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "lamellar_helmet_green", "lamellar_helmet_green", "green",0, 4, 2, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "lamellar_plate_green", "lamellar_plate_green", "green",1, 7, 2, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 2, EntityEquipmentSlot.LEGS, "lamellar_legs_green", "lamellar_legs_green","green", 1, 4, 2, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 3, EntityEquipmentSlot.FEET, "lamellar_feet_green", "lamellar_feet_green","green", 1, 2, 1, 0, 0, 0.05),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "lamellar_helmet_default_p1", "lamellar_helmet_default_p1", "default",3, 7, 2, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "lamellar_plate_default_p1", "lamellar_plate_default_p1", "default",2, 10, 2, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 2, EntityEquipmentSlot.LEGS, "lamellar_legs_default_p1", "lamellar_legs_default_p1","default", 2, 6, 2, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 3, EntityEquipmentSlot.FEET, "lamellar_feet_default_p1", "lamellar_feet_default_p1","default", 1, 5, 1, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "lamellar_helmet_black_p1", "lamellar_helmet_black_p1", "black",3, 7, 2, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "lamellar_plate_black_p1", "lamellar_plate_black_p1", "black",2, 10, 2, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 2, EntityEquipmentSlot.LEGS, "lamellar_legs_black_p1", "lamellar_legs_black_p1","black", 2, 6, 2, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 3, EntityEquipmentSlot.FEET, "lamellar_feet_black_p1", "lamellar_feet_black_p1","black", 1, 5, 1, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "lamellar_helmet_blue_p1", "lamellar_helmet_blue_p1", "blue",3, 7, 2, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "lamellar_plate_blue_p1", "lamellar_plate_blue_p1", "blue",2, 10, 2, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 2, EntityEquipmentSlot.LEGS, "lamellar_legs_blue_p1", "lamellar_legs_blue_p1","blue", 2, 6, 2, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 3, EntityEquipmentSlot.FEET, "lamellar_feet_blue_p1", "lamellar_feet_blue_p1","blue", 1, 5, 1, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "lamellar_helmet_red_p1", "lamellar_helmet_red_p1", "red",3, 7, 2, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "lamellar_plate_red_p1", "lamellar_plate_red_p1", "red",2, 10, 2, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 2, EntityEquipmentSlot.LEGS, "lamellar_legs_red_p1", "lamellar_legs_red_p1","red", 2, 6, 2, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 3, EntityEquipmentSlot.FEET, "lamellar_feet_red_p1", "lamellar_feet_red_p1","red", 1, 5, 1, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "lamellar_helmet_yellow_p1", "lamellar_helmet_yellow_p1", "yellow",3, 7, 2, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "lamellar_plate_yellow_p1", "lamellar_plate_yellow_p1", "yellow",2, 10, 2, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 2, EntityEquipmentSlot.LEGS, "lamellar_legs_yellow_p1", "lamellar_legs_yellow_p1","yellow", 2, 6, 2, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 3, EntityEquipmentSlot.FEET, "lamellar_feet_yellow_p1", "lamellar_feet_yellow_p1","yellow", 1, 5, 1, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "lamellar_helmet_white_p1", "lamellar_helmet_white_p1", "white",3, 7, 2, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "lamellar_plate_white_p1", "lamellar_plate_white_p1", "white",2, 10, 2, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 2, EntityEquipmentSlot.LEGS, "lamellar_legs_white_p1", "lamellar_legs_white_p1","white", 2, 6, 2, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 3, EntityEquipmentSlot.FEET, "lamellar_feet_white_p1", "lamellar_feet_white_p1","white", 1, 5, 1, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "lamellar_helmet_green_p1", "lamellar_helmet_green_p1", "green",3, 7, 2, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "lamellar_plate_green_p1", "lamellar_plate_green_p1", "green",2, 10, 2, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 2, EntityEquipmentSlot.LEGS, "lamellar_legs_green_p1", "lamellar_legs_green_p1","green", 2, 6, 2, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 3, EntityEquipmentSlot.FEET, "lamellar_feet_green_p1", "lamellar_feet_green_p1","green", 1, 5, 1, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "lamellar_helmet_default_p2", "lamellar_helmet_default_p2", "default",5, 10, 2, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "lamellar_plate_default_p2", "lamellar_plate_default_p2", "default",4, 13, 2, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 2, EntityEquipmentSlot.LEGS, "lamellar_legs_default_p2", "lamellar_legs_default_p2","default", 4, 11, 2, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 3, EntityEquipmentSlot.FEET, "lamellar_feet_default_p2", "lamellar_feet_default_p2","default", 4,  9, 1, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "lamellar_helmet_black_p2", "lamellar_helmet_black_p2", "black",5, 10, 2, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "lamellar_plate_black_p2", "lamellar_plate_black_p2", "black",4, 13, 2, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 2, EntityEquipmentSlot.LEGS, "lamellar_legs_black_p2", "lamellar_legs_black_p2","black", 4, 11, 2, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 3, EntityEquipmentSlot.FEET, "lamellar_feet_black_p2", "lamellar_feet_black_p2","black", 4,  9, 1, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "lamellar_helmet_blue_p2", "lamellar_helmet_blue_p2", "blue",5, 10, 2, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "lamellar_plate_blue_p2", "lamellar_plate_blue_p2", "blue",4, 13, 2, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 2, EntityEquipmentSlot.LEGS, "lamellar_legs_blue_p2", "lamellar_legs_blue_p2","blue", 4, 11, 2, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 3, EntityEquipmentSlot.FEET, "lamellar_feet_blue_p2", "lamellar_feet_blue_p2","blue", 4,  9, 1, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "lamellar_helmet_red_p2", "lamellar_helmet_red_p2", "red",5, 10, 2, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "lamellar_plate_red_p2", "lamellar_plate_red_p2", "red",4, 13, 2, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 2, EntityEquipmentSlot.LEGS, "lamellar_legs_red_p2", "lamellar_legs_red_p2","red", 4, 11, 2, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 3, EntityEquipmentSlot.FEET, "lamellar_feet_red_p2", "lamellar_feet_red_p2","red", 4,  9, 1, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "lamellar_helmet_yellow_p2", "lamellar_helmet_yellow_p2", "yellow",5, 10, 2, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "lamellar_plate_yellow_p2", "lamellar_plate_yellow_p2", "yellow",4, 13, 2, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 2, EntityEquipmentSlot.LEGS, "lamellar_legs_yellow_p2", "lamellar_legs_yellow_p2","yellow", 4, 11, 2, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 3, EntityEquipmentSlot.FEET, "lamellar_feet_yellow_p2", "lamellar_feet_yellow_p2","yellow", 4,  9, 1, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "lamellar_helmet_white_p2", "lamellar_helmet_white_p2", "white",5, 10, 2, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "lamellar_plate_white_p2", "lamellar_plate_white_p2", "white",4, 13, 2, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 2, EntityEquipmentSlot.LEGS, "lamellar_legs_white_p2", "lamellar_legs_white_p2","white", 4, 11, 2, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 3, EntityEquipmentSlot.FEET, "lamellar_feet_white_p2", "lamellar_feet_white_p2","white", 4,  9, 1, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "lamellar_helmet_green_p2", "lamellar_helmet_green_p2", "green",5, 10, 2, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "lamellar_plate_green_p2", "lamellar_plate_green_p2", "green",4, 13, 2, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 2, EntityEquipmentSlot.LEGS, "lamellar_legs_green_p2", "lamellar_legs_green_p2","green", 4, 11, 2, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 3, EntityEquipmentSlot.FEET, "lamellar_feet_green_p2", "lamellar_feet_green_p2","green", 4,  9, 1, 0, 0, 0.1),

                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.GOLD, 0, EntityEquipmentSlot.HEAD, "sacred_armor_helmet", "sacred_armor_helmet", 1, 3, 3, 0, 0, 0.01),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.GOLD, 1, EntityEquipmentSlot.CHEST, "sacred_armor_plate", "sacred_armor_plate", 3, 5, 4, 0, 0, 0.01),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.GOLD, 2, EntityEquipmentSlot.LEGS, "sacred_armor_legs", "sacred_armor_legs", 1, 3, 3, 0, 0, 0.01),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.GOLD, 3, EntityEquipmentSlot.FEET, "sacred_armor_feet", "sacred_armor_feet", 1, 3, 2, 0, 0, 0.01),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.GOLD, 0, EntityEquipmentSlot.HEAD, "sacred_armor_helmet_p1", "sacred_armor_helmet_p1", 3, 5, 3, 0, 0, 0.03),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.GOLD, 1, EntityEquipmentSlot.CHEST, "sacred_armor_plate_p1", "sacred_armor_plate_p1", 5, 7, 4, 0, 0, 0.03),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.GOLD, 2, EntityEquipmentSlot.LEGS, "sacred_armor_legs_p1", "sacred_armor_legs_p1", 3, 5, 3, 0, 0, 0.03),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.GOLD, 3, EntityEquipmentSlot.FEET, "sacred_armor_feet_p1", "sacred_armor_feet_p1", 4, 4, 2, 0, 0, 0.03),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.GOLD, 0, EntityEquipmentSlot.HEAD, "sacred_armor_helmet_p2", "sacred_armor_helmet_p2", 5, 9, 3, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.GOLD, 1, EntityEquipmentSlot.CHEST, "sacred_armor_plate_p2", "sacred_armor_plate_p2", 8, 10, 4, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.GOLD, 2, EntityEquipmentSlot.LEGS, "sacred_armor_legs_p2", "sacred_armor_legs_p2", 6, 8, 3, 0, 0, 0.07),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.GOLD, 3, EntityEquipmentSlot.FEET, "sacred_armor_feet_p2", "sacred_armor_feet_p2", 6, 8, 2, 0, 0, 0.07),

                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.CHAIN, 0, EntityEquipmentSlot.HEAD, "splint_mail_helmet", "splint_mail_helmet", 3, 1, 2, 0, 0, 0.0),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.CHAIN, 1, EntityEquipmentSlot.CHEST, "splint_mail_plate", "splint_mail_plate", 5, 3, 3, 0, 0, 0.0),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.CHAIN, 2, EntityEquipmentSlot.LEGS, "splint_mail_legs", "splint_mail_legs", 4, 1, 3, 0, 0, 0.0),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.CHAIN, 3, EntityEquipmentSlot.FEET, "splint_mail_feet", "splint_mail_feet", 2, 1, 2, 0, 0, 0.0),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.CHAIN, 0, EntityEquipmentSlot.HEAD, "splint_mail_helmet_p1", "splint_mail_helmet_p1", 5, 3, 2, 1, 1, 0.0),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.CHAIN, 1, EntityEquipmentSlot.CHEST, "splint_mail_plate_p1", "splint_mail_plate_p1", 7, 5, 3, 1, 1, 0.0),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.CHAIN, 2, EntityEquipmentSlot.LEGS, "splint_mail_legs_p1", "splint_mail_legs_p1", 5, 3, 3, 1, 1, 0.0),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.CHAIN, 3, EntityEquipmentSlot.FEET, "splint_mail_feet_p1", "splint_mail_feet_p1", 4, 4, 2, 1, 1, 0.0),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.CHAIN, 0, EntityEquipmentSlot.HEAD, "splint_mail_helmet_p2", "splint_mail_helmet_p2", 9, 5, 2, 2, 2, 0.0),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.CHAIN, 1, EntityEquipmentSlot.CHEST, "splint_mail_plate_p2", "splint_mail_plate_p2", 10, 8, 3, 2, 2, 0.0),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.CHAIN, 2, EntityEquipmentSlot.LEGS, "splint_mail_legs_p2", "splint_mail_legs_p2", 8, 6, 3, 2, 2, 0.0),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.CHAIN, 3, EntityEquipmentSlot.FEET, "splint_mail_feet_p2", "splint_mail_feet_p2", 8, 6, 2, 2, 2, 0.0),

                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.IRON, 0, EntityEquipmentSlot.HEAD, "bastille_plate_helmet", "bastille_plate_helmet", 4, 0, 4, 0, 0, 0.02),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.IRON, 1, EntityEquipmentSlot.CHEST, "bastille_plate_plate", "bastille_plate_plate", 7, 1, 7, 0, 0, 0.02),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.IRON, 2, EntityEquipmentSlot.LEGS, "bastille_plate_legs", "bastille_plate_legs", 4, 1, 7, 0, 0, 0.02),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.IRON, 3, EntityEquipmentSlot.FEET, "bastille_plate_feet", "bastille_plate_feet", 3, 0, 4, 0, 0, 0.02),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.IRON, 0, EntityEquipmentSlot.HEAD, "bastille_plate_helmet_p1", "bastille_plate_helmet_p1", 7, 3, 4, 0, 0, 0.04),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.IRON, 1, EntityEquipmentSlot.CHEST, "bastille_plate_plate_p1", "bastille_plate_plate_p1", 10, 2, 7, 0, 0, 0.04),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.IRON, 2, EntityEquipmentSlot.LEGS, "bastille_plate_legs_p1", "bastille_plate_legs_p1", 6, 2, 7, 0, 0, 0.04),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.IRON, 3, EntityEquipmentSlot.FEET, "bastille_plate_feet_p1", "bastille_plate_feet_p1", 5, 1, 4, 0, 0, 0.04),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.IRON, 0, EntityEquipmentSlot.HEAD, "bastille_plate_helmet_p2", "bastille_plate_helmet_p2", 10, 5, 4, 0, 0, 0.09),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.IRON, 1, EntityEquipmentSlot.CHEST, "bastille_plate_plate_p2", "bastille_plate_plate_p2", 13, 4, 7, 0, 0, 0.09),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.IRON, 2, EntityEquipmentSlot.LEGS, "bastille_plate_legs_p2", "bastille_plate_legs_p2", 11, 4, 7, 0, 0, 0.09),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.IRON, 3, EntityEquipmentSlot.FEET, "bastille_plate_feet_p2", "bastille_plate_feet_p2", 9, 4, 4, 0, 0, 0.09),

                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.DIAMOND, 0, EntityEquipmentSlot.HEAD, "avalon_mail_helmet", "avalon_mail_helmet", 2, 2, 3, 0, 0, 0.02),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.DIAMOND, 1, EntityEquipmentSlot.CHEST, "avalon_mail_plate", "avalon_mail_plate", 4, 4, 4, 0, 0, 0.02),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.DIAMOND, 2, EntityEquipmentSlot.LEGS, "avalon_mail_legs", "avalon_mail_legs", 2, 2, 6, 0, 0, 0.02),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.DIAMOND, 3, EntityEquipmentSlot.FEET, "avalon_mail_feet", "avalon_mail_feet", 2, 2, 3, 0, 0, 0.02),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.DIAMOND, 0, EntityEquipmentSlot.HEAD, "avalon_mail_helmet_p1", "avalon_mail_helmet_p1", 4, 4, 3, 0, 0, 0.04),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.DIAMOND, 1, EntityEquipmentSlot.CHEST, "avalon_mail_plate_p1", "avalon_mail_plate_p1", 6, 6, 4, 0, 0, 0.04),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.DIAMOND, 2, EntityEquipmentSlot.LEGS, "avalon_mail_legs_p1", "avalon_mail_legs_p1", 4, 4, 6, 0, 0, 0.04),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.DIAMOND, 3, EntityEquipmentSlot.FEET, "avalon_mail_feet_p1", "avalon_mail_feet_p1", 4, 4, 3, 0, 0, 0.04),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.DIAMOND, 0, EntityEquipmentSlot.HEAD, "avalon_mail_helmet_p2", "avalon_mail_helmet_p2", 7, 7, 3, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.DIAMOND, 1, EntityEquipmentSlot.CHEST, "avalon_mail_plate_p2", "avalon_mail_plate_p2", 9, 9, 4, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.DIAMOND, 2, EntityEquipmentSlot.LEGS, "avalon_mail_legs_p2", "avalon_mail_legs_p2", 7, 7, 6, 0, 0, 0.1),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.DIAMOND, 3, EntityEquipmentSlot.FEET, "avalon_mail_feet_p2", "avalon_mail_feet_p2", 7, 7, 3, 0, 0, 0.1),

                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "sorcerers_sallet", "sorcerers_sallet", 4, 2, 4, 4, 0, 0.0),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "sorcerers_sallet_p1", "sorcerers_sallet_p1", 7, 3, 4, 7, 0, 0.0),

                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "sorcerers_hat", "sorcerers_hat", 2, 4, 3, 0, 4, 0.0),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "sorcerers_hat_p1", "sorcerers_hat_p1", 3, 7, 3, 0, 7, 0.0),

                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "sorcerers_robe", "sorcerers_robe", 0, 8, 1, 0, 2, 0.0),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "sorcerers_robe_p1", "sorcerers_robe_p1", 0, 12, 1, 0, 4, 0.0),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.CHEST, "sorcerers_robe_p2", "sorcerers_robe_p2", 0, 17, 1, 0, 8, 0.0),

                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "thiefs_hood", "thiefs_hood", 1, 0, 0, 0, 0, 0.06),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "thiefs_hood_p1", "thiefs_hood_p1", 3, 1, 0, 0, 0, 1.1),

                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "skeleton_helmet", "skeleton_helmet", -4, -4, 1, 5, 5, 0.0),
                new ItemNecropolisArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD, "skeleton_helmet_p1", "skeleton_helmet_p1", -4, -4, 1, 9, 9, 0.0)
        );
    }
}
