package joshie.enchiridion.designer.recipe;

import java.lang.reflect.Field;
import java.util.ArrayList;

import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RecipeHandlerShapelessOre extends RecipeHandlerRecipeBase {
    public RecipeHandlerShapelessOre() {}
    public RecipeHandlerShapelessOre(IRecipe recipe) {
        try {
            init(recipe.getRecipeOutput(), (ArrayList<Object>) this.input.get(recipe), 3);
        } catch (Exception e) { e.printStackTrace(); }
    }
    
    @Override
    protected Class getHandlerClass() {
        return this.getClass();
    }
    
    @Override
    protected Class getRecipeClass() {
        return ShapelessOreRecipe.class;
    }

    private static Field input;
    static {
        try {
            input = ShapelessOreRecipe.class.getDeclaredField("input");
            input.setAccessible(true);
        } catch (Exception e) {}
    }
}
