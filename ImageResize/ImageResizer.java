import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import javax.imageio.ImageIO;

public class ImageResizer{
    public String doResize(File target,int width,int height)throws IOException{
        BufferedImage source = ImageIO.read(target);
        BigDecimal bdw = new BigDecimal(width);
        bdw = bdw.divide(new BigDecimal(source.getWidth()),8,BigDecimal.ROUND_HALF_UP);
        BigDecimal bdh = new BigDecimal(height);
        bdh = bdh.divide(new BigDecimal(source.getHeight()),8,BigDecimal.ROUND_HALF_UP);
        
        if(bdh.compareTo(bdw) < 0){
            width = -1;
        }else{
            height = -1;
        }
        
        Image image = source.getScaledInstance(width,height,Image.SCALE_AREA_AVERAGING);
        
        BufferedImage targetBI = new BufferedImage(image.getWidth(null),image.getHeight(null),BufferedImage.TYPE_INT_RGB);
        Graphics2D graphic = targetBI.createGraphics();
        
        graphic.drawImage(image,0,0,null);
        
        String inputPath = target.getName();
        String ext = inputPath.substring(inputPath.lastIndexOf(".") + 1);
        ImageIO.write(targetBI, ext, new File("resize_"+inputPath));
        
        return "resize_"+inputPath;
    }
}