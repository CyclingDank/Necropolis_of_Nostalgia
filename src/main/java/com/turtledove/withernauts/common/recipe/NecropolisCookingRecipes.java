package com.turtledove.withernauts.common.recipe;

import com.turtledove.withernauts.server.item.ItemHandler;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//this class handles vanilla recipes AND new recipes.

public class NecropolisCookingRecipes
{
    private Set<String> cooked_porkchop = new HashSet<String>();
    private Set<String> cooked_fish = new HashSet<String>();
    private Set<String> cooked_steak = new HashSet<String>();
    private Set<String> cooked_chicken = new HashSet<String>();
    private Set<String> baked_potato = new HashSet<String>();
    private Set<String> cooked_rabbit = new HashSet<String>();
    private Set<String> cooked_mutton = new HashSet<String>();

    private Set<String> steak_potato = new HashSet<String>();

    private Set<String> toasted_sandwich_0 = new HashSet<String>();
    private Set<String> toasted_sandwich_1 = new HashSet<String>();
    private Set<String> toasted_sandwich_2 = new HashSet<String>();
    private Set<String> toasted_sandwich_3 = new HashSet<String>();
    private Set<String> toasted_sandwich_4 = new HashSet<String>();
    private Set<String> toasted_sandwich_5 = new HashSet<String>();

    private Set<String> broth = new HashSet<String>();
    private Set<String> roast = new HashSet<String>();
    private Set<String> pork_stew = new HashSet<String>();
    private Set<String> mushroom_burger = new HashSet<String>();
    private Set<String> veggie_stir_fry = new HashSet<String>();
    private Set<String> steamed_rice = new HashSet<String>();
    private Set<String> omurice = new HashSet<String>();
    private Set<String> seafood_fried_rice = new HashSet<String>();






    private List<Set<String>> cookBook = new ArrayList<Set<String>>();
    public List<Item> dishID = new ArrayList<Item>();

    public NecropolisCookingRecipes()
    {
        dishID.add(Item.getItemById(320));
        dishID.add(Item.getItemById(350));
        dishID.add(Item.getItemById(364));
        dishID.add(Item.getItemById(366));
        dishID.add(Item.getItemById(393));
        dishID.add(Item.getItemById(412));
        dishID.add(Item.getItemById(424));
        dishID.add(ItemHandler.STEAK_POTATO);
        dishID.add(ItemHandler.TOASTED_SANDWICH);
        dishID.add(ItemHandler.TOASTED_SANDWICH);
        dishID.add(ItemHandler.TOASTED_SANDWICH);
        dishID.add(ItemHandler.TOASTED_SANDWICH);
        dishID.add(ItemHandler.TOASTED_SANDWICH);
        dishID.add(ItemHandler.TOASTED_SANDWICH);
        dishID.add(ItemHandler.BROTH);
        dishID.add(ItemHandler.ROAST);
        dishID.add(ItemHandler.PORK_STEW);
        dishID.add(ItemHandler.MUSHROOM_BURGER);
        dishID.add(ItemHandler.VEGGIE_STIR_FRY);
        dishID.add(ItemHandler.STEAMED_RICE);
        dishID.add(ItemHandler.OMURICE);
        dishID.add(ItemHandler.SEAFOOD_FRIED_RICE);


        cooked_porkchop.add(Item.REGISTRY.getObjectById(319).getRegistryName().toString());
        cooked_fish.add(Item.REGISTRY.getObjectById(349).getRegistryName().toString());
        cooked_steak.add(Item.REGISTRY.getObjectById(363).getRegistryName().toString());
        cooked_chicken.add(Item.REGISTRY.getObjectById(365).getRegistryName().toString());
        baked_potato.add(Item.REGISTRY.getObjectById(392).getRegistryName().toString());
        cooked_rabbit.add(Item.REGISTRY.getObjectById(411).getRegistryName().toString());
        cooked_mutton.add(Item.REGISTRY.getObjectById(423).getRegistryName().toString());

        steak_potato.add(Item.REGISTRY.getObjectById(363).getRegistryName().toString());
        steak_potato.add(Item.REGISTRY.getObjectById(392).getRegistryName().toString());

        toasted_sandwich_0.add(Item.REGISTRY.getObjectById(297).getRegistryName().toString());
        toasted_sandwich_0.add(Item.REGISTRY.getObjectById(319).getRegistryName().toString());
        toasted_sandwich_1.add(Item.REGISTRY.getObjectById(297).getRegistryName().toString());
        toasted_sandwich_1.add(Item.REGISTRY.getObjectById(349).getRegistryName().toString());
        toasted_sandwich_2.add(Item.REGISTRY.getObjectById(297).getRegistryName().toString());
        toasted_sandwich_2.add(Item.REGISTRY.getObjectById(363).getRegistryName().toString());
        toasted_sandwich_3.add(Item.REGISTRY.getObjectById(297).getRegistryName().toString());
        toasted_sandwich_3.add(Item.REGISTRY.getObjectById(365).getRegistryName().toString());
        toasted_sandwich_4.add(Item.REGISTRY.getObjectById(297).getRegistryName().toString());
        toasted_sandwich_4.add(Item.REGISTRY.getObjectById(411).getRegistryName().toString());
        toasted_sandwich_5.add(Item.REGISTRY.getObjectById(297).getRegistryName().toString());
        toasted_sandwich_5.add(Item.REGISTRY.getObjectById(423).getRegistryName().toString());

        broth.add(Item.REGISTRY.getObjectById(363).getRegistryName().toString());
        broth.add(Item.REGISTRY.getObjectById(326).getRegistryName().toString());

        roast.add(ItemHandler.BROTH.getRegistryName().toString());
        roast.add(Item.REGISTRY.getObjectById(363).getRegistryName().toString());
        roast.add(Item.REGISTRY.getObjectById(391).getRegistryName().toString());

        pork_stew.add(Item.REGISTRY.getObjectById(319).getRegistryName().toString());
        pork_stew.add(ItemHandler.BROTH.getRegistryName().toString());
        pork_stew.add(Item.REGISTRY.getObjectById(391).getRegistryName().toString());
        pork_stew.add(Item.REGISTRY.getObjectById(392).getRegistryName().toString());
        pork_stew.add(Item.getItemFromBlock(Blocks.BROWN_MUSHROOM).getRegistryName().toString());

        mushroom_burger.add(Item.REGISTRY.getObjectById(297).getRegistryName().toString());
        mushroom_burger.add(Item.getItemFromBlock(Blocks.BROWN_MUSHROOM).getRegistryName().toString());

        veggie_stir_fry.add(Item.getItemFromBlock(Blocks.BROWN_MUSHROOM).getRegistryName().toString());
        veggie_stir_fry.add(Item.REGISTRY.getObjectById(391).getRegistryName().toString());
        veggie_stir_fry.add(Item.REGISTRY.getObjectById(392).getRegistryName().toString());

        steamed_rice.add(ItemHandler.RICE_SEED.getRegistryName().toString());
        steamed_rice.add(Item.REGISTRY.getObjectById(326).getRegistryName().toString());

        omurice.add(ItemHandler.STEAMED_RICE.getRegistryName().toString());
        omurice.add(Item.REGISTRY.getObjectById(344).getRegistryName().toString());

        seafood_fried_rice.add(ItemHandler.STEAMED_RICE.getRegistryName().toString());
        seafood_fried_rice.add(Item.REGISTRY.getObjectById(391).getRegistryName().toString());
        seafood_fried_rice.add(Item.REGISTRY.getObjectById(349).getRegistryName().toString());

        cookBook.add(cooked_porkchop);
        cookBook.add(cooked_fish);
        cookBook.add(cooked_steak);
        cookBook.add(cooked_chicken);
        cookBook.add(baked_potato);
        cookBook.add(cooked_rabbit);
        cookBook.add(cooked_mutton);
        cookBook.add(steak_potato);
        cookBook.add(toasted_sandwich_0);
        cookBook.add(toasted_sandwich_1);
        cookBook.add(toasted_sandwich_2);
        cookBook.add(toasted_sandwich_3);
        cookBook.add(toasted_sandwich_4);
        cookBook.add(toasted_sandwich_5);
        cookBook.add(broth);
        cookBook.add(roast);
        cookBook.add(pork_stew);
        cookBook.add(mushroom_burger);
        cookBook.add(veggie_stir_fry);
        cookBook.add(steamed_rice);
        cookBook.add(omurice);
        cookBook.add(seafood_fried_rice);

    }

    public ItemStack getRecipeResult(List<String> grid_elements)
    {
        if (grid_elements.isEmpty())
           return ItemStack.EMPTY;

        if (grid_elements.size() > 1)
        {
            for (int i = 0; i < grid_elements.size() - 1; i++)
            {
                for (int j = i + 1; j < grid_elements.size(); j++)
                {
                    if (grid_elements.get(i).equals(grid_elements.get(j)))
                    {
                        return ItemStack.EMPTY;
                    }
                }
            }
        }
        Set<String> ingredients = new HashSet<String>();
        for (String item : grid_elements)
            ingredients.add(item);

        for (int i = 0; i < cookBook.size(); i++)
        {
            if (ingredients.equals(cookBook.get(i)))
                return new ItemStack(dishID.get(i));
        }
        return ItemStack.EMPTY;
    }
}
