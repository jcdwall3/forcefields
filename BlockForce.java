package net.minecraft.src;

import java.util.Random;

public class BlockForce extends Block {
	
    public BlockForce(int var1, int var2, Material var3) {
        super(var1, var2, var3);
        this.setTickOnLoad(true);
    }
    
    public int getRenderBlockPass() {
        return 0;
    }
    
    public int quantityDropped(Random var1) {
        return 0;
    }

    public int idDropped(int var1, Random var2) {
        return 0;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    

}
