package ansi;

/**
 *
 * @author Ansi Abdulmalek
 */
public class Student
{
    private int id;
    private String name;
    private int age;
    private int phone_number;
    private String address;

    public Student(int id, String name, int age, int phone_number, String address)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone_number = phone_number;
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getPhone_number()
    {
        return phone_number;
    }

    public void setPhone_number(int phone_number)
    {
        this.phone_number = phone_number;
    }
    
}
