package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class GuiForceEmitter extends GuiScreen {
	public TileEntityForceEmitter emitterEntity;
	
	public void setEmitter(TileEntityForceEmitter emitterEntity) {
		this.emitterEntity = emitterEntity;
	}
	
    @SuppressWarnings("unchecked")
	public void initGui() {
        this.controlList.clear();
        
        this.controlList.add(new GuiButton(1, this.width / 2 - 100, 140, "Close"));
        
        GuiButton decreaseLength = new GuiButton(2, this.width / 2 - 100, 70, "-");
        decreaseLength.width = 32;
        this.controlList.add(decreaseLength);
        GuiButton increaseLength = new GuiButton(3, this.width / 2 + 100 - 32, 70, "+");
        increaseLength.width = 32;
        this.controlList.add(increaseLength);
        
        GuiButton decreaseWidth = new GuiButton(4, this.width / 2 - 100, 90, "-");
        decreaseWidth.width = 32;
        this.controlList.add(decreaseWidth);
        GuiButton increaseWidth = new GuiButton(5, this.width / 2 + 100 - 32, 90, "+");
        increaseWidth.width = 32;
        this.controlList.add(increaseWidth);
        
        GuiButton decreaseHeight = new GuiButton(6, this.width / 2 - 100, 110, "-");
        decreaseHeight.width = 32;
        this.controlList.add(decreaseHeight);
        GuiButton increaseHeight = new GuiButton(7, this.width / 2 + 100 - 32, 110, "+");
        increaseHeight.width = 32;
        this.controlList.add(increaseHeight);
        
        
        if (this.mc.session == null) {
            ((GuiButton)this.controlList.get(1)).enabled = false;
        }

    }

    protected void keyTyped(char var1, int var2) {
    }

    protected void actionPerformed(GuiButton var1) {
        if (var1.id == 0) {
        }

        if (var1.id == 1) {
            //this.mc.thePlayer.respawnPlayer();
            this.mc.displayGuiScreen((GuiScreen)null);
        }

        if (var1.id == 2) {
        	if (emitterEntity.getLength() != 1) {
        		emitterEntity.setLength(emitterEntity.getLength()-1);
        	}
        }
        
        if (var1.id == 3) {
        	emitterEntity.setLength(emitterEntity.getLength()+1);
        }
        
        if (var1.id == 4) {
        	if (emitterEntity.getWidth() != 1) {
        		emitterEntity.setWidth(emitterEntity.getWidth()-1);
        	}
        }
        
        if (var1.id == 5) {
        	emitterEntity.setWidth(emitterEntity.getWidth()+1);
        }
        
        if (var1.id == 6) {
        	if (emitterEntity.getHeight() != 1) {
        		emitterEntity.setHeight(emitterEntity.getHeight()-1);
        	}
        }
        
        if (var1.id == 7) {
        	emitterEntity.setHeight(emitterEntity.getHeight()+1);
        }

    }

    public void drawScreen(int var1, int var2, float var3) {
    	
    	this.drawDefaultBackground();
        //this.drawGradientRect(0, 0, this.width, this.height, 0, 0);
        GL11.glPushMatrix();
        //GL11.glScalef(2.0F, 2.0F, 2.0F);
        this.drawCenteredString(this.fontRenderer, "§cLength: §r" + emitterEntity.getLength(), this.width / 2, 80, 16777215);
        GL11.glPopMatrix();
        this.drawCenteredString(this.fontRenderer, "§aWidth: §r" + emitterEntity.getWidth(), this.width / 2, 100, 16777215);
        GL11.glPopMatrix();
        this.drawCenteredString(this.fontRenderer, "§bHeight: §r" + emitterEntity.getHeight(), this.width / 2, 120, 16777215);
        super.drawScreen(var1, var2, var3);
    }

    public boolean doesGuiPauseGame() {
        return true;
    }
}
