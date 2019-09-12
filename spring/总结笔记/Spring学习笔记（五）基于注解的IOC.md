# Spring学习笔记（五）基于注解的IOC

## 五、基于注解的IOC实例

基于xml实例，代码重复太多，就不贴出来了，主要是对于注解的应用，建议也手动敲一遍代码，对记忆和理解的加深有帮助。

1. Spring 中的新注解：
	
	- @Component
		- 作用：用于把当前类对象存入spring容器中
		- 属性：value(用于指定bean的id，当不写时，默认值是当前类名，且首字母改小写)
		- 下面这三个注解作用和属性与Component是一样的，只不过是spring框架提供的明确三层使用的注解，使得三层对象更加清晰。
	- @Controller：一般用于表现层
	- @Service：一般用于业务层
	- @Repository：一般用于持久层
	- @Autowired
		- 作用：自动按照类型注入，只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功。
		- 注意：如果ioc容器中没有任何bean的类型和要注入的变量类型匹配，则报错；如果ioc容器中有多个类型匹配时，先找变量类型，再找id名，如果没有则报错，有则成功注入。	
	- @Qualifier:
		- 作用：在按照类型注入的基础之上再按照名称注入，它再给类成员注入时不能单独使用，但是在给方法参数注入时可以。
		- 属性：value：用于指定注入bean的id	
	- @Resource：
		- 作用：直接按照bean的id注入，可以独立使用
		- 属性：name：用于指定bean的id。


	以上三个注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现，另外集合类型只能通过XML来实现。
	
	- @Value：
		- 作用：用于注入基本类型和String类型的数据
		- 属性：value：用于指定数据的值，它可以使用spring中SpEL(也就是spring的el表达式)，SpEL的写法：${表达式}
	- @Scope:
		- 作用：用于指定bean的作用范围
		- 属性：value：指定范围的取值。常用取值：singleton prototype
	- @PreDestroy:
		- 作用：用于指定销毁方法
	- @PostConstruct：
		- 作用：用于指定初始化方法
    - @Configuration
        - 作用：指定当前类是一个配置类
        - 细节：当配置类作为 AnnotationConfigurationApplicationContext 对象创建的参数时，该注解可以不写
    - @ComponentScan
        - 作用：用于通过注解指定 Spring 在创建容器时要扫描的包
        - 属性：

            value : 它和 basepackages 的作用是一样的，都是用于指定创建容器时要扫描的包

            使用此注解就等同于在 xml 中配置了：

            <context:component-scan base-package="com.greyson"></context:component-scan>

    - @Bean
        - 作用：用于把当前方法的返回值作为 bean 对象放入 Spring 的IOC容器中
        - 属性：

            name : 用于指定 bean 的 id，当不写时，默认值为当前方法的名称

        - 细节：

            当我们使用注解配置方法时，如果方法有参数，Spring 框架会去容器中查找有没有可用的 bean 对象，

            查找的方式和 Autowired 注解的作用是一样的

    - @Import
        - 作用：用于导入其他的配置类
        - 属性：

            value : 用于指定其他配置类的字节码

            当我们使用 Import 的注解之后，有 Import 注解的类就是父配置类，而导入的都是子配置类

    - @Properties
        - 作用：用于指定 properties 文件的位置
        - 属性：

            value : 指定文件的名称和路径

            关键字：classpath , 表示类路径下
2. 代码文件：Annotation_iocDemo

# [Spring学习笔记（六）Spring整合Junit](./Spring学习笔记（六）Spring整合Junit.md)