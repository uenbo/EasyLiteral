在写一个字符串列表或是数组或是一个类似Json的字符串名值对时，需要经常在引号和逗号或是冒号之前切换输入，感觉很烦，因此写了这么一个工具。


一个 IntelliJ 的插件，用于简化字面值的输入。

An IntelliJ plugin provide an easy way to input literal.


## Usage

### convert selected

 **ctrl+comma**

`make the world a better place`  -> `"make", "the", "world", "a", "better", "place"`

split by `"\\s+"`

**ctrl+shift+comma**

`make the world a better place` <-  `"make", "the", "world", "a", "better", "place"`

split by `","`

**ctrl+quote**

`name=Tom,friend=Jerry` ->  `"name": "Tom", "friend": "Jerry"`


split by `","`, then split by `"\\s?=\\s?"`.

**ctrl+shift+quote**


`name=Tom,friend=Jerry` <- `"name": "Tom", "friend": "Jerry"`

split by `","`, then split by `"\\s?:\\s?"`

If you do not want quote the value, you can add a "+" before it: <br/>
<pre>age=+20  ->  "age": 20</pre>

### convert without select

If you do not want select the text you want to convert, just add a back quote symbol before you input: <br/>
<pre>`what a wonderful day</pre>
--->
<pre>"what", "a", "wonderful", "day"</pre>