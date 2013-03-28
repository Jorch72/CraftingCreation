package vazkii.craftingcreation;

import java.util.logging.Logger;

import vazkii.craftingcreation.core.CommonProxy;
import vazkii.craftingcreation.lib.ModConstants;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = ModConstants.MOD_ID, name = ModConstants.MOD_NAME, version = ModConstants.VERSION)
@NetworkMod(clientSideRequired = true, channels = { ModConstants.NETWORK_CHANNEL })
public final class CraftingCreation {

	@Instance
	public static CraftingCreation instance;
	
	public static Logger logger;
	
	@SidedProxy(clientSide = ModConstants.CLIENT_PROXY, serverSide = ModConstants.COMMON_PROXY)
	public static CommonProxy proxy;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		instance = this;
		logger = event.getModLog();
		
		proxy.preInit(event);
	}
	
	@Init
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}
	
}