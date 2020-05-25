package proxy.cglib;

import org.junit.Test;

public class TestCglib {
    @Test
    public void test(){
        TeacherDao teacherDao = new TeacherDao();
        CglibProxyFactory cglibProxyFactory = new CglibProxyFactory(teacherDao);
        teacherDao = (TeacherDao) cglibProxyFactory.getProxyInstance();
        teacherDao.teach();

    }
}
