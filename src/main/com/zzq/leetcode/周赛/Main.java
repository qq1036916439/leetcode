package com.zzq.leetcode.周赛;

import java.util.Random;

public class Main {



	public static void main(String[] args) {
		//Scanner in = new Scanner(System.in);
		//int a = in.nextInt();
		//System.out.println(a);
		int[]  array=new int[]{1,3, 2, 2, 5, 4};
		quickSort(array,0,array.length-1);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]);
		}
	}

	public static void quickSort(int[] array,int left,int right){
		if(left<right){
			int pos =randomSort(array,left,right);
			quickSort(array,left,pos-1);
			quickSort(array,pos+1,right);
		}
	}
	public static int randomSort(int[] array,int left,int right){
		int po =new Random().nextInt(right-left+1)+left;
		swap(array,po,right);
		return patition(array,left,right);
	}

	public static int patition(int[] array,int left,int right){
		int index=left-1;
		int mid=array[right];
		for(int i=left;i<right;i++){
			if(array[i]<=mid){
				index++;
				swap(array,index,i);
			}
		}
		swap(array,index+1,right);
		return index+1;
	}

	public static void swap(int[] array,int i,int j){
		int tem=array[i];
		array[i]=array[j];
		array[j]=tem;
	}

}
