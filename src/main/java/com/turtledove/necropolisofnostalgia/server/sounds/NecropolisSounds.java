package com.turtledove.necropolisofnostalgia.server.sounds;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
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
                create("baby_spider_gone")
                );
    }
    private static SoundEvent create(String name)
    {
        return new SoundEvent(new ResourceLocation(Necropolis_of_Nostalgia.MODID, name)).setRegistryName(name);
    }
}
