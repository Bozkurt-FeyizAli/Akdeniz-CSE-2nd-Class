import java.util.*;

public class a{
    public static void main(String[] args){
        HashSet<Integer[][]> a= ab();
        for (Integer[][] abc : a) {
            for (Integer[] c : abc) {
                System.out.println(c[0]+" "+c[1]);
            }
            System.out.println();
        }
    }

    public static HashSet<Integer[][]> ab(){
        HashSet<Integer[][]> result= new HashSet<>();
        int ea=15;
        int me=10;
        int h=0;
        final int ex=1;
        /*
         * while (ea<40) {
            int eaP=1;
            while (eaP<11) {
                
                 me=10;
            while (me<40) {
                int meP=1;
                while (meP<11) {
                    
                    h=0;
                while (h<6) {
                    int hP=1;
                    while (hP<11) {
                        
                    
                    if(ea+me+h+ex==40){
                        int exP=1;
                        while (exP<11) {
                            if((h*hP+eaP*ea+meP*me+ex*exP)==100){
                                if(ea>me&&me>h&&h>ex){
                                    if(exP>hP&&hP>meP&&meP>eaP){
                                        result.add(new Integer[][]{{ea, eaP}, {me, meP}, {h, hP},{ex, exP}});
                                    }
                                }
                            }
                            exP++;
                            if(exP==11)
                                break;
                        }


                    }
                    hP++;
                }
                h++;
                }
                meP++;
            }
            me++;
            }
            eaP++;
        }
        ea++;
        }
         */

        for (int i = ea; i < 40; i++) {
            int eaP=1;
            for (int j = eaP; j < 11; j++) {
                me=10;
                for (int j2 = me; j2 < 40; j2++) {
                    int meP=1;
                    for (int k = meP; k < 11; k++) {
                        h=0;
                        for (int k2 = h; k2<6; k2++) {
                            int hP=1;
                            for (int l = hP; l < 11; l++) {
                                if(i+j2+k2+ex==40){
                                    int exP=1;
                                    while (exP<11) {
                                        if((k2*l+j*i+k*j2+ex*exP)==100){
                                            if(i>j2&&j2>k2&&k2>ex){
                                                if(exP>l&&l>k&&k>j){
                                                    result.add(new Integer[][]{{i, j}, {j2, k}, {k2, l},{ex, exP}});
                                                }
                                            }
                                        }
                                        exP++;
                                        if(exP==11)
                                            break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}