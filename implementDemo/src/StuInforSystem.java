/*
请设计一个班级学生的信息管理模块:学生的数据有:姓名、性别、成绩
功能1∶要求打印出全班学生的信息;功能2:要求打印出全班学生的平均成绩。
注意!以上功能的业务实现是有多套方案的，比如:
第1套方案:能打印出班级全部学生的信息;能打印班级全部学生的平均分。
第2套方案:能打印出班级全部学生的信息（包含男女人数);能打印班级全部学生的平均分(要求是去掉最高分、最低分)
要求:系统可以支持灵活的切换这些实现方案。
* */

import java.util.ArrayList;

public class StuInforSystem {
    private ArrayList<Student> students = new ArrayList<>();
    StudentOperator studentOperator = new StudentOpetatorImpl2();

    public StuInforSystem(){
        students.add(new Student("A","男",99));
        students.add(new Student("B","女",97));
        students.add(new Student("C","男",80));
        students.add(new Student("D","女",90));
    }

    public void printInfo(){
        studentOperator.printInfo();

    }

    public void printAverage(){
        studentOperator.printAverage();
    }

}
