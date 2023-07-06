package net.lewis.firstmod.block;

import net.lewis.firstmod.FirstMod;
import net.lewis.firstmod.block.custom.JumpyBlock;
import net.lewis.firstmod.block.custom.ZirconLampBlock;
import net.lewis.firstmod.item.ModCreativeModeTab;
import net.lewis.firstmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FirstMod.MOD_ID);

    public static final RegistryObject<Block> ZIRCON_BLOCK = registerBlock("zircon_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)  //How the block behaviours (Stone0
                    .strength(6f).requiresCorrectToolForDrops()), //Strength of block and tool required
                    ModCreativeModeTab.FIRST_TAB);

    public static final RegistryObject<Block> ZIRCON_ORE = registerBlock("zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),  //Strength of block and tool required
                    UniformInt.of(3,7)), //Amount of Experience when mined
                    ModCreativeModeTab.FIRST_TAB);

    public static final RegistryObject<Block> DEEPSLATE_ZIRCON_ORE = registerBlock("deepslate_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),   //Strength of block and tool required
                    UniformInt.of(3,7)),
                    ModCreativeModeTab.FIRST_TAB);

    public static final RegistryObject<Block> NETHERRACk_ZIRCON_ORE = registerBlock("netherrack_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),   //Strength of block and tool required
                    UniformInt.of(3,7)),
            ModCreativeModeTab.FIRST_TAB);

    public static final RegistryObject<Block> ENDSTONE_ZIRCON_ORE = registerBlock("endstone_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),   //Strength of block and tool required
                    UniformInt.of(3,7)),
            ModCreativeModeTab.FIRST_TAB);

    public static final RegistryObject<Block> JUMPY_BLOCK = registerBlock("jumpy_block",
            () -> new JumpyBlock(BlockBehaviour.Properties.of(Material.STONE)  //How the block behaviours (Stone
                    .strength(6f).requiresCorrectToolForDrops()), //Strength of block and tool required
            ModCreativeModeTab.FIRST_TAB);

    public static final RegistryObject<Block> ZIRCON_LAMP = registerBlock("zircon_lamp",
            () -> new ZirconLampBlock(BlockBehaviour.Properties.of(Material.STONE)  //How the block behaviours (Stone
                    .strength(6f).requiresCorrectToolForDrops().lightLevel(state -> state.getValue(ZirconLampBlock.LIT) ? 15 : 0)), //light level should emit 15 or 0
            ModCreativeModeTab.FIRST_TAB);


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);

        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab))); //Creates new block and adds it to the creative tab
    }


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
