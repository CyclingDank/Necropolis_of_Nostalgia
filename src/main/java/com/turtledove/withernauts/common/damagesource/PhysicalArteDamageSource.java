package com.turtledove.withernauts.common.damagesource;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

import java.util.Random;

public class PhysicalArteDamageSource extends DamageSource {

    public PhysicalArteDamageSource() {
        super("physical_artes");

        this.setDamageBypassesArmor();
    }

    @Override
    public ITextComponent getDeathMessage(EntityLivingBase entityLivingBaseIn) {
        String translationKey = "death.attack.physical_artes.player_" + new Random().nextInt(2);

        return new TextComponentString(entityLivingBaseIn.getDisplayName().getFormattedText() + " ")
                .appendSibling(new TextComponentTranslation(translationKey, entityLivingBaseIn.getDisplayName()));
    }
}
