package com.turtledove.necropolisofnostalgia;

import net.minecraftforge.common.config.Configuration;

public class WithernautsConfigs
{
    public double skeletonMaxHealth = 20D;
    public double skeletonDamage = 7D;
    public int skeletonSpawnWeight = 80;
    public int skeletonSpawnMaxGroupSize = 2;

    public double axebeakMaxHealth = 30D;
    public double axebeakDamage = 10D;
    public int axebeakSpawnWeight = 70;
    public int axebeakSpawnMaxGroupSize = 4;

    public double vampireBatMaxHealth = 20D;
    public double vampireBatDamage = 15D;
    public int vampireBatSpawnWeight = 80;

    public double spiderMaxHealth = 40D;
    public double spiderDamage = 20D;
    public int spiderSpawnWeight = 65;

    public double babySpiderMaxHealth = 12D;
    public double babySpiderDamage = 25D;

    public double fuguMaxHealth = 50D;
    public double fuguDamage = 30D;
    public int fuguSpawnWeight = 80;

    public double booglinMaxHealth = 60D;
    public double booglinDamage = 30D;
    public int booglinSpawnWeight = 80;

    //booglin special configs
    public boolean booglinGrief = true;

    public void init(Configuration config)
    {
        this.skeletonMaxHealth = config.getFloat("Skeleton Max Health", "all", (float)this.skeletonMaxHealth, 1, 1000, "");
        this.skeletonDamage = config.getFloat("Skeleton Damage", "all", (float)this.skeletonDamage, 1, 1000, "");
        this.skeletonSpawnWeight = config.getInt("Skeleton Spawn Weight", "all", this.skeletonSpawnWeight, 1, 100, "");
        this.skeletonSpawnMaxGroupSize = config.getInt("Skeleton Spawn Group Size", "all", this.skeletonSpawnMaxGroupSize, 1, 5, "");

        this.axebeakMaxHealth = config.getFloat("Axebeak Max Health", "all", (float)this.axebeakMaxHealth, 1, 1000, "");
        this.axebeakDamage = config.getFloat("Axebeak Damage", "all", (float)this.axebeakDamage, 1, 1000, "");
        this.axebeakSpawnWeight = config.getInt("Axebeak Spawn Weight", "all", this.axebeakSpawnWeight, 1, 100, "");
        this.axebeakSpawnMaxGroupSize = config.getInt("Axebeak Spawn Group Size", "all", this.axebeakSpawnMaxGroupSize, 1, 5, "");

        this.vampireBatMaxHealth = config.getFloat("Vampire Bat Max Health", "all", (float)this.vampireBatMaxHealth, 1, 1000, "");
        this.vampireBatDamage = config.getFloat("Vampire Bat Damage", "all", (float)this.vampireBatDamage, 1, 1000, "");
        this.vampireBatSpawnWeight = config.getInt("Vampire Bat Spawn Weight", "all", this.vampireBatSpawnWeight, 1, 100, "");

        this.spiderMaxHealth = config.getFloat("Patriarch Spider Max Health", "all", (float)this.spiderMaxHealth, 1, 1000, "");
        this.spiderDamage = config.getFloat("Patriarch Spider Damage", "all", (float)this.spiderDamage, 1, 1000, "");
        this.spiderSpawnWeight = config.getInt("Patriarch Spider Spawn Weight", "all", this.spiderSpawnWeight, 1, 100, "");
        
        this.babySpiderMaxHealth = config.getFloat("Brood Spider Max Health", "all", (float)this.babySpiderMaxHealth, 1, 1000, "");
        this.babySpiderDamage = config.getFloat("Brood Spider Damage", "all", (float)this.babySpiderDamage, 1, 1000, "");
        
        this.fuguMaxHealth = config.getFloat("Glob Max Health", "all", (float)this.fuguMaxHealth, 1, 1000, "");
        this.fuguDamage = config.getFloat("Glob Damage", "all", (float)this.fuguDamage, 1, 1000, "");
        this.fuguSpawnWeight = config.getInt("Glob Spawn Weight", "all", this.fuguSpawnWeight, 1, 100, "");
        
        this.booglinMaxHealth = config.getFloat("Booglin Max Health", "all", (float)this.booglinMaxHealth, 1, 1000, "");
        this.booglinDamage = config.getFloat("Booglin Damage", "all", (float)this.booglinDamage, 1, 1000, "");
        this.booglinSpawnWeight = config.getInt("Booglin Spawn Weight", "all", this.booglinSpawnWeight, 1, 100, "");


        this.booglinGrief = config.getBoolean("Booglins can grief", "all", true, "Whether Booglins can mine walls");
    }
}
