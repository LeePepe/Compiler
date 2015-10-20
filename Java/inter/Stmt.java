package inter;

public class Stmt extends Node {
    public Stmt() { }
    public static Stmt Null = new Stmt();
    public void gen(int b, int a) { } // 参数是语句开始处的标号和语句的下一条指令的标号
    int after = 0; // 保存语句下一条指令的标号
    public static Stmt Enclosing = Stmt.Null; // break 语句
}
