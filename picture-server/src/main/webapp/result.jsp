<%	String s = request.getParameter("result");
	if(s!=null)
	{		
		//s=java.net.URLDecoder.decode(s,"UTF-8");
		//s=new String(s.getBytes("ISO-8859-1"));
		out.print(s);
	} else {
		out.print("{result:'fail',message:'没有返回数据'}");
	}

%>