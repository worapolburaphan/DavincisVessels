package io.github.elytra.davincisvessels.client.gui;

import io.github.elytra.davincisvessels.common.entity.EntityShip;
import io.github.elytra.davincisvessels.common.tileentity.TileEntityAnchorPoint;
import io.github.elytra.davincisvessels.common.tileentity.TileEntityEngine;
import io.github.elytra.davincisvessels.common.tileentity.TileEntityHelm;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class DavincisVesselsGuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te;
        switch (ID) {
            case 1:
                te = world.getTileEntity(pos);
                if (te instanceof TileEntityHelm) {
                    return new ContainerHelm((TileEntityHelm) te, player);
                }
                return null;
            case 2:
                if (player.getRidingEntity() instanceof EntityShip) {
                    EntityShip ship = (EntityShip) player.getRidingEntity();
                    return new ContainerShip(ship, player);
                }
                return null;
            case 3:
                te = world.getTileEntity(pos);
                if (te instanceof TileEntityEngine) {
                    return new ContainerEngine((TileEntityEngine) te, player);
                }
                return null;
            case 4:
                te = world.getTileEntity(pos);
                if (te instanceof TileEntityAnchorPoint) {
                    return new ContainerAnchorPoint((TileEntityAnchorPoint) te, player);
                }
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te;
        switch (ID) {
            case 1:
                te = world.getTileEntity(pos);
                if (te instanceof TileEntityHelm) {
                    return new GuiHelm((TileEntityHelm) te, player);
                }
            case 2:
                if (player.getRidingEntity() instanceof EntityShip) {
                    EntityShip ship = (EntityShip) player.getRidingEntity();
                    return new GuiShip(ship, player);
                }
            case 3:
                te = world.getTileEntity(pos);
                if (te instanceof TileEntityEngine) {
                    return new GuiEngine((TileEntityEngine) te, player);
                }
            case 4:
                te = world.getTileEntity(pos);
                if (te instanceof TileEntityAnchorPoint) {
                    return new GuiAnchorPoint((TileEntityAnchorPoint) te, player);
                }
            default:
                return null;
        }
    }
}