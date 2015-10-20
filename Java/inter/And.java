package inter;
import lexer.*;
import symbols.*;
public class And extends Logical {
    public And(Token tok, Expr e1, Expr e2) {
	super(tok, e1, e2);
    }
    public void jumping(itn t, int f) {
	int label = f != 0 ? f : newlabel();
	expr1.jumping(0, label);
	expr2.jumping(t, f);
	if (f == 0) emitlabel(label);
    }
}
