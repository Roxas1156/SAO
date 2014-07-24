package net.teamsao.mcsao.item.swords;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.teamsao.mcsao.help.ReferenceHelper;
import net.teamsao.mcsao.init.SAOItems;
import net.teamsao.mcsao.item.ItemSAO;
import net.teamsao.mcsao.lib.SAOTabsManager;
//

public class MateChopper extends ItemSword {

	public MateChopper(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		this.setUnlocalizedName("MateChopper");
		this.setTextureName(ReferenceHelper.setItemName(this));
		this.setCreativeTab(SAOTabsManager.saoTools);
	}
	

	
	@Override
    public ItemStack onItemRightClick(ItemStack par1, World par2, EntityPlayer par3)
    {
        par3.setItemInUse(par1, this.getMaxItemUseDuration(par1));
        ItemStack sword = new ItemStack(SAOItems.MateChopperPowered);
        

        if(!par2.isRemote)
        {
        	if(par3.isSneaking())
        	{
        		sword.addEnchantment(Enchantment.sharpness, 6);
        		sword.addEnchantment(Enchantment.fireAspect, 3);
    			sword.setItemDamage(par1.getItemDamage());
    			return sword;
        	}
        }
        
        return par1;
    }

}
