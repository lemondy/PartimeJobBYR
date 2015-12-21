package cn.edu.bit.lemondy.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by lemon on 12-21.
 * @description: this class is used to customize my own xml file format.
 *               It looks like:
 *               <post>
 *                   <title>something for title</title>
 *                   <time>represent the time that the post be published</time>
 *               </post>
 *
 */
public class XMLUtils {

    /**
     * check if the file exists, if it not exists,then create it and initialize file object.
     * if it exists, just initialize the file object.
     * Attention: this class not assure that the filepath is correct, so the outer call must
     * assure the filepath is correct.
     * @param filePath
     */
    private File xmlFile;
    private BufferedReader bufReader = null;
    private BufferedWriter bufWriter = null;

    private static final String headString = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";

    public XMLUtils(String filePath){
        this.xmlFile = new File(filePath);
        if(!xmlFile.exists()){   //if this is the first time, then create the file.

            try {
                xmlFile.createNewFile();
                writeHead();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //write head tag
    private void writeHead() throws IOException{

        bufWriter = new BufferedWriter(new FileWriter(xmlFile,true));   //FileWriter the second parameter represents that the file's content will be appended when write something.
        bufWriter.write(headString);
        bufWriter.newLine();
        closeIO();
    }

    public void writeItem(String title,String time) throws IOException{
        bufWriter = new BufferedWriter(new FileWriter(xmlFile,true));
        bufWriter.write("<post>\n");
        bufWriter.write("\t<title>"+title+"</title>\n");
        bufWriter.write("\t<time>"+time+"</time>\n");
        bufWriter.write("</post>");
        bufWriter.write("\n\n");
        closeIO();
    }

    public void closeIO(){
        try{
            if(bufReader != null)
                bufReader.close();
            if(bufWriter != null)
                bufWriter.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
