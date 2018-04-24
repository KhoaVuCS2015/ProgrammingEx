package programmingExercise;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import android.graphics.Bitmap;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.oned.Code128Reader;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.OneDimensionalCodeWriter;

import org.bytedeco.javacv.*;
import static org.bytedeco.javacpp.opencv_core.IplImage;
import static org.bytedeco.javacpp.opencv_core.cvFlip;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvSaveImage;

public class BarcodeGenerator {
	String path;
	public BarcodeGenerator(String path1) {
		path=path1;
	}
	
	public void generateBarcode() throws WriterException, IOException {
		BufferedImage bufferedImage;
		OneDimensionalCodeWriter oneDimensionalCodeWriter = new Code128Writer();
		int cont=2;
		
		do{
			String s1 = JOptionPane.showInputDialog("input an integer :");
		BitMatrix bitMatrix = oneDimensionalCodeWriter.encode(s1,BarcodeFormat.CODE_128,256,128);
		bufferedImage=MatrixToImageWriter.toBufferedImage(bitMatrix);
		File outputfile = new File(path+"generatedBarcode.jpg");
		ImageIO.write(bufferedImage, "jpg", outputfile);
		int t=Integer.parseInt(JOptionPane.showInputDialog("continue(1) ?:"));
		if (t==1){
			cont=1;
		}
		else {cont=2;}
		}while (cont==1);
	}
	
