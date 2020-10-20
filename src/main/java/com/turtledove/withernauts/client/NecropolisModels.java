package com.turtledove.withernauts.client;

import com.turtledove.withernauts.Necropolis_of_Nostalgia;
import com.turtledove.withernauts.server.blocks.BlockHandler;
import com.turtledove.withernauts.server.item.ItemHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Necropolis_of_Nostalgia.MODID)
public class NecropolisModels
{
    private NecropolisModels() {};
    @SubscribeEvent
    public static void register(ModelRegistryEvent event)
    {
        registerBlockModel(BlockHandler.BAKE_KETTLE, "bake_kettle");
        registerBlockModel(BlockHandler.REPITIFLEUR, "repitifleur");
        registerBlockModel(BlockHandler.KELP, "kelp");

        registerBlockModel(BlockHandler.FOREST_SHRUB, "forest_shrub");

        registerBlockModel(BlockHandler.YAM_BLUEPRINT, "yam_blueprint");
        registerBlockModel(BlockHandler.FARM_PLOT, "farm_plot");
        registerBlockModel(BlockHandler.TEA_BLUEPRINT, "tea_blueprint");
        registerBlockModel(BlockHandler.RICE_FARM_PLOT, "rice_farm_plot");

        registerBlockModel(BlockHandler.DWIGT_BLUEPRINT, "dwigt_blueprint");
        registerBlockModel(BlockHandler.RITA_BLUEPRINT, "rita_blueprint");
        registerBlockModel(BlockHandler.CARLSON_BLUEPRINT, "carlson_blueprint");

        registerItemModel(ItemHandler.RICE_SEED, "rice_seed");
        registerItemModel(ItemHandler.CAT_TAIL, "cat_tail");
        registerItemModel(ItemHandler.DUCKWEED, "duckweed");

        registerItemModel(ItemHandler.WOODEN_RAPIER, "wooden_rapier");
        registerItemModel(ItemHandler.GOLD_RAPIER, "gold_rapier");
        registerItemModel(ItemHandler.STONE_RAPIER, "stone_rapier");
        registerItemModel(ItemHandler.IRON_RAPIER, "iron_rapier");
        registerItemModel(ItemHandler.DIAMOND_RAPIER, "diamond_rapier");

        registerItemModel(ItemHandler.STEAK_POTATO, "steak_potato");
        registerItemModel(ItemHandler.TOASTED_SANDWICH, "toasted_sandwich");
        registerItemModel(ItemHandler.BROTH, "broth");
        registerItemModel(ItemHandler.ROAST, "roast");
        registerItemModel(ItemHandler.PORK_STEW, "pork_stew");
        registerItemModel(ItemHandler.SEAFOOD_FRIED_RICE, "seafood_fried_rice");
        registerItemModel(ItemHandler.OMURICE, "omurice");
        registerItemModel(ItemHandler.STEAMED_RICE, "steamed_rice");
        registerItemModel(ItemHandler.MUSHROOM_BURGER, "mushroom_burger");
        registerItemModel(ItemHandler.VEGGIE_STIR_FRY, "veggie_stir_fry");
        registerItemModel(ItemHandler.MYSTERY_MEAL, "mystery_meal");


        registerItemModel(ItemHandler.KNIGHT_SWORD, "knight_sword");
        registerItemModel(ItemHandler.KNIGHT_SWORD_P1, "knight_sword_p1");
        registerItemModel(ItemHandler.KNIGHT_SWORD_P2, "knight_sword_p2");

        registerItemModel(ItemHandler.RUNE_BLADE, "rune_blade");
        registerItemModel(ItemHandler.RUNE_BLADE_P1, "rune_blade_p1");
        registerItemModel(ItemHandler.RUNE_BLADE_P2, "rune_blade_p2");

        registerItemModel(ItemHandler.HIGH_DAMASCUS, "high_damascus");
        registerItemModel(ItemHandler.HIGH_DAMASCUS_P1, "high_damascus_p1");
        registerItemModel(ItemHandler.HIGH_DAMASCUS_P2, "high_damascus_p2");

        registerItemModel(ItemHandler.MOONLIGHT_AQUA, "moonlight_aqua");
        registerItemModel(ItemHandler.MOONLIGHT_AQUA_P1, "moonlight_aqua_p1");


        registerItemModel(ItemHandler.SCYTHE, "scythe");
        registerItemModel(ItemHandler.SCYTHE_P1, "scythe_p1");

        registerItemModel(ItemHandler.LONGINUS, "longinus");
        registerItemModel(ItemHandler.LONGINUS_P1, "longinus_p1");

        registerItemModel(ItemHandler.EXCALIBER, "excaliber");
        registerItemModel(ItemHandler.EXCALIBER_P1, "excaliber_p1");

        registerItemModel(ItemHandler.POSEIDON, "poseidon");
        registerItemModel(ItemHandler.POSEIDON_P1, "poseidon_p1");




        registerItemModel(ItemHandler.HOLY_AVENGER, "holy_avenger");
        registerItemModel(ItemHandler.HOLY_AVENGER_P1, "holy_avenger_p1");
        registerItemModel(ItemHandler.HOLY_AVENGER_P2, "holy_avenger_p2");

        registerItemModel(ItemHandler.MERCURIUS, "mercurius");
        registerItemModel(ItemHandler.MERCURIUS_P1, "mercurius_p1");
        registerItemModel(ItemHandler.MERCURIUS_P2, "mercurius_p2");

        registerItemModel(ItemHandler.IRON_MAIDEN, "iron_maiden");
        registerItemModel(ItemHandler.IRON_MAIDEN_P1, "iron_maiden_p1");
        registerItemModel(ItemHandler.IRON_MAIDEN_P2, "iron_maiden_p2");

        registerItemModel(ItemHandler.RADIANT_STAR, "radiant_star");
        registerItemModel(ItemHandler.RADIANT_STAR_P1, "radiant_star_p1");



        registerItemModel(ItemHandler.PSYCHEDELIA, "psychedelia");
        registerItemModel(ItemHandler.PSYCHEDELIA_P1, "psychedelia_p1");

        registerItemModel(ItemHandler.GRIMOIRE, "grimoire");
        registerItemModel(ItemHandler.GRIMOIRE_P1, "grimoire_p1");

        registerItemModel(ItemHandler.SERAPHIM, "seraphim");
        registerItemModel(ItemHandler.SERAPHIM_P1, "seraphim_p1");

        registerItemModel(ItemHandler.NOTUNG, "notung");
        registerItemModel(ItemHandler.NOTUNG_P1, "notung_p1");



        registerItemModel(ItemHandler.LAMELLAR_HELMET_DEFAULT, "lamellar_helmet_default");
        registerItemModel(ItemHandler.LAMELLAR_PLATE_DEFAULT, "lamellar_plate_default");
        registerItemModel(ItemHandler.LAMELLAR_LEGS_DEFAULT, "lamellar_legs_default");
        registerItemModel(ItemHandler.LAMELLAR_FEET_DEFAULT, "lamellar_feet_default");
        registerItemModel(ItemHandler.LAMELLAR_HELMET_BLACK, "lamellar_helmet_black");
        registerItemModel(ItemHandler.LAMELLAR_PLATE_BLACK, "lamellar_plate_black");
        registerItemModel(ItemHandler.LAMELLAR_LEGS_BLACK, "lamellar_legs_black");
        registerItemModel(ItemHandler.LAMELLAR_FEET_BLACK, "lamellar_feet_black");
        registerItemModel(ItemHandler.LAMELLAR_HELMET_WHITE, "lamellar_helmet_white");
        registerItemModel(ItemHandler.LAMELLAR_PLATE_WHITE, "lamellar_plate_white");
        registerItemModel(ItemHandler.LAMELLAR_LEGS_WHITE, "lamellar_legs_white");
        registerItemModel(ItemHandler.LAMELLAR_FEET_WHITE, "lamellar_feet_white");
        registerItemModel(ItemHandler.LAMELLAR_HELMET_BLUE, "lamellar_helmet_blue");
        registerItemModel(ItemHandler.LAMELLAR_PLATE_BLUE, "lamellar_plate_blue");
        registerItemModel(ItemHandler.LAMELLAR_LEGS_BLUE, "lamellar_legs_blue");
        registerItemModel(ItemHandler.LAMELLAR_FEET_BLUE, "lamellar_feet_blue");
        registerItemModel(ItemHandler.LAMELLAR_HELMET_RED, "lamellar_helmet_red");
        registerItemModel(ItemHandler.LAMELLAR_PLATE_RED, "lamellar_plate_red");
        registerItemModel(ItemHandler.LAMELLAR_LEGS_RED, "lamellar_legs_red");
        registerItemModel(ItemHandler.LAMELLAR_FEET_RED, "lamellar_feet_red");
        registerItemModel(ItemHandler.LAMELLAR_HELMET_YELLOW, "lamellar_helmet_yellow");
        registerItemModel(ItemHandler.LAMELLAR_PLATE_YELLOW, "lamellar_plate_yellow");
        registerItemModel(ItemHandler.LAMELLAR_LEGS_YELLOW, "lamellar_legs_yellow");
        registerItemModel(ItemHandler.LAMELLAR_FEET_YELLOW, "lamellar_feet_yellow");
        registerItemModel(ItemHandler.LAMELLAR_HELMET_GREEN, "lamellar_helmet_green");
        registerItemModel(ItemHandler.LAMELLAR_PLATE_GREEN, "lamellar_plate_green");
        registerItemModel(ItemHandler.LAMELLAR_LEGS_GREEN, "lamellar_legs_green");
        registerItemModel(ItemHandler.LAMELLAR_FEET_GREEN, "lamellar_feet_green");
        registerItemModel(ItemHandler.LAMELLAR_HELMET_DEFAULT_P1, "lamellar_helmet_default_p1");
        registerItemModel(ItemHandler.LAMELLAR_PLATE_DEFAULT_P1, "lamellar_plate_default_p1");
        registerItemModel(ItemHandler.LAMELLAR_LEGS_DEFAULT_P1, "lamellar_legs_default_p1");
        registerItemModel(ItemHandler.LAMELLAR_FEET_DEFAULT_P1, "lamellar_feet_default_p1");
        registerItemModel(ItemHandler.LAMELLAR_HELMET_BLACK_P1, "lamellar_helmet_black_p1");
        registerItemModel(ItemHandler.LAMELLAR_PLATE_BLACK_P1, "lamellar_plate_black_p1");
        registerItemModel(ItemHandler.LAMELLAR_LEGS_BLACK_P1, "lamellar_legs_black_p1");
        registerItemModel(ItemHandler.LAMELLAR_FEET_BLACK_P1, "lamellar_feet_black_p1");
        registerItemModel(ItemHandler.LAMELLAR_HELMET_WHITE_P1, "lamellar_helmet_white_p1");
        registerItemModel(ItemHandler.LAMELLAR_PLATE_WHITE_P1, "lamellar_plate_white_p1");
        registerItemModel(ItemHandler.LAMELLAR_LEGS_WHITE_P1, "lamellar_legs_white_p1");
        registerItemModel(ItemHandler.LAMELLAR_FEET_WHITE_P1, "lamellar_feet_white_p1");
        registerItemModel(ItemHandler.LAMELLAR_HELMET_BLUE_P1, "lamellar_helmet_blue_p1");
        registerItemModel(ItemHandler.LAMELLAR_PLATE_BLUE_P1, "lamellar_plate_blue_p1");
        registerItemModel(ItemHandler.LAMELLAR_LEGS_BLUE_P1, "lamellar_legs_blue_p1");
        registerItemModel(ItemHandler.LAMELLAR_FEET_BLUE_P1, "lamellar_feet_blue_p1");
        registerItemModel(ItemHandler.LAMELLAR_HELMET_RED_P1, "lamellar_helmet_red_p1");
        registerItemModel(ItemHandler.LAMELLAR_PLATE_RED_P1, "lamellar_plate_red_p1");
        registerItemModel(ItemHandler.LAMELLAR_LEGS_RED_P1, "lamellar_legs_red_p1");
        registerItemModel(ItemHandler.LAMELLAR_FEET_RED_P1, "lamellar_feet_red_p1");
        registerItemModel(ItemHandler.LAMELLAR_HELMET_YELLOW_P1, "lamellar_helmet_yellow_p1");
        registerItemModel(ItemHandler.LAMELLAR_PLATE_YELLOW_P1, "lamellar_plate_yellow_p1");
        registerItemModel(ItemHandler.LAMELLAR_LEGS_YELLOW_P1, "lamellar_legs_yellow_p1");
        registerItemModel(ItemHandler.LAMELLAR_FEET_YELLOW_P1, "lamellar_feet_yellow_p1");
        registerItemModel(ItemHandler.LAMELLAR_HELMET_GREEN_P1, "lamellar_helmet_green_p1");
        registerItemModel(ItemHandler.LAMELLAR_PLATE_GREEN_P1, "lamellar_plate_green_p1");
        registerItemModel(ItemHandler.LAMELLAR_LEGS_GREEN_P1, "lamellar_legs_green_p1");
        registerItemModel(ItemHandler.LAMELLAR_FEET_GREEN_P1, "lamellar_feet_green_p1");
        registerItemModel(ItemHandler.LAMELLAR_HELMET_DEFAULT_P2, "lamellar_helmet_default_p2");
        registerItemModel(ItemHandler.LAMELLAR_PLATE_DEFAULT_P2, "lamellar_plate_default_p2");
        registerItemModel(ItemHandler.LAMELLAR_LEGS_DEFAULT_P2, "lamellar_legs_default_p2");
        registerItemModel(ItemHandler.LAMELLAR_FEET_DEFAULT_P2, "lamellar_feet_default_p2");
        registerItemModel(ItemHandler.LAMELLAR_HELMET_BLACK_P2, "lamellar_helmet_black_p2");
        registerItemModel(ItemHandler.LAMELLAR_PLATE_BLACK_P2, "lamellar_plate_black_p2");
        registerItemModel(ItemHandler.LAMELLAR_LEGS_BLACK_P2, "lamellar_legs_black_p2");
        registerItemModel(ItemHandler.LAMELLAR_FEET_BLACK_P2, "lamellar_feet_black_p2");
        registerItemModel(ItemHandler.LAMELLAR_HELMET_WHITE_P2, "lamellar_helmet_white_p2");
        registerItemModel(ItemHandler.LAMELLAR_PLATE_WHITE_P2, "lamellar_plate_white_p2");
        registerItemModel(ItemHandler.LAMELLAR_LEGS_WHITE_P2, "lamellar_legs_white_p2");
        registerItemModel(ItemHandler.LAMELLAR_FEET_WHITE_P2, "lamellar_feet_white_p2");
        registerItemModel(ItemHandler.LAMELLAR_HELMET_BLUE_P2, "lamellar_helmet_blue_p2");
        registerItemModel(ItemHandler.LAMELLAR_PLATE_BLUE_P2, "lamellar_plate_blue_p2");
        registerItemModel(ItemHandler.LAMELLAR_LEGS_BLUE_P2, "lamellar_legs_blue_p2");
        registerItemModel(ItemHandler.LAMELLAR_FEET_BLUE_P2, "lamellar_feet_blue_p2");
        registerItemModel(ItemHandler.LAMELLAR_HELMET_RED_P2, "lamellar_helmet_red_p2");
        registerItemModel(ItemHandler.LAMELLAR_PLATE_RED_P2, "lamellar_plate_red_p2");
        registerItemModel(ItemHandler.LAMELLAR_LEGS_RED_P2, "lamellar_legs_red_p2");
        registerItemModel(ItemHandler.LAMELLAR_FEET_RED_P2, "lamellar_feet_red_p2");
        registerItemModel(ItemHandler.LAMELLAR_HELMET_YELLOW_P2, "lamellar_helmet_yellow_p2");
        registerItemModel(ItemHandler.LAMELLAR_PLATE_YELLOW_P2, "lamellar_plate_yellow_p2");
        registerItemModel(ItemHandler.LAMELLAR_LEGS_YELLOW_P2, "lamellar_legs_yellow_p2");
        registerItemModel(ItemHandler.LAMELLAR_FEET_YELLOW_P2, "lamellar_feet_yellow_p2");
        registerItemModel(ItemHandler.LAMELLAR_HELMET_GREEN_P2, "lamellar_helmet_green_p2");
        registerItemModel(ItemHandler.LAMELLAR_PLATE_GREEN_P2, "lamellar_plate_green_p2");
        registerItemModel(ItemHandler.LAMELLAR_LEGS_GREEN_P2, "lamellar_legs_green_p2");
        registerItemModel(ItemHandler.LAMELLAR_FEET_GREEN_P2, "lamellar_feet_green_p2");

        registerItemModel(ItemHandler.SACRED_ARMOR_HELMET, "sacred_armor_helmet");
        registerItemModel(ItemHandler.SACRED_ARMOR_PLATE, "sacred_armor_plate");
        registerItemModel(ItemHandler.SACRED_ARMOR_LEGS, "sacred_armor_legs");
        registerItemModel(ItemHandler.SACRED_ARMOR_FEET, "sacred_armor_feet");
        registerItemModel(ItemHandler.SACRED_ARMOR_HELMET_P1, "sacred_armor_helmet_p1");
        registerItemModel(ItemHandler.SACRED_ARMOR_PLATE_P1, "sacred_armor_plate_p1");
        registerItemModel(ItemHandler.SACRED_ARMOR_LEGS_P1, "sacred_armor_legs_p1");
        registerItemModel(ItemHandler.SACRED_ARMOR_FEET_P1, "sacred_armor_feet_p1");
        registerItemModel(ItemHandler.SACRED_ARMOR_HELMET_P2, "sacred_armor_helmet_p2");
        registerItemModel(ItemHandler.SACRED_ARMOR_PLATE_P2, "sacred_armor_plate_p2");
        registerItemModel(ItemHandler.SACRED_ARMOR_LEGS_P2, "sacred_armor_legs_p2");
        registerItemModel(ItemHandler.SACRED_ARMOR_FEET_P2, "sacred_armor_feet_p2");

        registerItemModel(ItemHandler.SPLINT_MAIL_HELMET, "splint_mail_helmet");
        registerItemModel(ItemHandler.SPLINT_MAIL_PLATE, "splint_mail_plate");
        registerItemModel(ItemHandler.SPLINT_MAIL_LEGS, "splint_mail_legs");
        registerItemModel(ItemHandler.SPLINT_MAIL_FEET, "splint_mail_feet");
        registerItemModel(ItemHandler.SPLINT_MAIL_HELMET_P1,"splint_mail_helmet_p1");
        registerItemModel(ItemHandler.SPLINT_MAIL_PLATE_P1,"splint_mail_plate_p1");
        registerItemModel(ItemHandler.SPLINT_MAIL_LEGS_P1,"splint_mail_legs_p1");
        registerItemModel(ItemHandler.SPLINT_MAIL_FEET_P1,"splint_mail_feet_p1");
        registerItemModel(ItemHandler.SPLINT_MAIL_HELMET_P2,"splint_mail_helmet_p2");
        registerItemModel(ItemHandler.SPLINT_MAIL_PLATE_P2,"splint_mail_plate_p2");
        registerItemModel(ItemHandler.SPLINT_MAIL_LEGS_P2,"splint_mail_legs_p2");
        registerItemModel(ItemHandler.SPLINT_MAIL_FEET_P2,"splint_mail_feet_p2");

        registerItemModel(ItemHandler.BASTILLE_PLATE_HELMET, "bastille_plate_helmet");
        registerItemModel(ItemHandler.BASTILLE_PLATE_PLATE, "bastille_plate_plate");
        registerItemModel(ItemHandler.BASTILLE_PLATE_LEGS, "bastille_plate_legs");
        registerItemModel(ItemHandler.BASTILLE_PLATE_FEET, "bastille_plate_feet");
        registerItemModel(ItemHandler.BASTILLE_PLATE_HELMET_P1, "bastille_plate_helmet_p1");
        registerItemModel(ItemHandler.BASTILLE_PLATE_PLATE_P1, "bastille_plate_plate_p1");
        registerItemModel(ItemHandler.BASTILLE_PLATE_LEGS_P1, "bastille_plate_legs_p1");
        registerItemModel(ItemHandler.BASTILLE_PLATE_FEET_P1, "bastille_plate_feet_p1");
        registerItemModel(ItemHandler.BASTILLE_PLATE_HELMET_P2, "bastille_plate_helmet_p2");
        registerItemModel(ItemHandler.BASTILLE_PLATE_PLATE_P2, "bastille_plate_plate_p2");
        registerItemModel(ItemHandler.BASTILLE_PLATE_LEGS_P2, "bastille_plate_legs_p2");
        registerItemModel(ItemHandler.BASTILLE_PLATE_FEET_P2, "bastille_plate_feet_p2");

        registerItemModel(ItemHandler.AVALON_MAIL_HELMET, "avalon_mail_helmet");
        registerItemModel(ItemHandler.AVALON_MAIL_PLATE, "avalon_mail_plate");
        registerItemModel(ItemHandler.AVALON_MAIL_LEGS, "avalon_mail_legs");
        registerItemModel(ItemHandler.AVALON_MAIL_FEET, "avalon_mail_feet");
        registerItemModel(ItemHandler.AVALON_MAIL_HELMET_P1,"avalon_mail_helmet_p1");
        registerItemModel(ItemHandler.AVALON_MAIL_PLATE_P1,"avalon_mail_plate_p1");
        registerItemModel(ItemHandler.AVALON_MAIL_LEGS_P1,"avalon_mail_legs_p1");
        registerItemModel(ItemHandler.AVALON_MAIL_FEET_P1,"avalon_mail_feet_p1");
        registerItemModel(ItemHandler.AVALON_MAIL_HELMET_P2,"avalon_mail_helmet_p2");
        registerItemModel(ItemHandler.AVALON_MAIL_PLATE_P2,"avalon_mail_plate_p2");
        registerItemModel(ItemHandler.AVALON_MAIL_LEGS_P2,"avalon_mail_legs_p2");
        registerItemModel(ItemHandler.AVALON_MAIL_FEET_P2,"avalon_mail_feet_p2");
        

        registerItemModel(ItemHandler.SORCERERS_SALLET, "sorcerers_sallet");
        registerItemModel(ItemHandler.SORCERERS_SALLET_P1, "sorcerers_sallet_p1");

        registerItemModel(ItemHandler.SORCERERS_HAT, "sorcerers_hat");
        registerItemModel(ItemHandler.SORCERERS_HAT_P1, "sorcerers_hat_p1");

        registerItemModel(ItemHandler.SORCERERS_ROBE, "sorcerers_robe");
        registerItemModel(ItemHandler.SORCERERS_ROBE_P1, "sorcerers_robe_p1");
        registerItemModel(ItemHandler.SORCERERS_ROBE_P2, "sorcerers_robe_p2");

        registerItemModel(ItemHandler.THIEFS_HOOD, "thiefs_hood");
        registerItemModel(ItemHandler.THIEFS_HOOD_P1, "thiefs_hood_p1");

        registerItemModel(ItemHandler.SKELETON_HELMET, "skeleton_helmet");
        registerItemModel(ItemHandler.SKELETON_HELMET_P1, "skeleton_helmet_p1");


    }
    private static ModelResourceLocation registerBlockModel(Block block, String name) {
        return registerItemModel(Item.getItemFromBlock(block), 0, name);
    }
    private static ModelResourceLocation registerItemModel(Item item, String name) {
        return registerItemModel(item, 0, name);
    }

    private static ModelResourceLocation registerItemModel(Item item, int id, String name) {
        ModelResourceLocation resource = new ModelResourceLocation(Necropolis_of_Nostalgia.MODID + ":" + name, "inventory");
        ModelLoader.setCustomModelResourceLocation(item, id, resource);
        return resource;
    }
}
