package service.declaration;

public interface Writer {
    void write(String input);

    String readWrittenInputs();

    void close();
}
