package slang4java.statements;

import slang4java.context.RUNTIEM_CONTEXT;
import slang4java.expressions.Expression;
import slang4java.metainfo.SymbolInfo;
import slang4java.metainfo.TypeInfo;

import java.util.ArrayList;

public class WhileStatement extends Statement {

    private Expression condition;
    private ArrayList statementsList;

    public WhileStatement(Expression cond, ArrayList statementsList) {
        this.condition = cond;
        this.statementsList = statementsList;
    }


    @Override
    public SymbolInfo Execute(RUNTIEM_CONTEXT cont) throws Exception {
        while (true) {
            SymbolInfo evaluated_condition = condition.Evaluate(cont);
            if (evaluated_condition == null || evaluated_condition.Type == TypeInfo.TYPE_BOOL)
                return null;

            if (!evaluated_condition.BoolValue)
                return null;

            for (Object s : statementsList) {
                Statement statement = (Statement) s;
                SymbolInfo tsp = statement.Execute(cont);
                if (tsp != null)
                    return tsp;
            }
        }
    }
}