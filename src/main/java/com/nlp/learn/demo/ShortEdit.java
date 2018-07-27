package com.nlp.learn.demo;

import java.util.Scanner;

/**
 * Created by wei.wang on 2018/7/27 0027.
 * 最短编辑距离
 */
public class ShortEdit {

    private int min(int x,int y){
        return x<y?x:y;
    }

    private void minDistance(char[] a,char[] b){
        int la=a.length;
        int lb=b.length;
		/*要对串a为0，串b部位0;串b为0,串a不为0;串a，串b同时为0这三种情况进行判断，
		 * 所以d[][]的行值须是la+1,列值须是lb+1
		 */
        int[][] d=new int[la+1][lb+1];
        int i,j;

        d[0][0]=0;
        for(i=1;i<=la;i++)//串b为空
            d[i][0]=i;
        for(j=1;j<=lb;j++)//串a为空
            d[0][j]=j;

        for(i=1;i<=la;i++){
            for(j=1;j<=lb;j++){
                if(a[i-1]==b[j-1])//a[]中的第i个字符的下标是i-1,b[]中的第j个字符的下标是j-1
                    d[i][j]=d[i-1][j-1];
                else
                    //d[i][j]取在a[]中插入一个字符，删除一个字符，替换一个字符的最小值
                    d[i][j]=min(min(d[i][j-1]+1,d[i-1][j]+1),d[i-1][j-1]+1);
            }
        }
        System.out.println(d[la][lb]);
    }


    public static void main(String[] args){
        System.out.println("请输入两行字符串:");
        Scanner read=new Scanner(System.in);

        String s1=read.nextLine();
        String s2=read.nextLine();
        char[] a=s1.toCharArray();
        char[] b=s2.toCharArray();
        ShortEdit shortEdit = new ShortEdit();
        shortEdit.minDistance(a,b);
    }

}
