package inter;
import lexer.*;
import symbols.*;

public class Or extends Logical {
    public Or(Token tok, Expr e1, Expr e2) {
	super(tok, e1, e2);
    }
    public void jumping(int t, int f) {
	int label = t != 0 ? t : newlabel();
	expr1.jumping(label, 0);
	expr2.jumping(t, f);
	if (t == 0) emitlabel(label);
    }
}
