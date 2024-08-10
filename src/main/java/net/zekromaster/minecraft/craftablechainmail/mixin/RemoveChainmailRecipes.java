package net.zekromaster.minecraft.craftablechainmail.mixin;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.ArmorRecipes;
import net.minecraft.recipe.CraftingRecipeManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ArmorRecipes.class)
public class RemoveChainmailRecipes {

	@Redirect(method = "add", at = @At(value = "INVOKE", target = "Lnet/minecraft/recipe/CraftingRecipeManager;addShapedRecipe(Lnet/minecraft/item/ItemStack;[Ljava/lang/Object;)V"))
	private void add(CraftingRecipeManager instance, ItemStack output, Object[] input) {
		if (input[1].equals(Block.FIRE)) {
			instance.addShapedRecipe(output, input);
		}
	}
}
