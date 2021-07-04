package com.turtledove.necropolisofnostalgia;

import com.turtledove.necropolisofnostalgia.server.entity.enemies.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.*;
import scala.actors.threadpool.Arrays;

import java.util.LinkedHashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = Necropolis_of_Nostalgia.MODID)
public class  NecropolisMobs
{
    private static int nextEntityId;

    @SubscribeEvent
    public static void register(RegistryEvent.Register<EntityEntry> event)
    {
        Biome[] coldBiomes = BiomeDictionary.getBiomes(BiomeDictionary.Type.COLD).toArray(new Biome[BiomeDictionary.getBiomes(BiomeDictionary.Type.COLD).size()]);
        Biome[] hotBiomes = BiomeDictionary.getBiomes(BiomeDictionary.Type.HOT).toArray(new Biome[BiomeDictionary.getBiomes(BiomeDictionary.Type.HOT).size()]);
        Biome[] mountainBiomes = BiomeDictionary.getBiomes(BiomeDictionary.Type.MOUNTAIN).toArray(new Biome[BiomeDictionary.getBiomes(BiomeDictionary.Type.MOUNTAIN).size()]);
        Biome[] forestBiomes = BiomeDictionary.getBiomes(BiomeDictionary.Type.FOREST).toArray(new Biome[BiomeDictionary.getBiomes(BiomeDictionary.Type.FOREST).size()]);
        Biome[] plainsBiomes = BiomeDictionary.getBiomes(BiomeDictionary.Type.PLAINS).toArray(new Biome[BiomeDictionary.getBiomes(BiomeDictionary.Type.PLAINS).size()]);
        Biome[] wetBiomes = BiomeDictionary.getBiomes(BiomeDictionary.Type.WET).toArray(new Biome[BiomeDictionary.getBiomes(BiomeDictionary.Type.WET).size()]);
        Set<Biome> overworldSetA = new LinkedHashSet<Biome>();
        overworldSetA.addAll(Arrays.asList(coldBiomes));
        overworldSetA.addAll(Arrays.asList(hotBiomes));
        overworldSetA.addAll(Arrays.asList(mountainBiomes));
        overworldSetA.addAll(Arrays.asList(forestBiomes));
        overworldSetA.addAll(Arrays.asList(plainsBiomes));
        overworldSetA.addAll(Arrays.asList(wetBiomes));


        registerMonster(EntityEntryBuilder.<EntityNecropolisSkeleton>create(), event, EntityNecropolisSkeleton.class, "necropolis_skeleton", 0xb5b39b, 0xf6f5de,
                overworldSetA.toArray(new Biome[overworldSetA.size()]), 30, 1,1 );

        registerMonster(EntityEntryBuilder.<EntityAxeBeak>create(), event, EntityAxeBeak.class, "axe_beak", 0xa3fe72, 0xa7912b,
                overworldSetA.toArray(new Biome[overworldSetA.size()]), 30, 2,3 );

        registerMonster(EntityEntryBuilder.<EntityVampireBat>create(), event, EntityVampireBat.class, "vampire_bat", 0x323034, 0x5a503c,
                overworldSetA.toArray(new Biome[overworldSetA.size()]), 20, 1,1 );

        registerMonster(EntityEntryBuilder.<EntityBooglin>create(), event, EntityBooglin.class, "booglin", 0x527173, 0xddb286,
                overworldSetA.toArray(new Biome[overworldSetA.size()]), 30, 1,1 );

        registerMonster(EntityEntryBuilder.<EntityNecropolisSpider>create(), event, EntityNecropolisSpider.class, "necropolis_spider", 0x2c1b11, 0x422f35,
                overworldSetA.toArray(new Biome[overworldSetA.size()]), 15, 1,1 );

        registerEntity(event, EntityBabyNecropolisSpider.class, "baby_necropolis_spider", true, 0x614734, 0xd9bb7b, 64);

        registerMonster(EntityEntryBuilder.<EntityFugu>create(), event, EntityFugu.class, "fugu", 0xd0e3bc, 0x6b867c,
                overworldSetA.toArray(new Biome[overworldSetA.size()]), 20, 2,3 );
    }
    public static void registerTileEntity(Class<? extends TileEntity> entityClass, String name)
    {
        GameRegistry.registerTileEntity(entityClass, new ResourceLocation(Necropolis_of_Nostalgia.MODID, name));
    }

    public static void registerMonster(EntityEntryBuilder builder, RegistryEvent.Register<EntityEntry> event, Class<? extends Entity> entityClass, String name, int mainColor, int subColor, Biome[] biomes, int weight, int min, int max) {
        builder.entity(entityClass);
        builder.id(new ResourceLocation(Necropolis_of_Nostalgia.MODID, name), nextEntityId());
        builder.name(name);
        builder.egg(mainColor, subColor);
        builder.tracker(64, 1, true);
        builder.spawn(EnumCreatureType.MONSTER, weight,min,max, biomes);
        event.getRegistry().register(builder.build());
    }

    public static void registerNPC(EntityEntryBuilder builder, RegistryEvent.Register<EntityEntry> event, Class<? extends Entity> entityClass, String name, int mainColor, int subColor, Biome[] biomes, int weight, int min, int max) {
        builder.entity(entityClass);
        builder.id(new ResourceLocation(Necropolis_of_Nostalgia.MODID, name), nextEntityId());
        builder.name(name);
        builder.egg(mainColor, subColor);
        builder.tracker(64, 1, true);
        builder.spawn(EnumCreatureType.CREATURE, weight,min,max, biomes);
        event.getRegistry().register(builder.build());
    }


    public static void registerEntity(RegistryEvent.Register<EntityEntry> event, Class<? extends EntityLiving> entityClass, String name, boolean addEgg, int mainColor, int subColor, int trackingDistance)
    {
        if (addEgg) {
            event.getRegistry().register(EntityEntryBuilder.create()
                    .entity(entityClass)
                    .id(new ResourceLocation(Necropolis_of_Nostalgia.MODID, name), nextEntityId())
                    .name(name)
                    .tracker(trackingDistance, 1, true)
                    .egg(mainColor, subColor)
                    .build()
            );
        }
        else
        {
            event.getRegistry().register(EntityEntryBuilder.create()
                    .entity(entityClass)
                    .id(new ResourceLocation(Necropolis_of_Nostalgia.MODID, name), nextEntityId())
                    .name(name)
                    .tracker(trackingDistance, 1, true)
                    .build()
            );
        }
    }
    public static void registerEntity(RegistryEvent.Register<EntityEntry> event, Class<? extends Entity> entityClass, String name, int mainColor, int subColor, int trackingDistance)
    {
        event.getRegistry().register(EntityEntryBuilder.create()
                .entity(entityClass)
                .id(new ResourceLocation(Necropolis_of_Nostalgia.MODID, name), nextEntityId())
                .name(name)
                .tracker(trackingDistance, 1, true)
                .egg(mainColor, subColor)
                .build()
        );
    }
    private static int nextEntityId()
    {
        return nextEntityId++;
    }
}
