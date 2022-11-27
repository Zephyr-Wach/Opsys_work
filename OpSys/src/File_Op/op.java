package File_Op;

import java.io.*;

public class op {
    public static  void create() throws IOException {
        String n_dir = "D:\\test";  // 指定目录
        File n = new File(n_dir);  // 创建一个文件操作对象
        if (!n.exists()) {
            n.mkdir();   // 【mkdir】只能创建一个文件夹
        }

        String m_dir = "D:\\test\\csj";  // 指定目录
        File m = new File(m_dir);  // 创建一个文件操作对象
        if (!m.exists()) {
            m.mkdirs();    // 【mkdirs】一次性创建多个文件夹
        }

        // 创建一个txt文件
        String m_file = "D:\\test\\csj\\nn.txt";  // 指定目录
        File f = new File(m_file);  // 创建一个文件操作对象
        f.createNewFile();
    }
    public static void print() {
        // ================ 【获取文件的信息】
        System.out.println("===== 获取文件信息 =====");

        String p_file = "D:\\test\\csj\\nn.txt";  // 指定目录
        File p = new File(p_file);  // 创建一个文件操作对象

        if (p.exists())  // 判断文件和文件夹是否存在
        {

            if (p.isFile())  // 是否是一个文件
            {
                System.out.println("文件名:" + p.getName());
                System.out.println("文件绝对路径:" + p.getAbsolutePath());
                System.out.println("文件相对路径:" + p.getPath());
                System.out.println("文件大小（字节数）:" + p.length());

            }
            if (p.isDirectory())  // 是否是文件夹
            {
                System.out.println("这个文件夹存在！");
            }

        }
    }

    public static void rename() {
        // ================ 【文件重命名】

        String r_file = "D:\\test\\csj\\nn.txt";  // 指定目录
        File r = new File(r_file);  // 创建一个文件操作对象

        if (r.exists()) {

            if (r.isFile()) {
                r.renameTo(new File("D:\\test\\csj\\csj.txt"));    // 重命名指定文件（注意加路径）
                System.out.println(r_file + "文件重命名成功！");
            }
        }
    }

    public static void delete() {

        // ================ 【删除指定文件】
        String d_file = "D:\\test\\csj\\csj.txt";  // 指定目录
        File d = new File(d_file);  // 创建一个文件操作对象

        if (d.exists()) {

            if (d.isFile()) {
                d.delete();	// 删除指定文件
                System.out.println(d_file + "文件删除成功！");
            }
        }
    }

    public static void read() {
        // ================ 【读取文件内容】

        try {
            String uu = "D:\\test\\csj\\csj.txt";
            FileInputStream read_file = new FileInputStream(uu);  // 创建写入对象-【内容】
            int len = read_file.available();  // 读取文件的字节数
            System.out.println("文件【" + uu + "】的字节数是" + len);

            int m_number;
            // 读取每一个字节的键值编码， 一个中文汉字两个字节。
            while ((m_number = read_file.read()) != -1) {

                System.out.print(m_number + "_");
            }

            // ---------- 读取文本文件内容


            System.out.println("----- 读取文本文件内容 -----");
            FileReader f_Reader = new FileReader(uu);
            char[] chars = new char[len];
            f_Reader.read(chars, 0, len); // 读取全部文本文件内容
            for (char aaa : chars) {
                System.out.print(aaa);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void write(){
        // ================ 【向文本文件写入内容】

        try
        {
            String w="D:\\test\\csj\\csj.txt";
            //FileOutputStream w_file = new FileOutputStream(w);  // 写入内容 - 【覆盖内容】
            FileOutputStream w_file = new FileOutputStream(w,true);  // 写入内容 - 【添加内容】
            String m_write="我是中国人！";
            byte[] mess=m_write.getBytes();
            w_file.write(mess,0,mess.length);

        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        create();
        print();
        rename();
        delete();
        read();
        write();
    }
}