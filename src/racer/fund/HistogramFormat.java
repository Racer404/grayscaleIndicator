package racer.fund;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

public class HistogramFormat {
	
	int[] grayScale;
	int[] histogram;

	public HistogramFormat(BufferedImage bImage) {
		// TODO Auto-generated constructor stub
		int width = bImage.getWidth();
		int height = bImage.getHeight();
		byte[] data = ((DataBufferByte)bImage.getRaster().getDataBuffer()).getData();
				
		grayScale = new int[width*height];
		int loops=0;
		double xAxisScaleRatio = 255.0/Main.MAX_CANVAS_WIDTH;
		for(int i=0;i<data.length;i=i+3) {
			grayScale[loops]=(int) ((Byte.toUnsignedInt(data[i])+Byte.toUnsignedInt(data[i+1])+Byte.toUnsignedInt(data[i+2]))/3/xAxisScaleRatio);
			loops++;
		}
	}
	
	public int[] getHistogram() {
		// TODO Auto-generated method stub
		int highestValue=0;
		int[] histogram = new int[Main.MAX_CANVAS_WIDTH];
		for(int i=0;i<histogram.length;i++) {
			for(int j=0;j<grayScale.length;j++) {
				if(grayScale[j]==i){
					histogram[i]++;
				}
			}
			if(histogram[i]>highestValue) {
				highestValue = histogram[i];
			}
		}
		double yAxisScaleRatio = (double)Main.MAX_CANVAS_HEIGHT/highestValue;
		for(int i=0;i<histogram.length;i++) {
			histogram[i]=(int) (histogram[i]*yAxisScaleRatio);
			
		}
		
		return histogram;
	}
}
