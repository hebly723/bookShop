package test;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import model.Book;
import tool.HttpRequest;
import model.User;
public class Test {
	public static void main(String args[]) throws UnsupportedEncodingException
	{
		User user = new User();
		user.setUserName("我的天空ewqe12ds");
		System.out.println(user.getUserName());
		user.setPassword("haha");
		System.out.println(user.getPassword());
		testRegister(user);
		String s = "浣犲ソ"; //这是"你好"的gbk编码的字符串
		String ss1 = new String(s.getBytes("gbk"), "UTF-8");
		String ss2 = new String(s.getBytes("utf-8"), "gbk");
		System.out.println(ss1 + "hahahahahahahahaha");
		System.out.println(ss2);
//		code();
//		Book book = new Book();
//		book.setBookId("111");
//		book.setBookName("用");
//		book.setAmount(120);
//		Book.addBook(book);
//		Book.buyBook(book);
//		testBuy(book);
//		efbfbdefbfbdc6ac
//		User.addUser(user);
//		Book book = new Book();
//		book.setAmount(2);
//		book.setBookName("算法分析");
//		book.setBookId("550");
//		System.out.println(Book.addBook(book));
//		System.out.println(User.addUser(user));
//		System.out.println(testValidate(user));
//		testJudge("EB6967ABC7EF3C7DF4342D2AF1122640");
//		testRegister(user);
//		String t = "这是一个字符串aaa111";
//		String gbk= new String(t.getBytes( "GBK"));
//		System.out.println(gbk);
//		String unicode = new String(gbk.getBytes(),"GBK");
//		System.out.println(unicode);
//		String utf8= new String(unicode.getBytes("UTF-8"));
//		System.out.println(utf8); 
	}
	
	public static String testValidate(User user)
	{
		
		Map mail = new HashMap();
		
		mail.put("username", user.getUserName());
		mail.put("password", user.getPassword());
		
		JSONObject json = JSONObject.fromObject(mail);
		
		String resultMessage = HttpRequest.sendPost("http://localhost:8080/bookShop/userValidate",
				json.toString());
		
		System.out.println(resultMessage);
		
		System.out.println(json);
		
		return resultMessage;
		
	}
	
	public static void testRegister(User user)
	{
		Map mail = new HashMap();
		
		mail.put("username", user.getUserName());
		mail.put("password", user.getPassword());
		
		JSONObject json = JSONObject.fromObject(mail);
		
		System.out.println(HttpRequest.sendPost("http://localhost:8080/bookShop/userRegister",
				json.toString()));
		
		System.out.println(json);
	}
	
	public static void testJudge( String id )
	{
		System.out.println(HttpRequest.sendGet("http://localhost:8080/bookShop/judgeLogin", id));
	}
	
	public static String testBuy( Book book )
	{
		Map mail = new HashMap();
		
		mail.put("bookname", book.getBookName());
		mail.put("bookId", book.getBookId());
		mail.put("amount", book.getAmount());
		
		JSONObject json = JSONObject.fromObject(mail);
		
		String resultMessage = HttpRequest.sendPost("http://localhost:8080/bookShop/buyBook",
				json.toString());
		
		System.out.println(resultMessage);
		
		System.out.println(json);
		
		return resultMessage;
	}
	public static void code() throws UnsupportedEncodingException {
        byte[] b1 = "你好".getBytes("utf-8");
        byte[] b2 = new String(b1,0,b1.length,"UTF-8").getBytes("GBK");
        System.out.println(new String(b1,0,b1.length));
        System.out.println(new String(b2,0,b2.length));
    }

}
