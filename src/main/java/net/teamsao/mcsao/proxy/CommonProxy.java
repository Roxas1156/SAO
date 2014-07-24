package net.teamsao.mcsao.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraftforge.common.DimensionManager;
import net.teamsao.mcsao.lib.DimensionId;
import net.teamsao.mcsao.dimension.SAOWorldProvider;
import net.teamsao.mcsao.entity.*;
import net.teamsao.mcsao.model.KoboldTest;
import net.teamsao.mcsao.model.boar;

/*
    ANY Methods you add here from the Sproxy class will not be needed in Client/Server proxy Classes.
    Only Override these methods IF you need to make a special change to the Client but no the server.
    Registering the Dimension here will tell the Minecraft that It needs to be applied to Both Client and Server
    If its rendering or a config related registration, it will go in either Client or Server depending on
    What the purpose of the Class is.
 */

public abstract class CommonProxy implements SProxy {


    public void registerTileEntities()
    {}



	public void registerGlobalEntity()
    {
        EntityRegistry.registerGlobalEntityID(EntityKoboldTest.class, "KoboldTest", EntityRegistry.findGlobalUniqueEntityId(), EntitySAO.redColor, EntitySAO.orangeColor);
        EntityRegistry.registerGlobalEntityID(EntityBoar.class, "Boar", EntityRegistry.findGlobalUniqueEntityId(), EntitySAO.redColor, EntitySAO.blueColor);
	}


    public void registerDimension() {
        DimensionManager.registerProviderType(DimensionId.SAO_DIMENSION_ID, SAOWorldProvider.class, false);
        DimensionManager.registerDimension(DimensionId.SAO_DIMENSION_ID, DimensionId.SAO_DIMENSION_ID);
    }
}
