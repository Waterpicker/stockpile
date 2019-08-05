package me.branchpanic.mods.stockpile.impl.storage

import me.branchpanic.mods.stockpile.api.storage.MutableMassStorage
import me.branchpanic.mods.stockpile.api.storage.Quantizer
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import java.text.NumberFormat

class MassItemStackStorage(override var contents: Quantizer<ItemStack>, var maxStacks: Int) :
    MutableMassStorage<ItemStack> {
    override val capacity: Long
        get() = (maxStacks * contents.reference.maxCount).toLong()

    private val numberFormat = NumberFormat.getNumberInstance()

    override fun describeContents(): Text =
        if (!isEmpty) TranslatableText(
            "ui.stockpile.barrel.contents",
            contents.amount.format(),
            capacity.format(),
            contents.reference.name,
            (contents.amount / contents.reference.maxCount).format(),
            maxStacks.format()
        ) else TranslatableText(
            "ui.stockpile.barrel.contents_empty",
            maxStacks.format()
        )
}

private fun Long.format(): String = NumberFormat.getNumberInstance().format(this)
private fun Int.format(): String = NumberFormat.getNumberInstance().format(this)