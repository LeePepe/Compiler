package inter;
import lexer.*;
import symbols.*;
/* 
tok作为运算符
null暂时占用type
二目运算符的类型通过Type.max，得到转换后的类型
不能转换则报告错误
*/   
public class Arith extends Op {
    public Expr expr1, expr2;
    public Arith(Token tok, Expr e1, Expr e2) {
	super(tok, null);
	expr1 = e1;
	expr2 = e2;
	type = Type.max(expr1.type, expr2.type);
	if (type == null) error("type error");
    }
    public Expr gen() {
	return new Arith(op, expr1.reduce(), expr2.reduce());
    }
    public String toString() {
	return expr1.toString() + " " + op.toString() + " " + expr2.toString();
    }

}
