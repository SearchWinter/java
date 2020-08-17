package demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Description jsoup各个方法的示例
 * @Date 2020/7/27  13:48
 */

public class TestDemo {
/** 从一个url加载一个document*/

    @Test
    public void demo1() throws IOException {
        //先获得一个连接，再利用get()得到document对象
        Document document = Jsoup.connect("https://www.jianshu.com/p/fd5caaaa950d").get();
        String title = document.title();
        System.out.println(title);
        //带有href属性的a元素
        Elements links = document.select("a[href]");
        //扩展名为.png的图片
        Elements pngs = document.select("img[src$=.png]");
        //在h3元素之后的a元素
        Elements resultLinks = document.select("h1>a");
        for (Element elements:resultLinks){
            System.out.println(elements);
        }
    }
/** 从元素中抽取属性，文本和HTML*/

    @Test
    public void demo2(){
        String html="<p>An <a href='http://example.com/' id='1'><b>example</b></a> link.</p>";
        //解析HTML字符串返回一个document实现
        Document document = Jsoup.parse(html);

        //查找第一个a元素
        Element link = document.select("a").first();
//        System.out.println(link);
        //取得链接地址
        String href = link.attr("href");
//        System.out.println(href);
        //取得链接地址中的文本
        String text1 = link.text();
//        System.out.println(text1);

        //
        String outerHtml = link.outerHtml();
//        System.out.println(outerHtml);
        //获取元素内的HTML内容
        String html1 = link.html();
//        System.out.println(html1);

        //Element.text() 取得字符串中的文本
        String text = document.body().text();
//        System.out.println(text);

        //得到元素的id值
        System.out.println(link.id());
    }
/** 获得绝对路径*/

    @Test
    public void demo3() throws IOException{
        Document doc = Jsoup.connect("http://www.open-open.com").get();
        Element link = doc.select("a").first();
        String relhref = link.attr("href");
        //abs:  前缀取得绝对路径
        String abshref = link.attr("abs:href");
        System.out.println(relhref);
        System.out.println(abshref);
    }

/** 伪选择器selectors*/
    @Test
    public void selectorDemo() throws IOException{
        Document document = Jsoup.connect("https://www.baidu.com/s?wd=jsoup&rsv_spt=1&rsv_iqid=0xd2b775d30005dc69&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&" +
                "tn=baiduhome_pg&rsv_enter=1&rsv_dl=tb&rsv_sug2=0&rsv_btype=i&inputT=1719&rsv_sug4=5081").get();
        // :lt(n)  查找哪些元素的同级索引值小于n
        Elements select = document.select("td:lt(5)");
        System.out.println(select);

        // :has(selector)  查找匹配器选择器包含元素的元素
    }

/** 字符串方法*/

    @Test
    public void StrDemo(){
        String string="qwer123456";
        //字符串index从0开始
        System.out.println(string.lastIndexOf("r"));
        System.out.println(string.length());
        //substring(3,5)方法，从3开始取(包括)，取到5(不包括)
        System.out.println(string.substring(3,string.length()));
    }

    @Test
    public void encodeDemo() throws UnsupportedEncodingException {
        String name="测试 检测";
        String encode = URLEncoder.encode(name, "UTF-8");
        System.out.println(encode);
    }
}
