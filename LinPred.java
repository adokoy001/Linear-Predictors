// Linear Predictor Core

import java.io.*;
public class LinPred{
    double inx[];
    double h[];
    double mu;
    double x_new;
    public LinPred(int TM,double in01[],double in02[], double in03, double in04){
	inx = new double [TM];
	h = new double [TM];
	System.arraycopy(in01,0,inx,0,in01.length);
	System.arraycopy(in02,0,h,0,in02.length);
	mu = in03;
	x_new = in04;
    }
    public double[] updateFilter(LinPred lps){
	int N = lps.inx.length;
	int M = lps.h.length;
	int k,k2;
	double error;
	double x_est = 0;
	double h_new[] = new double [M];
	for(k=0;k<M;k++){
	    x_est += lps.h[k] * lps.inx[k];
	}
	error = lps.x_new - x_est;
	System.out.println(error);
	for(k=0;k<M;k++){
	    h_new[k] = lps.h[k] + error*lps.mu*lps.inx[k];
	}
	return h_new;
    }
}
