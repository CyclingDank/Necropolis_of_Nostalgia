package com.turtledove.withernauts.server.sounds;

import com.turtledove.withernauts.Necropolis_of_Nostalgia;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber(modid = Necropolis_of_Nostalgia.MODID)
public class NecropolisSounds
{
    private NecropolisSounds() {
    }

    private static final SoundEvent NIL = null;

    //Combat
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":guard_hit")
    public static final SoundEvent GUARD_HIT = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":demon_fang")
    public static final SoundEvent DEMON_FANG = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":casting_40_ticks")
    public static final SoundEvent CASTING_40 = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":casting_80_ticks")
    public static final SoundEvent CASTING_80 = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":arte_complete")
    public static final SoundEvent ARTE_COMPLETE = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":heal")
    public static final SoundEvent HEAL = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":recover")
    public static final SoundEvent RECOVER = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":light_cast")
    public static final SoundEvent LIGHT_CAST = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":damage")
    public static final SoundEvent DAMAGE = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":beast")
    public static final SoundEvent BEAST = NIL;

    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":pb_cast")
    public static final SoundEvent PB_CAST = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":pb_crack")
    public static final SoundEvent PB_CRACK = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":pb_end")
    public static final SoundEvent PB_END = NIL;

    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":of_cast")
    public static final SoundEvent OF_CAST = NIL;

    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":nosferatu_cast")
    public static final SoundEvent NOSFERATU_CAST = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":nosferatu_end")
    public static final SoundEvent NOSFERATU_END = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":tb_cast")
    public static final SoundEvent TB_CAST = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":eruption_cast")
    public static final SoundEvent ERUPTION_CAST = NIL;

    //General
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":health_increase")
    public static final SoundEvent HEALTH_INCREASE = NIL;

    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":frying_1")
    public static final SoundEvent FRYING_1 = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":frying_2")
    public static final SoundEvent FRYING_2 = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":frying_3")
    public static final SoundEvent FRYING_3 = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":frying_4")
    public static final SoundEvent FRYING_4 = NIL;

    //enemies
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":skeleton_detect")
    public static final SoundEvent SKELETON_DETECT = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":skeleton_roar")
    public static final SoundEvent SKELETON_ROAR = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":ab_angry")
    public static final SoundEvent AB_ANGRY = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":ab_grunt")
    public static final SoundEvent AB_GRUNT = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":ab_cry")
    public static final SoundEvent AB_CRY = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":bat_ambient")
    public static final SoundEvent BAT_AMBIENT = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":bat_cry")
    public static final SoundEvent BAT_CRY = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":booglin_ambient")
    public static final SoundEvent BOOGLIN_AMBIENT = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":booglin_cry")
    public static final SoundEvent BOOGLIN_CRY = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":booglin_drill_1")
    public static final SoundEvent BOOGLIN_DRILL_1 = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":booglin_drill_2")
    public static final SoundEvent BOOGLIN_DRILL_2 = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":spider_ambient")
    public static final SoundEvent SPIDER_AMBIENT = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":spider_cry")
    public static final SoundEvent SPIDER_CRY = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":fugu_ambient")
    public static final SoundEvent FUGU_AMBIENT = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":fugu_cry")
    public static final SoundEvent FUGU_CRY = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":baby_spider_grow")
    public static final SoundEvent BABY_SPIDER_GROW = NIL;
    @GameRegistry.ObjectHolder(Necropolis_of_Nostalgia.MODID + ":baby_spider_gone")
    public static final SoundEvent BABY_SPIDER_GONE = NIL;


    @SubscribeEvent
    public static void register(RegistryEvent.Register<SoundEvent> event)
    {
        event.getRegistry().registerAll(
            create("guard_hit"),
                create("demon_fang"),
                create("casting_40_ticks"),
                create("heal"),
                create("damage"),
                create("health_increase"),
                create("frying_1"),
                create("frying_2"),
                create("frying_3"),
                create("frying_4"),
                create("skeleton_detect"),
                create("skeleton_roar"),
                create("beast"),
                create("arte_complete"),
                create("casting_80_ticks"),
                create("recover"),
                create("light_cast"),
                create("ab_angry"),
                create("ab_cry"),
                create("ab_grunt"),
                create("bat_ambient"),
                create("bat_cry"),
                create("booglin_ambient"),
                create("booglin_cry"),
                create("booglin_drill_1"),
                create("booglin_drill_2"),
                create("spider_ambient"),
                create("spider_cry"),
                create("fugu_ambient"),
                create("fugu_cry"),
                create("baby_spider_grow"),
                create("baby_spider_gone"),
                create("pb_cast"),
                create("pb_crack"),
                create("pb_end"),
                create("of_cast"),
                create("nosferatu_cast"),
                create("nosferatu_end"),
                create("tb_cast"),
                create("eruption_cast")
                );
    }
    private static SoundEvent create(String name)
    {
        return new SoundEvent(new ResourceLocation(Necropolis_of_Nostalgia.MODID, name)).setRegistryName(name);
    }
}
