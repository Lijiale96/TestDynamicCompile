package com.bjsxt.test;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Demo01 {

	public static void main(String[] args) throws Exception {
		
		//ͨ��IO�����������ַ����洢��һ����ʱ�ļ���Hi.java����Ȼ����ö�̬���뷽��
		
		String str = "public class Hi{public static void main(String[] args) {System.out.println(\"����ʧ��\");} }";
		
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, null, null,"C:/myjava/HelloWorld.java");
		
		//"C:\\myjava\\HelloWorld.java"
		//C:\\Users\\A\\eclipse-workspace\\IO_study01\\ball1.png
      	System.out.println(result==0?"����ɹ�":"����ʧ��");
		
      	
      	//ͨ��Runtime��������
//		Runtime run =Runtime.getRuntime();
//		Process process = run.exec("java  -cp  c:/myjava   HelloWorld");
//       InputStream in =process.getInputStream();
//       BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//       String info="";
//       while ((info=reader.readLine())!=null) {
//		System.out.println(info);
//}
		try {
      	URL[] urls = new URL[] {new URL("file:/"+"C:/myjava/")};
      	URLClassLoader loader = new URLClassLoader(urls);
      	Class c = loader.loadClass("HelloWorld");
      	//���ü������main����
      	Method m =c.getMethod("main", String[].class);
      	m.invoke(null, (Object)new String[]{});
      	//���ڿɱ������JDK5֮����С������������ɣ�m.invoke��null��"aa","bb")���ͷ����˲���������ƥ�������
      	//��ˣ�����Ҫ���ϣ�Object��ת�ͣ�����������⡣
      	//public static void mmm(String[] a,String[] b)
      	//public static void main( String[] args)
      	
		}catch(Exception e) {
			e.printStackTrace();
		}
      	
	}

}
