package notjoe.stockpile.adder

import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.ResourceLocation
import notjoe.stockpile.block.BlockBarrel
import notjoe.stockpile.block.BlockTrashCan
import org.dimdev.rift.listener.BlockAdder
import org.dimdev.rift.listener.ItemAdder
import kotlin.math.pow

@Suppress("unused")
class StockpileBlockAdder : BlockAdder, ItemAdder {
    private val blocks = mapOf<String, Block>(
            "barrel" to BlockBarrel(64),
            "black_hole_barrel" to BlockBarrel(2.0.pow(24).toInt()),
            "trash_can" to BlockTrashCan()
    )

    override fun registerBlocks() {
        blocks.forEach { name, block -> Block.registerBlock(ResourceLocation("stockpile", name), block) }
    }

    override fun registerItems() {
        blocks.forEach { _, block -> Item.registerItemBlock(block, ItemGroup.DECORATIONS) }
    }
}
