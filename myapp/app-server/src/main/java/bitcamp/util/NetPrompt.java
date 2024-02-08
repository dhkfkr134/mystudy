package bitcamp.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Date;

public class NetPrompt implements AutoCloseable {

  private DataInputStream in;
  private DataOutputStream out;
  private StringWriter stringWriter = new StringWriter();
  private PrintWriter writer = new PrintWriter(stringWriter);

  public NetPrompt(DataInputStream in, DataOutputStream out) {
    this.in = in;
    this.out = out;

  }

  public void print(String str) {
    writer.print(str);
  }

  public void println(String str) {
    writer.println(str);
  }

  public void printf(String str, Object... args) {
    writer.printf(str, args);
  }

  public void end() throws Exception{
    StringBuffer buf = stringWriter.getBuffer();
    String content = buf.toString();
    buf.setLength(0);

    out.writeUTF(content);
  }


  public String input() throws Exception {
    return in.readUTF();
  }

  public int inputInt() throws Exception {
    return Integer.parseInt(this.input());
  }

  public float inputFloat() throws Exception {
    return Float.parseFloat(this.input());
  }

  public boolean inputBoolean() throws Exception{
    return Boolean.parseBoolean(this.input());
  }

  public Date inputDate() throws Exception {
    return Date.valueOf(this.input());
  }

  public void close() throws Exception {
    writer.close();
    stringWriter.close();
  }
}
