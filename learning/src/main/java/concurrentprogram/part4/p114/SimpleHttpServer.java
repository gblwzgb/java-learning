package concurrentprogram.part4.p114;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by l_x_l on 2018-01-22.
 */
public class SimpleHttpServer {
    // 处理HttpRequest的线程池
    static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<>(1);
    // SimpleHttpServer的根路径
    static String basePath;
    static ServerSocket serverSocket;
    // 服务监听端口
    static int port = 8080;

    public static void setPort(int port) {
        if (port > 0) {
            SimpleHttpServer.port = port;
        }
    }

    public static void setBasePath(String basePath) {
        if (basePath != null && new File(basePath).exists() && new File(basePath).isDirectory()) {
            SimpleHttpServer.basePath = basePath;
        }
    }

    // 启动SimpleHttpServer
    public static void start() throws Exception {
        serverSocket = new ServerSocket(port);
        Socket socket = null;
        while ((socket = serverSocket.accept()) != null) {
            // 接受一个客户端Socket，生成一个HttpRequestHandler，放入线程池执行
            threadPool.execute(new HttpRequestHandler(socket));
        }
        serverSocket.close();
    }


    static class HttpRequestHandler implements Runnable {
        private Socket socket;

        public HttpRequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String line = null;
            BufferedReader br = null;
            BufferedReader reader = null;
            PrintWriter out = null;
            InputStream in = null;  // 定义在try外面，这样finally可以关闭
            try {
                // InputStreamReader是将字节流转化为字符流的桥梁
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();
                // 由相对路径计算出绝对路径
                String filePath = basePath + header.split(" ")[1];
                out = new PrintWriter(socket.getOutputStream());
                // 如果请求资源的后缀为jpg或ico，则读取资源并输出
                if (filePath.endsWith("jpg") || filePath.endsWith("ico")) {
                    in = new FileInputStream(filePath);
                    // 内部是一个可以自动扩容的byte[]数组
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int i = 0;
                    while ((i = in.read()) != -1) {
                        baos.write(i);
                    }
                    byte[] array = baos.toByteArray();
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-Type: image/jpeg");
                    out.println("Content-Length: " + array.length);
                    out.println();
                    /**
                     * 书上没有这句，所以图片显示不出来
                     * 先把内容输出到网页上，这样网页才知道response是200，且是图片
                     */
                    out.flush();
                    // 不执行out.flush()的话，write会先写到网页上，这时就出错了(有的流不需要flush可以直接输出？)
                    socket.getOutputStream().write(array, 0, array.length);
                } else {
                    // 使用BufferedReader字符流一行一行读，需要使用InputStreamReader把字节流转化为字符流
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-Type: text/html; charset=UTF-8");
                    out.println();
                    while ((line = br.readLine()) != null) {
                        out.println(line);
                    }
                }
                out.flush();  // 不flush是不会输出的
            } catch (Exception e) {
                out.println("Http/1.1 500");
                out.println("");
                out.flush();
            } finally {
                close(br, in, reader, out, socket);
            }
        }
    }

    // 关闭流或Socket
    private static void close(Closeable... closeables) {
        if (closeables != null) {
            for (Closeable closeable : closeables) {
                try {
                    closeable.close();
                } catch (Exception e) {
                    //
                }
            }
        }
    }
}
