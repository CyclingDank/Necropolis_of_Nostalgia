package com.turtledove.necropolisofnostalgia.server.events;

import com.google.common.base.MoreObjects;
import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.client.gui.INecropolisItemHandler;
import com.turtledove.necropolisofnostalgia.common.food.FoodEffects;
import com.turtledove.necropolisofnostalgia.server.blocks.BlockHandler;
import com.turtledove.necropolisofnostalgia.server.core.IPlayerData;
import com.turtledove.necropolisofnostalgia.server.core.NecropolisPlayerData;
import com.turtledove.necropolisofnostalgia.server.core.PlayerData;

import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityBeast;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityDemonFang;
import com.turtledove.necropolisofnostalgia.server.entity.Artes.EntityDestructionField;
import com.turtledove.necropolisofnostalgia.server.entity.EntityCasted;
import com.turtledove.necropolisofnostalgia.server.entity.EntityNecropolisFireCharge;
import com.turtledove.necropolisofnostalgia.server.entity.NecropolisEntity;
import com.turtledove.necropolisofnostalgia.server.entity.enemies.EntityNecropolisSkeleton;
import com.turtledove.necropolisofnostalgia.server.item.*;
import com.turtledove.necropolisofnostalgia.server.packets.Player.SyncServerClientStamina;
import com.turtledove.necropolisofnostalgia.server.packets.Sounds.SoundPacket;
import com.turtledove.necropolisofnostalgia.server.sounds.NecropolisSounds;
import com.turtledove.necropolisofnostalgia.server.world.generation.WorldGenCatTail;
import com.turtledove.necropolisofnostalgia.server.world.generation.WorldGenKelp;
import com.turtledove.necropolisofnostalgia.server.world.generation.WorldGenRepitifleur;
import net.ilexiconn.llibrary.server.config.ConfigHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderSpecificHandEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.Sys;

import java.util.Random;

@Mod.EventBusSubscriber
public class NecropolisCapabilitiesHandler
{
    public static final ResourceLocation PLAYER_DATA = new ResourceLocation(Necropolis_of_Nostalgia.MODID, "player_data");
    public static final ResourceLocation GUI_DATA = new ResourceLocation(Necropolis_of_Nostalgia.MODID, "gui_data");
    static int food_cooldown = 0;
    Random rand = new Random();

    @SubscribeEvent
    public static void onEntityJoinWorld(EntityJoinWorldEvent event)
    {
        if (event.getEntity() instanceof EntityPlayer)
        {
            PlayerData data = (PlayerData) NecropolisPlayerData.get((EntityPlayer) event.getEntity());
            if (data != null)
            {
                data.onJoinWorld();
                //check if world should spawn blastia
                if (data.get_oldface() == false && !event.getWorld().isRemote)
                {
                    data.set_oldface(true);
                    if (FMLCommonHandler.instance().getMinecraftServerInstance().isSinglePlayer())
                    {
                        BlockPos structurePos = event.getEntity().getPosition().north();

                        event.getWorld().setBlockState(structurePos, Blocks.COBBLESTONE.getDefaultState());
                        event.getWorld().setBlockState(structurePos.up(), Blocks.MOSSY_COBBLESTONE.getDefaultState());
                        event.getWorld().setBlockState(structurePos.up().up(), BlockHandler.BARRIER_BLASTIA.getDefaultState());

                    }
                }
            }
        }
        else if (event.getEntity() instanceof EntitySkeleton || event.getEntity() instanceof EntityZombie || event.getEntity() instanceof EntitySlime
                || event.getEntity() instanceof EntityWitch || event.getEntity() instanceof EntityEnderman || event.getEntity() instanceof  EntityWitch
                || event.getEntity() instanceof  EntityVindicator || event.getEntity() instanceof  EntitySpider || event.getEntity() instanceof EntityCreeper)
        {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onKnockBack(LivingKnockBackEvent event)
    {
        event.setCanceled(true);
    }

    //this should only fire on valid sword swipes
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onAttackMob(AttackEntityEvent event)
    {
        EntityPlayer source = event.getEntityPlayer();
        if (source.getHeldItemMainhand().getItem() instanceof ItemSword)
        {
            event.setCanceled(true);
            //PlayerData data = (PlayerData) NecropolisPlayerData.get(Minecraft.getMinecraft().player);
            //data.setActivatepArte(true);
            //Necropolis_of_Nostalgia.packetHandler.sendToServer(new MessagePacket(data.getCurrentArteIndex(),0,0.0,0.0,0.0));
        }
        else
        {
            float dist = source.getDistance(event.getTarget());
            if (dist > 1.5)
                event.setCanceled(true);
            if (source.swingProgress != 0.0F)
                event.setCanceled(true);
        }
    }
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onAttackBlock(PlayerInteractEvent.LeftClickBlock event)
    {
        EntityPlayer source = event.getEntityPlayer();

        if (source.getHeldItemMainhand().getItem() instanceof ItemSword)
        {
            //PlayerData data = (PlayerData) NecropolisPlayerData.get(Minecraft.getMinecraft().player);
            //Necropolis_of_Nostalgia.packetHandler.sendToServer(new MessagePacket(data.getCurrentArteIndex(),0,0.0,0.0,0.0));
            event.setCanceled(true);
            return;
        }
    }
    @SubscribeEvent
    public void onPlayerDrop(PlayerDropsEvent event)
    {
        event.setCanceled(true);
    }
    /*Handles cloning of inventory contents on player death or world change*/
    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event) {
        EntityPlayer player = event.getEntityPlayer();
        //copies custom inventory contents
        INecropolisItemHandler itemData = player.getCapability(NecropolisCapabilities.ITEM_HANDLER_CAPABILITY, null);
        INecropolisItemHandler oldItemData = event.getOriginal().getCapability(NecropolisCapabilities.ITEM_HANDLER_CAPABILITY, null);
        itemData.copyContents(oldItemData.getStack());

        /*//copies base inventory contents
        for (int i = 0; i < event.getOriginal().inventory.mainInventory.size(); i++)
        {
            player.inventory.mainInventory.set(i, event.getOriginal().inventory.mainInventory.get(i));
        }*/
    }
    @SubscribeEvent
    public void onBiomeDecorate(DecorateBiomeEvent.Pre event)
    {
        World world = event.getWorld();
        Biome biome = world.getBiomeForCoordsBody(event.getPos());
        Random rand = event.getRand();

        int x = rand.nextInt(16) + 8;
        int y = rand.nextInt(16) + 8;

        WorldGenCatTail catGEn = new WorldGenCatTail();
        catGEn.generate(world, rand, world.getHeight(event.getPos().add(x, 0, y)));


        WorldGenKelp kgen = new WorldGenKelp();
        kgen.generate(world, rand, world.getHeight(event.getPos().add(x, 0, y)));

        if (rand.nextDouble() > 0.1) return;

        WorldGenRepitifleur gen = new WorldGenRepitifleur();
        gen.generate(world, rand, world.getHeight(event.getPos().add(x, 0, y)));

    }
    /*@SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onAttackAir(PlayerInteractEvent.LeftClickEmpty event)
    {
        EntityPlayer source = event.getEntityPlayer();
        if (source.getHeldItemMainhand().getItem() instanceof ItemSword)
        {
            event.setCanceled(true);

            //ItemSword swordItem = (ItemSword)source.getHeldItemMainhand().getItem();
            //swordItem.get
            //PlayerData data = (PlayerData) NecropolisPlayerData.get(Minecraft.getMinecraft().player);
            //data.setActivatepArte(true);
            //Necropolis_of_Nostalgia.packetHandler.sendToServer(new MessagePacket(data.getCurrentArteIndex(),0,0.0,0.0,0.0));

        }
    }*/
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onHandRender(RenderSpecificHandEvent event)
    {
        AbstractClientPlayer abstractclientplayer = Minecraft.getMinecraft().player;
        PlayerData data = (PlayerData) NecropolisPlayerData.get(Minecraft.getMinecraft().player);

        if (event.getHand() == EnumHand.OFF_HAND)
            return;

        if (event.getItemStack().getItem() instanceof ItemSword)
        {
            if (abstractclientplayer.isSneaking()) {
                EntityPlayerSP player = (EntityPlayerSP) abstractclientplayer;
                GlStateManager.pushMatrix();
                boolean rightHanded = (event.getHand() == EnumHand.MAIN_HAND ? player.getPrimaryHand() : player.getPrimaryHand().opposite()) == EnumHandSide.RIGHT;
                float side = rightHanded ? 1.0F : -1.0F;
                float equippedProg = event.getEquipProgress();
                GlStateManager.translate(side * 0.56F, -0.52F + equippedProg * -0.6F, -0.72F);
                GlStateManager.translate(side * -0.14142136F, 0.08F, 0.14142136F);
                GlStateManager.rotate(-102.25F, 1.0F, 0.0F, 0.0F);
                GlStateManager.rotate(side * 13.365F, 0.0F, 1.0F, 0.0F);
                GlStateManager.rotate(side * 78.05F, 0.0F, 0.0F, 1.0F);
                Minecraft.getMinecraft().getItemRenderer().renderItemSide(player, event.getItemStack(), rightHanded ? ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND : ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND, !rightHanded);
                GlStateManager.popMatrix();
                event.setCanceled(true);
            }
        }

        if (data.getInBufferZone())
            return;
        if (event.getItemStack().getItem() instanceof ItemSpade)
        {
            event.setCanceled(true);
            float f = abstractclientplayer.getSwingProgress(event.getPartialTicks());
            EnumHand enumhand = (EnumHand) MoreObjects.firstNonNull(abstractclientplayer.swingingHand, EnumHand.MAIN_HAND);
            float f1 = abstractclientplayer.prevRotationPitch + (abstractclientplayer.rotationPitch - abstractclientplayer.prevRotationPitch) * event.getPartialTicks();
            float f2 = abstractclientplayer.prevRotationYaw + (abstractclientplayer.rotationYaw - abstractclientplayer.prevRotationYaw) * event.getPartialTicks();
            boolean flag = true;
            boolean flag1 = true;

            this.rotateArroundXAndY(f1, f2);
            this.setLightmap();
            this.rotateArm(event.getPartialTicks());
            GlStateManager.enableRescaleNormal();
            if (flag)
            {
                float swing_ratio = abstractclientplayer.getSwingProgress(event.getPartialTicks());
                float equip_ratio = 1.0F;
                this.renderShovelInFirstPerson(abstractclientplayer, event.getPartialTicks(), f1, EnumHand.MAIN_HAND, swing_ratio, event.getItemStack(), equip_ratio);
            }
            GlStateManager.disableRescaleNormal();
            RenderHelper.disableStandardItemLighting();
        }
        else if (event.getItemStack().getItem() instanceof ItemSword)
        {
            event.setCanceled(true);
            data.artes.r_arte[data.getCurrentpArte()].renderArte(abstractclientplayer,event.getItemStack(), event.getPartialTicks());
        }
    }

    public void renderShovelInFirstPerson(AbstractClientPlayer player, float partialTicks, float p_187457_3_, EnumHand hand, float swing_ratio, ItemStack stack, float equip_ratio)
    {
        EnumHandSide enumhandside = player.getPrimaryHand();
        GlStateManager.pushMatrix();

        int j = 1;
        float f = -0.4F * MathHelper.sin(MathHelper.sqrt(swing_ratio) * (float) Math.PI);
        float f1 = 0.2F * MathHelper.sin(MathHelper.sqrt(swing_ratio) * ((float) Math.PI * 2F));
        float f2 = -0.2F * MathHelper.sin(swing_ratio * (float) Math.PI);
        int i = 1;
        GlStateManager.translate((float) i * f, 0.5F, f2);
        this.transformShovelSideFirstPerson(enumhandside, equip_ratio);
        this.transformShovelFirstPerson(enumhandside, swing_ratio);

        this.renderItemSide(player, stack, ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND);
        GlStateManager.popMatrix();
    }

    public void renderSwordBlockingInFirstPerson(AbstractClientPlayer player, EnumHand hand, ItemStack stack, float equip_ratio)
    {
        EnumHandSide enumhandside = player.getPrimaryHand();
        GlStateManager.pushMatrix();

        GlStateManager.translate(0.56F, -0.52F + equip_ratio * -0.6F, -0.72F);
        GlStateManager.translate(-0.14142136F, 0.08F, 0.14142136F);
        GlStateManager.rotate(-102.25F, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(13.365F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(78.05F, 0.0F, 0.0F, 1.0F);

        if (!stack.isEmpty())
        {
            Item item = stack.getItem();
            Block block = Block.getBlockFromItem(item);
            GlStateManager.pushMatrix();
            boolean flag = Minecraft.getMinecraft().getRenderItem().shouldRenderItemIn3D(stack) && block.getBlockLayer() == BlockRenderLayer.TRANSLUCENT;

            if (flag)
            {
                GlStateManager.depthMask(false);
            }

            Minecraft.getMinecraft().getRenderItem().renderItem(stack, player, ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND, false);

            if (flag)
            {
                GlStateManager.depthMask(true);
            }
            GlStateManager.popMatrix();
        }

        GlStateManager.popMatrix();
    }

    @SubscribeEvent
    public void onEntityHurt(LivingHurtEvent event)
    {
        if (!event.isCanceled())
        {
            EntityLivingBase entity = event.getEntityLiving();
            if (entity.getEntityWorld().isRemote)
            {
                return;
            }
            DamageSource source = event.getSource();
            Entity trueSource = source.getTrueSource();
            if (event.getSource().getDamageType() == "arte" || event.getSource().getDamageType() == "physical_artes")
            {
                return;
            }
            if (event.getSource().getDamageType() == "melee")
            {
                entity.playSound(NecropolisSounds.DAMAGE,0.25f,1.0f);
                entity.hurtResistantTime = 0;
            }
        }
    }

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.HarvestDropsEvent event)
    {
        if (event.getState().getBlock().equals(Blocks.TALLGRASS) || event.getState().getBlock().equals(Blocks.DOUBLE_PLANT))
        {
            for (int i = 0; i < event.getDrops().size(); i++)
            {
                if (event.getDrops().get(i).getItem().equals(Items.WHEAT_SEEDS))
                {
                    event.getDrops().remove(i);
                }
            }
        }
    }

    /*@SubscribeEvent
    public void onPlayerFalls(LivingFallEvent event)
    {
        Entity entity = event.getEntity();
        if (entity.getEntityWorld().isRemote)
        {
            return;
        }
        if(!(entity instanceof EntityPlayerMP) || event.getDistance() < 3)
        {
            return;
        }
        PlayerData data = (PlayerData) NecropolisPlayerData.get((EntityPlayer) event.getEntity());

        float cost = event.getDistance() * 3;
        float mana = data.getMana();
        if (mana > cost)
        {
            data.consumeMana(cost * 3.0F);
            event.setCanceled(true);
        }
    }*/

    @SubscribeEvent
    public static void onItemConsume(LivingEntityUseItemEvent.Finish event)
    {
        EntityPlayer player = (EntityPlayer)event.getEntityLiving();
        if (event.getItem().getItem() instanceof ItemFood)
        {
            FoodEffects foodResult = new FoodEffects();
            PlayerData data = (PlayerData) NecropolisPlayerData.get(player);

            if (!player.world.isRemote)
            {
                player.heal((float)foodResult.getStatBoosts((ItemFood)event.getItem().getItem())[0]);
                data.restoreMana((float)foodResult.getStatBoosts((ItemFood)event.getItem().getItem())[1]);
                int[] stats = new int[4];
                stats[0] = foodResult.getStatBoosts((ItemFood)event.getItem().getItem())[2];
                stats[1] = foodResult.getStatBoosts((ItemFood)event.getItem().getItem())[3];
                stats[2] = foodResult.getStatBoosts((ItemFood)event.getItem().getItem())[4];
                stats[3] = foodResult.getStatBoosts((ItemFood)event.getItem().getItem())[5];

                data.setStatBoost(stats);
                player.getFoodStats().setFoodLevel(20);
            }
            else
            {
                return;
            }
        }
    }

    @SubscribeEvent
    public void onEntityHeal(LivingHealEvent event)
    {
        if (event.getEntityLiving() instanceof EntityPlayer)
        {
            Necropolis_of_Nostalgia.packetHandler.sendTo(new SoundPacket(5,1.0f,1.0f),(EntityPlayerMP)event.getEntityLiving());
        }
    }

    public void doArmorEffects(LivingAttackEvent event)
    {
        DamageSource source = event.getSource();
        EntityPlayer aPlayer = null;
        if (source.getImmediateSource() instanceof EntityCasted)
        {
            if (((EntityCasted)source.getImmediateSource()).caster instanceof EntityPlayer)
            {
                aPlayer = (EntityPlayer)((EntityCasted)source.getImmediateSource()).caster;
            }
        }
        else if (source.getImmediateSource() instanceof EntityPlayer)
            aPlayer = (EntityPlayer)source.getImmediateSource();

        if (event.getEntity() instanceof EntityPlayer)
        {
            EntityPlayer tPlayer = (EntityPlayer)event.getEntity();
            for (ItemStack val :tPlayer.getEquipmentAndArmor()) {
                if (val.getItem() instanceof ItemNecropolisArmor)
                {
                    ItemNecropolisArmor nItem = (ItemNecropolisArmor)val.getItem();
                    String tName = nItem.getItemName();
                    if (tName.contains("bastille_plate"))
                    {
                        if (Math.random() < nItem.getItemChance())
                        {
                            if (event.getSource().getImmediateSource() instanceof EntityLiving)
                            {
                                event.getSource().getImmediateSource().attackEntityFrom(DamageSource.GENERIC, 2.0f);
                            }
                        }
                    }
                }
            }
        }

        if (aPlayer != null)
        {
            for (ItemStack val :aPlayer.getEquipmentAndArmor())
            {
                if (val.getItem() instanceof ItemNecropolisArmor)
                {
                    ItemNecropolisArmor nItem = (ItemNecropolisArmor)val.getItem();
                    String tName = nItem.getItemName();
                    PlayerData aPlayerData = (PlayerData) NecropolisPlayerData.get(aPlayer);
                    if (tName.contains("thiefs_hood"))
                    {
                        if (Math.random() < nItem.getItemChance())
                        {
                            aPlayerData.restoreMana(50.0F);
                        }
                    }
                    else if (tName.contains("lamellar"))
                    {
                        if (Math.random() < nItem.getItemChance())
                        {
                            Necropolis_of_Nostalgia.packetHandler.sendTo(new SyncServerClientStamina(-200),(EntityPlayerMP)aPlayer);
                        }
                    }
                    else if (tName.contains("sacred_armor"))
                    {
                        if (Math.random() < nItem.getItemChance())
                        {
                            aPlayer.heal(2.0f);
                        }
                    }
                    else if (tName.contains("avalon_mail"))
                    {
                        if (Math.random() < nItem.getItemChance())
                        {
                            aPlayerData.restoreMana(50.0F);
                        }
                    }
                }
            }
        }
    }

    public float doWeaponEffects(DamageSource source, Entity entity, float amount)
    {
        float attkMult = 1.0f;
        if (source.getImmediateSource() instanceof EntityCasted)
        {
            if (((EntityCasted)source.getImmediateSource()).caster instanceof EntityPlayer)
            {
                EntityPlayer player = (EntityPlayer) ((EntityCasted) source.getImmediateSource()).caster;
                if (player.getHeldItemMainhand().getItem() instanceof ItemNecropolisWeapon)
                {
                    attkMult = ((ItemNecropolisWeapon)(player.getHeldItemMainhand().getItem())).doAttack(player, entity, amount);
                }
            }
        }
        else if (source.getImmediateSource() instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) source.getImmediateSource();
            if (player.getHeldItemMainhand().getItem() instanceof ItemNecropolisWeapon)
            {
                attkMult = ((ItemNecropolisWeapon)(player.getHeldItemMainhand().getItem())).doAttack(player, entity, amount);
            }
        }
        return attkMult;
    }

    public void doMeleeDeath(EntityPlayer playerIn, EntityPlayer entityTarget, float amount)
    {
        if (entityTarget.getHealth() - amount <= 0)
        {
            if (playerIn.getHeldItemMainhand().getItem() instanceof ItemNecropolisWeapon)
            {
                ((ItemNecropolisWeapon)(playerIn.getHeldItemMainhand().getItem())).doDeath(playerIn);
            }
        }
    }

    public void doMeleeDeath(EntityPlayer playerIn, EntityLiving entityTarget, float amount)
    {
        if (entityTarget.getHealth() - amount <= 0)
        {
            if (playerIn.getHeldItemMainhand().getItem() instanceof ItemNecropolisWeapon)
            {
                ((ItemNecropolisWeapon)(playerIn.getHeldItemMainhand().getItem())).doDeath(playerIn);
            }
        }
    }

    @SubscribeEvent
    public void onEntityDeath(LivingDeathEvent event)
    {
        if (event.getSource().getImmediateSource() instanceof EntityCasted)
        {
            if (((EntityCasted)event.getSource().getImmediateSource()).caster instanceof EntityPlayer)
            {
                EntityPlayer player = (EntityPlayer) ((EntityCasted) event.getSource().getImmediateSource()).caster;
                if (player.getHeldItemMainhand().getItem() instanceof ItemNecropolisWeapon)
                {
                    ((ItemNecropolisWeapon)(player.getHeldItemMainhand().getItem())).doDeath(player);
                }
            }
        }
    }

    @SubscribeEvent
    public void onEntityAttack(LivingAttackEvent event)
    {
        Entity entity = event.getEntity();
        if (entity.getEntityWorld().isRemote)
        {
            return;
        }
        DamageSource source = event.getSource();

        float attkMult = event.getAmount();

        if (!(event.getSource().getDamageType().equals("arte") || event.getSource().getDamageType().equals("physical_artes") || event.getSource().getDamageType().equals("melee")))
        {
            doArmorEffects(event);
            attkMult *= doWeaponEffects(source, event.getEntity(), event.getAmount());
        }
        else
        {
            System.out.print("final");
            System.out.print(event.getAmount());
            System.out.printf("%n");
        }

        if (source.getImmediateSource() instanceof EntityNecropolisFireCharge || source.getImmediateSource() instanceof EntityCasted)
        {
            if (event.getEntity() instanceof NecropolisEntity)
            {
                event.setCanceled(true);
                NecropolisEntity tEntity = (NecropolisEntity)event.getEntity();
                if (source.getImmediateSource() instanceof EntityDemonFang || source.getImmediateSource() instanceof EntityBeast || source.getImmediateSource() instanceof EntityDestructionField)
                    event.getEntity().attackEntityFrom(Necropolis_of_Nostalgia.physical_artes, Math.max(1.0f, attkMult - tEntity.getDef()));
                else
                {
                    if ( source.getImmediateSource() instanceof EntityCasted)
                    {
                        EntityCasted cEntity = (EntityCasted)source.getImmediateSource();
                        if (tEntity.getElementResponse(cEntity.getArte_element()) == 1)
                            event.getEntity().attackEntityFrom(Necropolis_of_Nostalgia.artes, Math.max(1.0F, attkMult - tEntity.getSDef()/4.0f));
                        else if (tEntity.getElementResponse(cEntity.getArte_element()) == -1)
                        {
                            event.setCanceled(true);
                            tEntity.heal(Math.min(cEntity.getMaxHealth(),attkMult));
                        }
                        else
                        {
                            event.getEntity().attackEntityFrom(Necropolis_of_Nostalgia.artes, Math.max(1.0f, attkMult - tEntity.getSDef()));
                        }
                    }
                    else
                    {
                        if (source.getImmediateSource() instanceof EntityNecropolisFireCharge)
                        {
                            if (tEntity.getElementResponse(1) == 1)
                                event.getEntity().attackEntityFrom(Necropolis_of_Nostalgia.artes, Math.max(1.0f, attkMult - tEntity.getSDef()/4.0f));
                            else if (tEntity.getElementResponse(1) == -1)
                            {
                                event.setCanceled(true);
                            }
                            else
                            {
                                event.getEntity().attackEntityFrom(Necropolis_of_Nostalgia.artes, Math.max(1.0f, attkMult - tEntity.getSDef()));
                            }
                        }
                        else
                            event.getEntity().attackEntityFrom(Necropolis_of_Nostalgia.artes, Math.max(1.0f, attkMult - tEntity.getSDef()));
                    }
                }
                return;
            }
            else if (event.getEntity() instanceof EntityPlayer)
            {
                event.setCanceled(true);
                EntityPlayer tEntity = (EntityPlayer)event.getEntity();
                PlayerData playerDataTarget = (PlayerData) NecropolisPlayerData.get(tEntity);

                int def = playerDataTarget.getPlayerStats()[2];
                int sDef = playerDataTarget.getPlayerStats()[3];

                int def_boost = playerDataTarget.getStatBoost()[2];
                int sdef_boost = playerDataTarget.getStatBoost()[3];
                if (def_boost > 0)
                    def = def +(int)( def * 0.25F);
                if (sdef_boost > 0)
                    sDef = sDef +(int)( sDef * 0.25F);

                if (tEntity.isSneaking() && tEntity.getHeldItemMainhand().getItem() instanceof ItemSword)
                {
                    float dmgAmount = 0;
                    if (source.getImmediateSource() instanceof EntityDemonFang || source.getImmediateSource() instanceof EntityBeast || source.getImmediateSource() instanceof EntityDestructionField)
                        dmgAmount = Math.max(0.0f, attkMult - def);
                    else
                        dmgAmount = Math.max(0.0f, attkMult - sDef);
                    float staminaRatio = dmgAmount / 60.0F;
                    int staminaDecrease = 100;
                    if (staminaRatio > 1.0F)
                        staminaDecrease = 1600;
                    else
                        staminaDecrease += (int)(staminaRatio * 1600.0F);
                    if (staminaDecrease > 0)
                    {
                        Necropolis_of_Nostalgia.packetHandler.sendTo(new SyncServerClientStamina(staminaDecrease),(EntityPlayerMP)tEntity);
                    }
                    Necropolis_of_Nostalgia.packetHandler.sendTo(new SoundPacket(3,1.0F,1.0F),(EntityPlayerMP)tEntity);
                    tEntity.playSound(NecropolisSounds.GUARD_HIT, 1.0F,1.0F);
                    return;
                }

                if (source.getImmediateSource() instanceof EntityDemonFang || source.getImmediateSource() instanceof EntityBeast || source.getImmediateSource() instanceof EntityDestructionField)
                    event.getEntity().attackEntityFrom(Necropolis_of_Nostalgia.physical_artes, Math.max(1.0f, attkMult - def));
                else
                    event.getEntity().attackEntityFrom(Necropolis_of_Nostalgia.artes, Math.max(1.0F, attkMult - sDef));
                return;
            }
        }

        if (source.getImmediateSource() instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)source.getTrueSource();
            PlayerData playerData = (PlayerData) NecropolisPlayerData.get(player);
            event.setCanceled(true);

            if (!(player.getHeldItemMainhand().getItem() instanceof ItemSword))
            {
                event.getEntity().attackEntityFrom(Necropolis_of_Nostalgia.melee, attkMult);
                return;
            }
            if (event.getEntity() instanceof  EntityPlayer)
            {
                float pDamage = getPlayerDamage(player, (EntityPlayer)event.getEntity(), attkMult);
                if ((int)pDamage == 0)
                    return;
                event.getEntity().attackEntityFrom(Necropolis_of_Nostalgia.melee, Math.max(1.0f,pDamage));
            }
            else
            {
                float pDamage =  getMobDamage(player, event.getEntity(), attkMult);

                event.getEntity().attackEntityFrom(Necropolis_of_Nostalgia.melee, Math.max(1.0f,pDamage));
            }
            return;
        }
        else if (event.getEntity() instanceof EntityPlayer)
        {
            if (source.getImmediateSource() instanceof NecropolisEntity)
            {
                EntityPlayer player = (EntityPlayer)event.getEntity();
                PlayerData playerData = (PlayerData) NecropolisPlayerData.get(player);
                int def = playerData.getPlayerStats()[2];

                int def_boost = playerData.getStatBoost()[2];
                if (def_boost > 0)
                    def = def +(int)( def * 0.25F);


                event.setCanceled(true);

                if (player.isSneaking()  && player.getHeldItemMainhand().getItem() instanceof ItemSword)
                {
                    float dmgAmount = Math.max(0.0f, attkMult - def);
                    float staminaRatio = dmgAmount / 60.0F;

                    int staminaDecrease = 100;
                    if (staminaRatio > 1.0F)
                        staminaDecrease = 1600;
                    else
                        staminaDecrease += (int)(staminaRatio * 1600.0F);
                    Necropolis_of_Nostalgia.packetHandler.sendTo(new SyncServerClientStamina(staminaDecrease),(EntityPlayerMP)player);
                    Necropolis_of_Nostalgia.packetHandler.sendTo(new SoundPacket(3,1.0F,1.0F),(EntityPlayerMP)player);
                    player.playSound(NecropolisSounds.GUARD_HIT, 1.0F,1.0F);
                    return;
                }

                event.getEntity().attackEntityFrom(Necropolis_of_Nostalgia.melee, Math.max(1.0f, attkMult - def));
            }
            return;
        }
    }

    public float getPlayerDamage(EntityPlayer source, EntityPlayer target, float amount)
    {
        PlayerData playerDataSource = (PlayerData) NecropolisPlayerData.get(source);
        PlayerData playerDataTarget = (PlayerData) NecropolisPlayerData.get(target);

        int attack = playerDataSource.getPlayerStats()[0];
        int def = playerDataTarget.getPlayerStats()[2];

        if (target.isSneaking() && target.getHeldItemMainhand().getItem() instanceof ItemSword)
        {
            def += def/2;
        }

        int attack_boost = playerDataSource.getStatBoost()[0];
        int def_boost = playerDataTarget.getStatBoost()[2];
        if (attack_boost > 0)
            attack = attack +(int)( attack * 0.25F);
        if (def_boost > 0)
            def = def +(int)( def * 0.25F);

        if (target.isSneaking() && target.getHeldItemMainhand().getItem() instanceof ItemSword)
        {
            float dmgAmount = Math.max(0, amount - def);
            float staminaRatio = dmgAmount / 60.0F;
            int staminaDecrease = 100;
            if (staminaRatio > 1.0F)
                staminaDecrease = 1600;
            else
                staminaDecrease += (int)(staminaRatio * 1600.0F);
            Necropolis_of_Nostalgia.packetHandler.sendTo(new SyncServerClientStamina(staminaDecrease),(EntityPlayerMP)target);
            Necropolis_of_Nostalgia.packetHandler.sendTo(new SoundPacket(3,1.0F,1.0F),(EntityPlayerMP)target);
            target.playSound(NecropolisSounds.GUARD_HIT, 1.0F,1.0F);
            return 0.0F;
        }

        if (source.getHeldItemMainhand().getItem() instanceof ItemDiamondRapier ||
                source.getHeldItemMainhand().getItem() instanceof ItemIronRapier ||
                source.getHeldItemMainhand().getItem() instanceof ItemGoldRapier ||
                source.getHeldItemMainhand().getItem() instanceof ItemStoneRapier ||
                source.getHeldItemMainhand().getItem() instanceof ItemWoodenRapier)
        {
            float weapon_attack = ((ItemSword) source.getHeldItemMainhand().getItem()).getAttackDamage() + 2.0f;
            return attack + weapon_attack * amount - def;
        }
        else if (source.getHeldItemMainhand().getItem() instanceof ItemNecropolisWeapon)
        {
            ItemNecropolisWeapon necropolisWeapon = (ItemNecropolisWeapon) source.getHeldItemMainhand().getItem();
            float weapon_attack = ((ItemNecropolisWeapon)source.getHeldItemMainhand().getItem()).getAttack(false);
            float totalDamage = attack + weapon_attack * amount - def;
            this.doMeleeDeath(source, target, totalDamage);
            return totalDamage;
        }
        else if (source.getHeldItemMainhand().getItem() instanceof ItemSword)
        {
            float weapon_attack = ((ItemSword) source.getHeldItemMainhand().getItem()).getAttackDamage() + 4.0f;
            return attack + weapon_attack * amount - def;
        }
        return amount;
    }

    public float getMobDamage(EntityPlayer player, Entity target, float amount)
    {
        PlayerData playerData = (PlayerData) NecropolisPlayerData.get(player);
        int attack = playerData.getPlayerStats()[0];
        int enemyDef = 0;
        int attack_boost = playerData.getStatBoost()[0];

        if (target instanceof NecropolisEntity)
            enemyDef = ((NecropolisEntity)target).getDef();

        if (attack_boost > 0)
            attack = attack +(int)( attack * 0.25F);
        if (player.getHeldItemMainhand().getItem() instanceof ItemDiamondRapier ||
                player.getHeldItemMainhand().getItem() instanceof ItemIronRapier ||
                player.getHeldItemMainhand().getItem() instanceof ItemGoldRapier ||
                player.getHeldItemMainhand().getItem() instanceof ItemStoneRapier ||
                player.getHeldItemMainhand().getItem() instanceof ItemWoodenRapier)
        {
            float weapon_attack = ((ItemSword) player.getHeldItemMainhand().getItem()).getAttackDamage() + 2.0f;
            return attack + weapon_attack * amount - enemyDef;
        }
        else if (player.getHeldItemMainhand().getItem() instanceof ItemNecropolisWeapon)
        {
            ItemNecropolisWeapon necropolisWeapon = (ItemNecropolisWeapon) player.getHeldItemMainhand().getItem();
            float weapon_attack = ((ItemNecropolisWeapon)player.getHeldItemMainhand().getItem()).getAttack(false);
            float totalDamage = attack + weapon_attack * amount - enemyDef;

            if (target instanceof EntityLiving)
            {
                this.doMeleeDeath(player, (EntityLiving)target, totalDamage);
            }
            return totalDamage;
        }
        else if (player.getHeldItemMainhand().getItem() instanceof ItemSword)
        {
            float weapon_attack = ((ItemSword) player.getHeldItemMainhand().getItem()).getAttackDamage() + 4.0f;
            return attack + weapon_attack * amount - enemyDef;
        }
        return amount;
    }

    @SubscribeEvent
    public static void onLivingUpdateTick(LivingEvent.LivingUpdateEvent e)
    {
        if (e.getEntityLiving() instanceof EntityPlayer) {
            PlayerData playerData = (PlayerData) NecropolisPlayerData.get((EntityPlayer) e.getEntityLiving());
            if (playerData != null)
            {
                playerData.onTick();
            }
        }
    }

    @SubscribeEvent
    public void onattachCapability(AttachCapabilitiesEvent<Entity> event)
    {
        if (!(event.getObject() instanceof EntityPlayer)) return;

        event.addCapability(PLAYER_DATA, new PlayerDataProvider((EntityPlayer) event.getObject()));
        event.addCapability(GUI_DATA, new GuiDataProvider((EntityPlayer) event.getObject()));
    }

    private void setLightmap()
    {
        AbstractClientPlayer abstractclientplayer = Minecraft.getMinecraft().player;
        int i = Minecraft.getMinecraft().world.getCombinedLight(new BlockPos(abstractclientplayer.posX, abstractclientplayer.posY + (double)abstractclientplayer.getEyeHeight(), abstractclientplayer.posZ), 0);
        float f = (float)(i & 65535);
        float f1 = (float)(i >> 16);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, f, f1);
    }
    private void rotateArroundXAndY(float angle, float angleY)
    {
        GlStateManager.pushMatrix();
        GlStateManager.rotate(angle, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(angleY, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.popMatrix();
    }
    private void rotateArm(float p_187458_1_)
    {
        EntityPlayerSP entityplayersp = Minecraft.getMinecraft().player;
        float f = entityplayersp.prevRenderArmPitch + (entityplayersp.renderArmPitch - entityplayersp.prevRenderArmPitch) * p_187458_1_;
        float f1 = entityplayersp.prevRenderArmYaw + (entityplayersp.renderArmYaw - entityplayersp.prevRenderArmYaw) * p_187458_1_;
        GlStateManager.rotate((entityplayersp.rotationPitch - f) * 0.1F, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate((entityplayersp.rotationYaw - f1) * 0.1F, 0.0F, 1.0F, 0.0F);
    }
    private void transformShovelSideFirstPerson(EnumHandSide hand, float equip_ratio)
    {
        int i = hand == EnumHandSide.RIGHT ? 1 : -1;
        GlStateManager.translate((float)i * 0.56F, -0.52F + equip_ratio * -0.6F, -0.72F);
    }
    private void transformShovelFirstPerson(EnumHandSide hand, float swing_ratio)
    {
        int i = hand == EnumHandSide.RIGHT ? 1 : -1;
        float f = MathHelper.sin(swing_ratio * swing_ratio * (float)Math.PI);
        GlStateManager.rotate((float)i * (45.0F + f * -20.0F), 0.0F, 1.0F, 0.0F);
        float f1 = MathHelper.sin(MathHelper.sqrt(swing_ratio) * (float)Math.PI);
        GlStateManager.rotate((float)i * f1 * -20.0F, 0.0F, 0.0F, 1.0F);
        GlStateManager.rotate(f1 * -80.0F, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate((float)i * -90.0F, 0.0F, 1.0F, 0.0F);
    }

    private void transformSwordSideFirstPerson(EnumHandSide hand, float equip_ratio)
    {
        int i = hand == EnumHandSide.RIGHT ? 1 : -1;
        GlStateManager.translate((float)i * 0.56F, -0.52F + equip_ratio * -0.6F, -0.72F);
    }
    private void transformSwordFirstPerson(EnumHandSide hand, float swing_ratio)
    {
        int i = hand == EnumHandSide.RIGHT ? 1 : -1;
        float f = MathHelper.sin(swing_ratio * swing_ratio * (float)Math.PI);
        GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
    }

    public void renderItemSide(EntityLivingBase entitylivingbaseIn, ItemStack heldStack, ItemCameraTransforms.TransformType transform)
    {
        if (!heldStack.isEmpty())
        {
            Item item = heldStack.getItem();
            Block block = Block.getBlockFromItem(item);
            GlStateManager.pushMatrix();
            boolean flag = Minecraft.getMinecraft().getRenderItem().shouldRenderItemIn3D(heldStack) && block.getBlockLayer() == BlockRenderLayer.TRANSLUCENT;

            if (flag)
            {
                GlStateManager.depthMask(false);
            }

            Minecraft.getMinecraft().getRenderItem().renderItem(heldStack, entitylivingbaseIn, transform, false);

            if (flag)
            {
                GlStateManager.depthMask(true);
            }
            GlStateManager.popMatrix();
        }
    }
}
