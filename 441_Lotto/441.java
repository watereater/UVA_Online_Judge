import java.io.*;
import java.util.*;

class Main{
    static int list [], masks [] = new int[15], ormasks []= new int[15];
    static int inputs;
    static void create_masks(){
        for(int i = 1; i < 15; i++){
            int next = 1 << (i-1);
            masks[i] = next;
            ormasks[i] |= ormasks[i-1] | next;
        }
    }
    static int next_permutation(int c){
        int zeros = 0, push = 0;
        for(int i = 0; i < inputs+1; i++){
            if((c&1)==1){
                if((c&2)==2){
                   zeros++;
                }
                else{
                    c >>= 1;
                    c <<= 1;
                    c |= 2;
                    break;
                }
            }
            push++;
            c >>= 1;
        }
        c <<= push;
        c |= ormasks[zeros];
        return c;
    }

public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();
        create_masks();
        boolean newLine = false;
        while((line = br.readLine())!=null){
            StringTokenizer stok = new StringTokenizer(line);
            inputs = Integer.parseInt(stok.nextToken());
            if(inputs == 0) break;
            if(newLine) sb.append('\n');
            newLine = true;
            list = new int[inputs];
            for(int i = 0; i < inputs; i++){
                list[i] = Integer.parseInt(stok.nextToken());               
            }
            int start = ormasks[inputs - 6], end = masks[inputs+1];
            while(start < end){
                //System.out.println(Integer.toBinaryString(start));
                boolean first = false;
                for(int i = inputs, j = 0; i >= 1; i--, j++){
                    if((masks[i] & start) == 0){
                        if(first) sb.append(' ');
                        first = true;
                        sb.append(list[j]);
                    }
                }
                start = next_permutation(start);
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }// main
}