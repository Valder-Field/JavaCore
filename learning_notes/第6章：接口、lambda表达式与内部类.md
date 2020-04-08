本章内容

1）接口（interface）：主要用于描述类具有什么功能，而并不给出每个功能的具体实现。一个类可以实现（implement）一个或多个接口，并在需要接口的地方，随时使用实现了相应接口的对象。

2）lambda表达式：一种表示可以在将来某个时间点执行的代码块的简洁方法，可以用一种精巧而简洁的方式表示**使用回调或变量行为的代码**。

3）内部类（inner class）：内部类定义在另一个类的内部，其中的方法可以访问包含它们的外部类的域。主要用于设计具有相互协作关系的类集合。

4）代理（proxy）：一种实现任意接口的对象，是一种非常专业的构造工具，用来构建系统级的工具。

# 6.1 接口

6.1.1 接口概念

1）概念

Q：什么是接口？

A：如果类遵从某个特定接口，那么就履行这项服务。具体来说，类实现某个接口，就必须实现接口所定义的方法，遵从接口里方法的：方法名、参数列表、返回值。

2）Comparable接口

```java
// Java 5之前原型
public interface Comparable{
    int compareTo(Object o);
}

// Java 5后接口改为泛型类型
public interface Comparable<T>{
    int compareTo(T o);// parameter has type T
}
```

- 在调用`x.compareTo(y) `的时候，这个compareTo 方法**必须确实比较两个对象的内容**， 并返回一个整型数值。
  - 当 x 小于 y 时， 返回一个负数；
  - 当 x 等于 y 时， 返回 0; 
  - 否则返回一个正数。

3）接口的默认属性【核心内容】

- 接口中所有方法自动地属于`public`。在接口中声明方法时，不必提供关键字public，但在类实现接口时，必须把方法声明为`public`，否则，编译器会认为这个方法的访问属性是：包可见，即：类的默认访问属性，编译器报错，如下图：

  ![image-20200406171628452](第6章：接口、lambda表达式与内部类.assets/image-20200406171628452.png)

- 接口中不能有属性；接口不能实例化。

  > 可以将接口看成没有实例域的抽象类

4）API介绍

- 接口Comparable默认的compareTo方法返回的是一个**整型数值**
  ![image-20200406172132969](第6章：接口、lambda表达式与内部类.assets/image-20200406172132969.png)

- 实现Comparable接口的包装类

  ![image-20200406172112371](第6章：接口、lambda表达式与内部类.assets/image-20200406172112371.png)

- Arrays.sort()

  ![image-20200406172206771](第6章：接口、lambda表达式与内部类.assets/image-20200406172206771.png)

6.1.2 接口的特性

1）接口不能实例化，但可声明接口变量，接口变量必须引用实现了接口的类对象

```java
class Employee implements Comparable<Employee>{
    ...
}

Comparable<Employee> x = new Employee("zhangsan", 666);
```

2）instanceof

- 检查一个**对象是否属于某个特定的类**

- 检查一个**对象是否实现了某个特定的接口**

  ```java
  Employee[] staff = new Employee[3];
  		
  staff[0] = new Employee("Harry Hacker", 35000);
  staff[1] = new Employee("Carl Cracker", 75000);
  staff[2] = new Employee("Tony Tester", 38000);
  
  if(staff[0] instanceof Comparable) {
      System.out.println("true"); // true
  }
  ```

3）接口中可有：

- 方法：public

- 常量：public static final

  ```java
  // 常量可在实现接口的类中直接调用
  interface Moveable{
  	void move(double x, double y);
  }
  
  interface Powered extends Moveable{
      double SPEED_LIMIT = 95; // a public static final constant
      double milesPerGallon();
  }
  
  class A implements Powered{
  
      @Override
      public void move(double x, double y) {
      }
  
      @Override
      public double milesPerGallon() {
          return 0;
      }
  }
  
  System.out.println(new A().SPEED_LIMIT); // 95.0
  ```

4）接口可以被扩展，即：接口可以继承接口

6.1.3 接口与抽象类

Q：为什么不将Comparable接口设计成为抽象类？

A：Java中每个类只能扩展一个类，但可以实现多个接口。

假设Employee 类已经扩展了一个类， 例如Person, 它就不能再像下面这样扩展第二个类了

```java
class Employee extends Person, Comparable // error
```

但，可以实现多个接口

```java
class Employee extends Person implements Comparable // ok
```

6.1.4 静态方法

1）Java 8中，允许接口中增加静态方法。但这样违背了将接口作为抽象规范的初衷。

之前的做法，将静态方法放在伴随类中，如：在标准库中，有**成对出现的接口和实用工具类**，如：Collection/Collections、Path/Paths

![image-20200406180504150](第6章：接口、lambda表达式与内部类.assets/image-20200406180504150.png)

6.1.5 默认方法

可以为接口方法提供一个默认实现，必须用`default`修饰符西标记这样一个方法

```java
public interface Comparable<T>{
    // By default, all the elements are the same
    default int compareTo(T other){return 0;}
}
```

上述操作并没有太大用处，因为Comparable每个实现类都要覆盖这个方法，有用处的地方在于：

- Java Swing事件中，如：鼠标点击事件方法默认值
- 在Java 8中为某个接口添加了新方法，但此接口**所有实现类**中都需要实现此方法，费时费力，可使用默认方法解决此问题。

6.1.6 解决默认方法冲突

一个类实现2个接口或实现1个接口个1个类，有可能存在方法名命名冲突，Java中提供了两种解决方案。

1）接口冲突。如果一个超接口提供了一个默认方法，另一个接口提供了一个同名而且参数类型（不论是否是默认参数）相同的方法， **必须覆盖这个方法**来解决冲突。

```java
class Student implements Person, Named{
    public String getName(){
        return Person.super.getName(); // 使用Person中的方法
    }
}
```

2）超类优先。如果超类提供了一个**具体方法**，同名而且有相同参数类型的默认方法会被忽略。

```java
class Student extends Person implements Named{
    ...
}
```

# 6.2 接口示例

6.2.1 接口与回调

回调（callback）是一种常见的程序设计模式，可以指出某个特定事件发生时应该采取的动作。

6.2.2 Comparator接口

1）当自带的`java.lang.Comparable`接口无法满足新的排序需求时，可用外部比较器（`java.util.Comparator`）实现新的排序需求。

2）两个接口使用对比

使用Comparable接口前提：

- **类对象数组**需要排序，则**类**必须实现Comparable接口

使用Comparator接口：

- 新建一个比较器类，并实现Comparator接口。实例化一个比较器对象，用于排序

  ```java
  public class ComparatorTest {
  
  	public static void main(String[] args) {
  		// 外部比较器对象
  		Comparator<String> comp = new LengthComparator();
          // 单独比较
  		System.out.println(comp.compare("123", "3456"));
  		// 对象数组比较
  		String[] str = {"123,", "332432", "1"};
  		Arrays.sort(str, comp);
          // print
  		for (String string : str) {
  			System.out.print(string + " ");
  		}
  	}
  }
  
  class LengthComparator implements Comparator<String>{
  	@Override
  	public int compare(String o1, String o2) {
  		// TODO Auto-generated method stub
  		return o1.length() - o2.length();
  	}
  }
  ```

6.2.3 对象克隆

1）普通的为一个**包含对象引用的变量**建立副本时，直接进行引用的赋值，原变量和副本都是同一个对象的引用。任何一个变量改变都会影响另一个变量。

```java
Employee original = new Employe("John Public", 50000);
Employee copy = original;
copy.raiseSalary(10); // oops--also changed original
```

![image-20200408161721672](第6章：接口、lambda表达式与内部类.assets/image-20200408161721672.png)

如果希望copy是一个新对象，它的初始状态与original相同，但之后它们各自会有自己不同的状态，则可以使用clone方法

2）浅拷贝。clone方法是Object的一个protected方法，不能直接调用。由于所有自定义类都是Object的子类，可通过子类对象调用。子类对象调用clone方法的流程（Object实现clone的流程）

- Object对子类对象一无所知，所以只能逐个域地进行拷贝。对于基本数据类型属性，直接拷贝值，但**对于引用类型数据**，直接拷贝对象的引用，这样原对象和克隆的对应仍然会共享引用类型的属性。

  ![image-20200408162359640](第6章：接口、lambda表达式与内部类.assets/image-20200408162359640.png)

  ![image-20200408162417681](第6章：接口、lambda表达式与内部类.assets/image-20200408162417681.png)

由上述可知，Object对象的Clone方法，默认的是“浅拷贝”，即：基本数据类型拷贝值，引用类型拷贝引用，不建立新的引用类型对象。但“浅拷贝”也有一定的好处，可根据需求要不要实现“深拷贝”。浅拷贝的好处，共享安全。

![image-20200408162650025](第6章：接口、lambda表达式与内部类.assets/image-20200408162650025.png)

3）Cloneable接口。

- Cloneable接口是Java中提供的一组标记接口（tagging interface）之一。其内不包含任何方法，唯一的作用是：允许在类型查询中使用instanceof。

  非标记接口，如：Comparable等接口，通常是用于确保一个类实现一个或一组特定的方法。

- 无论是浅拷贝还是深拷贝**都必须实现Cloneable接口**，且将从Object继承过来的clone设置为：**public**

4）深拷贝

```java
class Employee implements Cloneable{ // 必须实现Cloneable接口
    ...
    public Employee clone() throws CloneNotSupportedException{
        // call Object.clone() 【使用Object.clone，拷贝基本数据类型】
        Employee cloned = (Employee)super.clone();
        
        // clone mutable fields【拷贝引用类型数据】
        cloned.hireDay = (Date)hireDay.clone();// hireDay属性Date类，其已经实现了Cloneable接口
        
        return cloned;
    }
}
```

# 6.3 lambda表达式

6.3.1 为什么引入lambda表达式

1）将一个代码块传递到某个对象，这个代码块会在将来某个时间调用。到目前为止，在Java中**不能直接传递代码段**，Java是一种面向对象语言，**所以必须构造一个对象，这个对象的类需要有一个方法能包含所需的代码段**。代码段示例：

```java
class LengthComparator implements Comparator<String>{
    public int compare(String first, String second){
        return first.length() - seconde.length();
    }
}
...
Arrays.sort(strings, new LengthComparator())//new LengthComparator()本质为传递一个代码段
```

为解决上述必须构造一个对象传入代码块的方式，Java引入了lambda表达式，以一种简洁的语法定义代码块。

6.3.2 lambda表达式的语法

**lambda表达式就是一个代码块，以及必须传入代码的变量规范**

1）为什么起这个名字？带**参数变量的表达式**就称为lambda表达式

2）lambda表达式形式

```java
(参数1，参数2) ->
{ // 表达式1行时，{}可省略
	表达式
}
```

特殊用法：

- 即使lambda表达式没有参数，仍然要提供空括号，就像无参数方法一样

  ```java
  () -> 
  {
      for(int i = 100; i >= 0; i--) 
         System.out.println(i);
  }
  ```

- 如果可以推导出一个lambda表达式的参数类型，则可以忽略其类型

  ```java
  // 因为此lambda表达式将赋值给一个字符串比较器，所以编译器可以推导出first和second必然是字符串
  Comparator<String> comp = (first, second) // same as (String first, String second)
      -> first.length() - second.length();
  ```

- 如果方法只有一个参数，且此参数类型可以推导得出，则**可以省略小括号**

  ```java
  ActionListener listener = event ->
      // Instead of (event) -> . . . or (ActionEvent event) -> . . .
  	System.out.println("The time is " + new Date()"); 
  ```

特别注意：

- 无需指定lambda表达式的返回类型，返回类型总是会由上下文推导得出，如：

```java
(String first, String second) -> first.length() - second.length()
```

- 如果一个 lambda 表达式只在某些分支返回一个值， 而在另外一些分支不返回值，这是不合法的。

```java
(int x)-> { if(x >= 0) return 1; } // 不合法
```

6.3.3 函数式接口



6.3.4 方法引用

6.3.5 构造器引用

6.3.6 变量作用域

6.3.7 处理lambda表达式

6.3.8 再谈Comparator

# 6.4 内部类

6.4.1 使用内部类访问对象状态

6.4.2 内部类的特殊语法规则

6.4.3 内部类是否有用、必要和安全

6.4.4 局部内部类

6.4.5 由外部方法访问变量

6.4.6 匿名内部类

6.4.7 静态内部类

# 6.5 代理

6.5.1 何时使用代理

6.5.2 创建代理对象

6.5.3 代理类的特性



