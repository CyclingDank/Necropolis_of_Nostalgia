package com.turtledove.necropolisofnostalgia.client.render.entity;


import com.turtledove.necropolisofnostalgia.client.model.entity.ModelSpiral_Draco;
import com.turtledove.necropolisofnostalgia.server.entity.Spiral_Draco.EntitySpiral_Draco;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSpiral_Draco extends RenderLiving<EntitySpiral_Draco>
{
    private static final ResourceLocation COW_TEXTURES = new ResourceLocation("Necropolis_of_Nostalgia/src/main/resources/assets/textures/entity/wroughtnaut.png");

    public RenderSpiral_Draco(RenderManager mgr)
    {
        super(mgr, new ModelSpiral_Draco(), 0.7F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntitySpiral_Draco entity)
    {
        return COW_TEXTURES;
    }
}