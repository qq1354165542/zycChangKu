package entity;

/**
 * Created by 李克顺 on 2019/3/11.
 * 用户类
 */
public class User {
    private String id;                  //用户id
    private String passWord;            //登录密码
    private String name;                //用户名
    private String sex;                 //性别
    private int age;                    //姓名
    private String phone;               //手机号

    /**
     * 无参构造
     */
    public User(){}

    public User(String id, String passWord, String name, String sex, int age, String phone) {
        this.id = id;
        this.passWord = passWord;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
