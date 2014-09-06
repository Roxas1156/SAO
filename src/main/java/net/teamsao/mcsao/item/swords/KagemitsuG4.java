package net.teamsao.mcsao.item.swords;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.teamsao.mcsao.creativetabs.SAOTabsManager;
import net.teamsao.mcsao.helper.ReferenceHelper;
import net.teamsao.mcsao.init.SAOItems;
import net.teamsao.mcsao.item.SItemSword;

/**
 * @author 5chris100
 */
public class KagemitsuG4 extends SItemSword {

    public KagemitsuG4(ToolMaterial p_i45356_1_) {
        super(p_i45356_1_);
        this.setUnlocalizedName("KagemitsuG4");
        // this.setTextureName(ReferenceHelper.setItemName(SAOItems.KagemitsuG4));
        this.setCreativeTab(SAOTabsManager.saoTools);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack par1, World par2, EntityPlayer par3) {
        par3.setItemInUse(par1, this.getMaxItemUseDuration(par1));

        ItemStack sword = new ItemStack(SAOItems.KagemitsuG4Powered);
        sword.addEnchantment(Enchantment.sharpness, 4);
        sword.addEnchantment(Enchantment.power, 3);
        if (!par2.isRemote) {
            if (par3.isSneaking()) {
                sword.setItemDamage(par1.getItemDamage());
                return sword;
            }

        }
        return par1;
    }
}
