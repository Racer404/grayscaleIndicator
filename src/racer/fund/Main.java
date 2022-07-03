package racer.fund;

import java.awt.image.BufferedImage;

import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;


public class Main {

	static int MAX_CANVAS_WIDTH = 140;
	static int MAX_CANVAS_HEIGHT = 40;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Welcome! Please make sure your DOS on FULL WINDOW!");
		System.out.println("Please enter the Image file name that you placed as the same folder as this JAR programme, e.g cat.jpg");
		String input=new Scanner(System.in).nextLine();

		BufferedImage bImage=ImageIO.read(new File("./"+input));
		HistogramFormat hFormat = new HistogramFormat(bImage);
		
		int[] histogram=hFormat.getHistogram();

		//RENDER PART
		for(int i=MAX_CANVAS_HEIGHT;i>0;i--) {
			for(int j=0;j<histogram.length;j++) {
				if(histogram[j]>=i){
					System.out.print("#");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
			Thread.sleep(50);
		}
		
		System.out.print("0");
		for(int i=0;i<MAX_CANVAS_WIDTH/2-6;i++) {
			System.out.print("-");
		}
		System.out.print("GRAYSCALE");
		for(int i=0;i<MAX_CANVAS_WIDTH/2-7;i++) {
			System.out.print("-");
		}
		System.out.print("255");	
		
		System.out.println();
		System.out.println("Made by raceR.404, Thanks for using!");

		System.in.read();
	}

}
