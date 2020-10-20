package com.turtledove.withernauts.server.item;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.server.core.NecropolisPlayerData;
import com.turtledove.withernauts.server.core.PlayerData;
import com.turtledove.withernauts.server.packets.Player.SyncServerClientStamina;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class ItemNecropolisWeapon extends ItemSword
{
    private float pAtk;
    private float sAtk;
    private String []skillName;
    private String itemName;
    public ItemNecropolisWeapon(Item.ToolMaterial material, String registryName, String unlocalName, float pAtk, float sAtk, String [] skillName)
    {
        super(material);
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.COMBAT);
        this.setRegistryName(registryName);
        this.setUnlocalizedName(unlocalName);
        this.itemName = registryName;
        this.pAtk = pAtk;
        this.sAtk = sAtk;
        this.skillName = skillName;
    }
    public float getAttack(boolean isSpecial)
    {
        if (isSpecial)
            return this.sAtk;
        return this.pAtk;
    }
    public String [] getSkillNames()
    {
        return this.skillName;
    }

    public String getItemName()
    {
        return this.itemName;
    }

    public float doAttack(EntityPlayer playerIn, Entity entity, float amount)
    {
        float multiplier = 1.0f;
        PlayerData playerData = (PlayerData) NecropolisPlayerData.get(playerIn);
        if (this.skillName.length == 0)
            return multiplier;
        if (stringContains("Critical"))
        {
            if (Math.random() < 0.1)
                multiplier *= 2.0f;
        }
        if (stringContains("Fire Aspect"))
        {
            if (Math.random() < 0.3)
            {
                entity.setFire(40);
            }
        }
        if (stringContains("Taunt"))
        {
            if (entity instanceof EntityPlayer)
            {
                if (Math.random() < 0.3)
                {
                    PlayerData playerTargetData = (PlayerData) NecropolisPlayerData.get((EntityPlayer) entity);
                    playerTargetData.consumeMana(60);
                }
            }
        }
        if (stringContains("Taunt 2"))
        {
            if (entity instanceof EntityPlayer)
            {
                if (Math.random() < 0.6)
                {
                    PlayerData playerTargetData = (PlayerData) NecropolisPlayerData.get((EntityPlayer) entity);
                    playerTargetData.consumeMana(150);
                }
            }
        }
        if (stringContains("Adrenaline"))
        {
            Withernauts.packetHandler.sendTo(new SyncServerClientStamina(-10),(EntityPlayerMP)playerIn);
        }
        if (stringContains("Adrenaline 2"))
        {
            Withernauts.packetHandler.sendTo(new SyncServerClientStamina(-20),(EntityPlayerMP)playerIn);
        }
        if (stringContains("Light Magic"))
        {
            playerData.consumeMana(-10.0f);
        }
        if (stringContains("Heavy Magic"))
        {
            playerData.consumeMana(10.0f);
        }
        if (stringContains("Absorption"))
        {
            playerIn.heal(1.0f);
        }
        return multiplier;
    }

    public void doDeath(EntityPlayer playerIn)
    {
        PlayerData playerData = (PlayerData) NecropolisPlayerData.get(playerIn);
        if (this.skillName.length == 0)
            return;
        if (stringContains("HP Recover"))
        {
            playerIn.heal(10.0F);
        }
        if (stringContains("HP Recover 2"))
        {
            playerIn.heal(20.0F);
        }
        if (stringContains("TP Recover"))
        {
            playerData.restoreMana(50.0f);
        }
        if (stringContains("TP Recover 2"))
        {
            playerData.restoreMana(100.0f);
        }
    }

    public boolean stringContains(String val)
    {
        for (String word: this.skillName)
        {
            if (word.equals(val))
                return true;
        }
        return false;
    }

    public void doPassive(EntityPlayer playerIn)
    {
        if (this.skillName.length == 0)
            return;
        if (stringContains("Recover"))
        {
            if (Math.random() < 0.1)
            {
                playerIn.heal(1.0f);
            }
        }
        if (stringContains("Recover 2"))
        {
            if (Math.random() < 0.2)
            {
                playerIn.heal(3.0f);
            }
        }
        if (stringContains("Status Guard"))
        {
            playerIn.clearActivePotions();
        }
    }


}
