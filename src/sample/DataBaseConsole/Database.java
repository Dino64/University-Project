package sample.DataBaseConsole;

public interface Database extends AutoCloseable{
  void connect() throws Exception;
}