package data;

import java.io.Serializable;

import java.util.HashMap;

import javax.swing.ImageIcon;


public class ImageDB implements Serializable {
	public ImageIcon img;
	public ImageIcon dimg;    //   62 º¹ºÙ
	public ImageIcon mimg;
	
	public ImageDB(ImageIcon img,ImageIcon dimg,ImageIcon mimg) {
		this.img =img; this.dimg=dimg;this.mimg=mimg;
	}
}
