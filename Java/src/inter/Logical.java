package inter;
import lexer.*;
import symbols.*;

public class Logical extends Expr {
    public Expr expr1, expr2;
    Logical(Token tok, Expr e1, Expr e2) {
        super(tok, null);
        expr1 = e1;
        expr2 = e2;
        type = check(expr1.type, expr2.type);
        if (type == null) error("logical type error");
    }
    public Type check(Type e1, Type e2) {
        if (e1 == Type.Bool && e2 == Type.Bool) return Type.Bool;
        else return null;
    }
    public Expr gen() {
        int f = newlabel();
        int a = newlabel();
        Temp temp = new Temp(type);
        this.jumping(0, f);
        emit(temp.toString() + " = true");
        emit("goto L" + a);
        emitlabel(f);
        emit(temp.toString() + " = false");
        emitlabel(a);
        return temp;
    }
    public String toString() {
        return expr1.toString() + " " + op.toString() + " " + expr2.toString();
    }
}
