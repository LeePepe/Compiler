package inter;
import symbols.*;

public class Do extends Stmt {
    Expr expr;
    Stmt stmt;
    public Do() {
        expr = null;
        stmt = null;
    }
    public void init(Stmt s, Expr e) {
        expr = e;
        stmt = s;
        if (expr.type != Type.Bool) expr.error("Boolean required in do-while");
    }
    public void gen(int b, int a) {
        after = a;
        int label = newlabel(); // expr标号
        stmt.gen(b, label);
        emitlabel(label);
        expr.jumping(b, 0);
    }
}

