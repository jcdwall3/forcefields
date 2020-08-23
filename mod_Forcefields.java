package net.minecraft.src;

import net.minecraft.client.Minecraft;
import java.io.File;

public class mod_Forcefields extends BaseMod {

	public static Item ForceGem = (new Item(6000)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Forcefields/forceGem.png")).setItemName("ForceGem");
	public static Item NeodymiumPlate = (new Item(6001)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Forcefields/neodymiumPlate.png")).setItemName("NeodymiumPlate");
	public static Item ForceCoil = (new Item(6002)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Forcefields/forceCoil.png")).setItemName("ForceCoil");
	public static Item SodiumHydroxide = (new Item(6003)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Forcefields/sodiumHydroxide.png")).setItemName("SodiumHydroxide");
	public static Item SodiumHydroxideCell = (new Item(6004)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Forcefields/sodiumHydroxideCell.png")).setItemName("SodiumHydroxideCell");

	static int emitterTopStable = ModLoader.addOverride("/terrain.png", "/Forcefields/blockForcefieldEmitter.png");
	static int emitterTopUnstable = ModLoader.addOverride("/terrain.png", "/Forcefields/blockForcefieldEmitterUnstable.png");
	static int emitterTopAntigravity = ModLoader.addOverride("/terrain.png", "/Forcefields/blockForcefieldEmitterAntigravity.png");
	static int emitterTopCaustic = ModLoader.addOverride("/terrain.png", "/Forcefields/blockForcefieldEmitterCaustic.png");
	static int emitterSide = ModLoader.addOverride("/terrain.png", "/Forcefields/blockForcefieldEmitterSide.png");
	
	public static final BlockForce BlockForcefield = (BlockForce) (new BlockForce(101,
			ModLoader.addOverride("/terrain.png", "/Forcefields/blockForcefield.png"), Material.rock).setHardness(2.0F)
					.setBlockUnbreakable().setResistance(6000000.0F).setStepSound(Block.soundStoneFootstep)
					.setBlockName("BlockForcefield"));
	public static final BlockForce BlockForcefieldUnstable = (BlockForce) (new BlockForce(103,
			ModLoader.addOverride("/terrain.png", "/Forcefields/blockForcefieldUnstable.png"), Material.rock).setHardness(0.2F)
				.setStepSound(Block.soundStoneFootstep)
				.setBlockName("BlockForcefieldUnstable"));
	public static final BlockForce BlockForcefieldAntigravity = (BlockForceAntigravity) (new BlockForceAntigravity(105,
			ModLoader.addOverride("/terrain.png", "/Forcefields/blockForcefieldAntigravity.png"), Material.rock).setHardness(2.0F)
			.setBlockUnbreakable().setResistance(6000000.0F).setStepSound(Block.soundStoneFootstep)
			.setBlockName("BlockForcefieldAntigravity"));
	public static final BlockForce BlockForcefieldCaustic = (BlockForceCaustic) (new BlockForceCaustic(107,
			ModLoader.addOverride("/terrain.png", "/Forcefields/blockForcefieldCaustic.png"), Material.rock).setHardness(2.0F)
			.setBlockUnbreakable().setResistance(6000000.0F).setLightValue(1.0F).setStepSound(Block.soundStoneFootstep)
			.setBlockName("BlockForcefieldCaustic"));
	public static final BlockForceEmitter BlockForcefieldEmitter = (BlockForceEmitter) (new BlockForceEmitter(102,
			emitterSide, Material.iron, emitterTopStable, "stable")
					.setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setBlockName("BlockForcefieldEmitter"));
	public static final BlockForceEmitter BlockForcefieldEmitterUnstable = (BlockForceEmitter) (new BlockForceEmitter(104,
			emitterSide, Material.iron, emitterTopUnstable, "unstable")
			.setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setBlockName("BlockForcefieldEmitterUnstable"));
	public static final BlockForceEmitter BlockForcefieldEmitterAntigravity = (BlockForceEmitter) (new BlockForceEmitter(106,
			emitterSide, Material.iron, emitterTopAntigravity, "antigravity")
			.setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setBlockName("BlockForcefieldEmitterAntigravity"));
	public static final BlockForceEmitter BlockForcefieldEmitterCaustic = (BlockForceEmitter) (new BlockForceEmitter(108,
			emitterSide, Material.iron, emitterTopCaustic, "caustic")
			.setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setBlockName("BlockForcefieldEmitterCaustic"));

	
	
	public String Version() {
		return "Forcefields v1.0";
	}

	public Minecraft getMinecraftInstance() {
		Minecraft mc = ModLoader.getMinecraftInstance();
		return mc;
	}

	public mod_Forcefields() {
		
		ModLoader.AddName(ForceGem, "§5Crystalized Deuterium");
		ModLoader.AddName(NeodymiumPlate, "§eNeodymium Plating");
		ModLoader.AddName(ForceCoil, "§bDeuterium Propellant Coil");
		ModLoader.AddName(SodiumHydroxide, "§aSodium Hydroxide (NaOH)");
		ModLoader.AddName(SodiumHydroxideCell, "§aSodium Hydroxide Cell");
		
		ModLoader.RegisterBlock(BlockForcefield);
		ModLoader.RegisterBlock(BlockForcefieldEmitter);
		ModLoader.RegisterBlock(BlockForcefieldUnstable);
		ModLoader.RegisterBlock(BlockForcefieldEmitterUnstable);
		ModLoader.RegisterBlock(BlockForcefieldAntigravity);
		ModLoader.RegisterBlock(BlockForcefieldEmitterAntigravity);
		ModLoader.RegisterBlock(BlockForcefieldCaustic);
		ModLoader.RegisterBlock(BlockForcefieldEmitterCaustic);

		ModLoader.AddName(BlockForcefield, "Forcefield");
		ModLoader.AddName(BlockForcefieldEmitter, "§bForcefield Emitter");
		ModLoader.AddName(BlockForcefieldUnstable, "Unstable Forcefield");
		ModLoader.AddName(BlockForcefieldEmitterUnstable, "§eUnstable Forcefield Emitter");
		ModLoader.AddName(BlockForcefieldAntigravity, "Antigravity Forcefield");
		ModLoader.AddName(BlockForcefieldEmitterAntigravity, "§3Antigravity Forcefield Emitter");
		ModLoader.AddName(BlockForcefieldCaustic, "Caustic Forcefield");
		ModLoader.AddName(BlockForcefieldEmitterCaustic, "§4Caustic Forcefield Emitter");

		ModLoader.RegisterTileEntity(TileEntityForceEmitter.class, "ForceEmitter");


		ModLoader.AddShapelessRecipe(new ItemStack(ForceGem, 1), new Object[] { new ItemStack(Item.dyePowder, 1, 4), Item.redstone, Item.diamond });
		ModLoader.AddShapelessRecipe(new ItemStack(NeodymiumPlate, 1), new Object[] { Block.blockSteel, Item.redstone, Item.coal });
		ModLoader.AddShapelessRecipe(new ItemStack(ForceCoil, 1), new Object[] { ForceGem, Item.redstone, Item.redstone, Item.redstone, Item.redstone, Item.redstone, Item.redstone, Item.redstone, Item.redstone, });
		ModLoader.AddShapelessRecipe(new ItemStack(SodiumHydroxide, 1), new Object[] { new ItemStack(Item.dyePowder, 1, 15), Item.redstone, Item.bucketLava, Item.bucketLava, Block.sand, Block.sand, Block.sand});
		ModLoader.AddShapelessRecipe(new ItemStack(SodiumHydroxideCell, 1), new Object[] { SodiumHydroxide, Item.ingotIron, Item.redstone, Item.ingotGold});
		
		ModLoader.AddRecipe(new ItemStack(BlockForcefieldEmitterUnstable, 1), new Object[] {"RIR", "RGR", "RIR", Character.valueOf('G'), ForceGem, Character.valueOf('R'), Item.redstone, Character.valueOf('I'), Block.blockSteel});
		ModLoader.AddRecipe(new ItemStack(BlockForcefieldEmitter, 1), new Object[] {"RIR", "RGR", "RIR", Character.valueOf('G'), ForceGem, Character.valueOf('R'), Item.lightStoneDust, Character.valueOf('I'), NeodymiumPlate});
		ModLoader.AddRecipe(new ItemStack(BlockForcefieldEmitterAntigravity, 1), new Object[] {"RIR", "RGR", "RIR", Character.valueOf('G'), ForceGem, Character.valueOf('R'), ForceCoil, Character.valueOf('I'), NeodymiumPlate});
		ModLoader.AddRecipe(new ItemStack(BlockForcefieldEmitterCaustic, 1), new Object[] {"RIR", "RGR", "RIR", Character.valueOf('G'), ForceGem, Character.valueOf('R'), SodiumHydroxideCell, Character.valueOf('I'), NeodymiumPlate});

	}

}