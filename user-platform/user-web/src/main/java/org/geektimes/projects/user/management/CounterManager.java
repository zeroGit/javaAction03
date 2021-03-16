package org.geektimes.projects.user.management;

public class CounterManager implements CounterManagerMBean {
    private Counter counter;

    public CounterManager(Counter counter) {
        this.counter = counter;
    }

    @Override
    public int getTotal() {
        return counter.getTotal();
    }

    @Override
    public void setTotal(int total) {
        counter.setTotal(total);
    }

    @Override
    public int getInc() {
        return counter.getInc();
    }

    @Override
    public void setInc(int inc) {
        counter.setInc(inc);
    }
}
