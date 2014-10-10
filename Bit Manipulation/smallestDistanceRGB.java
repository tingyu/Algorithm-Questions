RGB = 0x1245A8

R’G’B’ 

distance = (r’-r)^2 + (g’-g)^2 + (b’-b)^2

R=0x12, R’=0x11 


r = 0xab (r = 0xfb or r=0x09)
0x(a-1)(a-1)
0x(a)(a)
0x(a+1)(a+1)

public static void main(String[] args) {
        int[] input = new int[3];
        input[0] = 0x12;
        input[1] = 0x45;
        input[2] = 0xA8;
        int[] res = distance(input);
        for (int a : res) {
            System.out.println(Integer.toHexString(a));
        }
    }

    public static int[] distance(int[] rgb) {
        int[] res = new int[3];
        for (int i = 0; i < 3; ++i) {
            int pix = rgb[i];
            int min = Integer.MAX_VALUE;
            int low_bit = (pix & 0xF0) >> 4;
            int element = getEle(low_bit);
            int tmp = (int) Math.pow((element - pix), 2);
            if (tmp < min) {
                min = tmp;
                res[i] = element;
            }
            element = getEle(low_bit + 1);
            tmp = (int) Math.pow((element - pix), 2);
            if (tmp < min) {
                min = tmp;
                res[i] = element;
            }
            element = getEle(low_bit - 1);
            tmp = (int) Math.pow((element - pix), 2);
            if (tmp < min) {
                min = tmp;
                res[i] = element;
            }
        }
        return res;
    }

    public static int getEle(int e) {
        return e << 4 | e;
    }

//a wrong one
public String smallestDistanceRGB(String rgb){
	rgb = rgb.substring(2);
	int[] num = new int[3];
	int[] res = new int[3];
	int[][] tmp = new int[3][3];
	for(int i = 0; i < 3; i++){
		num[i] = Integer.valueOf(rgb.substring(i*2, i+2));
		int t =  Integer.valueOf(rgb.substring(i*2, i+1);
		tmp[i][0] = 10*(t-1) + t-1;
		tmp[i][1] = 10*(t) + t;
		tmp[i][2] = 10*(t+1) + t+1;
}
	
	
	
	for(int i = 0; i < 3; i++){
int min = Integer.MAX_VALUE;
		for(int j = 0; j < 3; j++){
int t = (num[i] - tmp[i][j])*(num[i] - tmp[i][j]);
if(t < min){
		res[i] = tmp[i][j];
}
		}
}
return res;
}
