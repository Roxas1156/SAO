package net.teamsao.mcsao.item.swords;

import net.teamsao.mcsao.init.SAOItems;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.teamsao.mcsao.helper.Reference;
import net.teamsao.mcsao.creativetabs.SAOTabsManager;
//

/**
 * @author bfox1
 *
 */
public class Elucidator extends ItemSword {
	
	public int PowerPool = Elucidator_Powered.PowerPool;

	public Elucidator(ToolMaterial par1) {
		super(par1);
		setUnlocalizedName("Elucidator");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		this.setCreativeTab(SAOTabsManager.saoTools);

	}
	
	
	@Override
    public ItemStack onItemRightClick(ItemStack par1, World par2, EntityPlayer par3)
    {
        par3.setItemInUse(par1, this.getMaxItemUseDuration(par1));
        ItemStack sword = new ItemStack(SAOItems.ElucidatorPowered);
        sword.addEnchantment(Enchantment.sharpness, 5);

        if(!par2.isRemote)
        {
        	if(par3.isSneaking())
        	{
    			sword.setItemDamage(par1.getItemDamage());
    			return sword;
        	}
        }
        
        return par1;
    }


	
	
}
