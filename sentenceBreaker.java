import java.io.*;

public class sentenceBreaker {
    public String sentenceBreaker(String filename) throws IOException {
        PrintWriter file = null;
        file = new PrintWriter(new BufferedWriter(new  FileWriter("D:/NLP/VW/src/"+filename+"sentences")));
        //  file.close();


        InputStream inputFile = getClass().getResourceAsStream(filename);
        BufferedReader readFile = new BufferedReader(new InputStreamReader(inputFile));
        String temp ="";
        String file_line;

        try {
            int count = 0;
            while ((file_line = readFile.readLine()) != null) {

                temp=file_line;
                //  temp=temp.replace("\u200C"," ");
                String[] sentences = file_line.split("(?<=[.!?])\\s*");
                for(int i =0 ; i< sentences.length ; i++){
                    System.out.println(sentences[i]);}
                for(int i=0; i < sentences.length; i++){
                    //   sentences[i] = sentences[i].replaceAll(" ", "");
                    file.println(sentences[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();

        }

        file.close();
        return  filename+"sentences";

    }

    //test of file splitter is here
     public static void main(String[] args) throws IOException {
        sentenceBreaker w = new sentenceBreaker();
      String s =  w.sentenceBreaker("fekr");
         String s2 =  w.sentenceBreaker("eshgh");
System.out.print(s);
    }

}


