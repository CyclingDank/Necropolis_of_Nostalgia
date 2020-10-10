package com.turtledove.necropolisofnostalgia.common.food;

import com.turtledove.necropolisofnostalgia.Necropolis_of_Nostalgia;
import com.turtledove.necropolisofnostalgia.common.recipe.NecropolisCookingRecipes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;

public class FoodEffects
{
    public NecropolisCookingRecipes recipes = new NecropolisCookingRecipes();

    public int[] getStatBoosts(ItemFood food)
    {
        if (food.getRegistryName().equals(new ResourceLocation(Necropolis_of_Nostalgia.MODID,"steak_potato")))
        {
            int[] stats = new int[6];
            stats[0] = 6;
            stats[1] = 10;
            stats[2] = 1200;
            stats[3] = 0;
            stats[4] = 0;
            stats[5] = 0;
            return stats;
        }
        else if (food.getRegistryName().equals(new ResourceLocation(Necropolis_of_Nostalgia.MODID,"toasted_sandwich")))
        {
            int[] stats = new int[6];
            stats[0] = 6;
            stats[1] = 10;
            stats[2] = 0;
            stats[3] = 0;
            stats[4] = 1200;
            stats[5] = 0;
            return stats;
        }
        else if (food.getRegistryName().equals(new ResourceLocation(Necropolis_of_Nostalgia.MODID,"roast")))
        {
            int[] stats = new int[6];
            stats[0] = 15;
            stats[1] = 30;
            stats[2] = 1200;
            stats[3] = 1200;
            stats[4] = 0;
            stats[5] = 0;
            return stats;
        }
        else if (food.getRegistryName().equals(new ResourceLocation(Necropolis_of_Nostalgia.MODID,"pork_stew")))
        {
            int[] stats = new int[6];
            stats[0] = 10;
            stats[1] = 80;
            stats[2] = 0;
            stats[3] = 0;
            stats[4] = 1200;
            stats[5] = 1200;
            return stats;
        }
        else if (food.getRegistryName().equals(new ResourceLocation(Necropolis_of_Nostalgia.MODID,"seafood_fried_rice")))
        {
            int[] stats = new int[6];
            stats[0] = 15;
            stats[1] = 60;
            stats[2] = 0;
            stats[3] = 0;
            stats[4] = 0;
            stats[5] = 0;
            return stats;
        }
        else if (food.getRegistryName().equals(new ResourceLocation(Necropolis_of_Nostalgia.MODID,"omurice")))
        {
            int[] stats = new int[6];
            stats[0] = 4;
            stats[1] = 20;
            stats[2] = 0;
            stats[3] = 1200;
            stats[4] = 0;
            stats[5] = 0;
            return stats;
        }
        else if (food.getRegistryName().equals(new ResourceLocation(Necropolis_of_Nostalgia.MODID,"steamed_rice")))
        {
            int[] stats = new int[6];
            stats[0] = 0;
            stats[1] = 20;
            stats[2] = 0;
            stats[3] = 0;
            stats[4] = 0;
            stats[5] = 0;
            return stats;
        }
        else if (food.getRegistryName().equals(new ResourceLocation(Necropolis_of_Nostalgia.MODID,"mushroom_burger")))
        {
            int[] stats = new int[6];
            stats[0] = 6;
            stats[1] = 80;
            stats[2] = 0;
            stats[3] = 1200;
            stats[4] = 0;
            stats[5] = 0;
            return stats;
        }
        else if (food.getRegistryName().equals(new ResourceLocation(Necropolis_of_Nostalgia.MODID,"veggie_stir_fry")))
        {
            int[] stats = new int[6];
            stats[0] = 10;
            stats[1] = 140;
            stats[2] = 0;
            stats[3] = 1200;
            stats[4] = 0;
            stats[5] = 1200;
            return stats;
        }
        else
        {
            int[] stats = new int[6];
            stats[0] = 1;
            stats[1] = 4;
            stats[2] = 0;
            stats[3] = 0;
            stats[4] = 0;
            stats[5] = 0;
            return stats;
        }
    }

}
