package symbols;
import lexer.*;

public class Array extends Type {
    public Type of; // 数组类型
    public int size; // 数组大小
    public Array(int s, Type p) {
	super("[]", Tag.BASIC, s * p.width);
	size = s;
	of = p;
    }
    public toString() {
	return "[" + "]" + of.toString();
    }
}


