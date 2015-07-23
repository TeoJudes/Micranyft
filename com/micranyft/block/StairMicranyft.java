package com.micranyft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class StairMicranyft extends BlockStairs
{
	public StairMicranyft(Block blocktype, int metadata)
	{
		super(blocktype, metadata);
		this.setLightOpacity(255);
	}
	public boolean isOpaqueCube() {
		return false;
	}
	
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    public int getRenderType()
    {
        return 10;
    }

}