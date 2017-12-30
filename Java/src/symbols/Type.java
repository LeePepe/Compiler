package symbols;
import lexer.*;

public class Type extends Word {
    public int width; // 用于存储分配
    public Type(String s, int tag, int w) {
	super(s, tag);
	width = w;
    }

    public static final Type
	Int = new Type("int", Tag.BASIC, 4),
	Float = new Type("float", Tag.BASIC, 8),
	Char = new Type("char", Tag.BASIC, 1),
	Bool = new Type("bool", Tag.BASIC, 1);

    public static boolean numeric(Type p) {
	if (p == Type.Float || p == Type.Int || p == Type.Char) return true;
	else return false;
    }
    // 算术运算时 进行类型转换 向类型大的方向转
    public static Type max(Type a, Type b) {
	if (!numeric(a) || !numeric(b)) return null;
	else if (a == Type.Float || b == Type.Float) return Type.Float;
	else if (a == Type.Int || b == Type.Int) return Type.Int;
	else return Type.Char;
    }
}
