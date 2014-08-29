package net.teamsao.mcsao.item.potions;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.teamsao.mcsao.helper.ReferenceHelper;
import net.teamsao.mcsao.creativetabs.SAOTabsManager;

/**
 * Created by bfox1 on 8/11/2014.
 */
public class Elixir extends Item {
    @SideOnly(Side.CLIENT)
    private IIcon healing;

    @SideOnly(Side.CLIENT)
    private IIcon strength;

    @SideOnly(Side.CLIENT)
    private IIcon speed;

    public Elixir()
    {
        this.setUnlocalizedName("Elixer");
        this.setMaxStackSize(1);
        this.setTextureName(ReferenceHelper.setItemName(this));
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(SAOTabsManager.SAO);
    }


}
