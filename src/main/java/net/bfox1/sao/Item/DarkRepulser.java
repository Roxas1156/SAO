package net.bfox1.sao.Item;

import net.bfox1.sao.help.ReferenceHelper;
import net.bfox1.sao.lib.SCreativeTab;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class DarkRepulser extends ItemSword {

	public DarkRepulser(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		this.setUnlocalizedName("DarkRepulser");
		this.setTextureName(ReferenceHelper.registerItemName(this));
		this.setCreativeTab(SCreativeTab.SAO);
		
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1, World world, EntityPlayer player)
	{
		ItemStack sword = new ItemStack(SItem.DarkRepulserPowered);
        player.setItemInUse(par1, this.getMaxItemUseDuration(par1));
        if(!world.isRemote)
        {
        	if(player.isSneaking())
        	{
        	sword.setItemDamage(par1.getItemDamage());
        	sword.addEnchantment(Enchantment.unbreaking, 1);
        	sword.addEnchantment(Enchantment.sharpness, 3);
        	return sword;
        	}
        }
		return par1;
		
	}

}
