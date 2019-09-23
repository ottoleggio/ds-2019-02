package com.github.kyriosdata.exemplo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ClasseCriada extends FileInputStream {

    public ClasseCriada(String name) throws FileNotFoundException {
        super(name);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void close() throws IOException {
        // TODO Auto-generated method stub
        throw new RuntimeException("método close chamado");
    }

    

}
