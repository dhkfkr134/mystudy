package bitcamp.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Date;
import java.util.Scanner;
import java.util.Stack;

public class Prompt implements AutoCloseable{

  Stack<String> breadcrumb = new Stack<>();

  private DataInputStream in;
  private DataOutputStream out;
  private StringWriter stringWriter = new StringWriter();
  private PrintWriter writer = new PrintWriter(stringWriter);

  public Prompt(DataInputStream in, DataOutputStream out){
    this.in = in;
    this.out = out;
  }

  public String input(String str, Object... args) {
    try {
      printf(str, args);
      end();
      return in.readUTF();
    } catch (Exception e){
      throw new RuntimeException(e);
    }
  }

  public int inputInt(String str, Object... args) {
    return Integer.parseInt(this.input(str,args));
  }

  public float inputFloat(String str, Object... args){
    return Float.parseFloat(this.input(str,args));
  }

  public boolean inputBoolean(String str, Object... args){
    return Boolean.parseBoolean(this.input(str,args));
  }

  public Date inputDate(String str, Object... args) {
    return Date.valueOf(this.input(str,args));
  }

// ---------------------------------------------

  public void print(String str) {
    writer.print(str);
  }

  public void println(String str) {
    writer.println(str);
  }

  public void printf(String str, Object... args) {
    writer.printf(str, args);
  }

  public void end() throws Exception {
    StringBuffer buf = stringWriter.getBuffer();
    String content = buf.toString();
    buf.setLength(0);

    out.writeUTF(content);
  }

  public void pushPath(String path){
    breadcrumb.push(path);
  }

  public String popPath(String path){
    return breadcrumb.pop();
  }

  public void close() throws Exception{
    writer.close();
    stringWriter.close();
  }

  public String getFullPath() {
    return String.join("/", breadcrumb.toArray(new String[0]));
  }
}
