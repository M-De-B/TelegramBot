public class Code {

    public static String CodeCreate (int lenght){
        String symbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String pCode = "";
        int max = symbols.length()-1;

        for(int i = 0; i < lenght; ++i){
            int position =(int) Math.floor(Math.random() *max);
            pCode = pCode + symbols.substring(position,position+1);
        }
        return pCode;
    }
}
