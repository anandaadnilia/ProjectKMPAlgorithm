/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Joel
 */
public class SearchWithKmp {

   void KMPSearch(String pat, String txt) {
       int M = pat.length();//panjang karakter untuk pattern
       int N = txt.length();//panjang karakter untuk text
       
       //Deklarasi lps
       int lps[] = new int[M];
       int j = 0; //index untuk pattern
       
       computeLPSArray(pat, M, lps);
       
       int i = 0; //index untuk text 
       while (i < N) {
           if (pat.charAt(j) == txt.charAt(i)) {
               j++;
               i++;
           }
           if (j == M) {
               System.out.println("Found pattern in text at index " + (i - j));
               j = lps[j - 1];
           }
           else 
               if (i < N && pat.charAt(j) != txt.charAt(i)) {
                   if (j != 0){
                   j = lps[j - 1];
               }
               else {
                   i = i + 1;
               }
               }
            }
       }
       
    void computeLPSArray(String pat, int M, int lps[]) {
       int len = 0;
       int i = 1;
       lps[0] = 0; //lps[0] akan selalu bernilai 0
       
       while (i < M) {
           if (pat.charAt(i) == pat.charAt(len)) {
               len++;
               lps[i] = len;
               i++;
           }
           else 
               if (len != 0) {
                   len = lps[len - 1];
                   i++;
               }
               else {
                   lps[i] = len; //Memberikan nilai len yaitu 0 ke lps[i] 
                   //dikarenakan tidak ada karakter yang sama
                   i++;
               }
       }
   }
    public static void main(String[] args) {
        // TODO code application logic here
        String txt = "THIS IS A TEST TEXT";
        String pat = "IS A";

	System.out.println("The text is : " + txt);
	System.out.println("The pattern is : " + pat);

        new SearchWithKmp().KMPSearch(pat, txt);
    }
    
}
