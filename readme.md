在写一个字符串列表或是数组或是一个类似Json的字符串名值对时，需要经常在引号和逗号或是冒号之前切换输入，感觉很烦，因此写了这么一个工具。


一个 IntelliJ 的插件，用于简化字面值的输入。
An IntelliJ plugin provide an easy way to input literal.


实现细节（如果你发现转换不成功，那么请看一下是不是和下面的字符串分隔有冲突）：
Implement detail:

name=Tom,friend=Jerry `ctrl+comma` -> "name": "Tom", "friend": "Jerry"

split by `","`, then split by `"\\s?=\\s?"`.


name=Tom,friend=Jerry <- `ctrl+shift+comma`  "name": "Tom", "friend": "Jerry" 

split by `","`, then split by `"\\s?:\\s?"`


make the world a better place `ctrl+quote`  -> "make", "the", "world", "a", "better", "place"

split by `"\\s+"`

make the world a better place <- `ctrl+shift+quote`  "make", "the", "world", "a", "better", "place"

split by `","`