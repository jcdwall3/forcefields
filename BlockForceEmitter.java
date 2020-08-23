package net.minecraft.src;

import java.util.Random;

import org.lwjgl.input.Keyboard;

public class BlockForceEmitter extends BlockContainer {
	
	int topTexture;
	String type;
	
    public BlockForceEmitter(int var1, int var2, Material var3, int var4, String type) {
        super(var1, var2, var3);
        this.topTexture = var4;
        this.type = type;
    }


    public void onBlockAdded(World var1, int var2, int var3, int var4) {
        super.onBlockAdded(var1, var2, var3, var4);
        if (var1.isBlockIndirectlyGettingPowered(var2, var3, var4)) {
        	TileEntityForceEmitter emitterEntity = (TileEntityForceEmitter)var1.getBlockTileEntity(var2, var3, var4);
	        emitterEntity.setActivated(true);
        }

    }

    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5) {
    	TileEntityForceEmitter emitterEntity = (TileEntityForceEmitter)var1.getBlockTileEntity(var2, var3, var4);
        if (var5 > 0 && Block.blocksList[var5].canProvidePower() && var1.isBlockIndirectlyGettingPowered(var2, var3, var4)) {
	        emitterEntity.setActivated(true);
        } else {
        	emitterEntity.setActivated(false);
        }

    }
    
    protected TileEntity getBlockEntity() {
        TileEntityForceEmitter emitterEntity = new TileEntityForceEmitter();
        emitterEntity.setType(type);
        return emitterEntity;
    }

    @Override
    public void onBlockRemoval(World var1, int var2, int var3, int var4) {
    	TileEntityForceEmitter emitterEntity = (TileEntityForceEmitter)var1.getBlockTileEntity(var2, var3, var4);
    	emitterEntity.deactivate();
    }
    

    public boolean blockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5) {
    	TileEntityForceEmitter emitterEntity = (TileEntityForceEmitter)var1.getBlockTileEntity(var2, var3, var4);
    	if (!Keyboard.isKeyDown(42)) {

    	} else {
    		GuiForceEmitter forceGui = new GuiForceEmitter();
    		forceGui.setEmitter(emitterEntity);
    		ModLoader.getMinecraftInstance().displayGuiScreen(forceGui);
    	}
    	return super.blockActivated(var1, var2, var3, var4, var5);
    }

    public int getBlockTextureFromSide(int var1) {
        if (var1 == 1) {
            return topTexture;
        } else {
            return this.blockIndexInTexture;
        }
    }

}
