package net.minecraft.src;

import java.util.ArrayList;

public class TileEntityForceEmitter extends TileEntity {

	private boolean activated = false;
	private boolean hasPositions = false;
	private boolean removeMe = false;
	private boolean updateMe = false;
	private boolean initialized = false;
	private int height;
	private int width;
	private int length;
	private String type = "stable";
	private int fieldID = mod_Forcefields.BlockForcefield.blockID;
	
	private World theWorld;
	ArrayList<Vector3> fieldPositions = new ArrayList<>();
	
    public TileEntityForceEmitter() {
    	theWorld = ModLoader.getMinecraftInstance().theWorld;
    }
    
    public void setType(String type) {
    	this.type = type;
    	switch(this.type) {
    	case "stable":
    		fieldID = mod_Forcefields.BlockForcefield.blockID;
    		break;
    	case "unstable":
    		fieldID = mod_Forcefields.BlockForcefieldUnstable.blockID;
    		break;
    	case "antigravity":
    		fieldID = mod_Forcefields.BlockForcefieldAntigravity.blockID;
    		break;
    	case "caustic":
    		fieldID = mod_Forcefields.BlockForcefieldCaustic.blockID;
    		break;
    	}
    }

    public void writeToNBT(NBTTagCompound var1) {
        super.writeToNBT(var1);
        var1.setBoolean("activated", this.activated);
        var1.setBoolean("initialized", this.initialized);
        var1.setInteger("length", this.length);
        var1.setInteger("width", this.width);
        var1.setInteger("height", this.height);
        var1.setString("type", this.type);
    }
    
    public void readFromNBT(NBTTagCompound var1) {
        super.readFromNBT(var1);
        this.activated = var1.getBoolean("activated");
        this.initialized = var1.getBoolean("initialized");
        this.length = var1.getInteger("length");
        this.width = var1.getInteger("width");
        this.height = var1.getInteger("height");
        this.type = var1.getString("type");
        setType(this.type);
    }
    
    public void toggleActivated() {
    	ModLoader.getMinecraftInstance().theWorld.playSoundEffect(xCoord, yCoord, zCoord, "random.fizz", 0.1F, (1.0F + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2F) * 0.7F);
    	activated = !activated;
    	updateMe = true;
    }
    
    public void setActivated(boolean active) {
    	ModLoader.getMinecraftInstance().theWorld.playSoundEffect(xCoord, yCoord, zCoord, "random.fizz", 0.1F, (1.0F + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2F) * 0.7F);
    	activated = active;
    	updateMe = true;
    }

    public void deactivate() {
    	theWorld = ModLoader.getMinecraftInstance().theWorld;
    	activated = false;
    	clearPositions();
    }
    
    private void setPositions() {
    	fieldPositions.clear();
    	int worldI = -(int) Math.ceil(width/2);
    	int worldK = -(int) Math.ceil(length/2);
    	for (int k = 0; k < length; k ++) {
	    	for (int j = 0; j < height; j++) {
		    	for (int i = 0; i < width; i++) {
		    		 fieldPositions.add(new Vector3((xCoord)+worldI+i, yCoord+j+1, zCoord+worldK+k));
		    	}
	    	}
    	}
    	hasPositions = true;
    }
    
    public void fillPositions() {
    	
    	for (Vector3 pos : fieldPositions) {
    		if (theWorld.getBlockId(pos.x, pos.y, pos.z) == 0) {
    			double var9 = (double)((float)pos.x + this.worldObj.rand.nextFloat());
                double var11 = (double)((float)pos.y + this.worldObj.rand.nextFloat());
                double var13 = (double)((float)pos.z + this.worldObj.rand.nextFloat());
                this.worldObj.spawnParticle("portal", var9, var11, var13, 0, 0, 0);
                this.worldObj.spawnParticle("reddust", var9, var11, var13, 0, 0, 0);
        		theWorld.setBlockWithNotify(pos.x, pos.y, pos.z, fieldID);
        	}
    	}
    }
    
    public void clearPositions() {
    	for (Vector3 pos : fieldPositions) {
    		if (theWorld.getBlockId(pos.x, pos.y, pos.z) == fieldID) {
    			theWorld.setBlockWithNotify(pos.x, pos.y, pos.z, 0);
    		} 
    	}
    }
    
    public void updateEntity() {
    	
    	if (!initialized) {
    		length = 1;
    		width = 1;
    		height = 1;
    		initialized = true;
    	}
    	
    	if (hasPositions) {
    		if (updateMe) {
    			if (activated) {
    				fillPositions();
    			} else {
    				clearPositions();
    			}
    		updateMe = false;
    		}
	    } else {
	    	setPositions();
	    }
        super.updateEntity();
    }
    
    private void handleFieldAtPos(int x, int y, int z) {
    	if (removeMe == false ) {
	    	if (activated) {
	    		if (theWorld.getBlockId(x, y, z) == 0) {
	        		theWorld.setBlockWithNotify(x, y, z, fieldID);
	        	}
	    	} else {
	    		if (theWorld.getBlockId(x, y, z) == fieldID) {
	        		theWorld.setBlockWithNotify(x, y, z, 0);
	        	}
	    	}
    	}
    }

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public int getLength() {
		return length;
	}

	public void setHeight(int height) {
		this.height = height;
		resizeField();
	}

	public void setWidth(int width) {
		this.width = width;
		resizeField();
	}

	public void setLength(int length) {
		this.length = length;
		resizeField();
	}
	
	private void resizeField() {
		clearPositions();
		setPositions();
		fillPositions();
	}

    
    
    
}
