package mod.micranyft.entity;

import java.util.Random;




import com.micranyft.mod.MicranyftMod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityHandler {
	
	public static void registerEntities(Class entityClass, String name){
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		long x= name.hashCode();
		Random rand = new Random(x);
		int mainColor = rand.nextInt() * 16777215;
		int subColor = rand.nextInt() * 16777215;
		
		EntityRegistry.registerGlobalEntityID(entityClass, name, entityId);
		EntityRegistry.registerModEntity(entityClass, name, entityId, MicranyftMod.instance, 64, 1, true);
		EntityList.entityEggs.put(Integer.valueOf(entityId), new EntityList.EntityEggInfo(entityId, mainColor, subColor));
		
	}

}
