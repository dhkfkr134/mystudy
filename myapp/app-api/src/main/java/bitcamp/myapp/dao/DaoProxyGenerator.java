package bitcamp.myapp.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.net.Socket;


public class DaoProxyGenerator {

  private String host;
  private int port;
  private Gson gson;

  public DaoProxyGenerator(String host, int port) {
    this.host = host;
    this.port = port;
    gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
  }

  @SuppressWarnings("unchecked")
  public <T> T create(Class<T> clazz, String dataName) {
    return (T) Proxy.newProxyInstance(
        DaoProxyGenerator.class.getClassLoader(),
        new Class<?>[]{clazz},
        (proxy, method, args) -> {
          try (Socket socket = new Socket(host,port);
              DataInputStream in = new DataInputStream(socket.getInputStream());
              DataOutputStream out = new DataOutputStream(socket.getOutputStream())
            ){
            //데이터 던지기
            out.writeUTF(dataName);
            out.writeUTF(method.getName());
            if (args == null) {
              out.writeUTF("");
            } else {
              out.writeUTF(gson.toJson(args[0]));
            }
            // 데이터 받기
            String statusCode = in.readUTF();
            String entity = in.readUTF();

            if (!statusCode.equals("200")) {
              throw new Exception(entity);
            }
            // 데이터 객체화 시키기
            Type returnType = method.getGenericReturnType();
            if (returnType == void.class) {
              return null;
            } else {
              return gson.fromJson(entity, returnType);
            }

          } catch (Exception e) {
            e.printStackTrace();
            throw new DaoException(e);
          }
        }
    );
  }
}
