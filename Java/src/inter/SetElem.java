package inter;
import lexer.*;
import symbols.*;

public class SetElem extends Stmt {
    public Id array;
    public Expr index;
    public Expr expr;
    public SetElem(Access a, Expr e) {
        array = a.array;
        index = a.index;
        expr = e;
        if (check(a.type, expr.type) == null) error("array type error");
    }
    public Type check(Type p1, Type p2) {
        if (p1 instanceof Array || p2 instanceof Array) return null;
        if (p1 == p2 || (Type.numeric(p1) && Type.numeric(p2))) return p2;
        return null;
    }
    public void gen(int b, int a) {
        String s1 = index.reduce().toString();
        String s2 = expr.reduce().toString();
        emit(array.toString() + " [ " + s1 + " ] = " + s2);
    }
}
