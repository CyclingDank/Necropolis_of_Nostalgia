package com.turtledove.withernauts.client.inputs;

import com.turtledove.withernauts.Withernauts;
import com.turtledove.withernauts.client.gui.*;
import com.turtledove.withernauts.client.particles.ParticleSlashAttack;
import com.turtledove.withernauts.server.core.IPlayerData;
import com.turtledove.withernauts.server.core.NecropolisPlayerData;
import com.turtledove.withernauts.server.core.PlayerData;
import com.turtledove.withernauts.server.item.ItemNecropolisTome;
import com.turtledove.withernauts.server.packets.Inventory.InventoryPacket;
import com.turtledove.withernauts.server.packets.Player.SyncArtesOnClient;
import com.turtledove.withernauts.server.packets.Sounds.SoundPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientKeyHandler
{
    private static KeyBinding arteBinds;

    public static void initKeybinds()
    {
        String bindName = "key.hud.ability";
        int key = Keyboard.KEY_Q;
        KeyBinding bind = new KeyBinding(bindName, KeyConflictContext.IN_GAME, KeyModifier.CONTROL, key, "key.necropolisofnostalgia.artes");

        ClientRegistry.registerKeyBinding(bind);
        arteBinds = bind;
    }
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onKeyEvent(InputEvent.KeyInputEvent event)
    {
        EntityPlayer player = Minecraft.getMinecraft().player;
        if (player == null)
            return;
        IPlayerData pData = NecropolisPlayerData.get(player);
        if (pData == null)
        {
            return;
        }
        else
        {
            if (arteBinds.isPressed())
            {
                pData.doDialogueGUIControlls();
            }

        }

    }
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onMouseEvent(MouseEvent event)
    {
        EntityPlayer source = Minecraft.getMinecraft().player;
        if (source.getHeldItemMainhand().getItem() instanceof ItemSword)
        {
            EntityPlayer player = Minecraft.getMinecraft().player;
            if (player.isSneaking())
            {
                event.setCanceled(true);
                return;
            }

            if (event.isButtonstate() && event.getButton() == 0)
            {
                PlayerData data = (PlayerData) NecropolisPlayerData.get(Minecraft.getMinecraft().player);

                if (data.getClassWeapons().length == 1)
                {
                    if (data.getClassWeapons()[0] != data.getCurrent_weapon())
                        return;
                }
                else if (data.getClassWeapons().length == 2)
                {
                    if (data.getClassWeapons()[0] != data.getCurrent_weapon() && data.getClassWeapons()[1] != data.getCurrent_weapon())
                        return;
                }

                Withernauts.packetHandler.sendToServer(new SyncArtesOnClient(data.bindedArtes, data.arteCount, -1));
                if (!data.getInBufferZone())
                {
                    event.setCanceled(true);
                }
                else
                {
                    if ((data.getMana() - data.getCurrentArteTP(0)) >= 0)
                    {
                        Minecraft.getMinecraft().player.swingArm(EnumHand.MAIN_HAND);
                        data.setMouseClick(0);
                        data.setActivatepArte(true);
                        //Necropolis_of_Nostalgia.packetHandler.sendToServer(new MessagePacket(data.getCurrentArteIndex(),0,0.0,0.0,0.0));
                        Withernauts.packetHandler.sendToServer(new SoundPacket(0,0.4F,1.0F));
                        doSwordSlash(data);
                        data.consumeMana(data.getCurrentArteTP(0));
                    }
                }
            }
            else if  (event.isButtonstate() && event.getButton() == 1)
            {
                PlayerData data = (PlayerData) NecropolisPlayerData.get(Minecraft.getMinecraft().player);
                if (data.getClassWeapons().length == 1)
                {
                    if (data.getClassWeapons()[0] != data.getCurrent_weapon())
                        return;
                }
                else if (data.getClassWeapons().length == 2)
                {
                    if (data.getClassWeapons()[0] != data.getCurrent_weapon() && data.getClassWeapons()[1] != data.getCurrent_weapon())
                        return;
                }
                Withernauts.packetHandler.sendToServer(new SyncArtesOnClient(data.bindedArtes, data.arteCount, -1));
                if (!data.getInBufferZone())
                {
                    event.setCanceled(true);
                }
                else
                {
                    if ((data.getMana() - data.getCurrentArteTP(2)) >= 0)
                    {
                        Minecraft.getMinecraft().player.swingArm(EnumHand.MAIN_HAND);
                        data.setMouseClick(2);
                        data.setActivatepArte(true);
                        //Necropolis_of_Nostalgia.packetHandler.sendToServer(new MessagePacket(data.getCurrentArteIndex(),0,0.0,0.0,0.0));
                        Withernauts.packetHandler.sendToServer(new SoundPacket(0,0.2F,1.0F));
                        doSwordSlash(data);
                        data.consumeMana(data.getCurrentArteTP(2));
                    }
                }
            }
            else if (event.isButtonstate() && event.getButton() == 2)
            {
                PlayerData data = (PlayerData) NecropolisPlayerData.get(Minecraft.getMinecraft().player);
                if (data.getClassWeapons().length == 1)
                {
                    if (data.getClassWeapons()[0] != data.getCurrent_weapon())
                        return;
                }
                else if (data.getClassWeapons().length == 2)
                {
                    if (data.getClassWeapons()[0] != data.getCurrent_weapon() && data.getClassWeapons()[1] != data.getCurrent_weapon())
                        return;
                }
                Withernauts.packetHandler.sendToServer(new SyncArtesOnClient(data.bindedArtes, data.arteCount, -1));
                if (!data.getInBufferZone())
                {
                    event.setCanceled(true);
                }
                else
                {
                    if ((data.getMana() - data.getCurrentArteTP(1)) >= 0)
                    {
                        Minecraft.getMinecraft().player.swingArm(EnumHand.MAIN_HAND);
                        data.setMouseClick(1);
                        data.setActivatepArte(true);
                        //Necropolis_of_Nostalgia.packetHandler.sendToServer(new MessagePacket(data.getCurrentArteIndex(),0,0.0,0.0,0.0));
                        Withernauts.packetHandler.sendToServer(new SoundPacket(0,0.4F,1.0F));
                        doSwordSlash(data);
                        data.consumeMana(data.getCurrentArteTP(1));
                    }
                }
            }
        }
    }
    private static void doSwordSlash(PlayerData data)
    {
        if (data.getCurrentpArte() == 1)
        {
            Vec3d player_localSpace_translated = new Vec3d(0.0D, 0.0D, 1.0D);

            float draco_angle = -Minecraft.getMinecraft().player.rotationPitch * 0.0174533F;
            float t_sin = MathHelper.sin(draco_angle);
            float t_cos = MathHelper.cos(draco_angle);
            Vec3d player_localSpace_rotatedPitch = new Vec3d(player_localSpace_translated.x, t_cos * player_localSpace_translated.y + player_localSpace_translated.z * t_sin, -player_localSpace_translated.y * t_sin + t_cos * player_localSpace_translated.z);

            draco_angle = Minecraft.getMinecraft().player.rotationYaw * 0.0174533F;
            t_sin = MathHelper.sin(draco_angle);
            t_cos = MathHelper.cos(draco_angle);
            Vec3d player_localSpace_rotatedYaw = new Vec3d(player_localSpace_rotatedPitch.x * t_cos - player_localSpace_rotatedPitch.z * t_sin, player_localSpace_rotatedPitch.y,player_localSpace_rotatedPitch.x * t_sin + player_localSpace_rotatedPitch.z * t_cos);

            Particle slashParticle = new ParticleSlashAttack(Minecraft.getMinecraft().player.world,Minecraft.getMinecraft().player,
                    Minecraft.getMinecraft().player.posX + player_localSpace_rotatedYaw.x,Minecraft.getMinecraft().player.posY + player_localSpace_rotatedYaw.y + Minecraft.getMinecraft().player.getEyeHeight() - 0.25F,Minecraft.getMinecraft().player.posZ + player_localSpace_rotatedYaw.z);
            Minecraft.getMinecraft().effectRenderer.addEffect(slashParticle);
        }
    }
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onGuiOverlayEvent(RenderGameOverlayEvent event)
    {
        if (event.getType() == RenderGameOverlayEvent.ElementType.FOOD)
        {
            event.setCanceled(true);
        }
        else  if (event.getType() == RenderGameOverlayEvent.ElementType.CROSSHAIRS)
        {
            if (Minecraft.getMinecraft().player.getHeldItemMainhand().getItem() instanceof ItemSword && !(Minecraft.getMinecraft().player.getHeldItemMainhand().getItem() instanceof ItemNecropolisTome))
            {
                event.setCanceled(true);
            }
        }
        else if (event.getType() == RenderGameOverlayEvent.ElementType.EXPERIENCE)
        {
            event.setCanceled(true);
        }
        else if (event.getType() == RenderGameOverlayEvent.ElementType.HEALTH)
        {
            event.setCanceled(true);
        }
        else if (event.getType() == RenderGameOverlayEvent.ElementType.ARMOR)
        {
            event.setCanceled(true);
        }
        else if (event.getType() == RenderGameOverlayEvent.ElementType.AIR)
        {
            event.setCanceled(true);
        }
    }
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onGuiOpenEvent(GuiOpenEvent event)
    {
        EntityPlayer player = Minecraft.getMinecraft().player;
        if (player != null)
        {
            if (!player.isCreative())
            {
                if (event.getGui() instanceof GuiInventory)
                {
                    event.setCanceled(true);
                    Withernauts.packetHandler.sendToServer(new InventoryPacket());
                }
            }
        }
    }
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onGuiRenderEvent(RenderGameOverlayEvent.Post event)
    {
        if (event.getType() != RenderGameOverlayEvent.ElementType.HOTBAR) return;
        if (!Minecraft.getMinecraft().player.isCreative())
        {
            new TPMeterGUI(Minecraft.getMinecraft());
            new HeartsGUI(Minecraft.getMinecraft());
            new StaminaMeterGUI(Minecraft.getMinecraft());
            new PlayerSoulsGUI(Minecraft.getMinecraft());
        }
        EntityPlayer player = Minecraft.getMinecraft().player;
        if (player == null)
            return;
        IPlayerData pData = NecropolisPlayerData.get(player);
        if (pData == null)
        {
            return;
        }
        else
        {
            if (pData.doDialogue())
                new NPCDialogueGUI(Minecraft.getMinecraft());
        }
    }
}