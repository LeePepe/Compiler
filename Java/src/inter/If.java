package inter;
import symbols.*;

public class If extends Stmt {
    Expr expr;
    Stmt stmt;
    public If(Expr x, Stmt s) {
        expr = x;
        stmt = s;
        if (expr.type != Type.Bool) expr.error("Boolean required in if");
    }
    public void gen(int b, int a) { // 返回一个项，该项作为三地址指令右部
        int label = newlabel();
        expr.jumping(0, a);
        emitlabel(label);
        stmt.gen(label, a);
    }
}
