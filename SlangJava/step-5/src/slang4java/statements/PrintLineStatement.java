package slang4java.statements;

import slang4java.context.RUNTIEM_CONTEXT;
import slang4java.expressions.Expression;
import slang4java.metainfo.SymbolInfo;
import slang4java.metainfo.TypeInfo;

public class PrintLineStatement extends Statement {

    private Expression _ex;

    public PrintLineStatement(Expression _ex) {
        this._ex = _ex;
    }

    @Override
    public SymbolInfo Execute(RUNTIEM_CONTEXT cont) {

        SymbolInfo val = null;
        try {
            val = _ex.Evaluate(cont);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (val.Type == TypeInfo.TYPE_NUMERIC){
            System.out.println(val.DoubleValue);
        }
        else if(val.Type == TypeInfo.TYPE_STRING){
            System.out.println(val.StringValue);
        }
        else {
            System.out.println(val.BoolValue);
        }

        return null;
    }
}