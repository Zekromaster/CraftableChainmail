package net.zekromaster.minecraft.craftablechainmail;

import com.google.common.base.Suppliers;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.registry.ItemRegistry;
import net.modificationstation.stationapi.api.tag.TagKey;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Map;
import java.util.function.Supplier;

import static net.zekromaster.minecraft.craftablechainmail.ItemListener.IRON_RING;

public class RecipeListener {

    private final static int AMOUNT_PER_RECIPE = 8;

    private final static Supplier<Map<String[], Item>> patterns = Suppliers.memoize(() -> Map.of(
        new String[]{"XXX", "X X"}, Item.CHAIN_HELMET,
        new String[]{"X X", "XXX", "XXX"}, Item.CHAIN_CHESTPLATE,
        new String[]{"XXX", "X X", "X X"}, Item.CHAIN_LEGGINGS,
        new String[]{"X X", "X X"}, Item.CHAIN_BOOTS
    ));

    @EventListener
    public void registerRecipes(RecipeRegisterEvent event) {

        Identifier type = event.recipeId;
        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPED.type()) {
            // Recipe for the rings themselves
            CraftingRegistry.addShapedRecipe(
                new ItemStack(IRON_RING, AMOUNT_PER_RECIPE),
                new String[]{" X ", "X X", " X "},
                'X', Item.IRON_INGOT
            );

            for (var pattern: patterns.get().entrySet()) {
                CraftingRegistry.addShapedRecipe(
                    new ItemStack(pattern.getValue()),
                    pattern.getKey(),
                    'X', TagKey.of(ItemRegistry.KEY, Identifier.of("c:rings/iron"))
                );
            }

        }
    }

}
