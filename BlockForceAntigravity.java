package net.minecraft.src;

import java.util.Random;

public class BlockForceAntigravity extends BlockForce {
	
    public BlockForceAntigravity(int var1, int var2, Material var3) {
        super(var1, var2, var3);
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
        float var5 = 0.0625F;
        return AxisAlignedBB.getBoundingBoxFromPool((double)((float)var2 + var5), (double)var3, (double)((float)var4 + var5), (double)((float)(var2 + 1) - var5), (double)((float)(var3 + 1) - var5), (double)((float)(var4 + 1) - var5));
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
        float var5 = 0.0625F;
        return AxisAlignedBB.getBoundingBoxFromPool((double)((float)var2 + var5), (double)var3, (double)((float)var4 + var5), (double)((float)(var2 + 1) - var5), (double)(var3 + 1), (double)((float)(var4 + 1) - var5));
    }
    
    @Override
    public void onEntityCollidedWithBlock(World var1, int var2, int var3, int var4, Entity var5) {
    	 var5.motionY += 1.1D;
    }
    

}
