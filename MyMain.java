// Linear Prediction
// INPUT FILE ./data/values.txt
// Default Number of Tap Coefficients = 400

import java.io.*;
import java.util.ArrayList;

public class MyMain{
    public static void main(String args[]){
	int filnum = 0;
	int M = 400;
	double mu = 0.000001;
	double x_new;
	int k,k2;
	double h[] = new double [M];
	double h_temp[] = new double [M];
	double inx[] = new double [M];
	for(k=0;k<h.length;k++){
	    h[k] = 0;
	    h_temp[k] = 0;
	    inx[k] = 0;
	}
	try{
	    FileReader f = new FileReader("./data/values.txt");
	    BufferedReader b = new BufferedReader(f);
	    String s;
	    while((s = b.readLine())!=null){
		filnum++;
	    }
	}catch(Exception e){
	    System.out.println("Read Failed");
	}
	System.out.println("Total Lines : " + filnum);
	
	double x[] = new double [filnum];
	System.out.println("x : " + x.length);
	try{
	    FileReader f2 = new FileReader("./data/values.txt");
	    BufferedReader b2 = new BufferedReader(f2);
	    String s2;
	    int counter = 0;
	    while((s2 = b2.readLine())!=null){
		x[counter] = Double.valueOf(s2);
		counter++;
	    }
	}catch(Exception e){
	    System.out.println("Failed");
	}

	for(k=h.length;k<x.length-1;k++){
	    x_new = x[k+1];
	    for(k2=0;k2<h.length;k2++){
		inx[k2] = x[k-k2];
	    }
	    LinPred lps = new LinPred(M,inx,h,mu,x_new);
	    h_temp = lps.updateFilter(lps);
	    System.arraycopy(h_temp,0,h,0,h.length);
	}
    }
}
