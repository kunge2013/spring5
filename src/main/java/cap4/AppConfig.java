package cap4;

import cap3.bean.Company;
import cap3.bean.Person;
import cap3.edit.type.CustomerDate;
import cap3.validator.PersonValidator;
import cap3.wrapper.BeanWrapperUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.convert.ConversionService;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.*;

@Configuration
@ImportResource("classpath*:*4.xml")
public class AppConfig {
    public static void 可执行的语句(){
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.substring(0,5)");
        String message = (String) exp.getValue();
        System.out.println(message);
    }
    public static void 直接量表达式(){
        // 创建一个ExpressionParser对象，用于解析表达式
        ExpressionParser parser = new SpelExpressionParser();
        // 使用直接量表达式
        Expression exp = parser.parseExpression("'VipMao'");
        System.out.println(exp.getValue(String.class));
        exp = parser.parseExpression("6.9");
        System.out.println(exp.getValue(Double.class));
    }
    public static void 在表达式中创建数组(){
        // 创建一个ExpressionParser对象，用于解析表达式
        ExpressionParser parser = new SpelExpressionParser();
        //------------使用SpEL创建数组-----------
        Expression exp=parser.parseExpression("new String[]{'Struts2','Hibernate','Spring'}");
        System.out.println(exp.getValue(String.class));
        // 创建二维数组
        exp = parser.parseExpression(
                "new int[2][4]");
        System.out.println(exp.getValue(int.class));;
    }
    public static void 在表达式中创建List集合(){
        // 创建一个ExpressionParser对象，用于解析表达式
        ExpressionParser parser = new SpelExpressionParser();
        //------------使用SpEL创建数组-----------
        Expression exp=parser.parseExpression("{'java','c语言','PHP'}");
        System.out.println(exp.getValue(String.class));
        // 创建“二维”List集合
        exp = parser.parseExpression(
                "{{'孙悟空' , '哪吒'}, {'刘备' , '诸葛亮'}}");
        System.out.println(exp.getValue());

    }

    public static void SpEL中访问List_Map等元素集合(){
        // 创建一个ExpressionParser对象，用于解析表达式
        ExpressionParser parser = new SpelExpressionParser();
        //------------使用SpEL创建数组-----------
        //------------使用SpEL访问List集合、Map集合的元素-----------
        List<String>list=new ArrayList<String>();
        list.add("java");
        list.add("PHP");
        Map<String,Double> map=new HashMap<>();
        map.put("math", 78.8);
        map.put("chinese", 98.6);
        map.put("english", 92.2);
        // 创建一个EvaluationContext对象，作为SpEL解析变量的上下文
        EvaluationContext ctx = new StandardEvaluationContext();
        // 设置两个变量
        ctx.setVariable("list", list);
        ctx.setVariable("myMap", map);
        //修改并访问集合
        parser.parseExpression("#list[0]").setValue(ctx, "JavaEE");
        parser.parseExpression("#myMap['math']").setValue(ctx, 99.9);
        System.out.println("List集合中第一个元素为："+parser.parseExpression("#list[0]").getValue(ctx));
        System.out.println("map中修改后的value为："+parser.parseExpression("#myMap['math']").getValue(ctx));

    }

    public static void 调用方法(){
        // 创建一个ExpressionParser对象，用于解析表达式
        ExpressionParser parser = new SpelExpressionParser();
        //------------使用SpEL调用方法-----------
        // 调用String对象的substring()方法
        System.out.println(parser.parseExpression("'VipMao'.substring(0,3)").getValue());
        List<String>list=new ArrayList<String>();
        list.add("java");
        list.add("PHP");
        // 创建一个EvaluationContext对象，作为SpEL解析变量的上下文
        EvaluationContext ctx = new StandardEvaluationContext();
        // 设置两个变量
        ctx.setVariable("list", list);
        System.out.println(parser.parseExpression("#list.subList(0,2)").getValue(ctx));
    }

    public static void 算术_比较_赋值三元运算符(){
        //------------在SpEL中使用运算符-----------
        // 创建一个ExpressionParser对象，用于解析表达式
        ExpressionParser parser = new SpelExpressionParser();
        List<String>list=new ArrayList<String>();
        list.add("java");
        list.add("PHP");
        // 创建一个EvaluationContext对象，作为SpEL解析变量的上下文
        EvaluationContext ctx = new StandardEvaluationContext();
        // 设置两个变量
        ctx.setVariable("list", list);
        parser.parseExpression("#list[0]='JavaEE'").getValue(ctx);
        System.out.println(parser.parseExpression("#list").getValue(ctx));
        //使用三元运算符
        System.out.println(parser.parseExpression("#list.size()>3?'mylist长度大于3':'mylist长度不大于3'").getValue(ctx));

    }

    public static void 类型运算符(){
        ExpressionParser parser = new SpelExpressionParser();
        //------------在SpEL中使用类型运算符-----------
        //调用Math的静态方法
        System.out.println(parser.parseExpression("T(java.lang.Math).random()").getValue());
        //调用Math的静态方法
        System.out.println(parser.parseExpression("T(System).getProperty('os.name')").getValue());
    }
    public static void 调用构造器(){
        // 创建一个ExpressionParser对象，用于解析表达式
        ExpressionParser parser = new SpelExpressionParser();
        //------------在SpEL中调用构造器-----------
        System.out.println(parser.parseExpression("new String('HelloWorld').substring(2, 4)").getValue());
        System.out.println(parser.parseExpression("new javax.swing.JFrame('测试').setVisible('true')").getValue());
    }
    public static void 安全导航操作(){
        // 创建一个ExpressionParser对象，用于解析表达式
        ExpressionParser parser = new SpelExpressionParser();
        //------------在SpEL中使用安全导航操作-----------
        // 使用安全操作，将输出null
//        System.out.println("---"+parser.parseExpression("#foo?.bar").getValue());
        //不使用安全操作，将引发NullPointerException异常
//        System.out.println(parser.parseExpression("#foo.bar").getValue());
    }

    public static void 集合的选择(){
        // 创建一个ExpressionParser对象，用于解析表达式
        ExpressionParser parser = new SpelExpressionParser();
        List<String>list=new ArrayList<String>();
        list.add("java");
        list.add("PHP");
        list.add("JavaScript");
        Map<String,Double>map=new HashMap<String,Double>();
        map.put("math", 92.8);
        map.put("chinese", 98.6);
        map.put("english", 92.2);
        // 创建一个EvaluationContext对象，作为SpEL解析变量的上下文
        EvaluationContext ctx = new StandardEvaluationContext();
        // 设置两个变量
        ctx.setVariable("list", list);
        ctx.setVariable("myMap", map);
        //长度大于7的list集合元素将被筛选出来
        Expression expr=parser.parseExpression("#list.?[length()>7]");
        System.out.println("符合条件的List元素是："+expr.getValue(ctx));
        //key的长度小于5且value>90的map元素将被筛选出来
        expr=parser.parseExpression("#myMap.?[key.length()<5&&value>90]");
        System.out.println("符合条件的Map值为:"+expr.getValue(ctx));
    }

    public static void 集合的投影(){
        // 创建一个ExpressionParser对象，用于解析表达式
        ExpressionParser parser = new SpelExpressionParser();
        List<String>list=new ArrayList<String>();
        list.add("java");
        list.add("PHP");
        list.add("JavaScript");
        // 创建一个EvaluationContext对象，作为SpEL解析变量的上下文
        EvaluationContext ctx = new StandardEvaluationContext();
        // 设置变量
        ctx.setVariable("list", list);
        //------------在SpEL中对集合进行投影-----------
        //将每个集合元素进行截取，组成新的集合
        Expression expr=parser.parseExpression("#list.![substring(1,3)]");
        System.out.println("投影后的新集合为："+expr.getValue(ctx));
        List<Person>list2=new ArrayList<Person>();
        list2.add(new Person("VipMao",130));
        list2.add(new Person("ZhuLin",105));
        ctx.setVariable("mylist2", list2);
        expr=parser.parseExpression("#mylist2");
        System.out.println("投影前的集合为："+expr.getValue(ctx));
        //投影条件是 只要name属性
        expr=parser.parseExpression("#mylist2.![name]");
        System.out.println("投影后的新集合为"+expr.getValue(ctx));
    }

    public static void 表达式模板(){
        // 创建一个ExpressionParser对象，用于解析表达式
        ExpressionParser parser = new SpelExpressionParser();
        //------------在SpEL中使用表达式模板-----------
        Person p1 = new Person( "孙悟空" , 120);
        Person p2 = new Person( "猪八戒" , 220);
        Expression expr3 = parser.parseExpression("我的名字是#{name}" + ",年龄是#{age}", new TemplateParserContext());
        // 将使用p1对象name、height填充上面表达式模板中的#{}
        System.out.println(expr3.getValue(p1));
        // 将使用p2对象name、height填充上面表达式模板中的#{}
        System.out.println(expr3.getValue(p2));
    }
    public static void main(String[] args) {
        //--------------------------------------------可执行的语句---------------------------------
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        表达式模板();
    }
}
