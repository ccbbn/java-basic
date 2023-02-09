package chap11.ex03;

public class Sysinfo {
    public static void main(String[] args) {

        System.out.println(System.getProperty("os.name"));

        for(Object objKey : System.getProperties().keySet()) {
            String key = (String) objKey;
            String property = System.getProperty(key);
            System.out.printf("%-40s: %s\n",key, property);

        }

    }
}
