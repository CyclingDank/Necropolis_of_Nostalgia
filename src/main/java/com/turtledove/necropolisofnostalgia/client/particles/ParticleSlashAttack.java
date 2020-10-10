package com.turtledove.necropolisofnostalgia.client.particles;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ParticleSlashAttack extends Particle
{
    private static final ResourceLocation SLASH_TEXTURE = new ResourceLocation(Necropolis_of_Nostalgia.MODID,"textures/entity/sweep.png");
    private static final VertexFormat VERTEX_FORMAT = (new VertexFormat()).addElement(DefaultVertexFormats.POSITION_3F).addElement(DefaultVertexFormats.TEX_2F).addElement(DefaultVertexFormats.COLOR_4UB).addElement(DefaultVertexFormats.TEX_2S).addElement(DefaultVertexFormats.NORMAL_3B).addElement(DefaultVertexFormats.PADDING_1B);

    private int NUM_FRAMES = 2;

    private int currentAnimationFrame = 0;
    private float progress = 0.0F;
    int particleAge = 0;
    int particleMaxAge = 6;
    EntityPlayer player;

    public ParticleSlashAttack(World parWorld, EntityPlayer playerIn, double parX, double parY, double parZ)
    {

        super(parWorld, parX, parY, parZ);
        this.canCollide = false;
        this.player = playerIn;
        this.motionX = 0;
        this.motionY = 0;
        this.motionZ = 0;
    }

    @Override
    public void onUpdate()
    {
        updateTick();
    }

    private void updateTick()
    {
        if (this.particleAge++ >= this.particleMaxAge){this.setExpired();}
        progress = (float)particleAge / (float)particleMaxAge;

        currentAnimationFrame = (int) (progress * NUM_FRAMES);
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        this.posX += (this.player.posX - this.player.prevPosX);
        this.posY += (this.player.posY - this.player.prevPosY);
        this.posZ += (this.player.posZ - this.player.prevPosZ);

    }
    @Override
    public int getFXLayer() { return 3; }
    @Override
    public boolean shouldDisableDepth() { return false; }

    @Override
    public void renderParticle(BufferBuilder bufferIn, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ)
    {
        int i = (int)(((float)this.particleAge + partialTicks) * 3.0F / (float)this.particleMaxAge);

        if (i <= 7)
        {
            Minecraft.getMinecraft().getTextureManager().bindTexture(SLASH_TEXTURE);
            float f = (float)(i % 4) / 4.0F;
            float f1 = f + 0.24975F;
            float f2 = (float)(i / 2) / 2.0F;
            float f3 = f2 + 0.4995F;
            float f4 = 1.0F;
            float f5 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)partialTicks - interpPosX);
            float f6 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)partialTicks - interpPosY);
            float f7 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)partialTicks - interpPosZ);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            GlStateManager.alphaFunc(516, 0.003921569F);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 0.7F);
            GlStateManager.disableLighting();
            RenderHelper.disableStandardItemLighting();
            bufferIn.begin(7, VERTEX_FORMAT);
            bufferIn.pos((double)(f5 - rotationX * f4 - rotationXY * f4), (double)(f6 - rotationZ * f4 * 0.5F), (double)(f7 - rotationYZ * f4 - rotationXZ * f4)).tex((double)f1, (double)f3).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0F).lightmap(0, 240).normal(0.0F, 1.0F, 0.0F).endVertex();
            bufferIn.pos((double)(f5 - rotationX * f4 + rotationXY * f4), (double)(f6 + rotationZ * f4 * 0.5F), (double)(f7 - rotationYZ * f4 + rotationXZ * f4)).tex((double)f1, (double)f2).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0F).lightmap(0, 240).normal(0.0F, 1.0F, 0.0F).endVertex();
            bufferIn.pos((double)(f5 + rotationX * f4 + rotationXY * f4), (double)(f6 + rotationZ * f4 * 0.5F), (double)(f7 + rotationYZ * f4 + rotationXZ * f4)).tex((double)f, (double)f2).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0F).lightmap(0, 240).normal(0.0F, 1.0F, 0.0F).endVertex();
            bufferIn.pos((double)(f5 + rotationX * f4 - rotationXY * f4), (double)(f6 - rotationZ * f4 * 0.5F), (double)(f7 + rotationYZ * f4 - rotationXZ * f4)).tex((double)f, (double)f3).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0F).lightmap(0, 240).normal(0.0F, 1.0F, 0.0F).endVertex();
            Tessellator.getInstance().draw();
            GlStateManager.enableLighting();
        }
    }

}
