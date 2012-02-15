    package com.banana.network;  
      
    import java.io.ByteArrayOutputStream;  
    import java.io.InputStream;  
    import java.net.HttpURLConnection;  
    import java.net.URL;  
      
    public class GetInfo  
    {  
        /** 
         * ��ȡ���� 
         * @param inputStream 
         * @return 
         * @throws Exception 
         */  
        public static byte[] readStream(InputStream inputStream) throws Exception  
        {  
            byte[] buffer=new byte[1024];  
            int len=-1;  
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();  
              
            while((len=inputStream.read(buffer))!=-1)  
            {  
                byteArrayOutputStream.write(buffer,0,len);  
            }  
              
            inputStream.close();  
            byteArrayOutputStream.close();  
            return byteArrayOutputStream.toByteArray();  
        }  
          
        /** 
         * ��ȡ����ͼƬ 
         * @throws Exception 
         */  
        public static byte[] testGetImage(String path) throws Exception  
        {  
            URL url=new URL(path);  
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();  
            conn.setConnectTimeout(6*1000);  //�������ӳ�ʱʱ��6s  
            conn.setRequestMethod("GET");  
      
            if(conn.getResponseCode()==200)  
            {  
                InputStream inputStream=conn.getInputStream();  
                return readStream(inputStream);  
            }  
            return null;  
        }  
          
        /** 
         * ��ȡ��ַ��html 
         * @throws Exception 
         */  
        public static byte[] testGetHtml() throws Exception  
        {  
        	String str = "nothing";
            String urlpath="http://www.haha.mx/good/history";  
            URL url=new URL(urlpath);  
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();  
            conn.setConnectTimeout(600*1000);  //�������ӳ�ʱʱ��6s  
      
            conn.setRequestMethod("GET");  
      
            if(conn.getResponseCode()!= -1)  
            {  
                InputStream inputStream=conn.getInputStream();  
                byte[] data=readStream(inputStream);  
                return data;  
            } 
            return str.getBytes();  
            
        }  
    }  