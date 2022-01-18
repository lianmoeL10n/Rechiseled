package com.supermartijn642.rechiseled.data;

import com.supermartijn642.rechiseled.RechiseledBlockType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

import static com.supermartijn642.rechiseled.RechiseledBlockType.BlockOption.*;

/**
 * Created 21/12/2021 by SuperMartijn642
 */
public class RechiseledBlockModelProvider extends ModelProvider<RechiseledBlockModelBuilder> {

    public RechiseledBlockModelProvider(GatherDataEvent e){
        super(e.getGenerator(), "rechiseled", BLOCK_FOLDER, RechiseledBlockModelBuilder::new, e.getExistingFileHelper());
    }

    @Override
    protected void registerModels(){
        for(RechiseledBlockType type : RechiseledBlockType.values()){
            if(type.regularBlockMode == NORMAL)
                this.cubeAll("block/" + type.regularRegistryName, new ResourceLocation("rechiseled", "block/" + type.regularRegistryName));
            else if(type.regularBlockMode == NON_CONNECTING)
                this.regularCubeAll("block/" + type.regularRegistryName, new ResourceLocation("rechiseled", "block/" + type.regularRegistryName));
            else if(type.regularBlockMode == CONNECTING)
                this.connectingCubeAll("block/" + type.regularRegistryName, new ResourceLocation("rechiseled", "block/" + type.regularRegistryName));

            if(type.connectingBlockMode == NORMAL)
                this.cubeAll("block/" + type.connectingRegistryName, new ResourceLocation("rechiseled", "block/" + type.regularRegistryName));
            else if(type.connectingBlockMode == NON_CONNECTING)
                this.regularCubeAll("block/" + type.connectingRegistryName, new ResourceLocation("rechiseled", "block/" + type.regularRegistryName));
            else if(type.connectingBlockMode == CONNECTING)
                this.connectingCubeAll("block/" + type.connectingRegistryName, new ResourceLocation("rechiseled", "block/" + type.regularRegistryName));
        }
    }

    public RechiseledBlockModelBuilder regularCubeAll(String name, ResourceLocation texture){
        return this.singleTexture(name, new ResourceLocation("rechiseled", "block/connecting_cube_all"), "all", texture);
    }

    public RechiseledBlockModelBuilder connectingCubeAll(String name, ResourceLocation texture){
        return this.singleTexture(name, new ResourceLocation("rechiseled", "block/connecting_cube_all"), "all", texture)
            .connectToOtherBlocks();
    }

    @Override
    public String getName(){
        return "Rechiseled Connecting Block Models";
    }
}