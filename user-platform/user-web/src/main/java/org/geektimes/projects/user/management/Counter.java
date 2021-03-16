package org.geektimes.projects.user.management;

public class Counter {
    private volatile int total = 0;
    private volatile int inc = 0;

    public int getTotal() {
        return total;
    }

    public synchronized void setTotal(int total) {
        this.total = total;
    }

    public int getInc() {
        return inc;
    }

    public synchronized void setInc(int inc) {
        this.inc = inc;
    }

    public Counter() {

    }

    public synchronized void inc() {
        total++;
        inc++;
    }

    public synchronized void clear() {
        inc = 0;
    }
}
