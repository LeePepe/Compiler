package lexer;
import java.io.*;
import java.util.*;
import symbols.*;

public class Lexer {
    public static int line = 1; // 代码行数
    char peek = ' ';
    Hashtable words = new Hashtable();
    void reserve(Word w) {
	words.put(w.lexeme, w);
    }

    public Lexer() {
	reserve(new Word("if", Tag.IF));
	reserve(new Word("else", Tag.ELSE));
	reserve(new Word("while", Tag.WHILE));
	reserve(new Word("do", Tag.DO));
	reserve(new Word("break", Tag.BREAK));
	reserve(Word.True);	reserve(Word.False);
	reserve(Type.Int);	reserve(Type.Char);
	reserve(Type.Bool);	reserve(Type.Float);
    }
    // 读入下一个字符到peek
    void readch() throw IOExeption {
	peek = System.in.read();
    }
    // 检测下一个字符是否是参数给出的字符
    boolean readch(char c) throw IOExeption {
	readch();
	if (peek != c) return false;
	peek = ' ';
	return true;
    }
    
    public Token scan() throws IOExeption {
	// 忽略空格和tab，换行line+1
	for ( ; ; readch()) {
	    if (peek == ' ' || peek == '\t') continue;
	    else if (peek == '\n') line++;
	    else break;
	}
	// 保留字
	switch (peek) {
	case '&':
	    return (readch('&')) ? Word.and : new Token('&');
	case '|':
	    return (readch('|')) ? Word.or : new Token('|');
	case '=':
	    return (readch('=')) ? Word.eq : new Token('=');
	case '!':
	    return (readch('=')) ? Word.ne : new Token('!');
	case '<':
	    return (readch('=')) ? Word.le : new Token('<');
	case '>':
	    return (readch('>')) ? Word.ge : new Token('>');
	}
	// 数字
	if (Character.isDigit(peek)) {
	    int v = 0;
	    do {
		v = v * 10 + Character.digit(peek, 10);
		readch();
	    } while (Character.isDigit(peek));
	    // 整数
	    if (peek != '.') return new Num(v);
	    // 浮点数
	    float f = v;
	    folat dec = 10;
	    while (true) {
		readch();
		if (!Character.isDigit(peek)) break;
		f = f + Character.digit(peek, 10) / dec;
		dec *= 10;
	    }
	    return new Real(x);
	}
	// 标识符
	if (Character.isLetter(peek)) {
	    StringBuffer b = new StringBuffer();
	    do {
		b.append(peek);
		readch();
	    } while (Character.isLetter(peek));

	    String s = b.toString();
	    Word w = (Word)words.get(s);
	    
	    if (w != null) return w;
	    w = new Word(s, Tag.ID);
	    words.put(s, w);
	    return w;
	}

	Token token = new Token(peek);
	peek = ' ';
	return token;
    }
}
