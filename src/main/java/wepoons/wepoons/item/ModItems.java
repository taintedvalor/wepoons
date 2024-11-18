package wepoons.wepoons.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import wepoons.wepoons.Wepoons;
import wepoons.wepoons.item.Materials.ModFoodComponents;
import wepoons.wepoons.item.Materials.ModToolMaterial;

public class ModItems {
    public static final Item ace_mace = registeritem("ace_mace",
            new SwordItem(ModToolMaterial.ACE, 42068, 52,  new FabricItemSettings()));

    public static final Item ace_mace_newskin = registeritem("ace_mace_newskin",
            new SwordItem(ModToolMaterial.ACE, 42068, 52,  new FabricItemSettings()));

    public static final Item ace_cookie = registeritem("ace_cookie", new Item(new FabricItemSettings().food(ModFoodComponents.ace_cookie)));

    public static void AddToCombatGroup(FabricItemGroupEntries entries){
        entries.add(ace_mace);
        entries.add(ace_mace_newskin);
    }

    public static void AddToFoodGroup(FabricItemGroupEntries entries){
        entries.add(ace_cookie);
    }


    private static Item registeritem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Wepoons.MOD_ID, name), item);
    }


    public static void registerModItems(){
        Wepoons.LOGGER.info("Registering Mod items for " + Wepoons.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::AddToCombatGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::AddToFoodGroup);
    }
}
