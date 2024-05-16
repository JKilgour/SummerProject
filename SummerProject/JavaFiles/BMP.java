// import java.io.*;
// import java.util.Arrays;
// public class BMP {
//     public static void readBMP(String filename) throws IOException{
//         FileInputStream fileInputStream = new FileInputStream(filename);
//         DataInputStream dataInputStream = new DataInputStream(fileInputStream);

//         byte[] header = new byte[54];
//         dataInputStream.read(header);

//         int width = byteArrayToInt(Arrays.copyOfRange(header, 18,22));
//         int height = byteArrayToInt(Arrays.copyOfRange(header, 22,26));

//         dataInputStream.close();
//         fileInputStream.close();
//     }
//     private static int byteArrayToInt(){

//     }
// }
