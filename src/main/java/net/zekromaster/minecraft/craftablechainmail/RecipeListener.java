package net.zekromaster.minecraft.craftablechainmail;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.util.Identifier;

import static net.zekromaster.minecraft.craftablechainmail.ItemListener.IRON_RING;

public class RecipeListener {

    private final static int AMOUNT_PER_RECIPE = 8;

    @EventListener
    public void registerRecipes(RecipeRegisterEvent event) {

        Identifier type = event.recipeId;
        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPED.type()) {
            // Recipes for the rings themselves
            CraftingRegistry.addShapedRecipe(
                new ItemStack(IRON_RING, AMOUNT_PER_RECIPE),
                new String[]{"XX ", " XX"},
                'X', Item.IRON_INGOT
            );
            CraftingRegistry.addShapedRecipe(
                new ItemStack(IRON_RING, AMOUNT_PER_RECIPE),
                new String[]{" XX", "XX "},
                'X', Item.IRON_INGOT
            );
        }
    }

}
