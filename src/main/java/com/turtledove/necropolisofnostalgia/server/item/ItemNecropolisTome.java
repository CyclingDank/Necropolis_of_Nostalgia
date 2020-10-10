package com.turtledove.necropolisofnostalgia.server.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class ItemNecropolisTome extends ItemNecropolisWeapon
{
    public ItemNecropolisTome(float damage, String registryName, String unlocalName, String[] skills)
    {
        super(ToolMaterial.WOOD, registryName, unlocalName, 1.0f, damage, skills);
    }
}
