
1.String的方法实现利用了正则表达式
 String.matches(String regex)  //验证字符串是否匹配模式
 String.repalaceAll(regex, 被替换的子串);   //将匹配模式的子串替换
 
 
 String.matches() 的实现
 	//String.matches()
    public boolean matches(String regex) {
        return Pattern.matches(regex, this);
    }
 
 	//Pattern.matches()
    public static boolean matches(String regex, CharSequence input) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        return m.matches();
     }
 
 
 2.java.util.regex 两个类
 Pattern 编译后的模式						//静态方法 Pattern.compile(regex)
 Matcher 模式与指定字符串匹配后的产生的结果	//方法 p.matcher();
 
 3.转义字符
 \cx
 匹配由 x 指明的控制字符。例如， \cM 匹配一个 Control-M 或回车符。x 的值必须为 A-Z 或 a-z 之一。否则，将 c 视为一个原义的 'c' 字符。
 
 \xn	
匹配 n，其中 n 为十六进制转义值。十六进制转义值必须为确定的两个数字长。例如，'\x41' 匹配 "A"。'\x041' 则等价于 '\x04' & "1"。正则表达式中可以使用 ASCII 编码。

\un	
匹配 n，其中 n 是一个用四个十六进制数字表示的 Unicode 字符。例如， \u00A9 匹配版权符号 (?)。

\num	
匹配 num，其中 num 是一个正整数。对所获取的匹配的引用。例如，'(.)\1' 匹配两个连续的相同字符。



4.matches() find()之间相互影响

 matches() 匹配整个字符串
 find（）    匹配子串    // reset() 恢复到最初始的状态；  start() end() 匹配的情况下才有开始结束 
 lookingAt()从开始位置匹配
 
 
 5.替换
 
 m.replaceAll()	 替换符合模式的子串
 m.appendReplacement()	按规则替换符合模式的子串
 
 6.分组
 m.group()	//符合模式中所有组的子串
 m.group(n)	//符合模式中分组n的子串