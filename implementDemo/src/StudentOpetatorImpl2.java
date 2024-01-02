public class StudentOpetatorImpl2 implements StudentOperator{
    @Override
    public void printInfo() {
        System.out.println("全部信息，包含男女人数");
    }

    @Override
    public void printAverage() {
        System.out.println("去掉最高最低分的平均分");
    }
}
