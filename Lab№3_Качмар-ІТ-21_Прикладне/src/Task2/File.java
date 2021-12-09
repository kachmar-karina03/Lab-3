package Task2;

import java.io.IOException;

public class File implements AutoCloseable{
    public void read() throws IOException {
        if(true){
            throw new IOException();
        }
    }

    @Override
    public void close()  {
        System.out.println("closed");
    }
}