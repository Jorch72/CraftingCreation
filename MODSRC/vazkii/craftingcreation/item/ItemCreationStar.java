package vazkii.craftingcreation.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import vazkii.craftingcreation.handler.ConfigurationHandler;

public class ItemCreationStar extends ItemCraftingCreation {
	
	public ItemCreationStar(int par1) {
		super(par1);
		setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if(!par2World.isRemote && par3EntityPlayer instanceof EntityPlayerMP && par3EntityPlayer.dimension != ConfigurationHandler.dimID) {
			par1ItemStack.stackSize--;
			par3EntityPlayer.setPosition(1000, 130, 1000);
			par3EntityPlayer.travelToDimension(ConfigurationHandler.dimID);
			((EntityPlayerMP)par3EntityPlayer).playerNetServerHandler.setPlayerLocation(-12, 10, -12, par3EntityPlayer.rotationYaw, par3EntityPlayer.rotationPitch);
		}
		
		return par1ItemStack;
	}
}
