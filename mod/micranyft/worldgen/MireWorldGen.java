package mod.micranyft.worldgen;

import java.util.Random;

import com.micranyft.mod.MicranyftMod;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class MireWorldGen implements IWorldGenerator {
	
	public void generate(Random rand , int chunkX,int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
		switch(world.provider.dimensionId){
		case -1:
				generateNether(world, rand, chunkX , chunkZ );
		case 0:
				generateSurface(world, rand, chunkX , chunkZ );
		case 1:
				generateEnd(world, rand, chunkX , chunkZ);
		}
	}

	public void generateSurface(World world, Random rand, int X, int Z) {
			
		generateOre(MicranyftMod.mireOre, world, rand, X , Z , 1, 2, 6, 0 , 12, Blocks.stone);
	}

	public void generateNether(World world, Random rand, int chunkX, int chunkZ){
		
	}
	
	public void generateEnd(World world, Random rand, int chunkX, int chunkZ){
		
	}
	public void generateOre(Block block, World world, Random rand, int chunkX, int chunkZ, int minVienSize, int maxVienSize, int chance, int minY, int maxY, Block generateIn){
		int VienSize = minVienSize + rand.nextInt(maxVienSize - minVienSize);
		int heightRange = maxY - minY;
		WorldGenMinable gen= new WorldGenMinable(block,VienSize,generateIn);
		for(int i=0; i< chance ; i++)
		{
			int xRand = chunkX *16 + rand.nextInt(16);
			int yRand = rand.nextInt(heightRange)+ minY;
			int zRand = chunkZ * 16 + rand.nextInt(16);
			gen.generate(world, rand, xRand, yRand, zRand);
		}
	}

}
