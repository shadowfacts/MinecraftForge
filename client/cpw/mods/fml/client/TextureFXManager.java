package cpw.mods.fml.client;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderEngine;

public class TextureFXManager
{
    private static final TextureFXManager INSTANCE = new TextureFXManager();

    private Minecraft client;

    void setClient(Minecraft client)
    {
        this.client = client;
    }
    public BufferedImage loadImageFromTexturePack(RenderEngine renderEngine, String path) throws IOException
    {
        InputStream image=client.field_71418_C.func_77292_e().func_77532_a(path);
        if (image==null) {
            throw new RuntimeException(String.format("The requested image path %s is not found",path));
        }
        BufferedImage result=ImageIO.read(image);
        if (result==null)
        {
            throw new RuntimeException(String.format("The requested image path %s appears to be corrupted",path));
        }
        return result;
    }

    public static TextureFXManager instance()
    {
        return INSTANCE;
    }

}