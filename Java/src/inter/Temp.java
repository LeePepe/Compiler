package inter;
import lexer.*;
import symbols.*;

public class Temp extends Expr {
    static int count = 0; // 多少个临时变量
    int number = 0; // 当前临时变量的编号
    public Temp(Type p) {
	super(Word.temp, p);
        number = ++count;
    }
    public String toString() {
        return "t" + number;
    }
}

