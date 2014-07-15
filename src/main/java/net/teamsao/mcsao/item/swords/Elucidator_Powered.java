package net.teamsao.mcsao.item.swords;

import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.teamsao.mcsao.help.Reference;
import net.teamsao.mcsao.item.SItem;

/**
 * @author bfox1
 *
 */
public class Elucidator_Powered extends ItemSword {
	
	public static int PowerPool = 5000;
	
	public NBTTagCompound test;

	public Elucidator_Powered(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		setUnlocalizedName("Elucidator_Powered");
		setTextureName(Reference.MODID + ":" + "Elucidator");
		this.setCreativeTab(null);

	}
	
	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
	{
		if(((EntityPlayer)par3Entity).inventory.getCurrentItem() == par1ItemStack)
		{
		if(this.PowerPool > 0)
		{
			this.PowerPool = this.PowerPool - 2;
			System.out.println(this.PowerPool);
		}
		}
	}
	
	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving)
	{
	par2EntityLiving.addPotionEffect(new PotionEffect(Potion.harm.id, 2, 1));
	 float entity = par2EntityLiving.getHealth();
	 System.out.println(entity);
	return true;
	}

	

	@Override
	public ItemStack onItemRightClick(ItemStack par1, World par2, EntityPlayer par3) {
		par3.setItemInUse(par1, this.getMaxItemUseDuration(par1));

		ItemStack sword = new ItemStack(SItem.Elucidator);
		if (!par2.isRemote) {
			if (par3.isSneaking()) {
				sword.setItemDamage(par1.getItemDamage());
				return sword;
			}

		}
		return par1;
	}
	
	@Override
	public void addInformation(ItemStack item, EntityPlayer player, List list,
			boolean par4) {

		list.add(EnumChatFormatting.DARK_BLUE + "" + EnumChatFormatting.ITALIC
				+ "A very rare and Powerful sword.");
		list.add(EnumChatFormatting.DARK_BLUE + "" + EnumChatFormatting.ITALIC
				+ "Can be Obtained Only by defeating");
		list.add(EnumChatFormatting.DARK_BLUE + "" + EnumChatFormatting.ITALIC
				+ "a specific Boss.");

	}

}