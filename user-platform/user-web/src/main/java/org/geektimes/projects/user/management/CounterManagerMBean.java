package org.geektimes.projects.user.management;

public interface CounterManagerMBean {

    int getTotal();

    void setTotal(int total);

    int getInc();

    void setInc(int inc);
}
