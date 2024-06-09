package net.zekromaster.minecraft.craftablechainmail.mixin;

import net.minecraft.recipe.ArmorRecipes;
import net.zekromaster.minecraft.craftablechainmail.ItemListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ArmorRecipes.class)
public class RemoveChainmailRecipes {
	@Shadow
	private Object[][] items;

	@Inject(at = @At("TAIL"), method = "<init>", remap = false)
	private void init(CallbackInfo ci) {
		this.items[0][1] = ItemListener.IRON_RING;
	}
}
