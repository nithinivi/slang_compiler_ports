package CallSlang;

import slang4java.complationUnits.TModule;
import slang4java.context.RUNTIEM_CONTEXT;
import slang4java.lexer.RDParser;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws Exception {
        byte[] b;
        try (InputStream stream = new FileInputStream(
            "/home/nithihn/learn/slang_compiler/SlangJava/step-7/src/CallSlang/scripts/functions.sl")) {
            b = new byte[stream.available()];
            int read = stream.read(b);
        }
        String program = new String(b);

        RDParser pars = null;
        pars = new RDParser(program);
        if (pars == null) {
            System.out.println("Parse process failed");
            return;
        }

        TModule module = pars.doParse();
        RUNTIEM_CONTEXT rtx = new RUNTIEM_CONTEXT(module);

        module.Execute(rtx, null);

    }
}


