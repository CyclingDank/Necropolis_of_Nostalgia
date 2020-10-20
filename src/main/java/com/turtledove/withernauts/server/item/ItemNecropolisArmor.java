package com.turtledove.withernauts.server.item;

import com.turtledove.withernauts.client.model.entity.player.avalon_mail.ModelAvalonMail;
import com.turtledove.withernauts.client.model.entity.player.bastille_plate.ModelBastillePlate;
import com.turtledove.withernauts.client.model.entity.player.lamellar.ModelLamellarArmor;
import com.turtledove.withernauts.client.model.entity.player.sacred_armor.ModelSacredArmor;
import com.turtledove.withernauts.client.model.entity.player.skeleton_helmet.ModelSkeletonHelmet;
import com.turtledove.withernauts.client.model.entity.player.sorcerers_hat.ModelSorcerersHat;
import com.turtledove.withernauts.client.model.entity.player.sorcerers_robe.ModelSorcerersRobe;
import com.turtledove.withernauts.client.model.entity.player.sorcerers_sallet.ModelSorcerersSallet;
import com.turtledove.withernauts.client.model.entity.player.splint_mail.ModelSplintMail;
import com.turtledove.withernauts.client.model.entity.player.thiefs_hood.ModelThiefsHood;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemNecropolisArmor extends ItemArmor
{
    private int pDef;
    private int sDef;
    private int weight;
    private String itemName;
    private String tColor;
    private int pAtkBoost;
    private int sAtkBoost;
    private double chance;

    public ItemNecropolisArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlotIn, String registryName, String unlocalizedName, String color, int pDef, int sDef, int weight)
    {
        super(material, renderIndex, equipmentSlotIn);
        this.setRegistryName(registryName);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.COMBAT);
        this.itemName = unlocalizedName;
        this.tColor = color;
        this.pDef = pDef;
        this.sDef = sDef;
        this.weight = weight;

        this.pAtkBoost = 0;
        this.sAtkBoost = 0;
        this.chance = 0.0;
    }


    public ItemNecropolisArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlotIn, String registryName, String unlocalizedName, String color, int pDef, int sDef, int weight, int pAtkB, int sAtkB, double sC)
    {
        super(material, renderIndex, equipmentSlotIn);
        this.setRegistryName(registryName);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.COMBAT);
        this.itemName = unlocalizedName;
        this.tColor = color;
        this.pDef = pDef;
        this.sDef = sDef;
        this.weight = weight;

        this.pAtkBoost = pAtkB;
        this.sAtkBoost = sAtkB;
        this.chance = sC;
    }

    public ItemNecropolisArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlotIn, String registryName, String unlocalizedName, int pDef, int sDef, int weight)
    {
        super(material, renderIndex, equipmentSlotIn);
        this.setRegistryName(registryName);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.COMBAT);
        this.itemName = unlocalizedName;
        this.tColor = "NULL";
        this.pDef = pDef;
        this.sDef = sDef;
        this.weight = weight;

        this.pAtkBoost = 0;
        this.sAtkBoost = 0;
        this.chance = 0.0;
    }

    public ItemNecropolisArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlotIn, String registryName, String unlocalizedName, int pDef, int sDef, int weight, int pAtkB, int sAtkB, double sC)
    {
        super(material, renderIndex, equipmentSlotIn);
        this.setRegistryName(registryName);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.COMBAT);
        this.itemName = unlocalizedName;
        this.tColor = "NULL";
        this.pDef = pDef;
        this.sDef = sDef;
        this.weight = weight;

        this.pAtkBoost = pAtkB;
        this.sAtkBoost = sAtkB;
        this.chance = sC;
    }
    @Override
    public boolean getIsRepairable(ItemStack stack, ItemStack material) {
        return false;
    }

    public int getAtkBoost(boolean isSpecial)
    {
        if (isSpecial)
            return this.sAtkBoost;
        return this.pAtkBoost;
    }

    public String getItemName()
    {
        return this.itemName;
    }

    public double getItemChance()
    {
        return this.chance;
    }


    @Override
    public boolean isDamageable() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default)
    {
        /*if (this.getArmorMaterial().equals(ArmorMaterial.LEATHER))
        {

        }*/
        if (this.itemName.contains("sorcerers_sallet"))
        {
            ModelSorcerersSallet modelSorcerersSallet = new ModelSorcerersSallet();
            return (ModelBiped)modelSorcerersSallet;
        }
        else if (this.itemName.contains("sorcerers_hat"))
        {
            ModelSorcerersHat modelSorcerersHat = new ModelSorcerersHat();
            return (ModelBiped)modelSorcerersHat;
        }
        else if (this.itemName.contains("sorcerers_robe"))
        {
            ModelSorcerersRobe modelSorcerersRobe = new ModelSorcerersRobe();
            return (ModelBiped)modelSorcerersRobe;
        }
        else if (this.itemName.contains("thiefs_hood"))
        {
            ModelThiefsHood modelThiefsHood = new ModelThiefsHood();
            return (ModelBiped)modelThiefsHood;
        }
        else if (this.itemName.contains("skeleton_helmet"))
        {
            ModelSkeletonHelmet modelSkeletonHelmet = new ModelSkeletonHelmet();
            return (ModelBiped)modelSkeletonHelmet;
        }
        else if (this.itemName.contains("sacred_armor"))
        {
            ModelSacredArmor modelSacredArmor = new ModelSacredArmor();
            if (!itemStack.isEmpty()) {
                if (this.renderIndex == 0) {
                    modelSacredArmor.sa_leg_pivot_r.showModel = false;
                    modelSacredArmor.sa_leg_pivot_l.showModel = false;
                    modelSacredArmor.sa_boot_l.showModel = false;
                    modelSacredArmor.sa_boot_r.showModel = false;
                    modelSacredArmor.sa_shoulder_l_1.showModel = false;
                    modelSacredArmor.sa_shoulder_r_1.showModel = false;
                    modelSacredArmor.sa_torso.showModel = false;
                } else if (this.renderIndex == 1) {
                    modelSacredArmor.sa_leg_pivot_r.showModel = false;
                    modelSacredArmor.sa_leg_pivot_l.showModel = false;
                    modelSacredArmor.sa_boot_l.showModel = false;
                    modelSacredArmor.sa_boot_r.showModel = false;
                    modelSacredArmor.sa_helm_1.showModel = false;
                } else if (this.renderIndex == 2) {
                    modelSacredArmor.sa_boot_l.showModel = false;
                    modelSacredArmor.sa_boot_r.showModel = false;
                    modelSacredArmor.sa_shoulder_l_1.showModel = false;
                    modelSacredArmor.sa_shoulder_r_1.showModel = false;
                    modelSacredArmor.sa_torso.showModel = false;
                    modelSacredArmor.sa_helm_1.showModel = false;
                } else if (this.renderIndex == 3) {
                    modelSacredArmor.sa_leg_pivot_r.showModel = false;
                    modelSacredArmor.sa_leg_pivot_l.showModel = false;
                    modelSacredArmor.sa_shoulder_l_1.showModel = false;
                    modelSacredArmor.sa_shoulder_r_1.showModel = false;
                    modelSacredArmor.sa_torso.showModel = false;
                    modelSacredArmor.sa_helm_1.showModel = false;
                }
                return (ModelBiped) modelSacredArmor;
            }
        }
        else if (this.itemName.contains("splint_mail"))
        {
            ModelSplintMail modelSplintMail = new ModelSplintMail();
            if (!itemStack.isEmpty()) {
                if (this.renderIndex == 0) {
                    modelSplintMail.sm_leg_r_1.showModel = false;
                    modelSplintMail.sm_leg_l_1.showModel = false;
                    modelSplintMail.sm_boot_l.showModel = false;
                    modelSplintMail.sm_boot_r.showModel = false;
                    modelSplintMail.sm_shoulder_l_1.showModel = false;
                    modelSplintMail.sm_shoulder_r_1.showModel = false;
                    modelSplintMail.sm_torso.showModel = false;
                } else if (this.renderIndex == 1) {
                    modelSplintMail.sm_leg_r_1.showModel = false;
                    modelSplintMail.sm_leg_l_1.showModel = false;
                    modelSplintMail.sm_boot_l.showModel = false;
                    modelSplintMail.sm_boot_r.showModel = false;
                    modelSplintMail.sm_helm_1.showModel = false;
                } else if (this.renderIndex == 2) {
                    modelSplintMail.sm_boot_l.showModel = false;
                    modelSplintMail.sm_boot_r.showModel = false;
                    modelSplintMail.sm_shoulder_l_1.showModel = false;
                    modelSplintMail.sm_shoulder_r_1.showModel = false;
                    modelSplintMail.sm_torso.showModel = false;
                    modelSplintMail.sm_helm_1.showModel = false;
                } else if (this.renderIndex == 3) {
                    modelSplintMail.sm_leg_r_1.showModel = false;
                    modelSplintMail.sm_leg_l_1.showModel = false;
                    modelSplintMail.sm_shoulder_l_1.showModel = false;
                    modelSplintMail.sm_shoulder_r_1.showModel = false;
                    modelSplintMail.sm_torso.showModel = false;
                    modelSplintMail.sm_helm_1.showModel = false;
                }
                return (ModelBiped) modelSplintMail;
            }
        }
        else if (this.itemName.contains("bastille_plate"))
        {
            ModelBastillePlate modelBastillePlate = new ModelBastillePlate();
            if (!itemStack.isEmpty()) {
                if (this.renderIndex == 0) {
                    modelBastillePlate.bp_leg_r_1.showModel = false;
                    modelBastillePlate.bp_leg_l_1.showModel = false;
                    modelBastillePlate.bp_boot_l.showModel = false;
                    modelBastillePlate.bp_boot_r.showModel = false;
                    modelBastillePlate.bp_shoulder_l_1.showModel = false;
                    modelBastillePlate.bp_shoulder_r_1.showModel = false;
                    modelBastillePlate.bp_torso.showModel = false;
                } else if (this.renderIndex == 1) {
                    modelBastillePlate.bp_leg_r_1.showModel = false;
                    modelBastillePlate.bp_leg_l_1.showModel = false;
                    modelBastillePlate.bp_boot_l.showModel = false;
                    modelBastillePlate.bp_boot_r.showModel = false;
                    modelBastillePlate.bp_helm_1.showModel = false;
                } else if (this.renderIndex == 2) {
                    modelBastillePlate.bp_boot_l.showModel = false;
                    modelBastillePlate.bp_boot_r.showModel = false;
                    modelBastillePlate.bp_shoulder_l_1.showModel = false;
                    modelBastillePlate.bp_shoulder_r_1.showModel = false;
                    modelBastillePlate.bp_torso.showModel = false;
                    modelBastillePlate.bp_helm_1.showModel = false;
                } else if (this.renderIndex == 3) {
                    modelBastillePlate.bp_leg_r_1.showModel = false;
                    modelBastillePlate.bp_leg_l_1.showModel = false;
                    modelBastillePlate.bp_shoulder_l_1.showModel = false;
                    modelBastillePlate.bp_shoulder_r_1.showModel = false;
                    modelBastillePlate.bp_torso.showModel = false;
                    modelBastillePlate.bp_helm_1.showModel = false;
                }
                return (ModelBiped) modelBastillePlate;
            }
        }
        else if (this.itemName.contains("avalon_mail"))
        {
            ModelAvalonMail modelAvalonMail = new ModelAvalonMail();
            if (!itemStack.isEmpty()) {
                if (this.renderIndex == 0) {
                    modelAvalonMail.am_leg_pivot_r.showModel = false;
                    modelAvalonMail.am_leg_pivot_l.showModel = false;
                    modelAvalonMail.am_boot_l.showModel = false;
                    modelAvalonMail.am_boot_r.showModel = false;
                    modelAvalonMail.am_shoulder_l_1.showModel = false;
                    modelAvalonMail.am_shoulder_r_1.showModel = false;
                    modelAvalonMail.am_torso.showModel = false;
                } else if (this.renderIndex == 1) {
                    modelAvalonMail.am_leg_pivot_r.showModel = false;
                    modelAvalonMail.am_leg_pivot_l.showModel = false;
                    modelAvalonMail.am_boot_l.showModel = false;
                    modelAvalonMail.am_boot_r.showModel = false;
                    modelAvalonMail.am_helm_1.showModel = false;
                } else if (this.renderIndex == 2) {
                    modelAvalonMail.am_boot_l.showModel = false;
                    modelAvalonMail.am_boot_r.showModel = false;
                    modelAvalonMail.am_shoulder_l_1.showModel = false;
                    modelAvalonMail.am_shoulder_r_1.showModel = false;
                    modelAvalonMail.am_torso.showModel = false;
                    modelAvalonMail.am_helm_1.showModel = false;
                } else if (this.renderIndex == 3) {
                    modelAvalonMail.am_leg_pivot_r.showModel = false;
                    modelAvalonMail.am_leg_pivot_l.showModel = false;
                    modelAvalonMail.am_shoulder_l_1.showModel = false;
                    modelAvalonMail.am_shoulder_r_1.showModel = false;
                    modelAvalonMail.am_torso.showModel = false;
                    modelAvalonMail.am_helm_1.showModel = false;
                }
                return (ModelBiped) modelAvalonMail;
            }
        }
        else {
            ModelLamellarArmor modelLamellarArmor = new ModelLamellarArmor(false);
            if (!itemStack.isEmpty()) {
                if (this.renderIndex == 0) {
                    modelLamellarArmor.ll_leg_r.showModel = false;
                    modelLamellarArmor.ll_leg_l.showModel = false;
                    modelLamellarArmor.ll_foot_l.showModel = false;
                    modelLamellarArmor.ll_foot_r.showModel = false;
                    modelLamellarArmor.ll_shoulder_l.showModel = false;
                    modelLamellarArmor.ll_shoulder_r.showModel = false;
                    modelLamellarArmor.ll_torso.showModel = false;
                } else if (this.renderIndex == 1) {
                    modelLamellarArmor.ll_leg_r.showModel = false;
                    modelLamellarArmor.ll_leg_l.showModel = false;
                    modelLamellarArmor.ll_foot_l.showModel = false;
                    modelLamellarArmor.ll_foot_r.showModel = false;
                    modelLamellarArmor.ll_helm.showModel = false;
                } else if (this.renderIndex == 2) {
                    modelLamellarArmor.ll_foot_l.showModel = false;
                    modelLamellarArmor.ll_foot_r.showModel = false;
                    modelLamellarArmor.ll_shoulder_l.showModel = false;
                    modelLamellarArmor.ll_shoulder_r.showModel = false;
                    modelLamellarArmor.ll_torso.showModel = false;
                    modelLamellarArmor.ll_helm.showModel = false;
                } else if (this.renderIndex == 3) {
                    modelLamellarArmor.ll_leg_r.showModel = false;
                    modelLamellarArmor.ll_leg_l.showModel = false;
                    modelLamellarArmor.ll_shoulder_l.showModel = false;
                    modelLamellarArmor.ll_shoulder_r.showModel = false;
                    modelLamellarArmor.ll_torso.showModel = false;
                    modelLamellarArmor.ll_helm.showModel = false;
                }
                return (ModelBiped) modelLamellarArmor;
            }
        }
        return null;
    }

    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
        String frontS = "turtdance:textures/models/armor/";
        String endS = ".png";

        if (this.itemName.contains("sorcerers_sallet"))
        {
            frontS += "sorcerers_sallet/sorcerers_sallet_armor";
        }
        else if (this.itemName.contains("sorcerers_hat"))
        {
            frontS += "sorcerers_hat/sorcerers_hat_armor";
        }
        else if (this.itemName.contains("sorcerers_robe"))
        {
            frontS += "sorcerers_robe/sorcerers_robe_armor";
        }
        else if (this.itemName.contains("thiefs_hood"))
        {
            frontS += "thiefs_hood/thiefs_hood_armor";
        }
        else if (this.itemName.contains("skeleton_helmet"))
        {
            frontS += "skeleton_helmet/skeleton_helmet_armor";
        }
        else if (this.itemName.contains("sacred_armor"))
        {
            frontS += "sacred_armor/sacred_armor_armor";
            if (renderIndex == 2 || renderIndex == 3)
                endS = "_legs" + ".png";
        }
        else if (this.itemName.contains("splint_mail"))
        {
            frontS += "splint_mail/splint_mail_armor";
        }
        else if (this.itemName.contains("bastille_plate"))
        {
            frontS += "bastille_plate/bastille_plate_armor";
            if (renderIndex == 2 || renderIndex == 3)
                endS = "_legs" + ".png";
        }
        else if (this.itemName.contains("avalon_mail"))
        {
            frontS += "avalon_mail/avalon_mail_armor";
        }
        else
        {
            frontS += "lamellar/lamellar_armor_";
            endS = this.tColor + ".png";
            if (renderIndex == 2)
                endS = "legs_" + this.tColor + ".png";
        }
        return frontS  + endS;
    }

    public int getStrength(boolean isSpecial)
    {
        if (isSpecial)
            return this.sDef;
        return this.pDef;
    }

    public int getWeight()
    {
        return this.weight;
    }

    @Override
    public int getDamage(ItemStack stack) {
        return 0;
    }
    @Override
    public void setDamage(ItemStack stack, int damage) {}

}
